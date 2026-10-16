package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0718Fs extends AbstractC1592fo {
    public final /* synthetic */ VA A00;
    public final /* synthetic */ Y2 A01;
    public final /* synthetic */ C1486e5 A02;
    public final /* synthetic */ C0716Fq A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public C0718Fs(C0716Fq c0716Fq, String str, C1486e5 c1486e5, VA va, Map map, Y2 y2) {
        this.A03 = c0716Fq;
        this.A04 = str;
        this.A02 = c1486e5;
        this.A00 = va;
        this.A05 = map;
        this.A01 = y2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1592fo
    public final void A03() {
        if (!this.A03.A02.A0Z() && !TextUtils.isEmpty(this.A04) && !this.A03.A05.get(this.A02.A02())) {
            this.A00.ABJ(this.A04, new C1305b9(this.A05).A03(this.A03.A03).A02(this.A01).A05());
            C0912Ng.A07(this.A03.A00, this.A03.A06);
            this.A03.A05.put(this.A02.A02(), true);
        }
    }
}
