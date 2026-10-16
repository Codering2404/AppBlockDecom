package androidx.media3.decoder;

import androidx.media3.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleDecoderOutputBuffer extends DecoderOutputBuffer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DecoderOutputBuffer.Owner f42164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f42165g;

    @Override // androidx.media3.decoder.DecoderOutputBuffer, androidx.media3.decoder.Buffer
    public void f() {
        super.f();
        ByteBuffer byteBuffer = this.f42165g;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // androidx.media3.decoder.DecoderOutputBuffer
    public void o() {
        this.f42164f.a(this);
    }
}
