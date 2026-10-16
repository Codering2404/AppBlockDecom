package com.applovin.impl;

import android.opengl.Matrix;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class j9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f60681a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f60682b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final eo f60683c = new eo();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f60684d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f3 = fArr2[10];
        float f4 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
        float f5 = fArr2[10] / fSqrt;
        fArr[0] = f5;
        float f6 = fArr2[8];
        fArr[2] = f6 / fSqrt;
        fArr[8] = (-f6) / fSqrt;
        fArr[10] = f5;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f3 = fArr2[0];
        float f4 = -fArr2[1];
        float f5 = -fArr2[2];
        float length = Matrix.length(f3, f4, f5);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f3 / length, f4 / length, f5 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean a(float[] fArr, long j3) {
        float[] fArr2 = (float[]) this.f60683c.c(j3);
        if (fArr2 == null) {
            return false;
        }
        b(this.f60682b, fArr2);
        if (!this.f60684d) {
            a(this.f60681a, this.f60682b);
            this.f60684d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f60681a, 0, this.f60682b, 0);
        return true;
    }

    public void a() {
        this.f60683c.a();
        this.f60684d = false;
    }

    public void a(long j3, float[] fArr) {
        this.f60683c.a(j3, fArr);
    }
}
