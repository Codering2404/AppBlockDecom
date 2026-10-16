package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1976mK implements InterfaceC0788Ik {
    public final /* synthetic */ MatroskaExtractor A00;

    public C1976mK(MatroskaExtractor matroskaExtractor) {
        this.A00 = matroskaExtractor;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final void A4i(int i3, int i4, InterfaceC1999ms interfaceC1999ms) throws IOException {
        this.A00.A0U(i3, i4, interfaceC1999ms);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final void A6N(int i3) throws C3K {
        this.A00.A0S(i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final void A6a(int i3, double d3) throws C3K {
        this.A00.A0T(i3, d3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final int A7u(int i3) {
        return this.A00.A0R(i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final void AAH(int i3, long j3) throws C3K {
        this.A00.A0V(i3, j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final boolean AAW(int i3) {
        return this.A00.A0Y(i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final void AK9(int i3, long j3, long j4) throws C3K {
        this.A00.A0W(i3, j3, j4);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0788Ik
    public final void AKK(int i3, String str) throws C3K {
        this.A00.A0X(i3, str);
    }
}
