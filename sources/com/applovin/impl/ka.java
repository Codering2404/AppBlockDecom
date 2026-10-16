package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ka {
    public static final ka A;
    public static final ka B;
    public static final ka C;
    public static final ka D;
    public static final ka E;
    public static final ka F;
    public static final ka G;
    public static final ka H;
    public static final ka I;
    public static final ka J;
    public static final ka K;
    public static final ka L;
    public static final ka M;
    public static final ka N;
    public static final ka O;
    public static final ka P;
    public static final ka Q;
    public static final ka R;
    public static final ka S;
    public static final ka T;
    public static final ka U;
    public static final ka V;
    public static final ka W;
    public static final ka X;
    public static final ka Y;
    public static final ka Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final ka f60946a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final ka f60947b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JSONObject f60948c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final ka f60949c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ka f60950d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final ka f60951d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ka f60952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ka f60953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ka f60954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ka f60955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ka f60956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ka f60957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ka f60958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ka f60959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ka f60960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ka f60961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ka f60962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ka f60963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ka f60964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ka f60965r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ka f60966s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ka f60967t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ka f60968u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ka f60969v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ka f60970w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ka f60971x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ka f60972y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ka f60973z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f60974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f60975b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f60976a;

        static {
            int[] iArr = new int[b.values().length];
            f60976a = iArr;
            try {
                iArr[b.AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f60976a[b.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f60976a[b.USER_SESSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        AD,
        ERROR,
        USER_SESSION
    }

    static {
        b bVar = b.ERROR;
        f60950d = new ka("generic", bVar);
        f60952e = new ka("sdk_init", b.USER_SESSION);
        b bVar2 = b.AD;
        f60953f = new ka("ad_requested", bVar2);
        f60954g = new ka("ad_request_success", bVar2);
        f60955h = new ka("ad_request_failure", bVar2);
        f60956i = new ka("ad_load_success", bVar2);
        f60957j = new ka("ad_load_failure", bVar2);
        f60958k = new ka("ad_displayed", bVar2);
        f60959l = new ka("ad_hidden", bVar2);
        f60960m = new ka("resource_load_started", bVar2);
        f60961n = new ka("resource_load_success", bVar2);
        f60962o = new ka("resource_load_failure", bVar2);
        f60963p = new ka("ad_persist_request", bVar2);
        f60964q = new ka("ad_persist_success", bVar2);
        f60965r = new ka("ad_persist_failure", bVar2);
        f60966s = new ka("persisted_ad_requested", bVar2);
        f60967t = new ka("persisted_ad_load_success", bVar2);
        f60968u = new ka("persisted_ad_load_failure", bVar2);
        f60969v = new ka("persisted_ad_expired", bVar2);
        f60970w = new ka("adapter_init_started", bVar2);
        f60971x = new ka("adapter_init_success", bVar2);
        f60972y = new ka("adapter_init_failure", bVar2);
        f60973z = new ka("signal_collection_success", bVar2);
        A = new ka("signal_collection_failure", bVar2);
        B = new ka("mediated_ad_requested", bVar2);
        C = new ka("mediated_ad_request_success", bVar2);
        D = new ka("mediated_ad_request_failure", bVar2);
        E = new ka("mediated_ad_load_started", bVar2);
        F = new ka("mediated_ad_load_success", bVar2);
        G = new ka("mediated_ad_load_failure", bVar2);
        H = new ka("waterfall_processing_complete", bVar2);
        I = new ka("mediated_ad_displayed", bVar2);
        J = new ka("mediated_ad_display_failure", bVar2);
        K = new ka("mediated_ad_hidden", bVar2);
        L = new ka("mediated_ad_hidden_callback_not_called", bVar2);
        M = new ka("anr", bVar);
        N = new ka("app_killed_during_ad", bVar);
        O = new ka("auto_redirect", bVar);
        P = new ka("black_view", bVar);
        Q = new ka("cache_error", bVar);
        R = new ka("caught_exception", bVar);
        S = new ka("consent_flow_error", bVar);
        T = new ka("crash", bVar);
        U = new ka("file_error", bVar);
        V = new ka("integration_error", bVar);
        W = new ka("media_error", bVar);
        X = new ka("native_error", bVar);
        Y = new ka("network_error", bVar);
        Z = new ka("task_exception", bVar);
        f60946a0 = new ka("task_latency_alert", bVar);
        f60947b0 = new ka("template_error", bVar);
        f60949c0 = new ka("unexpected_state", bVar);
        f60951d0 = new ka("web_view_error", bVar);
    }

    public ka(String str, b bVar) {
        this.f60974a = str;
        this.f60975b = bVar;
    }

    public b a() {
        return this.f60975b;
    }

    public String b() {
        return this.f60974a;
    }

    public double a(com.applovin.impl.sdk.j jVar) {
        if (yp.i(com.applovin.impl.sdk.j.m())) {
            return 100.0d;
        }
        double dA = a(this.f60974a, jVar);
        if (dA >= 0.0d) {
            return dA;
        }
        double dA2 = a(this.f60975b, jVar);
        return dA2 >= 0.0d ? dA2 : ((Float) jVar.a(sj.J)).floatValue();
    }

    private double a(String str, com.applovin.impl.sdk.j jVar) {
        if (f60948c == null) {
            f60948c = JsonUtils.deserialize((String) jVar.a(sj.F));
        }
        Double d3 = JsonUtils.getDouble(f60948c, str, (Double) null);
        if (d3 != null) {
            return d3.doubleValue();
        }
        return -1.0d;
    }

    private double a(b bVar, com.applovin.impl.sdk.j jVar) {
        float fFloatValue;
        int i3 = a.f60976a[bVar.ordinal()];
        if (i3 == 1) {
            fFloatValue = ((Float) jVar.a(sj.G)).floatValue();
        } else if (i3 == 2) {
            fFloatValue = ((Float) jVar.a(sj.H)).floatValue();
        } else {
            if (i3 != 3) {
                return -1.0d;
            }
            fFloatValue = ((Float) jVar.a(sj.I)).floatValue();
        }
        return fFloatValue;
    }
}
