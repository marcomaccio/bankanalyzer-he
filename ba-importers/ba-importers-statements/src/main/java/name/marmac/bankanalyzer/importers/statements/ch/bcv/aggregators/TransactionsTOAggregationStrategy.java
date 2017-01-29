package name.marmac.bankanalyzer.importers.statements.ch.bcv.aggregators;

import name.marmac.bankanalyzer.model.to.transactions.ObjectFactory;
import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import name.marmac.bankanalyzer.model.to.transactions.TransactionsTOType;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import java.util.ArrayList;

/**
 * Created by marcomaccio on 11.01.17.
 */
public class TransactionsTOAggregationStrategy implements AggregationStrategy {

    ObjectFactory transactionOF = new ObjectFactory();

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        TransactionTOType newBody = (TransactionTOType) newExchange.getIn().getBody();
        TransactionsTOType transactionList = null;
        if (oldExchange == null) {

            transactionList = transactionOF.createTransactionsTOType();
            transactionList.getTransactions().add(newBody);
            transactionList.setTotalRecords(transactionList.getTransactions().size());

            newExchange.getIn().setBody(transactionList);
            return newExchange;
        } else {
            transactionList = oldExchange.getIn().getBody(TransactionsTOType.class);
            transactionList.getTransactions().add(newBody);
            transactionList.setTotalRecords(transactionList.getTransactions().size());

            return oldExchange;
        }
    }
}
