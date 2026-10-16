package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SeekPoint {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SeekPoint f46215c = new SeekPoint(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46217b;

    public SeekPoint(long j3, long j4) {
        this.f46216a = j3;
        this.f46217b = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SeekPoint.class == obj.getClass()) {
            SeekPoint seekPoint = (SeekPoint) obj;
            if (this.f46216a == seekPoint.f46216a && this.f46217b == seekPoint.f46217b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f46216a) * 31) + ((int) this.f46217b);
    }

    public String toString() {
        return "[timeUs=" + this.f46216a + ", position=" + this.f46217b + "]";
    }
}
