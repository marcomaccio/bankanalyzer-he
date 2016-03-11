package name.marmac.bankanalyzer.dal.impl.jpa.nosql.tests.create;

import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import name.marmac.bankanalyzer.dal.impl.jpa.nosql.BankAccountsPersistenceServicesImplJPANoSQL;
import name.marmac.bankanalyzer.model.impl.jpa.nosql.BankAccountPONoSql;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;

/**
 * Created by marcomaccio on 19/02/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dal-impl-jpa-nosql-integration-test-context.xml"})
public class ITCreateBankAccountTest {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(ITCreateBankAccountTest.class);

    @Autowired
    private BankAccountsPersistenceServicesImplJPANoSQL bankAccountsPersistenceServices;

    @ClassRule
    public static ManagedMongoDb managedMongoDb = newManagedMongoDbRule().mongodPath("/usr/local/bin/mongod").build();

    @Rule
    public MongoDbRule managedMongoDbRule =  newMongoDbRule().defaultManagedMongoDb("ba-nosql-test");

    @Test
    @UsingDataSet(locations="ITCreateBankAccountTest-initial.json", loadStrategy= LoadStrategyEnum.CLEAN_INSERT)
    @ShouldMatchDataSet(location="ITCreateBankAccountTest-expected.json")
    public void testCreateBankAccount() {
        //Using the SimpleDateFormat
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        Date openingDate = null;
        try {
            openingDate = format.parse("2016-02-18T10:50:00Z");
            LOGGER.info("OpeningDate: " + openingDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BankAccountPONoSql bankAccount = new BankAccountPONoSql();
        bankAccount.setBankName("MyBANK");
        bankAccount.setHolderName("Shaun the Sheep");
        bankAccount.setIban("CH53078");

        bankAccount.setOpeningDate(openingDate);

        //TransactionPONoSql transaction = new TransactionPONoSql();
        //bankAccount.getTransactions().add(transaction);

        bankAccount = bankAccountsPersistenceServices.save(bankAccount);
        if (bankAccount.getId() != null){
            LOGGER.info("" + bankAccount.getId());
        }
    }


}
