package org.threeten.bp.zone;

import androidx.compose.animation.core.h;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ZoneRulesInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ZoneRulesInitializer f146641a = new DoNothingZoneRulesInitializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f146642b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference f146643c = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        ServiceLoaderZoneRulesInitializer() {
        }

        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        protected void b() {
            Iterator it = ServiceLoader.load(ZoneRulesProvider.class, ZoneRulesProvider.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                try {
                    ZoneRulesProvider.f((ZoneRulesProvider) it.next());
                } catch (ServiceConfigurationError e3) {
                    if (!(e3.getCause() instanceof SecurityException)) {
                        throw e3;
                    }
                }
            }
        }
    }

    static void a() {
        if (f146642b.getAndSet(true)) {
            throw new IllegalStateException("Already initialized");
        }
        AtomicReference atomicReference = f146643c;
        h.a(atomicReference, null, new ServiceLoaderZoneRulesInitializer());
        ((ZoneRulesInitializer) atomicReference.get()).b();
    }

    public static void c(ZoneRulesInitializer zoneRulesInitializer) {
        if (f146642b.get()) {
            throw new IllegalStateException("Already initialized");
        }
        if (!h.a(f146643c, null, zoneRulesInitializer)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    protected abstract void b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        DoNothingZoneRulesInitializer() {
        }

        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        protected void b() {
        }
    }
}
