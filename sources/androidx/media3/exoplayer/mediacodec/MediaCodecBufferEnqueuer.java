package androidx.media3.exoplayer.mediacodec;

import android.os.Bundle;
import androidx.media3.decoder.CryptoInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface MediaCodecBufferEnqueuer {
    void a();

    void d(int i3, int i4, int i5, long j3, int i6);

    void e(int i3, int i4, CryptoInfo cryptoInfo, long j3, int i5);

    void f(Bundle bundle);

    void flush();

    void shutdown();

    void start();
}
