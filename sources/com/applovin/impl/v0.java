package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.ud;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class v0 extends xa {
    public static final Parcelable.Creator<v0> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64364d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f64365f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v0[] newArray(int i3) {
            return new v0[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v0 createFromParcel(Parcel parcel) {
            return new v0(parcel);
        }
    }

    v0(Parcel parcel) {
        super("APIC");
        this.f64362b = (String) xp.a((Object) parcel.readString());
        this.f64363c = parcel.readString();
        this.f64364d = parcel.readInt();
        this.f64365f = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    @Override // com.applovin.impl.af.b
    public void a(ud.b bVar) {
        bVar.a(this.f64365f, this.f64364d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v0.class == obj.getClass()) {
            v0 v0Var = (v0) obj;
            if (this.f64364d == v0Var.f64364d && xp.a((Object) this.f64362b, (Object) v0Var.f64362b) && xp.a((Object) this.f64363c, (Object) v0Var.f64363c) && Arrays.equals(this.f64365f, v0Var.f64365f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (this.f64364d + 527) * 31;
        String str = this.f64362b;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f64363c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f64365f);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": mimeType=" + this.f64362b + ", description=" + this.f64363c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64362b);
        parcel.writeString(this.f64363c);
        parcel.writeInt(this.f64364d);
        parcel.writeByteArray(this.f64365f);
    }

    public v0(String str, String str2, int i3, byte[] bArr) {
        super("APIC");
        this.f64362b = str;
        this.f64363c = str2;
        this.f64364d = i3;
        this.f64365f = bArr;
    }
}
