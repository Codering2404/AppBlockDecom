package androidx.media3.container;

import androidx.media3.common.Metadata;
import com.google.common.primitives.Longs;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4TimestampData implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f41672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f41673c;

    public Mp4TimestampData(long j3, long j4) {
        this.f41671a = j3;
        this.f41672b = j4;
        this.f41673c = -1L;
    }

    public static long d(long j3) {
        return (j3 / 1000) + 2082844800;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        return this.f41671a == mp4TimestampData.f41671a && this.f41672b == mp4TimestampData.f41672b && this.f41673c == mp4TimestampData.f41673c;
    }

    public int hashCode() {
        return ((((527 + Longs.e(this.f41671a)) * 31) + Longs.e(this.f41672b)) * 31) + Longs.e(this.f41673c);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.f41671a + ", modification time=" + this.f41672b + ", timescale=" + this.f41673c;
    }

    public Mp4TimestampData(long j3, long j4, long j5) {
        this.f41671a = j3;
        this.f41672b = j4;
        this.f41673c = j5;
    }
}
