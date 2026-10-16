package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class EmptySignature implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final EmptySignature f67258b = new EmptySignature();

    private EmptySignature() {
    }

    public static EmptySignature c() {
        return f67258b;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
    }
}
