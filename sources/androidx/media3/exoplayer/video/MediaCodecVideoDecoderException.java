package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45699d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f45700f;

    public MediaCodecVideoDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo, Surface surface) {
        super(th, mediaCodecInfo);
        this.f45699d = System.identityHashCode(surface);
        this.f45700f = surface == null || surface.isValid();
    }
}
