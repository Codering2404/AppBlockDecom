package androidx.media3.extractor.text;

import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SubtitleTranscodingExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Extractor f46963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SubtitleParser.Factory f46964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SubtitleTranscodingExtractorOutput f46965c;

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = this.f46965c;
        if (subtitleTranscodingExtractorOutput != null) {
            subtitleTranscodingExtractorOutput.a();
        }
        this.f46963a.a(j3, j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public Extractor c() {
        return this.f46963a;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return this.f46963a.g(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        SubtitleTranscodingExtractorOutput subtitleTranscodingExtractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f46964b);
        this.f46965c = subtitleTranscodingExtractorOutput;
        this.f46963a.h(subtitleTranscodingExtractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f46963a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
        this.f46963a.release();
    }
}
