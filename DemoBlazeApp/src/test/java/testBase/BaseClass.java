package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;;

	@BeforeClass
	public void setup(@Optional("chrome") String br) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fr);

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			logger.info("invalid browser name");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(pr.getProperty("URL"));

	}

	public void takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\DemoBalzeScreenshots.png");
		sourceFile.renameTo(targetFile);

	}

}
