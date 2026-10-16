package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final MediaSource.MediaPeriodId f44994y = new MediaSource.MediaPeriodId(new Object());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MaskingMediaSource f44995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final MediaItem.DrmConfiguration f44996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MediaSource.Factory f44997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AdsLoader f44998o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AdViewProvider f44999p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final DataSpec f45000q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f45001r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ComponentListener f45004u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Timeline f45005v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AdPlaybackState f45006w;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Handler f45002s = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Timeline.Period f45003t = new Timeline.Period();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private AdMediaSourceHolder[][] f45007x = new AdMediaSourceHolder[0][];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AdLoadException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45008a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i3, Exception exc) {
            super(exc);
            this.f45008a = i3;
        }

        public static AdLoadException a(Exception exc) {
            return new AdLoadException(0, exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AdMediaSourceHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaSource.MediaPeriodId f45009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f45010b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MediaItem f45011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MediaSource f45012d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Timeline f45013e;

        public AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId) {
            this.f45009a = mediaPeriodId;
        }

        public MediaPeriod a(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j3);
            this.f45010b.add(maskingMediaPeriod);
            MediaSource mediaSource = this.f45012d;
            if (mediaSource != null) {
                maskingMediaPeriod.w(mediaSource);
                maskingMediaPeriod.x(AdsMediaSource.this.new AdPrepareListener((MediaItem) Assertions.e(this.f45011c)));
            }
            Timeline timeline = this.f45013e;
            if (timeline != null) {
                maskingMediaPeriod.d(new MediaSource.MediaPeriodId(timeline.m(0), mediaPeriodId.f44757d));
            }
            return maskingMediaPeriod;
        }

        public long b() {
            Timeline timeline = this.f45013e;
            if (timeline == null) {
                return -9223372036854775807L;
            }
            return timeline.f(0, AdsMediaSource.this.f45003t).k();
        }

        public void c(Timeline timeline) {
            Assertions.a(timeline.i() == 1);
            if (this.f45013e == null) {
                Object objM = timeline.m(0);
                for (int i3 = 0; i3 < this.f45010b.size(); i3++) {
                    MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) this.f45010b.get(i3);
                    maskingMediaPeriod.d(new MediaSource.MediaPeriodId(objM, maskingMediaPeriod.f44719a.f44757d));
                }
            }
            this.f45013e = timeline;
        }

        public boolean d() {
            return this.f45012d != null;
        }

        public void e(MediaSource mediaSource, MediaItem mediaItem) {
            this.f45012d = mediaSource;
            this.f45011c = mediaItem;
            for (int i3 = 0; i3 < this.f45010b.size(); i3++) {
                MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) this.f45010b.get(i3);
                maskingMediaPeriod.w(mediaSource);
                maskingMediaPeriod.x(AdsMediaSource.this.new AdPrepareListener(mediaItem));
            }
            AdsMediaSource.this.w0(this.f45009a, mediaSource);
        }

        public boolean f() {
            return this.f45010b.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.x0(this.f45009a);
            }
        }

        public void h(MaskingMediaPeriod maskingMediaPeriod) {
            this.f45010b.remove(maskingMediaPeriod);
            maskingMediaPeriod.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaItem f45015a;

        public AdPrepareListener(MediaItem mediaItem) {
            this.f45015a = mediaItem;
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public void a(final MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource.this.V(mediaPeriodId).q(new LoadEventInfo(LoadEventInfo.a(), new DataSpec(((MediaItem.LocalConfiguration) Assertions.e(this.f45015a.f40714b)).f40810a), SystemClock.elapsedRealtime()), 6, AdLoadException.a(iOException), true);
            AdsMediaSource.this.f45002s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.d
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.AdPrepareListener adPrepareListener = this.f45057a;
                    MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
                    AdsMediaSource.this.f44998o.f(AdsMediaSource.this, mediaPeriodId2.f44755b, mediaPeriodId2.f44756c, iOException);
                }
            });
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public void b(final MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.f45002s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.e
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.AdPrepareListener adPrepareListener = this.f45060a;
                    MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
                    AdsMediaSource.this.f44998o.c(AdsMediaSource.this, mediaPeriodId2.f44755b, mediaPeriodId2.f44756c);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ComponentListener implements AdsLoader.EventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f45017a = Util.C();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f45018b;

        public ComponentListener() {
        }

        public void a() {
            this.f45018b = true;
            this.f45017a.removeCallbacksAndMessages(null);
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider, boolean z2) {
        this.f44995l = new MaskingMediaSource(mediaSource, z2);
        this.f44996m = ((MediaItem.LocalConfiguration) Assertions.e(mediaSource.m().f40714b)).f40812c;
        this.f44997n = factory;
        this.f44998o = adsLoader;
        this.f44999p = adViewProvider;
        this.f45000q = dataSpec;
        this.f45001r = obj;
        adsLoader.e(factory.e());
    }

    private long[][] H0() {
        boolean zA = ((AdPlaybackState) Assertions.e(this.f45006w)).a();
        int length = this.f45007x.length + (zA ? 1 : 0);
        long[][] jArr = new long[length][];
        int i3 = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.f45007x;
            if (i3 >= adMediaSourceHolderArr.length) {
                break;
            }
            jArr[i3] = new long[adMediaSourceHolderArr[i3].length];
            int i4 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.f45007x[i3];
                if (i4 < adMediaSourceHolderArr2.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i4];
                    jArr[i3][i4] = adMediaSourceHolder == null ? -9223372036854775807L : adMediaSourceHolder.b();
                    i4++;
                }
            }
            i3++;
        }
        if (zA) {
            jArr[length - 1] = new long[0];
        }
        return jArr;
    }

    private void J0() {
        MediaItem mediaItemA;
        AdPlaybackState adPlaybackState = this.f45006w;
        if (adPlaybackState == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f45007x.length; i3++) {
            int i4 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr = this.f45007x[i3];
                if (i4 < adMediaSourceHolderArr.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i4];
                    AdPlaybackState.AdGroup adGroupB = adPlaybackState.b(i3);
                    if (adMediaSourceHolder != null && !adMediaSourceHolder.d()) {
                        MediaItem[] mediaItemArr = adGroupB.f40511e;
                        if (i4 < mediaItemArr.length && (mediaItemA = mediaItemArr[i4]) != null) {
                            if (this.f44996m != null) {
                                mediaItemA = mediaItemA.a().d(this.f44996m).a();
                            }
                            adMediaSourceHolder.e(this.f44997n.c(mediaItemA), mediaItemA);
                        }
                    }
                    i4++;
                }
            }
        }
    }

    private void K0() {
        Timeline timeline = this.f45005v;
        AdPlaybackState adPlaybackState = this.f45006w;
        if (adPlaybackState == null || timeline == null) {
            return;
        }
        if (adPlaybackState.f40491b == 0) {
            j0(timeline);
        } else {
            this.f45006w = adPlaybackState.g(H0());
            j0(new SinglePeriodAdTimeline(timeline, this.f45006w));
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.f44719a;
        if (!mediaPeriodId.c()) {
            maskingMediaPeriod.v();
            return;
        }
        AdMediaSourceHolder adMediaSourceHolder = (AdMediaSourceHolder) Assertions.e(this.f45007x[mediaPeriodId.f44755b][mediaPeriodId.f44756c]);
        adMediaSourceHolder.h(maskingMediaPeriod);
        if (adMediaSourceHolder.f()) {
            adMediaSourceHolder.g();
            this.f45007x[mediaPeriodId.f44755b][mediaPeriodId.f44756c] = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void H(MediaItem mediaItem) {
        this.f44995l.H(mediaItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId q0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.c() ? mediaPeriodId : mediaPeriodId2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void v0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, final Timeline timeline) {
        if (mediaPeriodId.c()) {
            ((AdMediaSourceHolder) Assertions.e(this.f45007x[mediaPeriodId.f44755b][mediaPeriodId.f44756c])).c(timeline);
        } else {
            Assertions.a(timeline.i() == 1);
            this.f45005v = timeline;
            this.f45002s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.c
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource adsMediaSource = this.f45055a;
                    adsMediaSource.f44998o.d(adsMediaSource, timeline);
                }
            });
        }
        K0();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        super.f0(transferListener);
        final ComponentListener componentListener = new ComponentListener();
        this.f45004u = componentListener;
        this.f45005v = this.f44995l.L0();
        w0(f44994y, this.f44995l);
        this.f45002s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.a
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource adsMediaSource = this.f45051a;
                adsMediaSource.f44998o.a(adsMediaSource, adsMediaSource.f45000q, adsMediaSource.f45001r, adsMediaSource.f44999p, componentListener);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        if (((AdPlaybackState) Assertions.e(this.f45006w)).f40491b <= 0 || !mediaPeriodId.c()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j3);
            maskingMediaPeriod.w(this.f44995l);
            maskingMediaPeriod.d(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i3 = mediaPeriodId.f44755b;
        int i4 = mediaPeriodId.f44756c;
        AdMediaSourceHolder[][] adMediaSourceHolderArr = this.f45007x;
        AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i3];
        if (adMediaSourceHolderArr2.length <= i4) {
            adMediaSourceHolderArr[i3] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i4 + 1);
        }
        AdMediaSourceHolder adMediaSourceHolder = this.f45007x[i3][i4];
        if (adMediaSourceHolder == null) {
            adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId);
            this.f45007x[i3][i4] = adMediaSourceHolder;
            J0();
        }
        return adMediaSourceHolder.a(mediaPeriodId, allocator, j3);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        super.l0();
        final ComponentListener componentListener = (ComponentListener) Assertions.e(this.f45004u);
        this.f45004u = null;
        componentListener.a();
        this.f45005v = null;
        this.f45006w = null;
        this.f45007x = new AdMediaSourceHolder[0][];
        this.f45002s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.b
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource adsMediaSource = this.f45053a;
                adsMediaSource.f44998o.b(adsMediaSource, componentListener);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem m() {
        return this.f44995l.m();
    }
}
