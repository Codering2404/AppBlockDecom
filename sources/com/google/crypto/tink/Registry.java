package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Registry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f86046a = Logger.getLogger(Registry.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference f86047b = new AtomicReference(new KeyManagerRegistry());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentMap f86048c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentMap f86049d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentMap f86050e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentMap f86051f = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface KeyDeriverContainer {
    }

    private static KeyDeriverContainer a(final KeyTypeManager keyTypeManager) {
        return new KeyDeriverContainer() { // from class: com.google.crypto.tink.Registry.1
        };
    }

    private static synchronized void b(String str, Map map, boolean z2) {
        if (z2) {
            try {
                ConcurrentMap concurrentMap = f86049d;
                if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                }
            } finally {
            }
        }
        if (z2) {
            if (((KeyManagerRegistry) f86047b.get()).f(str)) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!f86051f.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry entry2 : map.entrySet()) {
                    if (f86051f.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template " + ((String) entry2.getKey()));
                    }
                }
            }
        }
    }

    static synchronized Map c() {
        return Collections.unmodifiableMap(f86051f);
    }

    public static synchronized void d(PrivateKeyTypeManager privateKeyTypeManager, KeyTypeManager keyTypeManager, boolean z2) {
        try {
            if (privateKeyTypeManager == null || keyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            AtomicReference atomicReference = f86047b;
            KeyManagerRegistry keyManagerRegistry = new KeyManagerRegistry((KeyManagerRegistry) atomicReference.get());
            keyManagerRegistry.c(privateKeyTypeManager, keyTypeManager);
            String strC = privateKeyTypeManager.c();
            String strC2 = keyTypeManager.c();
            b(strC, z2 ? privateKeyTypeManager.d().a() : Collections.EMPTY_MAP, z2);
            b(strC2, Collections.EMPTY_MAP, false);
            if (!((KeyManagerRegistry) atomicReference.get()).f(strC)) {
                f86048c.put(strC, a(privateKeyTypeManager));
                if (z2) {
                    f(privateKeyTypeManager.c(), privateKeyTypeManager.d().a());
                }
            }
            ConcurrentMap concurrentMap = f86049d;
            concurrentMap.put(strC, Boolean.valueOf(z2));
            concurrentMap.put(strC2, Boolean.FALSE);
            atomicReference.set(keyManagerRegistry);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void e(KeyTypeManager keyTypeManager, boolean z2) {
        try {
            if (keyTypeManager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference atomicReference = f86047b;
            KeyManagerRegistry keyManagerRegistry = new KeyManagerRegistry((KeyManagerRegistry) atomicReference.get());
            keyManagerRegistry.d(keyTypeManager);
            String strC = keyTypeManager.c();
            b(strC, z2 ? keyTypeManager.d().a() : Collections.EMPTY_MAP, z2);
            if (!((KeyManagerRegistry) atomicReference.get()).f(strC)) {
                f86048c.put(strC, a(keyTypeManager));
                if (z2) {
                    f(strC, keyTypeManager.d().a());
                }
            }
            f86049d.put(strC, Boolean.valueOf(z2));
            atomicReference.set(keyManagerRegistry);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void f(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            f86051f.put((String) entry.getKey(), KeyTemplate.a(str, ((MessageLite) ((KeyTypeManager.KeyFactory.KeyFormat) entry.getValue()).f86242a).i(), ((KeyTypeManager.KeyFactory.KeyFormat) entry.getValue()).f86243b));
        }
    }

    public static synchronized void g(PrimitiveWrapper primitiveWrapper) {
        MutablePrimitiveRegistry.a().c(primitiveWrapper);
    }
}
