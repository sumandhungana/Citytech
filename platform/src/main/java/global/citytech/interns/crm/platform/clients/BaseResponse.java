package global.citytech.interns.crm.platform.clients;

import global.citytech.interns.crm.platform.utils.JsonUtils;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.ws.rs.core.Response;

import java.io.StringReader;

public class BaseResponse {
    private String code;
    private String message;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response ok(Object data) {
        return Response.ok((new BaseResponse("0", "SUCCESS", data)).toJson()).build();
    }

    public static Response ok() {
        return Response.ok((new BaseResponse("0", "SUCCESS", (Object)null)).toJson()).build();
    }

    public static Response errorResponse(String message) {
        return Response.status(Response.Status.BAD_REQUEST).entity((new BaseResponse("500", message, (Object)null)).toJson()).build();
    }

    public static BaseResponse error(String message) {
        return new BaseResponse("400", message, (Object)null);
    }

    public static BaseResponse error(String code, String message) {
        return new BaseResponse(code, message, (Object)null);
    }

    public static Response okWithJsonObject(JsonArrayBuilder data) {
        JsonObject jsonObject = Json.createObjectBuilder().add("code", "0").add("message", "SUCCESS").add("data", data).build();
        return Response.ok(jsonObject).build();
    }

    public static Response okWithJsonObject(JsonObject data) {
        JsonObject jsonObject = Json.createObjectBuilder().add("code", "0").add("message", "SUCCESS").add("data", data).build();
        return Response.ok(jsonObject).build();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonObject toJson() {
        JsonObject object = null;
        JsonValue value = null;
        if (this.data != null) {
            value = Json.createReader(new StringReader(JsonUtils.toJsonObj(this.data))).read();
            return Json.createObjectBuilder().add("code", this.code).add("message", this.message).add("data", value).build();
        } else {
            return Json.createObjectBuilder().add("code", this.code).add("message", this.message).build();
        }
    }
}
