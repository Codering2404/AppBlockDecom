package androidx.media3.exoplayer.analytics;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundExecutor;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private int A;
    private boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f43383a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlaybackSessionManager f43385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PlaybackSession f43386d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f43392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PlaybackMetrics.Builder f43393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f43394l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private PlaybackException f43397o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PendingFormatUpdate f43398p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PendingFormatUpdate f43399q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PendingFormatUpdate f43400r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Format f43401s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Format f43402t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Format f43403u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f43404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f43405w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f43406x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f43407y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f43408z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f43384b = BackgroundExecutor.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Timeline.Window f43388f = new Timeline.Window();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Timeline.Period f43389g = new Timeline.Period();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HashMap f43391i = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap f43390h = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f43387e = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f43395m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f43396n = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ErrorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43410b;

        public ErrorInfo(int i3, int i4) {
            this.f43409a = i3;
            this.f43410b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PendingFormatUpdate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f43411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f43413c;

        public PendingFormatUpdate(Format format, int i3, String str) {
            this.f43411a = format;
            this.f43412b = i3;
            this.f43413c = str;
        }
    }

    private MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.f43383a = context.getApplicationContext();
        this.f43386d = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.f43385c = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.g(this);
    }

    private boolean I0(PendingFormatUpdate pendingFormatUpdate) {
        return pendingFormatUpdate != null && pendingFormatUpdate.f43413c.equals(this.f43385c.b());
    }

    public static MediaMetricsListener J0(Context context) {
        MediaMetricsManager mediaMetricsManagerA = u2.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new MediaMetricsListener(context, mediaMetricsManagerA.createPlaybackSession());
    }

    private void K0() {
        PlaybackMetrics.Builder builder = this.f43393k;
        if (builder != null && this.B) {
            builder.setAudioUnderrunCount(this.A);
            this.f43393k.setVideoFramesDropped(this.f43407y);
            this.f43393k.setVideoFramesPlayed(this.f43408z);
            Long l3 = (Long) this.f43390h.get(this.f43392j);
            this.f43393k.setNetworkTransferDurationMillis(l3 == null ? 0L : l3.longValue());
            Long l4 = (Long) this.f43391i.get(this.f43392j);
            this.f43393k.setNetworkBytesRead(l4 == null ? 0L : l4.longValue());
            this.f43393k.setStreamSource((l4 == null || l4.longValue() <= 0) ? 0 : 1);
            final PlaybackMetrics playbackMetricsBuild = this.f43393k.build();
            this.f43384b.execute(new Runnable() { // from class: androidx.media3.exoplayer.analytics.z3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43666a.f43386d.reportPlaybackMetrics(playbackMetricsBuild);
                }
            });
        }
        this.f43393k = null;
        this.f43392j = null;
        this.A = 0;
        this.f43407y = 0;
        this.f43408z = 0;
        this.f43401s = null;
        this.f43402t = null;
        this.f43403u = null;
        this.B = false;
    }

    private static int L0(int i3) {
        switch (Util.a0(i3)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE /* 6002 */:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /* 6003 */:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static DrmInitData M0(ImmutableList immutableList) {
        DrmInitData drmInitData;
        UnmodifiableIterator it = immutableList.iterator();
        while (it.hasNext()) {
            Tracks.Group group = (Tracks.Group) it.next();
            for (int i3 = 0; i3 < group.f41246a; i3++) {
                if (group.e(i3) && (drmInitData = group.a(i3).f40636s) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    private static int N0(DrmInitData drmInitData) {
        for (int i3 = 0; i3 < drmInitData.f40584d; i3++) {
            UUID uuid = drmInitData.f(i3).f40586b;
            if (uuid.equals(C.f40544d)) {
                return 3;
            }
            if (uuid.equals(C.f40545e)) {
                return 2;
            }
            if (uuid.equals(C.f40543c)) {
                return 6;
            }
        }
        return 1;
    }

    private static ErrorInfo O0(PlaybackException playbackException, Context context, boolean z2) {
        int i3;
        boolean z3;
        if (playbackException.f40947a == 1001) {
            return new ErrorInfo(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z3 = exoPlaybackException.f42956k == 1;
            i3 = exoPlaybackException.f42960o;
        } else {
            i3 = 0;
            z3 = false;
        }
        Throwable th = (Throwable) Assertions.e(playbackException.getCause());
        if (!(th instanceof IOException)) {
            if (z3 && (i3 == 0 || i3 == 1)) {
                return new ErrorInfo(35, 0);
            }
            if (z3 && i3 == 3) {
                return new ErrorInfo(15, 0);
            }
            if (z3 && i3 == 2) {
                return new ErrorInfo(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new ErrorInfo(13, Util.b0(((MediaCodecRenderer.DecoderInitializationException) th).f44314d));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new ErrorInfo(14, ((MediaCodecDecoderException) th).f44263c);
            }
            if (th instanceof OutOfMemoryError) {
                return new ErrorInfo(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new ErrorInfo(17, ((AudioSink.InitializationException) th).f43709a);
            }
            if (th instanceof AudioSink.WriteException) {
                return new ErrorInfo(18, ((AudioSink.WriteException) th).f43714a);
            }
            if (!(th instanceof MediaCodec.CryptoException)) {
                return new ErrorInfo(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new ErrorInfo(L0(errorCode), errorCode);
        }
        if (th instanceof HttpDataSource.InvalidResponseCodeException) {
            return new ErrorInfo(5, ((HttpDataSource.InvalidResponseCodeException) th).f41910d);
        }
        if ((th instanceof HttpDataSource.InvalidContentTypeException) || (th instanceof ParserException)) {
            return new ErrorInfo(z2 ? 10 : 11, 0);
        }
        boolean z4 = th instanceof HttpDataSource.HttpDataSourceException;
        if (z4 || (th instanceof UdpDataSource.UdpDataSourceException)) {
            if (NetworkTypeObserver.e(context).g() == 1) {
                return new ErrorInfo(3, 0);
            }
            Throwable cause = th.getCause();
            return cause instanceof UnknownHostException ? new ErrorInfo(6, 0) : cause instanceof SocketTimeoutException ? new ErrorInfo(7, 0) : (z4 && ((HttpDataSource.HttpDataSourceException) th).f41908c == 1) ? new ErrorInfo(4, 0) : new ErrorInfo(8, 0);
        }
        if (playbackException.f40947a == 1002) {
            return new ErrorInfo(21, 0);
        }
        if (th instanceof DrmSession.DrmSessionException) {
            Throwable th2 = (Throwable) Assertions.e(th.getCause());
            if (!(th2 instanceof MediaDrm.MediaDrmStateException)) {
                return (Util.f41609a < 23 || !(th2 instanceof MediaDrmResetException)) ? th2 instanceof NotProvisionedException ? new ErrorInfo(24, 0) : th2 instanceof DeniedByServerException ? new ErrorInfo(29, 0) : th2 instanceof UnsupportedDrmException ? new ErrorInfo(23, 0) : th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new ErrorInfo(28, 0) : new ErrorInfo(30, 0) : new ErrorInfo(27, 0);
            }
            int iB0 = Util.b0(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
            return new ErrorInfo(L0(iB0), iB0);
        }
        if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
            return new ErrorInfo(9, 0);
        }
        Throwable cause2 = ((Throwable) Assertions.e(th.getCause())).getCause();
        return ((cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new ErrorInfo(32, 0) : new ErrorInfo(31, 0);
    }

    private static Pair P0(String str) {
        String[] strArrH1 = Util.h1(str, "-");
        return Pair.create(strArrH1[0], strArrH1.length >= 2 ? strArrH1[1] : null);
    }

    private static int R0(Context context) {
        switch (NetworkTypeObserver.e(context).g()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    private static int S0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f40714b;
        if (localConfiguration == null) {
            return 0;
        }
        int iW0 = Util.w0(localConfiguration.f40810a, localConfiguration.f40811b);
        if (iW0 == 0) {
            return 3;
        }
        if (iW0 != 1) {
            return iW0 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int T0(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return i3 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void U0(AnalyticsListener.Events events) {
        for (int i3 = 0; i3 < events.d(); i3++) {
            int iB = events.b(i3);
            AnalyticsListener.EventTime eventTimeC = events.c(iB);
            if (iB == 0) {
                this.f43385c.e(eventTimeC);
            } else if (iB == 11) {
                this.f43385c.h(eventTimeC, this.f43394l);
            } else {
                this.f43385c.a(eventTimeC);
            }
        }
    }

    private void V0(long j3) {
        int iR0 = R0(this.f43383a);
        if (iR0 != this.f43396n) {
            this.f43396n = iR0;
            final NetworkEvent networkEventBuild = g2.a().setNetworkType(iR0).setTimeSinceCreatedMillis(j3 - this.f43387e).build();
            this.f43384b.execute(new Runnable() { // from class: androidx.media3.exoplayer.analytics.x3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43655a.f43386d.reportNetworkEvent(networkEventBuild);
                }
            });
        }
    }

    private void W0(long j3) {
        PlaybackException playbackException = this.f43397o;
        if (playbackException == null) {
            return;
        }
        ErrorInfo errorInfoO0 = O0(playbackException, this.f43383a, this.f43405w == 4);
        final PlaybackErrorEvent playbackErrorEventBuild = c3.a().setTimeSinceCreatedMillis(j3 - this.f43387e).setErrorCode(errorInfoO0.f43409a).setSubErrorCode(errorInfoO0.f43410b).setException(playbackException).build();
        this.f43384b.execute(new Runnable() { // from class: androidx.media3.exoplayer.analytics.y3
            @Override // java.lang.Runnable
            public final void run() {
                this.f43660a.f43386d.reportPlaybackErrorEvent(playbackErrorEventBuild);
            }
        });
        this.B = true;
        this.f43397o = null;
    }

    private void X0(Player player, AnalyticsListener.Events events, long j3) {
        if (player.p() != 2) {
            this.f43404v = false;
        }
        if (player.b() == null) {
            this.f43406x = false;
        } else if (events.a(10)) {
            this.f43406x = true;
        }
        int iF1 = f1(player);
        if (this.f43395m != iF1) {
            this.f43395m = iF1;
            this.B = true;
            final PlaybackStateEvent playbackStateEventBuild = n3.a().setState(this.f43395m).setTimeSinceCreatedMillis(j3 - this.f43387e).build();
            this.f43384b.execute(new Runnable() { // from class: androidx.media3.exoplayer.analytics.a4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43502a.f43386d.reportPlaybackStateEvent(playbackStateEventBuild);
                }
            });
        }
    }

    private void Y0(Player player, AnalyticsListener.Events events, long j3) {
        if (events.a(2)) {
            Tracks tracksS = player.s();
            boolean zB = tracksS.b(2);
            boolean zB2 = tracksS.b(1);
            boolean zB3 = tracksS.b(3);
            if (zB || zB2 || zB3) {
                if (!zB) {
                    d1(j3, null, 0);
                }
                if (!zB2) {
                    Z0(j3, null, 0);
                }
                if (!zB3) {
                    b1(j3, null, 0);
                }
            }
        }
        if (I0(this.f43398p)) {
            PendingFormatUpdate pendingFormatUpdate = this.f43398p;
            Format format = pendingFormatUpdate.f43411a;
            if (format.f40640w != -1) {
                d1(j3, format, pendingFormatUpdate.f43412b);
                this.f43398p = null;
            }
        }
        if (I0(this.f43399q)) {
            PendingFormatUpdate pendingFormatUpdate2 = this.f43399q;
            Z0(j3, pendingFormatUpdate2.f43411a, pendingFormatUpdate2.f43412b);
            this.f43399q = null;
        }
        if (I0(this.f43400r)) {
            PendingFormatUpdate pendingFormatUpdate3 = this.f43400r;
            b1(j3, pendingFormatUpdate3.f43411a, pendingFormatUpdate3.f43412b);
            this.f43400r = null;
        }
    }

    private void Z0(long j3, Format format, int i3) {
        if (Objects.equals(this.f43402t, format)) {
            return;
        }
        if (this.f43402t == null && i3 == 0) {
            i3 = 1;
        }
        this.f43402t = format;
        e1(0, j3, format, i3);
    }

    private void a1(Player player, AnalyticsListener.Events events) {
        DrmInitData drmInitDataM0;
        if (events.a(0)) {
            AnalyticsListener.EventTime eventTimeC = events.c(0);
            if (this.f43393k != null) {
                c1(eventTimeC.f43340b, eventTimeC.f43342d);
            }
        }
        if (events.a(2) && this.f43393k != null && (drmInitDataM0 = M0(player.s().a())) != null) {
            k2.a(Util.k(this.f43393k)).setDrmType(N0(drmInitDataM0));
        }
        if (events.a(CloseCodes.UNEXPECTED_CONDITION)) {
            this.A++;
        }
    }

    private void b1(long j3, Format format, int i3) {
        if (Objects.equals(this.f43403u, format)) {
            return;
        }
        if (this.f43403u == null && i3 == 0) {
            i3 = 1;
        }
        this.f43403u = format;
        e1(2, j3, format, i3);
    }

    private void c1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        int iB;
        PlaybackMetrics.Builder builder = this.f43393k;
        if (mediaPeriodId == null || (iB = timeline.b(mediaPeriodId.f44754a)) == -1) {
            return;
        }
        timeline.f(iB, this.f43389g);
        timeline.n(this.f43389g.f41116c, this.f43388f);
        builder.setStreamType(S0(this.f43388f.f41137c));
        Timeline.Window window = this.f43388f;
        if (window.f41147m != -9223372036854775807L && !window.f41145k && !window.f41143i && !window.f()) {
            builder.setMediaDurationMillis(this.f43388f.d());
        }
        builder.setPlaybackType(this.f43388f.f() ? 2 : 1);
        this.B = true;
    }

    private void d1(long j3, Format format, int i3) {
        if (Objects.equals(this.f43401s, format)) {
            return;
        }
        if (this.f43401s == null && i3 == 0) {
            i3 = 1;
        }
        this.f43401s = format;
        e1(1, j3, format, i3);
    }

    private void e1(int i3, long j3, Format format, int i4) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = v1.a(i3).setTimeSinceCreatedMillis(j3 - this.f43387e);
        if (format != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(T0(i4));
            String str = format.f40631n;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = format.f40632o;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = format.f40628k;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i5 = format.f40627j;
            if (i5 != -1) {
                timeSinceCreatedMillis.setBitrate(i5);
            }
            int i6 = format.f40639v;
            if (i6 != -1) {
                timeSinceCreatedMillis.setWidth(i6);
            }
            int i7 = format.f40640w;
            if (i7 != -1) {
                timeSinceCreatedMillis.setHeight(i7);
            }
            int i8 = format.E;
            if (i8 != -1) {
                timeSinceCreatedMillis.setChannelCount(i8);
            }
            int i9 = format.F;
            if (i9 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i9);
            }
            String str4 = format.f40621d;
            if (str4 != null) {
                Pair pairP0 = P0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairP0.first);
                Object obj = pairP0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f3 = format.f40641x;
            if (f3 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f3);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.B = true;
        final TrackChangeEvent trackChangeEventBuild = timeSinceCreatedMillis.build();
        this.f43384b.execute(new Runnable() { // from class: androidx.media3.exoplayer.analytics.w3
            @Override // java.lang.Runnable
            public final void run() {
                this.f43650a.f43386d.reportTrackChangeEvent(trackChangeEventBuild);
            }
        });
    }

    private int f1(Player player) {
        int iP = player.p();
        if (this.f43404v) {
            return 5;
        }
        if (this.f43406x) {
            return 13;
        }
        if (iP == 4) {
            return 11;
        }
        if (iP == 2) {
            int i3 = this.f43395m;
            if (i3 == 0 || i3 == 2 || i3 == 12) {
                return 2;
            }
            if (player.L()) {
                return player.C() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (iP == 3) {
            if (player.L()) {
                return player.C() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (iP != 1 || this.f43395m == 0) {
            return this.f43395m;
        }
        return 12;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void B0(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
        if (mediaPeriodId == null || !mediaPeriodId.c()) {
            K0();
            this.f43392j = str;
            this.f43393k = r2.a().setPlayerName("AndroidXMedia3").setPlayerVersion("1.7.1");
            c1(eventTime.f43340b, eventTime.f43342d);
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void C(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
        if (i3 == 1) {
            this.f43404v = true;
        }
        this.f43394l = i3;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void M(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f43405w = mediaLoadData.f44740a;
    }

    public LogSessionId Q0() {
        return this.f43386d.getSessionId();
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void i(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f43397o = playbackException;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void m(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f43407y += decoderCounters.f42867g;
        this.f43408z += decoderCounters.f42865e;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void m0(AnalyticsListener.EventTime eventTime, String str, boolean z2) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
        if ((mediaPeriodId == null || !mediaPeriodId.c()) && str.equals(this.f43392j)) {
            K0();
        }
        this.f43390h.remove(str);
        this.f43391i.remove(str);
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void o(AnalyticsListener.EventTime eventTime, int i3, long j3, long j4) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
        if (mediaPeriodId != null) {
            String strC = this.f43385c.c(eventTime.f43340b, (MediaSource.MediaPeriodId) Assertions.e(mediaPeriodId));
            Long l3 = (Long) this.f43391i.get(strC);
            Long l4 = (Long) this.f43390h.get(strC);
            this.f43391i.put(strC, Long.valueOf((l3 == null ? 0L : l3.longValue()) + j3));
            this.f43390h.put(strC, Long.valueOf((l4 != null ? l4.longValue() : 0L) + ((long) i3)));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void r0(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        PendingFormatUpdate pendingFormatUpdate = this.f43398p;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.f43411a;
            if (format.f40640w == -1) {
                this.f43398p = new PendingFormatUpdate(format.b().B0(videoSize.f41258a).d0(videoSize.f41259b).N(), pendingFormatUpdate.f43412b, pendingFormatUpdate.f43413c);
            }
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void u0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        if (eventTime.f43342d == null) {
            return;
        }
        PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate((Format) Assertions.e(mediaLoadData.f44742c), mediaLoadData.f44743d, this.f43385c.c(eventTime.f43340b, (MediaSource.MediaPeriodId) Assertions.e(eventTime.f43342d)));
        int i3 = mediaLoadData.f44741b;
        if (i3 != 0) {
            if (i3 == 1) {
                this.f43399q = pendingFormatUpdate;
                return;
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                this.f43400r = pendingFormatUpdate;
                return;
            }
        }
        this.f43398p = pendingFormatUpdate;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public void v0(Player player, AnalyticsListener.Events events) {
        if (events.d() == 0) {
            return;
        }
        U0(events);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a1(player, events);
        W0(jElapsedRealtime);
        Y0(player, events, jElapsedRealtime);
        V0(jElapsedRealtime);
        X0(player, events, jElapsedRealtime);
        if (events.a(1028)) {
            this.f43385c.f(events.c(1028));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void y0(AnalyticsListener.EventTime eventTime, String str) {
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager.Listener
    public void c(AnalyticsListener.EventTime eventTime, String str, String str2) {
    }
}
