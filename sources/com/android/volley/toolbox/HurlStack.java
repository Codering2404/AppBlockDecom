package com.android.volley.toolbox;

import com.android.volley.Header;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HurlStack extends BaseHttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UrlRewriter f57796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f57797b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UrlConnectionInputStream extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f57798a;

        UrlConnectionInputStream(HttpURLConnection httpURLConnection) {
            super(HurlStack.k(httpURLConnection));
            this.f57798a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f57798a.disconnect();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UrlRewriter extends com.android.volley.toolbox.UrlRewriter {
    }

    public HurlStack() {
        this(null);
    }

    private void d(HttpURLConnection httpURLConnection, Request request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.k());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(i(request, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private void e(HttpURLConnection httpURLConnection, Request request) throws IOException {
        byte[] bArrJ = request.j();
        if (bArrJ != null) {
            d(httpURLConnection, request, bArrJ);
        }
    }

    static List f(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new Header((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    private static boolean j(int i3, int i4) {
        if (i3 != 4) {
            return ((100 <= i4 && i4 < 200) || i4 == 204 || i4 == 304) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream k(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection l(URL url, Request request) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionG = g(url);
        int iX = request.x();
        httpURLConnectionG.setConnectTimeout(iX);
        httpURLConnectionG.setReadTimeout(iX);
        httpURLConnectionG.setUseCaches(false);
        httpURLConnectionG.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f57797b) != null) {
            ((HttpsURLConnection) httpURLConnectionG).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionG;
    }

    @Override // com.android.volley.toolbox.BaseHttpStack
    public HttpResponse b(Request request, Map map) throws IOException {
        String strZ = request.z();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(request.n());
        UrlRewriter urlRewriter = this.f57796a;
        if (urlRewriter != null) {
            String strA = urlRewriter.a(strZ);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strZ);
            }
            strZ = strA;
        }
        HttpURLConnection httpURLConnectionL = l(new URL(strZ), request);
        try {
            for (String str : map2.keySet()) {
                httpURLConnectionL.setRequestProperty(str, (String) map2.get(str));
            }
            m(httpURLConnectionL, request);
            int responseCode = httpURLConnectionL.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (j(request.o(), responseCode)) {
                return new HttpResponse(responseCode, f(httpURLConnectionL.getHeaderFields()), httpURLConnectionL.getContentLength(), h(request, httpURLConnectionL));
            }
            HttpResponse httpResponse = new HttpResponse(responseCode, f(httpURLConnectionL.getHeaderFields()));
            httpURLConnectionL.disconnect();
            return httpResponse;
        } catch (Throwable th) {
            if (0 == 0) {
                httpURLConnectionL.disconnect();
            }
            throw th;
        }
    }

    protected HttpURLConnection g(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    protected InputStream h(Request request, HttpURLConnection httpURLConnection) {
        return new UrlConnectionInputStream(httpURLConnection);
    }

    protected OutputStream i(Request request, HttpURLConnection httpURLConnection, int i3) {
        return httpURLConnection.getOutputStream();
    }

    void m(HttpURLConnection httpURLConnection, Request request) throws IOException {
        switch (request.o()) {
            case -1:
                byte[] bArrR = request.r();
                if (bArrR != null) {
                    httpURLConnection.setRequestMethod("POST");
                    d(httpURLConnection, request, bArrR);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                e(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                e(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                e(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.f57796a = urlRewriter;
        this.f57797b = sSLSocketFactory;
    }
}
