package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ForwardingExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class StartOffsetExtractorInput extends ForwardingExtractorInput {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f46404b;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j3) {
        super(extractorInput);
        Assertions.a(extractorInput.getPosition() >= j3);
        this.f46404b = j3;
    }

    @Override // androidx.media3.extractor.ForwardingExtractorInput, androidx.media3.extractor.ExtractorInput
    public long getLength() {
        return super.getLength() - this.f46404b;
    }

    @Override // androidx.media3.extractor.ForwardingExtractorInput, androidx.media3.extractor.ExtractorInput
    public long getPosition() {
        return super.getPosition() - this.f46404b;
    }

    @Override // androidx.media3.extractor.ForwardingExtractorInput, androidx.media3.extractor.ExtractorInput
    public long h() {
        return super.h() - this.f46404b;
    }
}
