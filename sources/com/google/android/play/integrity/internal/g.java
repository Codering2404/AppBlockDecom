package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends a implements i {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.i
    public final void G3(Bundle bundle, k kVar) {
        Parcel parcelX3 = x3();
        c.c(parcelX3, bundle);
        parcelX3.writeStrongBinder(kVar);
        h5(2, parcelX3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.i
    public final void j4(Bundle bundle, k kVar) {
        Parcel parcelX3 = x3();
        c.c(parcelX3, bundle);
        parcelX3.writeStrongBinder(kVar);
        h5(3, parcelX3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.integrity.internal.i
    public final void k(Bundle bundle, r rVar) {
        Parcel parcelX3 = x3();
        c.c(parcelX3, bundle);
        parcelX3.writeStrongBinder(rVar);
        h5(6, parcelX3);
    }
}
