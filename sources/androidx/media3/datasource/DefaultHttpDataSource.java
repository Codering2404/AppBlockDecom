package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.HttpDataSource;
import com.facebook.GraphRequest;
import com.facebook.ads.AdError;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f41867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f41868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f41869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f41870h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f41871i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HttpDataSource.RequestProperties f41872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HttpDataSource.RequestProperties f41873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Predicate f41874l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f41875m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private DataSpec f41876n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private HttpURLConnection f41877o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private InputStream f41878p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f41879q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f41880r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f41881s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f41882t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements HttpDataSource.Factory {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TransferListener f41884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Predicate f41885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f41886d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f41889g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f41890h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f41891i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpDataSource.RequestProperties f41883a = new HttpDataSource.RequestProperties();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f41887e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f41888f = 8000;

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DefaultHttpDataSource a() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.f41886d, this.f41887e, this.f41888f, this.f41889g, this.f41890h, this.f41883a, this.f41885c, this.f41891i);
            TransferListener transferListener = this.f41884b;
            if (transferListener != null) {
                defaultHttpDataSource.c(transferListener);
            }
            return defaultHttpDataSource;
        }

        public Factory c(boolean z2) {
            this.f41889g = z2;
            return this;
        }

        public Factory d(int i3) {
            this.f41887e = i3;
            return this;
        }

        public Factory e(int i3) {
            this.f41888f = i3;
            return this;
        }

        public Factory f(String str) {
            this.f41886d = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f41892a;

        public NullFilteringHeadersMap(Map map) {
            this.f41892a = map;
        }

        public static /* synthetic */ boolean c2(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public static /* synthetic */ boolean g2(String str) {
            return str != null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Map I1() {
            return this.f41892a;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean containsValue(Object obj) {
            return super.S1(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set entrySet() {
            return Sets.d(super.entrySet(), new Predicate() { // from class: androidx.media3.datasource.e
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultHttpDataSource.NullFilteringHeadersMap.c2((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean equals(Object obj) {
            return obj != null && super.T1(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public int hashCode() {
            return super.V1();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean isEmpty() {
            return super.isEmpty() || (super.size() == 1 && super.containsKey(null));
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set keySet() {
            return Sets.d(super.keySet(), new Predicate() { // from class: androidx.media3.datasource.f
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultHttpDataSource.NullFilteringHeadersMap.g2((String) obj);
                }
            });
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public List get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    private void r() {
        HttpURLConnection httpURLConnection = this.f41877o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e3) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e3);
            }
        }
    }

    private URL s(URL url, String str, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec, AdError.INTERNAL_ERROR_CODE, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec, AdError.INTERNAL_ERROR_CODE, 1);
            }
            if (this.f41867e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            if (this.f41868f) {
                try {
                    return new URL(url2.toString().replaceFirst(protocol, url.getProtocol()));
                } catch (MalformedURLException e3) {
                    throw new HttpDataSource.HttpDataSourceException(e3, dataSpec, AdError.INTERNAL_ERROR_CODE, 1);
                }
            }
            throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, AdError.INTERNAL_ERROR_CODE, 1);
        } catch (MalformedURLException e4) {
            throw new HttpDataSource.HttpDataSourceException(e4, dataSpec, AdError.INTERNAL_ERROR_CODE, 1);
        }
    }

    private static boolean t(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(GraphRequest.CONTENT_ENCODING_HEADER));
    }

    private HttpURLConnection u(DataSpec dataSpec) throws IOException {
        HttpURLConnection httpURLConnectionV;
        URL url = new URL(dataSpec.f41829a.toString());
        int i3 = dataSpec.f41831c;
        byte[] bArr = dataSpec.f41832d;
        long j3 = dataSpec.f41835g;
        long j4 = dataSpec.f41836h;
        int i4 = 1;
        boolean zD = dataSpec.d(1);
        if (!this.f41867e && !this.f41868f && !this.f41875m) {
            return v(url, i3, bArr, j3, j4, zD, true, dataSpec.f41833e);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (i5 > 20) {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i6), dataSpec, AdError.INTERNAL_ERROR_CODE, 1);
            }
            httpURLConnectionV = v(url, i3, bArr, j3, j4, zD, false, dataSpec.f41833e);
            int responseCode = httpURLConnectionV.getResponseCode();
            String headerField = httpURLConnectionV.getHeaderField("Location");
            if ((i3 == i4 || i3 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionV.disconnect();
                url = s(url, headerField, dataSpec);
            } else {
                if (i3 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionV.disconnect();
                if (!this.f41875m || responseCode != 302) {
                    bArr = null;
                    i3 = 1;
                }
                url = s(url, headerField, dataSpec);
            }
            i5 = i6;
            i4 = 1;
        }
        return httpURLConnectionV;
    }

    private HttpURLConnection v(URL url, int i3, byte[] bArr, long j3, long j4, boolean z2, boolean z3, Map map) throws IOException {
        HttpURLConnection httpURLConnectionW = w(url);
        httpURLConnectionW.setConnectTimeout(this.f41869g);
        httpURLConnectionW.setReadTimeout(this.f41870h);
        HashMap map2 = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f41872j;
        if (requestProperties != null) {
            map2.putAll(requestProperties.a());
        }
        map2.putAll(this.f41873k.a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionW.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = HttpUtil.a(j3, j4);
        if (strA != null) {
            httpURLConnectionW.setRequestProperty("Range", strA);
        }
        String str = this.f41871i;
        if (str != null) {
            httpURLConnectionW.setRequestProperty(GraphRequest.USER_AGENT_HEADER, str);
        }
        httpURLConnectionW.setRequestProperty("Accept-Encoding", z2 ? "gzip" : "identity");
        httpURLConnectionW.setInstanceFollowRedirects(z3);
        httpURLConnectionW.setDoOutput(bArr != null);
        httpURLConnectionW.setRequestMethod(DataSpec.c(i3));
        if (bArr == null) {
            httpURLConnectionW.connect();
            return httpURLConnectionW;
        }
        httpURLConnectionW.setFixedLengthStreamingMode(bArr.length);
        httpURLConnectionW.connect();
        OutputStream outputStream = httpURLConnectionW.getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
        return httpURLConnectionW;
    }

    private int x(byte[] bArr, int i3, int i4) throws IOException {
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f41881s;
        if (j3 != -1) {
            long j4 = j3 - this.f41882t;
            if (j4 == 0) {
                return -1;
            }
            i4 = (int) Math.min(i4, j4);
        }
        int i5 = ((InputStream) Util.k(this.f41878p)).read(bArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        this.f41882t += (long) i5;
        n(i5);
        return i5;
    }

    private void y(long j3, DataSpec dataSpec) throws IOException {
        if (j3 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j3 > 0) {
            int i3 = ((InputStream) Util.k(this.f41878p)).read(bArr, 0, (int) Math.min(j3, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), dataSpec, AdError.SERVER_ERROR_CODE, 1);
            }
            if (i3 == -1) {
                throw new HttpDataSource.HttpDataSourceException(dataSpec, AdError.REMOTE_ADS_SERVICE_ERROR, 1);
            }
            j3 -= (long) i3;
            n(i3);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrJ;
        this.f41876n = dataSpec;
        long j3 = 0;
        this.f41882t = 0L;
        this.f41881s = 0L;
        p(dataSpec);
        try {
            HttpURLConnection httpURLConnectionU = u(dataSpec);
            this.f41877o = httpURLConnectionU;
            this.f41880r = httpURLConnectionU.getResponseCode();
            String responseMessage = httpURLConnectionU.getResponseMessage();
            int i3 = this.f41880r;
            if (i3 < 200 || i3 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionU.getHeaderFields();
                if (this.f41880r == 416) {
                    if (dataSpec.f41835g == HttpUtil.c(httpURLConnectionU.getHeaderField("Content-Range"))) {
                        this.f41879q = true;
                        q(dataSpec);
                        long j4 = dataSpec.f41836h;
                        if (j4 != -1) {
                            return j4;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionU.getErrorStream();
                try {
                    bArrJ = errorStream != null ? ByteStreams.j(errorStream) : Util.f41614f;
                } catch (IOException unused) {
                    bArrJ = Util.f41614f;
                }
                byte[] bArr = bArrJ;
                r();
                throw new HttpDataSource.InvalidResponseCodeException(this.f41880r, responseMessage, this.f41880r == 416 ? new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR) : null, headerFields, dataSpec, bArr);
            }
            String contentType = httpURLConnectionU.getContentType();
            Predicate predicate = this.f41874l;
            if (predicate != null && !predicate.apply(contentType)) {
                r();
                throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
            }
            if (this.f41880r == 200) {
                long j5 = dataSpec.f41835g;
                if (j5 != 0) {
                    j3 = j5;
                }
            }
            boolean zT = t(httpURLConnectionU);
            if (zT) {
                this.f41881s = dataSpec.f41836h;
            } else {
                long j6 = dataSpec.f41836h;
                if (j6 != -1) {
                    this.f41881s = j6;
                } else {
                    long jB = HttpUtil.b(httpURLConnectionU.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionU.getHeaderField("Content-Range"));
                    this.f41881s = jB != -1 ? jB - j3 : -1L;
                }
            }
            try {
                this.f41878p = httpURLConnectionU.getInputStream();
                if (zT) {
                    this.f41878p = new GZIPInputStream(this.f41878p);
                }
                this.f41879q = true;
                q(dataSpec);
                try {
                    y(j3, dataSpec);
                    return this.f41881s;
                } catch (IOException e3) {
                    r();
                    if (e3 instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e3);
                    }
                    throw new HttpDataSource.HttpDataSourceException(e3, dataSpec, AdError.SERVER_ERROR_CODE, 1);
                }
            } catch (IOException e4) {
                r();
                throw new HttpDataSource.HttpDataSourceException(e4, dataSpec, AdError.SERVER_ERROR_CODE, 1);
            }
        } catch (IOException e5) {
            r();
            throw HttpDataSource.HttpDataSourceException.c(e5, dataSpec, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.datasource.DataSource
    public void close() {
        try {
            InputStream inputStream = this.f41878p;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    throw new HttpDataSource.HttpDataSourceException(e3, (DataSpec) Util.k(this.f41876n), AdError.SERVER_ERROR_CODE, 3);
                }
            }
        } finally {
            this.f41878p = null;
            r();
            if (this.f41879q) {
                this.f41879q = false;
                o();
            }
            this.f41877o = null;
            this.f41876n = null;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        HttpURLConnection httpURLConnection = this.f41877o;
        return httpURLConnection == null ? ImmutableMap.n() : new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f41877o;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        DataSpec dataSpec = this.f41876n;
        if (dataSpec != null) {
            return dataSpec.f41829a;
        }
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws HttpDataSource.HttpDataSourceException {
        try {
            return x(bArr, i3, i4);
        } catch (IOException e3) {
            throw HttpDataSource.HttpDataSourceException.c(e3, (DataSpec) Util.k(this.f41876n), 2);
        }
    }

    HttpURLConnection w(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    private DefaultHttpDataSource(String str, int i3, int i4, boolean z2, boolean z3, HttpDataSource.RequestProperties requestProperties, Predicate predicate, boolean z4) {
        super(true);
        this.f41871i = str;
        this.f41869g = i3;
        this.f41870h = i4;
        this.f41867e = z2;
        this.f41868f = z3;
        if (z2 && z3) {
            throw new IllegalArgumentException("crossProtocolRedirectsForceOriginal should not be set if allowCrossProtocolRedirects is true");
        }
        this.f41872j = requestProperties;
        this.f41874l = predicate;
        this.f41873k = new HttpDataSource.RequestProperties();
        this.f41875m = z4;
    }
}
