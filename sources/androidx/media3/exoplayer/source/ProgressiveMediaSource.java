package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.SeekMap;
import com.google.common.base.Supplier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final DataSource.Factory f44843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ProgressiveMediaExtractor.Factory f44844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final DrmSessionManager f44845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f44846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f44847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f44848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Format f44849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Supplier f44850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f44851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f44852r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f44853s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f44854t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TransferListener f44855u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MediaItem f44856v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Listener f44857w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements MediaSourceFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DataSource.Factory f44859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ProgressiveMediaExtractor.Factory f44860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private DrmSessionManagerProvider f44861e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private LoadErrorHandlingPolicy f44862f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f44863g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Supplier f44864h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f44865i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Format f44866j;

        public Factory(DataSource.Factory factory, final ExtractorsFactory extractorsFactory) {
            this(factory, new ProgressiveMediaExtractor.Factory() { // from class: androidx.media3.exoplayer.source.f0
                @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor.Factory
                public final ProgressiveMediaExtractor a(PlayerId playerId) {
                    return ProgressiveMediaSource.Factory.i(extractorsFactory, playerId);
                }
            });
        }

        public static /* synthetic */ ProgressiveMediaExtractor i(ExtractorsFactory extractorsFactory, PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        public int[] e() {
            return new int[]{4};
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public ProgressiveMediaSource c(MediaItem mediaItem) {
            Assertions.e(mediaItem.f40714b);
            return new ProgressiveMediaSource(mediaItem, this.f44859c, this.f44860d, this.f44861e.a(mediaItem), this.f44862f, this.f44863g, this.f44865i, this.f44866j, this.f44864h);
        }

        Factory k(int i3, Format format) {
            this.f44865i = i3;
            this.f44866j = (Format) Assertions.e(format);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f44861e = (DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.MediaSource.Factory
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Factory f(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f44862f = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i3) {
            this.f44859c = factory;
            this.f44860d = factory2;
            this.f44861e = drmSessionManagerProvider;
            this.f44862f = loadErrorHandlingPolicy;
            this.f44863g = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(MediaSource mediaSource, SeekMap seekMap);
    }

    private MediaItem.LocalConfiguration n0() {
        return (MediaItem.LocalConfiguration) Assertions.e(m().f40714b);
    }

    private void o0() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.f44852r, this.f44853s, false, this.f44854t, null, m());
        if (this.f44851q) {
            singlePeriodTimeline = new ForwardingTimeline(singlePeriodTimeline) { // from class: androidx.media3.exoplayer.source.ProgressiveMediaSource.1
                @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
                public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
                    super.g(i3, period, z2);
                    period.f41119f = true;
                    return period;
                }

                @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
                public Timeline.Window o(int i3, Timeline.Window window, long j3) {
                    super.o(i3, window, j3);
                    window.f41145k = true;
                    return window;
                }
            };
        }
        j0(singlePeriodTimeline);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).f0();
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaPeriod.Listener
    public void F(long j3, SeekMap seekMap, boolean z2) {
        if (j3 == -9223372036854775807L) {
            j3 = this.f44852r;
        }
        boolean zE = seekMap.e();
        if (!this.f44851q && this.f44852r == j3 && this.f44853s == zE && this.f44854t == z2) {
            return;
        }
        this.f44852r = j3;
        this.f44853s = zE;
        this.f44854t = z2;
        this.f44851q = false;
        o0();
        Listener listener = this.f44857w;
        if (listener != null) {
            listener.a(this, seekMap);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized void H(MediaItem mediaItem) {
        this.f44856v = mediaItem;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        this.f44855u = transferListener;
        this.f44845k.a((Looper) Assertions.e(Looper.myLooper()), b0());
        this.f44845k.e();
        o0();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        DataSource dataSourceA = this.f44843i.a();
        TransferListener transferListener = this.f44855u;
        if (transferListener != null) {
            dataSourceA.c(transferListener);
        }
        MediaItem.LocalConfiguration localConfigurationN0 = n0();
        Uri uri = localConfigurationN0.f40810a;
        ProgressiveMediaExtractor progressiveMediaExtractorA = this.f44844j.a(b0());
        DrmSessionManager drmSessionManager = this.f44845k;
        DrmSessionEventListener.EventDispatcher eventDispatcherQ = Q(mediaPeriodId);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f44846l;
        MediaSourceEventListener.EventDispatcher eventDispatcherV = V(mediaPeriodId);
        String str = localConfigurationN0.f40815f;
        int i3 = this.f44847m;
        int i4 = this.f44848n;
        Format format = this.f44849o;
        long jP0 = Util.P0(localConfigurationN0.f40819j);
        Supplier supplier = this.f44850p;
        return new ProgressiveMediaPeriod(uri, dataSourceA, progressiveMediaExtractorA, drmSessionManager, eventDispatcherQ, loadErrorHandlingPolicy, eventDispatcherV, this, allocator, str, i3, i4, format, jP0, supplier != null ? (ReleasableExecutor) supplier.get() : null);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        this.f44845k.release();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public synchronized MediaItem m() {
        return this.f44856v;
    }

    private ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i3, int i4, Format format, Supplier supplier) {
        this.f44856v = mediaItem;
        this.f44843i = factory;
        this.f44844j = factory2;
        this.f44845k = drmSessionManager;
        this.f44846l = loadErrorHandlingPolicy;
        this.f44847m = i3;
        this.f44849o = format;
        this.f44848n = i4;
        this.f44851q = true;
        this.f44852r = -9223372036854775807L;
        this.f44850p = supplier;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void L() {
    }
}
