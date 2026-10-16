package com.applovin.impl;

import android.os.Bundle;
import android.util.SparseArray;
import com.applovin.impl.db;
import com.applovin.impl.o2;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class p2 {
    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) xp.a(p2.class.getClassLoader()));
        }
    }

    public static List a(o2.a aVar, List list, List list2) {
        return list == null ? list2 : a(aVar, list);
    }

    public static SparseArray a(o2.a aVar, SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2;
        }
        SparseArray sparseArray3 = new SparseArray(sparseArray.size());
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            sparseArray3.put(sparseArray.keyAt(i3), aVar.a((Bundle) sparseArray.valueAt(i3)));
        }
        return sparseArray3;
    }

    public static o2 a(o2.a aVar, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return aVar.a(bundle);
    }

    public static db a(o2.a aVar, List list) {
        db.a aVarF = db.f();
        for (int i3 = 0; i3 < list.size(); i3++) {
            aVarF.b(aVar.a((Bundle) b1.a((Bundle) list.get(i3))));
        }
        return aVarF.a();
    }
}
