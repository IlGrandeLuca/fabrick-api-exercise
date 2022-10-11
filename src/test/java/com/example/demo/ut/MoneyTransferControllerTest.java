package com.example.demo.ut;

import com.example.demo.moneytransfer.controller.MoneyTransferController;
import com.example.demo.moneytransfer.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MoneyTransferControllerTest {

    @Autowired
    private MoneyTransferController moneyTransferController;

    // Money transfer test

    @Test
    public void moneyTransferCallApi() {
        MoneyTransfer moneyTransfer = addMoneyTransfer();
        moneyTransferController.createMoneyTransfer(moneyTransfer, "14537780");
    }

    @Test
    public void moneyTransferCallApiExceptionCheck() {
        MoneyTransfer moneyTransfer = addMoneyTransfer();
        moneyTransferController.createMoneyTransfer(null, "14537780");
        moneyTransferController.createMoneyTransfer(null, "");
    }

    private MoneyTransfer addMoneyTransfer() {
        MoneyTransfer moneyTransfer = new MoneyTransfer();
        Creditor creditor = new Creditor();
        Account account = new Account();
        Address address = new Address();
        TaxRelief taxRelief = new TaxRelief();
        NaturalPersonBeneficiary naturalPersonBeneficiary = new NaturalPersonBeneficiary();
        LegalPersonBeneficiary legalPersonBeneficiary = new LegalPersonBeneficiary();

        String dateString = "2019-04-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        creditor.setName("John Doe");
        account.setAccountCode("IT23A0336844430152923804660");
        account.setBicCode("SELBIT2BXXX");
        creditor.setAccount(account);
        creditor.setAddress(address);
        moneyTransfer.setCreditor(creditor);
        moneyTransfer.setExecutionDate(date);
        moneyTransfer.setUri("REMITTANCE_INFORMATION");
        moneyTransfer.setDescription(null);
        moneyTransfer.setAmount(800);
        moneyTransfer.setCurrency("EUR");
        moneyTransfer.setIsUrgent(false);
        moneyTransfer.setIsInstant(false);
        moneyTransfer.setFeeType("SHA");
        moneyTransfer.setFeeAccountId("45685475");
        taxRelief.setTaxReliefId("L449");
        taxRelief.setIsCondoUpgrade(false);
        taxRelief.setCreditorFiscalCode("56258745832");
        taxRelief.setBeneficiaryType("NATURAL_PERSON");
        naturalPersonBeneficiary.setFiscalCode1("MRLFNC81L04A859L");
        taxRelief.setNaturalPersonBeneficiary(naturalPersonBeneficiary);
        taxRelief.setLegalPersonBeneficiary(legalPersonBeneficiary);
        moneyTransfer.setTaxRelief(taxRelief);
        return moneyTransfer;
    }
}
