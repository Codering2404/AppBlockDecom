package androidx.media3.common.audio;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f41285a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AudioFormat {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final AudioFormat f41286e = new AudioFormat(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41290d;

        public AudioFormat(Format format) {
            this(format.F, format.E, format.G);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFormat)) {
                return false;
            }
            AudioFormat audioFormat = (AudioFormat) obj;
            return this.f41287a == audioFormat.f41287a && this.f41288b == audioFormat.f41288b && this.f41289c == audioFormat.f41289c;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f41287a), Integer.valueOf(this.f41288b), Integer.valueOf(this.f41289c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f41287a + ", channelCount=" + this.f41288b + ", encoding=" + this.f41289c + ']';
        }

        public AudioFormat(int i3, int i4, int i5) {
            this.f41287a = i3;
            this.f41288b = i4;
            this.f41289c = i5;
            this.f41290d = Util.C0(i5) ? Util.k0(i5, i4) : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnhandledAudioFormatException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioFormat f41291a;

        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            this("Unhandled input format:", audioFormat);
        }

        public UnhandledAudioFormatException(String str, AudioFormat audioFormat) {
            super(str + " " + audioFormat);
            this.f41291a = audioFormat;
        }
    }

    boolean b();

    ByteBuffer c();

    void d(ByteBuffer byteBuffer);

    void e();

    AudioFormat f(AudioFormat audioFormat);

    void flush();

    boolean isActive();

    void reset();

    default long g(long j3) {
        return j3;
    }
}
