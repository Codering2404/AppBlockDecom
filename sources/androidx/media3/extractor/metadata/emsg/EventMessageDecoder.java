package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EventMessageDecoder extends SimpleMetadataDecoder {
    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    protected Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return new Metadata(c(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(ParsableByteArray parsableByteArray) {
        return new EventMessage((String) Assertions.e(parsableByteArray.B()), (String) Assertions.e(parsableByteArray.B()), parsableByteArray.A(), parsableByteArray.A(), Arrays.copyOfRange(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray.g()));
    }
}
