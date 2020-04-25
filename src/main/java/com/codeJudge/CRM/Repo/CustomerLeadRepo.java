package com.codeJudge.CRM.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeJudge.CRM.Entity.CustomerLead;
@Repository
public interface CustomerLeadRepo extends CrudRepository<CustomerLead, Integer> {

}
