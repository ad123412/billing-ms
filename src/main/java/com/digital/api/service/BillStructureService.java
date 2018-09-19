package com.digital.api.service;

import com.digital.api.model.BillFormatRef;
import com.digital.api.model.BillPresentationMediaRef;
import com.digital.api.model.BillStructure;
import com.digital.api.model.BillingCycleSpecificationRef;

import java.util.List;
import java.util.Optional;

public interface BillStructureService {

    public Optional<BillStructure> getBillStructureById(String id);

    public Optional<BillingCycleSpecificationRef> getBillingCycleSpecificationById(String id);

    public Optional<BillPresentationMediaRef> getBillPresentationMediaById(String id);

    public Optional<BillFormatRef> getBillFormatById(String id);

    public List<BillingCycleSpecificationRef> getAllBillingCycleSpecification();

    public List<BillPresentationMediaRef> getAllBillPresentationMedia();

    public List<BillFormatRef> getAllBillFormat();
}
