package com.google.android.gms.fido.fido2;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Fido2ApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f72433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api f72434b;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72433a = clientKey;
        f72434b = new Api("Fido.FIDO2_API", new com.google.android.gms.internal.fido.zzo(), clientKey);
    }

    public Fido2ApiClient(Activity activity) {
        super(activity, f72434b, Api.ApiOptions.s8, new ApiExceptionMapper());
    }

    public Task h(final PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions) {
        return doRead(TaskApiCall.a().b(new RemoteCall() { // from class: com.google.android.gms.fido.fido2.zza
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.fido.zzs) ((com.google.android.gms.internal.fido.zzp) obj).getService()).zzc(new zzf(this.f72663a, (TaskCompletionSource) obj2), publicKeyCredentialCreationOptions);
            }
        }).e(5407).a());
    }
}
