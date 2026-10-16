package androidx.media3.extractor.flac;

import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacStreamMetadata;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FlacBinarySearchSeeker extends BinarySearchSeeker {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FlacStreamMetadata f46335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f46336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FlacFrameReader.SampleNumberHolder f46337c;

        private long c(ExtractorInput extractorInput) {
            while (extractorInput.h() < extractorInput.getLength() - 6 && !FlacFrameReader.h(extractorInput, this.f46335a, this.f46336b, this.f46337c)) {
                extractorInput.i(1);
            }
            if (extractorInput.h() < extractorInput.getLength() - 6) {
                return this.f46337c.f46151a;
            }
            extractorInput.i((int) (extractorInput.getLength() - extractorInput.h()));
            return this.f46335a.f46164j;
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult a(ExtractorInput extractorInput, long j3) {
            long position = extractorInput.getPosition();
            long jC = c(extractorInput);
            long jH = extractorInput.h();
            extractorInput.i(Math.max(6, this.f46335a.f46157c));
            long jC2 = c(extractorInput);
            return (jC > j3 || jC2 <= j3) ? jC2 <= j3 ? BinarySearchSeeker.TimestampSearchResult.f(jC2, extractorInput.h()) : BinarySearchSeeker.TimestampSearchResult.d(jC, position) : BinarySearchSeeker.TimestampSearchResult.e(jH);
        }

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata, int i3) {
            this.f46335a = flacStreamMetadata;
            this.f46336b = i3;
            this.f46337c = new FlacFrameReader.SampleNumberHolder();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlacBinarySearchSeeker(final FlacStreamMetadata flacStreamMetadata, int i3, long j3, long j4) {
        super(new BinarySearchSeeker.SeekTimestampConverter() { // from class: androidx.media3.extractor.flac.a
            @Override // androidx.media3.extractor.BinarySearchSeeker.SeekTimestampConverter
            public final long a(long j5) {
                return flacStreamMetadata.i(j5);
            }
        }, new FlacTimestampSeeker(flacStreamMetadata, i3), flacStreamMetadata.f(), 0L, flacStreamMetadata.f46164j, j3, j4, flacStreamMetadata.d(), Math.max(6, flacStreamMetadata.f46157c));
        Objects.requireNonNull(flacStreamMetadata);
    }
}
