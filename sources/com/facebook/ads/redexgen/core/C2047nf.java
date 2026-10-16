package com.facebook.ads.redexgen.core;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2047nf<K> extends AbstractSet<K> {
    public final /* synthetic */ C2049nh A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    public C2047nf(final C2049nh this$0) {
        this.A00 = this$0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.A00.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object o3) {
        return this.A00.containsKey(o3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<K> iterator() {
        return this.A00.A0e();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object o3) {
        Map mapA0h = this.A00.A0h();
        if (mapA0h != null) {
            return mapA0h.keySet().remove(o3);
        }
        return this.A00.A0K(o3) != C2049nh.A0B;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nf != com.google.common.collect.CompactHashMap<K, V>$KeySetView */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.A00.size();
    }
}
