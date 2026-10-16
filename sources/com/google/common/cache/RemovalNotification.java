package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RemovalCause f83645a;

    private RemovalNotification(Object obj, Object obj2, RemovalCause removalCause) {
        super(obj, obj2);
        this.f83645a = (RemovalCause) Preconditions.t(removalCause);
    }

    public static RemovalNotification a(Object obj, Object obj2, RemovalCause removalCause) {
        return new RemovalNotification(obj, obj2, removalCause);
    }
}
