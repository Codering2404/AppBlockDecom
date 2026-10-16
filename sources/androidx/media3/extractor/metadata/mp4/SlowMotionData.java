package androidx.media3.extractor.metadata.mp4;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SlowMotionData implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f46497a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Segment {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Comparator f46498d = new Comparator() { // from class: androidx.media3.extractor.metadata.mp4.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                SlowMotionData.Segment segment = (SlowMotionData.Segment) obj;
                SlowMotionData.Segment segment2 = (SlowMotionData.Segment) obj2;
                return ComparisonChain.k().e(segment.f46499a, segment2.f46499a).e(segment.f46500b, segment2.f46500b).d(segment.f46501c, segment2.f46501c).j();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f46499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f46500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46501c;

        public Segment(long j3, long j4, int i3) {
            Assertions.a(j3 < j4);
            this.f46499a = j3;
            this.f46500b = j4;
            this.f46501c = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Segment.class == obj.getClass()) {
                Segment segment = (Segment) obj;
                if (this.f46499a == segment.f46499a && this.f46500b == segment.f46500b && this.f46501c == segment.f46501c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f46499a), Long.valueOf(this.f46500b), Integer.valueOf(this.f46501c));
        }

        public String toString() {
            return Util.J("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f46499a), Long.valueOf(this.f46500b), Integer.valueOf(this.f46501c));
        }
    }

    public SlowMotionData(List list) {
        this.f46497a = list;
        Assertions.a(!d(list));
    }

    private static boolean d(List list) {
        if (list.isEmpty()) {
            return false;
        }
        long j3 = ((Segment) list.get(0)).f46500b;
        for (int i3 = 1; i3 < list.size(); i3++) {
            if (((Segment) list.get(i3)).f46499a < j3) {
                return true;
            }
            j3 = ((Segment) list.get(i3)).f46500b;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f46497a.equals(((SlowMotionData) obj).f46497a);
    }

    public int hashCode() {
        return this.f46497a.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f46497a;
    }
}
