package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class h2 extends xa {
    public static final Parcelable.Creator<h2> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f60096b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h2[] newArray(int i3) {
            return new h2[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h2 createFromParcel(Parcel parcel) {
            return new h2(parcel);
        }
    }

    h2(Parcel parcel) {
        super((String) xp.a((Object) parcel.readString()));
        this.f60096b = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h2.class == obj.getClass()) {
            h2 h2Var = (h2) obj;
            if (this.f64884a.equals(h2Var.f64884a) && Arrays.equals(this.f60096b, h2Var.f60096b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f64884a.hashCode() + 527) * 31) + Arrays.hashCode(this.f60096b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64884a);
        parcel.writeByteArray(this.f60096b);
    }

    public h2(String str, byte[] bArr) {
        super(str);
        this.f60096b = bArr;
    }
}
