package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ImmutableClassToInstanceMap f84002b = new ImmutableClassToInstanceMap(ImmutableMap.n());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableMap f84003a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<B> {
    }

    private ImmutableClassToInstanceMap(ImmutableMap immutableMap) {
        this.f84003a = immutableMap;
    }

    public static ImmutableClassToInstanceMap c2() {
        return f84002b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public Map k2() {
        return this.f84003a;
    }

    Object readResolve() {
        return isEmpty() ? c2() : this;
    }
}
