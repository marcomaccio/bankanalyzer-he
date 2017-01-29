package name.marmac.bankanalyzer.importers.statements.ch.bcv.routes;

import name.marmac.bankanalyzer.importers.statements.ch.bcv.aggregators.TransactionsTOAggregationStrategy;
import name.marmac.bankanalyzer.importers.statements.ch.bcv.model.to.BCVAccountStatement;
import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 10.01.17.
 */
public class BCVConvertCSVToJSONRoute extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(BCVImportRoute.class);
    private static final long BATCH_TIME_OUT = 30L;

    BindyCsvDataFormat formatBCVExport = new BindyCsvDataFormat("name.marmac.bankanalyzer.importers.statements.ch.bcv.model.to");

    @Override
    public void configure() throws Exception {

        LOGGER.debug("Configure method called...");
        from("file:/Users/marcomaccio/.bankanalyzer/importers/statements/ch/bcv/CH3100767000S53107882?noop=true&delay=10")
                .routeId("Importer :: Statements :: BCV Transform Service  CSV --> JSON ")
                .log(LoggingLevel.DEBUG, "Printing all file: \n ${body}  \n")

                .unmarshal(formatBCVExport)

                .split(body())
                    .convertBodyTo(BCVAccountStatement.class)
                    .convertBodyTo(TransactionTOType.class)
                    .log(LoggingLevel.DEBUG, "Printing all file: ${body} ")
                .aggregate(constant(true),new TransactionsTOAggregationStrategy()).completionTimeout(BATCH_TIME_OUT)
                .processRef("transactionToJSONProcessor")
                .log(LoggingLevel.DEBUG, "Printing all file: ${body} ")
                .setHeader(Exchange.FILE_NAME,
                        simple("${file:name.noext}-${date:now:yyyy-MM-dd-HHmm-ss_SSS}.${file:ext}"))
                .to("file:target/results")
                .end();

    }

}