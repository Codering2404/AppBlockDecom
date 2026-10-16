package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.bridge.gms.AdvertisingId;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1293ax implements TC {
    public final /* synthetic */ AdvertisingId A00;
    public final /* synthetic */ C1284ao A01;

    public C1293ax(C1284ao c1284ao, AdvertisingId advertisingId) {
        this.A01 = c1284ao;
        this.A00 = advertisingId;
    }

    @Override // com.facebook.ads.redexgen.core.TC
    public final boolean AAX() {
        return this.A00.isLimitAdTracking();
    }

    @Override // com.facebook.ads.redexgen.core.TC
    public final String getId() {
        return this.A00.getId();
    }
}
