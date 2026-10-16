package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Options implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap f66260b = new CachedHashCodeArrayMap();

    private static void g(Option option, Object obj, MessageDigest messageDigest) {
        option.g(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        for (int i3 = 0; i3 < this.f66260b.size(); i3++) {
            g((Option) this.f66260b.f(i3), this.f66260b.j(i3), messageDigest);
        }
    }

    public Object c(Option option) {
        return this.f66260b.containsKey(option) ? this.f66260b.get(option) : option.c();
    }

    public void d(Options options) {
        this.f66260b.g(options.f66260b);
    }

    public Options e(Option option) {
        this.f66260b.remove(option);
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f66260b.equals(((Options) obj).f66260b);
        }
        return false;
    }

    public Options f(Option option, Object obj) {
        this.f66260b.put(option, obj);
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f66260b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f66260b + '}';
    }
}
