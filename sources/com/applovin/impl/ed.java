package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ed implements af.b {
    public static final Parcelable.Creator<ed> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f59460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f59461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f59462d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ed[] newArray(int i3) {
            return new ed[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ed createFromParcel(Parcel parcel) {
            return new ed(parcel, null);
        }
    }

    private ed(Parcel parcel) {
        this.f59459a = (String) xp.a((Object) parcel.readString());
        this.f59460b = (byte[]) xp.a((Object) parcel.createByteArray());
        this.f59461c = parcel.readInt();
        this.f59462d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ed.class == obj.getClass()) {
            ed edVar = (ed) obj;
            if (this.f59459a.equals(edVar.f59459a) && Arrays.equals(this.f59460b, edVar.f59460b) && this.f59461c == edVar.f59461c && this.f59462d == edVar.f59462d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f59459a.hashCode() + 527) * 31) + Arrays.hashCode(this.f59460b)) * 31) + this.f59461c) * 31) + this.f59462d;
    }

    public String toString() {
        return "mdta: key=" + this.f59459a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f59459a);
        parcel.writeByteArray(this.f59460b);
        parcel.writeInt(this.f59461c);
        parcel.writeInt(this.f59462d);
    }

    /* synthetic */ ed(Parcel parcel, a aVar) {
        this(parcel);
    }

    public ed(String str, byte[] bArr, int i3, int i4) {
        this.f59459a = str;
        this.f59460b = bArr;
        this.f59461c = i3;
        this.f59462d = i4;
    }
}
