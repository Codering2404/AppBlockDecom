package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BinaryFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f46451b;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f46451b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && BinaryFrame.class == obj.getClass()) {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (this.f46475a.equals(binaryFrame.f46475a) && Arrays.equals(this.f46451b, binaryFrame.f46451b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f46475a.hashCode()) * 31) + Arrays.hashCode(this.f46451b);
    }
}
