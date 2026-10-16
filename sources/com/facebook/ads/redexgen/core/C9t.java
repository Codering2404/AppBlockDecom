package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9t, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C9t extends Timeline {
    public final Timeline A00;

    public C9t(Timeline timeline) {
        this.A00 = timeline;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A06() {
        return this.A00.A06();
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A07() {
        return this.A00.A07();
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public int A08(int i3, int i4, boolean z2) {
        return this.A00.A08(i3, i4, z2);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public int A0A(Object obj) {
        return this.A00.A0A(obj);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0B(boolean z2) {
        return this.A00.A0B(z2);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0C(boolean z2) {
        return this.A00.A0C(z2);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public C2175pl A0I(int i3, C2175pl c2175pl, boolean z2) {
        return this.A00.A0I(i3, c2175pl, z2);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public C2173pj A0L(int i3, C2173pj c2173pj, long j3) {
        return this.A00.A0L(i3, c2173pj, j3);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public Object A0M(int i3) {
        return this.A00.A0M(i3);
    }
}
