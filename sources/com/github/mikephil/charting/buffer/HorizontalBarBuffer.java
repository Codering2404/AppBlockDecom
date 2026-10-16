package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i3, int i4, boolean z2) {
        super(i3, i4, z2);
    }

    @Override // com.github.mikephil.charting.buffer.BarBuffer
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
                    d(f3, f7, fE, f6);
                } else {
                    float f10 = -barEntry.l();
                    float f11 = 0.0f;
                    int i4 = 0;
                    while (i4 < fArrO.length) {
                        float f12 = fArrO[i4];
                        if (f12 >= 0.0f) {
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
                        d(f4 * f17, f14, f10 * f17, f13);
                        i4++;
                        f10 = fAbs2;
                    }
                }
            }
        }
        a();
    }
}
