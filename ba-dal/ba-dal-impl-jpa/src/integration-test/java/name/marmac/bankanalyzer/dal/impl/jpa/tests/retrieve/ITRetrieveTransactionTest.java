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

    @Test
    @DatabaseSetup("retrieved-transactions-01.xml")
    public void testFindAllTransactions(){

        int EXPECTED_SIZE = 2;

        LOGGER.info("Method under test: FindAll ...");
        LOGGER.info("JDBC Connection Properties: " + jdbcProperties.getJdbcDriverName() + ", " +
                                                jdbcProperties.getJdbcUserName() + ", " +
                                                jdbcProperties.getSchemaFileName());

        List<TransactionPO> transactionPOList = bankAccountsPersistenceServices.getAllTransactionsByBankAccount("001");

        LOGGER.info("Transactions retrieved by the Persistence Layer: " + transactionPOList.size());

        Assert.assertEquals("It was expected " + EXPECTED_SIZE + " but retrieved: " + transactionPOList.size(), EXPECTED_SIZE, transactionPOList.size());
    }
}
