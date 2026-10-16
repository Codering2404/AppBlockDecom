package androidx.media3.extractor.jpeg;

import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MotionPhotoDescription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f46399b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ContainerItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f46401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f46402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f46403d;

        public ContainerItem(String str, String str2, long j3, long j4) {
            this.f46400a = str;
            this.f46401b = str2;
            this.f46402c = j3;
            this.f46403d = j4;
        }
    }

    public MotionPhotoDescription(long j3, List list) {
        this.f46398a = j3;
        this.f46399b = list;
    }

    public MotionPhotoMetadata a(long j3) {
        long j4;
        if (this.f46399b.size() < 2) {
            return null;
        }
        long j5 = j3;
        long j6 = -1;
        long j7 = -1;
        long j8 = -1;
        long j9 = -1;
        boolean z2 = false;
        for (int size = this.f46399b.size() - 1; size >= 0; size--) {
            ContainerItem containerItem = (ContainerItem) this.f46399b.get(size);
            boolean zEquals = "video/mp4".equals(containerItem.f46400a) | z2;
            if (size == 0) {
                j5 -= containerItem.f46403d;
                j4 = 0;
            } else {
                j4 = j5 - containerItem.f46402c;
            }
            long j10 = j4;
            long j11 = j5;
            j5 = j10;
            if (!zEquals || j5 == j11) {
                z2 = zEquals;
            } else {
                j9 = j11 - j5;
                j8 = j5;
                z2 = false;
            }
            if (size == 0) {
                j6 = j5;
                j7 = j11;
            }
        }
        if (j8 == -1 || j9 == -1 || j6 == -1 || j7 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j6, j7, this.f46398a, j8, j9);
    }
}
