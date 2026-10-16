package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MpeghUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MhasPacketHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f47626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f47627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f47628c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Mpegh3daConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f47632d;

        private Mpegh3daConfig(int i3, int i4, int i5, byte[] bArr) {
            this.f47629a = i3;
            this.f47630b = i4;
            this.f47631c = i5;
            this.f47632d = bArr;
        }
    }

    private static int a(int i3) throws ParserException {
        if (i3 == 0) {
            return 768;
        }
        if (i3 == 1) {
            return 1024;
        }
        if (i3 == 2 || i3 == 3) {
            return 2048;
        }
        if (i3 == 4) {
            return 4096;
        }
        throw ParserException.c("Unsupported coreSbrFrameLengthIndex " + i3);
    }

    private static double b(int i3) throws ParserException {
        switch (i3) {
            case 14700:
            case 16000:
                return 3.0d;
            case 22050:
            case 24000:
                return 2.0d;
            case 29400:
            case 32000:
            case 58800:
            case 64000:
                return 1.5d;
            case 44100:
            case 48000:
            case 88200:
            case 96000:
                return 1.0d;
            default:
                throw ParserException.c("Unsupported sampling rate " + i3);
        }
    }

    private static int c(int i3) throws ParserException {
        switch (i3) {
            case 0:
                return 96000;
            case 1:
                return 88200;
            case 2:
                return 64000;
            case 3:
                return 48000;
            case 4:
                return 44100;
            case 5:
                return 32000;
            case 6:
                return 24000;
            case 7:
                return 22050;
            case 8:
                return 16000;
            case 9:
                return 12000;
            case 10:
                return 11025;
            case 11:
                return 8000;
            case 12:
                return 7350;
            case 13:
            case 14:
            default:
                throw ParserException.c("Unsupported sampling rate index " + i3);
            case 15:
                return 57600;
            case 16:
                return 51200;
            case 17:
                return 40000;
            case 18:
                return 38400;
            case 19:
                return 34150;
            case 20:
                return 28800;
            case 21:
                return 25600;
            case 22:
                return 20000;
            case 23:
                return 19200;
            case 24:
                return 17075;
            case 25:
                return 14400;
            case 26:
                return 12800;
            case 27:
                return 9600;
        }
    }

    private static int d(int i3) throws ParserException {
        if (i3 == 0 || i3 == 1) {
            return 0;
        }
        int i4 = 2;
        if (i3 != 2) {
            i4 = 3;
            if (i3 != 3) {
                if (i3 == 4) {
                    return 1;
                }
                throw ParserException.c("Unsupported coreSbrFrameLengthIndex " + i3);
            }
        }
        return i4;
    }

    public static boolean e(int i3) {
        return (i3 & 16777215) == 12583333;
    }

    public static int f(ParsableBitArray parsableBitArray) {
        if (!parsableBitArray.g()) {
            return 0;
        }
        parsableBitArray.r(2);
        return parsableBitArray.h(13);
    }

    public static boolean g(ParsableBitArray parsableBitArray, MhasPacketHeader mhasPacketHeader) throws ParserException {
        parsableBitArray.d();
        int iK = k(parsableBitArray, 3, 8, 8);
        mhasPacketHeader.f47626a = iK;
        if (iK == -1) {
            return false;
        }
        long jL = l(parsableBitArray, 2, 8, 32);
        mhasPacketHeader.f47627b = jL;
        if (jL == -1) {
            return false;
        }
        if (jL > 16) {
            throw ParserException.c("Contains sub-stream with an invalid packet label " + mhasPacketHeader.f47627b);
        }
        if (jL == 0) {
            int i3 = mhasPacketHeader.f47626a;
            if (i3 == 1) {
                throw ParserException.a("Mpegh3daConfig packet with invalid packet label 0", null);
            }
            if (i3 == 2) {
                throw ParserException.a("Mpegh3daFrame packet with invalid packet label 0", null);
            }
            if (i3 == 17) {
                throw ParserException.a("AudioTruncation packet with invalid packet label 0", null);
            }
        }
        int iK2 = k(parsableBitArray, 11, 24, 24);
        mhasPacketHeader.f47628c = iK2;
        return iK2 != -1;
    }

    public static Mpegh3daConfig h(ParsableBitArray parsableBitArray) throws ParserException {
        int iH = parsableBitArray.h(8);
        int iH2 = parsableBitArray.h(5);
        int iH3 = iH2 == 31 ? parsableBitArray.h(24) : c(iH2);
        int iH4 = parsableBitArray.h(3);
        int iA = a(iH4);
        int iD = d(iH4);
        parsableBitArray.r(2);
        p(parsableBitArray);
        m(parsableBitArray, j(parsableBitArray), iD);
        byte[] bArr = null;
        if (parsableBitArray.g()) {
            int iK = k(parsableBitArray, 2, 4, 8) + 1;
            for (int i3 = 0; i3 < iK; i3++) {
                int iK2 = k(parsableBitArray, 4, 8, 16);
                int iK3 = k(parsableBitArray, 4, 8, 16);
                if (iK2 == 7) {
                    int iH5 = parsableBitArray.h(4) + 1;
                    parsableBitArray.r(4);
                    byte[] bArr2 = new byte[iH5];
                    for (int i4 = 0; i4 < iH5; i4++) {
                        bArr2[i4] = (byte) parsableBitArray.h(8);
                    }
                    bArr = bArr2;
                } else {
                    parsableBitArray.r(iK3 * 8);
                }
            }
        }
        byte[] bArr3 = bArr;
        double dB = b(iH3);
        return new Mpegh3daConfig(iH, (int) (((double) iH3) * dB), (int) (((double) iA) * dB), bArr3);
    }

    private static boolean i(ParsableBitArray parsableBitArray) {
        parsableBitArray.r(3);
        boolean zG = parsableBitArray.g();
        if (zG) {
            parsableBitArray.r(13);
        }
        return zG;
    }

    private static int j(ParsableBitArray parsableBitArray) {
        int iH = parsableBitArray.h(5);
        int iK = 0;
        for (int i3 = 0; i3 < iH + 1; i3++) {
            int iH2 = parsableBitArray.h(3);
            iK += k(parsableBitArray, 5, 8, 16) + 1;
            if ((iH2 == 0 || iH2 == 2) && parsableBitArray.g()) {
                p(parsableBitArray);
            }
        }
        return iK;
    }

    private static int k(ParsableBitArray parsableBitArray, int i3, int i4, int i5) {
        Assertions.a(Math.max(Math.max(i3, i4), i5) <= 31);
        int i6 = (1 << i3) - 1;
        int i7 = (1 << i4) - 1;
        IntMath.b(IntMath.b(i6, i7), 1 << i5);
        if (parsableBitArray.b() < i3) {
            return -1;
        }
        int iH = parsableBitArray.h(i3);
        if (iH != i6) {
            return iH;
        }
        if (parsableBitArray.b() < i4) {
            return -1;
        }
        int iH2 = parsableBitArray.h(i4);
        int i8 = iH + iH2;
        if (iH2 != i7) {
            return i8;
        }
        if (parsableBitArray.b() < i5) {
            return -1;
        }
        return i8 + parsableBitArray.h(i5);
    }

    private static long l(ParsableBitArray parsableBitArray, int i3, int i4, int i5) {
        Assertions.a(Math.max(Math.max(i3, i4), i5) <= 63);
        long j3 = (1 << i3) - 1;
        long j4 = (1 << i4) - 1;
        LongMath.a(LongMath.a(j3, j4), 1 << i5);
        if (parsableBitArray.b() < i3) {
            return -1L;
        }
        long j5 = parsableBitArray.j(i3);
        if (j5 != j3) {
            return j5;
        }
        if (parsableBitArray.b() < i4) {
            return -1L;
        }
        long j6 = parsableBitArray.j(i4);
        long j7 = j5 + j6;
        if (j6 != j4) {
            return j7;
        }
        if (parsableBitArray.b() < i5) {
            return -1L;
        }
        return j7 + parsableBitArray.j(i5);
    }

    private static void m(ParsableBitArray parsableBitArray, int i3, int i4) {
        int iH;
        int iK = k(parsableBitArray, 4, 8, 16) + 1;
        parsableBitArray.q();
        for (int i5 = 0; i5 < iK; i5++) {
            int iH2 = parsableBitArray.h(2);
            if (iH2 == 0) {
                i(parsableBitArray);
                if (i4 > 0) {
                    o(parsableBitArray);
                }
            } else if (iH2 == 1) {
                if (i(parsableBitArray)) {
                    parsableBitArray.q();
                }
                if (i4 > 0) {
                    o(parsableBitArray);
                    iH = parsableBitArray.h(2);
                } else {
                    iH = 0;
                }
                if (iH > 0) {
                    parsableBitArray.r(6);
                    int iH3 = parsableBitArray.h(2);
                    parsableBitArray.r(4);
                    if (parsableBitArray.g()) {
                        parsableBitArray.r(5);
                    }
                    if (iH == 2 || iH == 3) {
                        parsableBitArray.r(6);
                    }
                    if (iH3 == 2) {
                        parsableBitArray.q();
                    }
                }
                int iFloor = ((int) Math.floor(Math.log(i3 - 1) / Math.log(2.0d))) + 1;
                int iH4 = parsableBitArray.h(2);
                if (iH4 > 0 && parsableBitArray.g()) {
                    parsableBitArray.r(iFloor);
                }
                if (parsableBitArray.g()) {
                    parsableBitArray.r(iFloor);
                }
                if (i4 == 0 && iH4 == 0) {
                    parsableBitArray.q();
                }
            } else if (iH2 == 3) {
                k(parsableBitArray, 4, 8, 16);
                int iK2 = k(parsableBitArray, 4, 8, 16);
                if (parsableBitArray.g()) {
                    k(parsableBitArray, 8, 16, 0);
                }
                parsableBitArray.q();
                if (iK2 > 0) {
                    parsableBitArray.r(iK2 * 8);
                }
            }
        }
    }

    private static void n(ParsableBitArray parsableBitArray, int i3) {
        int iH;
        boolean zG = parsableBitArray.g();
        int i4 = zG ? 1 : 5;
        int i5 = zG ? 7 : 5;
        int i6 = zG ? 8 : 6;
        int i7 = 0;
        while (i7 < i3) {
            if (parsableBitArray.g()) {
                parsableBitArray.r(7);
                iH = 0;
            } else {
                if (parsableBitArray.h(2) == 3 && parsableBitArray.h(i5) * i4 != 0) {
                    parsableBitArray.q();
                }
                iH = parsableBitArray.h(i6) * i4;
                if (iH != 0 && iH != 180) {
                    parsableBitArray.q();
                }
                parsableBitArray.q();
            }
            if (iH != 0 && iH != 180 && parsableBitArray.g()) {
                i7++;
            }
            i7++;
        }
    }

    private static void o(ParsableBitArray parsableBitArray) {
        parsableBitArray.r(3);
        parsableBitArray.r(8);
        boolean zG = parsableBitArray.g();
        boolean zG2 = parsableBitArray.g();
        if (zG) {
            parsableBitArray.r(5);
        }
        if (zG2) {
            parsableBitArray.r(6);
        }
    }

    private static void p(ParsableBitArray parsableBitArray) {
        int iH = parsableBitArray.h(2);
        if (iH == 0) {
            parsableBitArray.r(6);
            return;
        }
        int iK = k(parsableBitArray, 5, 8, 16) + 1;
        if (iH == 1) {
            parsableBitArray.r(iK * 7);
        } else if (iH == 2) {
            n(parsableBitArray, iK);
        }
    }
}
