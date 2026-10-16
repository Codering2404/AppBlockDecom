package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class uk extends sk {
    public static final Parcelable.Creator<uk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f64253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f64254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f64255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f64256d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f64257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f64258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f64259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f64260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f64261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f64262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f64263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f64264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f64265n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public uk[] newArray(int i3) {
            return new uk[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public uk createFromParcel(Parcel parcel) {
            return new uk(parcel, null);
        }
    }

    private uk(long j3, boolean z2, boolean z3, boolean z4, boolean z5, long j4, long j5, List list, boolean z6, long j6, int i3, int i4, int i5) {
        this.f64253a = j3;
        this.f64254b = z2;
        this.f64255c = z3;
        this.f64256d = z4;
        this.f64257f = z5;
        this.f64258g = j4;
        this.f64259h = j5;
        this.f64260i = Collections.unmodifiableList(list);
        this.f64261j = z6;
        this.f64262k = j6;
        this.f64263l = i3;
        this.f64264m = i4;
        this.f64265n = i5;
    }

    static uk a(ah ahVar, long j3, ho hoVar) {
        List list;
        long j4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        int iW;
        int iW2;
        boolean z6;
        int i4;
        long jA;
        long jY = ahVar.y();
        boolean z7 = (ahVar.w() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
        List list2 = Collections.EMPTY_LIST;
        long jY2 = -9223372036854775807L;
        if (z7) {
            list = list2;
            j4 = -9223372036854775807L;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i3 = 0;
            iW = 0;
            iW2 = 0;
        } else {
            int iW3 = ahVar.w();
            boolean z8 = (iW3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
            boolean z9 = (iW3 & 64) != 0;
            boolean z10 = (iW3 & 32) != 0;
            boolean z11 = (iW3 & 16) != 0;
            long jA2 = (!z9 || z11) ? -9223372036854775807L : Cdo.a(ahVar, j3);
            if (!z9) {
                int iW4 = ahVar.w();
                ArrayList arrayList = new ArrayList(iW4);
                int i5 = 0;
                while (i5 < iW4) {
                    int iW5 = ahVar.w();
                    if (z11) {
                        i4 = iW4;
                        jA = -9223372036854775807L;
                    } else {
                        i4 = iW4;
                        jA = Cdo.a(ahVar, j3);
                    }
                    arrayList.add(new b(iW5, jA, hoVar.b(jA), null));
                    i5++;
                    iW4 = i4;
                }
                list2 = arrayList;
            }
            if (z10) {
                long jW = ahVar.w();
                boolean z12 = (128 & jW) != 0;
                jY2 = ((((jW & 1) << 32) | ahVar.y()) * 1000) / 90;
                z6 = z12;
            } else {
                z6 = false;
            }
            int iC = ahVar.C();
            long j5 = jA2;
            j4 = jY2;
            jY2 = j5;
            iW = ahVar.w();
            iW2 = ahVar.w();
            i3 = iC;
            z5 = z6;
            z2 = z8;
            z3 = z9;
            list = list2;
            z4 = z11;
        }
        return new uk(jY, z7, z2, z3, z4, jY2, hoVar.b(jY2), list, z5, j4, i3, iW, iW2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f64253a);
        parcel.writeByte(this.f64254b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f64255c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f64256d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f64257f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f64258g);
        parcel.writeLong(this.f64259h);
        int size = this.f64260i.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            ((b) this.f64260i.get(i4)).b(parcel);
        }
        parcel.writeByte(this.f64261j ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f64262k);
        parcel.writeInt(this.f64263l);
        parcel.writeInt(this.f64264m);
        parcel.writeInt(this.f64265n);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f64267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f64268c;

        private b(int i3, long j3, long j4) {
            this.f64266a = i3;
            this.f64267b = j3;
            this.f64268c = j4;
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f64266a);
            parcel.writeLong(this.f64267b);
            parcel.writeLong(this.f64268c);
        }

        /* synthetic */ b(int i3, long j3, long j4, a aVar) {
            this(i3, j3, j4);
        }
    }

    private uk(Parcel parcel) {
        this.f64253a = parcel.readLong();
        this.f64254b = parcel.readByte() == 1;
        this.f64255c = parcel.readByte() == 1;
        this.f64256d = parcel.readByte() == 1;
        this.f64257f = parcel.readByte() == 1;
        this.f64258g = parcel.readLong();
        this.f64259h = parcel.readLong();
        int i3 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(b.a(parcel));
        }
        this.f64260i = Collections.unmodifiableList(arrayList);
        this.f64261j = parcel.readByte() == 1;
        this.f64262k = parcel.readLong();
        this.f64263l = parcel.readInt();
        this.f64264m = parcel.readInt();
        this.f64265n = parcel.readInt();
    }

    /* synthetic */ uk(Parcel parcel, a aVar) {
        this(parcel);
    }
}
