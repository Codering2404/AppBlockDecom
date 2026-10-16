package androidx.media3.extractor.metadata.mp4;

import androidx.media3.common.Metadata;
import com.google.common.primitives.Longs;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f46495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f46496e;

    public MotionPhotoMetadata(long j3, long j4, long j5, long j6, long j7) {
        this.f46492a = j3;
        this.f46493b = j4;
        this.f46494c = j5;
        this.f46495d = j6;
        this.f46496e = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MotionPhotoMetadata.class == obj.getClass()) {
            MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
            if (this.f46492a == motionPhotoMetadata.f46492a && this.f46493b == motionPhotoMetadata.f46493b && this.f46494c == motionPhotoMetadata.f46494c && this.f46495d == motionPhotoMetadata.f46495d && this.f46496e == motionPhotoMetadata.f46496e) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + Longs.e(this.f46492a)) * 31) + Longs.e(this.f46493b)) * 31) + Longs.e(this.f46494c)) * 31) + Longs.e(this.f46495d)) * 31) + Longs.e(this.f46496e);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f46492a + ", photoSize=" + this.f46493b + ", photoPresentationTimestampUs=" + this.f46494c + ", videoStartPosition=" + this.f46495d + ", videoSize=" + this.f46496e;
    }
}
