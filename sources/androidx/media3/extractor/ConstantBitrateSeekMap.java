package androidx.media3.extractor;

import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstantBitrateSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f46093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f46094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f46095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f46096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f46097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f46098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f46099g;

    public ConstantBitrateSeekMap(long j3, long j4, int i3, int i4, boolean z2) {
        this.f46093a = j3;
        this.f46094b = j4;
        this.f46095c = i4 == -1 ? 1 : i4;
        this.f46097e = i3;
        this.f46099g = z2;
        if (j3 == -1) {
            this.f46096d = -1L;
            this.f46098f = -9223372036854775807L;
        } else {
            this.f46096d = j3 - j4;
            this.f46098f = g(j3, j4, i3);
        }
    }

    private long a(long j3) {
        long j4 = (j3 * ((long) this.f46097e)) / 8000000;
        int i3 = this.f46095c;
        long jMin = (j4 / ((long) i3)) * ((long) i3);
        long j5 = this.f46096d;
        if (j5 != -1) {
            jMin = Math.min(jMin, j5 - ((long) i3));
        }
        return this.f46094b + Math.max(jMin, 0L);
    }

    private static long g(long j3, long j4, int i3) {
        return (Math.max(0L, j3 - j4) * 8000000) / ((long) i3);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        if (this.f46096d == -1 && !this.f46099g) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.f46094b));
        }
        long jA = a(j3);
        long jC = c(jA);
        SeekPoint seekPoint = new SeekPoint(jC, jA);
        if (this.f46096d != -1 && jC < j3) {
            int i3 = this.f46095c;
            if (((long) i3) + jA < this.f46093a) {
                long j4 = jA + ((long) i3);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(c(j4), j4));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long c(long j3) {
        return g(j3, this.f46094b, this.f46097e);
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return this.f46096d != -1 || this.f46099g;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46098f;
    }
}
