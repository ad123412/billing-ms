package com.digital.api.controller;


import com.digital.api.model.BillFormatRef;
import com.digital.api.model.BillPresentationMediaRef;
import com.digital.api.model.BillStructure;
import com.digital.api.service.BillStructureService;
import com.digital.api.service.BillStructureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BillStructureController {

    @Autowired
    private BillStructureServiceImpl billStructureService;

    @GetMapping(value = {"/account/billStructure/{id}"})
    public Flux<BillStructure> getBillStructureDetails(@PathVariable(value = "id") String billStructureId){

        return Flux.just(billStructureService.getBillStructureById(billStructureId))
            .filter(billStructureOptional -> billStructureOptional.isPresent())
            .map(billStructureOptional -> billStructureOptional.get())
            .map(billStructure -> {
                billStructure.setFormat(
                        billStructureService.getBillFormatById(billStructure.getFormat().getId()).get());
                return billStructure;
            }).
            map(billStructure -> {
                billStructure.setCycleSpecification(
                        billStructureService.getBillingCycleSpecificationById(
                                billStructure.getCycleSpecification().getId()).get());
                return billStructure;
            }).
            map(billStructure -> {
                List<BillPresentationMediaRef> listOfBillPresentationMediaRefList = new ArrayList<>();
                if(billStructure.getPresentationMedia() != null && billStructure.getPresentationMedia().size() > 0){
                    listOfBillPresentationMediaRefList = billStructure.getPresentationMedia();
                }
                List<BillPresentationMediaRef> mappedListOfBillPresentationMediaRefs =
                        listOfBillPresentationMediaRefList.stream().map(
                            media -> {
                                return billStructureService.getBillPresentationMediaById(media.getId()).get();
                            }
                ).collect(Collectors.toList());
                billStructure.setPresentationMedia(mappedListOfBillPresentationMediaRefs);
                return billStructure;
            });
    }
}
