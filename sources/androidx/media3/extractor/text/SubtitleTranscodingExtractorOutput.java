package androidx.media3.extractor.text;

import android.util.SparseArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SubtitleTranscodingExtractorOutput implements ExtractorOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExtractorOutput f46966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SubtitleParser.Factory f46967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f46968c = new SparseArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f46969d;

    public SubtitleTranscodingExtractorOutput(ExtractorOutput extractorOutput, SubtitleParser.Factory factory) {
        this.f46966a = extractorOutput;
        this.f46967b = factory;
    }

    public void a() {
        for (int i3 = 0; i3 < this.f46968c.size(); i3++) {
            ((SubtitleTranscodingTrackOutput) this.f46968c.valueAt(i3)).k();
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput d(int i3, int i4) {
        if (i4 != 3) {
            this.f46969d = true;
            return this.f46966a.d(i3, i4);
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = (SubtitleTranscodingTrackOutput) this.f46968c.get(i3);
        if (subtitleTranscodingTrackOutput != null) {
            return subtitleTranscodingTrackOutput;
        }
        SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput2 = new SubtitleTranscodingTrackOutput(this.f46966a.d(i3, i4), this.f46967b);
        this.f46968c.put(i3, subtitleTranscodingTrackOutput2);
        return subtitleTranscodingTrackOutput2;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void n(SeekMap seekMap) {
        this.f46966a.n(seekMap);
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void q() {
        this.f46966a.q();
        if (this.f46969d) {
            for (int i3 = 0; i3 < this.f46968c.size(); i3++) {
                ((SubtitleTranscodingTrackOutput) this.f46968c.valueAt(i3)).l(true);
            }
        }
    }
}
