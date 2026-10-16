package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class BatchBuffer extends DecoderInputBuffer {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f44241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f44242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f44243m;

    public BatchBuffer() {
        super(2);
        this.f44243m = 32;
    }

    private boolean v(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!z()) {
            return true;
        }
        if (this.f44242l >= this.f44243m) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f42138d;
        return byteBuffer2 == null || (byteBuffer = this.f42138d) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public void A(int i3) {
        Assertions.a(i3 > 0);
        this.f44243m = i3;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer, androidx.media3.decoder.Buffer
    public void f() {
        super.f();
        this.f44242l = 0;
    }

    public boolean u(DecoderInputBuffer decoderInputBuffer) {
        Assertions.a(!decoderInputBuffer.r());
        Assertions.a(!decoderInputBuffer.h());
        Assertions.a(!decoderInputBuffer.i());
        if (!v(decoderInputBuffer)) {
            return false;
        }
        int i3 = this.f44242l;
        this.f44242l = i3 + 1;
        if (i3 == 0) {
            this.f42140g = decoderInputBuffer.f42140g;
            if (decoderInputBuffer.k()) {
                n(1);
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f42138d;
        if (byteBuffer != null) {
            p(byteBuffer.remaining());
            this.f42138d.put(byteBuffer);
        }
        this.f44241k = decoderInputBuffer.f42140g;
        return true;
    }

    public long w() {
        return this.f42140g;
    }

    public long x() {
        return this.f44241k;
    }

    public int y() {
        return this.f44242l;
    }

    public boolean z() {
        return this.f44242l > 0;
    }
}
