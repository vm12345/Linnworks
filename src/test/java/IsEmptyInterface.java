import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public interface IsEmptyInterface {
    default void isEmpty(final String categoryName) throws UnirestException {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json-patch+json");
        headers.put("Cookie", "Idea-83474ee0=2407a469-9f49-4bd7-b67e-cb55b6c6d1e6; .AspNetCore.Cookies=CfDJ8MKe7l1XhJ5PtQz7v8JSbSVQRXOi565jWNFA8U6Cl03Va28-53t2yeFnzgKw5mMPCR1f6mNcSVaVLBLfm4RHH98L4jleNsgaGFbVAln3cuuoqjFvlQpyS981-5zeeYTgZxKZUX8P-8fEnZw3uIslo953Ei3ILsoqHYZAnKMx1T3f6_tASREwqCjSqKJL2fm-c6aCuVETfMeRfboseb8rjdwhc3Z6cABzIos30iErNe7SxhFY60e_PZRkiyNoAgaZSzJo81t3eqYP3IekGDT1GAP--NSuhniAgIo7nMvDDC1Hr7OdVLkrHFVPZKKgm1ftZO5mgNzaR7ZHFAH89Go_zOo");
        JsonArray jsonElements = new Gson().fromJson(getJsonNodeHttpResponse().getBody().toString(), JsonArray.class);
        if (jsonElements.size() == 0) {
            HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest
                    .post("http://localhost:59509/api/Category/Create")
                    .headers(headers)
                    .body("{\n" +
                            "  \"categoryId\": \" b9b8a906-0aa2-4c89-50fd-08d7bfa659f0 \",\n" +
                            "  \"categoryName\": \"" + categoryName + "\"," +
                            "}")
                    .asJson();
            int status = jsonNodeHttpResponse.getStatus();
            String statusText = jsonNodeHttpResponse.getStatusText();
            Assert.assertEquals(200, status);
            Assert.assertEquals("OK", statusText);
        }
    }

    default HttpResponse<JsonNode> getJsonNodeHttpResponse() throws UnirestException {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Cookie", "Idea-83474ee0=2407a469-9f49-4bd7-b67e-cb55b6c6d1e6; .AspNetCore.Cookies=CfDJ8MKe7l1XhJ5PtQz7v8JSbSVQRXOi565jWNFA8U6Cl03Va28-53t2yeFnzgKw5mMPCR1f6mNcSVaVLBLfm4RHH98L4jleNsgaGFbVAln3cuuoqjFvlQpyS981-5zeeYTgZxKZUX8P-8fEnZw3uIslo953Ei3ILsoqHYZAnKMx1T3f6_tASREwqCjSqKJL2fm-c6aCuVETfMeRfboseb8rjdwhc3Z6cABzIos30iErNe7SxhFY60e_PZRkiyNoAgaZSzJo81t3eqYP3IekGDT1GAP--NSuhniAgIo7nMvDDC1Hr7OdVLkrHFVPZKKgm1ftZO5mgNzaR7ZHFAH89Go_zOo");
        return Unirest
                .get("http://localhost:59509/api/Category/Index/")
                .headers(headers)
                .asJson();
    }
}
