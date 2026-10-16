package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GpsStatusWrapper extends GnssStatusCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GpsStatus f34058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator f34060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GpsSatellite f34062e;

    GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.h(gpsStatus);
        this.f34058a = gpsStatus2;
        this.f34059b = -1;
        this.f34060c = gpsStatus2.getSatellites().iterator();
        this.f34061d = -1;
        this.f34062e = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GpsStatusWrapper) {
            return this.f34058a.equals(((GpsStatusWrapper) obj).f34058a);
        }
        return false;
    }

    public int hashCode() {
        return this.f34058a.hashCode();
    }
}
