package cz.mobilesoft.coreblock.util.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;
import cz.mobilesoft.coreblock.dto.GeofenceHolder;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver;
import cz.mobilesoft.coreblock.service.worker.LocationCheckWorker;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import cz.mobilesoft.coreblock.util.location.GeofenceHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GeofenceHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GeofenceHelper f128735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f128736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f128737c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class GeofenceResultCallback implements ResultCallback<Status> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private GoogleApiClient f128738a;

        @Override // com.google.android.gms.common.api.ResultCallback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Status status) {
            GoogleApiClient googleApiClient;
            Intrinsics.checkNotNullParameter(status, "status");
            GoogleApiClient googleApiClient2 = this.f128738a;
            if (googleApiClient2 == null || !googleApiClient2.l() || (googleApiClient = this.f128738a) == null) {
                return;
            }
            googleApiClient.e();
        }

        public final void c(GoogleApiClient googleApiClient) {
            this.f128738a = googleApiClient;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class GoogleApiClientWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private GoogleApiClient f128739a;

        public final GoogleApiClient a() {
            return this.f128739a;
        }

        public final void b(GoogleApiClient googleApiClient) {
            this.f128739a = googleApiClient;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final GeofenceHelper geofenceHelper = new GeofenceHelper();
        f128735a = geofenceHelper;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f128736b = LazyKt.a(lazyThreadSafetyModeB, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.util.location.GeofenceHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = geofenceHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), qualifier, objArr);
            }
        });
        f128737c = 8;
    }

    private GeofenceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GeofenceResultCallback geofenceResultCallback, ConnectionResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        geofenceResultCallback.a(new Status(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Context context, GoogleApiClient googleApiClient, PendingIntent pendingIntent, ResultCallback resultCallback) {
        if (j(context)) {
            LocationServices.f72967c.removeGeofences(googleApiClient, pendingIntent).setResultCallback(resultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Context context, GoogleApiClient googleApiClient, List list, ResultCallback resultCallback) {
        if (j(context)) {
            LocationServices.f72967c.removeGeofences(googleApiClient, list).setResultCallback(resultCallback);
        }
    }

    public static final boolean j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String[] strArrB = PermissionHelper.b();
        Intrinsics.checkNotNullExpressionValue(strArrB, "getLocationPermissions(...)");
        for (String str : strArrB) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    private final Geofence k(LatLng latLng, float f3, String str) {
        Geofence geofenceA = new Geofence.Builder().e(str).b(latLng.f73163a, latLng.f73164b, f3).c(2592000000L).f(3).d(1000).a();
        Intrinsics.checkNotNullExpressionValue(geofenceA, "build(...)");
        return geofenceA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent m(Context context) {
        Intent intent = new Intent(context, (Class<?>) GeofenceTransitionReceiver.class);
        intent.setAction("cz.mobilesoft.appblock.ACTION_RECEIVE_GEOFENCE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final GeofencingRequest n(List list) {
        GeofencingRequest geofencingRequestC = new GeofencingRequest.Builder().d(7).b(list).c();
        Intrinsics.checkNotNullExpressionValue(geofencingRequestC, "build(...)");
        return geofencingRequestC;
    }

    private final GoogleApiClient o(Context context, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        GoogleApiClient googleApiClientD = new GoogleApiClient.Builder(context).b(connectionCallbacks).c(onConnectionFailedListener).a(LocationServices.f72965a).d();
        Intrinsics.checkNotNullExpressionValue(googleApiClientD, "build(...)");
        return googleApiClientD;
    }

    private final GeoAddressDao p() {
        return (GeoAddressDao) f128736b.getValue();
    }

    public static final String r(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    private final void u(final Context context, final List list, final GeofenceResultCallback geofenceResultCallback) {
        final GoogleApiClientWrapper googleApiClientWrapper = new GoogleApiClientWrapper();
        GoogleApiClient googleApiClientO = o(context, new GoogleApiClient.ConnectionCallbacks() { // from class: cz.mobilesoft.coreblock.util.location.GeofenceHelper$recreateAllGeofences$googleApiClient$1
            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnected(Bundle bundle) {
                GoogleApiClient googleApiClientA = googleApiClientWrapper.a();
                if (googleApiClientA != null) {
                    GeofenceHelper.f128735a.w(context, list, googleApiClientA, geofenceResultCallback);
                }
            }

            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnectionSuspended(int i3) {
                geofenceResultCallback.a(new Status(-1));
            }
        }, new GoogleApiClient.OnConnectionFailedListener() { // from class: cz.mobilesoft.coreblock.util.location.c
            @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
            public final void onConnectionFailed(ConnectionResult connectionResult) {
                GeofenceHelper.v(geofenceResultCallback, connectionResult);
            }
        });
        googleApiClientWrapper.b(googleApiClientO);
        geofenceResultCallback.c(googleApiClientO);
        googleApiClientO.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GeofenceResultCallback geofenceResultCallback, ConnectionResult connectionResult) {
        geofenceResultCallback.a(new Status(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Context context, List list, GoogleApiClient googleApiClient, ResultCallback resultCallback) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GeoAddress geoAddress = (GeoAddress) it.next();
            arrayList.add(k(geoAddress.p(), geoAddress.i(), geoAddress.a()));
        }
        h(context, googleApiClient, n(arrayList), m(context), resultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GeofenceResultCallback geofenceResultCallback, ConnectionResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        geofenceResultCallback.a(new Status(-1));
    }

    public final void A(final Context context, final String geofenceId, final GeofenceResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(geofenceId, "geofenceId");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        LocationCheckHelper.f128775n.c();
        final GoogleApiClientWrapper googleApiClientWrapper = new GoogleApiClientWrapper();
        GoogleApiClient googleApiClientO = o(context, new GoogleApiClient.ConnectionCallbacks() { // from class: cz.mobilesoft.coreblock.util.location.GeofenceHelper$removeGeofenceForProfile$googleApiClient$1
            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnected(Bundle bundle) {
                GoogleApiClient googleApiClientA = googleApiClientWrapper.a();
                if (googleApiClientA != null) {
                    Context context2 = context;
                    String str = geofenceId;
                    GeofenceHelper.f128735a.D(context2, googleApiClientA, CollectionsKt.listOf(str), resultCallback);
                }
            }

            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnectionSuspended(int i3) {
                resultCallback.a(new Status(-1));
            }
        }, new GoogleApiClient.OnConnectionFailedListener() { // from class: cz.mobilesoft.coreblock.util.location.a
            @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
            public final void onConnectionFailed(ConnectionResult connectionResult) {
                GeofenceHelper.B(resultCallback, connectionResult);
            }
        });
        googleApiClientWrapper.b(googleApiClientO);
        resultCallback.c(googleApiClientO);
        googleApiClientO.d();
    }

    public final boolean i(GeofenceHolder geofenceHolder, GeofenceHolder geofenceHolder2) {
        if (!Intrinsics.areEqual(geofenceHolder != null ? geofenceHolder.a() : null, geofenceHolder2 != null ? geofenceHolder2.a() : null)) {
            return false;
        }
        if (!Intrinsics.areEqual(geofenceHolder != null ? Integer.valueOf(geofenceHolder.i()) : null, geofenceHolder2 != null ? Integer.valueOf(geofenceHolder2.i()) : null)) {
            return false;
        }
        if (Intrinsics.areEqual(geofenceHolder != null ? Double.valueOf(geofenceHolder.b()) : null, geofenceHolder2 != null ? Double.valueOf(geofenceHolder2.b()) : null)) {
            return Intrinsics.areEqual(geofenceHolder != null ? Double.valueOf(geofenceHolder.f()) : null, geofenceHolder2 != null ? Double.valueOf(geofenceHolder2.f()) : null);
        }
        return false;
    }

    public final void l(Context context, GeoAddress geoAddress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(geoAddress, "geoAddress");
        ArrayList arrayList = new ArrayList();
        arrayList.add(geoAddress);
        u(context, arrayList, new GeofencesRecreationResultCallback());
        LocationCheckWorker.f123925g.b(context);
    }

    public final Address q(Context context, LatLng latLng) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        try {
            List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(latLng.f73163a, latLng.f73164b, 1);
            if (fromLocation != null) {
                return (Address) CollectionsKt.firstOrNull((List) fromLocation);
            }
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final int s(Projection projection, LatLng base, float f3) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        Intrinsics.checkNotNullParameter(base, "base");
        Location location = new Location("");
        location.setLatitude(base.f73163a);
        location.setLongitude(base.f73164b);
        Location location2 = new Location("");
        location2.setLatitude(base.f73163a);
        location2.setLongitude(base.f73164b + 0.5d);
        double dDistanceTo = ((double) f3) * (0.5d / ((double) location.distanceTo(location2)));
        Point pointA = projection.a(base);
        Intrinsics.checkNotNullExpressionValue(pointA, "toScreenLocation(...)");
        Point pointA2 = projection.a(new LatLng(base.f73163a, base.f73164b + dDistanceTo));
        Intrinsics.checkNotNullExpressionValue(pointA2, "toScreenLocation(...)");
        return Math.abs(pointA2.x - pointA.x);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(android.content.Context r8, cz.mobilesoft.coreblock.util.location.GeofenceHelper.GeofenceResultCallback r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.util.location.GeofenceHelper$recreateAllGeofences$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.util.location.GeofenceHelper$recreateAllGeofences$1 r0 = (cz.mobilesoft.coreblock.util.location.GeofenceHelper$recreateAllGeofences$1) r0
            int r1 = r0.f128745g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128745g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.location.GeofenceHelper$recreateAllGeofences$1 r0 = new cz.mobilesoft.coreblock.util.location.GeofenceHelper$recreateAllGeofences$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f128743d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128745g
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r8 = r0.f128742c
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = r0.f128741b
            cz.mobilesoft.coreblock.util.location.GeofenceHelper$GeofenceResultCallback r8 = (cz.mobilesoft.coreblock.util.location.GeofenceHelper.GeofenceResultCallback) r8
            java.lang.Object r9 = r0.f128740a
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.b(r10)
            goto L83
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            java.lang.Object r8 = r0.f128741b
            r9 = r8
            cz.mobilesoft.coreblock.util.location.GeofenceHelper$GeofenceResultCallback r9 = (cz.mobilesoft.coreblock.util.location.GeofenceHelper.GeofenceResultCallback) r9
            java.lang.Object r8 = r0.f128740a
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.b(r10)
            goto L62
        L4e:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao r10 = r7.p()
            r0.f128740a = r8
            r0.f128741b = r9
            r0.f128745g = r5
            java.lang.Object r10 = r10.k(r0)
            if (r10 != r1) goto L62
            goto L7f
        L62:
            java.util.List r10 = (java.util.List) r10
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L93
            cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion r2 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.f128775n
            r0.f128740a = r8
            r0.f128741b = r9
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f128742c = r10
            r0.f128745g = r4
            r10 = 0
            java.lang.Object r10 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.b(r2, r3, r0, r5, r10)
            if (r10 != r1) goto L80
        L7f:
            return r1
        L80:
            r6 = r9
            r9 = r8
            r8 = r6
        L83:
            cz.mobilesoft.coreblock.service.worker.LocationCheckWorker$Companion r10 = cz.mobilesoft.coreblock.service.worker.LocationCheckWorker.f123925g
            r10.a(r9)
            com.google.android.gms.common.api.Status r9 = new com.google.android.gms.common.api.Status
            r9.<init>(r3)
            r8.a(r9)
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L93:
            cz.mobilesoft.coreblock.service.worker.LocationCheckWorker$Companion r0 = cz.mobilesoft.coreblock.service.worker.LocationCheckWorker.f123925g
            r0.b(r8)
            r7.u(r8, r10, r9)
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.GeofenceHelper.t(android.content.Context, cz.mobilesoft.coreblock.util.location.GeofenceHelper$GeofenceResultCallback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void x(final Context context, final GeofenceResultCallback resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        LocationCheckHelper.f128775n.c();
        final GoogleApiClientWrapper googleApiClientWrapper = new GoogleApiClientWrapper();
        GoogleApiClient googleApiClientO = o(context, new GoogleApiClient.ConnectionCallbacks() { // from class: cz.mobilesoft.coreblock.util.location.GeofenceHelper$removeAllGeofences$googleApiClient$1
            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnected(Bundle bundle) {
                GoogleApiClient googleApiClientA = googleApiClientWrapper.a();
                if (googleApiClientA != null) {
                    Context context2 = context;
                    GeofenceHelper.GeofenceResultCallback geofenceResultCallback = resultCallback;
                    GeofenceHelper geofenceHelper = GeofenceHelper.f128735a;
                    geofenceHelper.C(context2, googleApiClientA, geofenceHelper.m(context2), geofenceResultCallback);
                }
            }

            @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
            public void onConnectionSuspended(int i3) {
                resultCallback.a(new Status(-1));
            }
        }, new GoogleApiClient.OnConnectionFailedListener() { // from class: cz.mobilesoft.coreblock.util.location.b
            @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
            public final void onConnectionFailed(ConnectionResult connectionResult) {
                GeofenceHelper.y(resultCallback, connectionResult);
            }
        });
        googleApiClientWrapper.b(googleApiClientO);
        resultCallback.c(googleApiClientO);
        googleApiClientO.d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c5, code lost:
    
        if (r14 != r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(android.content.Context r10, long r11, cz.mobilesoft.coreblock.util.location.GeofenceHelper.GeofenceResultCallback r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.GeofenceHelper.z(android.content.Context, long, cz.mobilesoft.coreblock.util.location.GeofenceHelper$GeofenceResultCallback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void h(Context context, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent, ResultCallback resultCallback) {
        if (j(context)) {
            LocationServices.f72967c.addGeofences(googleApiClient, geofencingRequest, pendingIntent).setResultCallback(resultCallback);
            String str = "Creating geofences: " + geofencingRequest.M();
            String simpleName = GeofenceHelper.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, YgVrd.cYOG);
            Log.d(simpleName, str);
        }
    }
}
