package com.bumptech.glide.load;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f66253a = Charset.forName(Utf8Charset.NAME);

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
