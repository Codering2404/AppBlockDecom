package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface SeekMap {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SeekPoints {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SeekPoint f46211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SeekPoint f46212b;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SeekPoints.class == obj.getClass()) {
                SeekPoints seekPoints = (SeekPoints) obj;
                if (this.f46211a.equals(seekPoints.f46211a) && this.f46212b.equals(seekPoints.f46212b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f46211a.hashCode() * 31) + this.f46212b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f46211a);
            if (this.f46211a.equals(this.f46212b)) {
                str = "";
            } else {
                str = ", " + this.f46212b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.f46211a = (SeekPoint) Assertions.e(seekPoint);
            this.f46212b = (SeekPoint) Assertions.e(seekPoint2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Unseekable implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f46213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SeekPoints f46214b;

        public Unseekable(long j3) {
            this(j3, 0L);
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekPoints b(long j3) {
            return this.f46214b;
        }

        @Override // androidx.media3.extractor.SeekMap
        public boolean e() {
            return false;
        }

        @Override // androidx.media3.extractor.SeekMap
        public long l() {
            return this.f46213a;
        }

        public Unseekable(long j3, long j4) {
            this.f46213a = j3;
            this.f46214b = new SeekPoints(j4 == 0 ? SeekPoint.f46215c : new SeekPoint(0L, j4));
        }
    }

    SeekPoints b(long j3);

    boolean e();

    long l();
}
