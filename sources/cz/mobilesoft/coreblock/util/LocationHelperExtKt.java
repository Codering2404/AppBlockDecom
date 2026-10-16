package cz.mobilesoft.coreblock.util;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocationHelperExtKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WeakReference weakReference, Function1 function1, Exception exc) {
        if (weakReference.get() == null) {
            return;
        }
        Intrinsics.checkNotNull(exc, "null cannot be cast to non-null type com.google.android.gms.common.api.ApiException");
        int statusCode = ((ApiException) exc).getStatusCode();
        if (statusCode == 6) {
            try {
                function1.invoke((ResolvableApiException) exc);
            } catch (IntentSender.SendIntentException | ClassCastException unused) {
            }
        } else {
            if (statusCode != 8502) {
                return;
            }
            Object obj = weakReference.get();
            Intrinsics.checkNotNull(obj);
            ((Activity) obj).startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    public static final void b(Activity activity, OnSuccessListener onSuccessListener, final Function1 onException) {
        Intrinsics.checkNotNullParameter(onSuccessListener, "onSuccessListener");
        Intrinsics.checkNotNullParameter(onException, "onException");
        if (activity == null) {
            return;
        }
        String[] strArrB = PermissionHelper.b();
        Intrinsics.checkNotNullExpressionValue(strArrB, "getLocationPermissions(...)");
        for (String str : strArrB) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                return;
            }
        }
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.Q2(180000L);
        locationRequest.P2(30000L);
        locationRequest.R2(100);
        locationRequest.O2(60000L);
        LocationSettingsRequest.Builder builderA = new LocationSettingsRequest.Builder().a(locationRequest);
        Intrinsics.checkNotNullExpressionValue(builderA, "addLocationRequest(...)");
        SettingsClient settingsClientB = LocationServices.b(activity);
        Intrinsics.checkNotNullExpressionValue(settingsClientB, FptyjHFU.JYBgOXW);
        Task taskCheckLocationSettings = settingsClientB.checkLocationSettings(builderA.b());
        Intrinsics.checkNotNullExpressionValue(taskCheckLocationSettings, "checkLocationSettings(...)");
        final WeakReference weakReference = new WeakReference(activity);
        taskCheckLocationSettings.addOnSuccessListener(activity, onSuccessListener);
        taskCheckLocationSettings.addOnFailureListener(activity, new OnFailureListener() { // from class: cz.mobilesoft.coreblock.util.s
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationHelperExtKt.c(weakReference, onException, exc);
            }
        });
    }
}
