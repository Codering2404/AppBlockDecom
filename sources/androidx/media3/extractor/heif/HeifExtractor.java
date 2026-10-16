package androidx.media3.extractor.heif;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HeifExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46385a = new ParsableByteArray(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SingleSampleExtractor f46386b = new SingleSampleExtractor(-1, -1, "image/heif");

    private boolean b(ExtractorInput extractorInput, int i3) {
        this.f46385a.S(4);
        extractorInput.m(this.f46385a.e(), 0, 4);
        return this.f46385a.J() == ((long) i3);
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46386b.a(j3, j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        extractorInput.i(4);
        return b(extractorInput, 1718909296) && b(extractorInput, 1751476579);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46386b.h(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f46386b.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
