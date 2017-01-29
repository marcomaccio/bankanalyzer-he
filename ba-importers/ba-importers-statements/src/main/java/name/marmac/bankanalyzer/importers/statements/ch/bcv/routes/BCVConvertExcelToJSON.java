package name.marmac.bankanalyzer.importers.statements.ch.bcv.routes;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 28.01.17.
 */
public class BCVConvertExcelToJSON extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(BCVConvertExcelToJSON.class);
    private static final long BATCH_TIME_OUT = 30L;

    public void configure() throws Exception {

    }
}
