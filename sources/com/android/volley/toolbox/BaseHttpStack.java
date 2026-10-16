package com.android.volley.toolbox;

import com.android.volley.Header;
import com.android.volley.Request;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseHttpStack implements HttpStack {
    @Override // com.android.volley.toolbox.HttpStack
    public final org.apache.http.HttpResponse a(Request request, Map map) {
        HttpResponse httpResponseB = b(request, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), httpResponseB.d(), ""));
        ArrayList arrayList = new ArrayList();
        for (Header header : httpResponseB.c()) {
            arrayList.add(new BasicHeader(header.a(), header.b()));
        }
        basicHttpResponse.setHeaders((org.apache.http.Header[]) arrayList.toArray(new org.apache.http.Header[0]));
        InputStream inputStreamA = httpResponseB.a();
        if (inputStreamA != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStreamA);
            basicHttpEntity.setContentLength(httpResponseB.b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }

    public abstract HttpResponse b(Request request, Map map);
}
