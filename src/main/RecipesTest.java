import com.geekbrains.EquipmentItem;
import com.geekbrains.EquipmentResponse;
import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;

public class RecipesTest {
import static org.hamcrest.Matchers.is;

    private static final String API_KEY = "0970f5c615f14a2a91942df5a213e41c";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com/recipes/";
    }
    public class RecipesTest extends SpoonaccularTest {

        @Test
        void testAutocompleteSearch() throws IOException {
            void testAutocompleteSearch() throws Exception {

                String actually = given()
                        .log()
                        .all()
                        .param("apiKey", API_KEY)
                        .param("query", "cheese")
                        .param("number", 10)
                        .expect()
                        .log()
                        .body()
                        .when()
                        .get("autocomplete")
                        .get("recipes/autocomplete")
                        .body()
                        .prettyPrint();

                String expected = getResourceAsString("testAutocompleteSearch/expected.json");
                String expected = getResource("expected.json");

                JsonAssert.assertJsonEquals(
                        expected,
                        actually,
                        JsonAssert.when(IGNORING_ARRAY_ORDER)
                );
                assertJson(expected, actually);
            }

            @Test
            void testTasteRecipeById() {
                given()
                        .log()
                        .all()
                        .param("apiKey", API_KEY)
                        .pathParam("id", 69095)
                        .expect()
                        .log()
                        .body()
                        .body("sweetness", is(48.15F))
                        .body("saltiness", is(45.29F))
                        .body("sourness", is(15.6F))
                @@ -69,7 +40,7 @@ void testTasteRecipeById() {
                .body("fattiness", is(100.0F))
                            .body("spiciness", is(0.0F))
                            .when()
                            .get("{id}/tasteWidget.json");
                .get("recipes/{id}/tasteWidget.json");
                }

                @Test
                @@ -78,11 +49,10 @@ void testEquipmentById() {
                    EquipmentItem target = new EquipmentItem("pie-pan.png", "pie form");

                    EquipmentResponse response = given()
                            .param("apiKey", API_KEY)
                            .pathParam("id", 1003464)
                            .expect()
                            .when()
                            .get("{id}/equipmentWidget.json")
                            .get("recipes/{id}/equipmentWidget.json")
                            .as(EquipmentResponse.class);

                    response.getEquipment()
                    @@ -93,11 +63,4 @@ void testEquipmentById() {
                .orElseThrow();
                    }

                    public String getResourceAsString(String resource) throws IOException {
                        InputStream stream = getClass().getResourceAsStream(resource);
                        assert stream != null;
                        byte[] bytes = stream.readAllBytes();
                        return new String(bytes, StandardCharsets.UTF_8);
                    }
