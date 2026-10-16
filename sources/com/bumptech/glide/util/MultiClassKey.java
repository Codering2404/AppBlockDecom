package com.bumptech.glide.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiClassKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f67292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class f67293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class f67294c;

    public MultiClassKey() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.f67292a = cls;
        this.f67293b = cls2;
        this.f67294c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f67292a.equals(multiClassKey.f67292a) && this.f67293b.equals(multiClassKey.f67293b) && Util.e(this.f67294c, multiClassKey.f67294c);
    }

    public int hashCode() {
        int iHashCode = ((this.f67292a.hashCode() * 31) + this.f67293b.hashCode()) * 31;
        Class cls = this.f67294c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f67292a + ", second=" + this.f67293b + '}';
    }

    public MultiClassKey(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
