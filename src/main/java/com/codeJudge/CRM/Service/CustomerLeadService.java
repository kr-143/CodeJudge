package com.codeJudge.CRM.Service;

import com.codeJudge.CRM.Model.CustomerLeadModel;

public interface CustomerLeadService {

	public CustomerLeadModel fetchCustomerLeadModel(Integer id) throws Exception;
	public CustomerLeadModel saveCustomerLead(CustomerLeadModel model) throws Exception;
	public CustomerLeadModel updateCustomerLead(CustomerLeadModel model,Integer id) throws Exception;
	public CustomerLeadModel updateCustomerLeadAsMarked(Integer id) throws Exception;
	public void deleteCustomerLead(Integer id) throws Exception;
}
