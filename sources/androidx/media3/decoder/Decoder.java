package androidx.media3.decoder;

import androidx.media3.decoder.DecoderException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface Decoder<I, O, E extends DecoderException> {
    Object a();

    void b(Object obj);

    void e(long j3);

    Object f();

    void flush();

    String getName();

    void release();
}
