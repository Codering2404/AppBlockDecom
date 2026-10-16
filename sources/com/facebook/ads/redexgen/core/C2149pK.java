package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2149pK implements C4W {
    public Message A00;
    public C2148pJ A01;

    public C2149pK() {
    }

    private void A00() {
        this.A00 = null;
        this.A01 = null;
        C2148pJ.A01(this);
    }

    public final C2149pK A01(Message message, C2148pJ c2148pJ) {
        this.A00 = message;
        this.A01 = c2148pJ;
        return this;
    }

    public final void A02() {
        ((Message) AbstractC04323y.A01(this.A00)).sendToTarget();
        A00();
    }

    public final boolean A03(Handler handler) {
        boolean success = handler.sendMessageAtFrontOfQueue((Message) AbstractC04323y.A01(this.A00));
        A00();
        return success;
    }
}
