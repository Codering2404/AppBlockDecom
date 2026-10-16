package com.airbnb.lottie.model;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DocumentData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f56680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f56681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f56682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Justification f56683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f56684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f56685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f56686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f56687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f56689j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f56690k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PointF f56691l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PointF f56692m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f3, Justification justification, int i3, float f4, float f5, int i4, int i5, float f6, boolean z2, PointF pointF, PointF pointF2) {
        a(str, str2, f3, justification, i3, f4, f5, i4, i5, f6, z2, pointF, pointF2);
    }

    public void a(String str, String str2, float f3, Justification justification, int i3, float f4, float f5, int i4, int i5, float f6, boolean z2, PointF pointF, PointF pointF2) {
        this.f56680a = str;
        this.f56681b = str2;
        this.f56682c = f3;
        this.f56683d = justification;
        this.f56684e = i3;
        this.f56685f = f4;
        this.f56686g = f5;
        this.f56687h = i4;
        this.f56688i = i5;
        this.f56689j = f6;
        this.f56690k = z2;
        this.f56691l = pointF;
        this.f56692m = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f56680a.hashCode() * 31) + this.f56681b.hashCode()) * 31) + this.f56682c)) * 31) + this.f56683d.ordinal()) * 31) + this.f56684e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f56685f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f56687h;
    }

    public DocumentData() {
    }
}
