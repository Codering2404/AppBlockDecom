package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f2369f = new HashMap();

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected SafeIterableMap.Entry b(Object obj) {
        return (SafeIterableMap.Entry) this.f2369f.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f2369f.containsKey(obj);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public Object g(Object obj, Object obj2) {
        SafeIterableMap.Entry entryB = b(obj);
        if (entryB != null) {
            return entryB.f2375b;
        }
        this.f2369f.put(obj, f(obj, obj2));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public Object h(Object obj) {
        Object objH = super.h(obj);
        this.f2369f.remove(obj);
        return objH;
    }

    public Map.Entry l(Object obj) {
        if (contains(obj)) {
            return ((SafeIterableMap.Entry) this.f2369f.get(obj)).f2377d;
        }
        return null;
    }
}
