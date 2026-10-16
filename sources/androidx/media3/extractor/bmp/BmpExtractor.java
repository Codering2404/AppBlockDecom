package androidx.media3.extractor.bmp;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BmpExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SingleSampleExtractor f46334a = new SingleSampleExtractor(16973, 2, "image/bmp");

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46334a.a(j3, j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return this.f46334a.g(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46334a.h(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f46334a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
