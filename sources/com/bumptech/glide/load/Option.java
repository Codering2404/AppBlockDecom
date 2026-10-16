package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Option<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CacheKeyUpdater f66255e = new CacheKeyUpdater<Object>() { // from class: com.bumptech.glide.load.Option.1
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f66256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CacheKeyUpdater f66257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f66258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte[] f66259d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CacheKeyUpdater<T> {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    private Option(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        this.f66258c = Preconditions.c(str);
        this.f66256a = obj;
        this.f66257b = (CacheKeyUpdater) Preconditions.e(cacheKeyUpdater);
    }

    public static Option a(String str, Object obj, CacheKeyUpdater cacheKeyUpdater) {
        return new Option(str, obj, cacheKeyUpdater);
    }

    private static CacheKeyUpdater b() {
        return f66255e;
    }

    private byte[] d() {
        if (this.f66259d == null) {
            this.f66259d = this.f66258c.getBytes(Key.f66253a);
        }
        return this.f66259d;
    }

    public static Option e(String str) {
        return new Option(str, null, b());
    }

    public static Option f(String str, Object obj) {
        return new Option(str, obj, b());
    }

    public Object c() {
        return this.f66256a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f66258c.equals(((Option) obj).f66258c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.f66257b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.f66258c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f66258c + "'}";
    }
}
