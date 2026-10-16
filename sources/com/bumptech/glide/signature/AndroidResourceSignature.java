package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidResourceSignature implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f67255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Key f67256c;

    private AndroidResourceSignature(int i3, Key key) {
        this.f67255b = i3;
        this.f67256c = key;
    }

    public static Key c(Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.c(context));
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        this.f67256c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f67255b).array());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof AndroidResourceSignature) {
            AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
            if (this.f67255b == androidResourceSignature.f67255b && this.f67256c.equals(androidResourceSignature.f67256c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.q(this.f67256c, this.f67255b);
    }
}
