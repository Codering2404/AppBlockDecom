package com.facebook.ads.redexgen.core;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1911lG implements InterfaceC0850Kv {
    public static String[] A0C = {"sfI6nyeMmjCQTVuCF4qtLy1yjQ", "oMMkuqn3AEHt3nTJ2MOQ2D2uSIMoL5hR", "njiJ7f0cFz7yvYhslZfI3p6AsrETAKAq", "CO", "QYzjeJ7DBautBSe7mq0LOiDdFPwmAbmn", "JPkUATb4vKYtG67zqSLtKl3hIns3qHla", "LddklOggznimrifNDzyDRJC2bK2Jwwl3", "KQOf5F07mNCBpldsJ3B6cw89YczO0oD4"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public InterfaceC0755Hd A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final C04554v A09;
    public final HN A0A;
    public final String A0B;

    public C1911lG() {
        this(null);
    }

    public C1911lG(String str) {
        this.A02 = 0;
        this.A09 = new C04554v(4);
        this.A09.A0l()[0] = -1;
        this.A0A = new HN();
        this.A04 = -9223372036854775807L;
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A00(com.facebook.ads.redexgen.core.C04554v r10) {
        /*
            r9 = this;
            byte[] r8 = r10.A0l()
            int r4 = r10.A09()
            int r6 = r10.A0A()
        Lc:
            if (r4 >= r6) goto L6c
            r1 = r8[r4]
            r0 = 255(0xff, float:3.57E-43)
            r1 = r1 & r0
            r5 = 0
            r3 = 1
            if (r1 != r0) goto L6a
            r2 = 1
        L18:
            boolean r0 = r9.A08
            if (r0 == 0) goto L68
            r1 = r8[r4]
            r0 = 224(0xe0, float:3.14E-43)
            r1 = r1 & r0
            if (r1 != r0) goto L68
            r7 = 1
        L24:
            r9.A08 = r2
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1911lG.A0C
            r0 = 1
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 11
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L40
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L40:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1911lG.A0C
            java.lang.String r1 = "cXytat7P8iKtLP6TqIlLVzlvPDaZG4kX"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "jOC7bwxKPNAtckDXCFNPXzZbhL30f8uL"
            r0 = 4
            r2[r0] = r1
            if (r7 == 0) goto L65
            int r0 = r4 + 1
            r10.A0f(r0)
            r9.A08 = r5
            com.facebook.ads.redexgen.X.4v r0 = r9.A09
            byte[] r1 = r0.A0l()
            r0 = r8[r4]
            r1[r3] = r0
            r0 = 2
            r9.A00 = r0
            r9.A02 = r3
            return
        L65:
            int r4 = r4 + 1
            goto Lc
        L68:
            r7 = 0
            goto L24
        L6a:
            r2 = 0
            goto L18
        L6c:
            r10.A0f(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1911lG.A00(com.facebook.ads.redexgen.X.4v):void");
    }

    @RequiresNonNull({"output"})
    private void A01(C04554v c04554v) {
        int iMin = Math.min(c04554v.A07(), this.A01 - this.A00);
        this.A05.AIr(c04554v, iMin);
        int bytesToRead = this.A00;
        this.A00 = bytesToRead + iMin;
        int i3 = this.A00;
        int bytesToRead2 = this.A01;
        if (i3 < bytesToRead2) {
            return;
        }
        if (this.A04 != -9223372036854775807L) {
            InterfaceC0755Hd interfaceC0755Hd = this.A05;
            String[] strArr = A0C;
            String str = strArr[5];
            String str2 = strArr[6];
            int iCharAt = str.charAt(20);
            int bytesToRead3 = str2.charAt(20);
            if (iCharAt == bytesToRead3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[2] = "FJBco80YTxCtRjQ9gQqQy4qETqBIMl0G";
            strArr2[7] = "R9O1kZ0wfg8ZyFlwYf0hmCttc3ths7ud";
            interfaceC0755Hd.AIu(this.A04, 1, this.A01, 0, null);
            this.A04 += this.A03;
        }
        this.A00 = 0;
        this.A02 = 0;
    }

    @RequiresNonNull({"output"})
    private void A02(C04554v c04554v) {
        int iMin = Math.min(c04554v.A07(), 4 - this.A00);
        byte[] bArrA0l = this.A09.A0l();
        int bytesToRead = this.A00;
        c04554v.A0k(bArrA0l, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        if (bytesToRead3 < 4) {
            return;
        }
        this.A09.A0f(0);
        HN hn = this.A0A;
        int bytesToRead4 = this.A09.A0C();
        if (!hn.A00(bytesToRead4)) {
            this.A00 = 0;
            this.A02 = 1;
            return;
        }
        int bytesToRead5 = this.A0A.A02;
        this.A01 = bytesToRead5;
        if (!this.A07) {
            int bytesToRead6 = this.A0A.A04;
            long j3 = ((long) bytesToRead6) * 1000000;
            int bytesToRead7 = this.A0A.A03;
            this.A03 = j3 / ((long) bytesToRead7);
            C03992p c03992pA0h = new C03992p().A0y(this.A06).A11(this.A0A.A06).A0h(4096);
            int bytesToRead8 = this.A0A.A01;
            C03992p c03992pA0b = c03992pA0h.A0b(bytesToRead8);
            int bytesToRead9 = this.A0A.A03;
            this.A05.A6e(c03992pA0b.A0m(bytesToRead9).A10(this.A0B).A14());
            this.A07 = true;
        }
        this.A09.A0f(0);
        this.A05.AIr(this.A09, 4);
        this.A02 = 2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5A(C04554v c04554v) {
        AbstractC04323y.A02(this.A05);
        while (c04554v.A07() > 0) {
            switch (this.A02) {
                case 0:
                    A00(c04554v);
                    break;
                case 1:
                    A02(c04554v);
                    break;
                case 2:
                    A01(c04554v);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A06 = lg.A04();
        this.A05 = ha.AKS(lg.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGq(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.A04 = j3;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AJ5() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
    }
}
