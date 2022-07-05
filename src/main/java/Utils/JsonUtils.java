package Utils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtils {

	public static String convertJsonFileToString(String fileName) {
    	try {
    		JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\"+fileName+".json"));
			return jsonObject.toString();
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
		}
		return null;
	}
}
