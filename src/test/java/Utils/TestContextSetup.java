package Utils;

import Pages.pageObjectManager;
import Resources.External.Base;

import java.io.IOException;

public class TestContextSetup {
    public pageObjectManager pom;

    public Base base;
public TestContextSetup() throws IOException {
    base=new Base();
    pom =new pageObjectManager(base.initializeDriver());
}
}
