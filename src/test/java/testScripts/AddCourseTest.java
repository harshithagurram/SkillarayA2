package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.Iconstantpath;
// this test is verifies if user is able to add course
public class AddCourseTest extends BaseClass {
@Test
public void addCourseTest() throws InterruptedException {
	SoftAssert soft=new SoftAssert();
	home.clickCoursesTab();
	home.clickCoursesListLink();
	courseList.clickNewButton();
	Thread.sleep(3000);
	Map<String,String>map=excel.readFromExcel("Add Course");
	System.out.println(map);
	addcourse.setName(map.get("Name"));
	addcourse.selectCategory(web, map.get("Category"));
	addcourse.setPrice(map.get("Price"));
	addcourse.uploadPhoto(map.get("Photo"));
	addcourse.setDescription(map.get("Description"), web);
	addcourse.clickSave();
	
	soft.assertEquals(courseList.getSuccessMessage(),"Success!");
	courseList.deleteCourse(web, map.get("Name"));
	soft.assertEquals(courseList.getSuccessMessage(),"Success!");
	if(courseList.getSuccessMessage().equals("Success!")) {
		excel.updateTestStatus("Add Course","Pass",Iconstantpath.EXCEL_PATH);
	}
		else {
		excel.updateTestStatus("Add Course","Fail",Iconstantpath.EXCEL_PATH);
		}
	
}
}
		
	
	


