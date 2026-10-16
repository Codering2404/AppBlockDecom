package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zze implements RemoteCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fido2ApiClient f72670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicKeyCredentialRequestOptions f72671b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((com.google.android.gms.internal.fido.zzs) ((com.google.android.gms.internal.fido.zzp) obj).getService()).zzd(new zzi(this.f72670a, (TaskCompletionSource) obj2), this.f72671b);
    }
}
