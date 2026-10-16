package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractIdleService implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Service f85653a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class DelegateService extends AbstractService {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ AbstractIdleService f85654l;

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.f85654l.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ThreadNameSupplier implements Supplier<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractIdleService f85655a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return this.f85655a.a() + " " + this.f85655a.state();
        }
    }

    protected String a() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f85653a.state();
    }

    public String toString() {
        return a() + " [" + state() + "]";
    }
}
