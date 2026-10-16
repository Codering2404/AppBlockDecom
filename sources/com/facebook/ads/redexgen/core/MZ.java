package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class MZ implements Comparable<MZ> {
    public static byte[] A06;

    @MetaExoPlayerCustomization
    public static final String A07;
    public final long A00;
    public final long A01;
    public final long A02;
    public final File A03;
    public final String A04;
    public final boolean A05;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{Ascii.SI, 67, 78, 91, Ascii.NAK, 65, 17, Ascii.SO, Ascii.DC2, 91, 65, 119, 36, 62, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 109, 119, 65, 99, 97, 106, 103, 81, 114, 99, 108, 121};
    }

    static {
        A01();
        A07 = MZ.class.getSimpleName();
    }

    public MZ(String str, long j3, long j4, long j5, File file) {
        this.A04 = str;
        this.A02 = j3;
        this.A01 = j4;
        this.A05 = file != null;
        this.A03 = file;
        this.A00 = j5;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final int compareTo(MZ mz) {
        if (!this.A04.equals(mz.A04)) {
            return this.A04.compareTo(mz.A04);
        }
        long j3 = this.A02 - mz.A02;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }

    public final boolean A03() {
        return !this.A05;
    }

    public final boolean A04() {
        return this.A01 == -1;
    }

    @MetaExoPlayerCustomization
    public final String toString() {
        return A00(18, 10, 12) + this.A04 + A00(0, 5, 33) + this.A00 + A00(5, 6, 111) + this.A02 + A00(11, 7, 89) + this.A01 + '}';
    }
}
