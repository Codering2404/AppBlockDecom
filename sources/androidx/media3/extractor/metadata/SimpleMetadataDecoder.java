package androidx.media3.extractor.metadata;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    @Override // androidx.media3.extractor.metadata.MetadataDecoder
    public final Metadata a(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(metadataInputBuffer.f42138d);
        Assertions.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return b(metadataInputBuffer, byteBuffer);
    }

    protected abstract Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
