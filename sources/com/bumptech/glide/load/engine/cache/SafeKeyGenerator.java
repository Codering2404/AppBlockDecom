package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SafeKeyGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache f66622a = new LruCache(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool f66623b = FactoryPools.d(10, new FactoryPools.Factory<PoolableDigestContainer>() { // from class: com.bumptech.glide.load.engine.cache.SafeKeyGenerator.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoolableDigestContainer create() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(e3);
            }
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageDigest f66625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StateVerifier f66626b = StateVerifier.a();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.f66625a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        public StateVerifier d() {
            return this.f66626b;
        }
    }

    private String a(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.e((PoolableDigestContainer) this.f66623b.a());
        try {
            key.b(poolableDigestContainer.f66625a);
            return Util.z(poolableDigestContainer.f66625a.digest());
        } finally {
            this.f66623b.b(poolableDigestContainer);
        }
    }

    public String b(Key key) {
        String strA;
        synchronized (this.f66622a) {
            strA = (String) this.f66622a.i(key);
        }
        if (strA == null) {
            strA = a(key);
        }
        synchronized (this.f66622a) {
            this.f66622a.l(key, strA);
        }
        return strA;
    }
}
