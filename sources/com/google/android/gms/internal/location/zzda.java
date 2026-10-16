package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzda extends GoogleApi implements SettingsClient {
    public static final /* synthetic */ int zza = 0;

    public zzda(Activity activity) {
        super(activity, zzbi.zzb, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    @Override // com.google.android.gms.location.SettingsClient
    public final Task<LocationSettingsResponse> checkLocationSettings(final LocationSettingsRequest locationSettingsRequest) {
        return doRead(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzdb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzdz zzdzVar = (zzdz) obj;
                LocationSettingsRequest locationSettingsRequest2 = locationSettingsRequest;
                Preconditions.b(locationSettingsRequest2 != null, "locationSettingsRequest can't be null");
                ((zzv) zzdzVar.getService()).zzD(locationSettingsRequest2, new zzde(taskCompletionSource), null);
            }
        }).e(2426).a());
    }

    public final Task<Boolean> isGoogleLocationAccuracyEnabled() {
        return doRead(TaskApiCall.a().b(zzdc.zza).e(2444).d(com.google.android.gms.location.zzo.f73035m).a());
    }

    public zzda(Context context) {
        super(context, zzbi.zzb, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }
}
