package com.lti.service;

import java.util.List;

import com.lti.dto.BeneficiaryDTO;
import com.lti.dto.GetTransactionDTO;
import com.lti.dto.TransactionDTO;
import com.lti.dto.TransactionResponseDTO;

public interface TransactionInfoService {
	
	public void addBeneficiary(BeneficiaryDTO beneficiaryDTO);
	public int addTransaction(TransactionDTO transactionDTO);
	public TransactionResponseDTO checkTransaction(TransactionDTO transactionDTO);
	public void addSavedPayment(TransactionDTO transactionDTO);
	public List<TransactionDTO> getAllSavedPayments(String accountNumber);
	public List<TransactionDTO> getAllTransactions(GetTransactionDTO getTransactionDTO);
	public List<BeneficiaryDTO> getAllBeneficiaries(String accountNumber);
	

}
