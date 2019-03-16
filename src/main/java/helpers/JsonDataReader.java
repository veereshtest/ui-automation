package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import testDataTypes.User;

public class JsonDataReader {
private final String userFilePath = "src/test/resources/testData/" + "User.json";
private List<User> userList;
private static JsonDataReader jsonDataReader;

public JsonDataReader(){
	userList = getUserData();
	}

private List<User> getUserData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(userFilePath));
		User[] users = gson.fromJson(bufferReader, User[].class);
		return Arrays.asList(users);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + userFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}
	
public final User getUserByName(String userName) {
		 for(User user : userList) {
		 if(user.firstname.equalsIgnoreCase(userName)) 
			 return user;
		 }
		     return null;
		 }
 public static JsonDataReader getJsonReader(){
     return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
}
}
