package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9v, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9v implements InterfaceC2057np, InterfaceC2058nq {
    public static String[] A06 = {"JXRw8dEnvO1Lr4g7cFUS0dvQrSj2gCrD", "hvHNuBxl", "xmWilmV3z2eIIj1", "UUtHfwhImwRJiupXWlBcpFq10hKf2hZ3", "Gjwbiw3zcCnfnivX0C6Z4KLegMayRhyW", "PFLAFIzQgEofbdrT2htWxpP7W2gVOOgi", "405rypbMY6P", "HWuA8Rz9jBHRgd5bymvhijPSyV36G6mN"};
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC2058nq A03;
    public C2061nt[] A04 = new C2061nt[0];
    public final InterfaceC2057np A05;

    public C9v(InterfaceC2057np interfaceC2057np, boolean z2, long j3, long j4) {
        this.A05 = interfaceC2057np;
        this.A02 = z2 ? j3 : -9223372036854775807L;
        this.A01 = j3;
        this.A00 = j4;
    }

    private C05327u A00(long j3, C05327u c05327u) {
        long toleranceBeforeUs = C5C.A0T(c05327u.A01, 0L, j3 - this.A01);
        long jA0T = C5C.A0T(c05327u.A00, 0L, this.A00 == Long.MIN_VALUE ? Long.MAX_VALUE : this.A00 - j3);
        if (toleranceBeforeUs == c05327u.A01) {
            long j4 = c05327u.A00;
            if (A06[6].length() != 11) {
                throw new RuntimeException();
            }
            A06[0] = "SySHx2FlEzism2SEaRZKk1Ki9OIwKCgL";
            if (jA0T == j4) {
                return c05327u;
            }
        }
        return new C05327u(toleranceBeforeUs, jA0T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.DW
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void ADV(InterfaceC2057np interfaceC2057np) {
        ((InterfaceC2058nq) AbstractC04323y.A01(this.A03)).ADV(this);
    }

    public static boolean A02(long j3, InterfaceC2020nE[] interfaceC2020nEArr) {
        if (j3 != 0) {
            for (InterfaceC2020nE interfaceC2020nE : interfaceC2020nEArr) {
                if (interfaceC2020nE != null) {
                    C2208qI c2208qIA92 = interfaceC2020nE.A92();
                    if (!C3J.A0G(c2208qIA92.A0W, c2208qIA92.A0R)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D19760981 for cancel request")
    public final void A4s(long j3) {
        this.A05.A4s(j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final boolean A5C(long j3) {
        return this.A05.A5C(j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final void A60(long j3, boolean z2) {
        this.A05.A60(j3, z2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final long A6r(long j3, C05327u c05327u) {
        if (j3 == this.A01) {
            return this.A01;
        }
        return this.A05.A6r(j3, A00(j3, c05327u));
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D9949576 for unstall buffer")
    public final long A76(long j3) {
        return this.A05.A76(j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final long A78() {
        long jA78 = this.A05.A78();
        if (jA78 == Long.MIN_VALUE || (this.A00 != Long.MIN_VALUE && jA78 >= this.A00)) {
            return Long.MIN_VALUE;
        }
        return jA78;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final long A8b() {
        long jA8b = this.A05.A8b();
        if (jA8b != Long.MIN_VALUE) {
            long nextLoadPositionUs = this.A00;
            if (A06[0].charAt(29) != 'C') {
                throw new RuntimeException();
            }
            A06[0] = "QBPPyRyowan8CCGBQiXIHMf03VOUOCSC";
            if (nextLoadPositionUs == Long.MIN_VALUE || jA8b < this.A00) {
                return jA8b;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final C2038nW A9M() {
        return this.A05.A9M();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final void ACS() throws IOException {
        if (0 == 0) {
            this.A05.ACS();
            return;
        }
        throw null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2058nq
    public final void AFS(InterfaceC2057np interfaceC2057np) {
        if (0 != 0) {
            return;
        }
        ((InterfaceC2058nq) AbstractC04323y.A01(this.A03)).AFS(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final void AH5(InterfaceC2058nq interfaceC2058nq, long j3) {
        this.A03 = interfaceC2058nq;
        this.A05.AH5(this, j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final long AHQ() {
        if (A03()) {
            long childDiscontinuityUs = this.A02;
            this.A02 = -9223372036854775807L;
            long jAHQ = AHQ();
            return jAHQ != -9223372036854775807L ? jAHQ : childDiscontinuityUs;
        }
        InterfaceC2057np interfaceC2057np = this.A05;
        if (A06[2].length() == 0) {
            throw new RuntimeException();
        }
        A06[6] = "ABWUoGiNBoa";
        long jAHQ2 = interfaceC2057np.AHQ();
        if (jAHQ2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long discontinuityUs = this.A01;
        boolean z2 = true;
        AbstractC04323y.A08(jAHQ2 >= discontinuityUs);
        if (this.A00 != Long.MIN_VALUE) {
            long discontinuityUs2 = this.A00;
            if (jAHQ2 > discontinuityUs2) {
                z2 = false;
            }
        }
        AbstractC04323y.A08(z2);
        return jAHQ2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final void AHW(long j3) {
        this.A05.AHW(j3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    public final long AJ8(@MetaExoPlayerCustomization long j3, boolean z2) {
        this.A02 = -9223372036854775807L;
        boolean z3 = false;
        for (C2061nt c2061nt : this.A04) {
            if (c2061nt != null) {
                c2061nt.A00();
            }
        }
        long jAJ8 = this.A05.AJ8(j3, z2);
        if (jAJ8 == j3 || (jAJ8 >= this.A01 && (this.A00 == Long.MIN_VALUE || jAJ8 <= this.A00))) {
            z3 = true;
        }
        AbstractC04323y.A08(z3);
        return jAJ8;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2057np
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long AJ9(com.facebook.ads.redexgen.core.InterfaceC2020nE[] r18, boolean[] r19, com.facebook.ads.redexgen.core.DT[] r20, boolean[] r21, long r22) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9v.AJ9(com.facebook.ads.redexgen.X.nE[], boolean[], com.facebook.ads.redexgen.X.DT[], boolean[], long):long");
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D19875605 for error load during pause")
    public final void AJc(boolean z2) {
        this.A05.AJc(z2);
    }

    @Override // com.facebook.ads.redexgen.core.DX
    @MetaExoPlayerCustomization("Added in D13267633 for lower priority during pause")
    public final void AKb(byte b3) {
        this.A05.AKb(b3);
    }
}
