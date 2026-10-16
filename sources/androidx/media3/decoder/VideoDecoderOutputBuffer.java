package androidx.media3.decoder;

import androidx.media3.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class VideoDecoderOutputBuffer extends DecoderOutputBuffer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f42166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f42167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f42168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteBuffer[] f42169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f42170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f42171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DecoderOutputBuffer.Owner f42172l;

    @Override // androidx.media3.decoder.DecoderOutputBuffer
    public void o() {
        this.f42172l.a(this);
    }
}
