package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza implements Parcelable.Creator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zza f71881b = new zza(new zzb());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable.Creator f71882a;

    private zza(Parcelable.Creator creator) {
        this.f71882a = creator;
    }

    public static zza a() {
        return f71881b;
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iDataPosition = parcel.dataPosition();
        if (parcel.readInt() == -204102970) {
            return zzb.a(parcel);
        }
        parcel.setDataPosition(iDataPosition - 4);
        return ApiMetadata.M();
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i3) {
        return new ApiMetadata[i3];
    }
}
