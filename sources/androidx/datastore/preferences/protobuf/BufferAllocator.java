package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BufferAllocator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BufferAllocator f36016a = new BufferAllocator() { // from class: androidx.datastore.preferences.protobuf.BufferAllocator.1
        @Override // androidx.datastore.preferences.protobuf.BufferAllocator
        public AllocatedBuffer a(int i3) {
            return AllocatedBuffer.i(ByteBuffer.allocateDirect(i3));
        }

        @Override // androidx.datastore.preferences.protobuf.BufferAllocator
        public AllocatedBuffer b(int i3) {
            return AllocatedBuffer.j(new byte[i3]);
        }
    };

    BufferAllocator() {
    }

    public abstract AllocatedBuffer a(int i3);

    public abstract AllocatedBuffer b(int i3);
}
