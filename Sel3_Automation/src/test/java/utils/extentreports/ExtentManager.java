package utils.extentreports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.ThreadContext;
import tech.grasshopper.reporter.ExtentPDFReporter;
import utils.common.Utilities;
import utils.common.constants.Constant;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();
    private static final String sDate = Utilities.toDate("yyyy-MM-dd HH-mm-ss");
    private static final String sPathFileReportHTML = Constant.TARGET + "/ExtentReports/ExtentReport " + sDate + ".html";
    private static final String sPathFileReportPDF = Constant.TARGET + "/ExtentReports/ExtentReport " + sDate + ".pdf";

    /*
     Configure and create an ExtentReports object that can generate HTML and PDF reports
     */
    public synchronized static ExtentReports getExtentReports() {
        ThreadContext.put("pathFileReportHTML", sPathFileReportHTML);
        ThreadContext.put("pathFileReportPDF", sPathFileReportPDF);

        ExtentSparkReporter reporter = new ExtentSparkReporter(sPathFileReportHTML);
        reporter.config().setReportName("Start Report " + sDate);
        reporter.config().setDocumentTitle("Start Report " + sDate);
//        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);

        ExtentPDFReporter pdfReporter = new ExtentPDFReporter(sPathFileReportPDF);
        extentReports.attachReporter(pdfReporter);

        return extentReports;
    }
}
