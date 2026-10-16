package com.facebook.ads.redexgen.core;

import android.graphics.Paint;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1559fH extends Paint {
    public final /* synthetic */ C1560fI A00;
    public final /* synthetic */ boolean A01;

    public C1559fH(C1560fI c1560fI, boolean z2) {
        this.A00 = c1560fI;
        this.A01 = z2;
        setStyle(Paint.Style.FILL_AND_STROKE);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeWidth(3.0f);
        setAntiAlias(true);
        setColor(this.A01 ? -1 : -10066330);
    }
}
