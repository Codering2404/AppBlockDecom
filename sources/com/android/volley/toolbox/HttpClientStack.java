package com.android.volley.toolbox;

import com.android.volley.Request;
import java.net.URI;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class HttpClientStack implements HttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HttpClient f57790a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public HttpPatch(String str) {
            setURI(URI.create(str));
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }
    }

    static HttpUriRequest b(Request request, Map map) {
        switch (request.o()) {
            case -1:
                byte[] bArrR = request.r();
                if (bArrR == null) {
                    return new HttpGet(request.z());
                }
                HttpPost httpPost = new HttpPost(request.z());
                httpPost.addHeader("Content-Type", request.s());
                httpPost.setEntity(new ByteArrayEntity(bArrR));
                return httpPost;
            case 0:
                return new HttpGet(request.z());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.z());
                httpPost2.addHeader("Content-Type", request.k());
                d(httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.z());
                httpPut.addHeader("Content-Type", request.k());
                d(httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.z());
            case 4:
                return new HttpHead(request.z());
            case 5:
                return new HttpOptions(request.z());
            case 6:
                return new HttpTrace(request.z());
            case 7:
                HttpPatch httpPatch = new HttpPatch(request.z());
                httpPatch.addHeader("Content-Type", request.k());
                d(httpPatch, request);
                return httpPatch;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void d(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request request) {
        byte[] bArrJ = request.j();
        if (bArrJ != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrJ));
        }
    }

    private static void e(HttpUriRequest httpUriRequest, Map map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    @Override // com.android.volley.toolbox.HttpStack
    public org.apache.http.HttpResponse a(Request request, Map map) {
        HttpUriRequest httpUriRequestB = b(request, map);
        e(httpUriRequestB, map);
        e(httpUriRequestB, request.n());
        c(httpUriRequestB);
        HttpParams params = httpUriRequestB.getParams();
        int iX = request.x();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, iX);
        return this.f57790a.execute(httpUriRequestB);
    }

    protected void c(HttpUriRequest httpUriRequest) {
    }
}
