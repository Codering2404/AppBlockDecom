package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacSeekTableSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlacStreamMetadata f46153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f46154b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j3) {
        this.f46153a = flacStreamMetadata;
        this.f46154b = j3;
    }

    private SeekPoint a(long j3, long j4) {
        return new SeekPoint((j3 * 1000000) / ((long) this.f46153a.f46159e), this.f46154b + j4);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        Assertions.i(this.f46153a.f46165k);
        FlacStreamMetadata flacStreamMetadata = this.f46153a;
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata.f46165k;
        long[] jArr = seekTable.f46167a;
        long[] jArr2 = seekTable.f46168b;
        int iJ = Util.j(jArr, flacStreamMetadata.i(j3), true, false);
        SeekPoint seekPointA = a(iJ == -1 ? 0L : jArr[iJ], iJ != -1 ? jArr2[iJ] : 0L);
        if (seekPointA.f46216a == j3 || iJ == jArr.length - 1) {
            return new SeekMap.SeekPoints(seekPointA);
        }
        int i3 = iJ + 1;
        return new SeekMap.SeekPoints(seekPointA, a(jArr[i3], jArr2[i3]));
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46153a.f();
    }
}
