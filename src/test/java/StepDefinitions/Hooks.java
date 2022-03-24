package StepDefinitions;

import Utils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends BaseClass {

	public Scenario scenario = null;
	public static File destPath;
	public static String output;
	public static String path;


	@Before()
	public void before(Scenario scenario) throws IOException {
		this.scenario = scenario;
	}

	@After(order=1)
	public void AfterSelenium()
	{
		driver.close();
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}

	@After(order=2)
	public void AftersaveScreenshot(Scenario scenario)  {


		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss");
		Date curDate = new Date(); String strDate = sdf.format(curDate);
		File screenshot_with_scenario_name = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));

		if(scenario.isFailed())
		{
			path = "./test-output/Screenshots/Failed/"+scenario.getName()+".png";
			destPath=new File(path);
			sharedatastep.failed++;
		}
		else{
			path = "./test-output/Screenshots/Passed/"+scenario.getName()+".png";
			destPath=new File(path);
			sharedatastep.passed++;
		}

		try {
			FileUtils.copyFile(screenshot_with_scenario_name,destPath);

		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
