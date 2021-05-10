package myTests;

import myTests.models.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ApiTests {

    @Test
    public void testEmail(){
        List<UserModel> usersList = APIMethods.getAllUser();
        String email = "";
        for (UserModel user : usersList){
            if (user.getFirstName().equals("George") && user.getLastName().equals("Bluth")) email = user.getEmail();
        }
        Assert.assertEquals(email, "george.bluth@reqres.in");
    }

    @Test
    public void testEmailWithPagination(){
        List<UserModel> usersList = APIMethods.getAllUser();
        String email = "";
        for (UserModel user : usersList){
            if (user.getFirstName().equals("Michael") && user.getLastName().equals("Lawson")) email = user.getEmail();
        }
        Assert.assertEquals(email, "michael.lawson@reqres.in");
    }

}
