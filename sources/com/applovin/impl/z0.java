package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class z0 implements af.b {
    public static final Parcelable.Creator<z0> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f65279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65280b;

    public z0(int i3, String str) {
        this.f65279a = i3;
        this.f65280b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Ait(controlCode=" + this.f65279a + ",url=" + this.f65280b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f65280b);
        parcel.writeInt(this.f65279a);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z0 createFromParcel(Parcel parcel) {
            return new z0(parcel.readInt(), (String) b1.a((Object) parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z0[] newArray(int i3) {
            return new z0[i3];
        }
    }
}
