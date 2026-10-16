package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C8T extends AbstractC2127oy<C8S, C8P, C1940lj> implements InterfaceC1947lq {
    public static byte[] A01;
    public static String[] A02 = {"gN8", "v0q6HziqC5r28rLi1ZsQmD2OK0fgspik", "XftI4eRfVNg33Op0jQPz8O6PbCkMHbWE", "SdzNGuU6dc81VqISrLBD", "AmzsDcSyCxTNGO", "BjhKb3Az99p878kvj1gxEmyEzdFIjRD", "VkdZ1nUYKY17rCLbk1Npuh3A0WHSXOLE", "WDjquUi0atGhsKhHWhKEDeyGOzHRt12i"};
    public final String A00;

    public static String A0L(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = (byte) ((bArrCopyOfRange[i6] - i5) - 100);
            if (A02[0].length() != 3) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "7OO3CpMfw2stGNBOXFHDwltwdlKTQaUN";
            strArr[7] = "XdJDd6VP529P2X7c3MAKusUlyNrjc2WF";
            bArrCopyOfRange[i6] = b3;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        if (A02[0].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[5] = "V56IsTeJwH5mFHCmn3IS5snx7jCRlGG";
        strArr[4] = "owU73l6HwKvTqc";
        A01 = new byte[]{Ascii.FS, 53, 44, 63, 55, 44, 42, 59, 44, 43, -25, 43, 44, 42, 54, 43, 44, -25, 44, 57, 57, 54, 57};
    }

    public abstract InterfaceC0812Jj A0g(byte[] bArr, int i3, boolean z2) throws C1940lj;

    static {
        A0M();
    }

    public C8T(String str) {
        super(new C8S[2], new C8P[2]);
        this.A00 = str;
        A0d(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.1Y] */
    @Override // com.facebook.ads.redexgen.core.AbstractC2127oy
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final C1Y A0c() {
        return new C8P(this) { // from class: com.facebook.ads.redexgen.X.1Y
            public final C8T A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.core.C8P, com.facebook.ads.redexgen.core.AbstractC2128oz
            public final void A0B() {
                this.A00.A0h(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2127oy
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public final C1940lj A0Y(C8S c8s, C8P c8p, boolean z2) {
        try {
            ByteBuffer inputData = (ByteBuffer) AbstractC04323y.A01(c8s.A02);
            c8p.A0C(c8s.A01, A0g(inputData.array(), inputData.limit(), z2), c8s.A00);
            c8p.A01(Integer.MIN_VALUE);
            return null;
        } catch (C1940lj e3) {
            return e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2127oy
    /* JADX INFO: renamed from: A0J, reason: merged with bridge method [inline-methods] */
    public final C1940lj A0Z(Throwable th) {
        return new C1940lj(A0L(0, 23, 99), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2127oy
    /* JADX INFO: renamed from: A0K, reason: merged with bridge method [inline-methods] */
    public final C8S A0a() {
        return new C8S();
    }

    public final void A0h(C8P c8p) {
        super.A0f(c8p);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1947lq
    public final void AJh(long j3) {
    }
}
