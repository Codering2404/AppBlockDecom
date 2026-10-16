package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class HandlerC0957Oz extends Handler {
    public final /* synthetic */ P2 A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0957Oz(P2 p22, Looper looper) {
        super(looper);
        this.A00 = p22;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.A00.A02();
                break;
            default:
                super.handleMessage(message);
                break;
        }
    }
}
