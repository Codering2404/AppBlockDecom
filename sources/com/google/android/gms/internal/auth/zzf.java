package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzf extends IInterface {
    Bundle zzd(String str, Bundle bundle) throws RemoteException;

    @Nullable
    Bundle zze(Account account, String str, Bundle bundle) throws RemoteException;

    @Nullable
    Bundle zzf(Account account) throws RemoteException;

    Bundle zzg(String str) throws RemoteException;

    AccountChangeEventsResponse zzh(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException;
}
