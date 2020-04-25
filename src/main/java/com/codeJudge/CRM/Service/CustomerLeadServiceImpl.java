package com.codeJudge.CRM.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeJudge.CRM.Entity.CustomerLead;
import com.codeJudge.CRM.Enum.LocationType;
import com.codeJudge.CRM.Enum.StatusEnum;
import com.codeJudge.CRM.Model.CustomerLeadModel;
import com.codeJudge.CRM.Repo.CustomerLeadRepo;

@Service
public class CustomerLeadServiceImpl implements CustomerLeadService {

	@Autowired
	private CustomerLeadRepo cusRepo;

	@Override
	public CustomerLeadModel fetchCustomerLeadModel(Integer id) throws Exception {
		Optional<CustomerLead> findById = cusRepo.findById(id);
		if (findById.isPresent()) {
			CustomerLead customerLead = findById.get();
			return generateEntity(customerLead);
		}
		return null;
	}

	@Override
	public CustomerLeadModel saveCustomerLead(CustomerLeadModel model) throws Exception {
		if (model != null) {
			CustomerLead lead = generateEntity(model);
			lead.setStatus(StatusEnum.CREATED.name());
			lead = cusRepo.save(lead);
			return generateEntity(lead);
		}
		return null;
	}

	@Override
	public CustomerLeadModel updateCustomerLead(CustomerLeadModel model, Integer id) throws Exception {
		if (model != null) {
			Optional<CustomerLead> findById = cusRepo.findById(id);
			if (findById.isPresent()) {
				CustomerLead lead = findById.get();
				lead = generateEntity(model);
				lead.setStatus(StatusEnum.CREATED.name());
				lead = cusRepo.save(lead);
				return generateEntity(lead);
			}
		}
		return null;
	}

	@Override
	public void deleteCustomerLead(Integer id) throws Exception {
		cusRepo.deleteById(id);
	}

	private CustomerLead generateEntity(CustomerLeadModel model) {
		CustomerLead lead = new CustomerLead();
		lead.setFirstName(model.getFirst_name());
		lead.setLastName(model.getLast_name());
		lead.setMobile(model.getMobile());
		lead.setLocationString(model.getLocation_string());
		lead.setLocationType(LocationType.valueOf(model.getLocation_type()).name());
		return lead;
	}

	private CustomerLeadModel generateEntity(CustomerLead model) {
		CustomerLeadModel lead = new CustomerLeadModel();
		lead.setFirst_name(model.getFirstName());
		lead.setLast_name(model.getLastName());
		lead.setMobile(model.getMobile());
		lead.setLocation_string(model.getLocationString());
		lead.setLocation_type(LocationType.valueOf(model.getLocationType()).name());
		lead.setStatus(model.getStatus());
		lead.setId(model.getId());
		return lead;
	}

	@Override
	public CustomerLeadModel updateCustomerLeadAsMarked(Integer id) throws Exception {
		if (id != null) {
			Optional<CustomerLead> findById = cusRepo.findById(id);
			if (findById.isPresent()) {
				CustomerLead lead = findById.get();
				lead.setStatus(StatusEnum.CONTACTED.name());
				lead = cusRepo.save(lead);
				return generateEntity(lead);
			}
		}
		return null;
	}

}
