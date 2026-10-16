package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1894kz implements H9 {
    public static byte[] A07;
    public static String[] A08 = {"DwCwNe", "sWjhkz5Jk0aFlWxF8RAhYepliqmDVBH5", "fJB4aZ6fjAPSNUZta8hrgw0qJ7r8hoM5", "QGFmFhkJVom57VKObFa8uqUV9", "rnOb7nHa90E2wPIfOCxC", "at6D0iA1D4bxl", "SWjjSn0lfORi", "B3tBBFyQt38AAQleoY5s"};
    public static final HD A09;
    public HA A04;
    public InterfaceC0755Hd A05;
    public LL A06;
    public int A01 = 0;
    public long A03 = -1;
    public int A00 = -1;
    public long A02 = -1;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{87, 91, 2, 39, Framer.STDERR_FRAME_PREFIX, 39, 102, 35, 62, 37, 35, 35, 34, 53, 102, 47, 40, 54, 51, Framer.STDERR_FRAME_PREFIX, 102, 42, 35, 40, Framer.ENTER_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 46, 124, 102, 39, Ascii.FS, 1, 7, 2, 2, Ascii.GS, 0, 6, Ascii.ETB, Ascii.SYN, 82, 37, 51, 36, 82, Ascii.DC4, Ascii.GS, 0, Ascii.US, 19, 6, 82, 6, Ascii.VT, 2, Ascii.ETB, 72, 82, Ascii.DEL, 68, 89, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, 90, 69, 88, 94, 79, 78, 10, 69, 88, 10, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 88, 79, 73, 69, 77, 68, 67, 80, 79, 78, 10, 93, 75, 92, 10, 76, 67, 70, 79, 10, 94, 83, 90, 79, 4, 103, 81, 70, 117, 72, 68, 66, 81, 83, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 66, 17, 5, Ascii.DC4, Ascii.EM, Ascii.US, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.ETB, 71, 65, 65, 93, 17, Ascii.FS, 17, 7, Ascii.DEL, 107, 122, 119, 113, Framer.STDOUT_FRAME_PREFIX, 121, 41, 47, 47, 51, 115, 114, Ascii.DEL, 105, 55, 35, Framer.STDERR_FRAME_PREFIX, 63, 57, 121, 36, 55, Framer.ENTER_FRAME_PREFIX};
    }

    static {
        A03();
        A09 = new HD() { // from class: com.facebook.ads.redexgen.X.l2
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1894kz.A08();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    private int A00(InterfaceC1999ms interfaceC1999ms) throws IOException {
        AbstractC04323y.A08(this.A02 != -1);
        return ((LL) AbstractC04323y.A01(this.A06)).AIt(interfaceC1999ms, this.A02 - interfaceC1999ms.A8n()) ? -1 : 0;
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void A02() {
        AbstractC04323y.A02(this.A05);
    }

    private void A04(InterfaceC1999ms interfaceC1999ms) throws IOException {
        AbstractC04323y.A08(interfaceC1999ms.A8n() == 0);
        int i3 = this.A00;
        if (A08[5].length() != 13) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[7] = "oJOrgM3DzNUfWcxP3ghI";
        strArr[4] = "cZhhMb4kvP2y4vGeSU9A";
        if (i3 != -1) {
            interfaceC1999ms.AK3(this.A00);
            this.A01 = 4;
        } else {
            if (LP.A06(interfaceC1999ms)) {
                interfaceC1999ms.AK3((int) (interfaceC1999ms.A8i() - interfaceC1999ms.A8n()));
                this.A01 = 1;
                return;
            }
            throw C3K.A01(A01(58, 42, 8), null);
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    private void A05(InterfaceC1999ms interfaceC1999ms) throws IOException {
        LN wavFormat = LP.A02(interfaceC1999ms);
        if (wavFormat.A03 == 17) {
            this.A06 = new C1896l1(this.A04, this.A05, wavFormat);
        } else if (wavFormat.A03 == 6) {
            this.A06 = new C1895l0(this.A04, this.A05, wavFormat, A01(112, 15, 82), -1);
        } else if (wavFormat.A03 == 7) {
            this.A06 = new C1895l0(this.A04, this.A05, wavFormat, A01(127, 15, 60), -1);
        } else {
            int iA00 = AbstractC0763Hl.A00(wavFormat.A03, wavFormat.A01);
            if (iA00 != 0) {
                this.A06 = new C1895l0(this.A04, this.A05, wavFormat, A01(142, 9, 116), iA00);
            } else {
                throw C3K.A00(A01(29, 29, 80) + wavFormat.A03);
            }
        }
        this.A01 = 3;
    }

    private void A06(InterfaceC1999ms interfaceC1999ms) throws IOException {
        this.A03 = LP.A00(interfaceC1999ms);
        this.A01 = 2;
    }

    private void A07(InterfaceC1999ms interfaceC1999ms) throws IOException {
        Pair<Long, Long> pairA01 = LP.A01(interfaceC1999ms);
        this.A00 = ((Long) pairA01.first).intValue();
        long jLongValue = ((Long) pairA01.second).longValue();
        if (this.A03 != -1) {
            String[] strArr = A08;
            if (strArr[7].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "zD8CpsX01ISLh3RSws8RgUnhS";
            strArr2[6] = "h3zG6U6JIHw0";
            if (jLongValue == 4294967295L) {
                jLongValue = this.A03;
            }
        }
        this.A02 = ((long) this.A00) + jLongValue;
        long jA8O = interfaceC1999ms.A8O();
        if (jA8O != -1 && this.A02 > jA8O) {
            AbstractC04404g.A07(A01(100, 12, 18), A01(2, 27, 100) + this.A02 + A01(0, 2, 89) + jA8O);
            this.A02 = jA8O;
        }
        ((LL) AbstractC04323y.A01(this.A06)).AA8(this.A00, this.A02);
        this.A01 = 4;
    }

    public static /* synthetic */ H9[] A08() {
        return new H9[]{new C1894kz()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A04 = ha;
        this.A05 = ha.AKS(0, 1);
        ha.A6O();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        A02();
        switch (this.A01) {
            case 0:
                A04(interfaceC1999ms);
                return 0;
            case 1:
                A06(interfaceC1999ms);
                if (A08[5].length() != 13) {
                    throw new RuntimeException();
                }
                String[] strArr = A08;
                strArr[3] = "VLLh2GyvdfrrOjqYmUQdrqO3c";
                strArr[6] = "Miu4m4vLnYY2";
                return 0;
            case 2:
                A05(interfaceC1999ms);
                return 0;
            case 3:
                A07(interfaceC1999ms);
                return 0;
            case 4:
                return A00(interfaceC1999ms);
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j3, long j4) {
        this.A01 = j3 == 0 ? 0 : 4;
        if (this.A06 != null) {
            this.A06.AIk(j4);
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1999ms interfaceC1999ms) throws IOException {
        return LP.A06(interfaceC1999ms);
    }
}
