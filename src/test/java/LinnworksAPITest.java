import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LinnworksAPITest implements IsEmptyInterface {
    @Test
    public void testIndex() {
        try {
            HttpResponse<JsonNode> stringHttpResponse = getJsonNodeHttpResponse();
            int status = stringHttpResponse.getStatus();
            String statusText = stringHttpResponse.getStatusText();
            Assert.assertEquals(200, status);
            Assert.assertEquals("OK", statusText);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetIndex() throws UnirestException {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Content-Type", "application/json-patch+json");
            headers.put("Cookie", "Idea-83474ee0=2407a469-9f49-4bd7-b67e-cb55b6c6d1e6; .AspNetCore.Cookies=CfDJ8MKe7l1XhJ5PtQz7v8JSbSVQRXOi565jWNFA8U6Cl03Va28-53t2yeFnzgKw5mMPCR1f6mNcSVaVLBLfm4RHH98L4jleNsgaGFbVAln3cuuoqjFvlQpyS981-5zeeYTgZxKZUX8P-8fEnZw3uIslo953Ei3ILsoqHYZAnKMx1T3f6_tASREwqCjSqKJL2fm-c6aCuVETfMeRfboseb8rjdwhc3Z6cABzIos30iErNe7SxhFY60e_PZRkiyNoAgaZSzJo81t3eqYP3IekGDT1GAP--NSuhniAgIo7nMvDDC1Hr7OdVLkrHFVPZKKgm1ftZO5mgNzaR7ZHFAH89Go_zOo");
            JsonArray jsonElements = new Gson().fromJson(getJsonNodeHttpResponse().getBody().toString(), JsonArray.class);
            isEmpty("Category 2");
            jsonElements.forEach(jsonElement -> {
                try {
                    String categoryId = jsonElement.getAsJsonObject().get("categoryId").getAsString();
                    HttpResponse<String> jsonNodeHttpResponse = Unirest
                            .get("http://localhost:59509/api/Category/Details/" + categoryId)
                            .headers(headers)
                            .asString();
                    int status = jsonNodeHttpResponse.getStatus();
                    String statusText = jsonNodeHttpResponse.getStatusText();
                    Assert.assertEquals(200, status);
                    Assert.assertEquals("OK", statusText);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            });
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Content-Type", "application/json-patch+json");
            headers.put("Cookie", "Idea-83474ee0=2407a469-9f49-4bd7-b67e-cb55b6c6d1e6; .AspNetCore.Cookies=CfDJ8MKe7l1XhJ5PtQz7v8JSbSVQRXOi565jWNFA8U6Cl03Va28-53t2yeFnzgKw5mMPCR1f6mNcSVaVLBLfm4RHH98L4jleNsgaGFbVAln3cuuoqjFvlQpyS981-5zeeYTgZxKZUX8P-8fEnZw3uIslo953Ei3ILsoqHYZAnKMx1T3f6_tASREwqCjSqKJL2fm-c6aCuVETfMeRfboseb8rjdwhc3Z6cABzIos30iErNe7SxhFY60e_PZRkiyNoAgaZSzJo81t3eqYP3IekGDT1GAP--NSuhniAgIo7nMvDDC1Hr7OdVLkrHFVPZKKgm1ftZO5mgNzaR7ZHFAH89Go_zOo");
            JsonArray jsonElements = new Gson().fromJson(getJsonNodeHttpResponse().getBody().toString(), JsonArray.class);
            isEmpty("Category 2");
            jsonElements.forEach(jsonElement -> {
                try {
                    String categoryId = jsonElement.getAsJsonObject().get("categoryId").getAsString();
                    HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest
                            .post("http://localhost:59509/api/Category/Create")
                            .headers(headers)
                            .body("{\n" +
                                    "  \"categoryId\": \"" + categoryId + "\",\n" +
                                    "  \"categoryName\": \"test\"\n" +
                                    "}")
                            .asJson();
                    int status = jsonNodeHttpResponse.getStatus();
                    String statusText = jsonNodeHttpResponse.getStatusText();
                    Assert.assertEquals(200, status);
                    Assert.assertEquals("OK", statusText);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            });

        } catch (JsonSyntaxException | UnirestException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Content-Type", "application/json-patch+json");
            headers.put("Cookie", "Idea-83474ee0=2407a469-9f49-4bd7-b67e-cb55b6c6d1e6; .AspNetCore.Cookies=CfDJ8MKe7l1XhJ5PtQz7v8JSbSVQRXOi565jWNFA8U6Cl03Va28-53t2yeFnzgKw5mMPCR1f6mNcSVaVLBLfm4RHH98L4jleNsgaGFbVAln3cuuoqjFvlQpyS981-5zeeYTgZxKZUX8P-8fEnZw3uIslo953Ei3ILsoqHYZAnKMx1T3f6_tASREwqCjSqKJL2fm-c6aCuVETfMeRfboseb8rjdwhc3Z6cABzIos30iErNe7SxhFY60e_PZRkiyNoAgaZSzJo81t3eqYP3IekGDT1GAP--NSuhniAgIo7nMvDDC1Hr7OdVLkrHFVPZKKgm1ftZO5mgNzaR7ZHFAH89Go_zOo");
            JsonArray jsonElements = new Gson().fromJson(getJsonNodeHttpResponse().getBody().toString(), JsonArray.class);
            jsonElements.forEach(jsonElement -> {
                try {
                    String categoryId = jsonElement.getAsJsonObject().get("categoryId").getAsString();
                    HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest
                            .delete("http://localhost:59509/api/Category/Delete/" + categoryId)
                            .headers(headers)
                            .asJson();
                    int status = jsonNodeHttpResponse.getStatus();
                    String statusText = jsonNodeHttpResponse.getStatusText();
                    Assert.assertEquals(200, status);
                    Assert.assertEquals("OK", statusText);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            });
        } catch (JsonSyntaxException | UnirestException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEdit() throws UnirestException {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Content-Type", "application/json-patch+json");
            headers.put("Cookie", "Idea-83474ee0=2407a469-9f49-4bd7-b67e-cb55b6c6d1e6; .AspNetCore.Cookies=CfDJ8MKe7l1XhJ5PtQz7v8JSbSVQRXOi565jWNFA8U6Cl03Va28-53t2yeFnzgKw5mMPCR1f6mNcSVaVLBLfm4RHH98L4jleNsgaGFbVAln3cuuoqjFvlQpyS981-5zeeYTgZxKZUX8P-8fEnZw3uIslo953Ei3ILsoqHYZAnKMx1T3f6_tASREwqCjSqKJL2fm-c6aCuVETfMeRfboseb8rjdwhc3Z6cABzIos30iErNe7SxhFY60e_PZRkiyNoAgaZSzJo81t3eqYP3IekGDT1GAP--NSuhniAgIo7nMvDDC1Hr7OdVLkrHFVPZKKgm1ftZO5mgNzaR7ZHFAH89Go_zOo");
            JsonArray jsonElements = new Gson().fromJson(getJsonNodeHttpResponse().getBody().toString(), JsonArray.class);
            isEmpty("Category 2");
            jsonElements.forEach(jsonElement -> {
                try {
                    String categoryId = jsonElement.getAsJsonObject().get("categoryId").getAsString();
                    HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest
                            .put("http://localhost:59509/api/Category/Edit")
                            .headers(headers)
                            .body("{\n" +
                                    "  \"categoryId\": \"" + categoryId + "\",\n" +
                                    "  \"categoryName\": \"test123\"\n" +
                                    "}")
                            .asJson();
                    int status = jsonNodeHttpResponse.getStatus();
                    String statusText = jsonNodeHttpResponse.getStatusText();
                    Assert.assertEquals(200, status);
                    Assert.assertEquals("OK", statusText);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
            });
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }



}