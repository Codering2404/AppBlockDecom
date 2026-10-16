package androidx.media3.extractor.webp;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebpExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47796a = new ParsableByteArray(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SingleSampleExtractor f47797b = new SingleSampleExtractor(-1, -1, "image/webp");

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f47797b.a(j3, j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        this.f47796a.S(4);
        extractorInput.m(this.f47796a.e(), 0, 4);
        if (this.f47796a.J() != 1380533830) {
            return false;
        }
        extractorInput.i(4);
        this.f47796a.S(4);
        extractorInput.m(this.f47796a.e(), 0, 4);
        return this.f47796a.J() == 1464156752;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f47797b.h(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f47797b.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
