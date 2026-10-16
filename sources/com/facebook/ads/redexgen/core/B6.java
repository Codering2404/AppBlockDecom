package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class B6 {
    public static byte[] A03;
    public boolean A00 = false;
    public final ConcurrentLinkedQueue<B4> A01 = new ConcurrentLinkedQueue<>();
    public final /* synthetic */ B7 A02;

    static {
        A05();
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-89, -38, -59, -57, -46, -42, -53, -47, -48, -126, -39, -54, -57, -48, -126, -42, -44, -37, -53, -48, -55, -126, -42, -47, -126, -53, -48, -43, -42, -61, -48, -42, -53, -61, -42, -57, -126, -121, -43, -100, -126, -121, -43, -72, -48, -49, -44, -52, -82, -38, -49, -48, -50, -69, -38, -38, -41, -70, -37, -33, -44, -40, -44, -27, -48, -49, -59, -46, -46, -49, -46, -115, -41, -56, -55, -52, -59, -115, -46, -59, -52, -59, -63, -45, -59, -115, -61, -49, -60, -59, -61, -115, -58, -46, -49, -51, -115, -45, -59, -44, -115, -58, -55, -50, -63, -52, -52, -39, -102, -128, -123, -45, -40, -27, -27, -30, -27, -96, -22, -37, -36, -33, -40, -96, -27, -40, -33, -40, -44, -26, -40, -96, -42, -30, -41, -40, -42, -96, -39, -27, -30, -32, -96, -26, -40, -25, -83, -109, -104, -26, -34, -15, -24, -23, -27, -38, -14, -34, -21, -85, -89, -38, -17, -86, -89, -20, -21, -36, -89, -67, -38, -17, -86, -35, -58, -34, -35, -30, -38, -68, -24, -35, -34, -36, -70, -35, -38, -23, -19, -34, -21};
    }

    public B6(B7 b7) {
        this.A02 = b7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public B0 A02(boolean z2, C1804jQ c1804jQ, EnumC1801jL enumC1801jL, String str) throws Exception {
        Set<B0> set;
        if (this.A02.A0I(z2, c1804jQ) && B7.A0G(str, c1804jQ)) {
            synchronized (this.A02.A04) {
                set = this.A02.A04.get(str);
            }
            if (set != null) {
                synchronized (set) {
                    if (!set.isEmpty()) {
                        B7 b7 = this.A02;
                        b7.A00--;
                        Iterator<B0> it = set.iterator();
                        B0 ret = it.next();
                        it.remove();
                        this.A02.A03().A0A(z2, str, enumC1801jL, ret.hashCode());
                        return ret;
                    }
                }
            }
        }
        try {
            C1799jJ c1799jJA05 = this.A02.A03().A05(z2, str, enumC1801jL);
            B0 b0A03 = A03(z2, str);
            this.A02.A03().A06(c1799jJA05, b0A03.hashCode());
            return b0A03;
        } catch (Exception e3) {
            throw new MediaCodecInitializationException(str, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public B0 A03(boolean z2, String str) throws Exception {
        String strA04 = A04(150, 41, 69);
        if (z2 && B7.A0E(str)) {
            try {
                return (B0) Class.forName(strA04).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                Log.w(A04(43, 23, 55), String.format(A04(0, 43, 46), strA04, e3.getMessage()));
            }
        }
        return new C2073o6(MediaCodec.createByCodecName(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public void A0B(EnumC1801jL enumC1801jL) {
        String strA04;
        String str;
        B7 b7;
        Set<B0> set;
        for (B4 b4 : this.A01) {
            try {
                try {
                    if (!b4.A05) {
                        A08(b4.A01, enumC1801jL, Boolean.valueOf(b4.A04), b4.A00);
                    } else {
                        try {
                            try {
                                this.A02.A05 = SystemClock.elapsedRealtime();
                                b4.A00.reset();
                                b7 = this.A02;
                            } catch (Throwable th) {
                                this.A02.A05 = -1L;
                                throw th;
                            }
                        } catch (IllegalStateException unused) {
                            A09(b4.A02, b4.A00);
                            b7 = this.A02;
                        }
                        b7.A05 = -1L;
                        if (b4.A03) {
                            synchronized (this.A02.A04) {
                                set = this.A02.A04.get(b4.A02);
                            }
                            if (set != null) {
                                synchronized (set) {
                                    set.add(b4.A00);
                                    this.A02.A00++;
                                }
                            }
                        }
                    }
                    try {
                        synchronized (this.A01) {
                            this.A01.remove(b4);
                        }
                    } catch (Exception e3) {
                        strA04 = A04(43, 23, 55);
                        str = String.format(A04(66, 46, 44), e3.getMessage());
                        Log.w(strA04, str);
                    }
                } catch (Exception e4) {
                    Log.w(A04(43, 23, 55), String.format(A04(112, 38, 63), e4.getMessage()));
                    try {
                        synchronized (this.A01) {
                            this.A01.remove(b4);
                        }
                    } catch (Exception e5) {
                        strA04 = A04(43, 23, 55);
                        str = String.format(A04(66, 46, 44), e5.getMessage());
                        Log.w(strA04, str);
                    }
                }
            } catch (Throwable th2) {
                try {
                } catch (Exception e6) {
                    Log.w(A04(43, 23, 55), String.format(A04(66, 46, 44), e6.getMessage()));
                }
                synchronized (this.A01) {
                    this.A01.remove(b4);
                    throw th2;
                }
            }
        }
    }

    private void A08(C1804jQ c1804jQ, EnumC1801jL enumC1801jL, Boolean bool, B0 b02) {
        try {
            if (!c1804jQ.A0R || (!bool.booleanValue() && !c1804jQ.A0Q)) {
                b02.stop();
            }
        } finally {
            this.A02.A03().A08(enumC1801jL, b02.hashCode());
            b02.AHb();
            this.A02.A03().A07(enumC1801jL, b02.hashCode());
        }
    }

    private void A09(String str, B0 b02) {
        Set<B0> set;
        synchronized (this.A02.A04) {
            set = this.A02.A04.get(str);
        }
        if (set != null) {
            synchronized (set) {
                if (set.remove(b02)) {
                    B7 b7 = this.A02;
                    b7.A00--;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0A(boolean r24, com.facebook.ads.redexgen.core.C1804jQ r25, final com.facebook.ads.redexgen.core.EnumC1801jL r26, java.lang.String r27, com.facebook.ads.redexgen.core.B0 r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.B6.A0A(boolean, com.facebook.ads.redexgen.X.jQ, com.facebook.ads.redexgen.X.jL, java.lang.String, com.facebook.ads.redexgen.X.B0):void");
    }
}
