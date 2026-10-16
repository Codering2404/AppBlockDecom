package androidx.media3.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CopyOnWriteMultiset<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f41501a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f41502b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f41503c = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f41504d = Collections.EMPTY_LIST;

    public int Y1(Object obj) {
        int iIntValue;
        synchronized (this.f41501a) {
            try {
                iIntValue = this.f41502b.containsKey(obj) ? ((Integer) this.f41502b.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public void a(Object obj) {
        synchronized (this.f41501a) {
            try {
                ArrayList arrayList = new ArrayList(this.f41504d);
                arrayList.add(obj);
                this.f41504d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f41502b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f41503c);
                    hashSet.add(obj);
                    this.f41503c = Collections.unmodifiableSet(hashSet);
                }
                this.f41502b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Object obj) {
        synchronized (this.f41501a) {
            try {
                Integer num = (Integer) this.f41502b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f41504d);
                arrayList.remove(obj);
                this.f41504d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f41502b.remove(obj);
                    HashSet hashSet = new HashSet(this.f41503c);
                    hashSet.remove(obj);
                    this.f41503c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f41502b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set i() {
        Set set;
        synchronized (this.f41501a) {
            set = this.f41503c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator<E> it;
        synchronized (this.f41501a) {
            it = this.f41504d.iterator();
        }
        return it;
    }
}
