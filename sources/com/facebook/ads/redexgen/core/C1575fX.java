package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.view.Surface;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1575fX {
    public static byte[] A02;
    public final AA A00;
    public final C2016nA A01 = new C2016nA();

    static {
        A02();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-64, -54, -66, -64, 1, -1, 19, 17, 3, -64, -66, -40, -66, -64, -74, -64, -76, -74, 6, -7, 2, -8, -7, 6, -7, 6, -35, 2, -8, -7, Ascii.FF, -74, -76, -50, -76, -74, -54, 37, -9, -6, 9, Ascii.DLE, -73, 2, -6, 8, 8, -10, -4, -6, -73, -75, -49, -75, -73, -75, 92, -82, -77, -86, -97, 92, 90, 116, 90, 92};
    }

    public C1575fX(C1648gi c1648gi) {
        InterfaceC0687Em trackSelectionFactory = new C2033nR(this.A01);
        C05659h c05659h = new C05659h(trackSelectionFactory);
        AnonymousClass74 loadControl = new C2126ox();
        this.A00 = AbstractC04876b.A00(new C2123ou(c1648gi), c05659h, loadControl, this.A01);
    }

    public static String A01(C2189pz c2189pz) {
        boolean z2 = c2189pz instanceof AD;
        String strA00 = A00(36, 2, 118);
        String strA002 = A00(0, 14, 108);
        if (z2) {
            AD ad = (AD) c2189pz;
            return A00(55, 11, 8) + ad.A03 + A00(14, 22, 98) + ad.A02 + strA002 + ad.getCause() + strA00;
        }
        return A00(41, 14, 99) + c2189pz.getMessage() + strA002 + c2189pz.getCause() + strA00;
    }

    public static boolean A03() {
        return true;
    }

    public final int A04() {
        return this.A00.A0I();
    }

    public final int A05() {
        return this.A00.A00();
    }

    public final long A06() {
        return this.A00.A7e();
    }

    public final long A07() {
        return this.A00.A7s();
    }

    public final C1573fV A08() {
        C2208qI vf = this.A00.A0K();
        if (vf == null) {
            return null;
        }
        return new C1573fV(vf.A0L, vf.A0A);
    }

    public final void A09() {
        this.A00.A0L();
    }

    public final void A0A() {
        this.A00.A02();
    }

    public final void A0B() {
        this.A00.A01();
    }

    public final void A0C(float f3) {
        this.A00.A0M(f3);
    }

    public final void A0D(long j3) {
        this.A00.A04(j3);
    }

    public final void A0E(Surface surface) {
        this.A00.A0N(surface);
    }

    public final void A0F(C1644ge c1644ge, Uri uri) {
        if (C1098Up.A2z(c1644ge, A03())) {
            C1579fb cacheManager = C1579fb.A06(c1644ge);
            C5Y cachedDataSourceFactory = cacheManager.A0H(c1644ge);
            this.A00.A0Q(new C05709o(cachedDataSourceFactory).A04(uri));
            return;
        }
        InterfaceC0646Cx mediaSource = new C05709o(new C2143pE(c1644ge, C5C.A0j(c1644ge, A00(38, 3, 100)), this.A01)).A04(uri);
        this.A00.A0Q(mediaSource);
    }

    public final void A0G(InterfaceC1572fU interfaceC1572fU) {
        this.A00.A0O(new D6(this, interfaceC1572fU));
    }

    public final void A0H(final InterfaceC1574fW interfaceC1574fW) {
        this.A00.A0P(new InterfaceC2114ol() { // from class: com.facebook.ads.redexgen.X.2s
            @Override // com.facebook.ads.redexgen.core.C5L
            public final void AGa(int i3, int i4, int i5, float f3) {
                interfaceC1574fW.AGa(i3, i4, i5, f3);
            }
        });
    }

    public final void A0I(boolean z2) {
        this.A00.A0S(z2);
    }

    public final boolean A0J() {
        return this.A00.A0T();
    }

    public final boolean A0K() {
        return this.A00.A0J() != null;
    }
}
