package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1650gk implements InterfaceC1578fa {
    public static byte[] A04;
    public static String[] A05 = {"5xwnqBcSwQdKZIKpCxhEhIB1ehz5rbXz", "SVnny4sMHrVxDT0mCWgznsGyNwA0K29Q", "WSedDxIDZVsWQqxlis9Ww20KqcWIyEnI", "k4ruqDXMLqmQWww9EukWiXBxmglEjOwQ", "qeuUn3ZO1g9cCLbTYKy8rfCeNqsjP", "lwrAvEwGJvKZaAaN19YZU8UxJCWRUSKU", "KAMWqSOuX5oAD", "9nA6fjXGqk7Q6o3drz3rA7fb0omaCvC"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ CallableC1049Ss A02;
    public final /* synthetic */ C1050St A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 48);
            if (A05[5].charAt(12) == 'F') {
                throw new RuntimeException();
            }
            A05[5] = "k7DX94ZUmS6mjbqg2Uqpnt5MM6ksEeAZ";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A05[5].charAt(12) == 'F') {
            throw new RuntimeException();
        }
        A05[4] = "84A19LE3N5skcLW3UxwckiEcHwoNq";
        A04 = new byte[]{Ascii.DC2, Ascii.VT, 8, Ascii.VT, Ascii.FF, Ascii.DC4, Ascii.VT, -9, -22, -27, -26, -16};
    }

    static {
        A01();
    }

    public C1650gk(CallableC1049Ss callableC1049Ss, C1050St c1050St, long j3, long j4) {
        this.A02 = callableC1049Ss;
        this.A03 = c1050St;
        this.A00 = j3;
        this.A01 = j4;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1578fa
    public final void ADj(boolean z2) {
        if (T0.A06(this.A02.A01.A04)) {
            C1056Sz c1056Sz = new C1056Sz(this.A03.A06, this.A03.A07, A00(7, 5, 81), this.A03.A02, this.A03.A08);
            T0.A04(this.A02.A01.A04, c1056Sz, z2);
            if (!z2) {
                T0.A05(this.A02.A01.A04, this.A03.A06, this.A03.A07, this.A03.A08, A00(7, 5, 81), this.A03.A02, 2112, null, Long.valueOf(this.A00), Long.valueOf(System.currentTimeMillis() - this.A01), null);
            }
            C1054Sx.A0A().put(c1056Sz.A04, c1056Sz);
        }
        try {
            this.A02.A00.put(true);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1578fa
    public final void ADr(Throwable th) {
        if (T0.A06(this.A02.A01.A04)) {
            T0.A05(this.A02.A01.A04, this.A03.A06, this.A03.A07, this.A03.A08, A00(7, 5, 81), this.A03.A02, 2119, th != null ? th.toString() : A00(0, 7, 109), null, Long.valueOf(System.currentTimeMillis() - this.A01), null);
        }
        try {
            this.A02.A00.put(false);
        } catch (InterruptedException unused) {
        }
    }
}
