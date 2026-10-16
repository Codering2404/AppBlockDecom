package com.facebook.ads.androidx.media3.extractor;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.extractor.DefaultExtractorsFactory;
import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import com.facebook.ads.redexgen.core.AbstractC03942k;
import com.facebook.ads.redexgen.core.AnonymousClass53;
import com.facebook.ads.redexgen.core.C1894kz;
import com.facebook.ads.redexgen.core.C1898l3;
import com.facebook.ads.redexgen.core.C1905lA;
import com.facebook.ads.redexgen.core.C1920lP;
import com.facebook.ads.redexgen.core.C1922lR;
import com.facebook.ads.redexgen.core.C1925lU;
import com.facebook.ads.redexgen.core.C1928lX;
import com.facebook.ads.redexgen.core.C1953lw;
import com.facebook.ads.redexgen.core.C1959m2;
import com.facebook.ads.redexgen.core.C1960m3;
import com.facebook.ads.redexgen.core.C1973mG;
import com.facebook.ads.redexgen.core.C1984md;
import com.facebook.ads.redexgen.core.C1987mg;
import com.facebook.ads.redexgen.core.C1992ml;
import com.facebook.ads.redexgen.core.C2208qI;
import com.facebook.ads.redexgen.core.H4;
import com.facebook.ads.redexgen.core.H5;
import com.facebook.ads.redexgen.core.H9;
import com.facebook.ads.redexgen.core.HD;
import com.facebook.ads.redexgen.core.MetaExoPlayerCustomizedCollections;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DefaultExtractorsFactory implements HD {
    public static byte[] A0D;
    public static String[] A0E = {"XjRCK", "YKKzt2Kz2K7V0l18n", "uXpf", "oBPf3SXxcwKIIjUAiSrSO2O", "bGsaI0", "ItuqzfwzHHPicVJR9bxtDiYARBCa2uxZ", "TYxjAZ909gRPDezWj", "NTeqQWiGfYp1zE0qSPlL6iBK546ff9Um"};
    public static final H5 A0F;
    public static final H5 A0G;
    public static final int[] A0H;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08 = 1;
    public int A09 = 112800;

    @MetaExoPlayerCustomization("Replaces ImmutableList with List")
    public List<C2208qI> A0A = MetaExoPlayerCustomizedCollections.A03(new C2208qI[0]);
    public boolean A0B;
    public boolean A0C;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0D = new byte[]{74, 86, 84, Ascii.NAK, 77, 72, 74, 76, 73, 86, 86, 82, Ascii.NAK, 72, 75, 90, Ascii.NAK, 72, 85, 75, 89, 86, 80, 75, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.NAK, 84, 76, 75, 80, 72, Ascii.SUB, Ascii.NAK, 75, 76, 74, 86, 75, 76, 89, Ascii.NAK, 84, 80, 75, 80, Ascii.NAK, 52, 80, 75, 80, 44, Framer.STDIN_REQUEST_FRAME_PREFIX, 91, 89, 72, 74, 91, 86, 89, -6, 6, 4, -59, -3, -8, -6, -4, -7, 6, 6, 2, -59, -8, -5, 10, -59, -2, 6, 6, -2, 3, -4, -59, -8, 5, -5, 9, 6, 0, -5, -59, -4, Ascii.SI, 6, 7, 3, -8, Ascii.DLE, -4, 9, -55, -59, -4, Ascii.SI, Ascii.VT, -59, -3, 3, -8, -6, -59, -35, 3, -8, -6, -36, Ascii.SI, Ascii.VT, 9, -8, -6, Ascii.VT, 6, 9, Ascii.ESC, 39, 37, -26, Ascii.RS, Ascii.EM, Ascii.ESC, Ascii.GS, Ascii.SUB, 39, 39, 35, -26, Ascii.EM, Ascii.FS, 43, -26, Ascii.US, 39, 39, Ascii.US, 36, Ascii.GS, -26, Ascii.EM, 38, Ascii.FS, 42, 39, Framer.ENTER_FRAME_PREFIX, Ascii.FS, -26, Ascii.GS, 48, 39, 40, 36, Ascii.EM, Framer.STDOUT_FRAME_PREFIX, Ascii.GS, 42, -22, -26, Ascii.GS, 48, 44, -26, Ascii.RS, 36, Ascii.EM, Ascii.ESC, -26, -2, 36, Ascii.EM, Ascii.ESC, 4, Framer.ENTER_FRAME_PREFIX, Ascii.SUB, 42, Ascii.EM, 42, Framer.STDOUT_FRAME_PREFIX, 82, 92, 42, Framer.STDIN_REQUEST_FRAME_PREFIX, 74, 82, 85, 74, 75, 85, 78};
    }

    static {
        A05();
        A0H = new int[]{5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
        A0F = new H5(new H4() { // from class: com.facebook.ads.redexgen.X.mw
            @Override // com.facebook.ads.redexgen.core.H4
            public final Constructor A7R() {
                return DefaultExtractorsFactory.A01();
            }
        });
        A0G = new H5(new H4() { // from class: com.facebook.ads.redexgen.X.mv
            @Override // com.facebook.ads.redexgen.core.H4
            public final Constructor A7R() {
                return DefaultExtractorsFactory.A02();
            }
        });
    }

    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public DefaultExtractorsFactory() {
    }

    public static Constructor<? extends H9> A01() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        boolean isFlacNativeLibraryAvailable = Boolean.TRUE.equals(Class.forName(A00(124, 63, 62)).getMethod(A00(187, 11, 111), new Class[0]).invoke(null, new Object[0]));
        if (!isFlacNativeLibraryAvailable) {
            return null;
        }
        return Class.forName(A00(59, 65, 29)).asSubclass(H9.class).getConstructor(Integer.TYPE);
    }

    public static Constructor<? extends H9> A02() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName(A00(0, 59, 109)).asSubclass(H9.class).getConstructor(new Class[0]);
    }

    @MetaExoPlayerCustomization("Removed AVI and JPEG extractors")
    private void A06(int i3, List<H9> list) {
        int i4 = 2;
        switch (i3) {
            case 0:
                list.add(new C1928lX());
                return;
            case 1:
                list.add(new C1925lU());
                return;
            case 2:
                int i5 = (this.A0C ? 1 : 0) | this.A00;
                String[] strArr = A0E;
                if (strArr[2].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[5] = "0JYW4ys9S4cBRo9bfKNpoispKPkvAlfn";
                strArr2[7] = "ESM27VzyBHwJIaBfhIrCniRSUGwbmbgc";
                if (!this.A0B) {
                    i4 = 0;
                }
                list.add(new C1922lR(i4 | i5));
                return;
            case 3:
                int i6 = (this.A0C ? 1 : 0) | this.A01;
                boolean z2 = this.A0B;
                String[] strArr3 = A0E;
                if (strArr3[2].length() != strArr3[0].length()) {
                    String[] strArr4 = A0E;
                    strArr4[6] = "88SSgZrekVuE3ZpEu";
                    strArr4[1] = "yFmqseBd895DxKzOE";
                    if (!z2) {
                        i4 = 0;
                    }
                    list.add(new C1992ml(i4 | i6));
                    return;
                }
                throw new RuntimeException();
            case 4:
                H9 flacExtractor = A0F.A03(Integer.valueOf(this.A02));
                if (flacExtractor != null) {
                    list.add(flacExtractor);
                    return;
                } else {
                    list.add(new C1987mg(this.A02));
                    return;
                }
            case 5:
                list.add(new C1984md());
                return;
            case 6:
                list.add(new MatroskaExtractor(this.A04));
                return;
            case 7:
                int i7 = (this.A0C ? 1 : 0) | this.A05;
                if (!this.A0B) {
                    i4 = 0;
                }
                list.add(new C1973mG(i4 | i7));
                return;
            case 8:
                list.add(new C1959m2().A01(this.A03));
                list.add(new C1960m3(this.A06));
                return;
            case 9:
                list.add(new C1953lw());
                return;
            case 10:
                list.add(new C1905lA());
                return;
            case 11:
                list.add(new C1898l3(this.A08, new AnonymousClass53(0L), new C1920lP(this.A07, this.A0A), this.A09));
                return;
            case 12:
                list.add(new C1894kz());
                return;
            case 13:
            case 14:
            default:
                return;
            case 15:
                H9 midiExtractor = A0G.A03(new Object[0]);
                if (midiExtractor == null) {
                    return;
                }
                list.add(midiExtractor);
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.core.HD
    public final synchronized H9[] A5N() {
        return A5O(Uri.EMPTY, new HashMap());
    }

    @Override // com.facebook.ads.redexgen.core.HD
    public final synchronized H9[] A5O(Uri uri, Map<String, List<String>> responseHeaders) {
        List<Extractor> extractors;
        extractors = new ArrayList<>(A0H.length);
        int fileType = AbstractC03942k.A02(responseHeaders);
        if (fileType != -1) {
            A06(fileType, extractors);
        }
        int iA00 = AbstractC03942k.A00(uri);
        if (iA00 != -1 && iA00 != fileType) {
            A06(iA00, extractors);
        }
        for (int responseHeadersInferredFileType : A0H) {
            if (responseHeadersInferredFileType != fileType && responseHeadersInferredFileType != iA00) {
                A06(responseHeadersInferredFileType, extractors);
            }
        }
        return (H9[]) extractors.toArray(new H9[extractors.size()]);
    }
}
