package name.marmac.bankanalyzer.importers.statements.ch.bcv.routes;

import name.marmac.bankanalyzer.importers.statements.ch.bcv.model.to.BCVAccountStatement;
import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 11/06/2015.
 */
public class BCVImportRoute extends RouteBuilder
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BCVImportRoute.class);

    BindyCsvDataFormat formatBCVExport = new BindyCsvDataFormat("name.marmac.bankanalyzer.importers.statements.ch.bcv.model.to");

    @Override
    public void configure() throws Exception {

        LOGGER.debug("Configure method called...");

        from("file:/Users/marcomaccio/.bankanalyzer/importers/statements/ch/bcv/CH5900767000H53107881?noop=true&delay=10")
            .routeId("Importer :: Statements :: BCV Import Service ")
            .log(LoggingLevel.DEBUG, "Printing all file: \n ${body}  \n")

            .unmarshal(formatBCVExport)

            .split(body())
                .log(LoggingLevel.DEBUG, "BCV Account Statement: ${body}")
                .convertBodyTo(BCVAccountStatement.class)
                .convertBodyTo(TransactionTOType.class)
                .processRef("transactionProcessor")
//                .bean(BCVTransactionHandler.class, "handleTransaction(com.camelatwork.components.bindy.model.bo.Transaction)")
                .to("cxfrs:bean:rsAccountManagerClient")
            .end();

    }

}