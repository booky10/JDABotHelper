package tk.booky.jdahelper.api.event.events.other;
// Created by booky10 in JDABotHelper (21:52 30.09.20)

import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.data.DataArray;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.requests.Route;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import tk.booky.jdahelper.api.event.api.Event;

import java.util.Set;

public class HTTPRequestEvent extends Event {

    private final Request<?> request;
    private final Response response;

    public HTTPRequestEvent(Request<?> request, Response response) {
        super(request.getJDA());
        this.request = request;
        this.response = response;
    }

    public Request<?> getRequest() {
        return request;
    }

    public RequestBody getRequestBody() {
        return request.getBody();
    }

    public Object getRequestBodyRaw() {
        return request.getRawBody();
    }

    public Headers getRequestHeaders() {
        return response.getRawResponse() == null ? null : response.getRawResponse().request().headers();
    }

    public okhttp3.Request getRequestRaw() {
        return response.getRawResponse() == null ? null : response.getRawResponse().request();
    }

    public RestAction<?> getRestAction() {
        return this.request.getRestAction();
    }

    public Route.CompiledRoute getRoute() {
        return request.getRoute();
    }

    public Response getResponse() {
        return response;
    }

    public ResponseBody getResponseBody() {
        return response.getRawResponse() == null ? null : response.getRawResponse().body();
    }

    public DataArray getResponseBodyAsArray() {
        return response.getArray();
    }

    public DataObject getResponseBodyAsObject() {
        return response.getObject();
    }

    public String getResponseBodyAsString() {
        return response.getString();
    }

    public Headers getResponseHeaders() {
        return response.getRawResponse() == null ? null : response.getRawResponse().headers();
    }

    public okhttp3.Response getResponseRaw() {
        return response.getRawResponse();
    }

    public Set<String> getCFRays() {
        return response.getCFRays();
    }

    public boolean isRateLimit() {
        return response.isRateLimit();
    }
}