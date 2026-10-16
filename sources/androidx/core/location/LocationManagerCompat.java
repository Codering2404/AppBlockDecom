package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LocationManagerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final WeakHashMap f34063a = new WeakHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api19Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api28Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api31Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GnssListenersHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SimpleArrayMap f34070a = new SimpleArrayMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final SimpleArrayMap f34071b = new SimpleArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GnssMeasurementsEvent.Callback f34072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Executor f34073b;

        public static /* synthetic */ void a(GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (gnssMeasurementsTransport.f34073b != executor) {
                return;
            }
            gnssMeasurementsTransport.f34072a.onGnssMeasurementsReceived(gnssMeasurementsEvent);
        }

        public static /* synthetic */ void b(GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i3) {
            if (gnssMeasurementsTransport.f34073b != executor) {
                return;
            }
            gnssMeasurementsTransport.f34072a.onStatusChanged(i3);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(final GnssMeasurementsEvent gnssMeasurementsEvent) {
            final Executor executor = this.f34073b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.b
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.GnssMeasurementsTransport.a(this.f34094a, executor, gnssMeasurementsEvent);
                }
            });
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(final int i3) {
            final Executor executor = this.f34073b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.c
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.GnssMeasurementsTransport.b(this.f34097a, executor, i3);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GnssStatusTransport extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GnssStatusCompat.Callback f34074a;

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i3) {
            this.f34074a.a(i3);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f34074a.b(GnssStatusCompat.a(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.f34074a.c();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.f34074a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class GpsStatusTransport implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocationManager f34075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final GnssStatusCompat.Callback f34076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile Executor f34077c;

        public static /* synthetic */ void a(GpsStatusTransport gpsStatusTransport, Executor executor) {
            if (gpsStatusTransport.f34077c != executor) {
                return;
            }
            gpsStatusTransport.f34076b.d();
        }

        public static /* synthetic */ void b(GpsStatusTransport gpsStatusTransport, Executor executor) {
            if (gpsStatusTransport.f34077c != executor) {
                return;
            }
            gpsStatusTransport.f34076b.c();
        }

        public static /* synthetic */ void c(GpsStatusTransport gpsStatusTransport, Executor executor, int i3) {
            if (gpsStatusTransport.f34077c != executor) {
                return;
            }
            gpsStatusTransport.f34076b.a(i3);
        }

        public static /* synthetic */ void d(GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (gpsStatusTransport.f34077c != executor) {
                return;
            }
            gpsStatusTransport.f34076b.b(gnssStatusCompat);
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i3) {
            GpsStatus gpsStatus;
            final Executor executor = this.f34077c;
            if (executor == null) {
                return;
            }
            if (i3 == 1) {
                executor.execute(new Runnable() { // from class: androidx.core.location.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.b(this.f34100a, executor);
                    }
                });
                return;
            }
            if (i3 == 2) {
                executor.execute(new Runnable() { // from class: androidx.core.location.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.a(this.f34102a, executor);
                    }
                });
                return;
            }
            if (i3 != 3) {
                if (i3 == 4 && (gpsStatus = this.f34075a.getGpsStatus(null)) != null) {
                    final GnssStatusCompat gnssStatusCompatB = GnssStatusCompat.b(gpsStatus);
                    executor.execute(new Runnable() { // from class: androidx.core.location.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocationManagerCompat.GpsStatusTransport.d(this.f34107a, executor, gnssStatusCompatB);
                        }
                    });
                    return;
                }
                return;
            }
            GpsStatus gpsStatus2 = this.f34075a.getGpsStatus(null);
            if (gpsStatus2 != null) {
                final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                executor.execute(new Runnable() { // from class: androidx.core.location.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.c(this.f34104a, executor, timeToFirstFix);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InlineHandlerExecutor implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f34078a;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (Looper.myLooper() == this.f34078a.getLooper()) {
                runnable.run();
            } else {
                if (this.f34078a.post((Runnable) Preconditions.h(runnable))) {
                    return;
                }
                throw new RejectedExecutionException(this.f34078a + " is shutting down");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LocationListenerKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f34079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final LocationListenerCompat f34080b;

        public boolean equals(Object obj) {
            if (!(obj instanceof LocationListenerKey)) {
                return false;
            }
            LocationListenerKey locationListenerKey = (LocationListenerKey) obj;
            return this.f34079a.equals(locationListenerKey.f34079a) && this.f34080b.equals(locationListenerKey.f34080b);
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f34079a, this.f34080b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PreRGnssStatusTransport extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GnssStatusCompat.Callback f34083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Executor f34084b;

        public static /* synthetic */ void a(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
            if (preRGnssStatusTransport.f34084b != executor) {
                return;
            }
            preRGnssStatusTransport.f34083a.d();
        }

        public static /* synthetic */ void b(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i3) {
            if (preRGnssStatusTransport.f34084b != executor) {
                return;
            }
            preRGnssStatusTransport.f34083a.a(i3);
        }

        public static /* synthetic */ void c(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
            if (preRGnssStatusTransport.f34084b != executor) {
                return;
            }
            preRGnssStatusTransport.f34083a.c();
        }

        public static /* synthetic */ void d(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
            if (preRGnssStatusTransport.f34084b != executor) {
                return;
            }
            preRGnssStatusTransport.f34083a.b(GnssStatusCompat.a(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i3) {
            final Executor executor = this.f34084b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.n
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.b(this.f34124a, executor, i3);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.f34084b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.o
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.d(this.f34127a, executor, gnssStatus);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.f34084b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.q
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.c(this.f34132a, executor);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.f34084b;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.p
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.a(this.f34130a, executor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LocationListenerTransport implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile LocationListenerKey f34081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f34082b;

        public static /* synthetic */ void a(LocationListenerTransport locationListenerTransport, String str) {
            LocationListenerKey locationListenerKey = locationListenerTransport.f34081a;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.f34080b.onProviderEnabled(str);
        }

        public static /* synthetic */ void b(LocationListenerTransport locationListenerTransport, String str, int i3, Bundle bundle) {
            LocationListenerKey locationListenerKey = locationListenerTransport.f34081a;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.f34080b.onStatusChanged(str, i3, bundle);
        }

        public static /* synthetic */ void c(LocationListenerTransport locationListenerTransport, Location location) {
            LocationListenerKey locationListenerKey = locationListenerTransport.f34081a;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.f34080b.onLocationChanged(location);
        }

        public static /* synthetic */ void d(LocationListenerTransport locationListenerTransport, List list) {
            LocationListenerKey locationListenerKey = locationListenerTransport.f34081a;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.f34080b.onLocationChanged(list);
        }

        public static /* synthetic */ void e(LocationListenerTransport locationListenerTransport, String str) {
            LocationListenerKey locationListenerKey = locationListenerTransport.f34081a;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.f34080b.onProviderDisabled(str);
        }

        public static /* synthetic */ void f(LocationListenerTransport locationListenerTransport, int i3) {
            LocationListenerKey locationListenerKey = locationListenerTransport.f34081a;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.f34080b.onFlushComplete(i3);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i3) {
            if (this.f34081a == null) {
                return;
            }
            this.f34082b.execute(new Runnable() { // from class: androidx.core.location.l
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.f(this.f34118a, i3);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            if (this.f34081a == null) {
                return;
            }
            this.f34082b.execute(new Runnable() { // from class: androidx.core.location.k
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.c(this.f34116a, location);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String str) {
            if (this.f34081a == null) {
                return;
            }
            this.f34082b.execute(new Runnable() { // from class: androidx.core.location.i
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.e(this.f34112a, str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String str) {
            if (this.f34081a == null) {
                return;
            }
            this.f34082b.execute(new Runnable() { // from class: androidx.core.location.h
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.a(this.f34110a, str);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i3, final Bundle bundle) {
            if (this.f34081a == null) {
                return;
            }
            this.f34082b.execute(new Runnable() { // from class: androidx.core.location.m
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.b(this.f34120a, str, i3, bundle);
                }
            });
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final List list) {
            if (this.f34081a == null) {
                return;
            }
            this.f34082b.execute(new Runnable() { // from class: androidx.core.location.j
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.d(this.f34114a, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CancellableLocationListener implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LocationManager f34064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f34065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f34066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Consumer f34067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f34068e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Runnable f34069f;

        private void b() {
            this.f34067d = null;
            this.f34064a.removeUpdates(this);
            Runnable runnable = this.f34069f;
            if (runnable != null) {
                this.f34066c.removeCallbacks(runnable);
                this.f34069f = null;
            }
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            synchronized (this) {
                try {
                    if (this.f34068e) {
                        return;
                    }
                    this.f34068e = true;
                    final Consumer consumer = this.f34067d;
                    this.f34065b.execute(new Runnable() { // from class: androidx.core.location.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            consumer.accept(location);
                        }
                    });
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
        }
    }
}
