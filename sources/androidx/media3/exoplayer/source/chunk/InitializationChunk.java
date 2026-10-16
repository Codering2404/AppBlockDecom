package androidx.media3.exoplayer.source.chunk;

import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DefaultExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InitializationChunk extends Chunk {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ChunkExtractor f45138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ChunkExtractor.TrackOutputProvider f45139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ChunkIndex f45140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f45141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f45142n;

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public void a() {
        if (this.f45141m == 0) {
            this.f45138j.c(this.f45139k, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            DataSpec dataSpecE = this.f45093b.e(this.f45141m);
            StatsDataSource statsDataSource = this.f45100i;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(statsDataSource, dataSpecE.f41835g, statsDataSource.b(dataSpecE));
            while (!this.f45142n && this.f45138j.a(defaultExtractorInput)) {
                try {
                } finally {
                    this.f45141m = defaultExtractorInput.getPosition() - this.f45093b.f41835g;
                    this.f45140l = this.f45138j.b();
                }
            }
        } finally {
            DataSourceUtil.a(this.f45100i);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public void c() {
        this.f45142n = true;
    }

    public void f(ChunkExtractor.TrackOutputProvider trackOutputProvider) {
        this.f45139k = trackOutputProvider;
    }
}
