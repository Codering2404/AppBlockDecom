package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class x6 implements Comparator, Parcelable {
    public static final Parcelable.Creator<x6> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f64858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f64859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64861d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x6[] newArray(int i3) {
            return new x6[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x6 createFromParcel(Parcel parcel) {
            return new x6(parcel);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f64862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f64863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f64864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f64865d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final byte[] f64866f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }
        }

        b(Parcel parcel) {
            this.f64863b = new UUID(parcel.readLong(), parcel.readLong());
            this.f64864c = parcel.readString();
            this.f64865d = (String) xp.a((Object) parcel.readString());
            this.f64866f = parcel.createByteArray();
        }

        public boolean a(UUID uuid) {
            return t2.f63860a.equals(this.f64863b) || uuid.equals(this.f64863b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return xp.a((Object) this.f64864c, (Object) bVar.f64864c) && xp.a((Object) this.f64865d, (Object) bVar.f64865d) && xp.a(this.f64863b, bVar.f64863b) && Arrays.equals(this.f64866f, bVar.f64866f);
        }

        public int hashCode() {
            if (this.f64862a == 0) {
                int iHashCode = this.f64863b.hashCode() * 31;
                String str = this.f64864c;
                this.f64862a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f64865d.hashCode()) * 31) + Arrays.hashCode(this.f64866f);
            }
            return this.f64862a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f64863b.getMostSignificantBits());
            parcel.writeLong(this.f64863b.getLeastSignificantBits());
            parcel.writeString(this.f64864c);
            parcel.writeString(this.f64865d);
            parcel.writeByteArray(this.f64866f);
        }

        public b a(byte[] bArr) {
            return new b(this.f64863b, this.f64864c, this.f64865d, bArr);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.f64863b = (UUID) b1.a(uuid);
            this.f64864c = str;
            this.f64865d = (String) b1.a((Object) str2);
            this.f64866f = bArr;
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }
    }

    x6(Parcel parcel) {
        this.f64860c = parcel.readString();
        b[] bVarArr = (b[]) xp.a(parcel.createTypedArray(b.CREATOR));
        this.f64858a = bVarArr;
        this.f64861d = bVarArr.length;
    }

    public x6 a(String str) {
        return xp.a((Object) this.f64860c, (Object) str) ? this : new x6(str, false, this.f64858a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && x6.class == obj.getClass()) {
            x6 x6Var = (x6) obj;
            if (xp.a((Object) this.f64860c, (Object) x6Var.f64860c) && Arrays.equals(this.f64858a, x6Var.f64858a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f64859b == 0) {
            String str = this.f64860c;
            this.f64859b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f64858a);
        }
        return this.f64859b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64860c);
        parcel.writeTypedArray(this.f64858a, 0);
    }

    public b a(int i3) {
        return this.f64858a[i3];
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = t2.f63860a;
        if (uuid.equals(bVar.f64863b)) {
            return uuid.equals(bVar2.f64863b) ? 0 : 1;
        }
        return bVar.f64863b.compareTo(bVar2.f64863b);
    }

    private x6(String str, boolean z2, b... bVarArr) {
        this.f64860c = str;
        bVarArr = z2 ? (b[]) bVarArr.clone() : bVarArr;
        this.f64858a = bVarArr;
        this.f64861d = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public x6(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public x6(List list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    public x6(b... bVarArr) {
        this(null, bVarArr);
    }
}
