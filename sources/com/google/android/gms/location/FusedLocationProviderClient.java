package com.google.android.gms.location;

import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface FusedLocationProviderClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    Task getCurrentLocation(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken);

    Task getLastLocation();

    Task removeLocationUpdates(LocationCallback locationCallback);

    Task requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);
}
