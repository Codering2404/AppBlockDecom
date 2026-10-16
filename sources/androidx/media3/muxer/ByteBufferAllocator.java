package androidx.media3.muxer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ByteBufferAllocator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBufferAllocator f47800a = new ByteBufferAllocator() { // from class: androidx.media3.muxer.a
        @Override // androidx.media3.muxer.ByteBufferAllocator
        public final ByteBuffer a(int i3) {
            return ByteBuffer.allocateDirect(i3);
        }
    };

    ByteBuffer a(int i3);
}
