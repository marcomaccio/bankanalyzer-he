package name.marmac.bankanalyzer.importers.statements.ch.bcv.processors;

import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;

import javax.ws.rs.core.MediaType;

/**
 * Created by marcomaccio on 14/05/2016.
 */
public class TransactionProcessors implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception
    {
        Message in = exchange.getIn();
        TransactionTOType transactionTOType = (TransactionTOType)in.getBody();

        //setting headers
        in.setHeader("Content-Type",    MediaType.APPLICATION_JSON);
        in.setHeader("Accept",          MediaType.APPLICATION_JSON);
        in.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, false);
        in.setHeader(CxfConstants.OPERATION_NAME, "createTransaction");
        in.setBody(transactionTOType);

        exchange.setOut(in);
    }
}
