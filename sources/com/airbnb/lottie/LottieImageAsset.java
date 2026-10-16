package com.airbnb.lottie;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieImageAsset {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f56351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f56352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f56353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f56354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f56355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f56356f;

    public LottieImageAsset(int i3, int i4, String str, String str2, String str3) {
        this.f56351a = i3;
        this.f56352b = i4;
        this.f56353c = str;
        this.f56354d = str2;
        this.f56355e = str3;
    }

    public Bitmap a() {
        return this.f56356f;
    }

    public String b() {
        return this.f56354d;
    }

    public int c() {
        return this.f56352b;
    }

    public String d() {
        return this.f56353c;
    }

    public int e() {
        return this.f56351a;
    }

    public void f(Bitmap bitmap) {
        this.f56356f = bitmap;
    }
}
