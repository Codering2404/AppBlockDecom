package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnAttachStateChangeListenerC1265aV implements View.OnAttachStateChangeListener {
    public final /* synthetic */ C1266aW A00;

    public ViewOnAttachStateChangeListenerC1265aV(C1266aW c1266aW) {
        this.A00 = c1266aW;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.A00.A09();
        this.A00.A03.setOnClickListener(null);
    }
}
