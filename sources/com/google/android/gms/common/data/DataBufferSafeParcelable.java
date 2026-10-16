package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f71896c = {"data"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Parcelable.Creator f71897b;

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SafeParcelable get(int i3) {
        DataHolder dataHolder = (DataHolder) Preconditions.m(this.f71884a);
        byte[] bArrM = dataHolder.M("data", i3, dataHolder.j0(i3));
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrM, 0, bArrM.length);
        parcelObtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.f71897b.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return safeParcelable;
    }
}
