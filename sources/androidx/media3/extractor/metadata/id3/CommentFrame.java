package androidx.media3.extractor.metadata.id3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CommentFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46465d;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f46463b = str;
        this.f46464c = str2;
        this.f46465d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CommentFrame.class == obj.getClass()) {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (Objects.equals(this.f46464c, commentFrame.f46464c) && Objects.equals(this.f46463b, commentFrame.f46463b) && Objects.equals(this.f46465d, commentFrame.f46465d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46463b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f46464c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f46465d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": language=" + this.f46463b + ", description=" + this.f46464c + ", text=" + this.f46465d;
    }
}
