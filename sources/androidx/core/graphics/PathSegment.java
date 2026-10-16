package androidx.core.graphics;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PathSegment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f33973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f33974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointF f33975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f33976d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.f33974b, pathSegment.f33974b) == 0 && Float.compare(this.f33976d, pathSegment.f33976d) == 0 && this.f33973a.equals(pathSegment.f33973a) && this.f33975c.equals(pathSegment.f33975c);
    }

    public int hashCode() {
        int iHashCode = this.f33973a.hashCode() * 31;
        float f3 = this.f33974b;
        int iFloatToIntBits = (((iHashCode + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31) + this.f33975c.hashCode()) * 31;
        float f4 = this.f33976d;
        return iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
    }

    public String toString() {
        return "PathSegment{start=" + this.f33973a + ", startFraction=" + this.f33974b + ", end=" + this.f33975c + ", endFraction=" + this.f33976d + '}';
    }
}
