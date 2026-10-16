package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AudioSink {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AudioTrackConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f43705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f43706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f43707f;

        public AudioTrackConfig(int i3, int i4, int i5, boolean z2, boolean z3, int i6) {
            this.f43702a = i3;
            this.f43703b = i4;
            this.f43704c = i5;
            this.f43705d = z2;
            this.f43706e = z3;
            this.f43707f = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkFormatSupport {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnexpectedDiscontinuityException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f43712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43713b;

        public UnexpectedDiscontinuityException(long j3, long j4) {
            super("Unexpected audio track timestamp discontinuity: expected " + j4 + ", got " + j3);
            this.f43712a = j3;
            this.f43713b = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class WriteException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f43715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f43716c;

        public WriteException(int i3, Format format, boolean z2) {
            super("AudioTrack write failed: " + i3);
            this.f43715b = z2;
            this.f43714a = i3;
            this.f43716c = format;
        }
    }

    boolean a(Format format);

    boolean b();

    long c(boolean z2);

    PlaybackParameters d();

    void e(PlaybackParameters playbackParameters);

    void f(AudioAttributes audioAttributes);

    void flush();

    default AudioOffloadSupport g(Format format) {
        return AudioOffloadSupport.f43693d;
    }

    boolean h();

    void i(int i3);

    long j();

    void k(Listener listener);

    void m();

    boolean n(ByteBuffer byteBuffer, long j3, int i3);

    void o(Format format, int i3, int[] iArr);

    void p();

    void pause();

    void q();

    void reset();

    void setVolume(float f3);

    void u();

    void v();

    int w(Format format);

    void x(boolean z2);

    void y(AuxEffectInfo auxEffectInfo);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ConfigurationException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f43708a;

        public ConfigurationException(Throwable th, Format format) {
            super(th);
            this.f43708a = format;
        }

        public ConfigurationException(String str, Format format) {
            super(str);
            this.f43708a = format;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InitializationException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f43710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f43711c;

        public InitializationException(String str, int i3, Format format, boolean z2, Throwable th) {
            super(str, th);
            this.f43709a = i3;
            this.f43710b = z2;
            this.f43711c = format;
        }

        public InitializationException(int i3, int i4, int i5, int i6, Format format, boolean z2, Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(i3);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i4);
            sb.append(", ");
            sb.append(i5);
            sb.append(", ");
            sb.append(i6);
            sb.append(")");
            sb.append(" ");
            sb.append(format);
            sb.append(z2 ? " (recoverable)" : "");
            this(sb.toString(), i3, format, z2, exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void d(boolean z2);

        void h(int i3, long j3, long j4);

        void j();

        default void f() {
        }

        default void g() {
        }

        default void i() {
        }

        default void k() {
        }

        default void a(AudioTrackConfig audioTrackConfig) {
        }

        default void b(long j3) {
        }

        default void c(AudioTrackConfig audioTrackConfig) {
        }

        default void e(Exception exc) {
        }
    }

    default void release() {
    }

    default void l(int i3) {
    }

    default void s(PlayerId playerId) {
    }

    default void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
    }

    default void t(long j3) {
    }

    default void z(Clock clock) {
    }

    default void r(int i3, int i4) {
    }
}
