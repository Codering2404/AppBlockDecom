package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GnssStatusWrapper extends GnssStatusCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GnssStatus f34057a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {
    }

    GnssStatusWrapper(Object obj) {
        this.f34057a = (GnssStatus) Preconditions.h((GnssStatus) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GnssStatusWrapper) {
            return this.f34057a.equals(((GnssStatusWrapper) obj).f34057a);
        }
        return false;
    }

    public int hashCode() {
        return this.f34057a.hashCode();
    }
}
