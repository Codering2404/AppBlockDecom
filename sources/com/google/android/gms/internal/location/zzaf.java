package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaf implements ActivityRecognitionApi {
    public final PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.h(new zzad(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j3, PendingIntent pendingIntent) {
        return googleApiClient.h(new zzac(this, googleApiClient, j3, pendingIntent));
    }
}
