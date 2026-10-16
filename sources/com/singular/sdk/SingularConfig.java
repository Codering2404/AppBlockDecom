package com.singular.sdk;

import android.content.Intent;
import android.net.Uri;
import com.singular.sdk.internal.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularConfig {
    public String[][] A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f92416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f92417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f92418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f92419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DDLHandler f92420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f92421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f92422g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Uri f92428m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SingularLinkHandler f92429n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SingularDeviceAttributionHandler f92430o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f92431p;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f92436u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f92439x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SDIDAccessorHandler f92440y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Intent f92441z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f92423h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f92424i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f92425j = 60;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f92426k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f92427l = 6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f92432q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f92433r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f92434s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f92435t = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f92437v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f92438w = Boolean.FALSE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DDLHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DeferredDeepLinkHandler f92442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f92443b = 60;
    }

    public SingularConfig(String str, String str2) {
        if (Utils.U(str)) {
            throw new IllegalArgumentException("apiKey can not be null or empty");
        }
        if (Utils.U(str2)) {
            throw new IllegalArgumentException("secret can not be null or empty");
        }
        this.f92416a = str;
        this.f92417b = str2;
    }

    static SingularConfig a(SingularConfig singularConfig) {
        if (!singularConfig.f92416a.endsWith("_sl") && !singularConfig.f92417b.endsWith("_sl")) {
            return singularConfig;
        }
        SingularConfig singularConfig2 = new SingularConfig(singularConfig.f92416a.endsWith("_sl") ? Utils.r0(Utils.k(singularConfig.f92416a, "_sl")) : singularConfig.f92416a, singularConfig.f92417b.endsWith("_sl") ? Utils.r0(Utils.k(singularConfig.f92417b, "_sl")) : singularConfig.f92417b);
        singularConfig2.f92418c = singularConfig.f92418c;
        singularConfig2.f92419d = singularConfig.f92419d;
        singularConfig2.f92420e = singularConfig.f92420e;
        singularConfig2.f92421f = singularConfig.f92421f;
        singularConfig2.f92422g = singularConfig.f92422g;
        singularConfig2.f92423h = singularConfig.f92423h;
        singularConfig2.f92424i = singularConfig.f92424i;
        singularConfig2.f92425j = singularConfig.f92425j;
        singularConfig2.f92426k = singularConfig.f92426k;
        singularConfig2.f92427l = singularConfig.f92427l;
        singularConfig2.f92428m = singularConfig.f92428m;
        singularConfig2.f92429n = singularConfig.f92429n;
        singularConfig2.f92430o = singularConfig.f92430o;
        singularConfig2.f92431p = singularConfig.f92431p;
        singularConfig2.f92432q = singularConfig.f92432q;
        singularConfig2.f92433r = singularConfig.f92433r;
        singularConfig2.f92434s = singularConfig.f92434s;
        singularConfig2.f92436u = singularConfig.f92436u;
        singularConfig2.f92437v = singularConfig.f92437v;
        singularConfig2.f92438w = singularConfig.f92438w;
        singularConfig2.f92439x = singularConfig.f92439x;
        singularConfig2.f92440y = singularConfig.f92440y;
        singularConfig2.A = singularConfig.A;
        singularConfig2.f92441z = singularConfig.f92441z;
        singularConfig2.f92435t = singularConfig.f92435t;
        return singularConfig2;
    }

    public SingularConfig b(String str) {
        this.f92421f = str;
        return this;
    }

    public SingularConfig c(String str) {
        this.f92418c = str;
        return this;
    }

    public SingularConfig d(int i3) {
        this.f92427l = i3;
        return this;
    }

    public SingularConfig e() {
        this.f92426k = true;
        return this;
    }

    public SingularConfig f(SingularDeviceAttributionHandler singularDeviceAttributionHandler) {
        this.f92430o = singularDeviceAttributionHandler;
        return this;
    }

    public SingularConfig g(Intent intent, SingularLinkHandler singularLinkHandler) {
        return h(intent, singularLinkHandler, 10L, null);
    }

    public SingularConfig h(Intent intent, SingularLinkHandler singularLinkHandler, long j3, List list) {
        if (this.f92420e == null) {
            this.f92420e = new DDLHandler();
        }
        this.f92429n = singularLinkHandler;
        this.f92431p = j3;
        if (intent != null) {
            Uri data = intent.getData();
            this.f92428m = data;
            if (data != null && "android.intent.action.VIEW".equals(intent.getAction())) {
                this.f92432q = true;
            }
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("apiKey='");
        sb.append(this.f92416a);
        sb.append('\'');
        sb.append(", secret='");
        sb.append(this.f92417b);
        sb.append('\'');
        if (this.f92419d != null) {
            sb.append(", openUri=");
            sb.append(this.f92419d);
        }
        if (this.f92420e != null) {
            sb.append(", ddlHandler=");
            sb.append(this.f92420e.getClass().getName());
            sb.append(", timeoutInSec=");
            sb.append(this.f92420e.f92443b);
        }
        sb.append(", logging='");
        sb.append(this.f92426k);
        sb.append('\'');
        sb.append(", logLevel='");
        sb.append(this.f92427l);
        sb.append('\'');
        return sb.toString();
    }
}
