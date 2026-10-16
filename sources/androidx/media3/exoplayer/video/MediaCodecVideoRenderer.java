package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private static final int[] f45701v1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    private static boolean f45702w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private static boolean f45703x1;
    private final Context G0;
    private final boolean H0;
    private final VideoRendererEventListener.EventDispatcher I0;
    private final int J0;
    private final boolean K0;
    private final VideoFrameReleaseControl L0;
    private final VideoFrameReleaseControl.FrameReleaseInfo M0;
    private final Av1SampleDependencyParser N0;
    private final long O0;
    private final PriorityQueue P0;
    private CodecMaxValues Q0;
    private boolean R0;
    private boolean S0;
    private VideoSink T0;
    private boolean U0;
    private List V0;
    private Surface W0;
    private PlaceholderSurface X0;
    private Size Y0;
    private boolean Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private int f45704a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private int f45705b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private long f45706c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private int f45707d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    private int f45708e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private int f45709f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private long f45710g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private int f45711h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private long f45712i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private VideoSize f45713j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private VideoSize f45714k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private int f45715l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private boolean f45716m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private int f45717n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    OnFrameRenderedListenerV23 f45718o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private VideoFrameMetadataListener f45719p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private long f45720q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private long f45721r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    private boolean f45722s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    private boolean f45723t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    private int f45724u1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class Api26 {
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null && display.isHdr()) {
                for (int i3 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                    if (i3 == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f45730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f45731b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MediaCodecAdapter.Factory f45733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f45734e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f45735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Handler f45736g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private VideoRendererEventListener f45737h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f45738i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private VideoSink f45740k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f45741l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MediaCodecSelector f45732c = MediaCodecSelector.f44322a;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f45739j = 30.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f45742m = -9223372036854775807L;

        public Builder(Context context) {
            this.f45730a = context;
            this.f45733d = MediaCodecAdapter.Factory.a(context);
        }

        public MediaCodecVideoRenderer m() {
            Assertions.g(!this.f45731b);
            Handler handler = this.f45736g;
            Assertions.g((handler == null && this.f45737h == null) || !(handler == null || this.f45737h == null));
            this.f45731b = true;
            return new MediaCodecVideoRenderer(this);
        }

        public Builder n(long j3) {
            this.f45742m = j3;
            return this;
        }

        public Builder o(boolean z2) {
            this.f45741l = z2;
            return this;
        }

        public Builder p(long j3) {
            this.f45734e = j3;
            return this;
        }

        public Builder q(float f3) {
            this.f45739j = f3;
            return this;
        }

        public Builder r(MediaCodecAdapter.Factory factory) {
            this.f45733d = factory;
            return this;
        }

        public Builder s(boolean z2) {
            this.f45735f = z2;
            return this;
        }

        public Builder t(Handler handler) {
            this.f45736g = handler;
            return this;
        }

        public Builder u(VideoRendererEventListener videoRendererEventListener) {
            this.f45737h = videoRendererEventListener;
            return this;
        }

        public Builder v(int i3) {
            this.f45738i = i3;
            return this;
        }

        public Builder w(MediaCodecSelector mediaCodecSelector) {
            this.f45732c = mediaCodecSelector;
            return this;
        }

        public Builder x(VideoSink videoSink) {
            this.f45740k = videoSink;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class CodecMaxValues {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f45744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f45745c;

        public CodecMaxValues(int i3, int i4, int i5) {
            this.f45743a = i3;
            this.f45744b = i4;
            this.f45745c = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f45746a;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerD = Util.D(this);
            this.f45746a = handlerD;
            mediaCodecAdapter.h(this, handlerD);
        }

        private void b(long j3) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.f45718o1 || mediaCodecVideoRenderer.O0() == null) {
                return;
            }
            if (j3 == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.M2();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.L2(j3);
            } catch (ExoPlaybackException e3) {
                MediaCodecVideoRenderer.this.N1(e3);
            }
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void a(MediaCodecAdapter mediaCodecAdapter, long j3, long j4) {
            if (Util.f41609a >= 30) {
                b(j3);
            } else {
                this.f45746a.sendMessageAtFrontOfQueue(Message.obtain(this.f45746a, 0, (int) (j3 >> 32), (int) j3));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(Util.p1(message.arg1, message.arg2));
            return true;
        }
    }

    protected MediaCodecVideoRenderer(Builder builder) {
        super(2, builder.f45733d, builder.f45732c, builder.f45735f, builder.f45739j);
        Context applicationContext = builder.f45730a.getApplicationContext();
        this.G0 = applicationContext;
        this.J0 = builder.f45738i;
        this.T0 = builder.f45740k;
        this.I0 = new VideoRendererEventListener.EventDispatcher(builder.f45736g, builder.f45737h);
        this.H0 = this.T0 == null;
        this.L0 = new VideoFrameReleaseControl(applicationContext, this, builder.f45734e);
        this.M0 = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.K0 = l2();
        this.Y0 = Size.f41593c;
        this.f45704a1 = 1;
        this.f45705b1 = 0;
        this.f45713j1 = VideoSize.f41254e;
        this.f45717n1 = 0;
        this.f45714k1 = null;
        this.f45715l1 = -1000;
        this.f45720q1 = -9223372036854775807L;
        this.f45721r1 = -9223372036854775807L;
        this.N0 = builder.f45741l ? new Av1SampleDependencyParser() : null;
        this.P0 = new PriorityQueue();
        this.O0 = builder.f45742m != -9223372036854775807L ? -builder.f45742m : -9223372036854775807L;
    }

    private void B2() {
        if (this.f45707d1 > 0) {
            long jA = U().a();
            this.I0.n(this.f45707d1, jA - this.f45706c1);
            this.f45707d1 = 0;
            this.f45706c1 = jA;
        }
    }

    private void C2() {
        if (!this.L0.i() || this.W0 == null) {
            return;
        }
        K2();
    }

    private void D2() {
        int i3 = this.f45711h1;
        if (i3 != 0) {
            this.I0.r(this.f45710g1, i3);
            this.f45710g1 = 0L;
            this.f45711h1 = 0;
        }
    }

    private void E2(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.f41254e) || videoSize.equals(this.f45714k1)) {
            return;
        }
        this.f45714k1 = videoSize;
        this.I0.t(videoSize);
    }

    private void F2() {
        Surface surface = this.W0;
        if (surface == null || !this.Z0) {
            return;
        }
        this.I0.q(surface);
    }

    private void G2() {
        VideoSize videoSize = this.f45714k1;
        if (videoSize != null) {
            this.I0.t(videoSize);
        }
    }

    private void H2(MediaFormat mediaFormat) {
        if (this.T0 == null || Util.D0(this.G0)) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    private void I2() {
        int i3;
        MediaCodecAdapter mediaCodecAdapterO0;
        if (!this.f45716m1 || (i3 = Util.f41609a) < 23 || (mediaCodecAdapterO0 = O0()) == null) {
            return;
        }
        this.f45718o1 = new OnFrameRenderedListenerV23(mediaCodecAdapterO0);
        if (i3 >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            mediaCodecAdapterO0.f(bundle);
        }
    }

    private void J2(long j3, long j4, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.f45719p1;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.e(j3, j4, format, T0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        this.I0.q(this.W0);
        this.Z0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2() {
        M1();
    }

    private void N2(MediaCodecAdapter mediaCodecAdapter, int i3, long j3, Format format) {
        MediaCodecVideoRenderer mediaCodecVideoRenderer;
        long jG = this.M0.g();
        long jF = this.M0.f();
        if (Z2() && jG == this.f45712i1) {
            c3(mediaCodecAdapter, i3, j3);
            mediaCodecVideoRenderer = this;
        } else {
            mediaCodecVideoRenderer = this;
            mediaCodecVideoRenderer.J2(j3, jG, format);
            mediaCodecVideoRenderer.Q2(mediaCodecAdapter, i3, j3, jG);
            jG = jG;
        }
        i3(jF);
        mediaCodecVideoRenderer.f45712i1 = jG;
    }

    private void O2() {
        PlaceholderSurface placeholderSurface = this.X0;
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.X0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(MediaCodecAdapter mediaCodecAdapter, int i3, long j3, long j4) {
        Q2(mediaCodecAdapter, i3, j3, j4);
    }

    private static void R2(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.f(bundle);
    }

    private void S2(Object obj) throws ExoPlaybackException {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.W0 == surface) {
            if (surface != null) {
                G2();
                F2();
                return;
            }
            return;
        }
        this.W0 = surface;
        if (this.T0 == null) {
            this.L0.q(surface);
        }
        this.Z0 = false;
        int state = getState();
        MediaCodecAdapter mediaCodecAdapterO0 = O0();
        if (mediaCodecAdapterO0 != null && this.T0 == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) Assertions.e(Q0());
            boolean zX2 = x2(mediaCodecInfo);
            if (Util.f41609a < 23 || !zX2 || this.R0) {
                E1();
                m1();
            } else {
                T2(mediaCodecAdapterO0, w2(mediaCodecInfo));
            }
        }
        if (surface != null) {
            G2();
        } else {
            this.f45714k1 = null;
            VideoSink videoSink = this.T0;
            if (videoSink != null) {
                videoSink.v();
            }
        }
        if (state == 2) {
            VideoSink videoSink2 = this.T0;
            if (videoSink2 != null) {
                videoSink2.A(true);
            } else {
                this.L0.e(true);
            }
        }
        I2();
    }

    private void T2(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        int i3 = Util.f41609a;
        if (i3 >= 23 && surface != null) {
            U2(mediaCodecAdapter, surface);
        } else {
            if (i3 < 35) {
                throw new IllegalStateException();
            }
            k2(mediaCodecAdapter);
        }
    }

    private static int d3(Context context, MediaCodecSelector mediaCodecSelector, Format format) {
        boolean z2;
        int i3 = 0;
        if (!MimeTypes.q(format.f40632o)) {
            return RendererCapabilities.u(0);
        }
        boolean z3 = format.f40636s != null;
        List listS2 = s2(context, mediaCodecSelector, format, z3, false);
        if (z3 && listS2.isEmpty()) {
            listS2 = s2(context, mediaCodecSelector, format, false, false);
        }
        if (listS2.isEmpty()) {
            return RendererCapabilities.u(1);
        }
        if (!MediaCodecRenderer.W1(format)) {
            return RendererCapabilities.u(2);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) listS2.get(0);
        boolean zO = mediaCodecInfo.o(format);
        if (zO) {
            z2 = true;
        } else {
            for (int i4 = 1; i4 < listS2.size(); i4++) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) listS2.get(i4);
                if (mediaCodecInfo2.o(format)) {
                    z2 = false;
                    zO = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
            z2 = true;
        }
        int i5 = zO ? 4 : 3;
        int i6 = mediaCodecInfo.r(format) ? 16 : 8;
        int i7 = mediaCodecInfo.f44271h ? 64 : 0;
        int i8 = z2 ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 0;
        if (Util.f41609a >= 26 && "video/dolby-vision".equals(format.f40632o) && !Api26.a(context)) {
            i8 = Function.MAX_NARGS;
        }
        if (zO) {
            List listS22 = s2(context, mediaCodecSelector, format, z3, true);
            if (!listS22.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = (MediaCodecInfo) MediaCodecUtil.o(listS22, format).get(0);
                if (mediaCodecInfo3.o(format) && mediaCodecInfo3.r(format)) {
                    i3 = 32;
                }
            }
        }
        return RendererCapabilities.q(i5, i6, i3, i7, i8);
    }

    private void e3() {
        MediaCodecAdapter mediaCodecAdapterO0 = O0();
        if (mediaCodecAdapterO0 != null && Util.f41609a >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.f45715l1));
            mediaCodecAdapterO0.f(bundle);
        }
    }

    private void g3(long j3) {
        int i3 = 0;
        while (true) {
            Long l3 = (Long) this.P0.peek();
            if (l3 == null || l3.longValue() >= j3) {
                break;
            }
            i3++;
            this.P0.poll();
        }
        f3(i3, 0);
    }

    private void h3(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timelineC0 = c0();
        if (timelineC0.q()) {
            this.f45721r1 = -9223372036854775807L;
        } else {
            this.f45721r1 = timelineC0.h(((MediaSource.MediaPeriodId) Assertions.e(mediaPeriodId)).f44754a, new Timeline.Period()).k();
        }
    }

    private static boolean l2() {
        return "NVIDIA".equals(Build.MANUFACTURER);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int p2(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r10, androidx.media3.common.Format r11) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.p2(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, androidx.media3.common.Format):int");
    }

    private static Point q2(MediaCodecInfo mediaCodecInfo, Format format) {
        int i3 = format.f40640w;
        int i4 = format.f40639v;
        boolean z2 = i3 > i4;
        int i5 = z2 ? i3 : i4;
        if (z2) {
            i3 = i4;
        }
        float f3 = i3 / i5;
        for (int i6 : f45701v1) {
            int i7 = (int) (i6 * f3);
            if (i6 <= i5 || i7 <= i3) {
                break;
            }
            int i8 = z2 ? i7 : i6;
            if (!z2) {
                i6 = i7;
            }
            Point pointC = mediaCodecInfo.c(i8, i6);
            float f4 = format.f40641x;
            if (pointC != null && mediaCodecInfo.u(pointC.x, pointC.y, f4)) {
                return pointC;
            }
        }
        return null;
    }

    private static List s2(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z2, boolean z3) {
        String str = format.f40632o;
        if (str == null) {
            return ImmutableList.y();
        }
        if (Util.f41609a >= 26 && "video/dolby-vision".equals(str) && !Api26.a(context)) {
            List listH = MediaCodecUtil.h(mediaCodecSelector, format, z2, z3);
            if (!listH.isEmpty()) {
                return listH;
            }
        }
        return MediaCodecUtil.n(mediaCodecSelector, format, z2, z3);
    }

    protected static int t2(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.f40633p == -1) {
            return p2(mediaCodecInfo, format);
        }
        int size = format.f40635r.size();
        int length = 0;
        for (int i3 = 0; i3 < size; i3++) {
            length += ((byte[]) format.f40635r.get(i3)).length;
        }
        return format.f40633p + length;
    }

    private static int u2(int i3, int i4) {
        return (i3 * 3) / (i4 * 2);
    }

    private Surface w2(MediaCodecInfo mediaCodecInfo) {
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            return videoSink.a();
        }
        Surface surface = this.W0;
        if (surface != null) {
            return surface;
        }
        if (a3(mediaCodecInfo)) {
            return null;
        }
        Assertions.g(b3(mediaCodecInfo));
        PlaceholderSurface placeholderSurface = this.X0;
        if (placeholderSurface != null && placeholderSurface.f45750a != mediaCodecInfo.f44270g) {
            O2();
        }
        if (this.X0 == null) {
            this.X0 = PlaceholderSurface.d(this.G0, mediaCodecInfo.f44270g);
        }
        return this.X0;
    }

    private boolean x2(MediaCodecInfo mediaCodecInfo) {
        if (this.T0 != null) {
            return true;
        }
        Surface surface = this.W0;
        return (surface != null && surface.isValid()) || a3(mediaCodecInfo) || b3(mediaCodecInfo);
    }

    private boolean y2(DecoderInputBuffer decoderInputBuffer) {
        return decoderInputBuffer.f42140g < Y();
    }

    private boolean z2(DecoderInputBuffer decoderInputBuffer) {
        if (k() || decoderInputBuffer.l() || this.f45721r1 == -9223372036854775807L) {
            return true;
        }
        return this.f45721r1 - (decoderInputBuffer.f42140g - Y0()) <= 100000;
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean A(long j3, long j4) {
        return Y2(j3, j4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean A1(long j3, long j4, final MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, final int i3, int i4, int i5, long j5, boolean z2, boolean z3, Format format) {
        Assertions.e(mediaCodecAdapter);
        final long jY0 = j5 - Y0();
        g3(j5);
        if (this.T0 != null) {
            if (!z2 || z3) {
                return this.T0.e(o2() + j5, z3, new VideoSink.VideoFrameHandler() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.2
                    @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
                    public void a(long j6) {
                        MediaCodecVideoRenderer.this.P2(mediaCodecAdapter, i3, jY0, j6);
                    }

                    @Override // androidx.media3.exoplayer.video.VideoSink.VideoFrameHandler
                    public void b() {
                        MediaCodecVideoRenderer.this.c3(mediaCodecAdapter, i3, jY0);
                    }
                });
            }
            c3(mediaCodecAdapter, i3, jY0);
            return true;
        }
        int iC = this.L0.c(j5, j3, j4, Z0(), z2, z3, this.M0);
        if (iC == 0) {
            long jB = U().b();
            J2(jY0, jB, format);
            P2(mediaCodecAdapter, i3, jY0, jB);
            i3(this.M0.f());
            return true;
        }
        if (iC == 1) {
            N2((MediaCodecAdapter) Assertions.i(mediaCodecAdapter), i3, jY0, format);
            return true;
        }
        if (iC == 2) {
            m2(mediaCodecAdapter, i3, jY0);
            i3(this.M0.f());
            return true;
        }
        if (iC == 3) {
            c3(mediaCodecAdapter, i3, jY0);
            i3(this.M0.f());
            return true;
        }
        if (iC == 4 || iC == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(iC));
    }

    protected boolean A2(long j3, boolean z2) throws ExoPlaybackException {
        int iR0 = r0(j3);
        if (iR0 == 0) {
            return false;
        }
        if (z2) {
            DecoderCounters decoderCounters = this.A0;
            int i3 = decoderCounters.f42864d + iR0;
            decoderCounters.f42864d = i3;
            decoderCounters.f42866f += this.f45709f1;
            decoderCounters.f42864d = i3 + this.P0.size();
        } else {
            this.A0.f42870j++;
            f3(iR0 + this.P0.size(), this.f45709f1);
        }
        L0();
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.x(false);
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException B0(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.W0);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean C(long j3, long j4, long j5, boolean z2, boolean z3) {
        if (this.O0 != -9223372036854775807L) {
            this.f45723t1 = j4 > Y() + 200000 && j3 < this.O0;
        }
        return W2(j3, j5, z2) && A2(j4, z3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void F1() {
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.c();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void G1() {
        super.G1();
        this.P0.clear();
        this.f45723t1 = false;
        this.f45709f1 = 0;
        this.f45724u1 = 0;
        Av1SampleDependencyParser av1SampleDependencyParser = this.N0;
        if (av1SampleDependencyParser != null) {
            av1SampleDependencyParser.c();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public void L(float f3, float f4) throws ExoPlaybackException {
        super.L(f3, f4);
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.u(f3);
        } else {
            this.L0.r(f3);
        }
    }

    protected void L2(long j3) {
        Z1(j3);
        E2(this.f45713j1);
        this.A0.f42865e++;
        C2();
        v1(j3);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameTimingEvaluator
    public boolean M(long j3, long j4, boolean z2) {
        return X2(j3, j4, z2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int P0(DecoderInputBuffer decoderInputBuffer) {
        return (Util.f41609a >= 34 && this.f45716m1 && y2(decoderInputBuffer)) ? 32 : 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean Q1(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (z2(decoderInputBuffer) || decoderInputBuffer.r()) {
            return false;
        }
        boolean zY2 = y2(decoderInputBuffer);
        if ((!zY2 && !this.f45723t1) || decoderInputBuffer.h()) {
            return false;
        }
        if (decoderInputBuffer.m()) {
            decoderInputBuffer.f();
            if (zY2) {
                this.A0.f42864d++;
            } else if (this.f45723t1) {
                this.P0.add(Long.valueOf(decoderInputBuffer.f42140g));
                this.f45724u1++;
            }
            return true;
        }
        if (this.N0 != null && ((MediaCodecInfo) Assertions.e(Q0())).f44265b.equals("video/av01") && (byteBuffer = decoderInputBuffer.f42138d) != null) {
            boolean z2 = zY2 || this.f45724u1 <= 0;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            byteBufferAsReadOnlyBuffer.flip();
            int iD = this.N0.d(byteBufferAsReadOnlyBuffer, z2);
            boolean z3 = ((CodecMaxValues) Assertions.e(this.Q0)).f45745c + iD < byteBufferAsReadOnlyBuffer.capacity();
            if (iD != byteBufferAsReadOnlyBuffer.limit() && z3) {
                ((ByteBuffer) Assertions.e(decoderInputBuffer.f42138d)).position(iD);
                if (zY2) {
                    this.A0.f42864d++;
                } else if (this.f45723t1) {
                    this.P0.add(Long.valueOf(decoderInputBuffer.f42140g));
                    this.f45724u1++;
                }
                return true;
            }
        }
        return false;
    }

    protected void Q2(MediaCodecAdapter mediaCodecAdapter, int i3, long j3, long j4) {
        TraceUtil.a("releaseOutputBuffer");
        mediaCodecAdapter.n(i3, j4);
        TraceUtil.b();
        this.A0.f42865e++;
        this.f45708e1 = 0;
        if (this.T0 == null) {
            E2(this.f45713j1);
            C2();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean R0() {
        return this.f45716m1 && Util.f41609a < 23;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean R1(MediaCodecInfo mediaCodecInfo) {
        return x2(mediaCodecInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected float S0(float f3, Format format, Format[] formatArr) {
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f4 = format2.f40641x;
            if (f4 != -1.0f) {
                fMax = Math.max(fMax, f4);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f3;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected List U0(MediaCodecSelector mediaCodecSelector, Format format, boolean z2) {
        return MediaCodecUtil.o(s2(this.G0, mediaCodecSelector, format, z2, this.f45716m1), format);
    }

    protected void U2(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.l(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected int V1(MediaCodecSelector mediaCodecSelector, Format format) {
        return d3(this.G0, mediaCodecSelector, format);
    }

    public void V2(List list) {
        this.V0 = list;
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.l(list);
        }
    }

    protected boolean W2(long j3, long j4, boolean z2) {
        return j3 < -500000 && !z2;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected MediaCodecAdapter.Configuration X0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f3) {
        String str = mediaCodecInfo.f44266c;
        CodecMaxValues codecMaxValuesR2 = r2(mediaCodecInfo, format, a0());
        this.Q0 = codecMaxValuesR2;
        MediaFormat mediaFormatV2 = v2(format, str, codecMaxValuesR2, f3, this.K0, this.f45716m1 ? this.f45717n1 : 0);
        Surface surfaceW2 = w2(mediaCodecInfo);
        H2(mediaFormatV2);
        return MediaCodecAdapter.Configuration.b(mediaCodecInfo, mediaFormatV2, format, surfaceW2, mediaCrypto);
    }

    protected boolean X2(long j3, long j4, boolean z2) {
        return j3 < -30000 && !z2;
    }

    protected boolean Y2(long j3, long j4) {
        return j3 < -30000 && j4 > 100000;
    }

    protected boolean Z2() {
        return true;
    }

    protected boolean a3(MediaCodecInfo mediaCodecInfo) {
        return Util.f41609a >= 35 && mediaCodecInfo.f44274k;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean b() {
        if (!super.b()) {
            return false;
        }
        VideoSink videoSink = this.T0;
        return videoSink == null || videoSink.b();
    }

    protected boolean b3(MediaCodecInfo mediaCodecInfo) {
        if (Util.f41609a < 23 || this.f45716m1 || j2(mediaCodecInfo.f44264a)) {
            return false;
        }
        return !mediaCodecInfo.f44270g || PlaceholderSurface.c(this.G0);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void c1(DecoderInputBuffer decoderInputBuffer) {
        if (this.S0) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f42141h);
            if (byteBuffer.remaining() >= 7) {
                byte b3 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b4 = byteBuffer.get();
                byte b5 = byteBuffer.get();
                byteBuffer.position(0);
                if (b3 == -75 && s2 == 60 && s3 == 1 && b4 == 4) {
                    if (b5 == 0 || b5 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        R2((MediaCodecAdapter) Assertions.e(O0()), bArr);
                    }
                }
            }
        }
    }

    protected void c3(MediaCodecAdapter mediaCodecAdapter, int i3, long j3) {
        TraceUtil.a("skipVideoBuffer");
        mediaCodecAdapter.q(i3, false);
        TraceUtil.b();
        this.A0.f42866f++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void e0() {
        this.f45714k1 = null;
        this.f45721r1 = -9223372036854775807L;
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.s();
        } else {
            this.L0.g();
        }
        I2();
        this.Z0 = false;
        this.f45718o1 = null;
        try {
            super.e0();
        } finally {
            this.I0.m(this.A0);
            this.I0.t(VideoSize.f41254e);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void f() {
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.f();
        } else {
            this.L0.a();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void f0(boolean z2, boolean z3) {
        super.f0(z2, z3);
        boolean z4 = V().f43289b;
        Assertions.g((z4 && this.f45717n1 == 0) ? false : true);
        if (this.f45716m1 != z4) {
            this.f45716m1 = z4;
            E1();
        }
        this.I0.o(this.A0);
        if (!this.U0) {
            if (this.V0 != null && this.T0 == null) {
                PlaybackVideoGraphWrapper playbackVideoGraphWrapperH = new PlaybackVideoGraphWrapper.Builder(this.G0, this.L0).i(U()).h();
                playbackVideoGraphWrapperH.S(1);
                this.T0 = playbackVideoGraphWrapperH.H(0);
            }
            this.U0 = true;
        }
        VideoSink videoSink = this.T0;
        if (videoSink == null) {
            this.L0.o(U());
            this.L0.h(z3);
            return;
        }
        videoSink.B(new VideoSink.Listener() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.1
            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void a(VideoSink videoSink2) {
                if (MediaCodecVideoRenderer.this.W0 != null) {
                    MediaCodecVideoRenderer.this.K2();
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void c(VideoSink videoSink2, VideoSink.VideoSinkException videoSinkException) {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                mediaCodecVideoRenderer.N1(mediaCodecVideoRenderer.S(videoSinkException, videoSinkException.f45880a, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE));
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void d(VideoSink videoSink2) {
                if (MediaCodecVideoRenderer.this.W0 != null) {
                    MediaCodecVideoRenderer.this.f3(0, 1);
                }
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public void b(VideoSink videoSink2, VideoSize videoSize) {
            }
        }, MoreExecutors.a());
        VideoFrameMetadataListener videoFrameMetadataListener = this.f45719p1;
        if (videoFrameMetadataListener != null) {
            this.T0.g(videoFrameMetadataListener);
        }
        if (this.W0 != null && !this.Y0.equals(Size.f41593c)) {
            this.T0.r(this.W0, this.Y0);
        }
        this.T0.t(this.f45705b1);
        this.T0.u(a1());
        List list = this.V0;
        if (list != null) {
            this.T0.l(list);
        }
        this.T0.o(z3);
        Renderer.WakeupListener wakeupListenerB1 = b1();
        if (wakeupListenerB1 != null) {
            this.T0.k(wakeupListenerB1);
        }
    }

    protected void f3(int i3, int i4) {
        DecoderCounters decoderCounters = this.A0;
        decoderCounters.f42868h += i3;
        int i5 = i3 + i4;
        decoderCounters.f42867g += i5;
        this.f45707d1 += i5;
        int i6 = this.f45708e1 + i5;
        this.f45708e1 = i6;
        decoderCounters.f42869i = Math.max(i6, decoderCounters.f42869i);
        int i7 = this.J0;
        if (i7 <= 0 || this.f45707d1 < i7) {
            return;
        }
        B2();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void g0() {
        super.g0();
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public void h(long j3, long j4) throws ExoPlaybackException {
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            try {
                videoSink.h(j3, j4);
            } catch (VideoSink.VideoSinkException e3) {
                throw S(e3, e3.f45880a, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }
        super.h(j3, j4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void h0(long j3, boolean z2) throws ExoPlaybackException {
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            if (!z2) {
                videoSink.x(true);
            }
            this.T0.i(Z0(), o2());
            this.f45722s1 = true;
        }
        super.h0(j3, z2);
        if (this.T0 == null) {
            this.L0.m();
        }
        if (z2) {
            VideoSink videoSink2 = this.T0;
            if (videoSink2 != null) {
                videoSink2.A(false);
            } else {
                this.L0.e(false);
            }
        }
        I2();
        this.f45708e1 = 0;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void i0() {
        super.i0();
        VideoSink videoSink = this.T0;
        if (videoSink == null || !this.H0) {
            return;
        }
        videoSink.release();
    }

    protected void i2(VideoSink videoSink, int i3, Format format) {
        List listY = this.V0;
        if (listY == null) {
            listY = ImmutableList.y();
        }
        videoSink.q(i3, format, listY);
    }

    protected void i3(long j3) {
        this.A0.a(j3);
        this.f45710g1 += j3;
        this.f45711h1++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        boolean zIsReady = super.isReady();
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            return videoSink.m(zIsReady);
        }
        if (zIsReady && (O0() == null || this.f45716m1)) {
            return true;
        }
        return this.L0.d(zIsReady);
    }

    protected boolean j2(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            try {
                if (!f45702w1) {
                    f45703x1 = n2();
                    f45702w1 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f45703x1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void k0() {
        try {
            super.k0();
        } finally {
            this.U0 = false;
            this.f45720q1 = -9223372036854775807L;
            O2();
        }
    }

    protected void k2(MediaCodecAdapter mediaCodecAdapter) {
        mediaCodecAdapter.i();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void l0() {
        super.l0();
        this.f45707d1 = 0;
        this.f45706c1 = U().a();
        this.f45710g1 = 0L;
        this.f45711h1 = 0;
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.p();
        } else {
            this.L0.k();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void m0() {
        B2();
        D2();
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.j();
        } else {
            this.L0.l();
        }
        super.m0();
    }

    protected void m2(MediaCodecAdapter mediaCodecAdapter, int i3, long j3) {
        TraceUtil.a("dropVideoBuffer");
        mediaCodecAdapter.q(i3, false);
        TraceUtil.b();
        f3(0, 1);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    protected void n0(Format[] formatArr, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) {
        super.n0(formatArr, j3, j4, mediaPeriodId);
        if (this.f45720q1 == -9223372036854775807L) {
            this.f45720q1 = j3;
        }
        h3(mediaPeriodId);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected boolean o1(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.T0;
        if (videoSink == null || videoSink.isInitialized()) {
            return true;
        }
        try {
            return this.T0.n(format);
        } catch (VideoSink.VideoSinkException e3) {
            throw S(e3, format, 7000);
        }
    }

    protected long o2() {
        return -this.f45720q1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void p1(Exception exc) {
        Log.e("MediaCodecVideoRenderer", "Video codec error", exc);
        this.I0.s(exc);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void q1(String str, MediaCodecAdapter.Configuration configuration, long j3, long j4) {
        this.I0.k(str, j3, j4);
        this.R0 = j2(str);
        this.S0 = ((MediaCodecInfo) Assertions.e(Q0())).p();
        I2();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void r1(String str) {
        this.I0.l(str);
    }

    protected CodecMaxValues r2(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int iP2;
        int iMax = format.f40639v;
        int iMax2 = format.f40640w;
        int iT2 = t2(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (iT2 != -1 && (iP2 = p2(mediaCodecInfo, format)) != -1) {
                iT2 = Math.min((int) (iT2 * 1.5f), iP2);
            }
            return new CodecMaxValues(iMax, iMax2, iT2);
        }
        int length = formatArr.length;
        boolean z2 = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format formatN = formatArr[i3];
            if (format.C != null && formatN.C == null) {
                formatN = formatN.b().T(format.C).N();
            }
            if (mediaCodecInfo.e(format, formatN).f42876d != 0) {
                int i4 = formatN.f40639v;
                z2 |= i4 == -1 || formatN.f40640w == -1;
                iMax = Math.max(iMax, i4);
                iMax2 = Math.max(iMax2, formatN.f40640w);
                iT2 = Math.max(iT2, t2(mediaCodecInfo, formatN));
            }
        }
        if (z2) {
            Log.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointQ2 = q2(mediaCodecInfo, format);
            if (pointQ2 != null) {
                iMax = Math.max(iMax, pointQ2.x);
                iMax2 = Math.max(iMax2, pointQ2.y);
                iT2 = Math.max(iT2, p2(mediaCodecInfo, format.b().B0(iMax).d0(iMax2).N()));
                Log.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, iT2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation s1(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationS1 = super.s1(formatHolder);
        this.I0.p((Format) Assertions.e(formatHolder.f43108b), decoderReuseEvaluationS1);
        return decoderReuseEvaluationS1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void t1(Format format, MediaFormat mediaFormat) {
        int integer;
        int i3;
        MediaCodecAdapter mediaCodecAdapterO0 = O0();
        if (mediaCodecAdapterO0 != null) {
            mediaCodecAdapterO0.j(this.f45704a1);
        }
        if (this.f45716m1) {
            i3 = format.f40639v;
            integer = format.f40640w;
        } else {
            Assertions.e(mediaFormat);
            boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            integer = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            i3 = integer2;
        }
        float f3 = format.f40643z;
        int i4 = format.f40642y;
        if (i4 == 90 || i4 == 270) {
            f3 = 1.0f / f3;
            int i5 = integer;
            integer = i3;
            i3 = i5;
        }
        this.f45713j1 = new VideoSize(i3, integer, f3);
        VideoSink videoSink = this.T0;
        if (videoSink == null || !this.f45722s1) {
            this.L0.p(format.f40641x);
        } else {
            i2(videoSink, 1, format.b().B0(i3).d0(integer).q0(f3).N());
        }
        this.f45722s1 = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation v0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationE = mediaCodecInfo.e(format, format2);
        int i3 = decoderReuseEvaluationE.f42877e;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Assertions.e(this.Q0);
        if (format2.f40639v > codecMaxValues.f45743a || format2.f40640w > codecMaxValues.f45744b) {
            i3 |= Function.MAX_NARGS;
        }
        if (t2(mediaCodecInfo, format2) > codecMaxValues.f45745c) {
            i3 |= 64;
        }
        int i4 = i3;
        return new DecoderReuseEvaluation(mediaCodecInfo.f44264a, format, format2, i4 != 0 ? 0 : decoderReuseEvaluationE.f42876d, i4);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void v1(long j3) {
        super.v1(j3);
        if (this.f45716m1) {
            return;
        }
        this.f45709f1--;
    }

    protected MediaFormat v2(Format format, String str, CodecMaxValues codecMaxValues, float f3, boolean z2, int i3) {
        Pair pairJ;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, format.f40639v);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, format.f40640w);
        MediaFormatUtil.u(mediaFormat, format.f40635r);
        MediaFormatUtil.o(mediaFormat, "frame-rate", format.f40641x);
        MediaFormatUtil.p(mediaFormat, "rotation-degrees", format.f40642y);
        MediaFormatUtil.n(mediaFormat, format.C);
        if ("video/dolby-vision".equals(format.f40632o) && (pairJ = MediaCodecUtil.j(format)) != null) {
            MediaFormatUtil.p(mediaFormat, "profile", ((Integer) pairJ.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.f45743a);
        mediaFormat.setInteger("max-height", codecMaxValues.f45744b);
        MediaFormatUtil.p(mediaFormat, "max-input-size", codecMaxValues.f45745c);
        int i4 = Util.f41609a;
        if (i4 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f3 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f3);
            }
        }
        if (z2) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i3 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i3);
        }
        if (i4 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.f45715l1));
        }
        return mediaFormat;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void w(int i3, Object obj) throws ExoPlaybackException {
        if (i3 == 1) {
            S2(obj);
            return;
        }
        if (i3 == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Assertions.e(obj);
            this.f45719p1 = videoFrameMetadataListener;
            VideoSink videoSink = this.T0;
            if (videoSink != null) {
                videoSink.g(videoFrameMetadataListener);
                return;
            }
            return;
        }
        if (i3 == 10) {
            int iIntValue = ((Integer) Assertions.e(obj)).intValue();
            if (this.f45717n1 != iIntValue) {
                this.f45717n1 = iIntValue;
                if (this.f45716m1) {
                    E1();
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 4) {
            this.f45704a1 = ((Integer) Assertions.e(obj)).intValue();
            MediaCodecAdapter mediaCodecAdapterO0 = O0();
            if (mediaCodecAdapterO0 != null) {
                mediaCodecAdapterO0.j(this.f45704a1);
                return;
            }
            return;
        }
        if (i3 == 5) {
            int iIntValue2 = ((Integer) Assertions.e(obj)).intValue();
            this.f45705b1 = iIntValue2;
            VideoSink videoSink2 = this.T0;
            if (videoSink2 != null) {
                videoSink2.t(iIntValue2);
                return;
            } else {
                this.L0.n(iIntValue2);
                return;
            }
        }
        if (i3 == 13) {
            V2((List) Assertions.e(obj));
            return;
        }
        if (i3 == 14) {
            Size size = (Size) Assertions.e(obj);
            if (size.b() == 0 || size.a() == 0) {
                return;
            }
            this.Y0 = size;
            VideoSink videoSink3 = this.T0;
            if (videoSink3 != null) {
                videoSink3.r((Surface) Assertions.i(this.W0), size);
                return;
            }
            return;
        }
        if (i3 == 16) {
            this.f45715l1 = ((Integer) Assertions.e(obj)).intValue();
            e3();
        } else {
            if (i3 != 17) {
                super.w(i3, obj);
                return;
            }
            Surface surface = this.W0;
            S2(null);
            ((MediaCodecVideoRenderer) Assertions.e(obj)).w(1, surface);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void w1() {
        super.w1();
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.c();
            this.T0.i(Z0(), o2());
        } else {
            this.L0.j();
        }
        this.f45722s1 = true;
        I2();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void x1(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (this.N0 != null && ((MediaCodecInfo) Assertions.e(Q0())).f44265b.equals("video/av01") && (byteBuffer = decoderInputBuffer.f42138d) != null) {
            this.N0.b(byteBuffer);
        }
        this.f45724u1 = 0;
        boolean z2 = this.f45716m1;
        if (!z2) {
            this.f45709f1++;
        }
        if (Util.f41609a >= 23 || !z2) {
            return;
        }
        L2(decoderInputBuffer.f42140g);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    protected void y1(Renderer.WakeupListener wakeupListener) {
        VideoSink videoSink = this.T0;
        if (videoSink != null) {
            videoSink.k(wakeupListener);
        }
    }

    private static boolean n2() {
        String str;
        int i3 = Util.f41609a;
        byte b3 = 7;
        if (i3 <= 28) {
            String str2 = Build.DEVICE;
            str2.getClass();
            switch (str2) {
            }
            return true;
        }
        if (i3 <= 27 && "HWEML".equals(Build.DEVICE)) {
            return true;
        }
        str = Build.MODEL;
        str.getClass();
        switch (str) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                break;
            default:
                if (i3 <= 26) {
                    String str3 = Build.DEVICE;
                    str3.getClass();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            b3 = !str3.equals("GIONEE_SWW1609") ? (byte) -1 : (byte) 0;
                            break;
                        case -2144781185:
                            b3 = !str3.equals("GIONEE_SWW1627") ? (byte) -1 : (byte) 1;
                            break;
                        case -2144781160:
                            b3 = !str3.equals("GIONEE_SWW1631") ? (byte) -1 : (byte) 2;
                            break;
                        case -2097309513:
                            b3 = !str3.equals("K50a40") ? (byte) -1 : (byte) 3;
                            break;
                        case -2022874474:
                            b3 = !str3.equals("CP8676_I02") ? (byte) -1 : (byte) 4;
                            break;
                        case -1978993182:
                            b3 = !str3.equals("NX541J") ? (byte) -1 : (byte) 5;
                            break;
                        case -1978990237:
                            b3 = !str3.equals("NX573J") ? (byte) -1 : (byte) 6;
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                                b3 = -1;
                            }
                            break;
                        case -1936688066:
                            b3 = !str3.equals("PGN610") ? (byte) -1 : (byte) 8;
                            break;
                        case -1936688065:
                            b3 = !str3.equals("PGN611") ? (byte) -1 : (byte) 9;
                            break;
                        case -1931988508:
                            b3 = !str3.equals("AquaPowerM") ? (byte) -1 : (byte) 10;
                            break;
                        case -1885099851:
                            b3 = !str3.equals("RAIJIN") ? (byte) -1 : Ascii.VT;
                            break;
                        case -1696512866:
                            b3 = !str3.equals("XT1663") ? (byte) -1 : Ascii.FF;
                            break;
                        case -1680025915:
                            b3 = !str3.equals("ComioS1") ? (byte) -1 : Ascii.CR;
                            break;
                        case -1615810839:
                            b3 = !str3.equals("Phantom6") ? (byte) -1 : Ascii.SO;
                            break;
                        case -1600724499:
                            b3 = !str3.equals("pacificrim") ? (byte) -1 : Ascii.SI;
                            break;
                        case -1554255044:
                            b3 = !str3.equals("vernee_M5") ? (byte) -1 : Ascii.DLE;
                            break;
                        case -1481772737:
                            b3 = !str3.equals("panell_dl") ? (byte) -1 : (byte) 17;
                            break;
                        case -1481772730:
                            b3 = !str3.equals("panell_ds") ? (byte) -1 : Ascii.DC2;
                            break;
                        case -1481772729:
                            b3 = !str3.equals("panell_dt") ? (byte) -1 : (byte) 19;
                            break;
                        case -1320080169:
                            b3 = !str3.equals("GiONEE_GBL7319") ? (byte) -1 : Ascii.DC4;
                            break;
                        case -1217592143:
                            b3 = !str3.equals("BRAVIA_ATV2") ? (byte) -1 : Ascii.NAK;
                            break;
                        case -1180384755:
                            b3 = !str3.equals("iris60") ? (byte) -1 : Ascii.SYN;
                            break;
                        case -1139198265:
                            b3 = !str3.equals("Slate_Pro") ? (byte) -1 : Ascii.ETB;
                            break;
                        case -1052835013:
                            b3 = !str3.equals("namath") ? (byte) -1 : Ascii.CAN;
                            break;
                        case -993250464:
                            b3 = !str3.equals("A10-70F") ? (byte) -1 : Ascii.EM;
                            break;
                        case -993250458:
                            b3 = !str3.equals("A10-70L") ? (byte) -1 : (byte) 26;
                            break;
                        case -965403638:
                            b3 = !str3.equals("s905x018") ? (byte) -1 : (byte) 27;
                            break;
                        case -958336948:
                            b3 = !str3.equals("ELUGA_Ray_X") ? (byte) -1 : (byte) 28;
                            break;
                        case -879245230:
                            b3 = !str3.equals("tcl_eu") ? (byte) -1 : Ascii.GS;
                            break;
                        case -842500323:
                            b3 = !str3.equals("nicklaus_f") ? (byte) -1 : Ascii.RS;
                            break;
                        case -821392978:
                            b3 = !str3.equals("A7000-a") ? (byte) -1 : Ascii.US;
                            break;
                        case -797483286:
                            b3 = !str3.equals("SVP-DTV15") ? (byte) -1 : (byte) 32;
                            break;
                        case -794946968:
                            b3 = !str3.equals("watson") ? (byte) -1 : Framer.ENTER_FRAME_PREFIX;
                            break;
                        case -788334647:
                            b3 = !str3.equals("whyred") ? (byte) -1 : (byte) 34;
                            break;
                        case -782144577:
                            b3 = !str3.equals("OnePlus5T") ? (byte) -1 : (byte) 35;
                            break;
                        case -575125681:
                            b3 = !str3.equals("GiONEE_CBL7513") ? (byte) -1 : (byte) 36;
                            break;
                        case -521118391:
                            b3 = !str3.equals("GIONEE_GBL7360") ? (byte) -1 : (byte) 37;
                            break;
                        case -430914369:
                            b3 = !str3.equals("Pixi4-7_3G") ? (byte) -1 : (byte) 38;
                            break;
                        case -290434366:
                            b3 = !str3.equals("taido_row") ? (byte) -1 : (byte) 39;
                            break;
                        case -282781963:
                            b3 = !str3.equals("BLACK-1X") ? (byte) -1 : (byte) 40;
                            break;
                        case -277133239:
                            b3 = !str3.equals("Z12_PRO") ? (byte) -1 : (byte) 41;
                            break;
                        case -173639913:
                            b3 = !str3.equals("ELUGA_A3_Pro") ? (byte) -1 : (byte) 42;
                            break;
                        case -56598463:
                            b3 = !str3.equals("woods_fn") ? (byte) -1 : (byte) 43;
                            break;
                        case 2126:
                            b3 = !str3.equals("C1") ? (byte) -1 : (byte) 44;
                            break;
                        case 2564:
                            b3 = !str3.equals("Q5") ? (byte) -1 : Framer.STDIN_FRAME_PREFIX;
                            break;
                        case 2715:
                            b3 = !str3.equals("V1") ? (byte) -1 : (byte) 46;
                            break;
                        case 2719:
                            b3 = !str3.equals("V5") ? (byte) -1 : (byte) 47;
                            break;
                        case 3091:
                            b3 = !str3.equals("b5") ? (byte) -1 : (byte) 48;
                            break;
                        case 3483:
                            b3 = !str3.equals("mh") ? (byte) -1 : Framer.STDOUT_FRAME_PREFIX;
                            break;
                        case 73405:
                            b3 = !str3.equals("JGZ") ? (byte) -1 : Framer.STDERR_FRAME_PREFIX;
                            break;
                        case 75537:
                            b3 = !str3.equals("M04") ? (byte) -1 : (byte) 51;
                            break;
                        case 75739:
                            b3 = !str3.equals("M5c") ? (byte) -1 : (byte) 52;
                            break;
                        case 76779:
                            b3 = !str3.equals(CbYNFSEGaQj.DXdD) ? (byte) -1 : (byte) 53;
                            break;
                        case 78669:
                            b3 = !str3.equals("P85") ? (byte) -1 : (byte) 54;
                            break;
                        case 79305:
                            b3 = !str3.equals("PLE") ? (byte) -1 : (byte) 55;
                            break;
                        case 80618:
                            b3 = !str3.equals("QX1") ? (byte) -1 : (byte) 56;
                            break;
                        case 88274:
                            b3 = !str3.equals("Z80") ? (byte) -1 : (byte) 57;
                            break;
                        case 98846:
                            b3 = !str3.equals("cv1") ? (byte) -1 : (byte) 58;
                            break;
                        case 98848:
                            b3 = !str3.equals("cv3") ? (byte) -1 : (byte) 59;
                            break;
                        case 99329:
                            b3 = !str3.equals("deb") ? (byte) -1 : (byte) 60;
                            break;
                        case 101481:
                            b3 = !str3.equals("flo") ? (byte) -1 : (byte) 61;
                            break;
                        case 1513190:
                            b3 = !str3.equals("1601") ? (byte) -1 : (byte) 62;
                            break;
                        case 1514184:
                            b3 = !str3.equals("1713") ? (byte) -1 : (byte) 63;
                            break;
                        case 1514185:
                            b3 = !str3.equals("1714") ? (byte) -1 : (byte) 64;
                            break;
                        case 2133089:
                            b3 = !str3.equals("F01H") ? (byte) -1 : (byte) 65;
                            break;
                        case 2133091:
                            b3 = !str3.equals("F01J") ? (byte) -1 : (byte) 66;
                            break;
                        case 2133120:
                            b3 = !str3.equals("F02H") ? (byte) -1 : (byte) 67;
                            break;
                        case 2133151:
                            b3 = !str3.equals("F03H") ? (byte) -1 : (byte) 68;
                            break;
                        case 2133182:
                            b3 = !str3.equals("F04H") ? (byte) -1 : (byte) 69;
                            break;
                        case 2133184:
                            b3 = !str3.equals("F04J") ? (byte) -1 : (byte) 70;
                            break;
                        case 2436959:
                            b3 = !str3.equals("P681") ? (byte) -1 : (byte) 71;
                            break;
                        case 2463773:
                            b3 = !str3.equals("Q350") ? (byte) -1 : (byte) 72;
                            break;
                        case 2464648:
                            b3 = !str3.equals("Q427") ? (byte) -1 : (byte) 73;
                            break;
                        case 2689555:
                            b3 = !str3.equals("XE2X") ? (byte) -1 : (byte) 74;
                            break;
                        case 3154429:
                            b3 = !str3.equals("fugu") ? (byte) -1 : (byte) 75;
                            break;
                        case 3284551:
                            b3 = !str3.equals("kate") ? (byte) -1 : (byte) 76;
                            break;
                        case 3351335:
                            b3 = !str3.equals("mido") ? (byte) -1 : (byte) 77;
                            break;
                        case 3386211:
                            b3 = !str3.equals("p212") ? (byte) -1 : (byte) 78;
                            break;
                        case 41325051:
                            b3 = !str3.equals("MEIZU_M5") ? (byte) -1 : (byte) 79;
                            break;
                        case 51349633:
                            b3 = !str3.equals("601LV") ? (byte) -1 : (byte) 80;
                            break;
                        case 51350594:
                            b3 = !str3.equals("602LV") ? (byte) -1 : (byte) 81;
                            break;
                        case 55178625:
                            b3 = !str3.equals("Aura_Note_2") ? (byte) -1 : (byte) 82;
                            break;
                        case 61542055:
                            b3 = !str3.equals("A1601") ? (byte) -1 : (byte) 83;
                            break;
                        case 65355429:
                            b3 = !str3.equals("E5643") ? (byte) -1 : (byte) 84;
                            break;
                        case 66214468:
                            b3 = !str3.equals("F3111") ? (byte) -1 : (byte) 85;
                            break;
                        case 66214470:
                            b3 = !str3.equals("F3113") ? (byte) -1 : (byte) 86;
                            break;
                        case 66214473:
                            b3 = !str3.equals("F3116") ? (byte) -1 : (byte) 87;
                            break;
                        case 66215429:
                            b3 = !str3.equals("F3211") ? (byte) -1 : (byte) 88;
                            break;
                        case 66215431:
                            b3 = !str3.equals("F3213") ? (byte) -1 : (byte) 89;
                            break;
                        case 66215433:
                            b3 = !str3.equals("F3215") ? (byte) -1 : (byte) 90;
                            break;
                        case 66216390:
                            b3 = !str3.equals("F3311") ? (byte) -1 : (byte) 91;
                            break;
                        case 76402249:
                            b3 = !str3.equals("PRO7S") ? (byte) -1 : (byte) 92;
                            break;
                        case 76404105:
                            b3 = !str3.equals("Q4260") ? (byte) -1 : (byte) 93;
                            break;
                        case 76404911:
                            b3 = !str3.equals("Q4310") ? (byte) -1 : (byte) 94;
                            break;
                        case 80963634:
                            b3 = !str3.equals("V23GB") ? (byte) -1 : Framer.STDIN_REQUEST_FRAME_PREFIX;
                            break;
                        case 82882791:
                            b3 = !str3.equals("X3_HK") ? (byte) -1 : (byte) 96;
                            break;
                        case 98715550:
                            b3 = !str3.equals("i9031") ? (byte) -1 : (byte) 97;
                            break;
                        case 101370885:
                            b3 = !str3.equals("l5460") ? (byte) -1 : (byte) 98;
                            break;
                        case 102844228:
                            b3 = !str3.equals("le_x6") ? (byte) -1 : (byte) 99;
                            break;
                        case 165221241:
                            b3 = !str3.equals("A2016a40") ? (byte) -1 : (byte) 100;
                            break;
                        case 182191441:
                            b3 = !str3.equals("CPY83_I00") ? (byte) -1 : (byte) 101;
                            break;
                        case 245388979:
                            b3 = !str3.equals("marino_f") ? (byte) -1 : (byte) 102;
                            break;
                        case 287431619:
                            b3 = !str3.equals("griffin") ? (byte) -1 : (byte) 103;
                            break;
                        case 307593612:
                            b3 = !str3.equals("A7010a48") ? (byte) -1 : (byte) 104;
                            break;
                        case 308517133:
                            b3 = !str3.equals("A7020a48") ? (byte) -1 : (byte) 105;
                            break;
                        case 316215098:
                            b3 = !str3.equals("TB3-730F") ? (byte) -1 : (byte) 106;
                            break;
                        case 316215116:
                            b3 = !str3.equals("TB3-730X") ? (byte) -1 : (byte) 107;
                            break;
                        case 316246811:
                            b3 = !str3.equals("TB3-850F") ? (byte) -1 : (byte) 108;
                            break;
                        case 316246818:
                            b3 = !str3.equals("TB3-850M") ? (byte) -1 : (byte) 109;
                            break;
                        case 407160593:
                            b3 = !str3.equals("Pixi5-10_4G") ? (byte) -1 : (byte) 110;
                            break;
                        case 507412548:
                            b3 = !str3.equals("QM16XE_U") ? (byte) -1 : (byte) 111;
                            break;
                        case 793982701:
                            b3 = !str3.equals("GIONEE_WBL5708") ? (byte) -1 : (byte) 112;
                            break;
                        case 794038622:
                            b3 = !str3.equals("GIONEE_WBL7365") ? (byte) -1 : (byte) 113;
                            break;
                        case 794040393:
                            b3 = !str3.equals("GIONEE_WBL7519") ? (byte) -1 : (byte) 114;
                            break;
                        case 835649806:
                            b3 = !str3.equals("manning") ? (byte) -1 : (byte) 115;
                            break;
                        case 917340916:
                            b3 = !str3.equals("A7000plus") ? (byte) -1 : (byte) 116;
                            break;
                        case 958008161:
                            b3 = !str3.equals("j2xlteins") ? (byte) -1 : (byte) 117;
                            break;
                        case 1060579533:
                            b3 = !str3.equals("panell_d") ? (byte) -1 : (byte) 118;
                            break;
                        case 1150207623:
                            b3 = !str3.equals("LS-5017") ? (byte) -1 : (byte) 119;
                            break;
                        case 1176899427:
                            b3 = !str3.equals("itel_S41") ? (byte) -1 : Framer.EXIT_FRAME_PREFIX;
                            break;
                        case 1280332038:
                            b3 = !str3.equals("hwALE-H") ? (byte) -1 : (byte) 121;
                            break;
                        case 1306947716:
                            b3 = !str3.equals("EverStar_S") ? (byte) -1 : (byte) 122;
                            break;
                        case 1349174697:
                            b3 = !str3.equals("htc_e56ml_dtul") ? (byte) -1 : (byte) 123;
                            break;
                        case 1522194893:
                            b3 = !str3.equals("woods_f") ? (byte) -1 : (byte) 124;
                            break;
                        case 1691543273:
                            b3 = !str3.equals("CPH1609") ? (byte) -1 : (byte) 125;
                            break;
                        case 1691544261:
                            b3 = !str3.equals("CPH1715") ? (byte) -1 : (byte) 126;
                            break;
                        case 1709443163:
                            b3 = !str3.equals("iball8735_9806") ? (byte) -1 : Ascii.DEL;
                            break;
                        case 1865889110:
                            b3 = !str3.equals("santoni") ? (byte) -1 : (byte) 128;
                            break;
                        case 1906253259:
                            b3 = !str3.equals("PB2-670M") ? (byte) -1 : (byte) 129;
                            break;
                        case 1977196784:
                            b3 = !str3.equals("Infinix-X572") ? (byte) -1 : (byte) 130;
                            break;
                        case 2006372676:
                            b3 = !str3.equals("BRAVIA_ATV3_4K") ? (byte) -1 : (byte) 131;
                            break;
                        case 2019281702:
                            b3 = !str3.equals("DM-01K") ? (byte) -1 : (byte) 132;
                            break;
                        case 2029784656:
                            b3 = !str3.equals("HWBLN-H") ? (byte) -1 : (byte) 133;
                            break;
                        case 2030379515:
                            b3 = !str3.equals("HWCAM-H") ? (byte) -1 : (byte) 134;
                            break;
                        case 2033393791:
                            b3 = !str3.equals("ASUS_X00AD_2") ? (byte) -1 : (byte) 135;
                            break;
                        case 2047190025:
                            b3 = !str3.equals("ELUGA_Note") ? (byte) -1 : (byte) 136;
                            break;
                        case 2047252157:
                            b3 = !str3.equals("ELUGA_Prim") ? (byte) -1 : (byte) 137;
                            break;
                        case 2048319463:
                            b3 = !str3.equals("HWVNS-H") ? (byte) -1 : (byte) 138;
                            break;
                        case 2048855701:
                            b3 = !str3.equals("HWWAS-H") ? (byte) -1 : (byte) 139;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        default:
                            str.getClass();
                            if (!str.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case 127:
                        case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
                        case 129:
                        case 130:
                        case 131:
                        case 132:
                        case 133:
                        case 134:
                        case 135:
                        case 136:
                        case 137:
                        case 138:
                        case 139:
                            return true;
                    }
                }
                break;
        }
        return true;
    }
}
