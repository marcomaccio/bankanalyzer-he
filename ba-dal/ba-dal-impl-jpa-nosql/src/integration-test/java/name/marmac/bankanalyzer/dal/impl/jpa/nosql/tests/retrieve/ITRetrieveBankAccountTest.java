package name.marmac.bankanalyzer.dal.impl.jpa.nosql.tests.retrieve;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import name.marmac.bankanalyzer.dal.impl.jpa.nosql.BankAccountsPersistenceServicesImplJPANoSQL;
import name.marmac.bankanalyzer.model.impl.jpa.nosql.BankAccountPONoSql;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created by marcomaccio on 11/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dal-impl-jpa-nosql-integration-test-context.xml"})
public class ITRetrieveBankAccountTest {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(ITRetrieveBankAccountTest.class);

    @Autowired
    private BankAccountsPersistenceServicesImplJPANoSQL bankAccountsPersistenceServices;

    @ClassRule
    public static ManagedMongoDb managedMongoDb = newManagedMongoDbRule().mongodPath("/usr/local/bin/mongod").build();

    @Rule
    public MongoDbRule managedMongoDbRule =  newMongoDbRule().defaultManagedMongoDb("ba-nosql-test");

    @Test
    @UsingDataSet(locations="ITRetrieveBankAccountTest.json", loadStrategy= LoadStrategyEnum.CLEAN_INSERT)
    public void testFindAllBankAccounts(){

        int EXPECTED_SIZE = 1;

        LOGGER.info("Method under test: FindAll ...");

        List<BankAccountPONoSql> bankAccountPOList = bankAccountsPersistenceServices.getAllBankAccounts();

        LOGGER.info("BankAccounts retrieved by the Persistence Layer: " + bankAccountPOList.size());

        Assert.assertEquals("It was expected " + EXPECTED_SIZE + " but retrieved: " + bankAccountPOList.size(), EXPECTED_SIZE, bankAccountPOList.size());
    }
}
