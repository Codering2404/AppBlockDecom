package com.google.android.gms.fido.u2f;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import com.google.android.gms.internal.fido.zzw;
import com.google.android.gms.internal.fido.zzy;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zza implements RemoteCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ U2fApiClient f72775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RegisterRequestParams f72776b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zzw) ((zzy) obj).getService()).zzc(new zzc(this.f72775a, (TaskCompletionSource) obj2), this.f72776b);
    }
}
