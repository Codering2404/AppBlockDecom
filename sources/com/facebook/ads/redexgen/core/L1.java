package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L1 {
    public static String[] A0G = {"4S0ZR9", "9atY4pLS3", "JCkQ", "0FGnuhRUJbXFjAeocMQA4", "Bc2FjzyWuEwoYoDKosvue", "DSb6itpNp95G1DjaOdl5F45O", "d2IfSwPvc8yd2jGVLBTV47FBT3G8Pl4J", "SXUDcryZ"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public HR A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;

    public L1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A00(L1 l12) {
        if (!this.A0F) {
            return false;
        }
        if (!l12.A0F) {
            return true;
        }
        HR hr = (HR) AbstractC04323y.A02(this.A09);
        HR spsData = l12.A09;
        HR otherSpsData = (HR) AbstractC04323y.A02(spsData);
        if (this.A03 == l12.A03 && this.A07 == l12.A07 && this.A0C == l12.A0C && ((!this.A0B || !l12.A0B || this.A0A == l12.A0A) && ((this.A05 == l12.A05 || (this.A05 != 0 && l12.A05 != 0)) && ((hr.A07 != 0 || otherSpsData.A07 != 0 || (this.A06 == l12.A06 && this.A02 == l12.A02)) && ((hr.A07 != 1 || otherSpsData.A07 != 1 || (this.A00 == l12.A00 && this.A01 == l12.A01)) && this.A0E == l12.A0E))))) {
            boolean z2 = this.A0E;
            if (A0G[6].charAt(8) == '9') {
                throw new RuntimeException();
            }
            A0G[6] = "vYoSPXEMP2H1rloX7Zmdh99svIQCcR37";
            if (!z2 || this.A04 == l12.A04) {
                return false;
            }
        }
        return true;
    }

    public final void A02() {
        this.A0D = false;
        this.A0F = false;
    }

    public final void A03(int i3) {
        this.A08 = i3;
        this.A0D = true;
    }

    public final void A04(HR hr, int i3, int i4, int i5, int i6, boolean z2, boolean z3, boolean z4, boolean z5, int i7, int i8, int i9, int i10, int i11) {
        this.A09 = hr;
        this.A05 = i3;
        this.A08 = i4;
        this.A03 = i5;
        this.A07 = i6;
        this.A0C = z2;
        this.A0B = z3;
        this.A0A = z4;
        this.A0E = z5;
        this.A04 = i7;
        this.A06 = i8;
        this.A02 = i9;
        this.A00 = i10;
        this.A01 = i11;
        this.A0F = true;
        this.A0D = true;
    }

    public final boolean A05() {
        return this.A0D && (this.A08 == 7 || this.A08 == 2);
    }
}
