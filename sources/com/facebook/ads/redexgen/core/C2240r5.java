package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.r5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2240r5 {
    public static C2240r5 A03;
    public static InterfaceC2263rX A04;
    public static byte[] A05;
    public static String[] A06 = {"5DKKU3xZINN65fryyoBt5QQPLIMTkohn", "LFzimA69beWaSFXyztzupLxdNfHOQ", "XSuolM5aqTyza3oApgyv2R2QmsMDCJc3", "zWK24MgLV", "4", "qJClZMWv8", "0fmkfxUqb1vnRdlz6H0UDHtVT1WIbpOa", "oRXxD"};
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C2250rF A02;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = bArrCopyOfRange[i6];
            if (A06[4].length() == 19) {
                throw new RuntimeException();
            }
            A06[6] = "At1Zr1oMV19x7NxsOWFoG9shzyjt72Ks";
            bArrCopyOfRange[i6] = (byte) ((b3 - i5) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-89, -74, -87, -91, -72, -87};
    }

    static {
        A03();
        A03 = null;
        A04 = null;
    }

    public C2240r5(ViewpointQeConfig viewpointQeConfig, AbstractC2255rL abstractC2255rL, C2250rF c2250rF, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c2250rF;
        abstractC2255rL.A03(new C0585Aj(c2250rF));
    }

    public static ScanDelayController A00(int i3) {
        if (0 == 0) {
            return null;
        }
        throw new NullPointerException(A02(0, 6, 61));
    }

    public static C2240r5 A01(ViewpointQeConfig viewpointQeConfig, AbstractC2255rL abstractC2255rL, InterfaceC2260rQ interfaceC2260rQ, InterfaceC0586Al interfaceC0586Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        C2240r5 c2240r5 = A03;
        if (c2240r5 != null) {
            return c2240r5;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        CK ck = CK.A00;
        Handler handler = new Handler(Looper.getMainLooper());
        A00(100);
        return new C2240r5(viewpointQeConfig, abstractC2255rL, new C2250rF(viewpointQeConfig, interfaceC2260rQ, ck, interfaceC0586Al, viewpointRegistry, viewpointAutoOcclusion, handler, null), viewpointRegistry);
    }

    public final void A04(InterfaceC2254rK interfaceC2254rK) {
        this.A02.A0H(interfaceC2254rK);
    }

    public final void A05(InterfaceC2252rI interfaceC2252rI) {
        this.A02.A0I(interfaceC2252rI);
    }

    public final void A06(DspViewableNode dspViewableNode) {
        A07(dspViewableNode, null);
    }

    public final void A07(DspViewableNode dspViewableNode, C2261rU c2261rU) {
        if (this.A00.A00 && c2261rU != null) {
            this.A01.A06(dspViewableNode, c2261rU);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A08(DspViewableNode dspViewableNode, C2261rU c2261rU, C2257rN c2257rN) {
        if (this.A00.A00 && c2261rU != null) {
            this.A01.A07(dspViewableNode, c2261rU, c2257rN);
        } else {
            this.A01.A08(dspViewableNode, c2257rN);
        }
    }

    public final void A09(DspViewableNode dspViewableNode, C2257rN c2257rN) {
        A08(dspViewableNode, null, c2257rN);
    }
}
