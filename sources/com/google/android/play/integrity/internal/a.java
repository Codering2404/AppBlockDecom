package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f83157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f83158b;

    protected a(IBinder iBinder, String str) {
        this.f83157a = iBinder;
        this.f83158b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f83157a;
    }

    protected final void h5(int i3, Parcel parcel) {
        try {
            this.f83157a.transact(i3, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    protected final Parcel x3() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f83158b);
        return parcelObtain;
    }
}
