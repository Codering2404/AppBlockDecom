package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class ED extends RelativeLayout implements InterfaceC1536eu {
    public C0685Ek A00;

    public ED(C1648gi c1648gi) {
        super(c1648gi);
    }

    public ED(C1648gi c1648gi, AttributeSet attributeSet, int i3) {
        super(c1648gi, attributeSet, i3);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AAv(C0685Ek c0685Ek) {
        this.A00 = c0685Ek;
        A07();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1536eu
    public final void AKV(C0685Ek c0685Ek) {
        A08();
        this.A00 = null;
    }

    public C0685Ek getVideoView() {
        return this.A00;
    }
}
