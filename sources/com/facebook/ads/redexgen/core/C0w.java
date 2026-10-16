package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0w, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0w extends C1J {
    public C6X A00;
    public List<C1486e5> A01;

    public C0w(C1648gi c1648gi) {
        super(c1648gi);
        this.A00 = new C6X(this, 1, null, null, null);
    }

    public final void A20(C1593fp c1593fp) {
        if (this.A00 != null) {
            this.A00.A0c(c1593fp);
        }
    }

    public C6X getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0d(this.A01);
    }
}
