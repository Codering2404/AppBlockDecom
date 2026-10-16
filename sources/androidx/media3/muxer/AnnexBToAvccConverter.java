package androidx.media3.muxer;

import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AnnexBToAvccConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnexBToAvccConverter f47798a = new AnnexBToAvccConverter() { // from class: androidx.media3.muxer.AnnexBToAvccConverter.1
        @Override // androidx.media3.muxer.AnnexBToAvccConverter
        public ByteBuffer a(ByteBuffer byteBuffer) {
            return b(byteBuffer, ByteBufferAllocator.f47800a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.muxer.AnnexBToAvccConverter
        public ByteBuffer b(ByteBuffer byteBuffer, ByteBufferAllocator byteBufferAllocator) {
            if (!byteBuffer.hasRemaining()) {
                return byteBuffer;
            }
            ImmutableList immutableListC = AnnexBUtils.c(byteBuffer);
            int iRemaining = 0;
            for (int i3 = 0; i3 < immutableListC.size(); i3++) {
                iRemaining += ((ByteBuffer) immutableListC.get(i3)).remaining() + 4;
            }
            ByteBuffer byteBufferA = byteBufferAllocator.a(iRemaining);
            for (int i4 = 0; i4 < immutableListC.size(); i4++) {
                ByteBuffer byteBuffer2 = (ByteBuffer) immutableListC.get(i4);
                byteBufferA.putInt(byteBuffer2.remaining());
                byteBufferA.put(byteBuffer2);
            }
            byteBufferA.rewind();
            return byteBufferA;
        }
    };

    ByteBuffer a(ByteBuffer byteBuffer);

    default ByteBuffer b(ByteBuffer byteBuffer, ByteBufferAllocator byteBufferAllocator) {
        return a(byteBuffer);
    }
}
