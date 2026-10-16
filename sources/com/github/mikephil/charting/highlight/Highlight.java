package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Highlight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f68578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f68579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f68580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f68581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f68582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f68583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f68584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private YAxis.AxisDependency f68585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f68586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f68587j;

    public Highlight(float f3, float f4, float f5, float f6, int i3, YAxis.AxisDependency axisDependency) {
        this.f68582e = -1;
        this.f68584g = -1;
        this.f68578a = f3;
        this.f68579b = f4;
        this.f68580c = f5;
        this.f68581d = f6;
        this.f68583f = i3;
        this.f68585h = axisDependency;
    }

    public boolean a(Highlight highlight) {
        return highlight != null && this.f68583f == highlight.f68583f && this.f68578a == highlight.f68578a && this.f68584g == highlight.f68584g && this.f68582e == highlight.f68582e;
    }

    public YAxis.AxisDependency b() {
        return this.f68585h;
    }

    public int c() {
        return this.f68582e;
    }

    public int d() {
        return this.f68583f;
    }

    public float e() {
        return this.f68586i;
    }

    public float f() {
        return this.f68587j;
    }

    public int g() {
        return this.f68584g;
    }

    public float h() {
        return this.f68578a;
    }

    public float i() {
        return this.f68580c;
    }

    public float j() {
        return this.f68579b;
    }

    public float k() {
        return this.f68581d;
    }

    public void l(int i3) {
        this.f68582e = i3;
    }

    public void m(float f3, float f4) {
        this.f68586i = f3;
        this.f68587j = f4;
    }

    public String toString() {
        return "Highlight, x: " + this.f68578a + ", y: " + this.f68579b + ", dataSetIndex: " + this.f68583f + ", stackIndex (only stacked barentry): " + this.f68584g;
    }

    public Highlight(float f3, float f4, float f5, float f6, int i3, int i4, YAxis.AxisDependency axisDependency) {
        this(f3, f4, f5, f6, i3, axisDependency);
        this.f68584g = i4;
    }
}
