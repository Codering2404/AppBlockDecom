package com.google.android.gms.internal.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaj extends GoogleApi implements ActivityRecognitionClient {
    static final Api.ClientKey zza;
    public static final Api zzb;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzb = new Api("ActivityRecognition.API", new zzag(), clientKey);
    }

    public zzaj(Activity activity) {
        super(activity, zzb, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    public final Task<Void> removeActivityTransitionUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzam
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzaj.zzb;
                zzai zzaiVar = new zzai((TaskCompletionSource) obj2);
                Preconditions.n(zzaiVar, "ResultHolder not provided.");
                ((zzv) ((zzg) obj).getService()).zzk(pendingIntent, new StatusCallback(zzaiVar));
            }
        }).e(2406).a());
    }

    public final Task<Void> removeActivityUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzak
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzaj.zzb;
                ((zzg) obj).zzp(pendingIntent);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).e(2402).a());
    }

    public final Task<Void> removeSleepSegmentUpdates(final PendingIntent pendingIntent) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzan
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzaj.zzb;
                zzai zzaiVar = new zzai((TaskCompletionSource) obj2);
                PendingIntent pendingIntent2 = pendingIntent;
                Preconditions.n(pendingIntent2, "PendingIntent must be specified.");
                Preconditions.n(zzaiVar, "ResultHolder not provided.");
                ((zzv) ((zzg) obj).getService()).zzn(pendingIntent2, new StatusCallback(zzaiVar));
            }
        }).e(2411).a());
    }

    public final Task<Void> requestActivityTransitionUpdates(final ActivityTransitionRequest activityTransitionRequest, final PendingIntent pendingIntent) {
        activityTransitionRequest.M(getContextAttributionTag());
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzal
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzaj.zzb;
                zzai zzaiVar = new zzai((TaskCompletionSource) obj2);
                ActivityTransitionRequest activityTransitionRequest2 = activityTransitionRequest;
                Preconditions.n(activityTransitionRequest2, "activityTransitionRequest must be specified.");
                PendingIntent pendingIntent2 = pendingIntent;
                Preconditions.n(pendingIntent2, "PendingIntent must be specified.");
                Preconditions.n(zzaiVar, "ResultHolder not provided.");
                ((zzv) ((zzg) obj).getService()).zzj(activityTransitionRequest2, pendingIntent2, new StatusCallback(zzaiVar));
            }
        }).e(2405).a());
    }

    public final Task<Void> requestActivityUpdates(long j3, final PendingIntent pendingIntent) {
        com.google.android.gms.location.zza zzaVar = new com.google.android.gms.location.zza();
        zzaVar.a(j3);
        final com.google.android.gms.location.zzb zzbVarB = zzaVar.b();
        zzbVarB.M(getContextAttributionTag());
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzap
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                Api api = zzaj.zzb;
                zzai zzaiVar = new zzai((TaskCompletionSource) obj2);
                com.google.android.gms.location.zzb zzbVar = zzbVarB;
                Preconditions.n(zzbVar, "ActivityRecognitionRequest can't be null.");
                PendingIntent pendingIntent2 = pendingIntent;
                Preconditions.n(pendingIntent2, "PendingIntent must be specified.");
                Preconditions.n(zzaiVar, "ResultHolder not provided.");
                ((zzv) ((zzg) obj).getService()).zzi(zzbVar, pendingIntent2, new StatusCallback(zzaiVar));
            }
        }).e(2401).a());
    }

    public final Task<Void> requestSleepSegmentUpdates(final PendingIntent pendingIntent, final SleepSegmentRequest sleepSegmentRequest) {
        Preconditions.n(pendingIntent, "PendingIntent must be specified.");
        return doRead(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzao
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
                ((zzv) ((zzg) obj).getService()).zzm(pendingIntent, sleepSegmentRequest, new zzah(this.zza, (TaskCompletionSource) obj2));
            }
        }).d(com.google.android.gms.location.zzo.f73024b).e(2410).a());
    }

    public zzaj(Context context) {
        super(context, zzb, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }
}
