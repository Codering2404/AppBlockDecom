package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.AbstractC0682Eh;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0682Eh<T extends AbstractC0682Eh<T>> {
    public final int A00;
    public final int A01;
    public final C2208qI A02;
    public final C2171pg A03;

    public abstract int A08();

    public abstract boolean A09(T t2);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Eh != com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$TrackInfo<T extends com.facebook.ads.redexgen.X.Eh<T>> */
    public AbstractC0682Eh(int i3, C2171pg c2171pg, int i4) {
        this.A00 = i3;
        this.A03 = c2171pg;
        this.A01 = i4;
        this.A02 = c2171pg.A08(i4);
    }
}
