package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcq implements Parcelable.Creator {
    zzcq() {
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzcr(parcel);
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzcr[i3];
    }
}
