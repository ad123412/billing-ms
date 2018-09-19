package com.digital.api.controller;

import com.digital.api.model.BillFormat;
import com.digital.api.model.BillFormatRef;
import com.digital.api.model.BillingCycleSpecification;
import com.digital.api.model.BillingCycleSpecificationRef;
import com.digital.api.service.BillStructureServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BillFormatApiController {

    @Autowired
    private BillStructureServiceImpl billStructureService;

    @GetMapping(value = "/billFormat", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillFormat> listBillFormat(@ApiParam(value = "Comma separated properties to display in response")
                                                 @RequestParam(value = "fields", required = false) String fields
        , @ApiParam(value = "Requested index for start of resources to be provided in response")
                                                 @RequestParam(value = "offset", required = false) Integer offset
        , @ApiParam(value = "Requested number of resources to be provided in response")
                                                 @RequestParam(value = "limit", required = false) Integer limit
    ) {

        List<BillFormatRef> billFormatRefList =
                billStructureService.getAllBillFormat();
        List<BillFormat> billFormatList = billFormatRefList.stream()
                .map(billFormatRef -> {
                    BillFormat billFormat = new BillFormat();
                    BeanUtils.copyProperties(billFormatRef, billFormat);
                    return billFormat;
                }).collect(Collectors.toList());
        return Flux.fromIterable(billFormatList);
    }


    @GetMapping(value = "/billFormat/{id}",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<BillFormat> retrieveBillFormat(
        @ApiParam(value = "Identifier of the Bill Format",required=true ) @PathVariable("id") String id) {

        BillFormat billFormat = new BillFormat();
        BeanUtils.copyProperties(billStructureService.getBillFormatById(id).get(), billFormat);
        return Flux.fromIterable(Arrays.asList(billFormat));
    }

}
