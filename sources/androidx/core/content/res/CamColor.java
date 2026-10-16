package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CamColor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f33876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f33877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f33878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f33879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f33880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f33881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f33882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f33883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f33884i;

    CamColor(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.f33876a = f3;
        this.f33877b = f4;
        this.f33878c = f5;
        this.f33879d = f6;
        this.f33880e = f7;
        this.f33881f = f8;
        this.f33882g = f9;
        this.f33883h = f10;
        this.f33884i = f11;
    }

    private static CamColor b(float f3, float f4, float f5) {
        float f6 = 100.0f;
        float f7 = 1000.0f;
        float f8 = 0.0f;
        CamColor camColor = null;
        float f9 = 1000.0f;
        while (Math.abs(f8 - f6) > 0.01f) {
            float f10 = ((f6 - f8) / 2.0f) + f8;
            int iP = e(f10, f4, f3).p();
            float fB = CamUtils.b(iP);
            float fAbs = Math.abs(f5 - fB);
            if (fAbs < 0.2f) {
                CamColor camColorC = c(iP);
                float fA = camColorC.a(e(camColorC.k(), camColorC.i(), f3));
                if (fA <= 1.0f) {
                    camColor = camColorC;
                    f7 = fAbs;
                    f9 = fA;
                }
            }
            if (f7 == 0.0f && f9 == 0.0f) {
                return camColor;
            }
            if (fB < f5) {
                f8 = f10;
            } else {
                f6 = f10;
            }
        }
        return camColor;
    }

    static CamColor c(int i3) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i3, ViewingConditions.f33919k, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i3, ViewingConditions viewingConditions, float[] fArr, float[] fArr2) {
        CamUtils.f(i3, fArr2);
        float[][] fArr3 = CamUtils.f33885a;
        float f3 = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f4 = fArr4[0] * f3;
        float f5 = fArr2[1];
        float f6 = f4 + (fArr4[1] * f5);
        float f7 = fArr2[2];
        float f8 = f6 + (fArr4[2] * f7);
        float[] fArr5 = fArr3[1];
        float f9 = (fArr5[0] * f3) + (fArr5[1] * f5) + (fArr5[2] * f7);
        float[] fArr6 = fArr3[2];
        float f10 = (f3 * fArr6[0]) + (f5 * fArr6[1]) + (f7 * fArr6[2]);
        float f11 = viewingConditions.i()[0] * f8;
        float f12 = viewingConditions.i()[1] * f9;
        float f13 = viewingConditions.i()[2] * f10;
        float fPow = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f11))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f12))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f13))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f11) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f12) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f13) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d3 = fSignum3;
        float f14 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d3)) / 11.0f;
        float f15 = ((float) (((double) (fSignum + fSignum2)) - (d3 * 2.0d))) / 9.0f;
        float f16 = fSignum2 * 20.0f;
        float f17 = (((fSignum * 20.0f) + f16) + (21.0f * fSignum3)) / 20.0f;
        float f18 = (((fSignum * 40.0f) + f16) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f15, f14)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f19 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f18 * viewingConditions.f()) / viewingConditions.a(), viewingConditions.b() * viewingConditions.j())) * 100.0f;
        float fB = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.g()) * viewingConditions.h()) * ((float) Math.sqrt((f14 * f14) + (f15 * f15)))) / (f17 + 0.305f), 0.9d));
        float fD = viewingConditions.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r4 * viewingConditions.b()) / (viewingConditions.a() + 4.0f))) * 50.0f;
        float f20 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d4 = f19;
        float fCos = ((float) Math.cos(d4)) * fLog;
        float fSin = fLog * ((float) Math.sin(d4));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f20;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    private static CamColor e(float f3, float f4, float f5) {
        return f(f3, f4, f5, ViewingConditions.f33919k);
    }

    private static CamColor f(float f3, float f4, float f5, ViewingConditions viewingConditions) {
        float fB = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(((double) f3) / 100.0d)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float fD = viewingConditions.d() * f4;
        float fSqrt = ((float) Math.sqrt(((f4 / ((float) Math.sqrt(r4))) * viewingConditions.b()) / (viewingConditions.a() + 4.0f))) * 50.0f;
        float f6 = (1.7f * f3) / ((0.007f * f3) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d3 = (3.1415927f * f5) / 180.0f;
        return new CamColor(f5, f4, f3, fB, fD, fSqrt, f6, ((float) Math.cos(d3)) * fLog, fLog * ((float) Math.sin(d3)));
    }

    public static int m(float f3, float f4, float f5) {
        return n(f3, f4, f5, ViewingConditions.f33919k);
    }

    static int n(float f3, float f4, float f5, ViewingConditions viewingConditions) {
        if (f4 < 1.0d || Math.round(f5) <= 0.0d || Math.round(f5) >= 100.0d) {
            return CamUtils.a(f5);
        }
        float fMin = f3 < 0.0f ? 0.0f : Math.min(360.0f, f3);
        CamColor camColor = null;
        boolean z2 = true;
        float f6 = 0.0f;
        float f7 = f4;
        while (Math.abs(f6 - f4) >= 0.4f) {
            CamColor camColorB = b(fMin, f7, f5);
            if (!z2) {
                if (camColorB == null) {
                    f4 = f7;
                } else {
                    f6 = f7;
                    camColor = camColorB;
                }
                f7 = ((f4 - f6) / 2.0f) + f6;
            } else {
                if (camColorB != null) {
                    return camColorB.o(viewingConditions);
                }
                f7 = ((f4 - f6) / 2.0f) + f6;
                z2 = false;
            }
        }
        return camColor == null ? CamUtils.a(f5) : camColor.o(viewingConditions);
    }

    float a(CamColor camColor) {
        float fL = l() - camColor.l();
        float fG = g() - camColor.g();
        float fH = h() - camColor.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f33883h;
    }

    float h() {
        return this.f33884i;
    }

    float i() {
        return this.f33877b;
    }

    float j() {
        return this.f33876a;
    }

    float k() {
        return this.f33878c;
    }

    float l() {
        return this.f33882g;
    }

    int o(ViewingConditions viewingConditions) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = viewingConditions.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) viewingConditions.b())) / ((double) viewingConditions.j())));
        float fG = fCos * 3846.1538f * viewingConditions.g() * viewingConditions.h();
        float f3 = fA / viewingConditions.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f4 = (((0.305f + f3) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f5 = fCos2 * f4;
        float f6 = f4 * fSin;
        float f7 = f3 * 460.0f;
        float f8 = (((451.0f * f5) + f7) + (288.0f * f6)) / 1403.0f;
        float f9 = ((f7 - (891.0f * f5)) - (261.0f * f6)) / 1403.0f;
        float fSignum = Math.signum(f8) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f8)) * 27.13d) / (400.0d - ((double) Math.abs(f8)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f9) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f9)) * 27.13d) / (400.0d - ((double) Math.abs(f9)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f7 - (f5 * 220.0f)) - (f6 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r8)) * 27.13d) / (400.0d - ((double) Math.abs(r8)))), 2.380952380952381d));
        float f10 = fSignum / viewingConditions.i()[0];
        float f11 = fSignum2 / viewingConditions.i()[1];
        float f12 = fSignum3 / viewingConditions.i()[2];
        float[][] fArr = CamUtils.f33886b;
        float[] fArr2 = fArr[0];
        float f13 = (fArr2[0] * f10) + (fArr2[1] * f11) + (fArr2[2] * f12);
        float[] fArr3 = fArr[1];
        float f14 = (fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12);
        float[] fArr4 = fArr[2];
        return ColorUtils.b(f13, f14, (f10 * fArr4[0]) + (f11 * fArr4[1]) + (f12 * fArr4[2]));
    }

    int p() {
        return o(ViewingConditions.f33919k);
    }
}
