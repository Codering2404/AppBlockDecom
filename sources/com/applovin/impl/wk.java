package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class wk extends sk {
    public static final Parcelable.Creator<wk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f64673a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wk[] newArray(int i3) {
            return new wk[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public wk createFromParcel(Parcel parcel) {
            return new wk(parcel, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f64675b;

        private b(int i3, long j3) {
            this.f64674a = i3;
            this.f64675b = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeInt(this.f64674a);
            parcel.writeLong(this.f64675b);
        }

        /* synthetic */ b(int i3, long j3, a aVar) {
            this(i3, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f64676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f64677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f64678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f64679d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f64680e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f64681f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f64682g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f64683h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f64684i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f64685j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f64686k;

        private c(long j3, boolean z2, boolean z3, boolean z4, List list, long j4, boolean z5, long j5, int i3, int i4, int i5) {
            this.f64676a = j3;
            this.f64677b = z2;
            this.f64678c = z3;
            this.f64679d = z4;
            this.f64681f = Collections.unmodifiableList(list);
            this.f64680e = j4;
            this.f64682g = z5;
            this.f64683h = j5;
            this.f64684i = i3;
            this.f64685j = i4;
            this.f64686k = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(ah ahVar) {
            boolean z2;
            ArrayList arrayList;
            boolean z3;
            boolean z4;
            long j3;
            boolean z5;
            long j4;
            int i3;
            int i4;
            int iW;
            boolean z6;
            long jY;
            long jY2 = ahVar.y();
            boolean z7 = true;
            if ((ahVar.w() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                z2 = true;
            } else {
                z2 = true;
                z7 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (z7) {
                arrayList = arrayList2;
                z3 = false;
                z4 = false;
                j3 = -9223372036854775807L;
                z5 = false;
                j4 = -9223372036854775807L;
                i3 = 0;
                i4 = 0;
                iW = 0;
            } else {
                int iW2 = ahVar.w();
                boolean z8 = (iW2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? z2 : false;
                boolean z9 = (iW2 & 64) != 0 ? z2 : false;
                boolean z10 = (iW2 & 32) != 0 ? z2 : false;
                long jY3 = z9 ? ahVar.y() : -9223372036854775807L;
                if (!z9) {
                    int iW3 = ahVar.w();
                    ArrayList arrayList3 = new ArrayList(iW3);
                    int i5 = 0;
                    while (i5 < iW3) {
                        arrayList3.add(new b(ahVar.w(), ahVar.y(), null));
                        i5++;
                        iW3 = iW3;
                    }
                    arrayList2 = arrayList3;
                }
                if (z10) {
                    long jW = ahVar.w();
                    boolean z11 = (128 & jW) != 0;
                    jY = ((((jW & 1) << 32) | ahVar.y()) * 1000) / 90;
                    z6 = z11;
                } else {
                    z6 = false;
                    jY = -9223372036854775807L;
                }
                int iC = ahVar.C();
                int iW4 = ahVar.w();
                boolean z12 = z8;
                z5 = z6;
                z3 = z12;
                iW = ahVar.w();
                long j5 = jY3;
                i3 = iC;
                i4 = iW4;
                long j6 = jY;
                arrayList = arrayList2;
                z4 = z9;
                j3 = j5;
                j4 = j6;
            }
            return new c(jY2, z7, z3, z4, arrayList, j3, z5, j4, i3, i4, iW);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Parcel parcel) {
            parcel.writeLong(this.f64676a);
            parcel.writeByte(this.f64677b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f64678c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f64679d ? (byte) 1 : (byte) 0);
            int size = this.f64681f.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                ((b) this.f64681f.get(i3)).c(parcel);
            }
            parcel.writeLong(this.f64680e);
            parcel.writeByte(this.f64682g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f64683h);
            parcel.writeInt(this.f64684i);
            parcel.writeInt(this.f64685j);
            parcel.writeInt(this.f64686k);
        }

        private c(Parcel parcel) {
            this.f64676a = parcel.readLong();
            this.f64677b = parcel.readByte() == 1;
            this.f64678c = parcel.readByte() == 1;
            this.f64679d = parcel.readByte() == 1;
            int i3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(b.b(parcel));
            }
            this.f64681f = Collections.unmodifiableList(arrayList);
            this.f64680e = parcel.readLong();
            this.f64682g = parcel.readByte() == 1;
            this.f64683h = parcel.readLong();
            this.f64684i = parcel.readInt();
            this.f64685j = parcel.readInt();
            this.f64686k = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b(Parcel parcel) {
            return new c(parcel);
        }
    }

    private wk(Parcel parcel) {
        int i3 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(c.b(parcel));
        }
        this.f64673a = Collections.unmodifiableList(arrayList);
    }

    static wk a(ah ahVar) {
        int iW = ahVar.w();
        ArrayList arrayList = new ArrayList(iW);
        for (int i3 = 0; i3 < iW; i3++) {
            arrayList.add(c.b(ahVar));
        }
        return new wk(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int size = this.f64673a.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            ((c) this.f64673a.get(i4)).c(parcel);
        }
    }

    /* synthetic */ wk(Parcel parcel, a aVar) {
        this(parcel);
    }

    private wk(List list) {
        this.f64673a = Collections.unmodifiableList(list);
    }
}
