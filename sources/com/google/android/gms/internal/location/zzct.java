package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzct extends GoogleApi implements GeofencingClient {
    public static final /* synthetic */ int zza = 0;

    public zzct(Activity activity) {
        super(activity, zzbi.zzb, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    public final Task<Void> addGeofences(final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzcw
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzdz) obj).zzE(geofencingRequest, pendingIntent, (TaskCompletionSource) obj2);
            }
        }).e(2424).a());
    }

    public final Task<Void> removeGeofences(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzcu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzdz) obj).zzF(zzem.zzb(pendingIntent), (TaskCompletionSource) obj2);
            }
        }).e(2425).a());
    }

    public zzct(Context context) {
        super(context, zzbi.zzb, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    public final Task<Void> removeGeofences(final List<String> list) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzcv
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzdz) obj).zzF(zzem.zza(list), (TaskCompletionSource) obj2);
            }
        }).e(2425).a());
    }
}
