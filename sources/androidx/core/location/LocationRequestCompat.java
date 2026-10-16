package androidx.core.location;

import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LocationRequestCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f34085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f34086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f34087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f34088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f34089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final float f34090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f34091g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api19Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api31Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        return this.f34085a == locationRequestCompat.f34085a && this.f34086b == locationRequestCompat.f34086b && this.f34087c == locationRequestCompat.f34087c && this.f34088d == locationRequestCompat.f34088d && this.f34089e == locationRequestCompat.f34089e && Float.compare(locationRequestCompat.f34090f, this.f34090f) == 0 && this.f34091g == locationRequestCompat.f34091g;
    }

    public int hashCode() {
        int i3 = this.f34085a * 31;
        long j3 = this.f34086b;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f34087c;
        return i4 + ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.f34086b != Long.MAX_VALUE) {
            sb.append("@");
            TimeUtils.e(this.f34086b, sb);
            int i3 = this.f34085a;
            if (i3 == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i3 == 102) {
                sb.append(" BALANCED");
            } else if (i3 == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.f34088d != Long.MAX_VALUE) {
            sb.append(", duration=");
            TimeUtils.e(this.f34088d, sb);
        }
        if (this.f34089e != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f34089e);
        }
        long j3 = this.f34087c;
        if (j3 != -1 && j3 < this.f34086b) {
            sb.append(", minUpdateInterval=");
            TimeUtils.e(this.f34087c, sb);
        }
        if (this.f34090f > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f34090f);
        }
        if (this.f34091g / 2 > this.f34086b) {
            sb.append(", maxUpdateDelay=");
            TimeUtils.e(this.f34091g, sb);
        }
        sb.append(']');
        return sb.toString();
    }
}
