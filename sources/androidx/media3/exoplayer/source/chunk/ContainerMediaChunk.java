package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ContainerMediaChunk extends BaseMediaChunk {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f45131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ChunkExtractor f45132o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f45133p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f45134q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f45135r;

    private void k(BaseMediaChunkOutput baseMediaChunkOutput) {
        if (MimeTypes.o(this.f45095d.f40631n)) {
            Format format = this.f45095d;
            int i3 = format.L;
            if ((i3 <= 1 && format.M <= 1) || i3 == -1 || format.M == -1) {
                return;
            }
            TrackOutput trackOutputD = baseMediaChunkOutput.d(0, 4);
            Format format2 = this.f45095d;
            int i4 = format2.L * format2.M;
            long j3 = (this.f45099h - this.f45098g) / ((long) i4);
            for (int i5 = 1; i5 < i4; i5++) {
                trackOutputD.b(new ParsableByteArray(), 0);
                trackOutputD.g(((long) i5) * j3, 0, 0, 0, null);
            }
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        BaseMediaChunkOutput baseMediaChunkOutputH = h();
        if (this.f45133p == 0) {
            baseMediaChunkOutputH.b(this.f45131n);
            ChunkExtractor chunkExtractor = this.f45132o;
            ChunkExtractor.TrackOutputProvider trackOutputProviderJ = j(baseMediaChunkOutputH);
            long j3 = this.f45067j;
            long j4 = j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.f45131n;
            long j5 = this.f45068k;
            chunkExtractor.c(trackOutputProviderJ, j4, j5 != -9223372036854775807L ? j5 - this.f45131n : -9223372036854775807L);
        }
        try {
            DataSpec dataSpecE = this.f45093b.e(this.f45133p);
            StatsDataSource statsDataSource = this.f45100i;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, dataSpecE.f41835g, statsDataSource.b(dataSpecE));
            do {
                try {
                    if (this.f45134q) {
                        break;
                    }
                } finally {
                    this.f45133p = defaultExtractorInput.getPosition() - this.f45093b.f41835g;
                }
            } while (this.f45132o.a(defaultExtractorInput));
            k(baseMediaChunkOutputH);
            this.f45133p = defaultExtractorInput.getPosition() - this.f45093b.f41835g;
            l();
            DataSourceUtil.a(this.f45100i);
            this.f45135r = !this.f45134q;
        } catch (Throwable th) {
            l();
            DataSourceUtil.a(this.f45100i);
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void c() {
        this.f45134q = true;
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunk
    public boolean f() {
        return this.f45135r;
    }

    protected void l() {
    }

    protected ChunkExtractor.TrackOutputProvider j(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }
}
