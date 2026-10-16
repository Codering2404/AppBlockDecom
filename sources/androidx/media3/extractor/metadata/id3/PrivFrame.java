package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PrivFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f46486c;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f46485b = str;
        this.f46486c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PrivFrame.class == obj.getClass()) {
            PrivFrame privFrame = (PrivFrame) obj;
            if (Objects.equals(this.f46485b, privFrame.f46485b) && Arrays.equals(this.f46486c, privFrame.f46486c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46485b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f46486c);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": owner=" + this.f46485b;
    }
}
