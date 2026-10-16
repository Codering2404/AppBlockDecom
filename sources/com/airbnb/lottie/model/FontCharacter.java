package com.airbnb.lottie.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FontCharacter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f56703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f56704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f56705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f56706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f56707f;

    public FontCharacter(List list, char c3, double d3, double d4, String str, String str2) {
        this.f56702a = list;
        this.f56703b = c3;
        this.f56704c = d3;
        this.f56705d = d4;
        this.f56706e = str;
        this.f56707f = str2;
    }

    public static int c(char c3, String str, String str2) {
        return (((c3 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f56702a;
    }

    public double b() {
        return this.f56705d;
    }

    public int hashCode() {
        return c(this.f56703b, this.f56707f, this.f56706e);
    }
}
