package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LruCache<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f67285a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f67286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f67287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f67288d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Entry<Y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f67289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f67290b;

        Entry(Object obj, int i3) {
            this.f67289a = obj;
            this.f67290b = i3;
        }
    }

    public LruCache(long j3) {
        this.f67286b = j3;
        this.f67287c = j3;
    }

    private void h() {
        n(this.f67287c);
    }

    public void b() {
        n(0L);
    }

    public synchronized long c() {
        return this.f67287c;
    }

    public synchronized long d() {
        return this.f67288d;
    }

    public synchronized Object i(Object obj) {
        Entry entry;
        entry = (Entry) this.f67285a.get(obj);
        return entry != null ? entry.f67289a : null;
    }

    protected int j(Object obj) {
        return 1;
    }

    public synchronized Object l(Object obj, Object obj2) {
        int iJ = j(obj2);
        long j3 = iJ;
        if (j3 >= this.f67287c) {
            k(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f67288d += j3;
        }
        Entry entry = (Entry) this.f67285a.put(obj, obj2 == null ? null : new Entry(obj2, iJ));
        if (entry != null) {
            this.f67288d -= (long) entry.f67290b;
            if (!entry.f67289a.equals(obj2)) {
                k(obj, entry.f67289a);
            }
        }
        h();
        return entry != null ? entry.f67289a : null;
    }

    public synchronized Object m(Object obj) {
        Entry entry = (Entry) this.f67285a.remove(obj);
        if (entry == null) {
            return null;
        }
        this.f67288d -= (long) entry.f67290b;
        return entry.f67289a;
    }

    protected synchronized void n(long j3) {
        while (this.f67288d > j3) {
            Iterator it = this.f67285a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Entry entry2 = (Entry) entry.getValue();
            this.f67288d -= (long) entry2.f67290b;
            Object key = entry.getKey();
            it.remove();
            k(key, entry2.f67289a);
        }
    }

    protected void k(Object obj, Object obj2) {
    }
}
