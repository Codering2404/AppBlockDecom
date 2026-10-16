package androidx.media3.extractor.wav;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WavSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WavFormat f47791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f47792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f47793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f47794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f47795e;

    public WavSeekMap(WavFormat wavFormat, int i3, long j3, long j4) {
        this.f47791a = wavFormat;
        this.f47792b = i3;
        this.f47793c = j3;
        long j5 = (j4 - j3) / ((long) wavFormat.f47786e);
        this.f47794d = j5;
        this.f47795e = a(j5);
    }

    private long a(long j3) {
        return Util.Z0(j3 * ((long) this.f47792b), 1000000L, this.f47791a.f47784c);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        long jS = Util.s((((long) this.f47791a.f47784c) * j3) / (((long) this.f47792b) * 1000000), 0L, this.f47794d - 1);
        long j4 = this.f47793c + (((long) this.f47791a.f47786e) * jS);
        long jA = a(jS);
        SeekPoint seekPoint = new SeekPoint(jA, j4);
        if (jA >= j3 || jS == this.f47794d - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j5 = jS + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(a(j5), this.f47793c + (((long) this.f47791a.f47786e) * j5)));
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f47795e;
    }
}
