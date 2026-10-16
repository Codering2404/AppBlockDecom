package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class RegisterExportResponseCreator implements Parcelable.Creator<RegisterExportResponse> {
    static void c(RegisterExportResponse registerExportResponse, Parcel parcel, int i3) {
        SafeParcelWriter.b(parcel, SafeParcelWriter.a(parcel));
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RegisterExportResponse createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            SafeParcelReader.w(iE);
            SafeParcelReader.N(parcel, iE);
        }
        SafeParcelReader.v(parcel, iO);
        return new RegisterExportResponse();
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RegisterExportResponse[] newArray(int i3) {
        return new RegisterExportResponse[i3];
    }
}
