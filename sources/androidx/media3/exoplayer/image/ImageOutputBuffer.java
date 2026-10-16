package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.decoder.DecoderOutputBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageOutputBuffer extends DecoderOutputBuffer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f44159f;

    @Override // androidx.media3.decoder.DecoderOutputBuffer, androidx.media3.decoder.Buffer
    public void f() {
        this.f44159f = null;
        super.f();
    }
}
