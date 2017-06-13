/**
 * 
 */
package spring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author Administrator
 *
 */
public class PropertiesTest {
	
	public static void main(String[] args) {
		StandardEnvironment environment = new StandardEnvironment();
		String location = environment.resolveRequiredPlaceholders("quartz.properties");
		System.out.println(location);
		
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("quartz.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
