package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ChapterTocFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f46459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f46460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f46461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Id3Frame[] f46462f;

    public ChapterTocFrame(String str, boolean z2, boolean z3, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f46458b = str;
        this.f46459c = z2;
        this.f46460d = z3;
        this.f46461e = strArr;
        this.f46462f = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterTocFrame.class == obj.getClass()) {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            if (this.f46459c == chapterTocFrame.f46459c && this.f46460d == chapterTocFrame.f46460d && Objects.equals(this.f46458b, chapterTocFrame.f46458b) && Arrays.equals(this.f46461e, chapterTocFrame.f46461e) && Arrays.equals(this.f46462f, chapterTocFrame.f46462f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (((527 + (this.f46459c ? 1 : 0)) * 31) + (this.f46460d ? 1 : 0)) * 31;
        String str = this.f46458b;
        return i3 + (str != null ? str.hashCode() : 0);
    }
}
