package name.marmac.bankanalyzer.importers.statements.ch.bcv.converters;

import name.marmac.bankanalyzer.importers.statements.ch.bcv.model.to.BCVAccountStatement;
import name.marmac.bankanalyzer.model.to.transactions.ObjectFactory;
import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import org.apache.camel.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by marcomaccio on 14/05/2016.
 */
@Converter
public class BCVStatmentToBATransactionConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BCVStatmentToBATransactionConverter.class);

    @Converter
    public static TransactionTOType toTransactionTOType(BCVAccountStatement bcvAccountStatement) throws Exception {

        LOGGER.debug("BCVAccountStatement: \n " +
                    "Exec date: "   +   bcvAccountStatement.getExecutionDate()     + "\n " +
                    "Description: " +   bcvAccountStatement.getTransaction()       + "\n " +
                    "Credit:  "     +   bcvAccountStatement.getCredit()            + "\n " +
                    "Debit :  "     +   bcvAccountStatement.getDebit()             + "\n " +
                    "Value date: "  +   bcvAccountStatement.getValueDate()         + "\n " +
                    "Balance: "     +   bcvAccountStatement.getBalance()           + "\n " +
                    "Category: "    +   bcvAccountStatement.getCategory()          + "\n " +
                    "Subcategory: " +   bcvAccountStatement.getSubCategory()
                    );

        ObjectFactory transactionOFactory = new ObjectFactory();
        TransactionTOType transactionTOType = transactionOFactory.createTransactionTOType();

        Calendar executionDate = Calendar.getInstance();
        executionDate.setTime(bcvAccountStatement.getExecutionDate());

        Calendar valueDate      = Calendar.getInstance();
        valueDate.setTime(bcvAccountStatement.getValueDate());

        transactionTOType.setExecutionDate(executionDate);
        transactionTOType.setDescription(bcvAccountStatement.getTransaction());
        transactionTOType.setValueDate(valueDate);
        transactionTOType.setDebit(BigDecimal.valueOf(bcvAccountStatement.getDebit()));
        transactionTOType.setCredit(BigDecimal.valueOf(bcvAccountStatement.getCredit()));
        transactionTOType.setBalance(BigDecimal.valueOf(bcvAccountStatement.getBalance()));
        transactionTOType.setCategory(bcvAccountStatement.getCategory());
        transactionTOType.setSubCategory(bcvAccountStatement.getSubCategory());
        transactionTOType.setNote(bcvAccountStatement.getNote());

        LOGGER.debug("TransactionTOType: \n " + transactionTOType.toString());

        return transactionTOType;
    }
}
