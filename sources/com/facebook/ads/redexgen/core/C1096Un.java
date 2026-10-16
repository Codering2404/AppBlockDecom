package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Un, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1096Un {
    public static byte[] A06;
    public static String[] A07 = {"6qWdP8UnAqk2", "MP5OshbzeeKQXWypFydZHFaUVi2SMaBY", "YZOrpgpjnThYhZrbQ", "9FBJpZQghCKG6mC2kMssKZrg31bKkWn0", "1igNFrY6lER43", "wq7phLHZ3BH2hfkM7", "H4ZPtJlAPqOhXadVzSXMAib", "ZeuNk8rzE4mqHJK5cCc2mdI2UMeFjq1Z"};

    @Nullable
    public Messenger A00;
    public boolean A01 = false;
    public final ServiceConnection A02 = new ServiceConnectionC1095Um(this);
    public final C1648gi A03;
    public final String A04;
    public final String A05;

    public static String A05(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        byte[] bArr = {-32, -47, -30, -47, -35, -17, -47, -34, -17, -27, -27, -39, -44, -4, -19, -2, -19, -7, Ascii.VT, -4, -2, -5, 0, -5, -17, -5, -8, Ascii.VT, 2, -15, -2, -1, -11, -5, -6, -63, -78, -61, -78, -66, -48, -61, -74, -62, -58, -74, -60, -59, -48, -70, -75, Ascii.SO, Ascii.US, Framer.ENTER_FRAME_PREFIX, 41, Ascii.US, 37, 35, -19, Framer.ENTER_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 43, 46, Framer.STDIN_FRAME_PREFIX, 44, 35, 44, Framer.STDERR_FRAME_PREFIX, -34, 44, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, -34, 36, Framer.STDIN_FRAME_PREFIX, 51, 44, 34, -34, Framer.STDIN_FRAME_PREFIX, 48, -34, 43, 39, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 39, 44, 37, -34, 46, 35, 48, 43, 39, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 39, Framer.STDIN_FRAME_PREFIX, 44, Framer.STDOUT_FRAME_PREFIX, -69, -35, -38, -50, -48, -34, -34, -44, -39, -46, -117, -35, -48, -36, -32, -48, -34, -33, 1, Ascii.CR, Ascii.VT, -52, 4, -1, 1, 3, 0, Ascii.CR, Ascii.CR, 9, -52, -1, 19, 2, 7, 3, Ascii.FF, 1, 3, Ascii.FF, 3, Ascii.DC2, Ascii.NAK, Ascii.CR, Ascii.DLE, 9, -52, -33, 19, 2, 7, 3, Ascii.FF, 1, 3, -20, 3, Ascii.DC2, Ascii.NAK, Ascii.CR, Ascii.DLE, 9, -15, 3, Ascii.DLE, Ascii.DC4, 7, 1, 3, 2, Ascii.SO, Ascii.FF, -51, 5, 0, 2, 4, 1, Ascii.SO, Ascii.SO, 10, -51, 10, 0, 19, 0, Ascii.CR, 0, 43, Framer.STDERR_FRAME_PREFIX, 37, Framer.ENTER_FRAME_PREFIX, 56, 35, 46, 43, 38, 35, 54, 43, Framer.STDOUT_FRAME_PREFIX, 48};
        String[] strArr = A07;
        if (strArr[0].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[0] = "tkHV67jO43cW";
        strArr2[4] = "7eV9Uq8jXNAYU";
        A06 = bArr;
    }

    static {
        A06();
    }

    public C1096Un(C1648gi c1648gi, String str, String str2) {
        this.A03 = c1648gi;
        this.A05 = str;
        this.A04 = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putInt(A05(13, 22, 88), 1);
        bundle.putString(A05(0, 13, 60), this.A04);
        bundle.putString(A05(35, 16, 29), this.A05);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i3, C1061Te c1061Te) {
        this.A03.A08().ABC(A05(189, 14, 110), i3, c1061Te);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(int i3, C1061Te c1061Te) {
        c1061Te.A05(1);
        this.A03.A08().ABD(A05(189, 14, 110), i3, c1061Te);
    }

    public final void A0C() {
        A08(AbstractC1060Td.A1t, new C1061Te(A05(101, 18, 23), this.A05));
        Intent intent = new Intent();
        intent.setClassName(A05(170, 19, 75), A05(119, 51, 74));
        try {
            if (!this.A03.bindService(intent, this.A02, 1)) {
                A08(AbstractC1060Td.A1p, new C1061Te(A05(51, 50, 106)));
                this.A03.unbindService(this.A02);
            }
        } catch (Exception e3) {
            A07(AbstractC1060Td.A1o, new C1061Te(e3));
        }
    }
}
