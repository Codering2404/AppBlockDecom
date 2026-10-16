package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AppUpdateInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f82837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f82838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f82839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f82840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f82841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f82842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f82843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f82844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f82845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f82846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PendingIntent f82847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final PendingIntent f82848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PendingIntent f82849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final PendingIntent f82850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Map f82851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f82852p = false;

    private AppUpdateInfo(String str, int i3, int i4, int i5, Integer num, int i6, long j3, long j4, long j5, long j6, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        this.f82837a = str;
        this.f82838b = i3;
        this.f82839c = i4;
        this.f82840d = i5;
        this.f82841e = num;
        this.f82842f = i6;
        this.f82843g = j3;
        this.f82844h = j4;
        this.f82845i = j5;
        this.f82846j = j6;
        this.f82847k = pendingIntent;
        this.f82848l = pendingIntent2;
        this.f82849m = pendingIntent3;
        this.f82850n = pendingIntent4;
        this.f82851o = map;
    }

    public static AppUpdateInfo h(String str, int i3, int i4, int i5, Integer num, int i6, long j3, long j4, long j5, long j6, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4, Map map) {
        return new AppUpdateInfo(str, i3, i4, i5, num, i6, j3, j4, j5, j6, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    private final boolean k(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.a() && this.f82845i <= this.f82846j;
    }

    public int a() {
        return this.f82838b;
    }

    public Integer b() {
        return this.f82841e;
    }

    public int c() {
        return this.f82840d;
    }

    public boolean d(int i3) {
        return g(AppUpdateOptions.c(i3)) != null;
    }

    public boolean e(AppUpdateOptions appUpdateOptions) {
        return g(appUpdateOptions) != null;
    }

    public int f() {
        return this.f82839c;
    }

    final PendingIntent g(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.b() == 0) {
            PendingIntent pendingIntent = this.f82848l;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (k(appUpdateOptions)) {
                return this.f82850n;
            }
            return null;
        }
        if (appUpdateOptions.b() == 1) {
            PendingIntent pendingIntent2 = this.f82847k;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (k(appUpdateOptions)) {
                return this.f82849m;
            }
        }
        return null;
    }

    final void i() {
        this.f82852p = true;
    }

    final boolean j() {
        return this.f82852p;
    }
}
