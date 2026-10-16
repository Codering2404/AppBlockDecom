package androidx.media3.extractor;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.Util;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DtsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f46134a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f46135b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f46136c = {64, 112, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 192, 224, Function.MAX_NARGS, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f46137d = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f46138e = {5, 8, 10, 12};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f46139f = {6, 9, 12, 15};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f46140g = {2, 4, 6, 8};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f46141h = {9, 11, 13, 16};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f46142i = {5, 8, 10, 12};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DtsAudioMimeType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DtsHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f46146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f46147e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f46148f;

        private DtsHeader(String str, int i3, int i4, int i5, long j3, int i6) {
            this.f46143a = str;
            this.f46145c = i3;
            this.f46144b = i4;
            this.f46146d = i5;
            this.f46147e = j3;
            this.f46148f = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    private static void a(byte[] bArr, int i3) throws ParserException {
        int i4 = i3 - 2;
        if (((bArr[i3 - 1] & 255) | ((bArr[i4] << 8) & 65535)) != Util.x(bArr, 0, i4, 65535)) {
            throw ParserException.a("CRC check failed", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4f
            r2 = -1
            if (r1 == r2) goto L3e
            r2 = 31
            if (r1 == r2) goto L26
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L20:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L5e
        L26:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
        L36:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5e
        L3e:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
            goto L36
        L4f:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L20
        L5e:
            if (r0 == 0) goto L64
            int r7 = r7 * 16
            int r7 = r7 / 14
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.DtsUtil.b(byte[]):int");
    }

    public static int c(int i3) {
        if (i3 == 2147385345 || i3 == -25230976 || i3 == 536864768 || i3 == -14745368) {
            return 1;
        }
        if (i3 == 1683496997 || i3 == 622876772) {
            return 2;
        }
        if (i3 == 1078008818 || i3 == -233094848) {
            return 3;
        }
        return (i3 == 1908687592 || i3 == -398277519) ? 4 : 0;
    }

    private static ParsableBitArray d(byte[] bArr) {
        byte b3 = bArr[0];
        if (b3 == 127 || b3 == 100 || b3 == 64 || b3 == 113) {
            return new ParsableBitArray(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (e(bArrCopyOf)) {
            for (int i3 = 0; i3 < bArrCopyOf.length - 1; i3 += 2) {
                byte b4 = bArrCopyOf[i3];
                int i4 = i3 + 1;
                bArrCopyOf[i3] = bArrCopyOf[i4];
                bArrCopyOf[i4] = b4;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(bArrCopyOf);
            while (parsableBitArray2.b() >= 16) {
                parsableBitArray2.r(2);
                parsableBitArray.f(parsableBitArray2.h(14), 14);
            }
        }
        parsableBitArray.n(bArrCopyOf);
        return parsableBitArray;
    }

    private static boolean e(byte[] bArr) {
        byte b3 = bArr[0];
        return b3 == -2 || b3 == -1 || b3 == 37 || b3 == -14 || b3 == -24;
    }

    public static int f(ByteBuffer byteBuffer) {
        int i3;
        byte b3;
        int i4;
        byte b4;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int iPosition = byteBuffer.position();
        byte b5 = byteBuffer.get(iPosition);
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b4 = byteBuffer.get(iPosition + 7);
            } else if (b5 != 31) {
                i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b3 = byteBuffer.get(iPosition + 5);
            } else {
                i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b4 = byteBuffer.get(iPosition + 6);
            }
            i4 = b4 & 60;
            return (((i4 >> 2) | i3) + 1) * 32;
        }
        i3 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b3 = byteBuffer.get(iPosition + 4);
        i4 = b3 & 252;
        return (((i4 >> 2) | i3) + 1) * 32;
    }

    public static int g(byte[] bArr) {
        int i3;
        byte b3;
        int i4;
        byte b4;
        byte b5 = bArr[0];
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (bArr[4] & 7) << 4;
                b4 = bArr[7];
            } else if (b5 != 31) {
                i3 = (bArr[4] & 1) << 6;
                b3 = bArr[5];
            } else {
                i3 = (bArr[5] & 7) << 4;
                b4 = bArr[6];
            }
            i4 = b4 & 60;
            return (((i4 >> 2) | i3) + 1) * 32;
        }
        i3 = (bArr[5] & 1) << 6;
        b3 = bArr[4];
        i4 = b3 & 252;
        return (((i4 >> 2) | i3) + 1) * 32;
    }

    public static Format h(byte[] bArr, String str, String str2, int i3, String str3, DrmInitData drmInitData) {
        ParsableBitArray parsableBitArrayD = d(bArr);
        parsableBitArrayD.r(60);
        int i4 = f46134a[parsableBitArrayD.h(6)];
        int i5 = f46135b[parsableBitArrayD.h(4)];
        int iH = parsableBitArrayD.h(5);
        int[] iArr = f46136c;
        int i6 = iH >= iArr.length ? -1 : (iArr[iH] * 1000) / 2;
        parsableBitArrayD.r(10);
        return new Format.Builder().f0(str).U(str3).u0("audio/vnd.dts").Q(i6).R(i4 + (parsableBitArrayD.h(2) > 0 ? 1 : 0)).v0(i5).Y(drmInitData).j0(str2).s0(i3).N();
    }

    public static DtsHeader i(byte[] bArr) throws ParserException {
        int i3;
        int i4;
        int iH;
        int i5;
        long jZ0;
        int i6;
        ParsableBitArray parsableBitArrayD = d(bArr);
        parsableBitArrayD.r(40);
        int iH2 = parsableBitArrayD.h(2);
        if (parsableBitArrayD.g()) {
            i3 = 20;
            i4 = 12;
        } else {
            i3 = 16;
            i4 = 8;
        }
        parsableBitArrayD.r(i4);
        int iH3 = parsableBitArrayD.h(i3) + 1;
        boolean zG = parsableBitArrayD.g();
        int iH4 = -1;
        int i7 = 0;
        if (zG) {
            iH = parsableBitArrayD.h(2);
            int iH5 = (parsableBitArrayD.h(3) + 1) * 512;
            if (parsableBitArrayD.g()) {
                parsableBitArrayD.r(36);
            }
            int iH6 = parsableBitArrayD.h(3) + 1;
            int iH7 = parsableBitArrayD.h(3) + 1;
            if (iH6 != 1 || iH7 != 1) {
                throw ParserException.c("Multiple audio presentations or assets not supported");
            }
            int i8 = iH2 + 1;
            int iH8 = parsableBitArrayD.h(i8);
            for (int i9 = 0; i9 < i8; i9++) {
                if (((iH8 >> i9) & 1) == 1) {
                    parsableBitArrayD.r(8);
                }
            }
            if (parsableBitArrayD.g()) {
                parsableBitArrayD.r(2);
                int iH9 = (parsableBitArrayD.h(2) + 1) << 2;
                int iH10 = parsableBitArrayD.h(2) + 1;
                while (i7 < iH10) {
                    parsableBitArrayD.r(iH9);
                    i7++;
                }
            }
            i7 = iH5;
        } else {
            iH = -1;
        }
        parsableBitArrayD.r(i3);
        parsableBitArrayD.r(12);
        if (zG) {
            if (parsableBitArrayD.g()) {
                parsableBitArrayD.r(4);
            }
            if (parsableBitArrayD.g()) {
                parsableBitArrayD.r(24);
            }
            if (parsableBitArrayD.g()) {
                parsableBitArrayD.s(parsableBitArrayD.h(10) + 1);
            }
            parsableBitArrayD.r(5);
            i5 = f46137d[parsableBitArrayD.h(4)];
            iH4 = parsableBitArrayD.h(8) + 1;
        } else {
            i5 = -2147483647;
        }
        int i10 = i5;
        if (zG) {
            if (iH == 0) {
                i6 = 32000;
            } else if (iH == 1) {
                i6 = 44100;
            } else {
                if (iH != 2) {
                    throw ParserException.a("Unsupported reference clock code in DTS HD header: " + iH, null);
                }
                i6 = 48000;
            }
            jZ0 = Util.Z0(i7, 1000000L, i6);
        } else {
            jZ0 = -9223372036854775807L;
        }
        return new DtsHeader("audio/vnd.dts.hd;profile=lbr", iH4, i10, iH3, jZ0, 0);
    }

    public static int j(byte[] bArr) {
        ParsableBitArray parsableBitArrayD = d(bArr);
        parsableBitArrayD.r(42);
        return parsableBitArrayD.h(parsableBitArrayD.g() ? 12 : 8) + 1;
    }

    public static DtsHeader k(byte[] bArr, AtomicInteger atomicInteger) throws ParserException {
        int iH;
        long jZ0;
        AtomicInteger atomicInteger2;
        int i3;
        int i4;
        ParsableBitArray parsableBitArrayD = d(bArr);
        int i5 = parsableBitArrayD.h(32) == 1078008818 ? 1 : 0;
        int iM = m(parsableBitArrayD, f46138e, true) + 1;
        if (i5 == 0) {
            iH = -2147483647;
            jZ0 = -9223372036854775807L;
        } else {
            if (!parsableBitArrayD.g()) {
                throw ParserException.c("Only supports full channel mask-based audio presentation");
            }
            a(bArr, iM);
            int iH2 = parsableBitArrayD.h(2);
            if (iH2 == 0) {
                i3 = 512;
            } else if (iH2 == 1) {
                i3 = 480;
            } else {
                if (iH2 != 2) {
                    throw ParserException.a("Unsupported base duration index in DTS UHD header: " + iH2, null);
                }
                i3 = 384;
            }
            int iH3 = i3 * (parsableBitArrayD.h(3) + 1);
            int iH4 = parsableBitArrayD.h(2);
            if (iH4 == 0) {
                i4 = 32000;
            } else if (iH4 == 1) {
                i4 = 44100;
            } else {
                if (iH4 != 2) {
                    throw ParserException.a("Unsupported clock rate index in DTS UHD header: " + iH4, null);
                }
                i4 = 48000;
            }
            if (parsableBitArrayD.g()) {
                parsableBitArrayD.r(36);
            }
            iH = (1 << parsableBitArrayD.h(2)) * i4;
            jZ0 = Util.Z0(iH3, 1000000L, i4);
        }
        int i6 = iH;
        long j3 = jZ0;
        int iM2 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            iM2 += m(parsableBitArrayD, f46139f, true);
        }
        if (i5 != 0) {
            atomicInteger2 = atomicInteger;
            atomicInteger2.set(m(parsableBitArrayD, f46140g, true));
        } else {
            atomicInteger2 = atomicInteger;
        }
        return new DtsHeader("audio/vnd.dts.uhd;profile=p2", 2, i6, iM + iM2 + (atomicInteger2.get() != 0 ? m(parsableBitArrayD, f46141h, true) : 0), j3, 0);
    }

    public static int l(byte[] bArr) {
        ParsableBitArray parsableBitArrayD = d(bArr);
        parsableBitArrayD.r(32);
        return m(parsableBitArrayD, f46142i, true) + 1;
    }

    private static int m(ParsableBitArray parsableBitArray, int[] iArr, boolean z2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 3 && parsableBitArray.g(); i5++) {
            i4++;
        }
        if (z2) {
            int i6 = 0;
            while (i3 < i4) {
                i6 += 1 << iArr[i3];
                i3++;
            }
            i3 = i6;
        }
        return i3 + parsableBitArray.h(iArr[i4]);
    }
}
