package myTests;

import myTests.models.Page;
import myTests.models.UserModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APIMethods {

    public static ArrayList<UserModel> getAllUser(){
        ArrayList<UserModel> listOfUsers= new ArrayList<>();
        int page = 1;
        while (getPageOfUsers(page).size() > 0){
            listOfUsers.addAll(getPageOfUsers(page));
            page++;
        }
        return listOfUsers;
    }

    public static List<UserModel> getPageOfUsers(int page){
        Page pageOfUsers = given().param("page", page).when().get(Config.BASE_URL + Config.BASE_PATH).as(Page.class);
        return pageOfUsers.getData();
    }
}
