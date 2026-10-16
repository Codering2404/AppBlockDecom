package androidx.media3.exoplayer.source.chunk;

import android.util.SparseArray;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Factory f45073k = new Factory();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final PositionHolder f45074l = new PositionHolder();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Extractor f45075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f45076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Format f45077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f45078d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f45079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f45080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SeekMap f45082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Format[] f45083j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BindingTrackOutput implements TrackOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f45085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Format f45086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final DiscardingTrackOutput f45087d = new DiscardingTrackOutput();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Format f45088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TrackOutput f45089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f45090g;

        public BindingTrackOutput(int i3, int i4, Format format) {
            this.f45084a = i3;
            this.f45085b = i4;
            this.f45086c = format;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public void a(ParsableByteArray parsableByteArray, int i3, int i4) {
            ((TrackOutput) Util.k(this.f45089f)).b(parsableByteArray, i3);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public void c(Format format) {
            Format format2 = this.f45086c;
            if (format2 != null) {
                format = format.i(format2);
            }
            this.f45088e = format;
            ((TrackOutput) Util.k(this.f45089f)).c(this.f45088e);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public int f(DataReader dataReader, int i3, boolean z2, int i4) {
            return ((TrackOutput) Util.k(this.f45089f)).d(dataReader, i3, z2);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public void g(long j3, int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
            long j4 = this.f45090g;
            if (j4 != -9223372036854775807L && j3 >= j4) {
                this.f45089f = this.f45087d;
            }
            ((TrackOutput) Util.k(this.f45089f)).g(j3, i3, i4, i5, cryptoData);
        }

        public void h(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j3) {
            if (trackOutputProvider == null) {
                this.f45089f = this.f45087d;
                return;
            }
            this.f45090g = j3;
            TrackOutput trackOutputD = trackOutputProvider.d(this.f45084a, this.f45085b);
            this.f45089f = trackOutputD;
            Format format = this.f45088e;
            if (format != null) {
                trackOutputD.c(format);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements ChunkExtractor.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SubtitleParser.Factory f45091a = new DefaultSubtitleParserFactory();
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public boolean a(ExtractorInput extractorInput) {
        int iJ = this.f45075a.j(extractorInput, f45074l);
        Assertions.g(iJ != 1);
        return iJ == 0;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public ChunkIndex b() {
        SeekMap seekMap = this.f45082i;
        if (seekMap instanceof ChunkIndex) {
            return (ChunkIndex) seekMap;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor
    public void c(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j3, long j4) {
        this.f45080g = trackOutputProvider;
        this.f45081h = j4;
        if (!this.f45079f) {
            this.f45075a.h(this);
            if (j3 != -9223372036854775807L) {
                this.f45075a.a(0L, j3);
            }
            this.f45079f = true;
            return;
        }
        Extractor extractor = this.f45075a;
        if (j3 == -9223372036854775807L) {
            j3 = 0;
        }
        extractor.a(0L, j3);
        for (int i3 = 0; i3 < this.f45078d.size(); i3++) {
            ((BindingTrackOutput) this.f45078d.valueAt(i3)).h(trackOutputProvider, j4);
        }
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public TrackOutput d(int i3, int i4) {
        BindingTrackOutput bindingTrackOutput = (BindingTrackOutput) this.f45078d.get(i3);
        if (bindingTrackOutput == null) {
            Assertions.g(this.f45083j == null);
            bindingTrackOutput = new BindingTrackOutput(i3, i4, i4 == this.f45076b ? this.f45077c : null);
            bindingTrackOutput.h(this.f45080g, this.f45081h);
            this.f45078d.put(i3, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void n(SeekMap seekMap) {
        this.f45082i = seekMap;
    }

    @Override // androidx.media3.extractor.ExtractorOutput
    public void q() {
        Format[] formatArr = new Format[this.f45078d.size()];
        for (int i3 = 0; i3 < this.f45078d.size(); i3++) {
            formatArr[i3] = (Format) Assertions.i(((BindingTrackOutput) this.f45078d.valueAt(i3)).f45088e);
        }
        this.f45083j = formatArr;
    }
}
