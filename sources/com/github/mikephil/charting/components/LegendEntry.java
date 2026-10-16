package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LegendEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f68446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Legend.LegendForm f68447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f68448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f68449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DashPathEffect f68450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f68451f;

    public LegendEntry(String str, Legend.LegendForm legendForm, float f3, float f4, DashPathEffect dashPathEffect, int i3) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.NONE;
        this.f68446a = str;
        this.f68447b = legendForm;
        this.f68448c = f3;
        this.f68449d = f4;
        this.f68450e = dashPathEffect;
        this.f68451f = i3;
    }
}
