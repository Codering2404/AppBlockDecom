package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ml, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1992ml implements H9 {
    public static byte[] A0F;
    public static String[] A0G = {"nCYubXqvd8ypcUhOSOVlYAWiNtNg5aTx", "kK9obhnzrC8LOV4nIDjH0fRMkLxjM4hw", "y066yKC5U0", "cE1K3Th7x6hTx4uAy2DDcaRqLgqPomcW", "7FhRQrMCUcKubfGBASNqeIg", "2Nytx4SBEfNcp68myMLwYRuSH7vsFm1u", "ZlttTssTlgjvAvH32uYzHDtT6TE9W794", "80ncat3y6qUdob6xQVasiz6qbkfE4w7J"};
    public static final HD A0H;
    public static final int A0I;
    public static final byte[] A0J;
    public static final byte[] A0K;
    public static final int[] A0L;
    public static final int[] A0M;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public HA A07;
    public HY A08;
    public InterfaceC0755Hd A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final int A0D;
    public final byte[] A0E;

    public static String A05(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0F = new byte[]{-115, -45, -33, -50, -38, -46, -115, -31, -26, -35, -46, -115, -120, -122, -90, -78, -73, 111, -53, -55, -23, -11, -6, -43, -1, -22, -78, -15, Ascii.GS, 35, Ascii.SUB, Ascii.DC2, -50, Ascii.FS, Ascii.GS, 34, -50, Ascii.DC4, Ascii.ETB, Ascii.FS, Ascii.DC2, -50, -17, -5, 0, -50, Ascii.SYN, 19, Ascii.SI, Ascii.DC2, 19, 32, -36, Ascii.FS, 63, 63, 56, 58, 52, 63, -13, Ascii.DC4, 32, 37, -13, Ascii.ETB, 60, 68, 47, 58, 55, Framer.STDERR_FRAME_PREFIX, -18, 62, 47, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 55, 60, 53, -18, 48, 55, 66, 65, -18, 52, 61, 64, -18, 52, 64, 47, 59, 51, -18, 54, 51, 47, Framer.STDERR_FRAME_PREFIX, 51, 64, -18, -40, -52, -35, -56, -26, -6, -23, -18, -12, -76, -72, -20, -11, -11, -46, -26, -43, -38, -32, -96, -46, -34, -29, -98, -24, -45};
    }

    static {
        A08();
        A0H = new HD() { // from class: com.facebook.ads.redexgen.X.mm
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1992ml.A0F();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A0L = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        A0M = new int[]{18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        A0J = C5C.A1G(A05(12, 6, 14));
        A0K = C5C.A1G(A05(18, 9, 81));
        A0I = A0M[8];
    }

    public C1992ml() {
        this(0);
    }

    public C1992ml(int i3) {
        this.A0D = (i3 & 2) != 0 ? i3 | 1 : i3;
        this.A0E = new byte[1];
        this.A02 = -1;
    }

    private int A00(int i3) throws C3K {
        if (!A0B(i3)) {
            throw C3K.A01(A05(53, 12, 124) + (this.A0C ? A05(105, 2, 47) : A05(103, 2, 51)) + A05(0, 12, 22) + i3, null);
        }
        boolean z2 = this.A0C;
        if (A0G[4].length() != 23) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[3] = "XAVUjCRC3hebivW774juK0oqwk2i4xqh";
        strArr[7] = "ZJ3GnAAJbhmZqGnHED8y3IWqixRJo44l";
        return z2 ? A0M[i3] : A0L[i3];
    }

    public static int A01(int i3, long j3) {
        return (int) (((((long) i3) * 8) * 1000000) / j3);
    }

    private int A02(InterfaceC1999ms interfaceC1999ms) throws IOException {
        interfaceC1999ms.AIl();
        interfaceC1999ms.AGt(this.A0E, 0, 1);
        byte b3 = this.A0E[0];
        if ((b3 & 131) <= 0) {
            return A00((b3 >> 3) & 15);
        }
        throw C3K.A01(A05(65, 38, 119) + ((int) b3), null);
    }

    @RequiresNonNull({"trackOutput"})
    private int A03(InterfaceC1999ms interfaceC1999ms) throws IOException {
        if (this.A00 == 0) {
            try {
                this.A01 = A02(interfaceC1999ms);
                this.A00 = this.A01;
                if (this.A02 == -1) {
                    this.A05 = interfaceC1999ms.A8n();
                    this.A02 = this.A01;
                }
                if (this.A02 == this.A01) {
                    this.A03++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iAIp = this.A09.AIp(interfaceC1999ms, this.A00, true);
        if (iAIp == -1) {
            return -1;
        }
        int bytesAppended = this.A00;
        this.A00 = bytesAppended - iAIp;
        if (A0G[5].charAt(6) != 'S') {
            throw new RuntimeException();
        }
        A0G[4] = "CzfhB3PuIPzemLKFV0N6DKx";
        if (this.A00 > 0) {
            return 0;
        }
        this.A09.AIu(this.A06 + this.A04, 1, this.A01, 0, null);
        this.A04 += 20000;
        return 0;
    }

    private C2003mx A04(long j3, boolean z2) {
        return new C2003mx(j3, this.A05, A01(this.A02, 20000L), this.A02, z2);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void A06() {
        AbstractC04323y.A02(this.A09);
    }

    @RequiresNonNull({"trackOutput"})
    private void A07() {
        if (!this.A0A) {
            this.A0A = true;
            String mimeType = this.A0C ? A05(117, 12, 26) : A05(107, 10, 46);
            this.A09.A6e(new C03992p().A11(mimeType).A0h(A0I).A0b(1).A0m(this.A0C ? 16000 : 8000).A14());
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private void A09(long j3, int i3) {
        if (this.A0B) {
            return;
        }
        if ((this.A0D & 1) == 0 || j3 == -1 || (this.A02 != -1 && this.A02 != this.A01)) {
            this.A08 = new C1994mn(-9223372036854775807L);
            this.A07.AJ7(this.A08);
            this.A0B = true;
        } else {
            if (this.A03 < 20 && i3 != -1) {
                return;
            }
            this.A08 = A04(j3, (this.A0D & 2) != 0);
            this.A07.AJ7(this.A08);
            this.A0B = true;
        }
    }

    private boolean A0A(int i3) {
        return !this.A0C && (i3 < 12 || i3 > 14);
    }

    private boolean A0B(int i3) {
        return i3 >= 0 && i3 <= 15 && (A0C(i3) || A0A(i3));
    }

    private boolean A0C(int i3) {
        return this.A0C && (i3 < 10 || i3 > 13);
    }

    private boolean A0D(InterfaceC1999ms interfaceC1999ms) throws IOException {
        if (A0E(interfaceC1999ms, A0J)) {
            this.A0C = false;
            interfaceC1999ms.AK3(A0J.length);
            return true;
        }
        if (!A0E(interfaceC1999ms, A0K)) {
            return false;
        }
        this.A0C = true;
        interfaceC1999ms.AK3(A0K.length);
        return true;
    }

    public static boolean A0E(InterfaceC1999ms interfaceC1999ms, byte[] bArr) throws IOException {
        interfaceC1999ms.AIl();
        byte[] bArr2 = new byte[bArr.length];
        interfaceC1999ms.AGt(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    public static /* synthetic */ H9[] A0F() {
        return new H9[]{new C1992ml()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A07 = ha;
        this.A09 = ha.AKS(0, 1);
        ha.A6O();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        A06();
        if (interfaceC1999ms.A8n() != 0 || A0D(interfaceC1999ms)) {
            A07();
            int iA03 = A03(interfaceC1999ms);
            A09(interfaceC1999ms.A8O(), iA03);
            return iA03;
        }
        throw C3K.A01(A05(27, 26, 87), null);
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j3, long j4) {
        this.A04 = 0L;
        this.A01 = 0;
        this.A00 = 0;
        if (j3 != 0) {
            boolean z2 = this.A08 instanceof C2003mx;
            if (A0G[1].charAt(14) != '4') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[3] = "NQLxubHlf0cB1xHoee3lgwNqGMjiyHKA";
            strArr[7] = "Tv4bI2EMm7rGcVq8cNVXYB9qzgEcyYlQ";
            if (z2) {
                this.A06 = ((C2003mx) this.A08).A02(j3);
                return;
            }
        }
        this.A06 = 0L;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1999ms interfaceC1999ms) throws IOException {
        return A0D(interfaceC1999ms);
    }
}
