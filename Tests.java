package testNG;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;


public class Tests {

    //Task 1 Begin

    @Test
    public void checkGet() {
        String request = "http://www.dneonline.com/calculator.asmx?WSDL";
        given().
                when().get(request).
                then().log().ifError().statusCode(200).extract().response();
    }

    @Test
    public void checkPut() {
        String request = "http://www.dneonline.com/calculator.asmx?WSDL";
        given().
                when().put(request).
                then().log().ifError().statusCode(405).extract().response();
    }

    @Test
    public void checkPatch() {
        String request = "http://www.dneonline.com/calculator.asmx?WSDL";
        given().
                when().put(request).
                then().log().ifError().statusCode(405).extract().response();
    }

    @Test
    public void checkDelete() {
        String request = "http://www.dneonline.com/calculator.asmx?WSDL";
        given().
                when().delete(request).
                then().log().ifError().statusCode(405).extract().response();
    }

    @Test
    public void checkResponse() {
        String request = "http://www.dneonline.com/calculator.asmx?WSDL";
        Response response = given().when().get(request).
                then().log().ifError().contentType("text/xml").extract().response();
        System.out.println(response.xmlPath().prettify());
    }


    @Test
    public void checkMatch() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("http://www.dneonline.com/calculator.asmx?WSDL");
        NodeList schemas = document.getElementsByTagName("s:schema");
        for (int i = 0; i < schemas.getLength(); i++) {
            NamedNodeMap schemasMap = schemas.item(i).getAttributes();

            assertTrue("elementFormDefault not equals 'qualified'",
                    "qualified".equals(schemasMap.getNamedItem("elementFormDefault").getNodeValue()));
        }
    }

    //Task 1 End

    //Task 2 Exercise 1
    SimpleModelBean simpleModelBean = new SimpleModelBean(new String());
    SimpleModelBean anotherSimpleModeBean = new SimpleModelBean(new String());

    //Task 2 Exercise 3
    @Test
    public void testPropertiesInitialStates() {

        String aStr = simpleModelBean.getaStr();
        assertTrue("'aStr' not equals to null", aStr == null);

        String aFinalStr = simpleModelBean.getaFinalStr();
        assertTrue("'aFinalStr' not equals to empty String", aFinalStr.equals(new String()));

        String aFilledStr = simpleModelBean.getaFilledStr();
        assertTrue("'aFilledStr' not equals to 'abc'", aFilledStr.equals("abc"));

        String aFilledStrCopy = simpleModelBean.getaFilledStrCopy();
        assertTrue("'aFilledStrCopy' not equals to 'abc'", aFilledStrCopy.equals("abc"));

        String aFilledStrObjCopy = simpleModelBean.getaFilledStrObjCopy();
        assertTrue("'aFilledStrObjCopy' not equals to 'abc'", aFilledStrObjCopy.equals("abc"));

        int i = simpleModelBean.getI();
        assertTrue("'i' not equals to 0", i == 0);

        Integer iObj = simpleModelBean.getiObj();
        assertTrue("'iObl' not equals to null", iObj == null);
    }

    //Task 2 Exercise 4
    @Test
    public void equalityTest() {
        String aStr = simpleModelBean.getaStr();
        String anotherAStr = anotherSimpleModeBean.getaStr();
        assertTrue("Objects aren't equals", aStr != null && anotherAStr != null && aStr.equals(anotherAStr) &&
                simpleModelBean.getI() == anotherSimpleModeBean.getI());
    }

    //Task 2  Exercise 4 - alternate using overrided Object.equals()
    @Test
    public void equalityTestUsingOverridedEquals() {
        assertTrue("Objects aren't equals", simpleModelBean != null && simpleModelBean.equals(anotherSimpleModeBean));
    }
}