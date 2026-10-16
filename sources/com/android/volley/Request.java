package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.facebook.stetho.common.Utf8Charset;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VolleyLog.MarkerLog f57682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f57683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f57684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f57685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f57686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Response.ErrorListener f57687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f57688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RequestQueue f57689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f57690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f57691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f57692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f57693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f57694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RetryPolicy f57695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Cache.Entry f57696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private NetworkRequestCompleteListener f57697q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Method {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface NetworkRequestCompleteListener {
        void a(Request request, Response response);

        void b(Request request);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public Request(int i3, String str, Response.ErrorListener errorListener) {
        this.f57682a = VolleyLog.MarkerLog.f57727c ? new VolleyLog.MarkerLog() : null;
        this.f57686f = new Object();
        this.f57690j = true;
        this.f57691k = false;
        this.f57692l = false;
        this.f57693m = false;
        this.f57694n = false;
        this.f57696p = null;
        this.f57683b = i3;
        this.f57684c = str;
        this.f57687g = errorListener;
        Q(new DefaultRetryPolicy());
        this.f57685d = h(str);
    }

    private byte[] g(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode((String) entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Encoding not supported: " + str, e3);
        }
    }

    private static int h(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public boolean A() {
        boolean z2;
        synchronized (this.f57686f) {
            z2 = this.f57692l;
        }
        return z2;
    }

    public boolean B() {
        boolean z2;
        synchronized (this.f57686f) {
            z2 = this.f57691k;
        }
        return z2;
    }

    public void C() {
        synchronized (this.f57686f) {
            this.f57692l = true;
        }
    }

    void D() {
        NetworkRequestCompleteListener networkRequestCompleteListener;
        synchronized (this.f57686f) {
            networkRequestCompleteListener = this.f57697q;
        }
        if (networkRequestCompleteListener != null) {
            networkRequestCompleteListener.b(this);
        }
    }

    void E(Response response) {
        NetworkRequestCompleteListener networkRequestCompleteListener;
        synchronized (this.f57686f) {
            networkRequestCompleteListener = this.f57697q;
        }
        if (networkRequestCompleteListener != null) {
            networkRequestCompleteListener.a(this, response);
        }
    }

    protected abstract Response G(NetworkResponse networkResponse);

    void H(int i3) {
        RequestQueue requestQueue = this.f57689i;
        if (requestQueue != null) {
            requestQueue.g(this, i3);
        }
    }

    public Request I(Cache.Entry entry) {
        this.f57696p = entry;
        return this;
    }

    void O(NetworkRequestCompleteListener networkRequestCompleteListener) {
        synchronized (this.f57686f) {
            this.f57697q = networkRequestCompleteListener;
        }
    }

    public Request P(RequestQueue requestQueue) {
        this.f57689i = requestQueue;
        return this;
    }

    public Request Q(RetryPolicy retryPolicy) {
        this.f57695o = retryPolicy;
        return this;
    }

    public final Request R(int i3) {
        this.f57688h = Integer.valueOf(i3);
        return this;
    }

    public final boolean S() {
        return this.f57690j;
    }

    public final boolean T() {
        return this.f57694n;
    }

    public final boolean U() {
        return this.f57693m;
    }

    public void b(String str) {
        if (VolleyLog.MarkerLog.f57727c) {
            this.f57682a.a(str, Thread.currentThread().getId());
        }
    }

    public void c() {
        synchronized (this.f57686f) {
            this.f57691k = true;
            this.f57687g = null;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Request request) {
        Priority priorityV = v();
        Priority priorityV2 = request.v();
        return priorityV == priorityV2 ? this.f57688h.intValue() - request.f57688h.intValue() : priorityV2.ordinal() - priorityV.ordinal();
    }

    public void e(VolleyError volleyError) {
        Response.ErrorListener errorListener;
        synchronized (this.f57686f) {
            errorListener = this.f57687g;
        }
        if (errorListener != null) {
            errorListener.c(volleyError);
        }
    }

    protected abstract void f(Object obj);

    void i(final String str) {
        RequestQueue requestQueue = this.f57689i;
        if (requestQueue != null) {
            requestQueue.c(this);
        }
        if (VolleyLog.MarkerLog.f57727c) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.android.volley.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.f57682a.a(str, id);
                        Request.this.f57682a.b(Request.this.toString());
                    }
                });
            } else {
                this.f57682a.a(str, id);
                this.f57682a.b(toString());
            }
        }
    }

    public byte[] j() {
        Map mapP = p();
        if (mapP == null || mapP.size() <= 0) {
            return null;
        }
        return g(mapP, q());
    }

    public String k() {
        return "application/x-www-form-urlencoded; charset=" + q();
    }

    public Cache.Entry l() {
        return this.f57696p;
    }

    public String m() {
        String strZ = z();
        int iO = o();
        if (iO == 0 || iO == -1) {
            return strZ;
        }
        return Integer.toString(iO) + '-' + strZ;
    }

    public Map n() {
        return Collections.EMPTY_MAP;
    }

    public int o() {
        return this.f57683b;
    }

    protected Map p() {
        return null;
    }

    protected String q() {
        return Utf8Charset.NAME;
    }

    public byte[] r() {
        Map mapT = t();
        if (mapT == null || mapT.size() <= 0) {
            return null;
        }
        return g(mapT, u());
    }

    public String s() {
        return k();
    }

    protected Map t() {
        return p();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(y());
        StringBuilder sb = new StringBuilder();
        sb.append(B() ? "[X] " : "[ ] ");
        sb.append(z());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(v());
        sb.append(" ");
        sb.append(this.f57688h);
        return sb.toString();
    }

    protected String u() {
        return q();
    }

    public Priority v() {
        return Priority.NORMAL;
    }

    public RetryPolicy w() {
        return this.f57695o;
    }

    public final int x() {
        return w().c();
    }

    public int y() {
        return this.f57685d;
    }

    public String z() {
        return this.f57684c;
    }

    protected VolleyError F(VolleyError volleyError) {
        return volleyError;
    }
}
