package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.decoder.CryptoInfo;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaCodecAdapter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Configuration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodecInfo f44254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f44255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f44256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Surface f44257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final MediaCrypto f44258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final LoudnessCodecController f44259f;

        private Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto, LoudnessCodecController loudnessCodecController) {
            this.f44254a = mediaCodecInfo;
            this.f44255b = mediaFormat;
            this.f44256c = format;
            this.f44257d = surface;
            this.f44258e = mediaCrypto;
            this.f44259f = loudnessCodecController;
        }

        public static Configuration a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, MediaCrypto mediaCrypto, LoudnessCodecController loudnessCodecController) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, null, mediaCrypto, loudnessCodecController);
        }

        public static Configuration b(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, Surface surface, MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, surface, mediaCrypto, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Factory f44260a = new DefaultMediaCodecAdapterFactory();

        static Factory a(Context context) {
            return new DefaultMediaCodecAdapterFactory(context);
        }

        MediaCodecAdapter b(Configuration configuration);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnFrameRenderedListener {
        void a(MediaCodecAdapter mediaCodecAdapter, long j3, long j4);
    }

    MediaFormat c();

    void d(int i3, int i4, int i5, long j3, int i6);

    void e(int i3, int i4, CryptoInfo cryptoInfo, long j3, int i5);

    void f(Bundle bundle);

    void flush();

    default boolean g(OnBufferAvailableListener onBufferAvailableListener) {
        return false;
    }

    void h(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    void i();

    void j(int i3);

    ByteBuffer k(int i3);

    void l(Surface surface);

    boolean m();

    void n(int i3, long j3);

    int o();

    int p(MediaCodec.BufferInfo bufferInfo);

    void q(int i3, boolean z2);

    ByteBuffer r(int i3);

    void release();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnBufferAvailableListener {
        default void a() {
        }

        default void b() {
        }
    }
}
