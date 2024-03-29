package test.nestle.createaccount;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;


public class Main {
   
	public static void main(String[] args) throws Exception {
	    // Configure Log4J
	    PropertyConfigurator.configure(Main.class.getClassLoader()
	                                       .getResource("log4j.properties"));

	    // Read the Zip Code from the Command-line (if none supplied, use 60202)
	    String zipcode = "firefox";
	    try {
	      zipcode = args[0];
	    } catch( Exception e ) {}

	    // Start the program
	    new Main(zipcode).start();
	  }

	  private String zip;

	  public Main(String zip) {
	    this.zip = zip;
	  }
	  @Test
	  public void start() throws Exception {
	    // Retrieve Data
	    InputStream dataIn = new AppTest().retrieve(zip);

	   
	  }
}