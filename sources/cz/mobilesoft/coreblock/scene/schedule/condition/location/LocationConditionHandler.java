package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.SharedLocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.CameraCenterMoveDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.util.location.GeofenceHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

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
public interface LocationConditionHandler {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    private default double e(double d3) {
        return (d3 * 3.141592653589793d) / ((double) SensibleDefaults.X_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    default java.lang.Object u(com.google.android.gms.maps.model.LatLng r34, kotlin.coroutines.Continuation r35) throws java.lang.Throwable {
        /*
            r33 = this;
            r1 = r33
            r0 = r35
            boolean r2 = r0 instanceof cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$1
            if (r2 == 0) goto L17
            r2 = r0
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$1 r2 = (cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$1) r2
            int r3 = r2.f115353g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f115353g = r3
            goto L1c
        L17:
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$1 r2 = new cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$1
            r2.<init>(r1, r0)
        L1c:
            java.lang.Object r0 = r2.f115351d
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.f115353g
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L3e
            if (r4 != r5) goto L36
            java.lang.Object r3 = r2.f115349b
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r2 = r2.f115348a
            com.google.android.gms.maps.model.LatLng r2 = (com.google.android.gms.maps.model.LatLng) r2
            kotlin.ResultKt.b(r0)
            goto L59
        L36:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L3e:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.L()
            r4 = r34
            r2.f115348a = r4
            r2.f115349b = r0
            r7 = 0
            r2.f115350c = r7
            r2.f115353g = r5
            java.lang.Object r2 = r0.f(r6, r2)
            if (r2 != r3) goto L57
            return r3
        L57:
            r3 = r0
            r2 = r4
        L59:
            kotlinx.coroutines.Job r0 = r1.Q()     // Catch: java.lang.Throwable -> L63
            if (r0 == 0) goto L65
            kotlinx.coroutines.Job.DefaultImpls.b(r0, r6, r5, r6)     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r0 = move-exception
            goto Lb7
        L65:
            cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState r7 = r1.o()     // Catch: java.lang.Throwable -> L63
            cz.mobilesoft.coreblock.util.Loading r27 = cz.mobilesoft.coreblock.util.Loading.f127895a     // Catch: java.lang.Throwable -> L63
            r31 = 7864319(0x77ffff, float:1.1020258E-38)
            r32 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState r0 = cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState.d(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch: java.lang.Throwable -> L63
            r1.f0(r0)     // Catch: java.lang.Throwable -> L63
            kotlinx.coroutines.CoroutineScope r7 = r1.a()     // Catch: java.lang.Throwable -> L63
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$2$1 r10 = new cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$2$1     // Catch: java.lang.Throwable -> L63
            r10.<init>(r1, r2, r6)     // Catch: java.lang.Throwable -> L63
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L63
            r1.P(r0)     // Catch: java.lang.Throwable -> L63
            kotlin.Unit r0 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L63
            r3.i(r6)
            kotlin.Unit r0 = kotlin.Unit.f139807a
            return r0
        Lb7:
            r3.i(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler.u(com.google.android.gms.maps.model.LatLng, kotlin.coroutines.Continuation):java.lang.Object");
    }

    default LatLngBounds C(LatLng center, double d3) {
        Intrinsics.checkNotNullParameter(center, "center");
        double d4 = d3 / 111320.0d;
        double dCos = d3 / (Math.cos(e(center.f73163a)) * 111320.0d);
        return new LatLngBounds(new LatLng(center.f73163a - d4, center.f73164b - dCos), new LatLng(center.f73163a + d4, center.f73164b + dCos));
    }

    default void D() {
        LocationCallback locationCallback = new LocationCallback() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startLocationUpdatesIfPossible$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                super.onLocationResult(locationResult);
                Location locationM = locationResult.M();
                LatLng latLng = locationM != null ? new LatLng(locationM.getLatitude(), locationM.getLongitude()) : null;
                LocationConditionHandler locationConditionHandler = this.f115361a;
                locationConditionHandler.f0(LocationConfigurationViewState.d(locationConditionHandler.o(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, latLng, null, 6291455, null));
                if (this.f115361a.o().m() != null || latLng == null) {
                    return;
                }
                this.f115361a.E(latLng);
            }
        };
        if (!S()) {
            V().requestLocationUpdates(H(), locationCallback, Looper.myLooper());
        }
        q0(locationCallback);
    }

    default void E(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        f0(LocationConfigurationViewState.d(o(), 0, latLng, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new CameraCenterMoveDTO(latLng, 0L, 2, null), null, C(latLng, o().j()), 3145725, null));
        BuildersKt__Builders_commonKt.d(getScope(), null, null, new LocationConditionHandler$onMapClicked$1(this, latLng, null), 3, null);
    }

    LocationCallback F();

    LocationRequest H();

    Mutex L();

    CoroutineScope N();

    void P(Job job);

    Job Q();

    default boolean S() {
        Intrinsics.checkNotNullExpressionValue(LockieApplication.g(), "getContext(...)");
        return !GeofenceHelper.j(r0);
    }

    FusedLocationProviderClient V();

    CoroutineScope a();

    void f0(LocationConfigurationViewState locationConfigurationViewState);

    Context getContext();

    CoroutineScope getScope();

    LocationConfigurationViewState o();

    default void o0(SharedLocationConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SharedLocationConditionViewEvent.OnSettingsChanged) {
            SharedLocationConditionViewEvent.OnSettingsChanged onSettingsChanged = (SharedLocationConditionViewEvent.OnSettingsChanged) event;
            if (onSettingsChanged instanceof SharedLocationConditionViewEvent.OnSettingsChanged.Inverted) {
                f0(LocationConfigurationViewState.d(o(), 0, null, ((SharedLocationConditionViewEvent.OnSettingsChanged.Inverted) event).a(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388603, null));
                return;
            }
            if (!(onSettingsChanged instanceof SharedLocationConditionViewEvent.OnSettingsChanged.Radius)) {
                throw new NoWhenBranchMatchedException();
            }
            LocationConfigurationViewState locationConfigurationViewStateO = o();
            int iA = ((SharedLocationConditionViewEvent.OnSettingsChanged.Radius) event).a();
            LatLng latLngM = locationConfigurationViewStateO.m();
            f0(LocationConfigurationViewState.d(locationConfigurationViewStateO, iA, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, latLngM != null ? C(latLngM, r1.a()) : null, 4194302, null));
            return;
        }
        if (event instanceof SharedLocationConditionViewEvent.OnMapClicked) {
            E(((SharedLocationConditionViewEvent.OnMapClicked) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, SharedLocationConditionViewEvent.OnCurrentPositionClicked.f115490a)) {
            LatLng latLngK = o().k();
            if (latLngK != null) {
                f0(LocationConfigurationViewState.d(o(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new CameraCenterMoveDTO(latLngK, 0L, 2, null), null, null, 7340031, null));
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event, SharedLocationConditionViewEvent.OnMissingPermissionsChanged.f115492a)) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new LocationConditionHandler$handleSharedLocationConditionEvent$3(this, o().l(), null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, SharedLocationConditionViewEvent.OnPaused.f115493a)) {
            BuildersKt__Builders_commonKt.d(N(), null, null, new LocationConditionHandler$handleSharedLocationConditionEvent$4(this, null), 3, null);
        } else if (Intrinsics.areEqual(event, SharedLocationConditionViewEvent.OnResumed.f115495a)) {
            BuildersKt__Builders_commonKt.d(N(), null, null, new LocationConditionHandler$handleSharedLocationConditionEvent$5(this, null), 3, null);
        } else {
            if (!(event instanceof SharedLocationConditionViewEvent.OnPlaceByAddressSelected)) {
                throw new NoWhenBranchMatchedException();
            }
            E(((SharedLocationConditionViewEvent.OnPlaceByAddressSelected) event).a());
        }
    }

    void q0(LocationCallback locationCallback);

    default void t() {
        LocationCallback locationCallbackF = F();
        if (locationCallbackF != null) {
            V().removeLocationUpdates(locationCallbackF);
        }
    }
}
