package com.airbnb.lottie.model;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Font {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f56698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f56699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f56700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Typeface f56701e;

    public Font(String str, String str2, String str3, float f3) {
        this.f56697a = str;
        this.f56698b = str2;
        this.f56699c = str3;
        this.f56700d = f3;
    }

    public String a() {
        return this.f56697a;
    }

    public String b() {
        return this.f56698b;
    }

    public String c() {
        return this.f56699c;
    }

    public Typeface d() {
        return this.f56701e;
    }

    public void e(Typeface typeface) {
        this.f56701e = typeface;
    }
}
