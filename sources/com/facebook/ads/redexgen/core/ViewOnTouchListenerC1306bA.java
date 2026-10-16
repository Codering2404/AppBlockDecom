package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1306bA implements View.OnTouchListener {
    public final /* synthetic */ ViewOnClickListenerC1307bB A00;

    public ViewOnTouchListenerC1306bA(ViewOnClickListenerC1307bB viewOnClickListenerC1307bB) {
        this.A00 = viewOnClickListenerC1307bB;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.A00.A00(motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }
}
