package com.facebook.ads.redexgen.core;

import java.util.Collection;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1854kJ implements InterfaceC0903Mw {
    public final /* synthetic */ C1648gi A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C1854kJ(JSONObject jSONObject, C1648gi c1648gi, String str) {
        this.A02 = jSONObject;
        this.A00 = c1648gi;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0903Mw
    public final String A7O() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0903Mw
    public final Collection<String> A7p() {
        return AbstractC0904Mx.A03(this.A00, this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0903Mw
    public final EnumC0902Mv A8K() {
        return AbstractC0904Mx.A00(this.A02);
    }
}
