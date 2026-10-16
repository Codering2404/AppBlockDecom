package androidx.emoji2.text.flatbuffer;

import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FlatBufferBuilder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ByteBufferBackedInputStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ByteBuffer f36957a;

        @Override // java.io.InputStream
        public int read() {
            try {
                return this.f36957a.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ByteBufferFactory {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HeapByteBufferFactory f36958a = new HeapByteBufferFactory();
    }
}
