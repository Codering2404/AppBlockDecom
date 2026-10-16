package com.google.android.gms.auth.blockstore.restorecredential;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ClearRestoreCredentialRequestCreator implements Parcelable.Creator<ClearRestoreCredentialRequest> {
    static void c(ClearRestoreCredentialRequest clearRestoreCredentialRequest, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 1, clearRestoreCredentialRequest.M(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClearRestoreCredentialRequest createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            if (SafeParcelReader.w(iE) != 1) {
                SafeParcelReader.N(parcel, iE);
            } else {
                bundleF = SafeParcelReader.f(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ClearRestoreCredentialRequest(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ClearRestoreCredentialRequest[] newArray(int i3) {
        return new ClearRestoreCredentialRequest[i3];
    }
}
