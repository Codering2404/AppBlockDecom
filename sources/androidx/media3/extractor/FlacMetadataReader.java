package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacMetadataReader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FlacStreamMetadataHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FlacStreamMetadata f46152a;

        public FlacStreamMetadataHolder(FlacStreamMetadata flacStreamMetadata) {
            this.f46152a = flacStreamMetadata;
        }
    }

    public static boolean a(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.m(parsableByteArray.e(), 0, 4);
        return parsableByteArray.J() == 1716281667;
    }

    public static int b(ExtractorInput extractorInput) throws ParserException {
        extractorInput.f();
        ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        extractorInput.m(parsableByteArray.e(), 0, 2);
        int iP = parsableByteArray.P();
        if ((iP >> 2) == 16382) {
            extractorInput.f();
            return iP;
        }
        extractorInput.f();
        throw ParserException.a("First frame does not start with sync code.", null);
    }

    public static Metadata c(ExtractorInput extractorInput, boolean z2) throws Throwable {
        Metadata metadataA = new Id3Peeker().a(extractorInput, z2 ? null : Id3Decoder.f46470b);
        if (metadataA == null || metadataA.e() == 0) {
            return null;
        }
        return metadataA;
    }

    public static Metadata d(ExtractorInput extractorInput, boolean z2) throws Throwable {
        extractorInput.f();
        long jH = extractorInput.h();
        Metadata metadataC = c(extractorInput, z2);
        extractorInput.k((int) (extractorInput.h() - jH));
        return metadataC;
    }

    public static boolean e(ExtractorInput extractorInput, FlacStreamMetadataHolder flacStreamMetadataHolder) {
        extractorInput.f();
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[4]);
        extractorInput.m(parsableBitArray.f41576a, 0, 4);
        boolean zG = parsableBitArray.g();
        int iH = parsableBitArray.h(7);
        int iH2 = parsableBitArray.h(24) + 4;
        if (iH == 0) {
            flacStreamMetadataHolder.f46152a = h(extractorInput);
            return zG;
        }
        FlacStreamMetadata flacStreamMetadata = flacStreamMetadataHolder.f46152a;
        if (flacStreamMetadata == null) {
            throw new IllegalArgumentException();
        }
        if (iH == 3) {
            flacStreamMetadataHolder.f46152a = flacStreamMetadata.b(g(extractorInput, iH2));
            return zG;
        }
        if (iH == 4) {
            flacStreamMetadataHolder.f46152a = flacStreamMetadata.c(j(extractorInput, iH2));
            return zG;
        }
        if (iH != 6) {
            extractorInput.k(iH2);
            return zG;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(iH2);
        extractorInput.readFully(parsableByteArray.e(), 0, iH2);
        parsableByteArray.X(4);
        flacStreamMetadataHolder.f46152a = flacStreamMetadata.a(ImmutableList.z(PictureFrame.d(parsableByteArray)));
        return zG;
    }

    public static FlacStreamMetadata.SeekTable f(ParsableByteArray parsableByteArray) {
        parsableByteArray.X(1);
        int iK = parsableByteArray.K();
        long jF = ((long) parsableByteArray.f()) + ((long) iK);
        int i3 = iK / 18;
        long[] jArrCopyOf = new long[i3];
        long[] jArrCopyOf2 = new long[i3];
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            long jA = parsableByteArray.A();
            if (jA == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                break;
            }
            jArrCopyOf[i4] = jA;
            jArrCopyOf2[i4] = parsableByteArray.A();
            parsableByteArray.X(2);
            i4++;
        }
        parsableByteArray.X((int) (jF - ((long) parsableByteArray.f())));
        return new FlacStreamMetadata.SeekTable(jArrCopyOf, jArrCopyOf2);
    }

    private static FlacStreamMetadata.SeekTable g(ExtractorInput extractorInput, int i3) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i3);
        extractorInput.readFully(parsableByteArray.e(), 0, i3);
        return f(parsableByteArray);
    }

    private static FlacStreamMetadata h(ExtractorInput extractorInput) {
        byte[] bArr = new byte[38];
        extractorInput.readFully(bArr, 0, 38);
        return new FlacStreamMetadata(bArr, 4);
    }

    public static void i(ExtractorInput extractorInput) throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.e(), 0, 4);
        if (parsableByteArray.J() != 1716281667) {
            throw ParserException.a("Failed to read FLAC stream marker.", null);
        }
    }

    private static List j(ExtractorInput extractorInput, int i3) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i3);
        extractorInput.readFully(parsableByteArray.e(), 0, i3);
        parsableByteArray.X(4);
        return Arrays.asList(VorbisUtil.k(parsableByteArray, false, false).f46243b);
    }
}
