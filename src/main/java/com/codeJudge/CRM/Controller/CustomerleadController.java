package com.codeJudge.CRM.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeJudge.CRM.Model.CustomerLeadModel;
import com.codeJudge.CRM.Model.FailureReponse;
import com.codeJudge.CRM.Service.CustomerLeadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@Component
public class CustomerleadController {

	@Autowired
	private CustomerLeadService cusService;

	@GetMapping("/api/leads/{lead_Id}")
	public ResponseEntity<String> fetchCustomerLeadsforGivenId(@PathVariable("lead_Id") Integer leadId) {
		ResponseEntity<String> response = null;
		try {
			CustomerLeadModel fetchCustomerLeadModel = cusService.fetchCustomerLeadModel(leadId);
			if (null != fetchCustomerLeadModel) {
				String prepareResponse = prepareResponse(fetchCustomerLeadModel, "Success");
				response = new ResponseEntity<>(prepareResponse, HttpStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			try {
				String failResponse = prepareResponse(null, "Failure");
				response = new ResponseEntity<>(failResponse, HttpStatus.BAD_REQUEST);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@PostMapping("/api/leads")
	public ResponseEntity<String> saveCustomerLeads(@RequestBody CustomerLeadModel leadModel) {
		ResponseEntity<String> response = null;
		try {
			CustomerLeadModel fetchCustomerLeadModel = cusService.saveCustomerLead(leadModel);
			if (null != fetchCustomerLeadModel) {
				String prepareResponse = prepareResponse(fetchCustomerLeadModel, "Success");
				response = new ResponseEntity<>(prepareResponse, HttpStatus.CREATED);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String failResponse = prepareResponse(null, "Failure");
				response = new ResponseEntity<>(failResponse, HttpStatus.BAD_REQUEST);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return response;
	}

	@PutMapping("/api/mark_lead/{lead_Id}")
	public ResponseEntity<String> UpdateCustomerLeadsAsMarked(@PathVariable("lead_Id") Integer leadId) {
		ResponseEntity<String> response = null;
		try {
			if (null != cusService.updateCustomerLeadAsMarked(leadId)) {
				String prepareResponseForPutMapping = prepareResponseForMarkMapping("Success");
				response = new ResponseEntity<>(prepareResponseForPutMapping, HttpStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			String failResponse;
			try {
				failResponse = prepareResponseForMarkMapping("Failure");
				response = new ResponseEntity<>(failResponse, HttpStatus.BAD_REQUEST);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return response;
	}

	@PutMapping("/api/leads/{lead_Id}")
	public ResponseEntity<String> UpdateCustomerLeads( @RequestBody CustomerLeadModel leadModel,
			@PathVariable("lead_Id") Integer leadId) {
		ResponseEntity<String> response = null;
		try {
			if (null != cusService.updateCustomerLead(leadModel, leadId)) {
				String prepareResponseForPutMapping = prepareResponseForPutMapping("Success");
				response = new ResponseEntity<>(prepareResponseForPutMapping, HttpStatus.ACCEPTED);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			String failResponse;
			try {
				failResponse = prepareResponseForPutMapping("Failure");
				response = new ResponseEntity<>(failResponse, HttpStatus.BAD_REQUEST);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return response;
	}

	@DeleteMapping("/api/leads/{lead_Id}")
	public ResponseEntity<String> deleteCustomerLeads(@PathVariable("lead_Id") Integer leadId) {
		ResponseEntity<String> response = null;
		try {
			cusService.deleteCustomerLead(leadId);
			String prepareResponseForPutMapping = prepareResponseForPutMapping("Success");
			response = new ResponseEntity<>(prepareResponseForPutMapping, HttpStatus.OK);
		} catch (Exception e) {
			String failResponse;
			try {
				failResponse = prepareResponseForPutMapping("Failure");
				response = new ResponseEntity<>(failResponse, HttpStatus.BAD_REQUEST);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return response;
	}

	private String prepareResponse(CustomerLeadModel model, String status) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		if (status.equalsIgnoreCase("Success")) {
			return mapper.writeValueAsString(model);
		} else {
			SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("communication");
			FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
			FailureReponse response = new FailureReponse();
			response.setStatus("failure");
			response.setReason("Failed.....");
			return mapper.writer(filters).writeValueAsString(response);
		}	
	}

	private String prepareResponseForPutMapping(String status) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		if (status.equalsIgnoreCase("Success")) {
			SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(new String[] {"communication","reason"});
			FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
			FailureReponse response = new FailureReponse();
			response.setStatus("success");
			return mapper.writer(filters).writeValueAsString(response);
		} else {
			SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("communication");
			FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
			FailureReponse response = new FailureReponse();
			response.setStatus("failure");
			response.setReason("Failed.....");
			return mapper.writer(filters).writeValueAsString(response);
		}
	}
	
	private String prepareResponseForMarkMapping(String status) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		if (status.equalsIgnoreCase("Success")) {
			SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(new String[] {"reason"});
			FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
			FailureReponse response = new FailureReponse();
			response.setStatus("success");
			response.setCommunication("Communicate");
			return mapper.writer(filters).writeValueAsString(response);
		} else {
			SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("communication");
			FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", theFilter);
			FailureReponse response = new FailureReponse();
			response.setStatus("failure");
			response.setReason("Failed.....");
			return mapper.writer(filters).writeValueAsString(response);
		}
	}

}
