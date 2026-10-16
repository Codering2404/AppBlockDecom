package com.android.volley.toolbox;

import com.android.volley.Request;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class AdaptedHttpStack extends BaseHttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpStack f57738a;

    @Override // com.android.volley.toolbox.BaseHttpStack
    public HttpResponse b(Request request, Map map) throws IOException {
        try {
            org.apache.http.HttpResponse httpResponseA = this.f57738a.a(request, map);
            int statusCode = httpResponseA.getStatusLine().getStatusCode();
            Header[] allHeaders = httpResponseA.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new com.android.volley.Header(header.getName(), header.getValue()));
            }
            if (httpResponseA.getEntity() == null) {
                return new HttpResponse(statusCode, arrayList);
            }
            long contentLength = httpResponseA.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new HttpResponse(statusCode, arrayList, (int) httpResponseA.getEntity().getContentLength(), httpResponseA.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e3) {
            throw new SocketTimeoutException(e3.getMessage());
        }
    }
}
