package androidx.media3.common;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Longs;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Metadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Entry[] f40925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f40926b;

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    public Metadata a(Entry... entryArr) {
        return entryArr.length == 0 ? this : new Metadata(this.f40926b, (Entry[]) Util.T0(this.f40925a, entryArr));
    }

    public Metadata b(Metadata metadata) {
        return metadata == null ? this : a(metadata.f40925a);
    }

    public Metadata c(long j3) {
        return this.f40926b == j3 ? this : new Metadata(j3, this.f40925a);
    }

    public Entry d(int i3) {
        return this.f40925a[i3];
    }

    public int e() {
        return this.f40925a.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Metadata.class == obj.getClass()) {
            Metadata metadata = (Metadata) obj;
            if (Arrays.equals(this.f40925a, metadata.f40925a) && this.f40926b == metadata.f40926b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f40925a) * 31) + Longs.e(this.f40926b);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f40925a));
        if (this.f40926b == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f40926b;
        }
        sb.append(str);
        return sb.toString();
    }

    public Metadata(long j3, Entry... entryArr) {
        this.f40926b = j3;
        this.f40925a = entryArr;
    }

    public Metadata(List list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public Metadata(long j3, List list) {
        this(j3, (Entry[]) list.toArray(new Entry[0]));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Entry {
        default Format a() {
            return null;
        }

        default byte[] c() {
            return null;
        }

        default void b(MediaMetadata.Builder builder) {
        }
    }
}
