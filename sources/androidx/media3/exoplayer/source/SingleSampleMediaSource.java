package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import com.google.common.base.MoreObjects;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class SingleSampleMediaSource extends BaseMediaSource {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final DataSpec f44960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final DataSource.Factory f44961j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Format f44962k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f44963l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f44964m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f44965n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Timeline f44966o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MediaItem f44967p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Supplier f44968q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TransferListener f44969r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DataSource.Factory f44970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LoadErrorHandlingPolicy f44971b = new DefaultLoadErrorHandlingPolicy();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f44972c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Object f44973d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f44974e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Supplier f44975f;

        public Factory(DataSource.Factory factory) {
            this.f44970a = (DataSource.Factory) Assertions.e(factory);
        }

        public SingleSampleMediaSource a(MediaItem.SubtitleConfiguration subtitleConfiguration, long j3) {
            return new SingleSampleMediaSource(this.f44974e, subtitleConfiguration, this.f44970a, j3, this.f44971b, this.f44972c, this.f44973d, this.f44975f);
        }

        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.f44971b = loadErrorHandlingPolicy;
            return this;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).w();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        this.f44969r = transferListener;
        j0(this.f44966o);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        DataSpec dataSpec = this.f44960i;
        DataSource.Factory factory = this.f44961j;
        TransferListener transferListener = this.f44969r;
        Format format = this.f44962k;
        long j4 = this.f44963l;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f44964m;
        MediaSourceEventListener.EventDispatcher eventDispatcherV = V(mediaPeriodId);
        boolean z2 = this.f44965n;
        Supplier supplier = this.f44968q;
        return new SingleSampleMediaPeriod(dataSpec, factory, transferListener, format, j4, loadErrorHandlingPolicy, eventDispatcherV, z2, supplier != null ? (ReleasableExecutor) supplier.get() : null);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem m() {
        return this.f44967p;
    }

    private SingleSampleMediaSource(String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z2, Object obj, Supplier supplier) {
        this.f44961j = factory;
        this.f44963l = j3;
        this.f44964m = loadErrorHandlingPolicy;
        this.f44965n = z2;
        MediaItem mediaItemA = new MediaItem.Builder().k(Uri.EMPTY).f(subtitleConfiguration.f40837a.toString()).i(ImmutableList.z(subtitleConfiguration)).j(obj).a();
        this.f44967p = mediaItemA;
        Format.Builder builderH0 = new Format.Builder().u0((String) MoreObjects.a(subtitleConfiguration.f40838b, "text/x-unknown")).j0(subtitleConfiguration.f40839c).w0(subtitleConfiguration.f40840d).s0(subtitleConfiguration.f40841e).h0(subtitleConfiguration.f40842f);
        String str2 = subtitleConfiguration.f40843g;
        this.f44962k = builderH0.f0(str2 != null ? str2 : str).N();
        this.f44960i = new DataSpec.Builder().i(subtitleConfiguration.f40837a).b(1).a();
        this.f44966o = new SinglePeriodTimeline(j3, true, false, false, null, mediaItemA);
        this.f44968q = supplier;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void L() {
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
    }
}
