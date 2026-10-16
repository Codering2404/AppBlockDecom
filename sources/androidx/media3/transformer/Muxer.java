package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Muxer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        Muxer a(String str);

        ImmutableList b(int i3);
    }

    void a(Metadata.Entry entry);

    void b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    int c(Format format);

    void close();
}
