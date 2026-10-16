package com.google.android.gms.internal.p001authapiphone;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.phone.SmsCodeBrowserClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzv extends GoogleApi implements SmsCodeBrowserClient {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzt zztVar = new zzt();
        zzb = zztVar;
        zzc = new Api("SmsCodeBrowser.API", zztVar, clientKey);
    }

    public zzv(Activity activity) {
        super(activity, zzc, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(TaskApiCall.a().d(zzac.zzb).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api-phone.zzs
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzh) ((zzw) obj).getService()).zzf(new zzu(this.zza, (TaskCompletionSource) obj2));
            }
        }).e(1566).a());
    }

    public zzv(Context context) {
        super(context, zzc, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }
}
