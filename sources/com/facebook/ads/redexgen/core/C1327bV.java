package com.facebook.ads.redexgen.core;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1327bV {
    public static long A0F;
    public static byte[] A0G;
    public static String[] A0H = {"R0SbMgWAoC497HVFrz", "HjDMjTQFKfQjEPdjddKMHVEmssyIO6xJ", "qLmiUd82g2mhrwqPXxjSPUm4NIZHyVr2", "b8w5", "5ahVLoWejnV8u5u0zxB2Y4aA1Z0H734m", "82nB4Ww4zktBcOGVc7", "fE0nEfPNcAkneFTlCeTsSM9yzZ1yQJUc", "9xmO"};
    public InterfaceC0898Mr A00;
    public AbstractC0900Mt A01;
    public AbstractC1813jd A02;
    public XS A03;
    public InterfaceC1163Xh A04;
    public InterfaceC1326bU A05;
    public boolean A06;
    public final C0912Ng A07;
    public final C1648gi A08;
    public final VA A09;
    public final Y2 A0A;
    public final InterfaceC1189Yh A0B;
    public final C1593fp A0C;
    public final String A0D;
    public final boolean A0E;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {119, -120, 117, 118, -87, -88, -88, -93, -94, 119, -96, -99, -105, -97, -128, -99, -89, -88, -103, -94, -103, -90, 115, -96, -96, -99, -96, 78, -109, -90, -109, -111, -93, -94, -105, -100, -107, 78, -113, -111, -94, -105, -99, -100, -100, -55, -55, -58, -55, 119, -50, -65, -64, -61, -68, 119, -58, -57, -68, -59, -64, -59, -66, 119, -55, -46, -49, -55, -47, -59, -39, -43, -37, -40, -55, -53};
        String[] strArr = A0H;
        if (strArr[4].charAt(11) == strArr[6].charAt(11)) {
            throw new RuntimeException();
        }
        A0H[5] = "";
        A0G = bArr;
    }

    static {
        A03();
        A0F = 0L;
    }

    public C1327bV(C1648gi c1648gi, String str, C1593fp c1593fp, Y2 y2, VA va, C0912Ng c0912Ng) {
        this(c1648gi, str, c1593fp, y2, va, c0912Ng, new C0847Ks());
    }

    public C1327bV(C1648gi c1648gi, String str, C1593fp c1593fp, Y2 y2, VA va, C0912Ng c0912Ng, InterfaceC1189Yh interfaceC1189Yh) {
        this.A0E = true;
        this.A08 = c1648gi;
        this.A0D = str;
        this.A0C = c1593fp;
        this.A0A = y2;
        this.A09 = va;
        this.A07 = c0912Ng;
        this.A0B = interfaceC1189Yh;
    }

    public C1327bV(C1648gi c1648gi, String str, C1593fp c1593fp, Y2 y2, VA va, C0912Ng c0912Ng, InterfaceC1189Yh interfaceC1189Yh, InterfaceC1163Xh interfaceC1163Xh) {
        this.A0E = true;
        this.A08 = c1648gi;
        this.A0D = str;
        this.A0C = c1593fp;
        this.A0A = y2;
        this.A09 = va;
        this.A07 = c0912Ng;
        this.A0B = interfaceC1189Yh;
        this.A04 = interfaceC1163Xh;
    }

    private EnumC0897Mq A00(String str, String str2, Map<String, String> map) {
        String strA01 = A01(0, 22, 33);
        EnumC0897Mq actionOutcome = EnumC0897Mq.A09;
        try {
            YB.A0c(map, this.A02);
            Uri uriA00 = XB.A00(str2);
            if (this.A01 == null) {
                this.A01 = C0901Mu.A01(this.A08, this.A09, str, uriA00, new C1305b9(map).A03(this.A0C).A02(this.A0A).A05(), true, this.A06, this.A07);
                A02();
            }
            if (this.A01 instanceof AnonymousClass87) {
                ((AnonymousClass87) this.A01).A0N(this.A03);
            }
            if (this.A01 != null) {
                actionOutcome = this.A01.A0G(map.get(A01(64, 12, 83)));
                if (this.A06 && (this.A01 instanceof AnonymousClass85)) {
                    actionOutcome = EnumC0897Mq.A08;
                }
            }
            if (!(((this.A01 instanceof AnonymousClass84) || (this.A01 instanceof AnonymousClass87)) && YB.A0i(this.A08, actionOutcome, map)) && actionOutcome != EnumC0897Mq.A06) {
                if (this.A05 != null) {
                    this.A05.ADY();
                }
                this.A0B.A4j(this.A0D);
            }
        } catch (ActivityNotFoundException e3) {
            Log.e(strA01, A01(44, 20, 68) + str2, e3);
        } catch (Exception e4) {
            Log.e(strA01, A01(22, 22, 27), e4);
        }
        return actionOutcome;
    }

    private void A02() {
        if (this.A01 != null && this.A01.A0E() == null && this.A00 != null) {
            this.A01.A0F(this.A00);
        }
    }

    public static boolean A04(C1648gi c1648gi) {
        boolean zA2w = C1098Up.A2w(c1648gi);
        int iA07 = C1098Up.A07(c1648gi);
        long jCurrentTimeMillis = System.currentTimeMillis() - A0F;
        if (zA2w && A0F > 0 && jCurrentTimeMillis < iA07) {
            return true;
        }
        A0F = System.currentTimeMillis();
        return false;
    }

    public final EnumC0897Mq A05(String str, String str2, Map<String, String> extraData) {
        EnumC0897Mq enumC0897MqA00 = EnumC0897Mq.A09;
        new VI(str, this.A09).A04(VH.A0J, extraData);
        if (this.A0A.A09(this.A08)) {
            this.A09.AB6(str, extraData);
        } else {
            enumC0897MqA00 = A00(str, str2, extraData);
            if (this.A02 != null && this.A02.A29().A0L() != null && this.A04 != null) {
                XI.A07(this.A08.A02(), this.A02.A29().A0L(), this.A04);
            }
        }
        return enumC0897MqA00;
    }

    public final InterfaceC0898Mr A06() {
        if (this.A01 != null) {
            InterfaceC0898Mr interfaceC0898MrA0E = this.A01.A0E();
            String[] strArr = A0H;
            if (strArr[4].charAt(11) == strArr[6].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0H;
            strArr2[4] = "m9EeWSKmUQIcAT4bR8TqW1uNxXCrncrR";
            strArr2[6] = "ZpUrOoewPl5vbi76KZuNJwABiWDkIMaY";
            return interfaceC0898MrA0E;
        }
        return null;
    }

    public final void A07(InterfaceC0898Mr interfaceC0898Mr) {
        this.A00 = interfaceC0898Mr;
        A02();
    }

    public final void A08(AbstractC1813jd abstractC1813jd) {
        this.A02 = abstractC1813jd;
    }

    public final void A09(XS xs) {
        this.A03 = xs;
    }

    public final void A0A(InterfaceC1163Xh interfaceC1163Xh) {
        this.A04 = interfaceC1163Xh;
    }

    public final void A0B(InterfaceC1326bU interfaceC1326bU) {
        this.A05 = interfaceC1326bU;
    }

    public final void A0C(boolean z2) {
        this.A06 = z2;
    }
}
