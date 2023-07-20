package core.framework.utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import core.framework.utils.common.Utilities;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();
    private static final String sDate = Utilities.toDate("yyyy-MM-dd HH-mm-ss");

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport " + sDate + ".html");
        reporter.config().setReportName("Report");
        reporter.config().setDocumentTitle("Report");
        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
