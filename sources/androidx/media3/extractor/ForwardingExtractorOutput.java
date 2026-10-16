package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingExtractorOutput implements ExtractorOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExtractorOutput f46171a;

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput d(int i3, int i4) {
        return this.f46171a.d(i3, i4);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void n(SeekMap seekMap) {
        this.f46171a.n(seekMap);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void q() {
        this.f46171a.q();
    }
}
