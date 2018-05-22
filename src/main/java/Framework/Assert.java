package Framework;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class Assert {

    private SoftAssert sofas;
    private ThreadLocal<SoftAssert> threadLocal = new ThreadLocal<SoftAssert>();    
 
    @BeforeMethod(alwaysRun = true)
    public void createSoftAssert(Method method)
    {
        sofas = new SoftAssert();
        threadLocal.set(sofas);
    }
 
    public SoftAssert getSoftAssert() {
        return (SoftAssert)threadLocal.get();
    }

}
