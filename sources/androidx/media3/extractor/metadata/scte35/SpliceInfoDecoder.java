package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpliceInfoDecoder extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46507a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableBitArray f46508b = new ParsableBitArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TimestampAdjuster f46509c;

    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    protected Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        TimestampAdjuster timestampAdjuster = this.f46509c;
        if (timestampAdjuster == null || metadataInputBuffer.f46412k != timestampAdjuster.f()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.f42140g);
            this.f46509c = timestampAdjuster2;
            timestampAdjuster2.a(metadataInputBuffer.f42140g - metadataInputBuffer.f46412k);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f46507a.U(bArrArray, iLimit);
        this.f46508b.o(bArrArray, iLimit);
        this.f46508b.r(39);
        long jH = (((long) this.f46508b.h(1)) << 32) | ((long) this.f46508b.h(32));
        this.f46508b.r(20);
        int iH = this.f46508b.h(12);
        int iH2 = this.f46508b.h(8);
        this.f46507a.X(14);
        Metadata.Entry entryD = iH2 != 0 ? iH2 != 255 ? iH2 != 4 ? iH2 != 5 ? iH2 != 6 ? null : TimeSignalCommand.d(this.f46507a, jH, this.f46509c) : SpliceInsertCommand.d(this.f46507a, jH, this.f46509c) : SpliceScheduleCommand.d(this.f46507a) : PrivateCommand.d(this.f46507a, iH, jH) : new SpliceNullCommand();
        return entryD == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entryD);
    }
}
