package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.SeekMap;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class IndexSeeker implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f46628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IndexSeekMap f46630c;

    public IndexSeeker(long j3, long j4, long j5) {
        this.f46630c = new IndexSeekMap(new long[]{j4}, new long[]{0}, j3);
        this.f46628a = j5;
        int i3 = -2147483647;
        if (j3 == -9223372036854775807L) {
            this.f46629b = -2147483647;
            return;
        }
        long jB1 = Util.b1(j4 - j5, 8L, j3, RoundingMode.HALF_UP);
        if (jB1 > 0 && jB1 <= 2147483647L) {
            i3 = (int) jB1;
        }
        this.f46629b = i3;
    }

    public boolean a(long j3) {
        return this.f46630c.c(j3, 100000L);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        return this.f46630c.b(j3);
    }

    public void c(long j3, long j4) {
        if (a(j3)) {
            return;
        }
        this.f46630c.a(j3, j4);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long d() {
        return this.f46628a;
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return this.f46630c.e();
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long f(long j3) {
        return this.f46630c.f(j3);
    }

    void g(long j3) {
        this.f46630c.g(j3);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public int k() {
        return this.f46629b;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46630c.l();
    }
}
