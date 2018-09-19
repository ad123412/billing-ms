package com.digital.api.service;

import com.digital.api.model.BillFormatRef;
import com.digital.api.model.BillPresentationMediaRef;
import com.digital.api.model.BillStructure;
import com.digital.api.model.BillingCycleSpecificationRef;
import com.digital.api.repository.BillFormatRepository;
import com.digital.api.repository.BillPresentationMediaRepository;
import com.digital.api.repository.BillStructureRepository;
import com.digital.api.repository.BillingCycleSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillStructureServiceImpl implements BillStructureService {

    @Autowired
    private BillStructureRepository billStructureRepository;

    @Autowired
    private BillFormatRepository billFormatRepository;

    @Autowired
    private BillPresentationMediaRepository billPresentationMediaRepository;

    @Autowired
    private BillingCycleSpecificationRepository billingCycleSpecificationRepository;

    @Override
    public Optional<BillStructure> getBillStructureById(String id) {

        return billStructureRepository.findById(id);
    }

    @Override
    public Optional<BillingCycleSpecificationRef> getBillingCycleSpecificationById(String id) {
        return billingCycleSpecificationRepository.findById(id);
    }

    @Override
    public Optional<BillPresentationMediaRef> getBillPresentationMediaById(String id) {
        return billPresentationMediaRepository.findById(id);
    }

    @Override
    public Optional<BillFormatRef> getBillFormatById(String id) {
        return billFormatRepository.findById(id);
    }

    @Override
    public List<BillingCycleSpecificationRef> getAllBillingCycleSpecification() {

        List<BillingCycleSpecificationRef> billingCycleSpecificationRefList = new ArrayList<>();
        billingCycleSpecificationRepository.findAll()
                .forEach(
                        billingCycleSpecificationRef -> {
                            billingCycleSpecificationRefList.add(billingCycleSpecificationRef);
                        }
                );

        return billingCycleSpecificationRefList;
    }

    @Override
    public List<BillPresentationMediaRef> getAllBillPresentationMedia() {

        List<BillPresentationMediaRef> billPresentationMediaRefList = new ArrayList<>();
        billPresentationMediaRepository.findAll()
                .forEach(
                        billPresentationMediaRef -> {
                            billPresentationMediaRefList.add(billPresentationMediaRef);
                        }
                );

        return billPresentationMediaRefList;
    }

    @Override
    public List<BillFormatRef> getAllBillFormat() {

        List<BillFormatRef> billFormatRefList = new ArrayList<>();
        billFormatRepository.findAll()
                .forEach(
                        billFormatRef -> {
                            billFormatRefList.add(billFormatRef);
                        }
                );
        return billFormatRefList;
    }
}
