package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0900Mt {
    public static byte[] A04;
    public InterfaceC0898Mr A00;
    public final C1648gi A01;
    public final VA A02;
    public final String A03;

    static {
        A0D();
    }

    public static String A0B(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A04 = new byte[]{84, 69, 69, 106, 84, 81, 108, 105, 110, 107, Framer.STDIN_REQUEST_FRAME_PREFIX, 99, 108, 105, 99, 107, 112, 102, 115, 100, 111, 88, 102, 105, 99, 88, 101, 117, 104, 112, 116, 98};
    }

    public abstract EnumC0897Mq A0G(String str);

    public AbstractC0900Mt(C1648gi c1648gi, VA va, String str) {
        this.A01 = c1648gi;
        this.A02 = va;
        this.A03 = str;
    }

    public static String A0A() {
        return A0B(16, 16, 125);
    }

    public static String A0C(AbstractC0900Mt abstractC0900Mt) {
        if (abstractC0900Mt instanceof AnonymousClass84) {
            return A0B(6, 10, 122);
        }
        return A0B(0, 6, 79);
    }

    public final InterfaceC0898Mr A0E() {
        return this.A00;
    }

    public final void A0F(InterfaceC0898Mr interfaceC0898Mr) {
        this.A00 = interfaceC0898Mr;
    }
}
