package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class KeyManagerRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f86002b = Logger.getLogger(KeyManagerRegistry.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap f86003a;

    /* JADX INFO: renamed from: com.google.crypto.tink.KeyManagerRegistry$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements KeyManagerContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ KeyManager f86004a;

        @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
        public Class a() {
            return null;
        }

        @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
        public Class b() {
            return this.f86004a.getClass();
        }

        @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
        public KeyManager c() {
            return this.f86004a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface KeyManagerContainer {
        Class a();

        Class b();

        KeyManager c();
    }

    KeyManagerRegistry(KeyManagerRegistry keyManagerRegistry) {
        this.f86003a = new ConcurrentHashMap(keyManagerRegistry.f86003a);
    }

    private static KeyManagerContainer a(final KeyTypeManager keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.2
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class a() {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class b() {
                return keyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager c() {
                KeyTypeManager keyTypeManager2 = keyTypeManager;
                return new KeyManagerImpl(keyTypeManager2, keyTypeManager2.b());
            }
        };
    }

    private static KeyManagerContainer b(final PrivateKeyTypeManager privateKeyTypeManager, final KeyTypeManager keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.3
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class a() {
                return keyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class b() {
                return privateKeyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager c() {
                PrivateKeyTypeManager privateKeyTypeManager2 = privateKeyTypeManager;
                return new PrivateKeyManagerImpl(privateKeyTypeManager2, keyTypeManager, privateKeyTypeManager2.b());
            }
        };
    }

    private synchronized void e(KeyManagerContainer keyManagerContainer, boolean z2) {
        try {
            String strA = keyManagerContainer.c().a();
            KeyManagerContainer keyManagerContainer2 = (KeyManagerContainer) this.f86003a.get(strA);
            if (keyManagerContainer2 != null && !keyManagerContainer2.b().equals(keyManagerContainer.b())) {
                f86002b.warning("Attempted overwrite of a registered key manager for key type " + strA);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strA, keyManagerContainer2.b().getName(), keyManagerContainer.b().getName()));
            }
            if (z2) {
                this.f86003a.put(strA, keyManagerContainer);
            } else {
                this.f86003a.putIfAbsent(strA, keyManagerContainer);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void c(PrivateKeyTypeManager privateKeyTypeManager, KeyTypeManager keyTypeManager) {
        Class clsA;
        try {
            TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibilityA = privateKeyTypeManager.a();
            TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibilityA2 = keyTypeManager.a();
            if (!algorithmFipsCompatibilityA.a()) {
                throw new GeneralSecurityException("failed to register key manager " + privateKeyTypeManager.getClass() + " as it is not FIPS compatible.");
            }
            if (!algorithmFipsCompatibilityA2.a()) {
                throw new GeneralSecurityException("failed to register key manager " + keyTypeManager.getClass() + " as it is not FIPS compatible.");
            }
            String strC = privateKeyTypeManager.c();
            String strC2 = keyTypeManager.c();
            if (this.f86003a.containsKey(strC) && ((KeyManagerContainer) this.f86003a.get(strC)).a() != null && (clsA = ((KeyManagerContainer) this.f86003a.get(strC)).a()) != null && !clsA.getName().equals(keyTypeManager.getClass().getName())) {
                f86002b.warning("Attempted overwrite of a registered key manager for key type " + strC + " with inconsistent public key type " + strC2);
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", privateKeyTypeManager.getClass().getName(), clsA.getName(), keyTypeManager.getClass().getName()));
            }
            e(b(privateKeyTypeManager, keyTypeManager), true);
            e(a(keyTypeManager), false);
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void d(KeyTypeManager keyTypeManager) {
        if (!keyTypeManager.a().a()) {
            throw new GeneralSecurityException("failed to register key manager " + keyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        e(a(keyTypeManager), false);
    }

    boolean f(String str) {
        return this.f86003a.containsKey(str);
    }

    KeyManagerRegistry() {
        this.f86003a = new ConcurrentHashMap();
    }
}
