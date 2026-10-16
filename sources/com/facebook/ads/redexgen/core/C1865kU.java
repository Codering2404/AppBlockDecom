package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1865kU implements C5W {
    public static byte[] A0A;
    public static String[] A0B = {"ZvdLZTVfwuIBTQP4GzYBT5X", "wbAZGHQ6rgrE49QWGCHGfuBznSfuy1uN", "V6XwnsY6foGeZeUf6zKrOXNqPWCT5H6x", "YVOcTVGnehAK6q3v9MTNJvITraIKZiNA", "KHrBPZHANML419JBBjaM9uFMM5JItkLu", "1WIXy5Awt7B4E86DpiV0tl9iGx9sIFx0", "LtMYCkXqs5nSRMey4EGdy6S", "9S3XCAL9m1K226khzcMpmZ28hR6Taq7A"};
    public long A00;
    public long A01;
    public long A02;
    public C04685i A03;
    public C0895Mo A04;
    public File A05;
    public OutputStream A06;
    public final int A07;
    public final long A08;
    public final MP A09;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{86, 116, 118, 125, 112, 81, 116, 97, 116, 70, 124, 123, 126, 32, 52, 39, Framer.ENTER_FRAME_PREFIX, 43, 35, 40, Framer.STDERR_FRAME_PREFIX, Ascii.NAK, 47, 60, 35, 102, 47, 53, 102, 36, 35, 42, 41, Framer.STDOUT_FRAME_PREFIX, 102, Framer.STDERR_FRAME_PREFIX, 46, 35, 102, 43, 47, 40, 47, 43, 51, 43, 102, 52, 35, 37, 41, 43, 43, 35, 40, 34, 35, 34, 102, 48, 39, 42, 51, 35, 102, 41, 32, 102, 116, 118, Ascii.DEL, 113, 119, 115, 116, 104, 102, Ascii.DC2, 46, 47, 53, 102, 43, 39, 63, 102, 37, 39, 51, 53, 35, 102, 54, 41, 41, 52, 102, 37, 39, 37, 46, 35, 102, 54, 35, 52, 32, 41, 52, 43, 39, 40, 37, 35, 104, 35, 55, 36, 34, 40, 32, 43, Framer.STDOUT_FRAME_PREFIX, Ascii.SYN, 44, 63, 32, 101, 40, 48, 54, Framer.STDOUT_FRAME_PREFIX, 101, 39, 32, 101, 53, 42, 54, 44, Framer.STDOUT_FRAME_PREFIX, 44, 51, 32, 101, 42, 55, 101, 6, 107, 9, 0, Ascii.VT, 2, 17, Ascii.CR, Ascii.SUB, Ascii.DLE, Ascii.VT, Ascii.SYN, 0, 17, 107};
    }

    static {
        A02();
    }

    public C1865kU(MP mp, long j3, int i3) {
        AbstractC04323y.A0A(j3 > 0 || j3 == -1, A00(115, 48, 72));
        if (j3 != -1 && j3 < 2097152) {
            AbstractC04404g.A07(A00(0, 13, 24), A00(13, 102, 75));
        }
        this.A09 = (MP) AbstractC04323y.A01(mp);
        this.A08 = j3 == -1 ? Long.MAX_VALUE : j3;
        this.A07 = i3;
    }

    /* JADX WARN: Finally extract failed */
    private void A01() throws IOException {
        if (this.A06 == null) {
            return;
        }
        try {
            this.A06.flush();
            C5C.A10(this.A06);
            this.A06 = null;
            File file = (File) C5C.A0f(this.A05);
            this.A05 = null;
            String[] strArr = A0B;
            if (strArr[7].charAt(29) == strArr[2].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[0] = "UqCq1nJSNUsM2UdGgnorxCQ";
            strArr2[6] = "6grM2eqzP4bpAc7X7xQexiC";
            if (1 != 0) {
                this.A09.A55(file, this.A02);
            } else {
                file.delete();
            }
        } catch (Throwable th) {
            C5C.A10(this.A06);
            this.A06 = null;
            File fileToCommit = (File) C5C.A0f(this.A05);
            this.A05 = null;
            if (0 != 0) {
                this.A09.A55(fileToCommit, this.A02);
            } else {
                fileToCommit.delete();
            }
            throw th;
        }
    }

    private void A03(C04685i c04685i) throws IOException {
        this.A05 = this.A09.AK8((String) C5C.A0f(c04685i.A08), c04685i.A04 + this.A00, c04685i.A03 != -1 ? Math.min(c04685i.A03 - this.A00, this.A01) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.A05);
        if (this.A07 > 0) {
            if (this.A04 == null) {
                this.A04 = new C0895Mo(fileOutputStream, this.A07);
            } else {
                this.A04.A00(fileOutputStream);
            }
            this.A06 = this.A04;
        } else {
            this.A06 = fileOutputStream;
        }
        this.A02 = 0L;
    }

    @Override // com.facebook.ads.redexgen.core.C5W
    public final void AGk(C04685i c04685i) throws IOException {
        AbstractC04323y.A01(c04685i.A08);
        if (c04685i.A03 == -1 && c04685i.A06(2)) {
            this.A03 = null;
            return;
        }
        this.A03 = c04685i;
        this.A01 = c04685i.A06(4) ? this.A08 : Long.MAX_VALUE;
        this.A00 = 0L;
        try {
            A03(c04685i);
        } catch (IOException e3) {
            throw new C1867kW(e3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.C5W
    public final void close() throws IOException {
        if (this.A03 == null) {
            return;
        }
        try {
            A01();
        } catch (IOException e3) {
            throw new C1867kW(e3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.C5W
    public final void write(byte[] bArr, int i3, int i4) throws C1867kW {
        C04685i c04685i = this.A03;
        if (c04685i == null) {
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            try {
                if (this.A02 == this.A01) {
                    A01();
                    A03(c04685i);
                }
                int iMin = (int) Math.min(i4 - i5, this.A01 - this.A02);
                ((OutputStream) C5C.A0f(this.A06)).write(bArr, i3 + i5, iMin);
                i5 += iMin;
                this.A02 += (long) iMin;
                this.A00 += (long) iMin;
            } catch (IOException e3) {
                throw new C1867kW(e3);
            }
        }
    }
}
