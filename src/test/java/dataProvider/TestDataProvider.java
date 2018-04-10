package dataProvider;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "testSearchDataProvider")
    public Object[][] testSearchDataProvider(){
        return new Object[][]{
                {10000, 20000},
                {0, 1000}

        };
    }

}
