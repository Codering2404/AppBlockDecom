package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.ud;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class af implements Parcelable {
    public static final Parcelable.Creator<af> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f58385a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public af[] newArray(int i3) {
            return new af[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public af createFromParcel(Parcel parcel) {
            return new af(parcel);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b extends Parcelable {
        default void a(ud.b bVar) {
        }

        default e9 b() {
            return null;
        }

        default byte[] a() {
            return null;
        }
    }

    af(Parcel parcel) {
        this.f58385a = new b[parcel.readInt()];
        int i3 = 0;
        while (true) {
            b[] bVarArr = this.f58385a;
            if (i3 >= bVarArr.length) {
                return;
            }
            bVarArr[i3] = (b) parcel.readParcelable(b.class.getClassLoader());
            i3++;
        }
    }

    public af a(b... bVarArr) {
        return bVarArr.length == 0 ? this : new af((b[]) xp.a((Object[]) this.f58385a, (Object[]) bVarArr));
    }

    public int c() {
        return this.f58385a.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || af.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f58385a, ((af) obj).f58385a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f58385a);
    }

    public String toString() {
        return "entries=" + Arrays.toString(this.f58385a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f58385a.length);
        for (b bVar : this.f58385a) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public af a(af afVar) {
        return afVar == null ? this : a(afVar.f58385a);
    }

    public b a(int i3) {
        return this.f58385a[i3];
    }

    public af(List list) {
        this.f58385a = (b[]) list.toArray(new b[0]);
    }

    public af(b... bVarArr) {
        this.f58385a = bVarArr;
    }
}
