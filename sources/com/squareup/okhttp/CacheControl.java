package com.squareup.okhttp;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class CacheControl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CacheControl f92801m = new Builder().c().a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CacheControl f92802n = new Builder().d().b(Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f92803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f92804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f92805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f92806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f92807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f92808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f92809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f92810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f92811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f92812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f92813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f92814l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f92815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f92816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f92817c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f92818d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f92819e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f92820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f92821g;

        public CacheControl a() {
            return new CacheControl(this);
        }

        public Builder b(int i3, TimeUnit timeUnit) {
            if (i3 >= 0) {
                long seconds = timeUnit.toSeconds(i3);
                this.f92818d = seconds > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i3);
        }

        public Builder c() {
            this.f92815a = true;
            return this;
        }

        public Builder d() {
            this.f92820f = true;
            return this;
        }
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f92803a) {
            sb.append("no-cache, ");
        }
        if (this.f92804b) {
            sb.append("no-store, ");
        }
        if (this.f92805c != -1) {
            sb.append("max-age=");
            sb.append(this.f92805c);
            sb.append(", ");
        }
        if (this.f92806d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f92806d);
            sb.append(", ");
        }
        if (this.f92807e) {
            sb.append("private, ");
        }
        if (this.f92808f) {
            sb.append("public, ");
        }
        if (this.f92809g) {
            sb.append("must-revalidate, ");
        }
        if (this.f92810h != -1) {
            sb.append("max-stale=");
            sb.append(this.f92810h);
            sb.append(", ");
        }
        if (this.f92811i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f92811i);
            sb.append(", ");
        }
        if (this.f92812j) {
            sb.append("only-if-cached, ");
        }
        if (this.f92813k) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.squareup.okhttp.CacheControl k(com.squareup.okhttp.Headers r22) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.CacheControl.k(com.squareup.okhttp.Headers):com.squareup.okhttp.CacheControl");
    }

    public boolean b() {
        return this.f92807e;
    }

    public boolean c() {
        return this.f92808f;
    }

    public int d() {
        return this.f92805c;
    }

    public int e() {
        return this.f92810h;
    }

    public int f() {
        return this.f92811i;
    }

    public boolean g() {
        return this.f92809g;
    }

    public boolean h() {
        return this.f92803a;
    }

    public boolean i() {
        return this.f92804b;
    }

    public boolean j() {
        return this.f92812j;
    }

    public String toString() {
        String str = this.f92814l;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.f92814l = strA;
        return strA;
    }

    private CacheControl(boolean z2, boolean z3, int i3, int i4, boolean z4, boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, String str) {
        this.f92803a = z2;
        this.f92804b = z3;
        this.f92805c = i3;
        this.f92806d = i4;
        this.f92807e = z4;
        this.f92808f = z5;
        this.f92809g = z6;
        this.f92810h = i5;
        this.f92811i = i6;
        this.f92812j = z7;
        this.f92813k = z8;
        this.f92814l = str;
    }

    private CacheControl(Builder builder) {
        this.f92803a = builder.f92815a;
        this.f92804b = builder.f92816b;
        this.f92805c = builder.f92817c;
        this.f92806d = -1;
        this.f92807e = false;
        this.f92808f = false;
        this.f92809g = false;
        this.f92810h = builder.f92818d;
        this.f92811i = builder.f92819e;
        this.f92812j = builder.f92820f;
        this.f92813k = builder.f92821g;
    }
}
