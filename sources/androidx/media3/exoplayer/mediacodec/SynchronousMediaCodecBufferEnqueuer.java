package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.media3.decoder.CryptoInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class SynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f44333a;

    public SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.f44333a = mediaCodec;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void d(int i3, int i4, int i5, long j3, int i6) {
        this.f44333a.queueInputBuffer(i3, i4, i5, j3, i6);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void e(int i3, int i4, CryptoInfo cryptoInfo, long j3, int i5) {
        this.f44333a.queueSecureInputBuffer(i3, i4, cryptoInfo.a(), j3, i5);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void f(Bundle bundle) {
        this.f44333a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void a() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void flush() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void shutdown() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void start() {
    }
}
