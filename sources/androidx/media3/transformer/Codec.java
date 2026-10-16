package androidx.media3.transformer;

import android.media.MediaCodec;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Codec {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DecoderFactory {
        Codec a(Format format);

        Codec b(Format format, Surface surface, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EncoderFactory {
        default boolean a() {
            return false;
        }

        Codec b(Format format);

        Codec c(Format format);

        default boolean d() {
            return false;
        }
    }

    Surface a();

    boolean b();

    Format c();

    void d(DecoderInputBuffer decoderInputBuffer);

    Format e();

    void f(long j3);

    MediaCodec.BufferInfo g();

    String getName();

    void h(boolean z2);

    void i();

    ByteBuffer j();

    default int k() {
        return 5;
    }

    boolean l(DecoderInputBuffer decoderInputBuffer);

    Format m();

    void release();
}
