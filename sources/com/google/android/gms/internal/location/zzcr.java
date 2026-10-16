package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcr implements GeofencingApi {
    static /* synthetic */ TaskCompletionSource zza(final BaseImplementation.ResultHolder resultHolder) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzcs
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                BaseImplementation.ResultHolder resultHolder2 = resultHolder;
                if (task.isSuccessful()) {
                    resultHolder2.setResult(Status.f71537g);
                    return;
                }
                if (task.isCanceled()) {
                    resultHolder2.setFailedResult(Status.f71541k);
                    return;
                }
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    resultHolder2.setFailedResult(((ApiException) exception).getStatus());
                } else {
                    resultHolder2.setFailedResult(Status.f71539i);
                }
            }
        });
        return taskCompletionSource;
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.h(new zzcn(this, googleApiClient, geofencingRequest, pendingIntent));
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.h(new zzco(this, googleApiClient, pendingIntent));
    }

    @Deprecated
    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.b(list);
        builder.d(5);
        return googleApiClient.h(new zzcn(this, googleApiClient, builder.c(), pendingIntent));
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.h(new zzcp(this, googleApiClient, list));
    }
}
