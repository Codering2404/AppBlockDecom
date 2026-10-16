package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GnssStatusCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConstellationType {
    }

    GnssStatusCompat() {
    }

    public static GnssStatusCompat a(GnssStatus gnssStatus) {
        return new GnssStatusWrapper(gnssStatus);
    }

    public static GnssStatusCompat b(GpsStatus gpsStatus) {
        return new GpsStatusWrapper(gpsStatus);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {
        public void c() {
        }

        public void d() {
        }

        public void a(int i3) {
        }

        public void b(GnssStatusCompat gnssStatusCompat) {
        }
    }
}
