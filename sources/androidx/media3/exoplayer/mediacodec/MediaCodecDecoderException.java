package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodecInfo f44261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44263c;

    public MediaCodecDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoder failed: ");
        sb.append(mediaCodecInfo == null ? null : mediaCodecInfo.f44264a);
        super(sb.toString(), th);
        this.f44261a = mediaCodecInfo;
        String diagnosticInfo = th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null;
        this.f44262b = diagnosticInfo;
        this.f44263c = Util.f41609a >= 23 ? a(th) : Util.b0(diagnosticInfo);
    }

    private static int a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getErrorCode();
        }
        return 0;
    }
}
