package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class q3 {
    static StringBuilder a(int i3) {
        p3.a(i3, "size");
        return new StringBuilder((int) Math.min(((long) i3) * 8, 1073741824L));
    }

    static boolean a(Collection collection, Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
