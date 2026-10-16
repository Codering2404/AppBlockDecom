package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class f3 extends xa {
    public static final Parcelable.Creator<f3> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f59622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f59623d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f59624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final xa[] f59625g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f3[] newArray(int i3) {
            return new f3[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f3 createFromParcel(Parcel parcel) {
            return new f3(parcel);
        }
    }

    f3(Parcel parcel) {
        super("CTOC");
        this.f59621b = (String) xp.a((Object) parcel.readString());
        this.f59622c = parcel.readByte() != 0;
        this.f59623d = parcel.readByte() != 0;
        this.f59624f = (String[]) xp.a((Object) parcel.createStringArray());
        int i3 = parcel.readInt();
        this.f59625g = new xa[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.f59625g[i4] = (xa) parcel.readParcelable(xa.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f3.class == obj.getClass()) {
            f3 f3Var = (f3) obj;
            if (this.f59622c == f3Var.f59622c && this.f59623d == f3Var.f59623d && xp.a((Object) this.f59621b, (Object) f3Var.f59621b) && Arrays.equals(this.f59624f, f3Var.f59624f) && Arrays.equals(this.f59625g, f3Var.f59625g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = ((((this.f59622c ? 1 : 0) + 527) * 31) + (this.f59623d ? 1 : 0)) * 31;
        String str = this.f59621b;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f59621b);
        parcel.writeByte(this.f59622c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f59623d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f59624f);
        parcel.writeInt(this.f59625g.length);
        for (xa xaVar : this.f59625g) {
            parcel.writeParcelable(xaVar, 0);
        }
    }

    public f3(String str, boolean z2, boolean z3, String[] strArr, xa[] xaVarArr) {
        super("CTOC");
        this.f59621b = str;
        this.f59622c = z2;
        this.f59623d = z3;
        this.f59624f = strArr;
        this.f59625g = xaVarArr;
    }
}
