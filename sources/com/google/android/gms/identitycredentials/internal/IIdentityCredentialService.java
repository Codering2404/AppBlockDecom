package com.google.android.gms.identitycredentials.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identitycredentials.ClearRegistryRequest;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import com.google.android.gms.identitycredentials.RegistrationRequest;
import com.google.android.gms.internal.identity_credentials.zza;
import com.google.android.gms.internal.identity_credentials.zzb;
import com.google.android.gms.internal.identity_credentials.zzc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IIdentityCredentialService extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends zzb implements IIdentityCredentialService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Proxy extends zza implements IIdentityCredentialService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.identitycredentials.internal.IIdentityCredentialService");
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void K0(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegistrationRequest registrationRequest) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, registrationRequest);
                transactAndReadExceptionReturnVoid(2, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void M0(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, GetCredentialRequest getCredentialRequest) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, getCredentialRequest);
                transactAndReadExceptionReturnVoid(1, parcelObtainAndWriteInterfaceToken);
            }

            @Override // com.google.android.gms.identitycredentials.internal.IIdentityCredentialService
            public void w4(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearRegistryRequest clearRegistryRequest) throws RemoteException {
                Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zzc(parcelObtainAndWriteInterfaceToken, iIdentityCredentialCallbacks);
                zzc.zzb(parcelObtainAndWriteInterfaceToken, clearRegistryRequest);
                transactAndReadExceptionReturnVoid(3, parcelObtainAndWriteInterfaceToken);
            }
        }

        public static IIdentityCredentialService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identitycredentials.internal.IIdentityCredentialService");
            return iInterfaceQueryLocalInterface instanceof IIdentityCredentialService ? (IIdentityCredentialService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }
    }

    void K0(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, RegistrationRequest registrationRequest);

    void M0(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, GetCredentialRequest getCredentialRequest);

    void w4(IIdentityCredentialCallbacks iIdentityCredentialCallbacks, ClearRegistryRequest clearRegistryRequest);
}
