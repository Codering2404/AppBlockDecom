package com.github.mikephil.charting.data;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PieEntry extends Entry {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f68558f;

    @Override // com.github.mikephil.charting.data.Entry
    public float h() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.h();
    }

    public String i() {
        return this.f68558f;
    }
}
