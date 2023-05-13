package seleniumproject;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Testngexample {
	
	@Test()
	void lanch()
	{
		
		Assert.assertTrue(true);
		System.out.println("lanch browser");
	}
	
	@Test(priority=2, dependsOnMethods={"lanch"})
	void app(){
		System.out.println("my application login");
	}
	@Test (priority=1,dependsOnMethods={"lanch","app"})
	void serach() {
		System.out.println("Searching my application");
	}
	@Test (priority=1,dependsOnMethods= {"lanch","app"})
	void advserach() {
		System.out.println("keep more Searching my application");
	}
	
	@Test (priority=7)
	void close() {
		System.out.println("closing my application");
	}

}
