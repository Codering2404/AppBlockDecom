package androidx.media3.extractor.metadata.dvbsi;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTableDecoder extends SimpleMetadataDecoder {
    private static Metadata c(ParsableBitArray parsableBitArray) {
        parsableBitArray.r(12);
        int iD = (parsableBitArray.d() + parsableBitArray.h(12)) - 4;
        parsableBitArray.r(44);
        parsableBitArray.s(parsableBitArray.h(12));
        parsableBitArray.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strL = null;
            if (parsableBitArray.d() >= iD) {
                break;
            }
            parsableBitArray.r(48);
            int iH = parsableBitArray.h(8);
            parsableBitArray.r(4);
            int iD2 = parsableBitArray.d() + parsableBitArray.h(12);
            String strL2 = null;
            while (parsableBitArray.d() < iD2) {
                int iH2 = parsableBitArray.h(8);
                int iH3 = parsableBitArray.h(8);
                int iD3 = parsableBitArray.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = parsableBitArray.h(16);
                    parsableBitArray.r(8);
                    if (iH4 == 3) {
                        while (parsableBitArray.d() < iD3) {
                            strL = parsableBitArray.l(parsableBitArray.h(8), StandardCharsets.US_ASCII);
                            int iH5 = parsableBitArray.h(8);
                            for (int i3 = 0; i3 < iH5; i3++) {
                                parsableBitArray.s(parsableBitArray.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strL2 = parsableBitArray.l(iH3, StandardCharsets.US_ASCII);
                }
                parsableBitArray.p(iD3 * 8);
            }
            parsableBitArray.p(iD2 * 8);
            if (strL != null && strL2 != null) {
                arrayList.add(new AppInfoTable(iH, strL + strL2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    protected Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new ParsableBitArray(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
