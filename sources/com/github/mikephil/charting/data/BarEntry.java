package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Range;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarEntry extends Entry {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f68488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Range[] f68489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f68490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f68491i;

    public BarEntry(float f3, float f4) {
        super(f3, f4);
    }

    private void i() {
        float[] fArr = this.f68488f;
        if (fArr == null) {
            this.f68490h = 0.0f;
            this.f68491i = 0.0f;
            return;
        }
        float fAbs = 0.0f;
        float f3 = 0.0f;
        for (float f4 : fArr) {
            if (f4 <= 0.0f) {
                fAbs += Math.abs(f4);
            } else {
                f3 += f4;
            }
        }
        this.f68490h = fAbs;
        this.f68491i = f3;
    }

    private static float k(float[] fArr) {
        float f3 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f4 : fArr) {
            f3 += f4;
        }
        return f3;
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float e() {
        return super.e();
    }

    protected void j() {
        float[] fArrO = o();
        if (fArrO == null || fArrO.length == 0) {
            return;
        }
        this.f68489g = new Range[fArrO.length];
        float f3 = -l();
        int i3 = 0;
        float f4 = 0.0f;
        while (true) {
            Range[] rangeArr = this.f68489g;
            if (i3 >= rangeArr.length) {
                return;
            }
            float f5 = fArrO[i3];
            if (f5 < 0.0f) {
                float f6 = f3 - f5;
                rangeArr[i3] = new Range(f3, f6);
                f3 = f6;
            } else {
                float f7 = f5 + f4;
                rangeArr[i3] = new Range(f4, f7);
                f4 = f7;
            }
            i3++;
        }
    }

    public float l() {
        return this.f68490h;
    }

    public float m() {
        return this.f68491i;
    }

    public Range[] n() {
        return this.f68489g;
    }

    public float[] o() {
        return this.f68488f;
    }

    public boolean p() {
        return this.f68488f != null;
    }

    public BarEntry(float f3, float[] fArr) {
        super(f3, k(fArr));
        this.f68488f = fArr;
        i();
        j();
    }
}
