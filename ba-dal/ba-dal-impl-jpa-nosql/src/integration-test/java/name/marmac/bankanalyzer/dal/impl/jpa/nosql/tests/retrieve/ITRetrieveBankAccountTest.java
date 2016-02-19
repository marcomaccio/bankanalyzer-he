package name.marmac.bankanalyzer.dal.impl.jpa.nosql.tests.retrieve;

import name.marmac.bankanalyzer.dal.impl.jpa.nosql.BankAccountsPersistenceServicesImplJPANoSQL;
import name.marmac.bankanalyzer.model.impl.jpa.nosql.BankAccountPONoSql;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by marcomaccio on 11/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dal-impl-jpa-nosql-integration-test-context.xml"})

public class ITRetrieveBankAccountTest {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(ITRetrieveBankAccountTest.class);

    @Autowired
    private BankAccountsPersistenceServicesImplJPANoSQL bankAccountsPersistenceServices;

    @Test
    public void testFindAllBankAccounts(){

        int EXPECTED_SIZE = 0;

        LOGGER.info("Method under test: FindAll ...");

        List<BankAccountPONoSql> bankAccountPOList = bankAccountsPersistenceServices.getAllBankAccounts();

        LOGGER.info("BankAccounts retrieved by the Persistence Layer: " + bankAccountPOList.size());

        Assert.assertEquals("It was expected " + EXPECTED_SIZE + " but retrieved: " + bankAccountPOList.size(), EXPECTED_SIZE, bankAccountPOList.size());
    }
}
