package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.blockstore.restorecredential.ClearRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialRequest;
import com.google.android.gms.internal.auth_blockstore.zza;
import com.google.android.gms.internal.auth_blockstore.zzb;
import com.google.android.gms.internal.auth_blockstore.zzc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IRestoreCredentialService extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends zzb implements IRestoreCredentialService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Proxy extends zza implements IRestoreCredentialService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService");
            }

            @Override // com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService
            public void S2(ClearRestoreCredentialRequest clearRestoreCredentialRequest, IClearRestoreCredentialCallback iClearRestoreCredentialCallback) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, clearRestoreCredentialRequest);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iClearRestoreCredentialCallback);
                transactAndReadExceptionReturnVoid(4, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService
            public void a0(GetRestoreCredentialRequest getRestoreCredentialRequest, IGetRestoreCredentialCallback iGetRestoreCredentialCallback) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, getRestoreCredentialRequest);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iGetRestoreCredentialCallback);
                transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService
            public void m2(CreateRestoreCredentialRequest createRestoreCredentialRequest, ICreateRestoreCredentialCallback iCreateRestoreCredentialCallback) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzb(parcelObtainAndWriteInterfaceToken, createRestoreCredentialRequest);
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iCreateRestoreCredentialCallback);
                transactAndReadExceptionReturnVoid(3, parcelObtainAndWriteInterfaceToken);
            }
        }

        public static IRestoreCredentialService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService");
            return iInterfaceQueryLocalInterface instanceof IRestoreCredentialService ? (IRestoreCredentialService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }
    }

    void S2(ClearRestoreCredentialRequest clearRestoreCredentialRequest, IClearRestoreCredentialCallback iClearRestoreCredentialCallback);

    void a0(GetRestoreCredentialRequest getRestoreCredentialRequest, IGetRestoreCredentialCallback iGetRestoreCredentialCallback);

    void m2(CreateRestoreCredentialRequest createRestoreCredentialRequest, ICreateRestoreCredentialCallback iCreateRestoreCredentialCallback);
}
