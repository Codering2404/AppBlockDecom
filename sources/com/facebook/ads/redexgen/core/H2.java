package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class H2 {
    public static byte[] A04;
    public static String[] A05 = {"uP2VmRjmPrkQ", "gRGWgf4lLYF9Rif8PQPDNbGokb9BUMtV", "bSjOyzwe8Lqn79dPeHIi8kfJVgfNJaEZ", "7R1XMZQjg8S2TiXm1wE8kLqT1leJFKD3", "sD", "qKJRf3b", "Q40N8hoONMcQBFaHNU", "iAP6W7CwppN1UlUQVXHbR"};
    public C0748Gw A00;
    public final int A01;
    public final C2006n0 A02;
    public final H1 A03;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, Framer.STDIN_FRAME_PREFIX, 47, 61, 43};
    }

    static {
        A03();
    }

    public H2(InterfaceC0749Gx interfaceC0749Gx, H1 h12, long j3, long j4, long j5, long j6, long j7, long j8, int i3) {
        this.A03 = h12;
        this.A01 = i3;
        this.A02 = new C2006n0(interfaceC0749Gx, j3, j4, j5, j6, j7, j8);
    }

    private final int A00(InterfaceC1999ms interfaceC1999ms, long j3, HV hv) {
        if (j3 != interfaceC1999ms.A8n()) {
            hv.A00 = j3;
            return 1;
        }
        if (A05[5].length() != 7) {
            throw new RuntimeException();
        }
        A05[4] = "eb0wJDSKJb6zWnRAqReB9UTGfXv";
        return 0;
    }

    private final C0748Gw A01(long j3) {
        return new C0748Gw(j3, this.A02.A05(j3), this.A02.A05, this.A02.A02, this.A02.A04, this.A02.A01, this.A02.A00);
    }

    private final void A04(boolean z2, long j3) {
        this.A00 = null;
        this.A03.AFs();
    }

    private final boolean A05(InterfaceC1999ms interfaceC1999ms, long j3) throws IOException {
        long jA8n = j3 - interfaceC1999ms.A8n();
        if (jA8n >= 0 && jA8n <= 262144) {
            interfaceC1999ms.AK3((int) jA8n);
            return true;
        }
        return false;
    }

    public final int A06(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        while (true) {
            C0748Gw c0748Gw = (C0748Gw) AbstractC04323y.A02(this.A00);
            long jA01 = c0748Gw.A01();
            long jA00 = c0748Gw.A00();
            long jA02 = c0748Gw.A02();
            if (jA00 - jA01 <= this.A01) {
                A04(false, jA01);
                String[] strArr = A05;
                if (strArr[3].charAt(1) != strArr[1].charAt(1)) {
                    throw new RuntimeException();
                }
                A05[5] = "cjf3Phs";
                return A00(interfaceC1999ms, jA01, hv);
            }
            if (!A05(interfaceC1999ms, jA02)) {
                return A00(interfaceC1999ms, jA02, hv);
            }
            interfaceC1999ms.AIl();
            C0751Gz c0751GzAIw = this.A03.AIw(interfaceC1999ms, c0748Gw.A04());
            switch (c0751GzAIw.A00) {
                case -3:
                    A04(false, jA02);
                    return A00(interfaceC1999ms, jA02, hv);
                case -2:
                    c0748Gw.A0D(c0751GzAIw.A02, c0751GzAIw.A01);
                    break;
                case -1:
                    c0748Gw.A0C(c0751GzAIw.A02, c0751GzAIw.A01);
                    break;
                case 0:
                    A05(interfaceC1999ms, c0751GzAIw.A01);
                    long floorPosition = c0751GzAIw.A01;
                    A04(true, floorPosition);
                    return A00(interfaceC1999ms, c0751GzAIw.A01, hv);
                default:
                    throw new IllegalStateException(A02(0, 12, 109));
            }
        }
    }

    public final C2006n0 A07() {
        return this.A02;
    }

    public final void A08(long j3) {
        if (this.A00 != null && this.A00.A03() == j3) {
            return;
        }
        this.A00 = A01(j3);
    }

    public final boolean A09() {
        return this.A00 != null;
    }
}
