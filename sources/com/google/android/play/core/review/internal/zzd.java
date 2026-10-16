package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzd extends zza implements zzf {
    zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.review.internal.zzf
    public final void g5(String str, Bundle bundle, zzh zzhVar) {
        Parcel parcelX3 = x3();
        parcelX3.writeString(str);
        int i3 = zzc.f83109a;
        parcelX3.writeInt(1);
        bundle.writeToParcel(parcelX3, 0);
        parcelX3.writeStrongBinder(zzhVar);
        h5(2, parcelX3);
    }
}
