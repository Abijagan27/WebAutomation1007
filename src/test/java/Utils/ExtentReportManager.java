package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void initReport() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Your Name");
        }
    }

    public static void startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        extentTest.set(test);
    }

    public static void logInfo(String message) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.info(message);
        }
    }

    public static void logPass(String message) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.fail(message);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
