package androidx.media3.common;

import android.view.Surface;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SurfaceInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Surface f41096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f41100e;

    public SurfaceInfo(Surface surface, int i3, int i4) {
        this(surface, i3, i4, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurfaceInfo)) {
            return false;
        }
        SurfaceInfo surfaceInfo = (SurfaceInfo) obj;
        return this.f41097b == surfaceInfo.f41097b && this.f41098c == surfaceInfo.f41098c && this.f41099d == surfaceInfo.f41099d && this.f41100e == surfaceInfo.f41100e && this.f41096a.equals(surfaceInfo.f41096a);
    }

    public int hashCode() {
        return (((((((this.f41096a.hashCode() * 31) + this.f41097b) * 31) + this.f41098c) * 31) + this.f41099d) * 31) + (this.f41100e ? 1 : 0);
    }

    public SurfaceInfo(Surface surface, int i3, int i4, int i5) {
        this(surface, i3, i4, i5, false);
    }

    public SurfaceInfo(Surface surface, int i3, int i4, int i5, boolean z2) {
        Assertions.b(i5 == 0 || i5 == 90 || i5 == 180 || i5 == 270, "orientationDegrees must be 0, 90, 180, or 270");
        this.f41096a = surface;
        this.f41097b = i3;
        this.f41098c = i4;
        this.f41099d = i5;
        this.f41100e = z2;
    }
}
