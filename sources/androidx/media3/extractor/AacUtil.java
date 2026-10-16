package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AacUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f46022a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f46023b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AacAudioObjectType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f46026c;

        private Config(int i3, int i4, String str) {
            this.f46024a = i3;
            this.f46025b = i4;
            this.f46026c = str;
        }
    }

    public static byte[] a(int i3, int i4, int i5) {
        return new byte[]{(byte) (((i3 << 3) & 248) | ((i4 >> 1) & 7)), (byte) (((i4 << 7) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) | ((i5 << 3) & 120))};
    }

    private static int b(ParsableBitArray parsableBitArray) {
        int iH = parsableBitArray.h(5);
        return iH == 31 ? parsableBitArray.h(6) + 32 : iH;
    }

    private static int c(ParsableBitArray parsableBitArray) throws ParserException {
        int iH = parsableBitArray.h(4);
        if (iH == 15) {
            if (parsableBitArray.b() >= 24) {
                return parsableBitArray.h(24);
            }
            throw ParserException.a("AAC header insufficient data", null);
        }
        if (iH < 13) {
            return f46022a[iH];
        }
        throw ParserException.a("AAC header wrong Sampling Frequency Index", null);
    }

    public static Config d(ParsableBitArray parsableBitArray, boolean z2) throws ParserException {
        int iB = b(parsableBitArray);
        int iC = c(parsableBitArray);
        int iH = parsableBitArray.h(4);
        String str = "mp4a.40." + iB;
        if (iB == 5 || iB == 29) {
            iC = c(parsableBitArray);
            iB = b(parsableBitArray);
            if (iB == 22) {
                iH = parsableBitArray.h(4);
            }
        }
        if (z2) {
            if (iB != 1 && iB != 2 && iB != 3 && iB != 4 && iB != 6 && iB != 7 && iB != 17) {
                switch (iB) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.c("Unsupported audio object type: " + iB);
                }
            }
            f(parsableBitArray, iB, iH);
            switch (iB) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = parsableBitArray.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw ParserException.c("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i3 = f46023b[iH];
        if (i3 != -1) {
            return new Config(iC, i3, str);
        }
        throw ParserException.a(null, null);
    }

    public static Config e(byte[] bArr) {
        return d(new ParsableBitArray(bArr), false);
    }

    private static void f(ParsableBitArray parsableBitArray, int i3, int i4) {
        if (parsableBitArray.g()) {
            Log.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(14);
        }
        boolean zG = parsableBitArray.g();
        if (i4 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i3 == 6 || i3 == 20) {
            parsableBitArray.r(3);
        }
        if (zG) {
            if (i3 == 22) {
                parsableBitArray.r(16);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                parsableBitArray.r(3);
            }
            parsableBitArray.r(1);
        }
    }
}
