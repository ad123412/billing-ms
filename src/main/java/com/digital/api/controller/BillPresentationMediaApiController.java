package com.digital.api.controller;

import com.digital.api.model.BillPresentationMedia;
import com.digital.api.model.BillPresentationMediaRef;
import com.digital.api.service.BillStructureService;
import com.digital.api.service.BillStructureServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BillPresentationMediaApiController {

    @Autowired
    private BillStructureServiceImpl billStructureService;

    @GetMapping(value = "/billPresentationMedia",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillPresentationMedia> listBillPresentationMedia(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
        ,@ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
        ,@ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {

        List<BillPresentationMediaRef> billPresentationMediaRefList =
                billStructureService.getAllBillPresentationMedia();
        List<BillPresentationMedia> billPresentationMediaList = billPresentationMediaRefList.stream()
                .map(billPresentationMediaRef -> {
                    BillPresentationMedia billPresentationMedia = new BillPresentationMedia();
                    BeanUtils.copyProperties(billPresentationMediaRef, billPresentationMedia);
                    return billPresentationMedia;
                }).collect(Collectors.toList());
        return Flux.fromIterable(billPresentationMediaList);
    }


    @GetMapping(value = "/billPresentationMedia/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillPresentationMedia> retrieveBillPresentationMedia(
        @ApiParam(value = "Identifier of the Bill Presentation Media",required=true ) @PathVariable("id") String id
    ) {

        BillPresentationMedia billPresentationMedia = new BillPresentationMedia();
        BeanUtils.copyProperties(billStructureService.getBillPresentationMediaById(id).get(), billPresentationMedia);
        return Flux.fromIterable(Arrays.asList(billPresentationMedia));
    }

}
