package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ogg.StreamReader;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FlacReader extends StreamReader {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private FlacStreamMetadata f46879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private FlacOggSeeker f46880o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FlacOggSeeker implements OggSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FlacStreamMetadata f46881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FlacStreamMetadata.SeekTable f46882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f46883c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f46884d = -1;

        public FlacOggSeeker(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.SeekTable seekTable) {
            this.f46881a = flacStreamMetadata;
            this.f46882b = seekTable;
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public long a(ExtractorInput extractorInput) {
            long j3 = this.f46884d;
            if (j3 < 0) {
                return -1L;
            }
            long j4 = -(j3 + 2);
            this.f46884d = -1L;
            return j4;
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public SeekMap b() {
            Assertions.g(this.f46883c != -1);
            return new FlacSeekTableSeekMap(this.f46881a, this.f46883c);
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public void c(long j3) {
            long[] jArr = this.f46882b.f46167a;
            this.f46884d = jArr[Util.j(jArr, j3, true, true)];
        }

        public void d(long j3) {
            this.f46883c = j3;
        }
    }

    FlacReader() {
    }

    private int n(ParsableByteArray parsableByteArray) {
        int i3 = (parsableByteArray.e()[2] & 255) >> 4;
        if (i3 == 6 || i3 == 7) {
            parsableByteArray.X(4);
            parsableByteArray.Q();
        }
        int iJ = FlacFrameReader.j(parsableByteArray, i3);
        parsableByteArray.W(0);
        return iJ;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(ParsableByteArray parsableByteArray) {
        return parsableByteArray.a() >= 5 && parsableByteArray.H() == 127 && parsableByteArray.J() == 1179402563;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected long f(ParsableByteArray parsableByteArray) {
        if (o(parsableByteArray.e())) {
            return n(parsableByteArray);
        }
        return -1L;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected boolean h(ParsableByteArray parsableByteArray, long j3, StreamReader.SetupData setupData) {
        byte[] bArrE = parsableByteArray.e();
        FlacStreamMetadata flacStreamMetadata = this.f46879n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(bArrE, 17);
            this.f46879n = flacStreamMetadata2;
            setupData.f46921a = flacStreamMetadata2.g(Arrays.copyOfRange(bArrE, 9, parsableByteArray.g()), null).b().U("audio/ogg").N();
            return true;
        }
        if ((bArrE[0] & Ascii.DEL) == 3) {
            FlacStreamMetadata.SeekTable seekTableF = FlacMetadataReader.f(parsableByteArray);
            FlacStreamMetadata flacStreamMetadataB = flacStreamMetadata.b(seekTableF);
            this.f46879n = flacStreamMetadataB;
            this.f46880o = new FlacOggSeeker(flacStreamMetadataB, seekTableF);
            return true;
        }
        if (!o(bArrE)) {
            return true;
        }
        FlacOggSeeker flacOggSeeker = this.f46880o;
        if (flacOggSeeker != null) {
            flacOggSeeker.d(j3);
            setupData.f46922b = this.f46880o;
        }
        Assertions.e(setupData.f46921a);
        return false;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    protected void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f46879n = null;
            this.f46880o = null;
        }
    }
}
