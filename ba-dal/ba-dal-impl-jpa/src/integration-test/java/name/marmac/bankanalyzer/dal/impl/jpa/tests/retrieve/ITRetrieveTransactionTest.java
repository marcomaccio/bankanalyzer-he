package name.marmac.bankanalyzer.dal.impl.jpa.tests.retrieve;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import name.marmac.bankanalyzer.dal.api.BankAccountsPersistenceServices;
import name.marmac.bankanalyzer.dal.impl.properties.DataStoreProperties;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by marcomaccio on 11/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dal-impl-jpa-integrationtest-context.xml"})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class ITRetrieveTransactionTest {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(ITRetrieveTransactionTest.class);

    @Resource
    private DataStoreProperties jdbcProperties;
    @Autowired
    private BankAccountsPersistenceServices   bankAccountsPersistenceServices;

    /**
     * This test will verify that the method getAllTransactionsByBankAccount will return
     * all transactions of a given BankAccount
     *
     */
    @Test
    @DatabaseSetup("findAllTransactionsByBankAccount.xml")
    public void testFindAllTransactionsByBankAccount(){

        int EXPECTED_SIZE = 2;

        LOGGER.info("Method under test: FindAllTransactionsByBankAccounts ...");
        LOGGER.info("JDBC Connection Properties: " + jdbcProperties.getJdbcDriverName() + ", " +
                                                jdbcProperties.getJdbcUserName() + ", " +
                                                jdbcProperties.getSchemaFileName());

        List<TransactionPO> transactionPOList = bankAccountsPersistenceServices.getAllTransactionsByBankAccount("001");

        LOGGER.info("Transactions retrieved by the Persistence Layer: " + transactionPOList.size());
        Assert.assertEquals("It was expected " + EXPECTED_SIZE + " but retrieved: " + transactionPOList.size(), EXPECTED_SIZE, transactionPOList.size());
    }

    /**
     * This test will verify that the method getAllTransactionsByValueDate will return
     * all transactions done in a specific date
     */
    @Test
    @DatabaseSetup("findAllTransactionByValueDate.xml")
    public void testFindAllTransactionByValueDate(){

        int EXPECTED_SIZE = 3;

        LOGGER.info("Method under test: FindAllTransactionsByValueDate ...");
        LOGGER.info("JDBC Connection Properties: " + jdbcProperties.getJdbcDriverName() + ", " +
                                                jdbcProperties.getJdbcUserName() + ", " +
                                                jdbcProperties.getSchemaFileName());

        Calendar cal = Calendar.getInstance();
        cal.set(2012,11,06);

        String  iban        = "001";
        Date    valueDate   = cal.getTime();
        LOGGER.info("valueDate: " + valueDate.toString());

        List<TransactionPO> transactionPOList = bankAccountsPersistenceServices.getAllTransactionsByBankAccountAndValueDate(iban, valueDate);

        LOGGER.info("Transactions retrieved by the Persistence Layer: " + transactionPOList.size());
        Assert.assertEquals("It was expected " + EXPECTED_SIZE + " but retrieved: " + transactionPOList.size(), EXPECTED_SIZE, transactionPOList.size());
    }

    /**
     * This test will verify that the method getAllTransactionByKeyValues will return
     * only one transaction if the following parameters are set:
     * - executionDate
     * - valueDate
     * - amount
     * - currency
     * - BankAccount.iban
     */
    @Test
    @DatabaseSetup("findAllTransactionByKeyValues.xml")
    public void testFindAllTransactionByKeyValues(){
        int EXPECTED_SIZE = 1;

        LOGGER.info("Method under test: FindAllTransactionsByValueDate ...");
        LOGGER.info("JDBC Connection Properties: " + jdbcProperties.getJdbcDriverName() + ", " +
                                                    jdbcProperties.getJdbcUserName()    + ", " +
                                                    jdbcProperties.getSchemaFileName());
        Calendar cal = Calendar.getInstance();
        cal.set(2012,11,06,00,00,00);
        String  iban            = "001";
        Date    executionDate   = cal.getTime();
        Date    valueDate       = cal.getTime();
        LOGGER.info("executionDate: " + executionDate.toString() + " valueDate: " + valueDate.toString());

        BigDecimal amount       = BigDecimal.valueOf(24.5);
        String  currency        = "CHF";

        List<TransactionPO> transactionPOList = bankAccountsPersistenceServices.getTransactionByKeyValues(executionDate, valueDate, amount, currency, iban);

        LOGGER.info("Transactions retrieved by the Persistence Layer: " + transactionPOList.size());
        Assert.assertEquals("It was expected " + EXPECTED_SIZE + " but retrieved: " + transactionPOList.size(), EXPECTED_SIZE, transactionPOList.size());
        for (TransactionPO transactionPO : transactionPOList){
            LOGGER.info("Transaction " + transactionPO.toString());
            Assert.assertEquals("iban is wrong ",           iban,           transactionPO.getBankAccount().getIban());
            Assert.assertEquals("executionDate is wrong ",  executionDate,  transactionPO.getExecutionDate());
            Assert.assertEquals("valueDate is wrong ",      valueDate,      transactionPO.getValueDate());
            Assert.assertEquals("amount is wrong",          amount,         transactionPO.getAmount());
            Assert.assertEquals("amount is wrong",          currency,       transactionPO.getCurrency());
        }
    }
}
