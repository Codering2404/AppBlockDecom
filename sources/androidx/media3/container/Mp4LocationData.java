package androidx.media3.container;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import com.google.common.primitives.Floats;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4LocationData implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f41668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f41669b;

    public Mp4LocationData(float f3, float f4) {
        Assertions.b(f3 >= -90.0f && f3 <= 90.0f && f4 >= -180.0f && f4 <= 180.0f, "Invalid latitude or longitude");
        this.f41668a = f3;
        this.f41669b = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Mp4LocationData.class == obj.getClass()) {
            Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
            if (this.f41668a == mp4LocationData.f41668a && this.f41669b == mp4LocationData.f41669b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Floats.c(this.f41668a)) * 31) + Floats.c(this.f41669b);
    }

    public String toString() {
        return "xyz: latitude=" + this.f41668a + ", longitude=" + this.f41669b;
    }
}
