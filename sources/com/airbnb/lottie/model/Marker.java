package com.airbnb.lottie.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Marker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f56714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f56715c;

    public Marker(String str, float f3, float f4) {
        this.f56713a = str;
        this.f56715c = f4;
        this.f56714b = f3;
    }

    public boolean a(String str) {
        if (this.f56713a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f56713a.endsWith("\r")) {
            String str2 = this.f56713a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
