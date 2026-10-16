package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2054nm implements DT, DU {
    public final int A00;
    public final /* synthetic */ C05719p A01;

    public C2054nm(C05719p c05719p, int i3) {
        this.A01 = c05719p;
        this.A00 = i3;
    }

    @Override // com.facebook.ads.redexgen.core.DU
    @MetaExoPlayerCustomization("Added in D21840558 for FBVP")
    public final long A89() {
        return this.A01.A0L[this.A00].A0S();
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final boolean AAe() {
        return this.A01.A0f(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final void ACR() throws IOException {
        this.A01.A0d(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final int AHP(C05116z c05116z, C2129p0 c2129p0, int i3) {
        return this.A01.A0Y(this.A00, c05116z, c2129p0, i3);
    }

    @Override // com.facebook.ads.redexgen.core.DT
    public final int AK2(long j3) {
        return this.A01.A0X(this.A00, j3);
    }
}
