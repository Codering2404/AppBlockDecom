package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ht, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1720ht implements InterfaceC0990Qk {
    public static byte[] A07;
    public static String[] A08 = {"t5607oHfL2MNwmRFcsOr1jnyxzutumg5", "jNVCF7hNBx7qTlxJtSxtZf62y0YMH9ti", "vdh53KDEVDvYPF4U9zJ9CmemLfeqkfcW", "xmowDJGre", "ZTG0qcJaBRai17vkpDLZ7jbeFwjjrIPL", "kzc7Q54viT3CLivIFTQawvhHzc5bSJU6", "6m9Kb2lg4QS4P0ZcGJ2XwsRwfv4UyCAv", "gH"};
    public int A00;
    public PD<QN> A01;
    public final QM A02;
    public final C0991Ql A03;
    public final ArrayList<QN> A04;
    public final ArrayList<QN> A05;
    public final boolean A06;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{Ascii.ETB, Ascii.EM, Ascii.DLE, 19, 2, Ascii.SUB, Ascii.SI, Ascii.FF, 2, 7};
    }

    static {
        A02();
    }

    public C1720ht(QM qm) {
        this(qm, false);
    }

    public C1720ht(QM qm, boolean z2) {
        this.A01 = new C1731i6(30);
        this.A04 = new ArrayList<>();
        this.A05 = new ArrayList<>();
        this.A00 = 0;
        this.A02 = qm;
        this.A06 = z2;
        this.A03 = new C0991Ql(this);
    }

    private final int A00(int i3, int i4) {
        int count = this.A05.size();
        if (i4 < count) {
            this.A05.get(i4);
            throw new NullPointerException(A01(0, 3, 126));
        }
        return i3;
    }

    private final void A03(List<QN> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            list.get(i3);
            A0A(null);
        }
        list.clear();
        if (A08[1].charAt(29) != '9') {
            throw new RuntimeException();
        }
        A08[2] = "ayjYK9F9Z6sDhNCNS52R1Qcr5XRGx639";
    }

    public final int A04(int i3) {
        return A00(i3, 0);
    }

    public final int A05(int i3) {
        int size = this.A04.size();
        if (0 < size) {
            this.A04.get(0);
            throw new NullPointerException(A01(0, 3, 126));
        }
        return i3;
    }

    public final void A06() {
        int count = this.A05.size();
        if (0 < count) {
            QM qm = this.A02;
            this.A05.get(0);
            String[] strArr = A08;
            String str = strArr[0];
            String str2 = strArr[4];
            int i3 = str.charAt(3);
            int count2 = str2.charAt(3);
            if (i3 != count2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "Yhl0jQrdp33aIQ4Nx5XRCxKVlJRMQ99k";
            strArr2[4] = "te80aWrb7iKuE4ta48s0tNKQ3kiAwVCD";
            qm.ADg(null);
            throw null;
        }
        A03(this.A05);
        this.A00 = 0;
    }

    public final void A07() {
        A06();
        int count = this.A04.size();
        if (0 < count) {
            this.A04.get(0);
            throw new NullPointerException(A01(0, 3, 126));
        }
        A03(this.A04);
        this.A00 = 0;
    }

    public final void A08() {
        this.A03.A04(this.A04);
        int count = this.A04.size();
        if (0 < count) {
            this.A04.get(0);
            throw new NullPointerException(A01(0, 3, 126));
        }
        this.A04.clear();
    }

    public final void A09() {
        A03(this.A04);
        A03(this.A05);
        this.A00 = 0;
    }

    public final void A0A(QN qn) {
        if (!this.A06) {
            throw new NullPointerException(A01(3, 7, 105));
        }
    }

    public final boolean A0B() {
        return this.A04.size() > 0;
    }

    public final boolean A0C() {
        return (this.A05.isEmpty() || this.A04.isEmpty()) ? false : true;
    }

    public final boolean A0D(int i3) {
        return (this.A00 & i3) != 0;
    }
}
