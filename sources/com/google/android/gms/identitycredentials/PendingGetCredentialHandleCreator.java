package com.google.android.gms.identitycredentials;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PendingGetCredentialHandleCreator implements Parcelable.Creator<PendingGetCredentialHandle> {
    static void c(PendingGetCredentialHandle pendingGetCredentialHandle, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, pendingGetCredentialHandle.M(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PendingGetCredentialHandle createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            if (SafeParcelReader.w(iE) != 1) {
                SafeParcelReader.N(parcel, iE);
            } else {
                pendingIntent = (PendingIntent) SafeParcelReader.p(parcel, iE, PendingIntent.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PendingGetCredentialHandle(pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PendingGetCredentialHandle[] newArray(int i3) {
        return new PendingGetCredentialHandle[i3];
    }
}
