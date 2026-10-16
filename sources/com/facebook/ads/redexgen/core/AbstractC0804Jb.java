package com.facebook.ads.redexgen.core;

import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0804Jb {
    public static String[] A0D = {"XeH1UKKuz1EDpBeQKhAXaKjrjZgsodJU", "Qh9sfVWsiKdbMkoZ0Fly5mM08PFSskfX", "g5Vgu", "IbV76iHRvjKg6MHaSQGzPOhr6f1ApNQX", "p6vckuBwU2Q2AllMmzSrbAD", "CWShENYx4MqsFhdcA74Ut20lXSF9FxoW", "efy3JamC8vBQUYLSbDR2yGzuJR", "AxMKck"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public HA A06;
    public InterfaceC0755Hd A07;
    public JY A08;
    public boolean A0A;
    public boolean A0B;
    public final JW A0C = new JW();
    public C0803Ja A09 = new C0803Ja();

    public abstract long A09(C04554v c04554v);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean A0C(C04554v c04554v, long j3, C0803Ja c0803Ja) throws IOException;

    @RequiresNonNull({"trackOutput"})
    private int A00(InterfaceC1999ms interfaceC1999ms) throws IOException {
        if (A03(interfaceC1999ms)) {
            this.A00 = this.A09.A00.A0G;
            if (!this.A0A) {
                this.A07.A6e(this.A09.A00);
                this.A0A = true;
            }
            JY jy = this.A09.A01;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                throw new RuntimeException();
            }
            A0D[7] = "ikA5IIIrIRBN8L1z";
            if (jy != null) {
                this.A08 = this.A09.A01;
            } else if (interfaceC1999ms.A8O() == -1) {
                this.A08 = new C1951lu();
            } else {
                JX jxA02 = this.A0C.A02();
                this.A08 = new C1957m0(this, this.A04, interfaceC1999ms.A8O(), jxA02.A01 + jxA02.A00, jxA02.A05, (jxA02.A04 & 4) != 0);
            }
            this.A01 = 2;
            this.A0C.A04();
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(com.facebook.ads.redexgen.core.InterfaceC1999ms r19, com.facebook.ads.redexgen.core.HV r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC0804Jb.A01(com.facebook.ads.redexgen.X.ms, com.facebook.ads.redexgen.X.HV):int");
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void A02() {
        AbstractC04323y.A02(this.A07);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    private boolean A03(InterfaceC1999ms interfaceC1999ms) throws IOException {
        while (true) {
            JW jw = this.A0C;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                break;
            }
            A0D[7] = "RUb6h5R55PuDixsZqq";
            if (!jw.A05(interfaceC1999ms)) {
                this.A01 = 3;
                return false;
            }
            this.A03 = interfaceC1999ms.A8n() - this.A04;
            if (A0C(this.A0C.A01(), this.A04, this.A09)) {
                long jA8n = interfaceC1999ms.A8n();
                if (A0D[7].length() == 17) {
                    break;
                }
                A0D[0] = "MjaWWlFxdP245keDLyVkXHL1D0C1Hazn";
                this.A04 = jA8n;
            } else {
                return true;
            }
        }
        throw new RuntimeException();
    }

    public final int A04(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        A02();
        switch (this.A01) {
            case 0:
                return A00(interfaceC1999ms);
            case 1:
                interfaceC1999ms.AK3((int) this.A04);
                this.A01 = 2;
                return 0;
            case 2:
                return A01(interfaceC1999ms, hv);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A05(long j3) {
        return (1000000 * j3) / ((long) this.A00);
    }

    public final long A06(long j3) {
        return (((long) this.A00) * j3) / 1000000;
    }

    public final void A07(long j3, long j4) {
        this.A0C.A03();
        if (j3 == 0) {
            A0B(!this.A0B);
        } else {
            if (this.A01 == 0) {
                return;
            }
            this.A05 = A06(j4);
            ((JY) C5C.A0f(this.A08)).AKC(this.A05);
            this.A01 = 2;
        }
    }

    public final void A08(HA ha, InterfaceC0755Hd interfaceC0755Hd) {
        this.A06 = ha;
        this.A07 = interfaceC0755Hd;
        A0B(true);
    }

    public void A0A(long j3) {
        this.A02 = j3;
    }

    public void A0B(boolean z2) {
        if (z2) {
            this.A09 = new C0803Ja();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }
}
