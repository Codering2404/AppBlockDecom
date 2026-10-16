package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.ToInt16PcmAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackPositionTracker;
import androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static boolean f43769l0 = false;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final Object f43770m0 = new Object();

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static ScheduledExecutorService f43771n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static int f43772o0;
    private OnRoutingChangedListenerApi24 A;
    private AudioAttributes B;
    private MediaPositionParameters C;
    private MediaPositionParameters D;
    private PlaybackParameters E;
    private boolean F;
    private ByteBuffer G;
    private int H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;
    private boolean N;
    private boolean O;
    private long P;
    private float Q;
    private ByteBuffer R;
    private int S;
    private ByteBuffer T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f43773a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private AuxEffectInfo f43774a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.audio.AudioProcessorChain f43775b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private AudioDeviceInfoApi23 f43776b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f43777c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f43778c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ChannelMappingAudioProcessor f43779d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private long f43780d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TrimmingAudioProcessor f43781e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f43782e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableList f43783f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f43784f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImmutableList f43785g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private boolean f43786g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AudioTrackPositionTracker f43787h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private Looper f43788h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ArrayDeque f43789i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private long f43790i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f43791j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private long f43792j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f43793k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private Handler f43794k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private StreamEventCallbackV29 f43795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PendingExceptionHolder f43796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final PendingExceptionHolder f43797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AudioTrackBufferSizeProvider f43798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AudioOffloadSupportProvider f43799p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ExoPlayer.AudioOffloadListener f43800q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AudioTrackProvider f43801r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private PlayerId f43802s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AudioSink.Listener f43803t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Configuration f43804u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Configuration f43805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AudioProcessingPipeline f43806w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private AudioTrack f43807x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private AudioCapabilities f43808y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AudioCapabilitiesReceiver f43809z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        public static long a(AudioTrack audioTrack, Configuration configuration) {
            return configuration.f43824c == 0 ? configuration.d(audioTrack.getBufferSizeInFrames()) : Util.b1(audioTrack.getBufferSizeInFrames(), 1000000L, DefaultAudioTrackBufferSizeProvider.d(configuration.f43828g), RoundingMode.DOWN);
        }

        public static void b(AudioTrack audioTrack, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            audioTrack.setPreferredDevice(audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.f43692a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31 {
        public static void a(AudioTrack audioTrack, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AudioOffloadSupportProvider {
        AudioOffloadSupport a(Format format, AudioAttributes audioAttributes);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface AudioProcessorChain extends androidx.media3.common.audio.AudioProcessorChain {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AudioTrackBufferSizeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioTrackBufferSizeProvider f43810a = new DefaultAudioTrackBufferSizeProvider.Builder().h();

        int a(int i3, int i4, int i5, int i6, int i7, int i8, double d3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AudioTrackProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioTrackProvider f43811a = new DefaultAudioTrackProvider();

        AudioTrack a(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f43812a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private androidx.media3.common.audio.AudioProcessorChain f43814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f43815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f43816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f43817f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private AudioOffloadSupportProvider f43820i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ExoPlayer.AudioOffloadListener f43821j;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AudioCapabilities f43813b = AudioCapabilities.f43668c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private AudioTrackBufferSizeProvider f43818g = AudioTrackBufferSizeProvider.f43810a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private AudioTrackProvider f43819h = AudioTrackProvider.f43811a;

        public Builder(Context context) {
            this.f43812a = context;
        }

        public DefaultAudioSink j() {
            Assertions.g(!this.f43817f);
            this.f43817f = true;
            if (this.f43814c == null) {
                this.f43814c = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            if (this.f43820i == null) {
                this.f43820i = new DefaultAudioOffloadSupportProvider(this.f43812a);
            }
            return new DefaultAudioSink(this);
        }

        public Builder k(boolean z2) {
            this.f43816e = z2;
            return this;
        }

        public Builder l(boolean z2) {
            this.f43815d = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Configuration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f43822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f43825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f43826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f43827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f43828g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f43829h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AudioProcessingPipeline f43830i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f43831j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f43832k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f43833l;

        public Configuration(Format format, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AudioProcessingPipeline audioProcessingPipeline, boolean z2, boolean z3, boolean z4) {
            this.f43822a = format;
            this.f43823b = i3;
            this.f43824c = i4;
            this.f43825d = i5;
            this.f43826e = i6;
            this.f43827f = i7;
            this.f43828g = i8;
            this.f43829h = i9;
            this.f43830i = audioProcessingPipeline;
            this.f43831j = z2;
            this.f43832k = z3;
            this.f43833l = z4;
        }

        public AudioSink.AudioTrackConfig a() {
            return new AudioSink.AudioTrackConfig(this.f43828g, this.f43826e, this.f43827f, this.f43833l, this.f43824c == 1, this.f43829h);
        }

        public boolean b(Configuration configuration) {
            return configuration.f43824c == this.f43824c && configuration.f43828g == this.f43828g && configuration.f43826e == this.f43826e && configuration.f43827f == this.f43827f && configuration.f43825d == this.f43825d && configuration.f43831j == this.f43831j && configuration.f43832k == this.f43832k;
        }

        public Configuration c(int i3) {
            return new Configuration(this.f43822a, this.f43823b, this.f43824c, this.f43825d, this.f43826e, this.f43827f, this.f43828g, i3, this.f43830i, this.f43831j, this.f43832k, this.f43833l);
        }

        public long d(long j3) {
            return Util.Y0(j3, this.f43826e);
        }

        public long e(long j3) {
            return Util.Y0(j3, this.f43822a.F);
        }

        public boolean f() {
            return this.f43824c == 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DefaultAudioProcessorChain implements AudioProcessorChain {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioProcessor[] f43834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SilenceSkippingAudioProcessor f43835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SonicAudioProcessor f43836c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        @Override // androidx.media3.common.audio.AudioProcessorChain
        public long a(long j3) {
            return this.f43836c.isActive() ? this.f43836c.h(j3) : j3;
        }

        @Override // androidx.media3.common.audio.AudioProcessorChain
        public AudioProcessor[] b() {
            return this.f43834a;
        }

        @Override // androidx.media3.common.audio.AudioProcessorChain
        public PlaybackParameters c(PlaybackParameters playbackParameters) {
            this.f43836c.l(playbackParameters.f40953a);
            this.f43836c.k(playbackParameters.f40954b);
            return playbackParameters;
        }

        @Override // androidx.media3.common.audio.AudioProcessorChain
        public long d() {
            return this.f43835b.u();
        }

        @Override // androidx.media3.common.audio.AudioProcessorChain
        public boolean e(boolean z2) {
            this.f43835b.D(z2);
            return z2;
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f43834a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f43835b = silenceSkippingAudioProcessor;
            this.f43836c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaPositionParameters {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PlaybackParameters f43837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f43839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f43840d;

        private MediaPositionParameters(PlaybackParameters playbackParameters, long j3, long j4) {
            this.f43837a = playbackParameters;
            this.f43838b = j3;
            this.f43839c = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnRoutingChangedListenerApi24 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioTrack f43841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioCapabilitiesReceiver f43842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AudioRouting.OnRoutingChangedListener f43843c = new AudioRouting.OnRoutingChangedListener() { // from class: androidx.media3.exoplayer.audio.d0
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                this.f43921a.b(audioRouting);
            }
        };

        public OnRoutingChangedListenerApi24(AudioTrack audioTrack, AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
            this.f43841a = audioTrack;
            this.f43842b = audioCapabilitiesReceiver;
            audioTrack.addOnRoutingChangedListener(this.f43843c, new Handler(Looper.myLooper()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AudioRouting audioRouting) {
            AudioDeviceInfo routedDevice;
            if (this.f43843c == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
                return;
            }
            this.f43842b.i(routedDevice);
        }

        public void c() {
            this.f43841a.removeOnRoutingChangedListener((AudioRouting.OnRoutingChangedListener) Assertions.e(this.f43843c));
            this.f43843c = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PendingExceptionHolder<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Exception f43844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f43845b = -9223372036854775807L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f43846c = -9223372036854775807L;

        public void a() {
            this.f43844a = null;
            this.f43845b = -9223372036854775807L;
            this.f43846c = -9223372036854775807L;
        }

        public boolean b() {
            if (this.f43844a == null) {
                return false;
            }
            return DefaultAudioSink.Y() || SystemClock.elapsedRealtime() < this.f43846c;
        }

        public void c(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f43844a == null) {
                this.f43844a = exc;
            }
            if (this.f43845b == -9223372036854775807L && !DefaultAudioSink.Y()) {
                this.f43845b = 200 + jElapsedRealtime;
            }
            long j3 = this.f43845b;
            if (j3 == -9223372036854775807L || jElapsedRealtime < j3) {
                this.f43846c = jElapsedRealtime + 50;
                return;
            }
            Exception exc2 = this.f43844a;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = this.f43844a;
            a();
            throw exc3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioTrackPositionTracker.Listener
        public void a(int i3, long j3) {
            if (DefaultAudioSink.this.f43803t != null) {
                DefaultAudioSink.this.f43803t.h(i3, j3, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f43782e0);
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioTrackPositionTracker.Listener
        public void b(long j3) {
            if (DefaultAudioSink.this.f43803t != null) {
                DefaultAudioSink.this.f43803t.b(j3);
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioTrackPositionTracker.Listener
        public void c(long j3) {
            Log.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j3);
        }

        @Override // androidx.media3.exoplayer.audio.AudioTrackPositionTracker.Listener
        public void d(long j3, long j4, long j5, long j6) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j3 + ", " + j4 + ", " + j5 + ", " + j6 + ", " + DefaultAudioSink.this.V() + ", " + DefaultAudioSink.this.W();
            if (DefaultAudioSink.f43769l0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            Log.i("DefaultAudioSink", str);
        }

        @Override // androidx.media3.exoplayer.audio.AudioTrackPositionTracker.Listener
        public void e(long j3, long j4, long j5, long j6) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j3 + ", " + j4 + ", " + j5 + ", " + j6 + ", " + DefaultAudioSink.this.V() + ", " + DefaultAudioSink.this.W();
            if (DefaultAudioSink.f43769l0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            Log.i("DefaultAudioSink", str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class StreamEventCallbackV29 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f43848a = new Handler(Looper.myLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTrack$StreamEventCallback f43849b;

        public StreamEventCallbackV29() {
            this.f43849b = new AudioTrack$StreamEventCallback() { // from class: androidx.media3.exoplayer.audio.DefaultAudioSink.StreamEventCallbackV29.1
                public void onDataRequest(AudioTrack audioTrack, int i3) {
                    if (audioTrack.equals(DefaultAudioSink.this.f43807x) && DefaultAudioSink.this.f43803t != null && DefaultAudioSink.this.X) {
                        DefaultAudioSink.this.f43803t.k();
                    }
                }

                public void onPresentationEnded(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.f43807x)) {
                        DefaultAudioSink.this.W = true;
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.f43807x) && DefaultAudioSink.this.f43803t != null && DefaultAudioSink.this.X) {
                        DefaultAudioSink.this.f43803t.k();
                    }
                }
            };
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f43848a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new g0(handler), this.f43849b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f43849b);
            this.f43848a.removeCallbacksAndMessages(null);
        }
    }

    public static /* synthetic */ void C(AudioTrack audioTrack, final AudioSink.Listener listener, Handler handler, final AudioSink.AudioTrackConfig audioTrackConfig) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (listener != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        listener.c(audioTrackConfig);
                    }
                });
            }
            synchronized (f43770m0) {
                try {
                    int i3 = f43772o0 - 1;
                    f43772o0 = i3;
                    if (i3 == 0) {
                        f43771n0.shutdown();
                        f43771n0 = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            if (listener != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        listener.c(audioTrackConfig);
                    }
                });
            }
            synchronized (f43770m0) {
                try {
                    int i4 = f43772o0 - 1;
                    f43772o0 = i4;
                    if (i4 == 0) {
                        f43771n0.shutdown();
                        f43771n0 = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    private void L(long j3) {
        PlaybackParameters playbackParametersC;
        if (u0()) {
            playbackParametersC = PlaybackParameters.f40950d;
        } else {
            playbackParametersC = s0() ? this.f43775b.c(this.E) : PlaybackParameters.f40950d;
            this.E = playbackParametersC;
        }
        PlaybackParameters playbackParameters = playbackParametersC;
        this.F = s0() ? this.f43775b.e(this.F) : false;
        this.f43789i.add(new MediaPositionParameters(playbackParameters, Math.max(0L, j3), this.f43805v.d(W())));
        r0();
        AudioSink.Listener listener = this.f43803t;
        if (listener != null) {
            listener.d(this.F);
        }
    }

    private long M(long j3) {
        while (!this.f43789i.isEmpty() && j3 >= ((MediaPositionParameters) this.f43789i.getFirst()).f43839c) {
            this.D = (MediaPositionParameters) this.f43789i.remove();
        }
        MediaPositionParameters mediaPositionParameters = this.D;
        long j4 = j3 - mediaPositionParameters.f43839c;
        long jF0 = Util.f0(j4, mediaPositionParameters.f43837a.f40953a);
        if (!this.f43789i.isEmpty()) {
            MediaPositionParameters mediaPositionParameters2 = this.D;
            return mediaPositionParameters2.f43838b + jF0 + mediaPositionParameters2.f43840d;
        }
        long jA = this.f43775b.a(j4);
        MediaPositionParameters mediaPositionParameters3 = this.D;
        long j5 = mediaPositionParameters3.f43838b + jA;
        mediaPositionParameters3.f43840d = jA - jF0;
        return j5;
    }

    private long N(long j3) {
        long jD = this.f43775b.d();
        long jD2 = j3 + this.f43805v.d(jD);
        long j4 = this.f43790i0;
        if (jD > j4) {
            long jD3 = this.f43805v.d(jD - j4);
            this.f43790i0 = jD;
            X(jD3);
        }
        return jD2;
    }

    private AudioTrack O(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i3, Format format) throws AudioSink.InitializationException {
        try {
            AudioTrack audioTrackA = this.f43801r.a(audioTrackConfig, audioAttributes, i3);
            int state = audioTrackA.getState();
            if (state == 1) {
                return audioTrackA;
            }
            try {
                audioTrackA.release();
            } catch (Exception unused) {
            }
            throw new AudioSink.InitializationException(state, audioTrackConfig.f43703b, audioTrackConfig.f43704c, audioTrackConfig.f43702a, format, audioTrackConfig.f43706e, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e3) {
            throw new AudioSink.InitializationException(0, audioTrackConfig.f43703b, audioTrackConfig.f43704c, audioTrackConfig.f43702a, format, audioTrackConfig.f43706e, e3);
        }
    }

    private AudioTrack P(Configuration configuration) throws AudioSink.InitializationException {
        try {
            AudioTrack audioTrackO = O(configuration.a(), this.B, this.Z, configuration.f43822a);
            ExoPlayer.AudioOffloadListener audioOffloadListener = this.f43800q;
            if (audioOffloadListener == null) {
                return audioTrackO;
            }
            audioOffloadListener.C(c0(audioTrackO));
            return audioTrackO;
        } catch (AudioSink.InitializationException e3) {
            AudioSink.Listener listener = this.f43803t;
            if (listener != null) {
                listener.e(e3);
            }
            throw e3;
        }
    }

    private AudioTrack Q() throws AudioSink.InitializationException {
        try {
            return P((Configuration) Assertions.e(this.f43805v));
        } catch (AudioSink.InitializationException e3) {
            Configuration configuration = this.f43805v;
            if (configuration.f43829h > 1000000) {
                Configuration configurationC = configuration.c(1000000);
                try {
                    AudioTrack audioTrackP = P(configurationC);
                    this.f43805v = configurationC;
                    return audioTrackP;
                } catch (AudioSink.InitializationException e4) {
                    e3.addSuppressed(e4);
                    d0();
                    throw e3;
                }
            }
            d0();
            throw e3;
        }
    }

    private void R(long j3) throws Exception {
        DefaultAudioSink defaultAudioSink;
        int iV0;
        AudioSink.Listener listener;
        if (this.T == null || this.f43797n.b()) {
            return;
        }
        int iRemaining = this.T.remaining();
        if (this.f43778c0) {
            Assertions.g(j3 != -9223372036854775807L);
            if (j3 == Long.MIN_VALUE) {
                j3 = this.f43780d0;
            } else {
                this.f43780d0 = j3;
            }
            defaultAudioSink = this;
            iV0 = defaultAudioSink.w0(this.f43807x, this.T, iRemaining, j3);
        } else {
            defaultAudioSink = this;
            iV0 = v0(defaultAudioSink.f43807x, defaultAudioSink.T, iRemaining);
        }
        defaultAudioSink.f43782e0 = SystemClock.elapsedRealtime();
        if (iV0 < 0) {
            if (a0(iV0)) {
                if (W() > 0) {
                    z = true;
                } else if (c0(defaultAudioSink.f43807x)) {
                    d0();
                    z = true;
                }
            }
            AudioSink.WriteException writeException = new AudioSink.WriteException(iV0, defaultAudioSink.f43805v.f43822a, z);
            AudioSink.Listener listener2 = defaultAudioSink.f43803t;
            if (listener2 != null) {
                listener2.e(writeException);
            }
            if (!writeException.f43715b || defaultAudioSink.f43773a == null) {
                defaultAudioSink.f43797n.c(writeException);
                return;
            } else {
                defaultAudioSink.f43808y = AudioCapabilities.f43668c;
                throw writeException;
            }
        }
        defaultAudioSink.f43797n.a();
        if (c0(defaultAudioSink.f43807x)) {
            if (defaultAudioSink.L > 0) {
                defaultAudioSink.f43786g0 = false;
            }
            if (defaultAudioSink.X && (listener = defaultAudioSink.f43803t) != null && iV0 < iRemaining && !defaultAudioSink.f43786g0) {
                listener.g();
            }
        }
        int i3 = defaultAudioSink.f43805v.f43824c;
        if (i3 == 0) {
            defaultAudioSink.K += (long) iV0;
        }
        if (iV0 == iRemaining) {
            if (i3 != 0) {
                Assertions.g(defaultAudioSink.T == defaultAudioSink.R);
                defaultAudioSink.L += ((long) defaultAudioSink.M) * ((long) defaultAudioSink.S);
            }
            defaultAudioSink.T = null;
        }
    }

    private boolean S() throws Exception {
        ByteBuffer byteBuffer;
        if (!this.f43806w.g()) {
            R(Long.MIN_VALUE);
            return this.T == null;
        }
        this.f43806w.i();
        j0(Long.MIN_VALUE);
        return this.f43806w.f() && ((byteBuffer = this.T) == null || !byteBuffer.hasRemaining());
    }

    private static int T(int i3, int i4, int i5) {
        int minBufferSize = AudioTrack.getMinBufferSize(i3, i4, i5);
        Assertions.g(minBufferSize != -2);
        return minBufferSize;
    }

    private static int U(int i3, ByteBuffer byteBuffer) {
        if (i3 == 20) {
            return OpusUtil.h(byteBuffer);
        }
        if (i3 != 30) {
            switch (i3) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iM = MpegAudioUtil.m(Util.S(byteBuffer, byteBuffer.position()));
                    if (iM != -1) {
                        return iM;
                    }
                    throw new IllegalArgumentException();
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i3) {
                        case 14:
                            int iB = Ac3Util.b(byteBuffer);
                            if (iB == -1) {
                                return 0;
                            }
                            return Ac3Util.i(byteBuffer, iB) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            return Ac4Util.e(byteBuffer);
                        case 18:
                            break;
                        default:
                            throw new IllegalStateException("Unexpected audio encoding: " + i3);
                    }
                    break;
            }
            return Ac3Util.e(byteBuffer);
        }
        return DtsUtil.f(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V() {
        Configuration configuration = this.f43805v;
        return configuration.f43824c == 0 ? this.I / ((long) configuration.f43823b) : this.J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long W() {
        return this.f43805v.f43824c == 0 ? Util.n(this.K, r0.f43825d) : this.L;
    }

    private void X(long j3) {
        this.f43792j0 += j3;
        if (this.f43794k0 == null) {
            this.f43794k0 = new Handler(Looper.myLooper());
        }
        this.f43794k0.removeCallbacksAndMessages(null);
        this.f43794k0.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.audio.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f43956a.f0();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Y() {
        boolean z2;
        synchronized (f43770m0) {
            z2 = f43772o0 > 0;
        }
        return z2;
    }

    private boolean Z() throws AudioSink.InitializationException {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver;
        PlayerId playerId;
        if (this.f43796m.b()) {
            return false;
        }
        AudioTrack audioTrackQ = Q();
        this.f43807x = audioTrackQ;
        if (c0(audioTrackQ)) {
            k0(this.f43807x);
            Configuration configuration = this.f43805v;
            if (configuration.f43832k) {
                AudioTrack audioTrack = this.f43807x;
                Format format = configuration.f43822a;
                audioTrack.setOffloadDelayPadding(format.H, format.I);
            }
        }
        int i3 = Util.f41609a;
        if (i3 >= 31 && (playerId = this.f43802s) != null) {
            Api31.a(this.f43807x, playerId);
        }
        this.Z = this.f43807x.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker = this.f43787h;
        AudioTrack audioTrack2 = this.f43807x;
        Configuration configuration2 = this.f43805v;
        audioTrackPositionTracker.s(audioTrack2, configuration2.f43824c == 2, configuration2.f43828g, configuration2.f43825d, configuration2.f43829h);
        q0();
        int i4 = this.f43774a0.f40536a;
        if (i4 != 0) {
            this.f43807x.attachAuxEffect(i4);
            this.f43807x.setAuxEffectSendLevel(this.f43774a0.f40537b);
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.f43776b0;
        if (audioDeviceInfoApi23 != null && i3 >= 23) {
            Api23.b(this.f43807x, audioDeviceInfoApi23);
            AudioCapabilitiesReceiver audioCapabilitiesReceiver2 = this.f43809z;
            if (audioCapabilitiesReceiver2 != null) {
                audioCapabilitiesReceiver2.i(this.f43776b0.f43692a);
            }
        }
        if (i3 >= 24 && (audioCapabilitiesReceiver = this.f43809z) != null) {
            this.A = new OnRoutingChangedListenerApi24(this.f43807x, audioCapabilitiesReceiver);
        }
        this.O = true;
        AudioSink.Listener listener = this.f43803t;
        if (listener != null) {
            listener.a(this.f43805v.a());
        }
        return true;
    }

    private static boolean a0(int i3) {
        return (Util.f41609a >= 24 && i3 == -6) || i3 == -32;
    }

    private boolean b0() {
        return this.f43807x != null;
    }

    private static boolean c0(AudioTrack audioTrack) {
        return Util.f41609a >= 29 && audioTrack.isOffloadedPlayback();
    }

    private void d0() {
        if (this.f43805v.f()) {
            this.f43784f0 = true;
        }
    }

    private ByteBuffer e0(ByteBuffer byteBuffer) {
        if (this.f43805v.f43824c == 0) {
            int I = (int) Util.I(Util.P0(20L), this.f43805v.f43826e);
            long jW = W();
            if (jW < I) {
                Configuration configuration = this.f43805v;
                return PcmAudioUtil.a(byteBuffer, configuration.f43828g, configuration.f43825d, (int) jW, I);
            }
        }
        return byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        if (this.f43792j0 >= 300000) {
            this.f43803t.f();
            this.f43792j0 = 0L;
        }
    }

    private void g0() {
        if (this.f43809z == null && this.f43773a != null) {
            this.f43788h0 = Looper.myLooper();
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = new AudioCapabilitiesReceiver(this.f43773a, new AudioCapabilitiesReceiver.Listener() { // from class: androidx.media3.exoplayer.audio.a0
                @Override // androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver.Listener
                public final void a(AudioCapabilities audioCapabilities) {
                    this.f43918a.h0(audioCapabilities);
                }
            }, this.B, this.f43776b0);
            this.f43809z = audioCapabilitiesReceiver;
            this.f43808y = audioCapabilitiesReceiver.g();
        }
        Assertions.e(this.f43808y);
    }

    private void i0() {
        if (this.V) {
            return;
        }
        this.V = true;
        this.f43787h.g(W());
        if (c0(this.f43807x)) {
            this.W = false;
        }
        this.f43807x.stop();
        this.H = 0;
    }

    private void j0(long j3) throws Exception {
        R(j3);
        if (this.T != null) {
            return;
        }
        if (!this.f43806w.g()) {
            ByteBuffer byteBuffer = this.R;
            if (byteBuffer != null) {
                p0(byteBuffer);
                R(j3);
                return;
            }
            return;
        }
        while (!this.f43806w.f()) {
            do {
                ByteBuffer byteBufferD = this.f43806w.d();
                if (byteBufferD.hasRemaining()) {
                    p0(byteBufferD);
                    R(j3);
                } else {
                    ByteBuffer byteBuffer2 = this.R;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.f43806w.j(this.R);
                    }
                }
            } while (this.T == null);
            return;
        }
    }

    private void k0(AudioTrack audioTrack) {
        if (this.f43795l == null) {
            this.f43795l = new StreamEventCallbackV29();
        }
        this.f43795l.a(audioTrack);
    }

    private static void l0(final AudioTrack audioTrack, final AudioSink.Listener listener, final AudioSink.AudioTrackConfig audioTrackConfig) {
        final Handler handler = new Handler(Looper.myLooper());
        synchronized (f43770m0) {
            try {
                if (f43771n0 == null) {
                    f43771n0 = Util.R0("ExoPlayer:AudioTrackReleaseThread");
                }
                f43772o0++;
                f43771n0.schedule(new Runnable() { // from class: androidx.media3.exoplayer.audio.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultAudioSink.C(audioTrack, listener, handler, audioTrackConfig);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m0() {
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.f43786g0 = false;
        this.M = 0;
        this.D = new MediaPositionParameters(this.E, 0L, 0L);
        this.P = 0L;
        this.C = null;
        this.f43789i.clear();
        this.R = null;
        this.S = 0;
        this.T = null;
        this.V = false;
        this.U = false;
        this.W = false;
        this.G = null;
        this.H = 0;
        this.f43781e.n();
        r0();
    }

    private void n0(PlaybackParameters playbackParameters) {
        MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(playbackParameters, -9223372036854775807L, -9223372036854775807L);
        if (b0()) {
            this.C = mediaPositionParameters;
        } else {
            this.D = mediaPositionParameters;
        }
    }

    private void o0() {
        if (b0()) {
            try {
                this.f43807x.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.E.f40953a).setPitch(this.E.f40954b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e3) {
                Log.j("DefaultAudioSink", "Failed to set playback params", e3);
            }
            PlaybackParameters playbackParameters = new PlaybackParameters(this.f43807x.getPlaybackParams().getSpeed(), this.f43807x.getPlaybackParams().getPitch());
            this.E = playbackParameters;
            this.f43787h.t(playbackParameters.f40953a);
        }
    }

    private void p0(ByteBuffer byteBuffer) {
        Assertions.g(this.T == null);
        if (byteBuffer.hasRemaining()) {
            this.T = e0(byteBuffer);
        }
    }

    private void q0() {
        if (b0()) {
            this.f43807x.setVolume(this.Q);
        }
    }

    private void r0() {
        AudioProcessingPipeline audioProcessingPipeline = this.f43805v.f43830i;
        this.f43806w = audioProcessingPipeline;
        audioProcessingPipeline.b();
    }

    private boolean s0() {
        if (this.f43778c0) {
            return false;
        }
        Configuration configuration = this.f43805v;
        return configuration.f43824c == 0 && !t0(configuration.f43822a.G);
    }

    private boolean t0(int i3) {
        return this.f43777c && Util.B0(i3);
    }

    private boolean u0() {
        Configuration configuration = this.f43805v;
        return configuration != null && configuration.f43831j && Util.f41609a >= 23;
    }

    private static int v0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3) {
        return audioTrack.write(byteBuffer, i3, 1);
    }

    private int w0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3, long j3) {
        if (Util.f41609a >= 26) {
            return audioTrack.write(byteBuffer, i3, 1, j3 * 1000);
        }
        if (this.G == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.G = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.G.putInt(1431633921);
        }
        if (this.H == 0) {
            this.G.putInt(4, i3);
            this.G.putLong(8, j3 * 1000);
            this.G.position(0);
            this.H = i3;
        }
        int iRemaining = this.G.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.G, iRemaining, 1);
            if (iWrite < 0) {
                this.H = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iV0 = v0(audioTrack, byteBuffer, i3);
        if (iV0 < 0) {
            this.H = 0;
            return iV0;
        }
        this.H -= iV0;
        return iV0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean a(Format format) {
        return w(format) != 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean b() {
        if (b0()) {
            return this.U && !h();
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long c(boolean z2) {
        if (!b0() || this.O) {
            return Long.MIN_VALUE;
        }
        return N(M(Math.min(this.f43787h.c(), this.f43805v.d(W()))));
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public PlaybackParameters d() {
        return this.E;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void e(PlaybackParameters playbackParameters) {
        this.E = new PlaybackParameters(Util.q(playbackParameters.f40953a, 0.1f, 8.0f), Util.q(playbackParameters.f40954b, 0.1f, 8.0f));
        if (u0()) {
            o0();
        } else {
            n0(playbackParameters);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void f(AudioAttributes audioAttributes) {
        if (this.B.equals(audioAttributes)) {
            return;
        }
        this.B = audioAttributes;
        if (this.f43778c0) {
            return;
        }
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f43809z;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.h(audioAttributes);
        }
        flush();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void flush() {
        OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24;
        if (b0()) {
            m0();
            if (this.f43787h.i()) {
                this.f43807x.pause();
            }
            if (c0(this.f43807x)) {
                ((StreamEventCallbackV29) Assertions.e(this.f43795l)).b(this.f43807x);
            }
            AudioSink.AudioTrackConfig audioTrackConfigA = this.f43805v.a();
            Configuration configuration = this.f43804u;
            if (configuration != null) {
                this.f43805v = configuration;
                this.f43804u = null;
            }
            this.f43787h.q();
            if (Util.f41609a >= 24 && (onRoutingChangedListenerApi24 = this.A) != null) {
                onRoutingChangedListenerApi24.c();
                this.A = null;
            }
            l0(this.f43807x, this.f43803t, audioTrackConfigA);
            this.f43807x = null;
        }
        this.f43797n.a();
        this.f43796m.a();
        this.f43790i0 = 0L;
        this.f43792j0 = 0L;
        Handler handler = this.f43794k0;
        if (handler != null) {
            ((Handler) Assertions.e(handler)).removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public AudioOffloadSupport g(Format format) {
        return this.f43784f0 ? AudioOffloadSupport.f43693d : this.f43799p.a(format, this.B);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean h() {
        if (b0()) {
            return !(Util.f41609a >= 29 && this.f43807x.isOffloadedPlayback() && this.W) && this.f43787h.h(W());
        }
        return false;
    }

    public void h0(AudioCapabilities audioCapabilities) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f43788h0;
        if (looper != looperMyLooper) {
            String name = looper == null ? "null" : looper.getThread().getName();
            throw new IllegalStateException("Current looper (" + (looperMyLooper != null ? looperMyLooper.getThread().getName() : "null") + ") is not the playback looper (" + name + ")");
        }
        AudioCapabilities audioCapabilities2 = this.f43808y;
        if (audioCapabilities2 == null || audioCapabilities.equals(audioCapabilities2)) {
            return;
        }
        this.f43808y = audioCapabilities;
        AudioSink.Listener listener = this.f43803t;
        if (listener != null) {
            listener.i();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void i(int i3) {
        if (this.Z != i3) {
            this.Z = i3;
            this.Y = i3 != 0;
            flush();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long j() {
        if (!b0()) {
            return -9223372036854775807L;
        }
        if (Util.f41609a >= 23) {
            return Api23.a(this.f43807x, this.f43805v);
        }
        Configuration configuration = this.f43805v;
        return Util.b1(this.f43805v.f43829h, 1000000L, configuration.f43824c == 0 ? ((long) configuration.f43826e) * ((long) configuration.f43825d) : DefaultAudioTrackBufferSizeProvider.d(configuration.f43828g), RoundingMode.DOWN);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void k(AudioSink.Listener listener) {
        this.f43803t = listener;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void l(int i3) {
        Assertions.g(Util.f41609a >= 29);
        this.f43793k = i3;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void m() {
        if (this.f43778c0) {
            this.f43778c0 = false;
            flush();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean n(ByteBuffer byteBuffer, long j3, int i3) throws Exception {
        ByteBuffer byteBuffer2 = this.R;
        Assertions.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f43804u != null) {
            if (!S()) {
                return false;
            }
            if (this.f43804u.b(this.f43805v)) {
                this.f43805v = this.f43804u;
                this.f43804u = null;
                AudioTrack audioTrack = this.f43807x;
                if (audioTrack != null && c0(audioTrack) && this.f43805v.f43832k) {
                    if (this.f43807x.getPlayState() == 3) {
                        this.f43807x.setOffloadEndOfStream();
                        this.f43787h.a();
                    }
                    AudioTrack audioTrack2 = this.f43807x;
                    Format format = this.f43805v.f43822a;
                    audioTrack2.setOffloadDelayPadding(format.H, format.I);
                    this.f43786g0 = true;
                }
            } else {
                i0();
                if (h()) {
                    return false;
                }
                flush();
            }
            L(j3);
        }
        if (!b0()) {
            try {
                if (!Z()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e3) {
                if (e3.f43710b) {
                    throw e3;
                }
                this.f43796m.c(e3);
                return false;
            }
        }
        this.f43796m.a();
        if (this.O) {
            this.P = Math.max(0L, j3);
            this.N = false;
            this.O = false;
            if (u0()) {
                o0();
            }
            L(j3);
            if (this.X) {
                q();
            }
        }
        if (!this.f43787h.k(W())) {
            return false;
        }
        if (this.R == null) {
            Assertions.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration = this.f43805v;
            if (configuration.f43824c != 0 && this.M == 0) {
                int iU = U(configuration.f43828g, byteBuffer);
                this.M = iU;
                if (iU == 0) {
                    return true;
                }
            }
            if (this.C != null) {
                if (!S()) {
                    return false;
                }
                L(j3);
                this.C = null;
            }
            long jE = this.P + this.f43805v.e(V() - this.f43781e.m());
            if (!this.N && Math.abs(jE - j3) > 200000) {
                AudioSink.Listener listener = this.f43803t;
                if (listener != null) {
                    listener.e(new AudioSink.UnexpectedDiscontinuityException(j3, jE));
                }
                this.N = true;
            }
            if (this.N) {
                if (!S()) {
                    return false;
                }
                long j4 = j3 - jE;
                this.P += j4;
                this.N = false;
                L(j3);
                AudioSink.Listener listener2 = this.f43803t;
                if (listener2 != null && j4 != 0) {
                    listener2.j();
                }
            }
            if (this.f43805v.f43824c == 0) {
                this.I += (long) byteBuffer.remaining();
            } else {
                this.J += ((long) this.M) * ((long) i3);
            }
            this.R = byteBuffer;
            this.S = i3;
        }
        j0(j3);
        if (!this.R.hasRemaining()) {
            this.R = null;
            this.S = 0;
            return true;
        }
        if (!this.f43787h.j(W())) {
            return false;
        }
        Log.i("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void o(Format format, int i3, int[] iArr) throws AudioSink.ConfigurationException {
        int i4;
        int i5;
        int iK0;
        boolean z2;
        int i6;
        int i7;
        boolean z3;
        AudioProcessingPipeline audioProcessingPipeline;
        int i8;
        int i9;
        int iA;
        g0();
        if ("audio/raw".equals(format.f40632o)) {
            Assertions.a(Util.C0(format.G));
            iK0 = Util.k0(format.G, format.E);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            if (t0(format.G)) {
                builder.k(this.f43785g);
            } else {
                builder.k(this.f43783f);
                builder.j(this.f43775b.b());
            }
            AudioProcessingPipeline audioProcessingPipeline2 = new AudioProcessingPipeline(builder.m());
            if (audioProcessingPipeline2.equals(this.f43806w)) {
                audioProcessingPipeline2 = this.f43806w;
            }
            this.f43781e.o(format.H, format.I);
            this.f43779d.m(iArr);
            try {
                AudioProcessor.AudioFormat audioFormatA = audioProcessingPipeline2.a(new AudioProcessor.AudioFormat(format));
                int i10 = audioFormatA.f41289c;
                i4 = audioFormatA.f41287a;
                int iP = Util.P(audioFormatA.f41288b);
                int iK02 = Util.k0(i10, audioFormatA.f41288b);
                i5 = 0;
                i6 = i10;
                i7 = iP;
                z3 = this.f43791j;
                audioProcessingPipeline = audioProcessingPipeline2;
                i8 = iK02;
                z2 = false;
            } catch (AudioProcessor.UnhandledAudioFormatException e3) {
                throw new AudioSink.ConfigurationException(e3, format);
            }
        } else {
            AudioProcessingPipeline audioProcessingPipeline3 = new AudioProcessingPipeline(ImmutableList.y());
            i4 = format.F;
            AudioOffloadSupport audioOffloadSupportG = this.f43793k != 0 ? g(format) : AudioOffloadSupport.f43693d;
            if (this.f43793k == 0 || !audioOffloadSupportG.f43694a) {
                Pair pairH = this.f43808y.h(format, this.B);
                if (pairH == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format, format);
                }
                int iIntValue = ((Integer) pairH.first).intValue();
                int iIntValue2 = ((Integer) pairH.second).intValue();
                i5 = 2;
                iK0 = -1;
                z2 = false;
                i6 = iIntValue;
                i7 = iIntValue2;
                z3 = this.f43791j;
                audioProcessingPipeline = audioProcessingPipeline3;
            } else {
                int iE = MimeTypes.e((String) Assertions.e(format.f40632o), format.f40628k);
                int iP2 = Util.P(format.E);
                z2 = audioOffloadSupportG.f43695b;
                iK0 = -1;
                audioProcessingPipeline = audioProcessingPipeline3;
                i6 = iE;
                i7 = iP2;
                z3 = true;
                i5 = 1;
            }
            i8 = iK0;
        }
        if (i6 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i5 + ") for: " + format, format);
        }
        if (i7 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i5 + ") for: " + format, format);
        }
        int i11 = format.f40627j;
        if ("audio/vnd.dts.hd;profile=lbr".equals(format.f40632o) && i11 == -1) {
            i11 = 768000;
        }
        int i12 = i11;
        if (i3 != 0) {
            iA = i3;
            i9 = i4;
        } else {
            i9 = i4;
            iA = this.f43798o.a(T(i4, i7, i6), i6, i5, i8 != -1 ? i8 : 1, i9, i12, z3 ? 8.0d : 1.0d);
        }
        this.f43784f0 = false;
        boolean z4 = z2;
        int i13 = i5;
        Configuration configuration = new Configuration(format, iK0, i13, i8, i9, i7, i6, iA, audioProcessingPipeline, z3, z4, this.f43778c0);
        if (b0()) {
            this.f43804u = configuration;
        } else {
            this.f43805v = configuration;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void p() {
        if (!this.U && b0() && S()) {
            i0();
            this.U = true;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void pause() {
        this.X = false;
        if (b0()) {
            if (this.f43787h.p() || c0(this.f43807x)) {
                this.f43807x.pause();
            }
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void q() {
        this.X = true;
        if (b0()) {
            this.f43787h.v();
            this.f43807x.play();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void r(int i3, int i4) {
        Configuration configuration;
        AudioTrack audioTrack = this.f43807x;
        if (audioTrack == null || !c0(audioTrack) || (configuration = this.f43805v) == null || !configuration.f43832k) {
            return;
        }
        this.f43807x.setOffloadDelayPadding(i3, i4);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void release() {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f43809z;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.j();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void reset() {
        flush();
        UnmodifiableIterator it = this.f43783f.iterator();
        while (it.hasNext()) {
            ((AudioProcessor) it.next()).reset();
        }
        UnmodifiableIterator it2 = this.f43785g.iterator();
        while (it2.hasNext()) {
            ((AudioProcessor) it2.next()).reset();
        }
        AudioProcessingPipeline audioProcessingPipeline = this.f43806w;
        if (audioProcessingPipeline != null) {
            audioProcessingPipeline.k();
        }
        this.X = false;
        this.f43784f0 = false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void s(PlayerId playerId) {
        this.f43802s = playerId;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        this.f43776b0 = audioDeviceInfo == null ? null : new AudioDeviceInfoApi23(audioDeviceInfo);
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.f43809z;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.i(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.f43807x;
        if (audioTrack != null) {
            Api23.b(audioTrack, this.f43776b0);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setVolume(float f3) {
        if (this.Q != f3) {
            this.Q = f3;
            q0();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void u() {
        this.N = true;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void v() {
        Assertions.g(this.Y);
        if (this.f43778c0) {
            return;
        }
        this.f43778c0 = true;
        flush();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public int w(Format format) {
        g0();
        if (!"audio/raw".equals(format.f40632o)) {
            return this.f43808y.j(format, this.B) ? 2 : 0;
        }
        if (Util.C0(format.G)) {
            int i3 = format.G;
            return (i3 == 2 || (this.f43777c && i3 == 4)) ? 2 : 1;
        }
        Log.i("DefaultAudioSink", "Invalid PCM encoding: " + format.G);
        return 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void x(boolean z2) {
        this.F = z2;
        n0(u0() ? PlaybackParameters.f40950d : this.E);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void y(AuxEffectInfo auxEffectInfo) {
        if (this.f43774a0.equals(auxEffectInfo)) {
            return;
        }
        int i3 = auxEffectInfo.f40536a;
        float f3 = auxEffectInfo.f40537b;
        AudioTrack audioTrack = this.f43807x;
        if (audioTrack != null) {
            if (this.f43774a0.f40536a != i3) {
                audioTrack.attachAuxEffect(i3);
            }
            if (i3 != 0) {
                this.f43807x.setAuxEffectSendLevel(f3);
            }
        }
        this.f43774a0 = auxEffectInfo;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void z(Clock clock) {
        this.f43787h.u(clock);
    }

    private DefaultAudioSink(Builder builder) {
        Context context = builder.f43812a;
        this.f43773a = context;
        this.B = AudioAttributes.f40518g;
        this.f43808y = context != null ? null : builder.f43813b;
        this.f43775b = builder.f43814c;
        this.f43777c = builder.f43815d;
        this.f43791j = Util.f41609a >= 23 && builder.f43816e;
        this.f43793k = 0;
        this.f43798o = builder.f43818g;
        this.f43799p = (AudioOffloadSupportProvider) Assertions.e(builder.f43820i);
        this.f43787h = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.f43779d = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.f43781e = trimmingAudioProcessor;
        this.f43783f = ImmutableList.B(new ToInt16PcmAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        this.f43785g = ImmutableList.B(new ToFloatPcmAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        this.Q = 1.0f;
        this.Z = 0;
        this.f43774a0 = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.f40950d;
        this.D = new MediaPositionParameters(playbackParameters, 0L, 0L);
        this.E = playbackParameters;
        this.F = false;
        this.f43789i = new ArrayDeque();
        this.f43796m = new PendingExceptionHolder();
        this.f43797n = new PendingExceptionHolder();
        this.f43800q = builder.f43821j;
        this.f43801r = builder.f43819h;
    }
}
