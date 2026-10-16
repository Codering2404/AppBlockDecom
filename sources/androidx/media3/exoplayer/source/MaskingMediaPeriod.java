package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f44719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f44720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Allocator f44721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaSource f44722d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MediaPeriod f44723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MediaPeriod.Callback f44724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PrepareListener f44725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f44726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f44727j = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PrepareListener {
        void a(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);

        void b(MediaSource.MediaPeriodId mediaPeriodId);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        this.f44719a = mediaPeriodId;
        this.f44721c = allocator;
        this.f44720b = j3;
    }

    private long p(long j3) {
        long j4 = this.f44727j;
        return j4 != -9223372036854775807L ? j4 : j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        MediaPeriod mediaPeriod = this.f44723f;
        return mediaPeriod != null && mediaPeriod.a();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        MediaPeriod mediaPeriod = this.f44723f;
        return mediaPeriod != null && mediaPeriod.b(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        return ((MediaPeriod) Util.k(this.f44723f)).c();
    }

    public void d(MediaSource.MediaPeriodId mediaPeriodId) {
        long jP = p(this.f44720b);
        MediaPeriod mediaPeriodJ = ((MediaSource) Assertions.e(this.f44722d)).j(mediaPeriodId, this.f44721c, jP);
        this.f44723f = mediaPeriodJ;
        if (this.f44724g != null) {
            mediaPeriodJ.r(this, jP);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        return ((MediaPeriod) Util.k(this.f44723f)).e();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        ((MediaPeriod) Util.k(this.f44723f)).f(j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void g(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.k(this.f44724g)).g(this);
        PrepareListener prepareListener = this.f44725h;
        if (prepareListener != null) {
            prepareListener.b(this.f44719a);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.k(this.f44723f)).i(j3, seekParameters);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        return ((MediaPeriod) Util.k(this.f44723f)).j(j3);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        long j4 = this.f44727j;
        long j5 = (j4 == -9223372036854775807L || j3 != this.f44720b) ? j3 : j4;
        this.f44727j = -9223372036854775807L;
        return ((MediaPeriod) Util.k(this.f44723f)).k(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j5);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        return ((MediaPeriod) Util.k(this.f44723f)).l();
    }

    public long m() {
        return this.f44727j;
    }

    public long n() {
        return this.f44720b;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.f44723f;
            if (mediaPeriod != null) {
                mediaPeriod.o();
                return;
            }
            MediaSource mediaSource = this.f44722d;
            if (mediaSource != null) {
                mediaSource.L();
            }
        } catch (IOException e3) {
            PrepareListener prepareListener = this.f44725h;
            if (prepareListener == null) {
                throw e3;
            }
            if (this.f44726i) {
                return;
            }
            this.f44726i = true;
            prepareListener.a(this.f44719a, e3);
        }
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.k(this.f44724g)).h(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        this.f44724g = callback;
        MediaPeriod mediaPeriod = this.f44723f;
        if (mediaPeriod != null) {
            mediaPeriod.r(this, p(this.f44720b));
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return ((MediaPeriod) Util.k(this.f44723f)).s();
    }

    public void t(long j3) {
        this.f44727j = j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
        ((MediaPeriod) Util.k(this.f44723f)).u(j3, z2);
    }

    public void v() {
        if (this.f44723f != null) {
            ((MediaSource) Assertions.e(this.f44722d)).B(this.f44723f);
        }
    }

    public void w(MediaSource mediaSource) {
        Assertions.g(this.f44722d == null);
        this.f44722d = mediaSource;
    }

    public void x(PrepareListener prepareListener) {
        this.f44725h = prepareListener;
    }
}
