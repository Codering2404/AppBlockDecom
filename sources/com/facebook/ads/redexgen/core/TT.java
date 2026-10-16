package com.facebook.ads.redexgen.core;

import android.os.Process;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class TT implements Thread.UncaughtExceptionHandler {
    public static byte[] A04;
    public final C1644ge A00;
    public final InterfaceC1057Ta A01;
    public final Thread.UncaughtExceptionHandler A02;
    public final Map<String, String> A03;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-79, -51, -102, -74, -64, -64, -74, -69, -76, 109, -112, -68, -69, -63, -78, -59, -63, -102, -90, -92, 101, -99, -104, -102, -100, -103, -90, -90, -94, 101, -104, -101, -86, 2, 17, 0, Ascii.DC2, 7, 7, 9, -10, 8, Ascii.CR, 4, -7, -20, -18, -37, -19, -14, -23, -34, -40, -36, -24, -35, -34};
    }

    public TT(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1644ge c1644ge, TS ts) {
        this(uncaughtExceptionHandler, c1644ge, ts, AbstractC1058Tb.A00());
    }

    public TT(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C1644ge c1644ge, TS ts, InterfaceC1057Ta interfaceC1057Ta) {
        this.A02 = uncaughtExceptionHandler;
        if (c1644ge != null) {
            this.A00 = c1644ge;
            this.A03 = ts.A97(c1644ge);
            this.A01 = interfaceC1057Ta;
            return;
        }
        throw new IllegalArgumentException(A00(2, 15, 29));
    }

    public static void A02() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    private void A03(Thread thread, Throwable th) {
        if (this.A02 != null) {
            this.A02.uncaughtException(thread, th);
        } else {
            A02();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA03 = AbstractC1175Xt.A03(this.A00, th);
            if (!TextUtils.isEmpty(strA03)) {
                String stackTraceString = A00(17, 16, 7);
                if (strA03.contains(stackTraceString)) {
                    Map<String, String> mapA02 = new TR(strA03, this.A03).A02();
                    String strA00 = A00(38, 7, 100);
                    String stackTraceString2 = A00(33, 5, 111);
                    mapA02.put(strA00, stackTraceString2);
                    Throwable thA00 = WP.A00();
                    String strA002 = A00(45, 12, 73);
                    if (thA00 == th) {
                        String stackTraceString3 = A00(1, 1, 108);
                        mapA02.put(strA002, stackTraceString3);
                    } else {
                        String stackTraceString4 = A00(0, 1, 81);
                        mapA02.put(strA002, stackTraceString4);
                    }
                    this.A01.AL7(new C1064Th(this.A00.A09().A01(), this.A00.A09().A02(), mapA02), this.A00);
                    if (C1098Up.A2A(this.A00)) {
                        C1098Up.A0e(this.A00);
                    }
                }
            }
        } catch (Exception unused) {
        }
        A03(thread, th);
    }
}
