package P4_ParsingResponseBody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Ex1_ParsingJSONResponseData
{
  //  @Test(priority = 1)
    public void testJSONResponse1()
    {
        //approach1: Normal way (without capturing response)

        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/store")
        .then()
                .statusCode(200)
                .body("book[2].price", equalTo("150.50"))
                .body("book[3].title", equalTo("The Lord of Rings"));
    }


  //  @Test(priority = 2)
    public void testJSONResponse2()
    {
        //approach2: store response in a variable (with capturing response)

        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        Assert.assertEquals(resp.getStatusCode(), 200,"Failed-Status code mismatch");
        Assert.assertEquals(resp.jsonPath().getString("book[0].title")	, "savings of the country");


        //Assert.assertEquals(resp.getHeader("Content-Type")	, "application/json");
        //Assert.assertEquals(resp.getCookie("CookieName")	, "CookieValue");

        //Note: if title is not stored in same order then this approach will not work
        //we can write conditional/looping statement
    }






  //  @Test(priority = 3)
    public void getSingleTitleUsingJSOBObject()
    {
        //approach3: Converting Response into JSON Object

        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        //converting response into JSON Object type
        JSONObject jo=new JSONObject(resp.asString());

        String data = jo.getJSONArray("book").getJSONObject(0).get("title").toString();
        System.out.println(data);
    }

  //  @Test(priority = 4)
    public void getAllTitlesFromResponseUsingJSONObject()
    {
        //approach3: Converting Response into JSON Object

        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        //converting response into JSON Object type
        JSONObject jo=new JSONObject(resp.asString());

        int lastIndex = jo.getJSONArray("book").length()-1;
        for(int i=0; i<=lastIndex; i++)
        {
            String title = jo.getJSONArray("book").getJSONObject(i).getString("title");
            System.out.println(title);
        }
    }

   // @Test(priority = 5)
    public void verifySpecificTitleFromResponse()
    {
        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");

        JSONObject jo=new JSONObject(resp.asString());

        boolean titileFound=false;
        String expTitle="Moby Dick";

        int lastIndex = jo.getJSONArray("book").length()-1;
        for(int i=0; i<=lastIndex; i++)
        {
            String actTitle = jo.getJSONArray("book").getJSONObject(i).getString("title");
            if(actTitle.equals(expTitle))
            {
                titileFound=true;
                break;
            }
        }
        Assert.assertTrue(titileFound,"Failed : title not found  -   ");
    }


    @Test(priority = 5)
    public void verifyTotalPriceFromResponse()
    {
        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/store");
        JSONObject jo=new JSONObject(resp.asString());

        double totalPrice=0;

        int lastIndex = jo.getJSONArray("book").length()-1;
        for(int i=0; i<=lastIndex; i++)
        {
            String price = jo.getJSONArray("book").getJSONObject(i).getString("price");
            totalPrice=totalPrice+ Double.parseDouble(price);
        }

        System.out.println(totalPrice);
        Assert.assertEquals(totalPrice, 601,"Failed : price mismatch  -   ");
    }
}



