package androidx.media3.extractor.metadata.id3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InternalFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46479d;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f46477b = str;
        this.f46478c = str2;
        this.f46479d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && InternalFrame.class == obj.getClass()) {
            InternalFrame internalFrame = (InternalFrame) obj;
            if (Objects.equals(this.f46478c, internalFrame.f46478c) && Objects.equals(this.f46477b, internalFrame.f46477b) && Objects.equals(this.f46479d, internalFrame.f46479d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46477b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f46478c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f46479d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": domain=" + this.f46477b + ", description=" + this.f46478c;
    }
}
