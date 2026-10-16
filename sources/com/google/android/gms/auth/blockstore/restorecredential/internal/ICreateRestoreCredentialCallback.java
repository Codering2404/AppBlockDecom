package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth_blockstore.zzb;
import com.google.android.gms.internal.auth_blockstore.zzc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ICreateRestoreCredentialCallback extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends zzb implements ICreateRestoreCredentialCallback {
        public Stub() {
            super("com.google.android.gms.auth.blockstore.restorecredential.internal.ICreateRestoreCredentialCallback");
        }

        @Override // com.google.android.gms.internal.auth_blockstore.zzb
        protected boolean dispatchTransaction(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 != 1) {
                return false;
            }
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            CreateRestoreCredentialResponse createRestoreCredentialResponse = (CreateRestoreCredentialResponse) zzc.zza(parcel, CreateRestoreCredentialResponse.CREATOR);
            enforceNoDataAvail(parcel);
            u2(status, createRestoreCredentialResponse);
            return true;
        }
    }

    void u2(Status status, CreateRestoreCredentialResponse createRestoreCredentialResponse);
}
