package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YE implements ThreadFactory {
    public static byte[] A02;
    public final AtomicLong A01 = new AtomicLong();
    public int A00 = Thread.currentThread().getPriority();

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{Ascii.EM, Ascii.NAK, Ascii.ETB, 84, Ascii.FS, Ascii.ESC, Ascii.EM, Ascii.US, Ascii.CAN, Ascii.NAK, Ascii.NAK, 17, 84, Ascii.ESC, Ascii.RS, 9, 90, Ascii.SO, Ascii.DC2, 8, Ascii.US, Ascii.ESC, Ascii.RS, 87, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.RS, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.SO, 60, 90, Framer.STDIN_REQUEST_FRAME_PREFIX, 70, Ascii.SO, 46, 5, Ascii.EM, 3, Ascii.DC4, Ascii.DLE, Ascii.NAK, 2, 46, Ascii.DC2, Ascii.RS, 4, Ascii.US, 5, Ascii.DC4, 3, 46, 2, Ascii.NAK, Ascii.SUB, 46, Ascii.ETB, Ascii.DLE, Ascii.DC2, 5, Ascii.RS, 3, 8};
    }

    private final String A00() {
        return String.format(Locale.US, A01(0, 35, 38), Long.valueOf(this.A01.incrementAndGet()), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AbstractC1066Tj.A00(A01(35, 27, 45));
        Thread thread = new Thread(null, runnable, A00(), 0L);
        thread.setPriority(this.A00);
        return thread;
    }
}
