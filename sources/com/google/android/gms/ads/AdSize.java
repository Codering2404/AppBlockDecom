package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzr;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdSize {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AdSize f69645j = new AdSize(320, 50, "320x50_mb");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AdSize f69646k = new AdSize(468, 60, "468x60_as");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AdSize f69647l = new AdSize(320, 100, "320x100_as");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AdSize f69648m = new AdSize(728, 90, "728x90_as");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AdSize f69649n = new AdSize(300, 250, "300x250_as");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AdSize f69650o = new AdSize(160, 600, "160x600_as");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AdSize f69651p = new AdSize(-1, -2, "smart_banner");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AdSize f69652q = new AdSize(-3, -4, "fluid");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AdSize f69653r = new AdSize(0, 0, "invalid");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AdSize f69654s = new AdSize(50, 50, "50x50_mb");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f69656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f69657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f69658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f69659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f69660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f69661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f69662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f69663i;

    public AdSize(int i3, int i4) {
        String strValueOf = i3 == -1 ? "FULL" : String.valueOf(i3);
        String strValueOf2 = i4 == -2 ? "AUTO" : String.valueOf(i4);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length() + 3);
        sb.append(strValueOf);
        sb.append("x");
        sb.append(strValueOf2);
        sb.append("_as");
        this(i3, i4, sb.toString());
    }

    public static AdSize a(Context context, int i3) {
        AdSize adSizeV = com.google.android.gms.ads.internal.util.client.zzf.v(context, i3, 50, 0);
        adSizeV.f69658d = true;
        return adSizeV;
    }

    public int b() {
        return this.f69656b;
    }

    public int c(Context context) {
        int i3 = this.f69656b;
        if (i3 == -4 || i3 == -3) {
            return -1;
        }
        if (i3 == -2) {
            return zzr.M(context.getResources().getDisplayMetrics());
        }
        zzay.a();
        return com.google.android.gms.ads.internal.util.client.zzf.e(context, i3);
    }

    public int d() {
        return this.f69655a;
    }

    public int e(Context context) {
        int i3 = this.f69655a;
        if (i3 == -3) {
            return -1;
        }
        if (i3 != -1) {
            zzay.a();
            return com.google.android.gms.ads.internal.util.client.zzf.e(context, i3);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzr> creator = zzr.CREATOR;
        return displayMetrics.widthPixels;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f69655a == adSize.f69655a && this.f69656b == adSize.f69656b && this.f69657c.equals(adSize.f69657c);
    }

    public boolean f() {
        return this.f69655a == -3 && this.f69656b == -4;
    }

    final boolean g() {
        return this.f69658d;
    }

    final boolean h() {
        return this.f69659e;
    }

    public int hashCode() {
        return this.f69657c.hashCode();
    }

    final boolean i() {
        return this.f69660f;
    }

    final void j(boolean z2) {
        this.f69660f = true;
    }

    final void k(int i3) {
        this.f69661g = i3;
    }

    final int l() {
        return this.f69661g;
    }

    final boolean m() {
        return this.f69662h;
    }

    final void n(boolean z2) {
        this.f69662h = true;
    }

    final int o() {
        return this.f69663i;
    }

    final void p(int i3) {
        this.f69663i = i3;
    }

    public String toString() {
        return this.f69657c;
    }

    AdSize(int i3, int i4, String str) {
        if (i3 < 0 && i3 != -1 && i3 != -3) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 26);
            sb.append("Invalid width for AdSize: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i4 < 0 && i4 != -2 && i4 != -4) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 27);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i4);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.f69655a = i3;
        this.f69656b = i4;
        this.f69657c = str;
    }
}
