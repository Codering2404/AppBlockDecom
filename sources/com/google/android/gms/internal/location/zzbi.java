package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbi extends GoogleApi implements FusedLocationProviderClient {
    static final Api.ClientKey zza;
    public static final Api zzb;
    private static final Object zzc;
    private static Object zzd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzb = new Api("LocationServices.API", new zzbf(), clientKey);
        zzc = new Object();
    }

    public zzbi(Activity activity) {
        super(activity, zzb, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    private final Task zza(final LocationRequest locationRequest, ListenerHolder listenerHolder) {
        final zzbh zzbhVar = new zzbh(this, listenerHolder, zzcd.zza);
        return doRegisterEventListener(RegistrationMethods.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbt
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzs(zzbhVar, locationRequest, (TaskCompletionSource) obj2);
            }
        }).d(zzbhVar).e(listenerHolder).c(2435).a());
    }

    private final Task zzb(final LocationRequest locationRequest, ListenerHolder listenerHolder) {
        final zzbh zzbhVar = new zzbh(this, listenerHolder, zzbz.zza);
        return doRegisterEventListener(RegistrationMethods.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzt(zzbhVar, locationRequest, (TaskCompletionSource) obj2);
            }
        }).d(zzbhVar).e(listenerHolder).c(2436).a());
    }

    private final Task zzc(final DeviceOrientationRequest deviceOrientationRequest, final ListenerHolder listenerHolder) {
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbm
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzC(listenerHolder, deviceOrientationRequest, (TaskCompletionSource) obj2);
            }
        };
        return doRegisterEventListener(RegistrationMethods.a().b(remoteCall).d(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbn
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzdz zzdzVar = (zzdz) obj;
                Api api = zzbi.zzb;
                ListenerHolder.ListenerKey listenerKeyB = listenerHolder.b();
                if (listenerKeyB != null) {
                    zzdzVar.zzD(listenerKeyB, taskCompletionSource);
                }
            }
        }).e(listenerHolder).c(2434).a());
    }

    public final Task<Void> flushLocations() {
        return doWrite(TaskApiCall.a().b(zzca.zza).e(2422).a());
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    protected final String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final Task<Location> getCurrentLocation(int i3, CancellationToken cancellationToken) {
        CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
        builder.c(i3);
        CurrentLocationRequest currentLocationRequestA = builder.a();
        if (cancellationToken != null) {
            Preconditions.b(!cancellationToken.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task<Location> taskDoRead = doRead(TaskApiCall.a().b(new zzbp(currentLocationRequestA, cancellationToken)).e(2415).a());
        if (cancellationToken == null) {
            return taskDoRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        taskDoRead.continueWith(new zzbq(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Location> getLastLocation() {
        return doRead(TaskApiCall.a().b(zzby.zza).e(2414).a());
    }

    public final Task<LocationAvailability> getLocationAvailability() {
        return doRead(TaskApiCall.a().b(zzbr.zza).e(2416).a());
    }

    public final Task<Void> removeDeviceOrientationUpdates(DeviceOrientationListener deviceOrientationListener) {
        return doUnregisterEventListener(ListenerHolders.c(deviceOrientationListener, DeviceOrientationListener.class.getSimpleName()), 2440).continueWith(zzcg.zza, zzbo.zza);
    }

    public final Task<Void> removeLocationUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzx(pendingIntent, (TaskCompletionSource) obj2, null);
            }
        }).e(2418).a());
    }

    public final Task<Void> requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, DeviceOrientationListener deviceOrientationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.n(looper, "invalid null looper");
        }
        return zzc(deviceOrientationRequest, ListenerHolders.a(deviceOrientationListener, looper, DeviceOrientationListener.class.getSimpleName()));
    }

    public final Task<Void> requestLocationUpdates(final LocationRequest locationRequest, final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbs
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzu(pendingIntent, locationRequest, (TaskCompletionSource) obj2);
            }
        }).e(2417).a());
    }

    public final Task<Void> setMockLocation(final Location location) {
        Preconditions.a(location != null);
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzA(location, (TaskCompletionSource) obj2);
            }
        }).e(2421).a());
    }

    public final Task<Void> setMockMode(boolean z2) {
        synchronized (zzc) {
            try {
                if (!z2) {
                    Object obj = zzd;
                    if (obj != null) {
                        zzd = null;
                        return doUnregisterEventListener(ListenerHolders.c(obj, Object.class.getSimpleName()), 2420).continueWith(zzcf.zza, zzbk.zza);
                    }
                } else if (zzd == null) {
                    Object obj2 = new Object();
                    zzd = obj2;
                    return doRegisterEventListener(RegistrationMethods.a().b(zzcb.zza).d(zzcc.zza).e(ListenerHolders.a(obj2, Looper.getMainLooper(), Object.class.getSimpleName())).c(2420).a());
                }
                return Tasks.forResult(null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzbi(Context context) {
        super(context, zzb, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    public final Task<Location> getLastLocation(final LastLocationRequest lastLocationRequest) {
        return doRead(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzbj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzbi.zzb;
                ((zzdz) obj).zzq(lastLocationRequest, (TaskCompletionSource) obj2);
            }
        }).e(2414).d(com.google.android.gms.location.zzo.f73028f).a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        return doUnregisterEventListener(ListenerHolders.c(locationCallback, LocationCallback.class.getSimpleName()), 2418).continueWith(zzce.zza, zzbw.zza);
    }

    public final Task<Void> requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, Executor executor, DeviceOrientationListener deviceOrientationListener) {
        return zzc(deviceOrientationRequest, ListenerHolders.b(deviceOrientationListener, executor, DeviceOrientationListener.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.n(looper, "invalid null looper");
        }
        return zzb(locationRequest, ListenerHolders.a(locationCallback, looper, LocationCallback.class.getSimpleName()));
    }

    public final Task<Void> removeLocationUpdates(LocationListener locationListener) {
        return doUnregisterEventListener(ListenerHolders.c(locationListener, LocationListener.class.getSimpleName()), 2418).continueWith(zzch.zza, zzbv.zza);
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.n(looper, "invalid null looper");
        }
        return zza(locationRequest, ListenerHolders.a(locationListener, looper, LocationListener.class.getSimpleName()));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final Task<Location> getCurrentLocation(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken) {
        if (cancellationToken != null) {
            Preconditions.b(!cancellationToken.isCancellationRequested(), "cancellationToken may not be already canceled");
        }
        Task<Location> taskDoRead = doRead(TaskApiCall.a().b(new zzbp(currentLocationRequest, cancellationToken)).e(2415).a());
        if (cancellationToken == null) {
            return taskDoRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        taskDoRead.continueWith(new zzbq(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, Executor executor, LocationCallback locationCallback) {
        return zzb(locationRequest, ListenerHolders.b(locationCallback, executor, LocationCallback.class.getSimpleName()));
    }

    public final Task<Void> requestLocationUpdates(LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
        return zza(locationRequest, ListenerHolders.b(locationListener, executor, LocationListener.class.getSimpleName()));
    }
}
