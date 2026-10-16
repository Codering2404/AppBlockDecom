package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataList extends Table {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Vector extends BaseVector {
    }

    public static MetadataList i(ByteBuffer byteBuffer) {
        return j(byteBuffer, new MetadataList());
    }

    public static MetadataList j(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.g(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataList g(int i3, ByteBuffer byteBuffer) {
        h(i3, byteBuffer);
        return this;
    }

    public void h(int i3, ByteBuffer byteBuffer) {
        c(i3, byteBuffer);
    }

    public MetadataItem k(MetadataItem metadataItem, int i3) {
        int iB = b(6);
        if (iB != 0) {
            return metadataItem.g(a(d(iB) + (i3 * 4)), this.f36981b);
        }
        return null;
    }

    public int l() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int m() {
        int iB = b(4);
        if (iB != 0) {
            return this.f36981b.getInt(iB + this.f36980a);
        }
        return 0;
    }
}
