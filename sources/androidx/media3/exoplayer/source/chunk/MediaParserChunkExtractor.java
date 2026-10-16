package androidx.media3.exoplayer.source.chunk;

import android.media.MediaParser;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.m;
import androidx.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaParserChunkExtractor implements ChunkExtractor {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ChunkExtractor.Factory f45143j = new Factory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputConsumerAdapterV30 f45144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputReaderAdapterV30 f45145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaParser f45146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TrackOutputProviderAdapter f45147d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DiscardingTrackOutput f45148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f45149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f45150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Format[] f45151i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory implements ChunkExtractor.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SubtitleParser.Factory f45152a = new DefaultSubtitleParserFactory();
    }

    private void h() {
        MediaParser.SeekMap seekMapD = this.f45144a.d();
        long j3 = this.f45149g;
        if (j3 == -9223372036854775807L || seekMapD == null) {
            return;
        }
        this.f45146c.seek(m.a(seekMapD.getSeekPoints(j3).first));
        this.f45149g = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public boolean a(ExtractorInput extractorInput) {
        h();
        this.f45145b.c(extractorInput, extractorInput.getLength());
        return this.f45146c.advance(this.f45145b);
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public ChunkIndex b() {
        return this.f45144a.c();
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public void c(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j3, long j4) {
        this.f45150h = trackOutputProvider;
        this.f45144a.n(j4);
        this.f45144a.m(this.f45147d);
        this.f45149g = j3;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TrackOutputProviderAdapter implements ExtractorOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaParserChunkExtractor f45153a;

        @Override // androidx.media3.extractor.ExtractorOutput
        public TrackOutput d(int i3, int i4) {
            return this.f45153a.f45150h != null ? this.f45153a.f45150h.d(i3, i4) : this.f45153a.f45148f;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void q() {
            MediaParserChunkExtractor mediaParserChunkExtractor = this.f45153a;
            mediaParserChunkExtractor.f45151i = mediaParserChunkExtractor.f45144a.h();
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void n(SeekMap seekMap) {
        }
    }
}
