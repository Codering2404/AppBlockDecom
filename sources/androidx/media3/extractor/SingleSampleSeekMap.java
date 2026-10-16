package androidx.media3.extractor;

import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SingleSampleSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f46225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f46226b;

    public SingleSampleSeekMap(long j3) {
        this(j3, 0L);
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        return new SeekMap.SeekPoints(new SeekPoint(j3, this.f46226b));
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46225a;
    }

    public SingleSampleSeekMap(long j3, long j4) {
        this.f46225a = j3;
        this.f46226b = j4;
    }
}
