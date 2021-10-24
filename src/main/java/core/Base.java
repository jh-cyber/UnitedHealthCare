package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
 
	public static WebDriver driver ;
	public static Properties properties;
	public static Logger logger;
//	we need to provide a path to read from it
	private String propertyPath=".\\src\\test\\resources\\input\\property.priperties"	;
	private String log4jPath=".\\src\\test\\resources\\input\\log4j.properties";
	
//	now we need to create a constructor , to initialize all the methods: 
//	we should to write a class like BufferReader or scanner or file and put strims 
//	BufferedReader class reads the data by specifying by characters
//	BufferedReade accepts an argument 
	public Base() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyPath) );
//			now we create the object of property
			properties = new Properties();
//			now we should load the file but you see  the red line under load we should add catch clause to try which will add IOException to catch 
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger = Logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4jPath);
		
	}
	
	public static String getBrowserName() {
		String browserName = properties.getProperty("browser");
		return browserName;
	}
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	public static void openBrowser() {
	driver.get(getUrl());
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public static void selectBrowser() {
		String browsers = getBrowserName();
		if (browsers.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browsers.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browsers.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	// driver.manage().deleteAllCookies();// this method will delete all store
	// cookies of browser
}
}
