package com.google.android.gms.internal.auth;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.auth.api.proxy.ProxyClient;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbo extends GoogleApi implements ProxyClient {
    public zzbo(Activity activity, AuthProxyOptions authProxyOptions) {
        super(activity, AuthProxy.f70970a, (Api.ApiOptions) (authProxyOptions == null ? AuthProxyOptions.f70974b : authProxyOptions), GoogleApi.Settings.f71506c);
    }

    public final Task<String> getSpatulaHeader() {
        return doRead(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzbk
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1520).a());
    }

    public final Task<ProxyResponse> performProxyRequest(final ProxyRequest proxyRequest) {
        return doWrite(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzbl
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbo zzboVar = this.zza;
                ProxyRequest proxyRequest2 = proxyRequest;
                ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), proxyRequest2);
            }
        }).e(1518).a());
    }

    public zzbo(Context context, AuthProxyOptions authProxyOptions) {
        super(context, AuthProxy.f70970a, authProxyOptions == null ? AuthProxyOptions.f70974b : authProxyOptions, GoogleApi.Settings.f71506c);
    }
}
