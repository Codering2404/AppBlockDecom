package com.facebook.ads.redexgen.core;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ia, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0778Ia {
    public final int A00;
    public final long A01;

    public C0778Ia(int i3, long j3) {
        this.A00 = i3;
        this.A01 = j3;
    }

    public /* synthetic */ C0778Ia(int i3, long j3, IZ iz) {
        this(i3, j3);
    }

    public static C0778Ia A00(Parcel parcel) {
        return new C0778Ia(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
