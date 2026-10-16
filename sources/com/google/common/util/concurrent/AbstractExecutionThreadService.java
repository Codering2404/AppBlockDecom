package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractExecutionThreadService implements Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LazyLogger f85617b = new LazyLogger(AbstractExecutionThreadService.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Service f85618a;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends AbstractService {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ AbstractExecutionThreadService f85619l;

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.f85619l.toString();
        }
    }

    protected String a() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f85618a.state();
    }

    public String toString() {
        return a() + " [" + state() + "]";
    }
}
