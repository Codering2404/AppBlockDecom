package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class t4 implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f63869a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f63870b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f63871c = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f63872d = Collections.EMPTY_LIST;

    public void a(Object obj) {
        synchronized (this.f63869a) {
            try {
                ArrayList arrayList = new ArrayList(this.f63872d);
                arrayList.add(obj);
                this.f63872d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f63870b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f63871c);
                    hashSet.add(obj);
                    this.f63871c = Collections.unmodifiableSet(hashSet);
                }
                this.f63870b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int b(Object obj) {
        int iIntValue;
        synchronized (this.f63869a) {
            try {
                iIntValue = this.f63870b.containsKey(obj) ? ((Integer) this.f63870b.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public void c(Object obj) {
        synchronized (this.f63869a) {
            try {
                Integer num = (Integer) this.f63870b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f63872d);
                arrayList.remove(obj);
                this.f63872d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f63870b.remove(obj);
                    HashSet hashSet = new HashSet(this.f63871c);
                    hashSet.remove(obj);
                    this.f63871c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f63870b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f63869a) {
            it = this.f63872d.iterator();
        }
        return it;
    }

    public Set a() {
        Set set;
        synchronized (this.f63869a) {
            set = this.f63871c;
        }
        return set;
    }
}
