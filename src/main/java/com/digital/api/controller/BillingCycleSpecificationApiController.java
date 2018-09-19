package com.digital.api.controller;

import com.digital.api.model.BillPresentationMedia;
import com.digital.api.model.BillPresentationMediaRef;
import com.digital.api.model.BillingCycleSpecification;
import com.digital.api.model.BillingCycleSpecificationRef;
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
public class BillingCycleSpecificationApiController {

    @Autowired
    private BillStructureServiceImpl billStructureService;

    @GetMapping(value = "/billingCycleSpecification",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillingCycleSpecification> listBillingCycleSpecification(@ApiParam(value = "Comma separated properties to display in response") @RequestParam(value = "fields", required = false) String fields
            , @ApiParam(value = "Requested index for start of resources to be provided in response") @RequestParam(value = "offset", required = false) Integer offset
            ,@ApiParam(value = "Requested number of resources to be provided in response") @RequestParam(value = "limit", required = false) Integer limit
    ) {

        List<BillingCycleSpecificationRef> billingCycleSpecificationRefList =
                billStructureService.getAllBillingCycleSpecification();
        List<BillingCycleSpecification> billingCycleSpecificationList = billingCycleSpecificationRefList.stream()
                .map(billingCycleSpecificationRef -> {
                    BillingCycleSpecification billingCycleSpecification = new BillingCycleSpecification();
                    BeanUtils.copyProperties(billingCycleSpecificationRef, billingCycleSpecification);
                    return billingCycleSpecification;
                }).collect(Collectors.toList());
        return Flux.fromIterable(billingCycleSpecificationList);
    }



    @GetMapping(value = "/billingCycleSpecification/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillingCycleSpecification> retrieveBillingCycleSpecification(
        @ApiParam(value = "Identifier of the Billing Cycle Specification",required=true ) @PathVariable("id") String id

    ){
        BillingCycleSpecification billingCycleSpecification = new BillingCycleSpecification();
        BeanUtils.copyProperties(billStructureService.getBillingCycleSpecificationById(id).get(), billingCycleSpecification);
        return Flux.fromIterable(Arrays.asList(billingCycleSpecification));
    }

}
