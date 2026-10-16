package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.ForwardingTimeline;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ServerSideAdInsertionMediaSource extends BaseMediaSource implements MediaSource.MediaSourceCaller, MediaSourceEventListener, DrmSessionEventListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaSource f45020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ListMultimap f45021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f45022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f45023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AdPlaybackStateUpdater f45024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Handler f45025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private SharedMediaPeriod f45026o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImmutableMap f45027p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AdPlaybackStateUpdater {
        boolean a(Timeline timeline);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaPeriodImpl implements MediaPeriod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SharedMediaPeriod f45028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSource.MediaPeriodId f45029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MediaSourceEventListener.EventDispatcher f45030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DrmSessionEventListener.EventDispatcher f45031d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public MediaPeriod.Callback f45032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f45033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean[] f45034h = new boolean[0];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f45035i;

        public MediaPeriodImpl(SharedMediaPeriod sharedMediaPeriod, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
            this.f45028a = sharedMediaPeriod;
            this.f45029b = mediaPeriodId;
            this.f45030c = eventDispatcher;
            this.f45031d = eventDispatcher2;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean a() {
            return this.f45028a.r(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public boolean b(LoadingInfo loadingInfo) {
            return this.f45028a.f(this, loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long c() {
            return this.f45028a.o(this);
        }

        public void d() {
            MediaPeriod.Callback callback = this.f45032f;
            if (callback != null) {
                callback.g(this);
            }
            this.f45035i = true;
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public long e() {
            return this.f45028a.l(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
        public void f(long j3) {
            this.f45028a.E(this, j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long i(long j3, SeekParameters seekParameters) {
            return this.f45028a.k(this, j3, seekParameters);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long j(long j3) {
            return this.f45028a.H(this, j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
            if (this.f45034h.length == 0) {
                this.f45034h = new boolean[sampleStreamArr.length];
            }
            return this.f45028a.I(this, exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public long l() {
            return this.f45028a.D(this);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void o() {
            this.f45028a.w();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void r(MediaPeriod.Callback callback, long j3) {
            this.f45032f = callback;
            this.f45028a.B(this, j3);
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public TrackGroupArray s() {
            return this.f45028a.q();
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod
        public void u(long j3, boolean z2) {
            this.f45028a.i(this, j3, z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SampleStreamImpl implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaPeriodImpl f45036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f45037b;

        public SampleStreamImpl(MediaPeriodImpl mediaPeriodImpl, int i3) {
            this.f45036a = mediaPeriodImpl;
            this.f45037b = i3;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() {
            this.f45036a.f45028a.v(this.f45037b);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            MediaPeriodImpl mediaPeriodImpl = this.f45036a;
            return mediaPeriodImpl.f45028a.J(mediaPeriodImpl, this.f45037b, j3);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return this.f45036a.f45028a.s(this.f45037b);
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            MediaPeriodImpl mediaPeriodImpl = this.f45036a;
            return mediaPeriodImpl.f45028a.C(mediaPeriodImpl, this.f45037b, formatHolder, decoderInputBuffer, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ServerSideAdInsertionTimeline extends ForwardingTimeline {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ImmutableMap f45038f;

        public ServerSideAdInsertionTimeline(Timeline timeline, ImmutableMap immutableMap) {
            super(timeline);
            Assertions.g(timeline.p() == 1);
            Timeline.Period period = new Timeline.Period();
            for (int i3 = 0; i3 < timeline.i(); i3++) {
                timeline.g(i3, period, true);
                Assertions.g(immutableMap.containsKey(Assertions.e(period.f41115b)));
            }
            this.f45038f = immutableMap;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Period g(int i3, Timeline.Period period, boolean z2) {
            super.g(i3, period, true);
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45038f.get(period.f41115b));
            long j3 = period.f41117d;
            long jD = j3 == -9223372036854775807L ? adPlaybackState.f40493d : ServerSideAdInsertionUtil.d(j3, -1, adPlaybackState);
            Timeline.Period period2 = new Timeline.Period();
            long jD2 = 0;
            for (int i4 = 0; i4 < i3 + 1; i4++) {
                this.f44698e.g(i4, period2, true);
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45038f.get(period2.f41115b));
                if (i4 == 0) {
                    jD2 = -ServerSideAdInsertionUtil.d(-period2.o(), -1, adPlaybackState2);
                }
                if (i4 != i3) {
                    jD2 += ServerSideAdInsertionUtil.d(period2.f41117d, -1, adPlaybackState2);
                }
            }
            period.u(period.f41114a, period.f41115b, period.f41116c, jD, jD2, adPlaybackState, period.f41119f);
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public Timeline.Window o(int i3, Timeline.Window window, long j3) {
            super.o(i3, window, j3);
            Timeline.Period period = new Timeline.Period();
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45038f.get(Assertions.e(g(window.f41148n, period, true).f41115b)));
            long jD = ServerSideAdInsertionUtil.d(window.f41150p, -1, adPlaybackState);
            if (window.f41147m == -9223372036854775807L) {
                long j4 = adPlaybackState.f40493d;
                if (j4 != -9223372036854775807L) {
                    window.f41147m = j4 - jD;
                }
            } else {
                Timeline.Period periodG = super.g(window.f41149o, period, true);
                long j5 = periodG.f41118e;
                AdPlaybackState adPlaybackState2 = (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45038f.get(periodG.f41115b));
                Timeline.Period periodF = f(window.f41149o, period);
                window.f41147m = periodF.f41118e + ServerSideAdInsertionUtil.d(window.f41147m - j5, -1, adPlaybackState2);
            }
            window.f41150p = jD;
            return window;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SharedMediaPeriod implements MediaPeriod.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaPeriod f45039a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f45042d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private AdPlaybackState f45043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private MediaPeriodImpl f45044g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f45045h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f45046i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f45040b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f45041c = new HashMap();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ExoTrackSelection[] f45047j = new ExoTrackSelection[0];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public SampleStream[] f45048k = new SampleStream[0];

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public MediaLoadData[] f45049l = new MediaLoadData[0];

        public SharedMediaPeriod(MediaPeriod mediaPeriod, Object obj, AdPlaybackState adPlaybackState) {
            this.f45039a = mediaPeriod;
            this.f45042d = obj;
            this.f45043f = adPlaybackState;
        }

        private int j(MediaLoadData mediaLoadData) {
            String str;
            if (mediaLoadData.f44742c == null) {
                return -1;
            }
            int i3 = 0;
            loop0: while (true) {
                ExoTrackSelection[] exoTrackSelectionArr = this.f45047j;
                if (i3 >= exoTrackSelectionArr.length) {
                    return -1;
                }
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
                if (exoTrackSelection != null) {
                    TrackGroup trackGroupH = exoTrackSelection.h();
                    boolean z2 = mediaLoadData.f44741b == 0 && trackGroupH.equals(q().b(0));
                    for (int i4 = 0; i4 < trackGroupH.f41153a; i4++) {
                        Format formatA = trackGroupH.a(i4);
                        if (formatA.equals(mediaLoadData.f44742c) || (z2 && (str = formatA.f40618a) != null && str.equals(mediaLoadData.f44742c.f40618a))) {
                            break loop0;
                        }
                    }
                }
                i3++;
            }
            return i3;
        }

        private long n(MediaPeriodImpl mediaPeriodImpl, long j3) {
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            long jB = ServerSideAdInsertionUtil.b(j3, mediaPeriodImpl.f45029b, this.f45043f);
            if (jB >= ServerSideAdInsertionMediaSource.r0(mediaPeriodImpl, this.f45043f)) {
                return Long.MIN_VALUE;
            }
            return jB;
        }

        private long p(MediaPeriodImpl mediaPeriodImpl, long j3) {
            long j4 = mediaPeriodImpl.f45033g;
            return j3 < j4 ? ServerSideAdInsertionUtil.e(j4, mediaPeriodImpl.f45029b, this.f45043f) - (mediaPeriodImpl.f45033g - j3) : ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f);
        }

        private void u(MediaPeriodImpl mediaPeriodImpl, int i3) {
            MediaLoadData mediaLoadData;
            boolean[] zArr = mediaPeriodImpl.f45034h;
            if (zArr[i3] || (mediaLoadData = this.f45049l[i3]) == null) {
                return;
            }
            zArr[i3] = true;
            mediaPeriodImpl.f45030c.k(ServerSideAdInsertionMediaSource.p0(mediaPeriodImpl, mediaLoadData, this.f45043f));
        }

        public void A(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            this.f45041c.put(Long.valueOf(loadEventInfo.f44705a), Pair.create(loadEventInfo, mediaLoadData));
        }

        public void B(MediaPeriodImpl mediaPeriodImpl, long j3) {
            mediaPeriodImpl.f45033g = j3;
            if (this.f45045h) {
                if (this.f45046i) {
                    mediaPeriodImpl.d();
                }
            } else {
                this.f45045h = true;
                this.f45039a.r(this, ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f));
            }
        }

        public int C(MediaPeriodImpl mediaPeriodImpl, int i3, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i4) {
            long jL = l(mediaPeriodImpl);
            int iN = ((SampleStream) Util.k(this.f45048k[i3])).n(formatHolder, decoderInputBuffer, i4 | 5);
            long jN = n(mediaPeriodImpl, decoderInputBuffer.f42140g);
            if ((iN == -4 && jN == Long.MIN_VALUE) || (iN == -3 && jL == Long.MIN_VALUE && !decoderInputBuffer.f42139f)) {
                u(mediaPeriodImpl, i3);
                decoderInputBuffer.f();
                decoderInputBuffer.e(4);
                return -4;
            }
            if (iN == -4) {
                u(mediaPeriodImpl, i3);
                ((SampleStream) Util.k(this.f45048k[i3])).n(formatHolder, decoderInputBuffer, i4);
                decoderInputBuffer.f42140g = jN;
            }
            return iN;
        }

        public long D(MediaPeriodImpl mediaPeriodImpl) {
            if (!mediaPeriodImpl.equals(this.f45040b.get(0))) {
                return -9223372036854775807L;
            }
            long jL = this.f45039a.l();
            if (jL == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return ServerSideAdInsertionUtil.b(jL, mediaPeriodImpl.f45029b, this.f45043f);
        }

        public void E(MediaPeriodImpl mediaPeriodImpl, long j3) {
            this.f45039a.f(p(mediaPeriodImpl, j3));
        }

        public void F(MediaSource mediaSource) {
            mediaSource.B(this.f45039a);
        }

        public void G(MediaPeriodImpl mediaPeriodImpl) {
            if (mediaPeriodImpl.equals(this.f45044g)) {
                this.f45044g = null;
                this.f45041c.clear();
            }
            this.f45040b.remove(mediaPeriodImpl);
        }

        public long H(MediaPeriodImpl mediaPeriodImpl, long j3) {
            return ServerSideAdInsertionUtil.b(this.f45039a.j(ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f)), mediaPeriodImpl.f45029b, this.f45043f);
        }

        public long I(MediaPeriodImpl mediaPeriodImpl, ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
            mediaPeriodImpl.f45033g = j3;
            if (!mediaPeriodImpl.equals(this.f45040b.get(0))) {
                for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
                    ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
                    boolean z2 = true;
                    if (exoTrackSelection != null) {
                        if (zArr[i3] && sampleStreamArr[i3] != null) {
                            z2 = false;
                        }
                        zArr2[i3] = z2;
                        if (z2) {
                            sampleStreamArr[i3] = Objects.equals(this.f45047j[i3], exoTrackSelection) ? new SampleStreamImpl(mediaPeriodImpl, i3) : new EmptySampleStream();
                        }
                    } else {
                        sampleStreamArr[i3] = null;
                        zArr2[i3] = true;
                    }
                }
                return j3;
            }
            this.f45047j = (ExoTrackSelection[]) Arrays.copyOf(exoTrackSelectionArr, exoTrackSelectionArr.length);
            long jE = ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f);
            SampleStream[] sampleStreamArr2 = this.f45048k;
            SampleStream[] sampleStreamArr3 = sampleStreamArr2.length == 0 ? new SampleStream[exoTrackSelectionArr.length] : (SampleStream[]) Arrays.copyOf(sampleStreamArr2, sampleStreamArr2.length);
            long jK = this.f45039a.k(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, jE);
            this.f45048k = (SampleStream[]) Arrays.copyOf(sampleStreamArr3, sampleStreamArr3.length);
            this.f45049l = (MediaLoadData[]) Arrays.copyOf(this.f45049l, sampleStreamArr3.length);
            for (int i4 = 0; i4 < sampleStreamArr3.length; i4++) {
                if (sampleStreamArr3[i4] == null) {
                    sampleStreamArr[i4] = null;
                    this.f45049l[i4] = null;
                } else if (sampleStreamArr[i4] == null || zArr2[i4]) {
                    sampleStreamArr[i4] = new SampleStreamImpl(mediaPeriodImpl, i4);
                    this.f45049l[i4] = null;
                }
            }
            return ServerSideAdInsertionUtil.b(jK, mediaPeriodImpl.f45029b, this.f45043f);
        }

        public int J(MediaPeriodImpl mediaPeriodImpl, int i3, long j3) {
            return ((SampleStream) Util.k(this.f45048k[i3])).h(ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f));
        }

        public void d(MediaPeriodImpl mediaPeriodImpl) {
            this.f45040b.add(mediaPeriodImpl);
        }

        public boolean e(MediaSource.MediaPeriodId mediaPeriodId, long j3) {
            MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) Iterables.j(this.f45040b);
            return ServerSideAdInsertionUtil.e(j3, mediaPeriodId, this.f45043f) == ServerSideAdInsertionUtil.e(ServerSideAdInsertionMediaSource.r0(mediaPeriodImpl, this.f45043f), mediaPeriodImpl.f45029b, this.f45043f);
        }

        public boolean f(MediaPeriodImpl mediaPeriodImpl, LoadingInfo loadingInfo) {
            MediaPeriodImpl mediaPeriodImpl2 = this.f45044g;
            if (mediaPeriodImpl2 != null && !mediaPeriodImpl.equals(mediaPeriodImpl2)) {
                for (Pair pair : this.f45041c.values()) {
                    mediaPeriodImpl2.f45030c.o((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.p0(mediaPeriodImpl2, (MediaLoadData) pair.second, this.f45043f));
                    mediaPeriodImpl.f45030c.t((LoadEventInfo) pair.first, ServerSideAdInsertionMediaSource.p0(mediaPeriodImpl, (MediaLoadData) pair.second, this.f45043f), 0);
                }
            }
            this.f45044g = mediaPeriodImpl;
            return this.f45039a.b(loadingInfo.a().f(p(mediaPeriodImpl, loadingInfo.f43121a)).d());
        }

        @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
        public void g(MediaPeriod mediaPeriod) {
            this.f45046i = true;
            for (int i3 = 0; i3 < this.f45040b.size(); i3++) {
                ((MediaPeriodImpl) this.f45040b.get(i3)).d();
            }
        }

        public void i(MediaPeriodImpl mediaPeriodImpl, long j3, boolean z2) {
            this.f45039a.u(ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f), z2);
        }

        public long k(MediaPeriodImpl mediaPeriodImpl, long j3, SeekParameters seekParameters) {
            return ServerSideAdInsertionUtil.b(this.f45039a.i(ServerSideAdInsertionUtil.e(j3, mediaPeriodImpl.f45029b, this.f45043f), seekParameters), mediaPeriodImpl.f45029b, this.f45043f);
        }

        public long l(MediaPeriodImpl mediaPeriodImpl) {
            return n(mediaPeriodImpl, this.f45039a.e());
        }

        public MediaPeriodImpl m(MediaLoadData mediaLoadData) {
            if (mediaLoadData == null || mediaLoadData.f44745f == -9223372036854775807L) {
                return null;
            }
            for (int i3 = 0; i3 < this.f45040b.size(); i3++) {
                MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) this.f45040b.get(i3);
                if (mediaPeriodImpl.f45035i) {
                    long jB = ServerSideAdInsertionUtil.b(Util.P0(mediaLoadData.f44745f), mediaPeriodImpl.f45029b, this.f45043f);
                    long jR0 = ServerSideAdInsertionMediaSource.r0(mediaPeriodImpl, this.f45043f);
                    if (jB >= 0 && jB < jR0) {
                        return mediaPeriodImpl;
                    }
                }
            }
            return null;
        }

        public long o(MediaPeriodImpl mediaPeriodImpl) {
            return n(mediaPeriodImpl, this.f45039a.c());
        }

        public TrackGroupArray q() {
            return this.f45039a.s();
        }

        public boolean r(MediaPeriodImpl mediaPeriodImpl) {
            return mediaPeriodImpl.equals(this.f45044g) && this.f45039a.a();
        }

        public boolean s(int i3) {
            return ((SampleStream) Util.k(this.f45048k[i3])).isReady();
        }

        public boolean t() {
            return this.f45040b.isEmpty();
        }

        public void v(int i3) {
            ((SampleStream) Util.k(this.f45048k[i3])).d();
        }

        public void w() {
            this.f45039a.o();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public void h(MediaPeriod mediaPeriod) {
            MediaPeriodImpl mediaPeriodImpl = this.f45044g;
            if (mediaPeriodImpl == null) {
                return;
            }
            ((MediaPeriod.Callback) Assertions.e(mediaPeriodImpl.f45032f)).h(this.f45044g);
        }

        public void y(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData) {
            int iJ = j(mediaLoadData);
            if (iJ != -1) {
                this.f45049l[iJ] = mediaLoadData;
                mediaPeriodImpl.f45034h[iJ] = true;
            }
        }

        public void z(LoadEventInfo loadEventInfo) {
            this.f45041c.remove(Long.valueOf(loadEventInfo.f44705a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaLoadData p0(MediaPeriodImpl mediaPeriodImpl, MediaLoadData mediaLoadData, AdPlaybackState adPlaybackState) {
        return new MediaLoadData(mediaLoadData.f44740a, mediaLoadData.f44741b, mediaLoadData.f44742c, mediaLoadData.f44743d, mediaLoadData.f44744e, q0(mediaLoadData.f44745f, mediaPeriodImpl, adPlaybackState), q0(mediaLoadData.f44746g, mediaPeriodImpl, adPlaybackState));
    }

    private static long q0(long j3, MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jP0 = Util.P0(j3);
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.f45029b;
        return Util.t1(mediaPeriodId.c() ? ServerSideAdInsertionUtil.c(jP0, mediaPeriodId.f44755b, mediaPeriodId.f44756c, adPlaybackState) : ServerSideAdInsertionUtil.d(jP0, -1, adPlaybackState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long r0(MediaPeriodImpl mediaPeriodImpl, AdPlaybackState adPlaybackState) {
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodImpl.f45029b;
        if (mediaPeriodId.c()) {
            AdPlaybackState.AdGroup adGroupB = adPlaybackState.b(mediaPeriodId.f44755b);
            if (adGroupB.f40508b == -1) {
                return 0L;
            }
            return adGroupB.f40513g[mediaPeriodId.f44756c];
        }
        int i3 = mediaPeriodId.f44758e;
        if (i3 == -1) {
            return Long.MAX_VALUE;
        }
        long j3 = adPlaybackState.b(i3).f40507a;
        if (j3 == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    private MediaPeriodImpl s0(MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData, boolean z2) {
        if (mediaPeriodId == null) {
            return null;
        }
        List list = this.f45021j.get((Object) new Pair(Long.valueOf(mediaPeriodId.f44757d), mediaPeriodId.f44754a));
        if (list.isEmpty()) {
            return null;
        }
        if (z2) {
            SharedMediaPeriod sharedMediaPeriod = (SharedMediaPeriod) Iterables.j(list);
            return sharedMediaPeriod.f45044g != null ? sharedMediaPeriod.f45044g : (MediaPeriodImpl) Iterables.j(sharedMediaPeriod.f45040b);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaPeriodImpl mediaPeriodImplM = ((SharedMediaPeriod) list.get(i3)).m(mediaLoadData);
            if (mediaPeriodImplM != null) {
                return mediaPeriodImplM;
            }
        }
        return (MediaPeriodImpl) ((SharedMediaPeriod) list.get(0)).f45040b.get(0);
    }

    private void v0() {
        SharedMediaPeriod sharedMediaPeriod = this.f45026o;
        if (sharedMediaPeriod != null) {
            sharedMediaPeriod.F(this.f45020i);
            this.f45026o = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void B(MediaPeriod mediaPeriod) {
        MediaPeriodImpl mediaPeriodImpl = (MediaPeriodImpl) mediaPeriod;
        mediaPeriodImpl.f45028a.G(mediaPeriodImpl);
        if (mediaPeriodImpl.f45028a.t()) {
            this.f45021j.remove(new Pair(Long.valueOf(mediaPeriodImpl.f45029b.f44757d), mediaPeriodImpl.f45029b.f44754a), mediaPeriodImpl.f45028a);
            if (this.f45021j.isEmpty()) {
                this.f45026o = mediaPeriodImpl.f45028a;
            } else {
                mediaPeriodImpl.f45028a.F(this.f45020i);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public void E(int i3, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodImplS0 == null) {
            this.f45022k.w(mediaLoadData);
        } else {
            mediaPeriodImplS0.f45030c.w(p0(mediaPeriodImplS0, mediaLoadData, (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodImplS0.f45029b.f44754a))));
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void H(MediaItem mediaItem) {
        this.f45020i.H(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void L() {
        this.f45020i.L();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void N(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, null, false);
        if (mediaPeriodImplS0 == null) {
            this.f45023l.h();
        } else {
            mediaPeriodImplS0.f45031d.h();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public void R(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i4) {
        if (i4 == 0) {
            MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, mediaLoadData, true);
            if (mediaPeriodImplS0 == null) {
                this.f45022k.t(loadEventInfo, mediaLoadData, 0);
            } else {
                mediaPeriodImplS0.f45028a.A(loadEventInfo, mediaLoadData);
                mediaPeriodImplS0.f45030c.t(loadEventInfo, p0(mediaPeriodImplS0, mediaLoadData, (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodImplS0.f45029b.f44754a))), 0);
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void S(int i3, MediaSource.MediaPeriodId mediaPeriodId, int i4) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, null, true);
        if (mediaPeriodImplS0 == null) {
            this.f45023l.k(i4);
        } else {
            mediaPeriodImplS0.f45031d.k(i4);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public void U(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplS0 == null) {
            this.f45022k.r(loadEventInfo, mediaLoadData, iOException, z2);
            return;
        }
        if (z2) {
            mediaPeriodImplS0.f45028a.z(loadEventInfo);
        }
        mediaPeriodImplS0.f45030c.r(loadEventInfo, p0(mediaPeriodImplS0, mediaLoadData, (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodImplS0.f45029b.f44754a))), iOException, z2);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void W() {
        v0();
        this.f45020i.K(this);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void X(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, null, false);
        if (mediaPeriodImplS0 == null) {
            this.f45023l.i();
        } else {
            mediaPeriodImplS0.f45031d.i();
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void Y(int i3, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, null, false);
        if (mediaPeriodImplS0 == null) {
            this.f45023l.l(exc);
        } else {
            mediaPeriodImplS0.f45031d.l(exc);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public void Z(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplS0 == null) {
            this.f45022k.m(loadEventInfo, mediaLoadData);
        } else {
            mediaPeriodImplS0.f45028a.z(loadEventInfo);
            mediaPeriodImplS0.f45030c.m(loadEventInfo, p0(mediaPeriodImplS0, mediaLoadData, (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodImplS0.f45029b.f44754a))));
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void a0() {
        this.f45020i.G(this);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void f0(TransferListener transferListener) {
        Handler handlerC = Util.C();
        synchronized (this) {
            this.f45025n = handlerC;
        }
        this.f45020i.b(handlerC, this);
        this.f45020i.t(handlerC, this);
        this.f45020i.C(this, transferListener, b0());
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public void g0(int i3, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, mediaLoadData, true);
        if (mediaPeriodImplS0 == null) {
            this.f45022k.o(loadEventInfo, mediaLoadData);
        } else {
            mediaPeriodImplS0.f45028a.z(loadEventInfo);
            mediaPeriodImplS0.f45030c.o(loadEventInfo, p0(mediaPeriodImplS0, mediaLoadData, (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodImplS0.f45029b.f44754a))));
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public void h0(int i3, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, mediaLoadData, false);
        if (mediaPeriodImplS0 == null) {
            this.f45022k.k(mediaLoadData);
        } else {
            mediaPeriodImplS0.f45028a.y(mediaPeriodImplS0, mediaLoadData);
            mediaPeriodImplS0.f45030c.k(p0(mediaPeriodImplS0, mediaLoadData, (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodImplS0.f45029b.f44754a))));
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void i0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, null, false);
        if (mediaPeriodImplS0 == null) {
            this.f45023l.j();
        } else {
            mediaPeriodImplS0.f45031d.j();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod j(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j3) {
        SharedMediaPeriod sharedMediaPeriod;
        Pair pair = new Pair(Long.valueOf(mediaPeriodId.f44757d), mediaPeriodId.f44754a);
        SharedMediaPeriod sharedMediaPeriod2 = this.f45026o;
        boolean z2 = false;
        if (sharedMediaPeriod2 != null) {
            if (sharedMediaPeriod2.f45042d.equals(mediaPeriodId.f44754a)) {
                sharedMediaPeriod = this.f45026o;
                this.f45021j.put(pair, sharedMediaPeriod);
                z2 = true;
            } else {
                this.f45026o.F(this.f45020i);
                sharedMediaPeriod = null;
            }
            this.f45026o = null;
        } else {
            sharedMediaPeriod = null;
        }
        if (sharedMediaPeriod == null && ((sharedMediaPeriod = (SharedMediaPeriod) Iterables.k(this.f45021j.get((Object) pair), null)) == null || !sharedMediaPeriod.e(mediaPeriodId, j3))) {
            AdPlaybackState adPlaybackState = (AdPlaybackState) Assertions.e((AdPlaybackState) this.f45027p.get(mediaPeriodId.f44754a));
            SharedMediaPeriod sharedMediaPeriod3 = new SharedMediaPeriod(this.f45020i.j(new MediaSource.MediaPeriodId(mediaPeriodId.f44754a, mediaPeriodId.f44757d), allocator, ServerSideAdInsertionUtil.e(j3, mediaPeriodId, adPlaybackState)), mediaPeriodId.f44754a, adPlaybackState);
            this.f45021j.put(pair, sharedMediaPeriod3);
            sharedMediaPeriod = sharedMediaPeriod3;
        }
        MediaPeriodImpl mediaPeriodImpl = new MediaPeriodImpl(sharedMediaPeriod, mediaPeriodId, V(mediaPeriodId), Q(mediaPeriodId));
        sharedMediaPeriod.d(mediaPeriodImpl);
        if (z2 && sharedMediaPeriod.f45047j.length > 0) {
            mediaPeriodImpl.j(j3);
        }
        return mediaPeriodImpl;
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    protected void l0() {
        v0();
        synchronized (this) {
            this.f45025n = null;
        }
        this.f45020i.J(this);
        this.f45020i.d(this);
        this.f45020i.u(this);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem m() {
        return this.f45020i.m();
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public void t0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaPeriodImpl mediaPeriodImplS0 = s0(mediaPeriodId, null, false);
        if (mediaPeriodImplS0 == null) {
            this.f45023l.m();
        } else {
            mediaPeriodImplS0.f45031d.m();
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
    public void z(MediaSource mediaSource, Timeline timeline) {
        AdPlaybackStateUpdater adPlaybackStateUpdater = this.f45024m;
        if ((adPlaybackStateUpdater == null || !adPlaybackStateUpdater.a(timeline)) && !this.f45027p.isEmpty()) {
            j0(new ServerSideAdInsertionTimeline(timeline, this.f45027p));
        }
    }
}
