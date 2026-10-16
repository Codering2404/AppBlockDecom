package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.40, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass40 {
    public static byte[] A02;
    public static String[] A03 = {"xt7OJkzoRAU9F21vTA99nWdYHEgU1aqe", "agkrpda7Xp", "R", "5vNqnHOJCumqZOnLm9qFfz6JcwPphcfm", "ZSdlC9FQn5pQkXbUirih3rU8AE2dOqgO", "058ZJGrrLXJjuDHx9oXjnYONx8ueRFml", "p8wyR2SRaX4jfTsJEE0Ho6ErxYgTWBLm", "ZJmK2n287z"};
    public final File A00;
    public final File A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-69, Ascii.SI, 10, -69, -3, -4, -2, 6, Ascii.DLE, Ascii.VT, -69, 1, 4, 7, 0, -69, -43, 9, 8, Ascii.DC2, -64, -13, -18, -20, -24, -30, -59, -24, -21, -28, 6, Framer.STDERR_FRAME_PREFIX, 56, 47, 39, Framer.STDOUT_FRAME_PREFIX, -22, 55, -29, 38, 53, 40, 36, 55, 40, -29, -13, Ascii.US, 37, Ascii.FS, Ascii.DC4, Ascii.RS, -41, 36, -48, 34, Ascii.NAK, Ascii.RS, 17, Ascii.GS, Ascii.NAK, -48, Ascii.SYN, Ascii.EM, Ascii.FS, Ascii.NAK, -48};
    }

    static {
        A02();
    }

    public AnonymousClass40(File file) {
        this.A01 = file;
        this.A00 = new File(file.getPath() + A00(16, 4, 88));
    }

    private void A01() {
        if (this.A00.exists()) {
            this.A01.delete();
            this.A00.renameTo(this.A01);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.facebook.ads.redexgen.X.3z] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.facebook.ads.redexgen.X.3z] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.C04333z A03() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass40.A03():com.facebook.ads.redexgen.X.3z");
    }

    public final InputStream A04() throws FileNotFoundException {
        A01();
        return new FileInputStream(this.A01);
    }

    public final void A05() {
        this.A01.delete();
        this.A00.delete();
    }

    public final void A06(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.A00.delete();
    }

    public final boolean A07() {
        return this.A01.exists() || this.A00.exists();
    }
}
