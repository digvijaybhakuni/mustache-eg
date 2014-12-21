import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

/**
 * 
 */

/**
 * @author digvijayb
 *
 */
public class TestMustacheClass {

	/**
	 * 
	 */
	public TestMustacheClass() {
		// TODO Auto-generated constructor stub
	}

	List<Item> items() {
		return Arrays.asList(
				new Item("Item 1", "$19.99", Arrays.asList(new Feature("New!"),
						new Feature("Awesome!"))),
				new Item("Item 2", "$29.99", Arrays.asList(new Feature("Old."),
						new Feature("Ugly."))));
	}

	static class Item {
		Item(String name, String price, List<Feature> features) {
			this.name = name;
			this.price = price;
			this.features = features;
		}

		String name, price;
		List<Feature> features;
	}

	static class Feature {
		Feature(String description) {
			this.description = description;
		}

		String description;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		 MustacheFactory mf = new DefaultMustacheFactory();
		 Mustache mustache = mf.compile("template.mustache");
		 mustache.execute(new PrintWriter(System.out), new TestMustacheClass()).flush();
		 System.out.println();
		 Map<String, Object> map = new HashMap<String, Object>(){
			 {
				 put("name", "Rahuliya");
				 put("accountNo", 420);
				 put("uuid", new String("101010-101010-10101-0420"));
				 put("status", "Failed because invalid information");
				 put("isPassed", 0);
				 put("isFailed", 1);
				 put("sender", "Motu..");
			 }
		 };
		 
		 mustache = mf.compile("email.content.template");
		 mustache.execute(new PrintWriter(System.out), map).flush();
	}
	/*
	  	Name: Item 1
		Price: $19.99
		Feature: New!
		Feature: Awesome!
		Name: Item 2
		Price: $29.99
		Feature: Old.
		Feature: Ugly.
		
		Hi Rahuliya,
		
		Your Account number 420 mapped with your aardhar card no. 101010-101010-10101-0420
		Is Failed because invalid information. Thank you for your assistance.
		
		Congrat!!! Now Enjoy the benefits...
		
		
		Sorry !!! Please try agian
		
		
		
		Thank You :-?
		Motu..

	 */

}
