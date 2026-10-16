package androidx.media3.extractor.metadata.id3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class UrlLinkFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46491c;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f46490b = str2;
        this.f46491c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UrlLinkFrame.class == obj.getClass()) {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (this.f46475a.equals(urlLinkFrame.f46475a) && Objects.equals(this.f46490b, urlLinkFrame.f46490b) && Objects.equals(this.f46491c, urlLinkFrame.f46491c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.f46475a.hashCode()) * 31;
        String str = this.f46490b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f46491c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": url=" + this.f46491c;
    }
}
