package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05699n extends AbstractC2063nv implements DI {
    public long A00;
    public InterfaceC04795t A01;
    public InterfaceC1889ku<InterfaceExecutorC0702Fb> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final AnonymousClass32 A07;
    public final C2197q7 A08;
    public final C5Y A09;
    public final A6 A0A;
    public final DC A0B;
    public final FF A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ku != com.google.common.base.Supplier<com.facebook.ads.androidx.media3.exoplayer.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public C05699n(C2197q7 c2197q7, C5Y c5y, DC dc, A6 a6, FF ff, int i3, InterfaceC1889ku<InterfaceExecutorC0702Fb> interfaceC1889ku) {
        this.A07 = (AnonymousClass32) AbstractC04323y.A01(c2197q7.A03);
        this.A08 = c2197q7;
        this.A09 = c5y;
        this.A0B = dc;
        this.A0A = a6 == null ? A6.A00 : a6;
        this.A0C = ff;
        this.A06 = i3;
        this.A04 = true;
        this.A00 = -9223372036854775807L;
        this.A02 = interfaceC1889ku;
    }

    private void A00() {
        final Timeline c05689m = new C05689m(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C9t(c05689m) { // from class: com.facebook.ads.redexgen.X.1e
                @Override // com.facebook.ads.redexgen.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C2175pl A0I(int i3, C2175pl c2175pl, boolean z2) {
                    super.A0I(i3, c2175pl, z2);
                    c2175pl.A05 = true;
                    return c2175pl;
                }

                @Override // com.facebook.ads.redexgen.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C2173pj A0L(int i3, C2173pj c2173pj, long j3) {
                    super.A0L(i3, c2173pj, j3);
                    c2173pj.A0F = true;
                    return c2173pj;
                }
            };
            c05689m = timeline;
        }
        A05(c05689m);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2063nv
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2063nv
    public final void A0A(InterfaceC04795t interfaceC04795t) {
        this.A01 = interfaceC04795t;
        this.A0A.AH4();
        this.A0A.AJe((Looper) AbstractC04323y.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final InterfaceC2057np A5W(C2056no c2056no, F0 f02, long j3) {
        InterfaceExecutorC0702Fb interfaceExecutorC0702Fb;
        InterfaceC2144pF interfaceC2144pFA5I = this.A09.A5I();
        if (this.A01 != null) {
            interfaceC2144pFA5I.A43(this.A01);
        }
        Uri uri = this.A07.A00;
        DD ddA5X = this.A0B.A5X(C8O.A03);
        A6 a6 = this.A0A;
        A1 a1A01 = A01(c2056no);
        FF ff = this.A0C;
        D8 d8A02 = A02(c2056no);
        String str = this.A07.A04;
        int i3 = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC0702Fb = this.A02.get();
        } else {
            interfaceExecutorC0702Fb = null;
        }
        return new C05719p(uri, interfaceC2144pFA5I, ddA5X, a6, a1A01, ff, d8A02, this, f02, str, i3, interfaceExecutorC0702Fb);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    public final void ACT() {
    }

    @Override // com.facebook.ads.redexgen.core.DI
    public final void AG0(long j3, boolean z2, boolean z3) {
        if (j3 == -9223372036854775807L) {
            j3 = this.A00;
        }
        if (!this.A04 && this.A00 == j3 && this.A05 == z2 && this.A03 == z3) {
            return;
        }
        this.A00 = j3;
        this.A05 = z2;
        this.A03 = z3;
        this.A04 = false;
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0646Cx
    public final void AHk(InterfaceC2057np interfaceC2057np) {
        ((C05719p) interfaceC2057np).A0a();
    }
}
