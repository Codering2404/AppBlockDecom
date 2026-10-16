package com.applovin.impl;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.impl.pa;
import com.facebook.GraphRequest;
import com.facebook.ads.AdError;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c6 extends a2 implements pa {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f58827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f58828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f58829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f58830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final pa.f f58831i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final pa.f f58832j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f58833k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Predicate f58834l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private k5 f58835m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HttpURLConnection f58836n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private InputStream f58837o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f58838p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f58839q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f58840r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f58841s;

    private c6(String str, int i3, int i4, boolean z2, pa.f fVar, Predicate predicate, boolean z3) {
        super(true);
        this.f58830h = str;
        this.f58828f = i3;
        this.f58829g = i4;
        this.f58827e = z2;
        this.f58831i = fVar;
        this.f58834l = predicate;
        this.f58832j = new pa.f();
        this.f58833k = z3;
    }

    private URL a(URL url, String str, k5 k5Var) throws pa.c {
        if (str == null) {
            throw new pa.c("Null location redirect", k5Var, AdError.INTERNAL_ERROR_CODE, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new pa.c("Unsupported protocol redirect: " + protocol, k5Var, AdError.INTERNAL_ERROR_CODE, 1);
            }
            if (this.f58827e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new pa.c("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", k5Var, AdError.INTERNAL_ERROR_CODE, 1);
        } catch (MalformedURLException e3) {
            throw new pa.c(e3, k5Var, AdError.INTERNAL_ERROR_CODE, 1);
        }
    }

    private HttpURLConnection d(k5 k5Var) throws IOException {
        HttpURLConnection httpURLConnectionA;
        URL url = new URL(k5Var.f60912a.toString());
        int i3 = k5Var.f60914c;
        byte[] bArr = k5Var.f60915d;
        long j3 = k5Var.f60918g;
        long j4 = k5Var.f60919h;
        int i4 = 1;
        boolean zB = k5Var.b(1);
        if (!this.f58827e && !this.f58833k) {
            return a(url, i3, bArr, j3, j4, zB, true, k5Var.f60916e);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (i5 > 20) {
                throw new pa.c(new NoRouteToHostException("Too many redirects: " + i6), k5Var, AdError.INTERNAL_ERROR_CODE, 1);
            }
            httpURLConnectionA = a(url, i3, bArr, j3, j4, zB, false, k5Var.f60916e);
            int responseCode = httpURLConnectionA.getResponseCode();
            String headerField = httpURLConnectionA.getHeaderField("Location");
            if ((i3 == i4 || i3 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionA.disconnect();
                url = a(url, headerField, k5Var);
            } else {
                if (i3 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionA.disconnect();
                if (!this.f58833k || responseCode != 302) {
                    bArr = null;
                    i3 = 1;
                }
                url = a(url, headerField, k5Var);
            }
            i5 = i6;
            i4 = 1;
        }
        return httpURLConnectionA;
    }

    private void h() {
        HttpURLConnection httpURLConnection = this.f58836n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e3) {
                oc.a("DefaultHttpDataSource", "Unexpected error while disconnecting", e3);
            }
            this.f58836n = null;
        }
    }

    @Override // com.applovin.impl.h5
    public Uri c() {
        HttpURLConnection httpURLConnection = this.f58836n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.applovin.impl.h5
    public void close() {
        try {
            InputStream inputStream = this.f58837o;
            if (inputStream != null) {
                long j3 = this.f58840r;
                long j4 = -1;
                if (j3 != -1) {
                    j4 = j3 - this.f58841s;
                }
                a(this.f58836n, j4);
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    throw new pa.c(e3, (k5) xp.a(this.f58835m), AdError.SERVER_ERROR_CODE, 3);
                }
            }
        } finally {
            this.f58837o = null;
            h();
            if (this.f58838p) {
                this.f58838p = false;
                g();
            }
        }
    }

    @Override // com.applovin.impl.h5
    public Map e() {
        HttpURLConnection httpURLConnection = this.f58836n;
        return httpURLConnection == null ? Collections.EMPTY_MAP : httpURLConnection.getHeaderFields();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements pa.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private xo f58843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Predicate f58844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f58845d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f58848g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f58849h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final pa.f f58842a = new pa.f();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f58846e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f58847f = 8000;

        @Override // com.applovin.impl.pa.b, com.applovin.impl.h5.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c6 a() {
            c6 c6Var = new c6(this.f58845d, this.f58846e, this.f58847f, this.f58848g, this.f58842a, this.f58844c, this.f58849h);
            xo xoVar = this.f58843b;
            if (xoVar != null) {
                c6Var.a(xoVar);
            }
            return c6Var;
        }

        public b a(String str) {
            this.f58845d = str;
            return this;
        }
    }

    private int e(byte[] bArr, int i3, int i4) throws IOException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f58840r;
        if (j3 != -1) {
            long j4 = j3 - this.f58841s;
            if (j4 == 0) {
                return -1;
            }
            i4 = (int) Math.min(i4, j4);
        }
        int i5 = ((InputStream) xp.a((Object) this.f58837o)).read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        this.f58841s += (long) i5;
        d(i5);
        return i5;
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(GraphRequest.CONTENT_ENCODING_HEADER));
    }

    private HttpURLConnection a(URL url, int i3, byte[] bArr, long j3, long j4, boolean z2, boolean z3, Map map) throws IOException {
        HttpURLConnection httpURLConnectionA = a(url);
        httpURLConnectionA.setConnectTimeout(this.f58828f);
        httpURLConnectionA.setReadTimeout(this.f58829g);
        HashMap map2 = new HashMap();
        pa.f fVar = this.f58831i;
        if (fVar != null) {
            map2.putAll(fVar.a());
        }
        map2.putAll(this.f58832j.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionA.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = ra.a(j3, j4);
        if (strA != null) {
            httpURLConnectionA.setRequestProperty("Range", strA);
        }
        String str = this.f58830h;
        if (str != null) {
            httpURLConnectionA.setRequestProperty(GraphRequest.USER_AGENT_HEADER, str);
        }
        httpURLConnectionA.setRequestProperty("Accept-Encoding", z2 ? "gzip" : "identity");
        httpURLConnectionA.setInstanceFollowRedirects(z3);
        httpURLConnectionA.setDoOutput(bArr != null);
        httpURLConnectionA.setRequestMethod(k5.a(i3));
        if (bArr != null) {
            httpURLConnectionA.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionA.connect();
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            return httpURLConnectionA;
        }
        httpURLConnectionA.connect();
        return httpURLConnectionA;
    }

    private static void a(HttpURLConnection httpURLConnection, long j3) {
        int i3;
        if (httpURLConnection == null || (i3 = xp.f65027a) < 19 || i3 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j3 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j3 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) b1.a(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.applovin.impl.h5
    public long a(k5 k5Var) throws pa.c {
        byte[] bArrA;
        this.f58835m = k5Var;
        long j3 = 0;
        this.f58841s = 0L;
        this.f58840r = 0L;
        b(k5Var);
        try {
            HttpURLConnection httpURLConnectionD = d(k5Var);
            this.f58836n = httpURLConnectionD;
            this.f58839q = httpURLConnectionD.getResponseCode();
            String responseMessage = httpURLConnectionD.getResponseMessage();
            int i3 = this.f58839q;
            if (i3 >= 200 && i3 <= 299) {
                String contentType = httpURLConnectionD.getContentType();
                Predicate predicate = this.f58834l;
                if (predicate != null && !predicate.apply(contentType)) {
                    h();
                    throw new pa.d(contentType, k5Var);
                }
                if (this.f58839q == 200) {
                    long j4 = k5Var.f60918g;
                    if (j4 != 0) {
                        j3 = j4;
                    }
                }
                boolean zA = a(httpURLConnectionD);
                if (!zA) {
                    long j5 = k5Var.f60919h;
                    if (j5 != -1) {
                        this.f58840r = j5;
                    } else {
                        long jA = ra.a(httpURLConnectionD.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionD.getHeaderField("Content-Range"));
                        this.f58840r = jA != -1 ? jA - j3 : -1L;
                    }
                } else {
                    this.f58840r = k5Var.f60919h;
                }
                try {
                    this.f58837o = httpURLConnectionD.getInputStream();
                    if (zA) {
                        this.f58837o = new GZIPInputStream(this.f58837o);
                    }
                    this.f58838p = true;
                    c(k5Var);
                    try {
                        a(j3, k5Var);
                        return this.f58840r;
                    } catch (IOException e3) {
                        h();
                        if (e3 instanceof pa.c) {
                            throw ((pa.c) e3);
                        }
                        throw new pa.c(e3, k5Var, AdError.SERVER_ERROR_CODE, 1);
                    }
                } catch (IOException e4) {
                    h();
                    throw new pa.c(e4, k5Var, AdError.SERVER_ERROR_CODE, 1);
                }
            }
            Map<String, List<String>> headerFields = httpURLConnectionD.getHeaderFields();
            if (this.f58839q == 416) {
                if (k5Var.f60918g == ra.a(httpURLConnectionD.getHeaderField("Content-Range"))) {
                    this.f58838p = true;
                    c(k5Var);
                    long j6 = k5Var.f60919h;
                    if (j6 != -1) {
                        return j6;
                    }
                    return 0L;
                }
            }
            InputStream errorStream = httpURLConnectionD.getErrorStream();
            try {
                if (errorStream != null) {
                    bArrA = xp.a(errorStream);
                } else {
                    bArrA = xp.f65032f;
                }
            } catch (IOException unused) {
                bArrA = xp.f65032f;
            }
            byte[] bArr = bArrA;
            h();
            throw new pa.e(this.f58839q, responseMessage, this.f58839q == 416 ? new i5(AdError.REMOTE_ADS_SERVICE_ERROR) : null, headerFields, k5Var, bArr);
        } catch (IOException e5) {
            h();
            throw pa.c.a(e5, k5Var, 1);
        }
    }

    HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    @Override // com.applovin.impl.f5
    public int a(byte[] bArr, int i3, int i4) throws pa.c {
        try {
            return e(bArr, i3, i4);
        } catch (IOException e3) {
            throw pa.c.a(e3, (k5) xp.a(this.f58835m), 2);
        }
    }

    private void a(long j3, k5 k5Var) throws IOException {
        if (j3 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j3 > 0) {
            int i3 = ((InputStream) xp.a((Object) this.f58837o)).read(bArr, 0, (int) Math.min(j3, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new pa.c(new InterruptedIOException(), k5Var, AdError.SERVER_ERROR_CODE, 1);
            }
            if (i3 != -1) {
                j3 -= (long) i3;
                d(i3);
            } else {
                throw new pa.c(k5Var, AdError.REMOTE_ADS_SERVICE_ERROR, 1);
            }
        }
    }
}
