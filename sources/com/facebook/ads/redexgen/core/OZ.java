package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.ads.AdSDKNotificationListener;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class OZ implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ String A00;
    public final /* synthetic */ List A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{112, 123, 118, 103, 108, 101, 97, 112, 113, 74, 118, 101, Framer.EXIT_FRAME_PREFIX, 57, 61, 32, 34, 53, 35, 35, 57, 63, 62};
    }

    public OZ(List list, String str) {
        this.A01 = list;
        this.A00 = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            for (AdSDKNotificationListener adSDKNotificationListener : this.A01) {
                Bundle data = new Bundle();
                data.putString(A00(0, 13, 63), this.A00);
                adSDKNotificationListener.onAdEvent(A00(13, 10, 122), data);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
