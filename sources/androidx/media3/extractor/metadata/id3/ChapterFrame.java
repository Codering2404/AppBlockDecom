package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ChapterFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f46455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f46456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Id3Frame[] f46457g;

    public ChapterFrame(String str, int i3, int i4, long j3, long j4, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f46452b = str;
        this.f46453c = i3;
        this.f46454d = i4;
        this.f46455e = j3;
        this.f46456f = j4;
        this.f46457g = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ChapterFrame.class == obj.getClass()) {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            if (this.f46453c == chapterFrame.f46453c && this.f46454d == chapterFrame.f46454d && this.f46455e == chapterFrame.f46455e && this.f46456f == chapterFrame.f46456f && Objects.equals(this.f46452b, chapterFrame.f46452b) && Arrays.equals(this.f46457g, chapterFrame.f46457g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (((((((527 + this.f46453c) * 31) + this.f46454d) * 31) + ((int) this.f46455e)) * 31) + ((int) this.f46456f)) * 31;
        String str = this.f46452b;
        return i3 + (str != null ? str.hashCode() : 0);
    }
}
