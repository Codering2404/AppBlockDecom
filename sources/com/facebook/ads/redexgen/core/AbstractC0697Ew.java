package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0697Ew {
    public InterfaceC0696Ev A00;
    public F6 A01;

    public abstract boolean A0Y();

    public abstract C0698Ex A0b(InterfaceC05277p[] interfaceC05277pArr, C2038nW c2038nW, C2056no c2056no, Timeline timeline) throws AD;

    public abstract void A0c(Object obj);

    public final F6 A00() {
        return (F6) AbstractC04323y.A02(this.A01);
    }

    public final void A01() {
        if (this.A00 != null) {
            this.A00.AGD();
        }
    }

    public final void A02(InterfaceC0696Ev interfaceC0696Ev, F6 f6) {
        this.A00 = interfaceC0696Ev;
        this.A01 = f6;
    }
}
