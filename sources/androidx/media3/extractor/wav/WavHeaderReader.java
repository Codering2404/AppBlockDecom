package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WavHeaderReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ChunkHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f47790b;

        private ChunkHeader(int i3, long j3) {
            this.f47789a = i3;
            this.f47790b = j3;
        }

        public static ChunkHeader a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) {
            extractorInput.m(parsableByteArray.e(), 0, 8);
            parsableByteArray.W(0);
            return new ChunkHeader(parsableByteArray.q(), parsableByteArray.x());
        }
    }

    public static boolean a(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i3 = ChunkHeader.a(extractorInput, parsableByteArray).f47789a;
        if (i3 != 1380533830 && i3 != 1380333108) {
            return false;
        }
        extractorInput.m(parsableByteArray.e(), 0, 4);
        parsableByteArray.W(0);
        int iQ = parsableByteArray.q();
        if (iQ == 1463899717) {
            return true;
        }
        Log.d("WavHeaderReader", "Unsupported form type: " + iQ);
        return false;
    }

    public static WavFormat b(ExtractorInput extractorInput) throws ParserException {
        byte[] bArr;
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        ChunkHeader chunkHeaderD = d(1718449184, extractorInput, parsableByteArray);
        Assertions.g(chunkHeaderD.f47790b >= 16);
        extractorInput.m(parsableByteArray.e(), 0, 16);
        parsableByteArray.W(0);
        int iZ = parsableByteArray.z();
        int iZ2 = parsableByteArray.z();
        int iY = parsableByteArray.y();
        int iY2 = parsableByteArray.y();
        int iZ3 = parsableByteArray.z();
        int iZ4 = parsableByteArray.z();
        int i3 = ((int) chunkHeaderD.f47790b) - 16;
        if (i3 > 0) {
            bArr = new byte[i3];
            extractorInput.m(bArr, 0, i3);
        } else {
            bArr = Util.f41614f;
        }
        byte[] bArr2 = bArr;
        extractorInput.k((int) (extractorInput.h() - extractorInput.getPosition()));
        return new WavFormat(iZ, iZ2, iY, iY2, iZ3, iZ4, bArr2);
    }

    public static long c(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader chunkHeaderA = ChunkHeader.a(extractorInput, parsableByteArray);
        if (chunkHeaderA.f47789a != 1685272116) {
            extractorInput.f();
            return -1L;
        }
        extractorInput.i(8);
        parsableByteArray.W(0);
        extractorInput.m(parsableByteArray.e(), 0, 8);
        long jV = parsableByteArray.v();
        extractorInput.k(((int) chunkHeaderA.f47790b) + 8);
        return jV;
    }

    private static ChunkHeader d(int i3, ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws ParserException {
        ChunkHeader chunkHeaderA = ChunkHeader.a(extractorInput, parsableByteArray);
        while (chunkHeaderA.f47789a != i3) {
            Log.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + chunkHeaderA.f47789a);
            long j3 = chunkHeaderA.f47790b;
            long j4 = 8 + j3;
            if (j3 % 2 != 0) {
                j4 = 9 + j3;
            }
            if (j4 > 2147483647L) {
                throw ParserException.c("Chunk is too large (~2GB+) to skip; id: " + chunkHeaderA.f47789a);
            }
            extractorInput.k((int) j4);
            chunkHeaderA = ChunkHeader.a(extractorInput, parsableByteArray);
        }
        return chunkHeaderA;
    }

    public static Pair e(ExtractorInput extractorInput) throws ParserException {
        extractorInput.f();
        ChunkHeader chunkHeaderD = d(1684108385, extractorInput, new ParsableByteArray(8));
        extractorInput.k(8);
        return Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(chunkHeaderD.f47790b));
    }
}
