package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SmsRetrieverClient extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsRetrieverApi {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zza zzaVar = new zza();
        zzb = zzaVar;
        zzc = new Api("SmsRetriever.API", zzaVar, clientKey);
    }

    public SmsRetrieverClient(Activity activity) {
        super(activity, zzc, (Api.ApiOptions) Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }

    public abstract Task startSmsRetriever();

    public SmsRetrieverClient(Context context) {
        super(context, zzc, Api.ApiOptions.s8, GoogleApi.Settings.f71506c);
    }
}
