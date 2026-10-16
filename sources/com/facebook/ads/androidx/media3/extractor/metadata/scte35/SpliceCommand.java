package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.redexgen.core.C2208qI;
import com.facebook.ads.redexgen.core.C3E;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{54, 38, Framer.STDOUT_FRAME_PREFIX, 32, 72, 86, 80, 69, Ascii.SYN, Ascii.NAK, 9, Ascii.FF, 6, 0, 69, 6, 10, 8, 8, 4, Ascii.VT, 1, Framer.STDIN_REQUEST_FRAME_PREFIX, 69, 17, Ascii.FS, Ascii.NAK, 0, 88};
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ byte[] A9a() {
        return C3E.A01(this);
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ C2208qI A9b() {
        return C3E.A00(this);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return A02(0, 29, 61) + getClass().getSimpleName();
    }
}
