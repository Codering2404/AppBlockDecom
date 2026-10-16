package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private float A;
    private int B;
    private int C;
    private int D;
    private String[] E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f68486y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f68487z;

    public BarDataSet(List list, String str) {
        super(list, str);
        this.f68486y = 1;
        this.f68487z = Color.rgb(215, 215, 215);
        this.A = 0.0f;
        this.B = -16777216;
        this.C = 120;
        this.D = 0;
        this.E = new String[]{"Stack"};
        this.f68492x = Color.rgb(0, 0, 0);
        e1(list);
        c1(list);
    }

    private void c1(List list) {
        this.D = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            float[] fArrO = ((BarEntry) list.get(i3)).o();
            if (fArrO == null) {
                this.D++;
            } else {
                this.D += fArrO.length;
            }
        }
    }

    private void e1(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            float[] fArrO = ((BarEntry) list.get(i3)).o();
            if (fArrO != null && fArrO.length > this.f68486y) {
                this.f68486y = fArrO.length;
            }
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int A() {
        return this.f68486y;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int A0() {
        return this.C;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public boolean F0() {
        return this.f68486y > 1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public String[] G0() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public float d0() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void X0(BarEntry barEntry) {
        if (barEntry == null || Float.isNaN(barEntry.e())) {
            return;
        }
        if (barEntry.o() == null) {
            if (barEntry.e() < this.f68537u) {
                this.f68537u = barEntry.e();
            }
            if (barEntry.e() > this.f68536t) {
                this.f68536t = barEntry.e();
            }
        } else {
            if ((-barEntry.l()) < this.f68537u) {
                this.f68537u = -barEntry.l();
            }
            if (barEntry.m() > this.f68536t) {
                this.f68536t = barEntry.m();
            }
        }
        Y0(barEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int h() {
        return this.B;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public int s0() {
        return this.f68487z;
    }
}
