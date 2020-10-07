package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.SavedPaymentsInfo;

@Repository
public class SavedPaymentsInfoDaoImpl implements SavedPaymentsInfoDao {

	@PersistenceContext
	EntityManager entityManager=null;
	
	public SavedPaymentsInfoDaoImpl() {
		
	}
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createSavedPayment(SavedPaymentsInfo savedPayment) {
		entityManager.persist(savedPayment);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<SavedPaymentsInfo> readAllSavedPaymentsByAccountNumber(String accountNumber) {
		String jpql="Select s from SavedPaymentsInfo s where s.fromAccountNumber.accountNumber=:accountNumber";
		TypedQuery<SavedPaymentsInfo> tQuery=entityManager.createQuery(jpql, SavedPaymentsInfo.class);
		tQuery.setParameter("accountNumber", accountNumber);
		List<SavedPaymentsInfo> savedPayments=tQuery.getResultList();
		return savedPayments;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deleteSavedPayment(String serialNumber) {
		String jpql="Delete s from SavedPayments s where s.serialNumber=:serialNumber";
		TypedQuery<SavedPaymentsInfo> tQuery=entityManager.createQuery(jpql, SavedPaymentsInfo.class);
		int result=tQuery.executeUpdate();
		return result;
		
	}

}
