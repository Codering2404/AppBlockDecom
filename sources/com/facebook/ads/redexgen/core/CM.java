package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CM implements InterfaceC1642gc {
    public final EnumC1634gU A00;
    public final AbstractC03892d A01;

    public CM(AbstractC03892d abstractC03892d, EnumC1634gU enumC1634gU) {
        this.A01 = abstractC03892d;
        this.A00 = enumC1634gU;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1642gc
    public void A4D(Map<InterfaceC1624gK, EnumC1647gh> map, Map<SyncModifiableBundle, EnumC1634gU> map2) {
        map2.put(null, this.A00);
    }
}
