package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.af;
import com.applovin.impl.jk;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class jk implements af.b {
    public static final Parcelable.Creator<jk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f60768a;

    public jk(List list) {
        this.f60768a = list;
        b1.a(!a(list));
    }

    private static boolean a(List list) {
        if (list.isEmpty()) {
            return false;
        }
        long j3 = ((b) list.get(0)).f60771b;
        for (int i3 = 1; i3 < list.size(); i3++) {
            if (((b) list.get(i3)).f60770a < j3) {
                return true;
            }
            j3 = ((b) list.get(i3)).f60771b;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jk.class != obj.getClass()) {
            return false;
        }
        return this.f60768a.equals(((jk) obj).f60768a);
    }

    public int hashCode() {
        return this.f60768a.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f60768a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.f60768a);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jk createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, b.class.getClassLoader());
            return new jk(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public jk[] newArray(int i3) {
            return new jk[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f60770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f60771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f60772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Comparator f60769d = new Comparator() { // from class: com.applovin.impl.qy
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return jk.b.a((jk.b) obj, (jk.b) obj2);
            }
        };
        public static final Parcelable.Creator<b> CREATOR = new a();

        public b(long j3, long j4, int i3) {
            b1.a(j3 < j4);
            this.f60770a = j3;
            this.f60771b = j4;
            this.f60772c = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(b bVar, b bVar2) {
            return y3.e().a(bVar.f60770a, bVar2.f60770a).a(bVar.f60771b, bVar2.f60771b).a(bVar.f60772c, bVar2.f60772c).d();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.f60770a == bVar.f60770a && this.f60771b == bVar.f60771b && this.f60772c == bVar.f60772c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f60770a), Long.valueOf(this.f60771b), Integer.valueOf(this.f60772c));
        }

        public String toString() {
            return xp.a("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f60770a), Long.valueOf(this.f60771b), Integer.valueOf(this.f60772c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f60770a);
            parcel.writeLong(this.f60771b);
            parcel.writeInt(this.f60772c);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }
    }
}
