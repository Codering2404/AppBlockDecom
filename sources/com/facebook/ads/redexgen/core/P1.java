package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class P1 {
    public static byte[] A04;
    public static String[] A05 = {"GkkO", "YJmuGc85y4OuUVwghPHMw6H0hrXdCbsK", "rRyyH1Ry9JSt7GwazL3CF5Rf19vLBzF0", "Kr8SfiAbBQlS981voHWRhKuNeYVS", "2bjqqKstFSNs", "YCJEv0AAmy9EO19MFuS1eY2psLita0He", "8nMnppK8MJ669xw0eU6fQM63oOjVziX6", "UtNvkE6PgDf4Bgx19r2HgtE5txVeLiPN"};
    public boolean A00;
    public boolean A01;
    public final BroadcastReceiver A02;
    public final IntentFilter A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A05;
            if (strArr[1].charAt(0) != strArr[5].charAt(0)) {
                throw new RuntimeException();
            }
            A05[2] = "RuLyFqXzbhnlmQeuw5cGDVAvivNnSqaB";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 95);
            i6++;
        }
    }

    public static void A01() {
        byte[] bArr = {73, Framer.STDIN_FRAME_PREFIX, 44, 40, Framer.STDIN_FRAME_PREFIX, Ascii.SI, 73, 70, 67, 91, 74, 93, Ascii.DC2, 84, 99, 101, 99, 111, 112, 99, 116, 125, 108};
        String[] strArr = A05;
        if (strArr[0].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        A05[6] = "goVzQt2K0L2BtiDyFGHqLLcsDevd1QlQ";
        A04 = bArr;
    }

    static {
        A01();
    }

    public P1(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.A03 = intentFilter;
        this.A02 = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        sb.append(A00(13, 9, 89));
        sb.append(this.A02);
        sb.append(A00(5, 8, 112));
        sb.append(this.A03);
        if (this.A01) {
            sb.append(A00(0, 5, 54));
        }
        sb.append(A00(22, 1, 78));
        return sb.toString();
    }
}
