package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PsBinarySearchSeeker extends BinarySearchSeeker {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PsScrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimestampAdjuster f47653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ParsableByteArray f47654b;

        private BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j3, long j4) {
            int iF = -1;
            int iF2 = -1;
            long j5 = -9223372036854775807L;
            while (parsableByteArray.a() >= 4) {
                if (PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f()) != 442) {
                    parsableByteArray.X(1);
                } else {
                    parsableByteArray.X(4);
                    long jL = PsDurationReader.l(parsableByteArray);
                    if (jL != -9223372036854775807L) {
                        long jB = this.f47653a.b(jL);
                        if (jB > j3) {
                            return j5 == -9223372036854775807L ? BinarySearchSeeker.TimestampSearchResult.d(jB, j4) : BinarySearchSeeker.TimestampSearchResult.e(j4 + ((long) iF2));
                        }
                        if (100000 + jB > j3) {
                            return BinarySearchSeeker.TimestampSearchResult.e(j4 + ((long) parsableByteArray.f()));
                        }
                        iF2 = parsableByteArray.f();
                        j5 = jB;
                    }
                    d(parsableByteArray);
                    iF = parsableByteArray.f();
                }
            }
            return j5 != -9223372036854775807L ? BinarySearchSeeker.TimestampSearchResult.f(j5, j4 + ((long) iF)) : BinarySearchSeeker.TimestampSearchResult.f46083d;
        }

        private static void d(ParsableByteArray parsableByteArray) {
            int iK;
            int iG = parsableByteArray.g();
            if (parsableByteArray.a() < 10) {
                parsableByteArray.W(iG);
                return;
            }
            parsableByteArray.X(9);
            int iH = parsableByteArray.H() & 7;
            if (parsableByteArray.a() < iH) {
                parsableByteArray.W(iG);
                return;
            }
            parsableByteArray.X(iH);
            if (parsableByteArray.a() < 4) {
                parsableByteArray.W(iG);
                return;
            }
            if (PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f()) == 443) {
                parsableByteArray.X(4);
                int iP = parsableByteArray.P();
                if (parsableByteArray.a() < iP) {
                    parsableByteArray.W(iG);
                    return;
                }
                parsableByteArray.X(iP);
            }
            while (parsableByteArray.a() >= 4 && (iK = PsBinarySearchSeeker.k(parsableByteArray.e(), parsableByteArray.f())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                parsableByteArray.X(4);
                if (parsableByteArray.a() < 2) {
                    parsableByteArray.W(iG);
                    return;
                }
                parsableByteArray.W(Math.min(parsableByteArray.g(), parsableByteArray.f() + parsableByteArray.P()));
            }
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public BinarySearchSeeker.TimestampSearchResult a(ExtractorInput extractorInput, long j3) {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(20000L, extractorInput.getLength() - position);
            this.f47654b.S(iMin);
            extractorInput.m(this.f47654b.e(), 0, iMin);
            return c(this.f47654b, j3, position);
        }

        @Override // androidx.media3.extractor.BinarySearchSeeker.TimestampSeeker
        public void b() {
            this.f47654b.T(Util.f41614f);
        }

        private PsScrSeeker(TimestampAdjuster timestampAdjuster) {
            this.f47653a = timestampAdjuster;
            this.f47654b = new ParsableByteArray();
        }
    }

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j3, long j4) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster), j3, 0L, j3 + 1, 0L, j4, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }
}
