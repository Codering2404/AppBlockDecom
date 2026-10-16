package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.TrackOutput;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class SingleSampleMediaChunk extends BaseMediaChunk {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f45154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Format f45155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f45156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f45157q;

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public void a() {
        BaseMediaChunkOutput baseMediaChunkOutputH = h();
        baseMediaChunkOutputH.b(0L);
        TrackOutput trackOutputD = baseMediaChunkOutputH.d(0, this.f45154n);
        trackOutputD.c(this.f45155o);
        try {
            long jB = this.f45100i.b(this.f45093b.e(this.f45156p));
            if (jB != -1) {
                jB += this.f45156p;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.f45100i, this.f45156p, jB);
            for (int iD = 0; iD != -1; iD = trackOutputD.d(defaultExtractorInput, Api.BaseClientBuilder.API_PRIORITY_OTHER, true)) {
                this.f45156p += (long) iD;
            }
            trackOutputD.g(this.f45098g, 1, (int) this.f45156p, 0, null);
            DataSourceUtil.a(this.f45100i);
            this.f45157q = true;
        } catch (Throwable th) {
            DataSourceUtil.a(this.f45100i);
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.source.chunk.MediaChunk
    public boolean f() {
        return this.f45157q;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public void c() {
    }
}
