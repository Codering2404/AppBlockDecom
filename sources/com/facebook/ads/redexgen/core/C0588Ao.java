package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0588Ao implements SharedViewpointManager {
    public static boolean A07;
    public static byte[] A08;
    public InterfaceC2264rY A00;
    public InterfaceC2252rI A01;
    public C2240r5 A02;
    public final InterfaceC2253rJ A04;
    public final ViewpointQeConfig A05;
    public final LinkedHashMap<Integer, Runnable> A06 = new LinkedHashMap<>();
    public final InterfaceC2252rI A03 = new C0589Ap(this);

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-28};
    }

    static {
        A04();
        A07 = false;
    }

    public C0588Ao(ViewpointQeConfig viewpointQeConfig, InterfaceC2264rY interfaceC2264rY, InterfaceC2253rJ interfaceC2253rJ) {
        this.A05 = viewpointQeConfig;
        this.A00 = interfaceC2264rY;
        this.A04 = interfaceC2253rJ;
    }

    public static C0588Ao A01() {
        return new C0588Ao(new ViewpointQeConfig(), new C0591Ar(), null);
    }

    private void A05(AbstractC2255rL abstractC2255rL, InterfaceC2260rQ interfaceC2260rQ, InterfaceC0586Al interfaceC0586Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        this.A02 = C2240r5.A01(this.A05, abstractC2255rL, interfaceC2260rQ, interfaceC0586Al, viewpointAutoOcclusion);
        if (0 != 0) {
            this.A02.A04(null);
        }
        this.A02.A05(this.A03);
    }

    private void A06(DspViewableNode dspViewableNode, C2261rU c2261rU) {
        C2240r5 c2240r5 = this.A02;
        if (c2240r5 != null && dspViewableNode != null) {
            if (this.A05.A00 && c2261rU != null) {
                c2240r5.A07(dspViewableNode, c2261rU);
            } else {
                c2240r5.A06(dspViewableNode);
            }
        }
    }

    private void A07(DspViewableNode dspViewableNode, C2261rU c2261rU, C2257rN c2257rN) {
        C2240r5 c2240r5 = this.A02;
        if (c2240r5 != null && dspViewableNode != null && c2257rN != null) {
            if (this.A05.A00 && c2261rU != null) {
                c2257rN.A02 = dspViewableNode.hashCode() + A02(0, 1, 27) + c2257rN.A08 + c2261rU;
                c2240r5.A08(dspViewableNode, c2261rU, c2257rN);
            } else {
                c2240r5.A09(dspViewableNode, c2257rN);
            }
        }
    }

    public final void A08(View view) {
        A06(view != null ? ViewpointViewNode.A00(view) : null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public final void A09(View view, C2257rN<?, ?> c2257rN) {
        A07(view != null ? ViewpointViewNode.A00(view) : null, null, c2257rN);
    }

    public final void A0A(AbstractC2255rL abstractC2255rL, View view) {
        if (abstractC2255rL != null && view != null) {
            A05(abstractC2255rL, new C0590Aq(view, this.A00), new C03801u(null), null);
        }
    }
}
