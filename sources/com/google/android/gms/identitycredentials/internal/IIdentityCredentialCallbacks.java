package com.google.android.gms.identitycredentials.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.identitycredentials.ClearRegistryResponse;
import com.google.android.gms.identitycredentials.PendingGetCredentialHandle;
import com.google.android.gms.identitycredentials.PendingImportCredentialsHandle;
import com.google.android.gms.identitycredentials.RegisterExportResponse;
import com.google.android.gms.identitycredentials.RegistrationResponse;
import com.google.android.gms.internal.identity_credentials.zzb;
import com.google.android.gms.internal.identity_credentials.zzc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IIdentityCredentialCallbacks extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends zzb implements IIdentityCredentialCallbacks {
        public Stub() {
            super("com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks");
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        protected boolean dispatchTransaction(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 == 1) {
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                PendingGetCredentialHandle pendingGetCredentialHandle = (PendingGetCredentialHandle) zzc.zza(parcel, PendingGetCredentialHandle.CREATOR);
                enforceNoDataAvail(parcel);
                l4(status, pendingGetCredentialHandle);
            } else if (i3 == 2) {
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                RegistrationResponse registrationResponse = (RegistrationResponse) zzc.zza(parcel, RegistrationResponse.CREATOR);
                enforceNoDataAvail(parcel);
                I4(status2, registrationResponse);
            } else if (i3 == 3) {
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                ClearRegistryResponse clearRegistryResponse = (ClearRegistryResponse) zzc.zza(parcel, ClearRegistryResponse.CREATOR);
                enforceNoDataAvail(parcel);
                q3(status3, clearRegistryResponse);
            } else if (i3 == 4) {
                Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
                PendingImportCredentialsHandle pendingImportCredentialsHandle = (PendingImportCredentialsHandle) zzc.zza(parcel, PendingImportCredentialsHandle.CREATOR);
                enforceNoDataAvail(parcel);
                j0(status4, pendingImportCredentialsHandle);
            } else {
                if (i3 != 5) {
                    return false;
                }
                Status status5 = (Status) zzc.zza(parcel, Status.CREATOR);
                RegisterExportResponse registerExportResponse = (RegisterExportResponse) zzc.zza(parcel, RegisterExportResponse.CREATOR);
                enforceNoDataAvail(parcel);
                V4(status5, registerExportResponse);
            }
            return true;
        }
    }

    void I4(Status status, RegistrationResponse registrationResponse);

    void V4(Status status, RegisterExportResponse registerExportResponse);

    void j0(Status status, PendingImportCredentialsHandle pendingImportCredentialsHandle);

    void l4(Status status, PendingGetCredentialHandle pendingGetCredentialHandle);

    void q3(Status status, ClearRegistryResponse clearRegistryResponse);
}
