package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BinarySearchSeeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final BinarySearchSeekMap f46064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final TimestampSeeker f46065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected SeekOperationParams f46066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f46067d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BinarySearchSeekMap implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SeekTimestampConverter f46068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f46070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f46071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f46072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f46073f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f46074g;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f46068a = seekTimestampConverter;
            this.f46069b = j3;
            this.f46070c = j4;
            this.f46071d = j5;
            this.f46072e = j6;
            this.f46073f = j7;
            this.f46074g = j8;
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekMap.SeekPoints b(long j3) {
            return new SeekMap.SeekPoints(new SeekPoint(j3, SeekOperationParams.h(this.f46068a.a(j3), this.f46070c, this.f46071d, this.f46072e, this.f46073f, this.f46074g)));
        }

        @Override // androidx.media3.extractor.SeekMap
        public boolean e() {
            return true;
        }

        public long j(long j3) {
            return this.f46068a.a(j3);
        }

        @Override // androidx.media3.extractor.SeekMap
        public long l() {
            return this.f46069b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class SeekOperationParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f46075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f46077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f46078d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f46079e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f46080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f46081g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f46082h;

        protected SeekOperationParams(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
            this.f46075a = j3;
            this.f46076b = j4;
            this.f46078d = j5;
            this.f46079e = j6;
            this.f46080f = j7;
            this.f46081g = j8;
            this.f46077c = j9;
            this.f46082h = h(j4, j5, j6, j7, j8, j9);
        }

        protected static long h(long j3, long j4, long j5, long j6, long j7, long j8) {
            if (j6 + 1 >= j7 || j4 + 1 >= j5) {
                return j6;
            }
            long j9 = (long) ((j3 - j4) * ((j7 - j6) / (j5 - j4)));
            return Util.s(((j9 + j6) - j8) - (j9 / 20), j6, j7 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.f46081g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f46080f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.f46082h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.f46075a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.f46076b;
        }

        private void n() {
            this.f46082h = h(this.f46076b, this.f46078d, this.f46079e, this.f46080f, this.f46081g, this.f46077c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j3, long j4) {
            this.f46079e = j3;
            this.f46081g = j4;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j3, long j4) {
            this.f46078d = j3;
            this.f46080f = j4;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SeekTimestampConverter {
        long a(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class TimestampSearchResult {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final TimestampSearchResult f46083d = new TimestampSearchResult(-3, -9223372036854775807L, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f46084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f46086c;

        private TimestampSearchResult(int i3, long j3, long j4) {
            this.f46084a = i3;
            this.f46085b = j3;
            this.f46086c = j4;
        }

        public static TimestampSearchResult d(long j3, long j4) {
            return new TimestampSearchResult(-1, j3, j4);
        }

        public static TimestampSearchResult e(long j3) {
            return new TimestampSearchResult(0, -9223372036854775807L, j3);
        }

        public static TimestampSearchResult f(long j3, long j4) {
            return new TimestampSearchResult(-2, j3, j4);
        }
    }

    protected BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long j3, long j4, long j5, long j6, long j7, long j8, int i3) {
        this.f46065b = timestampSeeker;
        this.f46067d = i3;
        this.f46064a = new BinarySearchSeekMap(seekTimestampConverter, j3, j4, j5, j6, j7, j8);
    }

    protected SeekOperationParams a(long j3) {
        return new SeekOperationParams(j3, this.f46064a.j(j3), this.f46064a.f46070c, this.f46064a.f46071d, this.f46064a.f46072e, this.f46064a.f46073f, this.f46064a.f46074g);
    }

    public final SeekMap b() {
        return this.f46064a;
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            SeekOperationParams seekOperationParams = (SeekOperationParams) Assertions.i(this.f46066c);
            long j3 = seekOperationParams.j();
            long jI = seekOperationParams.i();
            long jK = seekOperationParams.k();
            if (jI - j3 <= this.f46067d) {
                e(false, j3);
                return g(extractorInput, j3, positionHolder);
            }
            if (!i(extractorInput, jK)) {
                return g(extractorInput, jK, positionHolder);
            }
            extractorInput.f();
            TimestampSearchResult timestampSearchResultA = this.f46065b.a(extractorInput, seekOperationParams.m());
            int i3 = timestampSearchResultA.f46084a;
            if (i3 == -3) {
                e(false, jK);
                return g(extractorInput, jK, positionHolder);
            }
            if (i3 == -2) {
                seekOperationParams.p(timestampSearchResultA.f46085b, timestampSearchResultA.f46086c);
            } else {
                if (i3 != -1) {
                    if (i3 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(extractorInput, timestampSearchResultA.f46086c);
                    e(true, timestampSearchResultA.f46086c);
                    return g(extractorInput, timestampSearchResultA.f46086c, positionHolder);
                }
                seekOperationParams.o(timestampSearchResultA.f46085b, timestampSearchResultA.f46086c);
            }
        }
    }

    public final boolean d() {
        return this.f46066c != null;
    }

    protected final void e(boolean z2, long j3) {
        this.f46066c = null;
        this.f46065b.b();
        f(z2, j3);
    }

    protected final int g(ExtractorInput extractorInput, long j3, PositionHolder positionHolder) {
        if (j3 == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.f46210a = j3;
        return 1;
    }

    public final void h(long j3) {
        SeekOperationParams seekOperationParams = this.f46066c;
        if (seekOperationParams == null || seekOperationParams.l() != j3) {
            this.f46066c = a(j3);
        }
    }

    protected final boolean i(ExtractorInput extractorInput, long j3) {
        long position = j3 - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.k((int) position);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TimestampSeeker {
        TimestampSearchResult a(ExtractorInput extractorInput, long j3);

        default void b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        @Override // androidx.media3.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long a(long j3) {
            return j3;
        }
    }

    protected void f(boolean z2, long j3) {
    }
}
