package com.google.android.gms.internal.auth_blockstore;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.blockstore.BlockstoreClient;
import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.auth.blockstore.StoreBytesData;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaa extends GoogleApi implements BlockstoreClient {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzc = new Api("Blockstore.API", zzuVar, clientKey);
    }

    public zzaa(Context context) {
        super(context, zzc, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    @Override // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task<Boolean> deleteBytes(final DeleteBytesRequest deleteBytesRequest) {
        Preconditions.n(deleteBytesRequest, "DeleteBytesRequest cannot be null");
        return doWrite(TaskApiCall.a().d(zzab.zzg).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzp
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzg) ((zzf) obj).getService()).zza(new zzy(this.zza, (TaskCompletionSource) obj2), deleteBytesRequest);
            }
        }).c(false).e(1669).a());
    }

    public final Task<Boolean> isEndToEndEncryptionAvailable() {
        return doRead(TaskApiCall.a().d(zzab.zze).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzr
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzg) ((zzf) obj).getService()).zzb(new zzz(this.zza, (TaskCompletionSource) obj2));
            }
        }).c(false).e(1651).a());
    }

    public final Task<byte[]> retrieveBytes() {
        return doRead(TaskApiCall.a().d(zzab.zza).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzt
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzg) ((zzf) obj).getService()).zzc(new zzx(this.zza, (TaskCompletionSource) obj2));
            }
        }).c(false).e(1570).a());
    }

    @Override // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task<Integer> storeBytes(final StoreBytesData storeBytesData) {
        return doWrite(TaskApiCall.a().d(zzab.zzd, zzab.zzf).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzq
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzg) ((zzf) obj).getService()).zze(new zzv(this.zza, (TaskCompletionSource) obj2), storeBytesData);
            }
        }).e(1645).c(false).a());
    }

    @Override // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task<RetrieveBytesResponse> retrieveBytes(final RetrieveBytesRequest retrieveBytesRequest) {
        Preconditions.n(retrieveBytesRequest, "RetrieveBytesRequest cannot be null");
        return doRead(TaskApiCall.a().d(zzab.zzh).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzs
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzg) ((zzf) obj).getService()).zzd(new zzw(this.zza, (TaskCompletionSource) obj2), retrieveBytesRequest);
            }
        }).c(false).e(1668).a());
    }
}
