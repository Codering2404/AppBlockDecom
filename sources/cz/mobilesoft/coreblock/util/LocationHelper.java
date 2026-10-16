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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class LocationHelper {
    public static /* synthetic */ void a(WeakReference weakReference, int i3, Exception exc) {
        if (weakReference.get() == null) {
            return;
        }
        int statusCode = ((ApiException) exc).getStatusCode();
        if (statusCode == 6) {
            try {
                ((ResolvableApiException) exc).b((Activity) weakReference.get(), i3);
            } catch (IntentSender.SendIntentException | ClassCastException unused) {
            }
        } else {
            if (statusCode != 8502) {
                return;
            }
            ((Activity) weakReference.get()).startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    public static void b(Activity activity, OnSuccessListener onSuccessListener, final int i3) {
        if (ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            return;
        }
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.Q2(180000L);
        locationRequest.P2(30000L);
        locationRequest.R2(100);
        locationRequest.O2(60000L);
        Task taskCheckLocationSettings = LocationServices.b(activity).checkLocationSettings(new LocationSettingsRequest.Builder().a(locationRequest).b());
        final WeakReference weakReference = new WeakReference(activity);
        taskCheckLocationSettings.addOnSuccessListener(activity, onSuccessListener);
        taskCheckLocationSettings.addOnFailureListener(activity, new OnFailureListener() { // from class: cz.mobilesoft.coreblock.util.r
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationHelper.a(weakReference, i3, exc);
            }
        });
    }
}
