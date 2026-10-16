package androidx.media3.extractor.jpeg;

import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class StartOffsetExtractorOutput implements ExtractorOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f46405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtractorOutput f46406b;

    public StartOffsetExtractorOutput(long j3, ExtractorOutput extractorOutput) {
        this.f46405a = j3;
        this.f46406b = extractorOutput;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput d(int i3, int i4) {
        return this.f46406b.d(i3, i4);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void n(final SeekMap seekMap) {
        this.f46406b.n(new ForwardingSeekMap(seekMap) { // from class: androidx.media3.extractor.jpeg.StartOffsetExtractorOutput.1
            @Override // androidx.media3.extractor.ForwardingSeekMap, androidx.media3.extractor.SeekMap
            public SeekMap.SeekPoints b(long j3) {
                SeekMap.SeekPoints seekPointsB = seekMap.b(j3);
                SeekPoint seekPoint = seekPointsB.f46211a;
                SeekPoint seekPoint2 = new SeekPoint(seekPoint.f46216a, seekPoint.f46217b + StartOffsetExtractorOutput.this.f46405a);
                SeekPoint seekPoint3 = seekPointsB.f46212b;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.f46216a, seekPoint3.f46217b + StartOffsetExtractorOutput.this.f46405a));
            }
        });
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void q() {
        this.f46406b.q();
    }
}
