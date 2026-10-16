package com.facebook.ads.redexgen.core;

import android.net.TrafficStats;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Su, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class CallableC1051Su implements Callable<Boolean> {
    public static byte[] A02;
    public final C1050St A00;
    public final /* synthetic */ C1054Sx A01;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-34, -46, -29, -36, -26, -31, -25, -38, -43, -42, -32};
    }

    public CallableC1051Su(C1054Sx c1054Sx, C1050St c1050St) {
        this.A01 = c1054Sx;
        this.A00 = c1050St;
    }

    private final Boolean A00() throws Throwable {
        String strA01;
        if (WU.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            if (this.A00.A04) {
                strA01 = A01(0, 6, 72);
            } else {
                strA01 = A01(6, 5, 72);
            }
            String str = this.A00.A08;
            String creativeType = this.A00.A07;
            LX lx = new LX(str, creativeType, this.A00.A06, strA01, this.A00.A02, this.A00.A05);
            lx.A04 = this.A00.A03;
            lx.A02 = this.A00.A01;
            lx.A05 = this.A00.A04;
            if (T0.A06(this.A01.A04)) {
                C1054Sx.A0F.put(this.A00.A08, lx);
            }
            return Boolean.valueOf(C1054Sx.A03(this.A01.A04.A02()).AIg(lx) != null);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        if (WU.A02(this)) {
            return null;
        }
        try {
            return A00();
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }
}
