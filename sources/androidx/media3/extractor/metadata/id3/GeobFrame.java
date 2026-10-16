package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GeobFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f46469e;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f46466b = str;
        this.f46467c = str2;
        this.f46468d = str3;
        this.f46469e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GeobFrame.class == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (Objects.equals(this.f46466b, geobFrame.f46466b) && Objects.equals(this.f46467c, geobFrame.f46467c) && Objects.equals(this.f46468d, geobFrame.f46468d) && Arrays.equals(this.f46469e, geobFrame.f46469e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46466b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f46467c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f46468d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f46469e);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": mimeType=" + this.f46466b + ", filename=" + this.f46467c + ", description=" + this.f46468d;
    }
}
