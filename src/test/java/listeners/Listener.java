package listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test: "  + iTestContext.getName() + " FINISHED" + "\n" );
        super.onFinish(iTestContext);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test from: " + iTestContext.getName() + " STARTED" + "\n");
        super.onStart(iTestContext);
    }

    @Override
    public void onTestStart(ITestResult iTestResult){
        System.out.println("Test method: " + iTestResult.getName() + " STARTED");
        super.onTestStart(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test: " + iTestResult.getMethod().getMethodName() +  " PASSED" + "\n");
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test: " + iTestResult.getMethod().getMethodName() + " FAILURE" + "\n");
        super.onTestFailure(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test: " + iTestResult.getMethod().getMethodName() +  " SKIPPED" + "\n");
        super.onTestSkipped(iTestResult);
    }
}
