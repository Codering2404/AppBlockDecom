package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacFrameReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SampleNumberHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f46151a;
    }

    private static boolean a(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i3) {
        int iJ = j(parsableByteArray, i3);
        return iJ != -1 && iJ <= flacStreamMetadata.f46156b;
    }

    private static boolean b(ParsableByteArray parsableByteArray, int i3) {
        return parsableByteArray.H() == Util.A(parsableByteArray.e(), i3, parsableByteArray.f() - 1, 0);
    }

    private static boolean c(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z2, SampleNumberHolder sampleNumberHolder) {
        try {
            long jQ = parsableByteArray.Q();
            if (!z2) {
                jQ *= (long) flacStreamMetadata.f46156b;
            }
            sampleNumberHolder.f46151a = jQ;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i3, SampleNumberHolder sampleNumberHolder) {
        int iF = parsableByteArray.f();
        long J = parsableByteArray.J();
        long j3 = J >>> 16;
        if (j3 != i3) {
            return false;
        }
        return g((int) ((J >> 4) & 15), flacStreamMetadata) && f((int) ((J >> 1) & 7), flacStreamMetadata) && !(((J & 1) > 1L ? 1 : ((J & 1) == 1L ? 0 : -1)) == 0) && c(parsableByteArray, flacStreamMetadata, ((j3 & 1) > 1L ? 1 : ((j3 & 1) == 1L ? 0 : -1)) == 0, sampleNumberHolder) && a(parsableByteArray, flacStreamMetadata, (int) ((J >> 12) & 15)) && e(parsableByteArray, flacStreamMetadata, (int) ((J >> 8) & 15)) && b(parsableByteArray, iF);
    }

    private static boolean e(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i3) {
        int i4 = flacStreamMetadata.f46159e;
        if (i3 == 0) {
            return true;
        }
        if (i3 <= 11) {
            return i3 == flacStreamMetadata.f46160f;
        }
        if (i3 == 12) {
            return parsableByteArray.H() * 1000 == i4;
        }
        if (i3 <= 14) {
            int iP = parsableByteArray.P();
            if (i3 == 14) {
                iP *= 10;
            }
            if (iP == i4) {
                return true;
            }
        }
        return false;
    }

    private static boolean f(int i3, FlacStreamMetadata flacStreamMetadata) {
        return i3 == 0 || i3 == flacStreamMetadata.f46163i;
    }

    private static boolean g(int i3, FlacStreamMetadata flacStreamMetadata) {
        return i3 <= 7 ? i3 == flacStreamMetadata.f46161g - 1 : i3 <= 10 && flacStreamMetadata.f46161g == 2;
    }

    public static boolean h(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i3, SampleNumberHolder sampleNumberHolder) {
        long jH = extractorInput.h();
        byte[] bArr = new byte[2];
        extractorInput.m(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i3) {
            extractorInput.f();
            extractorInput.i((int) (jH - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.e(), 0, 2);
        parsableByteArray.V(ExtractorUtil.c(extractorInput, parsableByteArray.e(), 2, 14));
        extractorInput.f();
        extractorInput.i((int) (jH - extractorInput.getPosition()));
        return d(parsableByteArray, flacStreamMetadata, i3, sampleNumberHolder);
    }

    public static long i(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws ParserException {
        extractorInput.f();
        extractorInput.i(1);
        byte[] bArr = new byte[1];
        extractorInput.m(bArr, 0, 1);
        boolean z2 = (bArr[0] & 1) == 1;
        extractorInput.i(2);
        int i3 = z2 ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i3);
        parsableByteArray.V(ExtractorUtil.c(extractorInput, parsableByteArray.e(), 0, i3));
        extractorInput.f();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (c(parsableByteArray, flacStreamMetadata, z2, sampleNumberHolder)) {
            return sampleNumberHolder.f46151a;
        }
        throw ParserException.a(null, null);
    }

    public static int j(ParsableByteArray parsableByteArray, int i3) {
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i3 - 2);
            case 6:
                return parsableByteArray.H() + 1;
            case 7:
                return parsableByteArray.P() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return Function.MAX_NARGS << (i3 - 8);
            default:
                return -1;
        }
    }
}
