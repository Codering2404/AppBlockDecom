package androidx.media3.extractor;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Extractor f46169a;

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46169a.a(j3, j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public Extractor c() {
        return this.f46169a.c();
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return this.f46169a.g(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46169a.h(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public List i() {
        return this.f46169a.i();
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f46169a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
        this.f46169a.release();
    }
}
