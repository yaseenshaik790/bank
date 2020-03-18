package com.hcl.bank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.bank.dto.FundTransferdto;
import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.FundTransfer;
import com.hcl.bank.entity.Transaction;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.FundTransferRepository;
import com.hcl.bank.repository.TransactionRepository;
@Service
public class FundService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private FundTransferRepository fundTransferRepository;

	@Transactional
	public String fundTransfer(FundTransferdto fundTransferdto)
			throws InsufficientResourcesException, AccountNotFoundException {

		Optional<Account> fromAccountCheck = accountRepository.findByAccountNumber(fundTransferdto.getFromAccount());

		if (!fromAccountCheck.isPresent()) {

			throw new AccountNotFoundException(fundTransferdto.getFromAccount());
		}

		Account fromAccount = fromAccountCheck.get();

		Optional<Account> toAccountCheck = accountRepository.findByAccountNumber(fundTransferdto.getToAccount());
		Account toAccount = toAccountCheck.get();

		if (!toAccountCheck.isPresent()) {

			throw new AccountNotFoundException(fundTransferdto.getToAccount());
		}

		if (fromAccount.getAvailableBalance() < fundTransferdto.getAmount()) {
			throw new InsufficientResourcesException("Insufficient fund exception ");
		}

		fromAccount.setAvailableBalance(fromAccount.getAvailableBalance() - fundTransferdto.getAmount());

		toAccount.setAvailableBalance(toAccount.getAvailableBalance() + fundTransferdto.getAmount());

		Transaction fromTransaction = new Transaction();

		fromTransaction.setAmount(fundTransferdto.getAmount());
		fromTransaction.setTransactionDateTime(new Date());
		fromTransaction.setTransactionStatus("success");
		fromTransaction.setTransactionDescription(fundTransferdto.getDescription());
		fromTransaction.setTransactionType("debited");
		List<Transaction> fromTransactionList = new ArrayList<Transaction>();
		fromTransactionList.add(fromTransaction);

		fromAccount.setTransaction(fromTransactionList);
		fromTransaction.setAccounts(fromAccount);
		accountRepository.save(fromAccount);

		Transaction toTransaction = new Transaction();
		toTransaction.setAmount(fundTransferdto.getAmount());
		toTransaction.setTransactionDateTime(new Date());
		toTransaction.setTransactionStatus("success");
		toTransaction.setTransactionDescription(fundTransferdto.getDescription());
		toTransaction.setTransactionType("credited");

		List<Transaction> toTransactionList = new ArrayList<Transaction>();
		toTransactionList.add(toTransaction);

		toAccount.setTransaction(toTransactionList);
		toTransaction.setAccounts(toAccount);
		accountRepository.save(toAccount);
		
		FundTransfer fundTransfer = new FundTransfer(toAccount.getAccountNumber(), fundTransferdto.getAmount(), fromAccount.getAccountNumber());
		
		fundTransferRepository.save(fundTransfer);
		return "Transaction successful";

	}

}
