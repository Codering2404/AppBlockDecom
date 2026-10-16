package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbb implements FusedLocationProviderApi {
    static /* synthetic */ TaskCompletionSource zza(final BaseImplementation.ResultHolder resultHolder) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzbd
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

    public final PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.h(new zzaq(this, googleApiClient));
    }

    public final Location getLastLocation(GoogleApiClient googleApiClient) {
        Preconditions.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzdz zzdzVar = (zzdz) googleApiClient.j(zzbi.zza);
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            zzdzVar.zzq(new LastLocationRequest.Builder().a(), taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzbe
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final /* synthetic */ void onComplete(Task task) {
                    if (task.isSuccessful()) {
                        atomicReference.set((Location) task.getResult());
                    }
                    countDownLatch.countDown();
                }
            });
            if (zzfd.zza(countDownLatch, 30L, TimeUnit.SECONDS)) {
                return (Location) atomicReference.get();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        Preconditions.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzdz zzdzVar = (zzdz) googleApiClient.j(zzbi.zza);
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            zzdzVar.zzp(com.google.android.gms.location.zzac.a(), taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzbc
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final /* synthetic */ void onComplete(Task task) {
                    if (task.isSuccessful()) {
                        atomicReference.set((LocationAvailability) task.getResult());
                    }
                    countDownLatch.countDown();
                }
            });
            if (zzfd.zza(countDownLatch, 30L, TimeUnit.SECONDS)) {
                return (LocationAvailability) atomicReference.get();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.h(new zzav(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.h(new zzat(this, googleApiClient, pendingIntent, locationRequest));
    }

    public final PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.h(new zzay(this, googleApiClient, location));
    }

    public final PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z2) {
        return googleApiClient.h(new zzax(this, googleApiClient, z2));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.h(new zzaw(this, googleApiClient, locationCallback));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.n(looper, "invalid null looper");
        }
        return googleApiClient.h(new zzas(this, googleApiClient, ListenerHolders.a(locationCallback, looper, LocationCallback.class.getSimpleName()), locationRequest));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.h(new zzau(this, googleApiClient, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        Looper looperMyLooper = Looper.myLooper();
        Preconditions.n(looperMyLooper, "invalid null looper");
        return googleApiClient.h(new zzar(this, googleApiClient, ListenerHolders.a(locationListener, looperMyLooper, LocationListener.class.getSimpleName()), locationRequest));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.n(looper, "invalid null looper");
        }
        return googleApiClient.h(new zzar(this, googleApiClient, ListenerHolders.a(locationListener, looper, LocationListener.class.getSimpleName()), locationRequest));
    }
}
