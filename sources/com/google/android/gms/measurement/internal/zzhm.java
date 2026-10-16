package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhm extends LruCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzht f73840a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhm(zzht zzhtVar, int i3) {
        super(20);
        Objects.requireNonNull(zzhtVar);
        this.f73840a = zzhtVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.g(str);
        return this.f73840a.o(str);
    }
}
