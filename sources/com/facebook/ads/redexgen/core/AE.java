package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AE implements InterfaceC2117oo, InterfaceC05277p {
    public int A00;
    public int A01;
    public long A02;
    public long A04;
    public C05307s A05;
    public C8O A06;
    public DT A07;
    public boolean A08;
    public boolean A09;
    public C2208qI[] A0A;
    public final int A0C;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D18870411: Adding start stall debug reason")
    public EnumC1774ir A0B = EnumC1774ir.A09;
    public final C05116z A0D = new C05116z();
    public long A03 = Long.MIN_VALUE;

    public abstract void A1Z();

    public abstract void A1a(long j3, boolean z2) throws AD;

    public abstract void A1c(C2208qI[] c2208qIArr, long j3, long j4) throws AD;

    public AE(int i3) {
        this.A0C = i3;
    }

    private final int A1O() {
        return this.A00;
    }

    private void A1P(long j3, boolean z2) throws AD {
        this.A08 = false;
        this.A02 = j3;
        this.A03 = j3;
        A1a(j3, z2);
    }

    public final int A1Q(long j3) {
        return ((DT) AbstractC04323y.A01(this.A07)).AK2(j3 - this.A04);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Keep track of the non-adjusted timestamp")
    public final int A1R(C05116z c05116z, C2129p0 c2129p0, int i3) {
        int iAHP = ((DT) AbstractC04323y.A01(this.A07)).AHP(c05116z, c2129p0, i3);
        if (iAHP == -4) {
            if (c2129p0.A05()) {
                this.A03 = Long.MIN_VALUE;
                return this.A08 ? -4 : -3;
            }
            c2129p0.A00 = c2129p0.A01;
            c2129p0.A01 += this.A04;
            this.A03 = Math.max(this.A03, c2129p0.A01);
        } else if (iAHP == -5) {
            C2208qI c2208qI = (C2208qI) AbstractC04323y.A01(c05116z.A00);
            if (c2208qI.A0M != Long.MAX_VALUE) {
                c05116z.A00 = c2208qI.A07().A0s(c2208qI.A0M + this.A04).A14();
            }
        }
        return iAHP;
    }

    public final AD A1S(Throwable th, C2208qI c2208qI, int i3) {
        return A1T(th, c2208qI, false, i3);
    }

    public final AD A1T(Throwable th, C2208qI c2208qI, boolean z2, int i3) {
        int iA03 = 4;
        if (c2208qI != null && !this.A09) {
            this.A09 = true;
            try {
                int formatSupport = AKM(c2208qI);
                iA03 = AbstractC05207i.A03(formatSupport);
            } catch (AD unused) {
            } catch (Throwable th2) {
                this.A09 = false;
                throw th2;
            }
            this.A09 = false;
        }
        return AD.A04(th, getName(), A1O(), c2208qI, iA03, z2, i3);
    }

    public final C05116z A1U() {
        this.A0D.A00();
        return this.A0D;
    }

    public final C05307s A1V() {
        return (C05307s) AbstractC04323y.A01(this.A05);
    }

    public final C8O A1W() {
        return (C8O) AbstractC04323y.A01(this.A06);
    }

    public void A1X() throws AD {
    }

    public void A1Y() {
    }

    public void A1b(boolean z2, boolean z3) throws AD {
    }

    public final boolean A1d() {
        return A9p() ? this.A08 : ((DT) AbstractC04323y.A01(this.A07)).AAe();
    }

    public final C2208qI[] A1e() {
        return (C2208qI[]) AbstractC04323y.A01(this.A0A);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void A5x() {
        AbstractC04323y.A08(this.A01 == 1);
        this.A0D.A00();
        this.A01 = 0;
        this.A07 = null;
        this.A0A = null;
        this.A08 = false;
        A1Z();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void A6L(C05307s c05307s, C2208qI[] c2208qIArr, DT dt, long j3, boolean z2, boolean z3, long j4, long j5) throws AD {
        AbstractC04323y.A08(this.A01 == 0);
        this.A05 = c05307s;
        this.A01 = 1;
        A1b(z2, z3);
        AIa(c2208qIArr, dt, j4, j5);
        A1P(j3, z2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final InterfaceC05277p A7D() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public AnonymousClass78 A8T() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D18870411: Adding start stall debug reason")
    public final EnumC1774ir A99() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final int A9A() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final DT A9D() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo, com.facebook.ads.redexgen.core.InterfaceC05277p
    public final int A9N() {
        return this.A0C;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05147c
    public void A9i(int i3, Object obj) throws AD {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final boolean A9p() {
        return this.A03 == Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void AA9(int i3, C8O c8o) {
        this.A00 = i3;
        this.A06 = c8o;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final boolean AAN() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void ACU() throws IOException {
        ((DT) AbstractC04323y.A01(this.A07)).ACR();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void AIa(C2208qI[] c2208qIArr, DT dt, long j3, long j4) throws AD {
        AbstractC04323y.A08(!this.A08);
        this.A07 = dt;
        if (this.A03 == Long.MIN_VALUE) {
            this.A03 = j3;
        }
        this.A0A = c2208qIArr;
        this.A04 = j4;
        A1c(c2208qIArr, j3, j4);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void AIm(long j3) throws AD {
        A1P(j3, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void AJN() {
        this.A08 = true;
    }

    public int AKO() throws AD {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void start() throws AD {
        AbstractC04323y.A08(this.A01 == 1);
        this.A01 = 2;
        A1X();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2117oo
    public final void stop() {
        AbstractC04323y.A08(this.A01 == 2);
        this.A01 = 1;
        A1Y();
    }
}
