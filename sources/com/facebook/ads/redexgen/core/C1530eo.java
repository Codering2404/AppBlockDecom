package com.facebook.ads.redexgen.core;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1530eo extends ViewOutlineProvider {
    public final /* synthetic */ float A00;
    public final /* synthetic */ C1532eq A01;

    public C1530eo(C1532eq c1532eq, float f3) {
        this.A01 = c1532eq;
        this.A00 = f3;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.A00);
    }
}
