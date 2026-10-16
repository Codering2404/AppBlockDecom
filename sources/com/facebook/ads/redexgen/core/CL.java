package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CL implements InterfaceC1642gc {
    public final C0626Cb A00;
    public final EnumC1647gh A01;

    public CL(C0626Cb c0626Cb, EnumC1647gh enumC1647gh) {
        this.A00 = c0626Cb;
        this.A01 = enumC1647gh;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1642gc
    public void A4D(Map<InterfaceC1624gK, EnumC1647gh> map, Map<SyncModifiableBundle, EnumC1634gU> map2) {
        map.put(this.A00, this.A01);
    }
}
