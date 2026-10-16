package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class DataCacheKey implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Key f66330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Key f66331c;

    DataCacheKey(Key key, Key key2) {
        this.f66330b = key;
        this.f66331c = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        this.f66330b.b(messageDigest);
        this.f66331c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            if (this.f66330b.equals(dataCacheKey.f66330b) && this.f66331c.equals(dataCacheKey.f66331c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f66330b.hashCode() * 31) + this.f66331c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f66330b + ", signature=" + this.f66331c + '}';
    }
}
