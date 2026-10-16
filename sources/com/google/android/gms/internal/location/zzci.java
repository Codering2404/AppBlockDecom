package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedOrientationProviderClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzci extends GoogleApi implements FusedOrientationProviderClient {
    public static final /* synthetic */ int zza = 0;

    public zzci(Activity activity) {
        super(activity, zzbi.zzb, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    protected final String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final Task<Void> removeOrientationUpdates(DeviceOrientationListener deviceOrientationListener) {
        return doUnregisterEventListener(ListenerHolders.c(deviceOrientationListener, DeviceOrientationListener.class.getSimpleName()), 2440).continueWith(zzcm.zza, zzck.zza);
    }

    public final Task<Void> requestOrientationUpdates(final DeviceOrientationRequest deviceOrientationRequest, Executor executor, DeviceOrientationListener deviceOrientationListener) {
        final ListenerHolder listenerHolderB = ListenerHolders.b(deviceOrientationListener, executor, DeviceOrientationListener.class.getSimpleName());
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.internal.location.zzcl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzdz) obj).zzC(listenerHolderB, deviceOrientationRequest, (TaskCompletionSource) obj2);
            }
        };
        return doRegisterEventListener(RegistrationMethods.a().b(remoteCall).d(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzcj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzdz zzdzVar = (zzdz) obj;
                ListenerHolder.ListenerKey listenerKeyB = listenerHolderB.b();
                if (listenerKeyB != null) {
                    zzdzVar.zzD(listenerKeyB, taskCompletionSource);
                }
            }
        }).e(listenerHolderB).c(2434).a());
    }

    public zzci(Context context) {
        super(context, zzbi.zzb, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }
}
