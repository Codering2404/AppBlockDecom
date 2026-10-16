package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1523eh implements View.OnTouchListener {
    public final /* synthetic */ C0685Ek A00;

    public ViewOnTouchListenerC1523eh(C0685Ek c0685Ek) {
        this.A00 = c0685Ek;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A00.A0C.A02(new C0669Du(view, motionEvent));
        return false;
    }
}
