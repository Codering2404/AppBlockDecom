package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class hb extends bb implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient db f60184b;

    hb() {
    }

    private static boolean a(int i3, int i4) {
        return i3 < (i4 >> 1) + (i4 >> 2);
    }

    public static hb h() {
        return oi.f62319i;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof hb) && g() && ((hb) obj).g() && hashCode() != obj.hashCode()) {
            return false;
        }
        return rj.a(this, obj);
    }

    db f() {
        return db.a(toArray());
    }

    boolean g() {
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return rj.a(this);
    }

    @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract pp iterator();

    @Override // com.applovin.impl.bb
    public db a() {
        db dbVar = this.f60184b;
        if (dbVar != null) {
            return dbVar;
        }
        db dbVarF = f();
        this.f60184b = dbVarF;
        return dbVarF;
    }

    static int a(int i3) {
        int iMax = Math.max(i3, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
            return iHighestOneBit;
        }
        Preconditions.checkArgument(iMax < 1073741824, "collection too large");
        return 1073741824;
    }

    private static hb a(int i3, Object... objArr) {
        if (i3 == 0) {
            return h();
        }
        if (i3 != 1) {
            int iA = a(i3);
            Object[] objArr2 = new Object[iA];
            int i4 = iA - 1;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                Object objA = fg.a(objArr[i7], i7);
                int iHashCode = objA.hashCode();
                int iA2 = ja.a(iHashCode);
                while (true) {
                    int i8 = iA2 & i4;
                    Object obj = objArr2[i8];
                    if (obj == null) {
                        objArr[i6] = objA;
                        objArr2[i8] = objA;
                        i5 += iHashCode;
                        i6++;
                        break;
                    }
                    if (obj.equals(objA)) {
                        break;
                    }
                    iA2++;
                }
            }
            Arrays.fill(objArr, i6, i3, (Object) null);
            if (i6 == 1) {
                return new hk(objArr[0], i5);
            }
            if (a(i6) < iA / 2) {
                return a(i6, objArr);
            }
            if (a(i6, objArr.length)) {
                objArr = Arrays.copyOf(objArr, i6);
            }
            return new oi(objArr, i5, objArr2, i4, i6);
        }
        return a(objArr[0]);
    }

    public static hb a(Collection collection) {
        if ((collection instanceof hb) && !(collection instanceof SortedSet)) {
            hb hbVar = (hb) collection;
            if (!hbVar.e()) {
                return hbVar;
            }
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    public static hb a(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return h();
        }
        if (length != 1) {
            return a(objArr.length, (Object[]) objArr.clone());
        }
        return a(objArr[0]);
    }

    public static hb a(Object obj, Object obj2) {
        return a(2, obj, obj2);
    }

    public static hb a(Object obj, Object obj2, Object obj3) {
        return a(3, obj, obj2, obj3);
    }

    public static hb a(Object obj) {
        return new hk(obj);
    }
}
