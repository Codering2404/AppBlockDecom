package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzab extends GoogleApi implements zzg {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;
    private static final Logger zzd;
    private final Context zze;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzv zzvVar = new zzv();
        zzb = zzvVar;
        zzc = new Api("GoogleAuthService.API", zzvVar, clientKey);
        zzd = com.google.android.gms.auth.zzd.a("GoogleAuthServiceClient");
    }

    zzab(Context context) {
        super(context, zzc, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
        this.zze = context;
    }

    static /* bridge */ /* synthetic */ void zzf(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (TaskUtil.c(status, obj, taskCompletionSource)) {
            return;
        }
        zzd.h("The task is already complete.", new Object[0]);
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zza(final zzbw zzbwVar) {
        return doWrite(TaskApiCall.a().d(com.google.android.gms.auth.zze.f71324l).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzt
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzd(new zzx(zzabVar, (TaskCompletionSource) obj2), zzbwVar);
            }
        }).e(1513).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzb(final AccountChangeEventsRequest accountChangeEventsRequest) {
        Preconditions.n(accountChangeEventsRequest, "request cannot be null.");
        return doWrite(TaskApiCall.a().d(com.google.android.gms.auth.zze.f71323k).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzu
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzab zzabVar = this.zza;
                AccountChangeEventsRequest accountChangeEventsRequest2 = accountChangeEventsRequest;
                ((zzp) ((zzi) obj).getService()).zze(new zzz(zzabVar, (TaskCompletionSource) obj2), accountChangeEventsRequest2);
            }
        }).e(1515).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzc(final Account account, final String str, final Bundle bundle) {
        Preconditions.n(account, "Account name cannot be null!");
        Preconditions.h(str, "Scope cannot be null!");
        return doWrite(TaskApiCall.a().d(com.google.android.gms.auth.zze.f71324l).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzs
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzf(new zzw(zzabVar, (TaskCompletionSource) obj2), account, str, bundle);
            }
        }).e(1512).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zze(final String str) {
        Preconditions.n(str, "Client package name cannot be null!");
        return doWrite(TaskApiCall.a().d(com.google.android.gms.auth.zze.f71323k).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzq
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzh(new zzy(zzabVar, (TaskCompletionSource) obj2), str);
            }
        }).e(1514).a());
    }

    @Override // com.google.android.gms.internal.auth.zzg
    public final Task zzd(final Account account) {
        Preconditions.n(account, KqqtdetwHMIO.DEwkiqn);
        return doWrite(TaskApiCall.a().d(com.google.android.gms.auth.zze.f71323k).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzr
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzab zzabVar = this.zza;
                ((zzp) ((zzi) obj).getService()).zzg(new zzaa(zzabVar, (TaskCompletionSource) obj2), account);
            }
        }).e(1517).a());
    }
}
