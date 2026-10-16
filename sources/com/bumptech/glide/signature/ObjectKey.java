package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ObjectKey implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f67262b;

    public ObjectKey(Object obj) {
        this.f67262b = Preconditions.e(obj);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        messageDigest.update(this.f67262b.toString().getBytes(Key.f66253a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.f67262b.equals(((ObjectKey) obj).f67262b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f67262b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f67262b + '}';
    }
}
