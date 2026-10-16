package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataItem extends Table {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Vector extends BaseVector {
    }

    public MetadataItem g(int i3, ByteBuffer byteBuffer) {
        h(i3, byteBuffer);
        return this;
    }

    public void h(int i3, ByteBuffer byteBuffer) {
        c(i3, byteBuffer);
    }

    public int i(int i3) {
        int iB = b(16);
        if (iB != 0) {
            return this.f36981b.getInt(d(iB) + (i3 * 4));
        }
        return 0;
    }

    public int j() {
        int iB = b(16);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public boolean k() {
        int iB = b(6);
        return (iB == 0 || this.f36981b.get(iB + this.f36980a) == 0) ? false : true;
    }

    public short l() {
        int iB = b(14);
        if (iB != 0) {
            return this.f36981b.getShort(iB + this.f36980a);
        }
        return (short) 0;
    }

    public int m() {
        int iB = b(4);
        if (iB != 0) {
            return this.f36981b.getInt(iB + this.f36980a);
        }
        return 0;
    }

    public short n() {
        int iB = b(8);
        if (iB != 0) {
            return this.f36981b.getShort(iB + this.f36980a);
        }
        return (short) 0;
    }

    public short o() {
        int iB = b(12);
        if (iB != 0) {
            return this.f36981b.getShort(iB + this.f36980a);
        }
        return (short) 0;
    }
}
