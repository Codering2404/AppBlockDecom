package androidx.media3.datasource;

import android.net.Uri;
import android.net.http.HttpEngine;
import android.net.http.HttpException;
import android.net.http.UrlRequest;
import android.net.http.UrlRequest$Callback;
import android.net.http.UrlRequest$StatusListener;
import android.net.http.UrlResponseInfo;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import com.facebook.GraphRequest;
import com.facebook.ads.AdError;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Longs;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpEngineDataSource extends BaseDataSource implements HttpDataSource {
    private volatile long A;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HttpEngine f41916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f41917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f41918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f41919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f41920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f41921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f41922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f41923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final HttpDataSource.RequestProperties f41924m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final HttpDataSource.RequestProperties f41925n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ConditionVariable f41926o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Clock f41927p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Predicate f41928q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f41929r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f41930s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f41931t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private DataSpec f41932u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private UrlRequestWrapper f41933v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ByteBuffer f41934w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private UrlResponseInfo f41935x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private IOException f41936y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f41937z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements HttpDataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpEngine f41938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f41939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HttpDataSource.RequestProperties f41940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Predicate f41941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TransferListener f41942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f41943f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f41944g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f41945h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f41946i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f41947j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f41948k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f41949l;

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public HttpDataSource a() {
            HttpEngineDataSource httpEngineDataSource = new HttpEngineDataSource(this.f41938a, this.f41939b, this.f41944g, this.f41945h, this.f41946i, this.f41947j, this.f41948k, this.f41943f, this.f41940c, this.f41941d, this.f41949l);
            TransferListener transferListener = this.f41942e;
            if (transferListener != null) {
                httpEngineDataSource.c(transferListener);
            }
            return httpEngineDataSource;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class UrlRequestCallback implements UrlRequest$Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f41951a = false;

        UrlRequestCallback() {
        }

        public void a() {
            this.f41951a = true;
        }

        public synchronized void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public synchronized void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, HttpException httpException) {
            try {
                if (this.f41951a) {
                    return;
                }
                if (x.a(httpException) && y.a(httpException).getErrorCode() == 1) {
                    HttpEngineDataSource.this.f41936y = new UnknownHostException();
                } else {
                    HttpEngineDataSource.this.f41936y = httpException;
                }
                HttpEngineDataSource.this.f41926o.f();
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (this.f41951a) {
                return;
            }
            HttpEngineDataSource.this.f41926o.f();
        }

        public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            if (this.f41951a) {
                return;
            }
            DataSpec dataSpec = (DataSpec) Assertions.e(HttpEngineDataSource.this.f41932u);
            int httpStatusCode = urlResponseInfo.getHttpStatusCode();
            if (dataSpec.f41831c == 2 && (httpStatusCode == 307 || httpStatusCode == 308)) {
                HttpEngineDataSource.this.f41936y = new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfo.getHttpStatusText(), null, urlResponseInfo.getHeaders().getAsMap(), dataSpec, Util.f41614f);
                HttpEngineDataSource.this.f41926o.f();
                return;
            }
            if (HttpEngineDataSource.this.f41921j) {
                HttpEngineDataSource.this.P();
            }
            CookieHandler cookieManager = CookieHandler.getDefault();
            if (cookieManager == null && HttpEngineDataSource.this.f41922k) {
                cookieManager = new CookieManager();
            }
            HttpEngineDataSource.S(urlResponseInfo, cookieManager);
            String strJ = HttpEngineDataSource.J(urlResponseInfo.getUrl(), urlResponseInfo.getHeaders().getAsMap(), cookieManager);
            boolean z2 = HttpEngineDataSource.this.f41929r && dataSpec.f41831c == 2 && httpStatusCode == 302;
            if (!z2 && (!HttpEngineDataSource.this.f41922k || TextUtils.isEmpty(strJ))) {
                urlRequest.followRedirect();
                return;
            }
            urlRequest.cancel();
            DataSpec dataSpecG = (z2 || dataSpec.f41831c != 2) ? dataSpec.g(Uri.parse(str)) : dataSpec.a().j(str).d(1).c(null).a();
            if (!TextUtils.isEmpty(strJ)) {
                HashMap map = new HashMap();
                map.putAll(dataSpec.f41833e);
                map.put("Cookie", strJ);
                dataSpecG = dataSpecG.a().e(map).a();
            }
            try {
                UrlRequestWrapper urlRequestWrapperI = HttpEngineDataSource.this.I(dataSpecG);
                if (HttpEngineDataSource.this.f41933v != null) {
                    HttpEngineDataSource.this.f41933v.a();
                }
                HttpEngineDataSource.this.f41933v = urlRequestWrapperI;
                HttpEngineDataSource.this.f41933v.d();
            } catch (IOException e3) {
                HttpEngineDataSource.this.f41936y = e3;
            }
        }

        public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (this.f41951a) {
                return;
            }
            HttpEngineDataSource.R(urlResponseInfo);
            HttpEngineDataSource.this.f41935x = urlResponseInfo;
            HttpEngineDataSource.this.f41926o.f();
        }

        public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (this.f41951a) {
                return;
            }
            HttpEngineDataSource.this.f41937z = true;
            HttpEngineDataSource.this.f41926o.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UrlRequestWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UrlRequest f41953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UrlRequestCallback f41954b;

        UrlRequestWrapper(UrlRequest urlRequest, UrlRequestCallback urlRequestCallback) {
            this.f41953a = urlRequest;
            this.f41954b = urlRequestCallback;
        }

        public void a() {
            this.f41954b.a();
            this.f41953a.cancel();
        }

        public int b() {
            final ConditionVariable conditionVariable = new ConditionVariable();
            final int[] iArr = new int[1];
            this.f41953a.getStatus(new UrlRequest$StatusListener() { // from class: androidx.media3.datasource.HttpEngineDataSource.UrlRequestWrapper.1
                public void onStatus(int i3) {
                    iArr[0] = i3;
                    conditionVariable.f();
                }
            });
            conditionVariable.a();
            return iArr[0];
        }

        public void c(ByteBuffer byteBuffer) {
            this.f41953a.read(byteBuffer);
        }

        public void d() {
            this.f41953a.start();
        }
    }

    HttpEngineDataSource(HttpEngine httpEngine, Executor executor, int i3, int i4, int i5, boolean z2, boolean z3, String str, HttpDataSource.RequestProperties requestProperties, Predicate predicate, boolean z4) {
        super(true);
        this.f41916e = o.a(Assertions.e(httpEngine));
        this.f41917f = (Executor) Assertions.e(executor);
        this.f41918g = i3;
        this.f41919h = i4;
        this.f41920i = i5;
        this.f41921j = z2;
        this.f41922k = z3;
        this.f41923l = str;
        this.f41924m = requestProperties;
        this.f41928q = predicate;
        this.f41929r = z4;
        this.f41927p = Clock.f41485a;
        this.f41925n = new HttpDataSource.RequestProperties();
        this.f41926o = new ConditionVariable();
    }

    private boolean G() {
        long jA = this.f41927p.a();
        boolean zB = false;
        while (!zB && jA < this.A) {
            zB = this.f41926o.b((this.A - jA) + 5);
            jA = this.f41927p.a();
        }
        return zB;
    }

    private UrlRequest.Builder H(DataSpec dataSpec, UrlRequest$Callback urlRequest$Callback) throws OpenException {
        UrlRequest.Builder directExecutorAllowed = this.f41916e.newUrlRequestBuilder(dataSpec.f41829a.toString(), this.f41917f, urlRequest$Callback).setPriority(this.f41918g).setDirectExecutorAllowed(true);
        HashMap map = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f41924m;
        if (requestProperties != null) {
            map.putAll(requestProperties.a());
        }
        map.putAll(this.f41925n.a());
        map.putAll(dataSpec.f41833e);
        for (Map.Entry entry : map.entrySet()) {
            directExecutorAllowed.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (dataSpec.f41832d != null && !map.containsKey("Content-Type")) {
            throw new OpenException("HTTP request with non-empty body must set Content-Type", dataSpec, 1004, 0);
        }
        String strA = HttpUtil.a(dataSpec.f41835g, dataSpec.f41836h);
        if (strA != null) {
            directExecutorAllowed.addHeader("Range", strA);
        }
        String str = this.f41923l;
        if (str != null) {
            directExecutorAllowed.addHeader(GraphRequest.USER_AGENT_HEADER, str);
        }
        directExecutorAllowed.setHttpMethod(dataSpec.b());
        if (dataSpec.f41832d != null) {
            directExecutorAllowed.setUploadDataProvider(new ByteArrayUploadDataProvider(dataSpec.f41832d), this.f41917f);
        }
        return directExecutorAllowed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UrlRequestWrapper I(DataSpec dataSpec) {
        UrlRequestCallback urlRequestCallback = new UrlRequestCallback();
        return new UrlRequestWrapper(H(dataSpec, urlRequestCallback).build(), urlRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String J(String str, Map map, CookieHandler cookieHandler) {
        List<String> list;
        if (cookieHandler == null) {
            return "";
        }
        Map<String, List<String>> mapN = ImmutableMap.n();
        try {
            mapN = cookieHandler.get(new URI(str), map);
        } catch (Exception e3) {
            Log.j("HttpEngineDataSource", "Failed to read cookies from CookieHandler", e3);
        }
        StringBuilder sb = new StringBuilder();
        if (mapN.containsKey("Cookie") && (list = mapN.get("Cookie")) != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("; ");
            }
        }
        return w.a(sb.toString());
    }

    private static String K(Map map, String str) {
        List list = (List) map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    private ByteBuffer L() {
        if (this.f41934w == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32768);
            this.f41934w = byteBufferAllocateDirect;
            byteBufferAllocateDirect.limit(0);
        }
        return this.f41934w;
    }

    private static boolean M(UrlResponseInfo urlResponseInfo) {
        Iterator it = urlResponseInfo.getHeaders().getAsList().iterator();
        while (it.hasNext()) {
            if (((String) ((Map.Entry) it.next()).getKey()).equalsIgnoreCase(GraphRequest.CONTENT_ENCODING_HEADER)) {
                return !((String) r0.getValue()).equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    private void N(ByteBuffer byteBuffer, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        ((UrlRequestWrapper) Util.k(this.f41933v)).c(byteBuffer);
        try {
            if (!this.f41926o.b(this.f41920i)) {
                throw new SocketTimeoutException();
            }
        } catch (InterruptedException unused) {
            if (byteBuffer == this.f41934w) {
                this.f41934w = null;
            }
            Thread.currentThread().interrupt();
            this.f41936y = new InterruptedIOException();
        } catch (SocketTimeoutException e3) {
            if (byteBuffer == this.f41934w) {
                this.f41934w = null;
            }
            this.f41936y = new HttpDataSource.HttpDataSourceException(e3, dataSpec, AdError.CACHE_ERROR_CODE, 2);
        }
        IOException iOException = this.f41936y;
        if (iOException != null) {
            if (!(iOException instanceof HttpDataSource.HttpDataSourceException)) {
                throw HttpDataSource.HttpDataSourceException.c(iOException, dataSpec, 2);
            }
            throw ((HttpDataSource.HttpDataSourceException) iOException);
        }
    }

    private byte[] O() throws HttpDataSource.HttpDataSourceException {
        byte[] bArrCopyOf = Util.f41614f;
        ByteBuffer byteBufferL = L();
        while (!this.f41937z) {
            this.f41926o.d();
            byteBufferL.clear();
            N(byteBufferL, (DataSpec) Util.k(this.f41932u));
            byteBufferL.flip();
            if (byteBufferL.remaining() > 0) {
                int length = bArrCopyOf.length;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + byteBufferL.remaining());
                byteBufferL.get(bArrCopyOf, length, byteBufferL.remaining());
            }
        }
        return bArrCopyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.A = this.f41927p.a() + ((long) this.f41919h);
    }

    private void Q(long j3, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (j3 == 0) {
            return;
        }
        ByteBuffer byteBufferL = L();
        while (j3 > 0) {
            try {
                this.f41926o.d();
                byteBufferL.clear();
                N(byteBufferL, dataSpec);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (this.f41937z) {
                    throw new OpenException(dataSpec, AdError.REMOTE_ADS_SERVICE_ERROR, 14);
                }
                byteBufferL.flip();
                Assertions.g(byteBufferL.hasRemaining());
                int iMin = (int) Math.min(byteBufferL.remaining(), j3);
                byteBufferL.position(byteBufferL.position() + iMin);
                j3 -= (long) iMin;
            } catch (IOException e3) {
                if (e3 instanceof HttpDataSource.HttpDataSourceException) {
                    throw ((HttpDataSource.HttpDataSourceException) e3);
                }
                throw new OpenException(e3, dataSpec, e3 instanceof SocketTimeoutException ? AdError.CACHE_ERROR_CODE : AdError.INTERNAL_ERROR_CODE, 14);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(UrlResponseInfo urlResponseInfo) {
        S(urlResponseInfo, CookieHandler.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(UrlResponseInfo urlResponseInfo, CookieHandler cookieHandler) {
        if (cookieHandler == null) {
            return;
        }
        try {
            cookieHandler.put(new URI(urlResponseInfo.getUrl()), urlResponseInfo.getHeaders().getAsMap());
        } catch (Exception e3) {
            Log.j("HttpEngineDataSource", "Failed to store cookies in CookieHandler", e3);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public long b(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrO;
        String strK;
        Assertions.e(dataSpec);
        Assertions.g(!this.f41930s);
        this.f41926o.d();
        P();
        this.f41932u = dataSpec;
        try {
            UrlRequestWrapper urlRequestWrapperI = I(dataSpec);
            this.f41933v = urlRequestWrapperI;
            urlRequestWrapperI.d();
            p(dataSpec);
            try {
                boolean zG = G();
                IOException iOException = this.f41936y;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (message == null || !Ascii.e(message).contains("err_cleartext_not_permitted")) {
                        throw new OpenException(iOException, dataSpec, AdError.INTERNAL_ERROR_CODE, urlRequestWrapperI.b());
                    }
                    throw new HttpDataSource.CleartextNotPermittedException(iOException, dataSpec);
                }
                if (!zG) {
                    throw new OpenException(new SocketTimeoutException(), dataSpec, AdError.CACHE_ERROR_CODE, urlRequestWrapperI.b());
                }
                UrlResponseInfo urlResponseInfoA = p.a(Assertions.e(this.f41935x));
                int httpStatusCode = urlResponseInfoA.getHttpStatusCode();
                Map asMap = urlResponseInfoA.getHeaders().getAsMap();
                long j3 = 0;
                if (httpStatusCode < 200 || httpStatusCode > 299) {
                    if (httpStatusCode == 416) {
                        if (dataSpec.f41835g == HttpUtil.c(K(asMap, "Content-Range"))) {
                            this.f41930s = true;
                            q(dataSpec);
                            long j4 = dataSpec.f41836h;
                            if (j4 != -1) {
                                return j4;
                            }
                            return 0L;
                        }
                    }
                    try {
                        bArrO = O();
                    } catch (IOException unused) {
                        bArrO = Util.f41614f;
                    }
                    throw new HttpDataSource.InvalidResponseCodeException(httpStatusCode, urlResponseInfoA.getHttpStatusText(), httpStatusCode == 416 ? new DataSourceException(AdError.REMOTE_ADS_SERVICE_ERROR) : null, asMap, dataSpec, bArrO);
                }
                Predicate predicate = this.f41928q;
                if (predicate != null && (strK = K(asMap, "Content-Type")) != null && !predicate.apply(strK)) {
                    throw new HttpDataSource.InvalidContentTypeException(strK, dataSpec);
                }
                if (httpStatusCode == 200) {
                    long j5 = dataSpec.f41835g;
                    if (j5 != 0) {
                        j3 = j5;
                    }
                }
                if (M(urlResponseInfoA)) {
                    this.f41931t = dataSpec.f41836h;
                } else {
                    long j6 = dataSpec.f41836h;
                    if (j6 != -1) {
                        this.f41931t = j6;
                    } else {
                        long jB = HttpUtil.b(K(asMap, HttpHeaders.CONTENT_LENGTH), K(asMap, "Content-Range"));
                        this.f41931t = jB != -1 ? jB - j3 : -1L;
                    }
                }
                this.f41930s = true;
                q(dataSpec);
                Q(j3, dataSpec);
                return this.f41931t;
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                throw new OpenException(new InterruptedIOException(), dataSpec, 1004, -1);
            }
        } catch (IOException e3) {
            if (e3 instanceof HttpDataSource.HttpDataSourceException) {
                throw ((HttpDataSource.HttpDataSourceException) e3);
            }
            throw new OpenException(e3, dataSpec, AdError.SERVER_ERROR_CODE, 0);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public synchronized void close() {
        try {
            UrlRequestWrapper urlRequestWrapper = this.f41933v;
            if (urlRequestWrapper != null) {
                urlRequestWrapper.a();
                this.f41933v = null;
            }
            ByteBuffer byteBuffer = this.f41934w;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.f41932u = null;
            this.f41935x = null;
            this.f41936y = null;
            this.f41937z = false;
            if (this.f41930s) {
                this.f41930s = false;
                o();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public Map e() {
        UrlResponseInfo urlResponseInfo = this.f41935x;
        return urlResponseInfo == null ? Collections.EMPTY_MAP : urlResponseInfo.getHeaders().getAsMap();
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        UrlResponseInfo urlResponseInfo = this.f41935x;
        if (urlResponseInfo != null) {
            return Uri.parse(urlResponseInfo.getUrl());
        }
        DataSpec dataSpec = this.f41932u;
        if (dataSpec != null) {
            return dataSpec.f41829a;
        }
        return null;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) throws HttpDataSource.HttpDataSourceException {
        Assertions.g(this.f41930s);
        if (i4 == 0) {
            return 0;
        }
        if (this.f41931t == 0) {
            return -1;
        }
        ByteBuffer byteBufferL = L();
        if (!byteBufferL.hasRemaining()) {
            this.f41926o.d();
            byteBufferL.clear();
            N(byteBufferL, (DataSpec) Util.k(this.f41932u));
            if (this.f41937z) {
                this.f41931t = 0L;
                return -1;
            }
            byteBufferL.flip();
            Assertions.g(byteBufferL.hasRemaining());
        }
        long j3 = this.f41931t;
        if (j3 == -1) {
            j3 = Long.MAX_VALUE;
        }
        int i5 = (int) Longs.i(j3, byteBufferL.remaining(), i4);
        byteBufferL.get(bArr, i3, i5);
        long j4 = this.f41931t;
        if (j4 != -1) {
            this.f41931t = j4 - ((long) i5);
        }
        n(i5);
        return i5;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class OpenException extends HttpDataSource.HttpDataSourceException {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41950d;

        public OpenException(IOException iOException, DataSpec dataSpec, int i3, int i4) {
            super(iOException, dataSpec, i3, 1);
            this.f41950d = i4;
        }

        public OpenException(String str, DataSpec dataSpec, int i3, int i4) {
            super(str, dataSpec, i3, 1);
            this.f41950d = i4;
        }

        public OpenException(DataSpec dataSpec, int i3, int i4) {
            super(dataSpec, i3, 1);
            this.f41950d = i4;
        }
    }
}
