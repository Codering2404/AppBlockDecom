package com.facebook.ads.redexgen.core;

import android.os.AsyncTask;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class YD {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{77, 66, 72, 94, 67, 69, 72, 2, 67, Framer.STDIN_REQUEST_FRAME_PREFIX, 2, 109, Framer.STDIN_REQUEST_FRAME_PREFIX, 85, 66, 79, Framer.EXIT_FRAME_PREFIX, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, 71};
    }

    public static <P, PR, R> AsyncTask<P, PR, R> A00(Executor executor, AsyncTask<P, PR, R> task, P... params) {
        task.executeOnExecutor(executor, params);
        return task;
    }

    public static void A02() {
        try {
            Class.forName(A01(0, 20, 53));
        } catch (Throwable unused) {
        }
    }
}
