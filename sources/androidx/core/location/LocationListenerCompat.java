package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    default void onLocationChanged(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            onLocationChanged((Location) list.get(i3));
        }
    }

    @Override // android.location.LocationListener
    default void onFlushComplete(int i3) {
    }

    @Override // android.location.LocationListener
    default void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    default void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    default void onStatusChanged(String str, int i3, Bundle bundle) {
    }
}
