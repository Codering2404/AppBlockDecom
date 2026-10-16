package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.flac.PictureFrame;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
public abstract class HH {
    public static byte[] A00;
    public static String[] A01 = {"jaTfwC0cI533jMSLFdbnMioREeamNCq8", "oxYS1uYBjADPdRUL4vsR12VppXrr4BxP", "o9bG5hJtiKIeIPN2CaXw8mH6vllsT8Pg", "8s8MZLb5TSIkvuwEDH", "W6kvFYauQlSyWCDb8CQhWvVbWb1Alqwq", "aw37R0CiGakhFrBRrvipxmkRXRxeCTzI", "Y2zfIeYjiYIsjSkQMxD0jwTDeetOAull", "DaiobFePrAznnRWN86LDTmrCW9O2HPvR"};

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{5, 34, 42, 47, 38, 39, 99, 55, 44, 99, Framer.STDOUT_FRAME_PREFIX, 38, 34, 39, 99, 5, Ascii.SI, 2, 0, 99, 48, 55, Framer.STDOUT_FRAME_PREFIX, 38, 34, 46, 99, 46, 34, Framer.STDOUT_FRAME_PREFIX, 40, 38, Framer.STDOUT_FRAME_PREFIX, 109, 125, 82, 73, 72, 79, Ascii.ESC, 93, 73, 90, 86, 94, Ascii.ESC, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, 94, 72, Ascii.ESC, 85, 84, 79, Ascii.ESC, 72, 79, 90, 73, 79, Ascii.ESC, 76, 82, 79, 83, Ascii.ESC, 72, 66, 85, 88, Ascii.ESC, 88, 84, Framer.STDIN_REQUEST_FRAME_PREFIX, 94, Ascii.NAK};
    }

    static {
        A08();
    }

    public static int A00(InterfaceC1999ms interfaceC1999ms) throws IOException {
        interfaceC1999ms.AIl();
        C04554v c04554v = new C04554v(2);
        interfaceC1999ms.AGt(c04554v.A0l(), 0, 2);
        int syncCode = c04554v.A0M();
        int frameStartMarker = syncCode >> 2;
        if (frameStartMarker == 16382) {
            interfaceC1999ms.AIl();
            return syncCode;
        }
        interfaceC1999ms.AIl();
        throw C3K.A01(A06(34, 42, 75), null);
    }

    public static Metadata A01(InterfaceC1999ms interfaceC1999ms, boolean z2) throws IOException {
        IE id3FramePredicate;
        if (z2) {
            id3FramePredicate = null;
        } else {
            id3FramePredicate = C9U.A03;
        }
        Metadata metadataA00 = new HM().A00(interfaceC1999ms, id3FramePredicate);
        if (metadataA00 == null || metadataA00.A02() == 0) {
            return null;
        }
        return metadataA00;
    }

    public static Metadata A02(InterfaceC1999ms interfaceC1999ms, boolean z2) throws IOException {
        interfaceC1999ms.AIl();
        long jA8i = interfaceC1999ms.A8i();
        Metadata metadataA01 = A01(interfaceC1999ms, z2);
        interfaceC1999ms.AK3((int) (interfaceC1999ms.A8i() - jA8i));
        return metadataA01;
    }

    public static HI A03(C04554v c04554v) {
        c04554v.A0g(1);
        int iA0K = c04554v.A0K();
        int length = c04554v.A09();
        long j3 = ((long) length) + ((long) iA0K);
        int i3 = iA0K / 18;
        long[] jArrCopyOf = new long[i3];
        long[] jArrCopyOf2 = new long[i3];
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            long jA0P = c04554v.A0P();
            if (jA0P == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                break;
            }
            jArrCopyOf[i4] = jA0P;
            jArrCopyOf2[i4] = c04554v.A0P();
            c04554v.A0g(2);
            i4++;
        }
        int length2 = c04554v.A09();
        c04554v.A0g((int) (j3 - ((long) length2)));
        return new HI(jArrCopyOf, jArrCopyOf2);
    }

    public static HI A04(InterfaceC1999ms interfaceC1999ms, int i3) throws IOException {
        C04554v c04554v = new C04554v(i3);
        interfaceC1999ms.readFully(c04554v.A0l(), 0, i3);
        return A03(c04554v);
    }

    public static HJ A05(InterfaceC1999ms interfaceC1999ms) throws IOException {
        byte[] bArr = new byte[38];
        interfaceC1999ms.readFully(bArr, 0, 38);
        return new HJ(bArr, 4);
    }

    public static List<String> A07(InterfaceC1999ms interfaceC1999ms, int i3) throws IOException {
        C04554v c04554v = new C04554v(i3);
        interfaceC1999ms.readFully(c04554v.A0l(), 0, i3);
        c04554v.A0g(4);
        return Arrays.asList(AbstractC0762Hk.A05(c04554v, false, false).A02);
    }

    public static void A09(InterfaceC1999ms interfaceC1999ms) throws IOException {
        C04554v c04554v = new C04554v(4);
        interfaceC1999ms.readFully(c04554v.A0l(), 0, 4);
        if (c04554v.A0Q() == 1716281667) {
        } else {
            throw C3K.A01(A06(0, 34, 51), null);
        }
    }

    public static boolean A0A(InterfaceC1999ms interfaceC1999ms) throws IOException {
        C04554v c04554v = new C04554v(4);
        interfaceC1999ms.AGt(c04554v.A0l(), 0, 4);
        return c04554v.A0Q() == 1716281667;
    }

    public static boolean A0B(InterfaceC1999ms interfaceC1999ms, HG hg) throws IOException {
        interfaceC1999ms.AIl();
        C04544u c04544u = new C04544u(new byte[4]);
        interfaceC1999ms.AGt(c04544u.A00, 0, 4);
        boolean zA0H = c04544u.A0H();
        int iA04 = c04544u.A04(7);
        int iA042 = c04544u.A04(24) + 4;
        if (iA04 == 0) {
            HJ hjA05 = A05(interfaceC1999ms);
            String[] strArr = A01;
            if (strArr[1].charAt(0) != strArr[2].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "oF2KQg39ZEK5V6OHUZM6u4PkuH0D3J87";
            strArr2[2] = "opWNo3Pnwj2PHBTvqD8r5OWylRW508kK";
            hg.A00 = hjA05;
        } else {
            HJ hj = hg.A00;
            if (hj != null) {
                if (iA04 != 3) {
                    if (iA04 == 4) {
                        hg.A00 = hj.A0B(A07(interfaceC1999ms, iA042));
                    } else if (iA04 == 6) {
                        C04554v c04554v = new C04554v(iA042);
                        interfaceC1999ms.readFully(c04554v.A0l(), 0, iA042);
                        c04554v.A0g(4);
                        PictureFrame pictureFrame = PictureFrame.A00(c04554v);
                        hg.A00 = hj.A0A(MetaExoPlayerCustomizedCollections.A03(pictureFrame));
                    } else {
                        interfaceC1999ms.AK3(iA042);
                    }
                } else {
                    hg.A00 = hj.A09(A04(interfaceC1999ms, iA042));
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return zA0H;
    }
}
