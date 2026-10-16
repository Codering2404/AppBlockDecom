package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzal implements WorkAccountApi {
    private static final Status zza = new Status(13);

    public final PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.h(new zzae(this, WorkAccount.f70956a, googleApiClient, str));
    }

    public final PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, Account account) {
        return googleApiClient.h(new zzag(this, WorkAccount.f70956a, googleApiClient, account));
    }

    public final void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, boolean z2) {
        setWorkAuthenticatorEnabledWithResult(googleApiClient, z2);
    }

    public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient googleApiClient, boolean z2) {
        return googleApiClient.h(new zzac(this, WorkAccount.f70956a, googleApiClient, z2));
    }
}
