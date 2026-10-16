package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1308bC {
    public static void A00(View view, boolean z2, View.OnClickListener onClickListener) {
        if (!z2) {
            view.setOnClickListener(onClickListener);
        } else {
            if (!z2) {
                return;
            }
            ViewOnClickListenerC1307bB viewOnClickListenerC1307bB = new ViewOnClickListenerC1307bB(onClickListener);
            view.setOnClickListener(viewOnClickListenerC1307bB);
            view.setOnTouchListener(new ViewOnTouchListenerC1306bA(viewOnClickListenerC1307bB));
        }
    }
}
