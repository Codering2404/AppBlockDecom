package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MediaStoreSignature implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f67259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f67260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f67261d;

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f67260c).putInt(this.f67261d).array());
        messageDigest.update(this.f67259b.getBytes(Key.f66253a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.f67260c == mediaStoreSignature.f67260c && this.f67261d == mediaStoreSignature.f67261d && this.f67259b.equals(mediaStoreSignature.f67259b);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int iHashCode = this.f67259b.hashCode() * 31;
        long j3 = this.f67260c;
        return ((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f67261d;
    }
}
