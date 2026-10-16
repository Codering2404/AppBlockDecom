package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Description extends ComponentBase {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MPPointF f68402h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f68401g = "Description Label";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint.Align f68403i = Paint.Align.RIGHT;

    public Description() {
        this.f68399e = Utils.e(8.0f);
    }

    public MPPointF l() {
        return this.f68402h;
    }

    public String m() {
        return this.f68401g;
    }

    public Paint.Align n() {
        return this.f68403i;
    }

    public void o(String str) {
        this.f68401g = str;
    }
}
