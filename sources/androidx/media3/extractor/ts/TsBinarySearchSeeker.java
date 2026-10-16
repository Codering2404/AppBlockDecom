package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TsBinarySearchSeeker extends BinarySearchSeeker {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TsPcrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimestampAdjuster f47693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ParsableByteArray f47694b = new ParsableByteArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f47695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f47696d;

        public TsPcrSeeker(int i3, TimestampAdjuster timestampAdjuster, int i4) {
            this.f47695c = i3;
            this.f47693a = timestampAdjuster;
            this.f47696d = i4;
        }

        private BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j3, long j4) {
            int iA;
            int iA2;
            int iG = parsableByteArray.g();
            long j5 = -1;
            long j6 = -1;
            long j7 = -9223372036854775807L;
            while (parsableByteArray.a() >= 188 && (iA2 = (iA = TsUtil.a(parsableByteArray.e(), parsableByteArray.f(), iG)) + 188) <= iG) {
                long jC = TsUtil.c(parsableByteArray, iA, this.f47695c);
                if (jC != -9223372036854775807L) {
                    long jB = this.f47693a.b(jC);
                    if (jB > j3) {
                        return j7 == -9223372036854775807L ? BinarySearchSeeker.TimestampSearchResult.d(jB, j4) : BinarySearchSeeker.TimestampSearchResult.e(j4 + j6);
                    }
                    if (100000 + jB > j3) {
                        return BinarySearchSeeker.TimestampSearchResult.e(j4 + ((long) iA));
                    }
                    j6 = iA;
                    j7 = jB;
                }
                parsableByteArray.W(iA2);
                j5 = iA2;
            }
            return j7 != -9223372036854775807L ? BinarySearchSeeker.TimestampSearchResult.f(j7, j4 + j5) : BinarySearchSeeker.TimestampSearchResult.f46083d;
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult a(ExtractorInput extractorInput, long j3) {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(this.f47696d, extractorInput.getLength() - position);
            this.f47694b.S(iMin);
            extractorInput.m(this.f47694b.e(), 0, iMin);
            return c(this.f47694b, j3, position);
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public void b() {
            this.f47694b.T(Util.f41614f);
        }
    }

    public TsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j3, long j4, int i3, int i4) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new TsPcrSeeker(i3, timestampAdjuster, i4), j3, 0L, j3 + 1, 0L, j4, 188L, 940);
    }
}
