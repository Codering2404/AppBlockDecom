package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f68285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f68286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f68287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f68288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f68289k;

    public BarBuffer(int i3, int i4, boolean z2) {
        super(i3);
        this.f68285g = 0;
        this.f68288j = false;
        this.f68289k = 1.0f;
        this.f68286h = i4;
        this.f68287i = z2;
    }

    protected void d(float f3, float f4, float f5, float f6) {
        float[] fArr = this.f68280b;
        int i3 = this.f68279a;
        int i4 = i3 + 1;
        this.f68279a = i4;
        fArr[i3] = f3;
        int i5 = i3 + 2;
        this.f68279a = i5;
        fArr[i4] = f4;
        int i6 = i3 + 3;
        this.f68279a = i6;
        fArr[i5] = f5;
        this.f68279a = i3 + 4;
        fArr[i6] = f6;
    }

    public void e(IBarDataSet iBarDataSet) {
        float f3;
        float fAbs;
        float fAbs2;
        float f4;
        float fJ0 = iBarDataSet.J0() * this.f68281c;
        float f5 = this.f68289k / 2.0f;
        for (int i3 = 0; i3 < fJ0; i3++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.r(i3);
            if (barEntry != null) {
                float fH = barEntry.h();
                float fE = barEntry.e();
                float[] fArrO = barEntry.o();
                if (!this.f68287i || fArrO == null) {
                    float f6 = fH - f5;
                    float f7 = fH + f5;
                    if (this.f68288j) {
                        f3 = fE >= 0.0f ? fE : 0.0f;
                        if (fE > 0.0f) {
                            fE = 0.0f;
                        }
                    } else {
                        float f8 = fE >= 0.0f ? fE : 0.0f;
                        if (fE > 0.0f) {
                            fE = 0.0f;
                        }
                        float f9 = fE;
                        fE = f8;
                        f3 = f9;
                    }
                    if (fE > 0.0f) {
                        fE *= this.f68282d;
                    } else {
                        f3 *= this.f68282d;
                    }
                    d(f6, fE, f7, f3);
                } else {
                    float f10 = -barEntry.l();
                    float f11 = 0.0f;
                    int i4 = 0;
                    while (i4 < fArrO.length) {
                        float f12 = fArrO[i4];
                        if (f12 == 0.0f && (f11 == 0.0f || f10 == 0.0f)) {
                            fAbs = f12;
                            fAbs2 = f10;
                            f10 = fAbs;
                        } else if (f12 >= 0.0f) {
                            fAbs = f12 + f11;
                            fAbs2 = f10;
                            f10 = f11;
                            f11 = fAbs;
                        } else {
                            fAbs = Math.abs(f12) + f10;
                            fAbs2 = Math.abs(f12) + f10;
                        }
                        float f13 = fH - f5;
                        float f14 = fH + f5;
                        if (this.f68288j) {
                            f4 = f10 >= fAbs ? f10 : fAbs;
                            if (f10 > fAbs) {
                                f10 = fAbs;
                            }
                        } else {
                            float f15 = f10 >= fAbs ? f10 : fAbs;
                            if (f10 > fAbs) {
                                f10 = fAbs;
                            }
                            float f16 = f10;
                            f10 = f15;
                            f4 = f16;
                        }
                        float f17 = this.f68282d;
                        d(f13, f10 * f17, f14, f4 * f17);
                        i4++;
                        f10 = fAbs2;
                    }
                }
            }
        }
        a();
    }

    public void f(float f3) {
        this.f68289k = f3;
    }

    public void g(int i3) {
        this.f68285g = i3;
    }

    public void h(boolean z2) {
        this.f68288j = z2;
    }
}
