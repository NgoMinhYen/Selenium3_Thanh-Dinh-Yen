package utils.extentreports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import tech.grasshopper.reporter.ExtentPDFReporter;
import utils.common.Utilities;
import utils.common.constants.Constant;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();
    private static final String sDate = Utilities.toDate("yyyy-MM-dd HH-mm-ss");

    public synchronized static ExtentReports getExtentReports() {

        ExtentSparkReporter reporter = new ExtentSparkReporter(Constant.TARGET + "/ExtentReports/ExtentReport " + sDate + ".html");//chay được
        reporter.config().setReportName("Start Report " + sDate);
        reporter.config().setDocumentTitle("Start Report " + sDate);
//        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);

        ExtentPDFReporter pdfReporter = new ExtentPDFReporter(Constant.TARGET + "/ExtentReports/ExtentReport " + sDate +".pdf");
        extentReports.attachReporter(pdfReporter);

        return extentReports;
    }
}
