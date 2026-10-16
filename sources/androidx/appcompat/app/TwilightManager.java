package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class TwilightManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static TwilightManager f1123d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationManager f1125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TwilightState f1126c = new TwilightState();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TwilightState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1128b;

        TwilightState() {
        }
    }

    TwilightManager(Context context, LocationManager locationManager) {
        this.f1124a = context;
        this.f1125b = locationManager;
    }

    static TwilightManager a(Context context) {
        if (f1123d == null) {
            Context applicationContext = context.getApplicationContext();
            f1123d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1123d;
    }

    private Location b() {
        Location locationC = PermissionChecker.b(this.f1124a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = PermissionChecker.b(this.f1124a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f1125b.isProviderEnabled(str)) {
                return this.f1125b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e3) {
            Log.d("TwilightManager", "Failed to get last known location", e3);
            return null;
        }
    }

    private boolean e() {
        return this.f1126c.f1128b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j3;
        TwilightState twilightState = this.f1126c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        TwilightCalculator twilightCalculatorB = TwilightCalculator.b();
        twilightCalculatorB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        twilightCalculatorB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z2 = twilightCalculatorB.f1122c == 1;
        long j4 = twilightCalculatorB.f1121b;
        long j5 = twilightCalculatorB.f1120a;
        twilightCalculatorB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j6 = twilightCalculatorB.f1121b;
        if (j4 == -1 || j5 == -1) {
            j3 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis > j5) {
                j4 = j6;
            } else if (jCurrentTimeMillis > j4) {
                j4 = j5;
            }
            j3 = j4 + 60000;
        }
        twilightState.f1127a = z2;
        twilightState.f1128b = j3;
    }

    boolean d() {
        TwilightState twilightState = this.f1126c;
        if (e()) {
            return twilightState.f1127a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return twilightState.f1127a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i3 = Calendar.getInstance().get(11);
        return i3 < 6 || i3 >= 22;
    }
}
