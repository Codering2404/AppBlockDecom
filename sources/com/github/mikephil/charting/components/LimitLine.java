package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LimitLine extends ComponentBase {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f68452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f68453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f68454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint.Style f68455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f68456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private DashPathEffect f68457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LimitLabelPosition f68458m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public DashPathEffect l() {
        return this.f68457l;
    }

    public String m() {
        return this.f68456k;
    }

    public LimitLabelPosition n() {
        return this.f68458m;
    }

    public float o() {
        return this.f68452g;
    }

    public int p() {
        return this.f68454i;
    }

    public float q() {
        return this.f68453h;
    }

    public Paint.Style r() {
        return this.f68455j;
    }
}
