package androidx.media3.container;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4OrientationData implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41670a;

    public Mp4OrientationData(int i3) {
        Assertions.b(i3 == 0 || i3 == 90 || i3 == 180 || i3 == 270, "Unsupported orientation");
        this.f41670a = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mp4OrientationData) && this.f41670a == ((Mp4OrientationData) obj).f41670a;
    }

    public int hashCode() {
        return 527 + Integer.hashCode(this.f41670a);
    }

    public String toString() {
        return "Orientation= " + this.f41670a;
    }
}
