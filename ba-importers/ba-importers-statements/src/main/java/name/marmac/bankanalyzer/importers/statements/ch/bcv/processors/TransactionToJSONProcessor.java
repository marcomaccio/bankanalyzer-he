package name.marmac.bankanalyzer.importers.statements.ch.bcv.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import name.marmac.bankanalyzer.model.to.transactions.TransactionsTOType;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by marcomaccio on 11.01.17.
 */
public class TransactionToJSONProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Message in = exchange.getIn();
        TransactionsTOType transactionsTOType = (TransactionsTOType) in.getBody();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String transactionsTOJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(transactionsTOType);

        exchange.getOut().setBody(transactionsTOJSON);
    }
}
