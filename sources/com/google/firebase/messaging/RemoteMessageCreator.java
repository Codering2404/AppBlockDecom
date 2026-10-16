package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {
    static void c(RemoteMessage remoteMessage, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 2, remoteMessage.f89420a, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RemoteMessage createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            if (SafeParcelReader.w(iE) != 2) {
                SafeParcelReader.N(parcel, iE);
            } else {
                bundleF = SafeParcelReader.f(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new RemoteMessage(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteMessage[] newArray(int i3) {
        return new RemoteMessage[i3];
    }
}
