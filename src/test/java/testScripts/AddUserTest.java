package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AddUserTest extends BaseClass {
@Test
public void addUserTest() throws InterruptedException {
	SoftAssert soft=new SoftAssert();
	home.clickUsersTab();
	soft.assertTrue(users.getPageHeader().contains("Users"));
	users.clickNewButton();
	Thread.sleep(3000);
	soft.assertEquals(adduser.getPageHeader(),"Add new user");
	Map<String,String>map=excel.readFromExcel("Add User");
	
	adduser.setEmail(map.get("Email"));
	adduser.setPassword(map.get("password"));
	adduser.setFirstname(map.get("firstname"));
	adduser.setLastname(map.get("lastname"));
	adduser.setAddress(map.get("address"));
	adduser.setContactInfo(map.get("contact info"));
	adduser.uploadPhoto(map.get("photo"));
	adduser.clickSave();
	soft.assertEquals(users.getSuccessMessage(),"Success");
	soft.assertAll();
}
}
