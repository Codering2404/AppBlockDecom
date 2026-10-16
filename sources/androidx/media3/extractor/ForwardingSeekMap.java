package androidx.media3.extractor;

import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingSeekMap implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeekMap f46172a;

    public ForwardingSeekMap(SeekMap seekMap) {
        this.f46172a = seekMap;
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        return this.f46172a.b(j3);
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return this.f46172a.e();
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f46172a.l();
    }
}
