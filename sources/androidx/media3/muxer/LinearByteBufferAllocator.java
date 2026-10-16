package androidx.media3.muxer;

import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class LinearByteBufferAllocator implements ByteBufferAllocator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f47835b;

    public LinearByteBufferAllocator(int i3) {
        Assertions.a(i3 >= 0);
        this.f47835b = ByteBuffer.allocateDirect(i3);
    }

    @Override // androidx.media3.muxer.ByteBufferAllocator
    public ByteBuffer a(int i3) {
        Assertions.a(i3 >= 0);
        if (this.f47835b.remaining() < i3) {
            this.f47835b = ByteBuffer.allocateDirect(Math.max(i3, this.f47835b.capacity() * 2));
        }
        ByteBuffer byteBufferSlice = this.f47835b.slice();
        ByteBuffer byteBuffer = this.f47835b;
        byteBuffer.position(byteBuffer.position() + i3);
        byteBufferSlice.limit(i3);
        return byteBufferSlice;
    }

    public void b() {
        this.f47835b.clear();
    }
}
