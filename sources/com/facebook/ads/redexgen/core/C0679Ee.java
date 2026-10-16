package com.facebook.ads.redexgen.core;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0679Ee implements Spatializer$OnSpatializerStateChangedListener {
    public final /* synthetic */ C0680Ef A00;
    public final /* synthetic */ C05659h A01;

    public C0679Ee(C0680Ef c0680Ef, C05659h c05659h) {
        this.A00 = c0680Ef;
        this.A01 = c05659h;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z2) {
        this.A01.A0L();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z2) {
        this.A01.A0L();
    }
}
