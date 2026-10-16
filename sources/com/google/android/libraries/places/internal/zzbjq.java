package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbjq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zzbjr f76293a;

    static {
        zzbjr zzbnyVar;
        AtomicReference atomicReference = new AtomicReference();
        try {
            zzbnyVar = (zzbjr) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(zzbjr.class).getConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e3) {
            atomicReference.set(e3);
            zzbnyVar = new zzbny();
        } catch (Exception e4) {
            throw new RuntimeException("Storage override failed to initialize", e4);
        }
        f76293a = zzbnyVar;
        Throwable th = (Throwable) atomicReference.get();
        if (th != null) {
            zzbjs.f76294a.logp(Level.FINE, "io.grpc.Context$LazyStorage", "<clinit>", "Storage override doesn't exist. Using default", th);
        }
    }
}
