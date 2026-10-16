package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected abstract class StandardEntrySet extends Maps.EntrySet<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForwardingMap f83952a;

        @Override // com.google.common.collect.Maps.EntrySet
        Map f() {
            return this.f83952a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardKeySet extends Maps.KeySet<K, V> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardValues extends Maps.Values<K, V> {
    }

    protected ForwardingMap() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public abstract Map k2();

    protected boolean S1(Object obj) {
        return Maps.o(this, obj);
    }

    protected boolean T1(Object obj) {
        return Maps.p(this, obj);
    }

    protected int V1() {
        return Sets.f(entrySet());
    }

    protected String b2() {
        return Maps.L(this);
    }

    public void clear() {
        k2().clear();
    }

    public boolean containsKey(Object obj) {
        return k2().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return k2().containsValue(obj);
    }

    public Set entrySet() {
        return k2().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || k2().equals(obj);
    }

    public Object get(Object obj) {
        return k2().get(obj);
    }

    public int hashCode() {
        return k2().hashCode();
    }

    public boolean isEmpty() {
        return k2().isEmpty();
    }

    public Set keySet() {
        return k2().keySet();
    }

    public Object put(Object obj, Object obj2) {
        return k2().put(obj, obj2);
    }

    public void putAll(Map map) {
        k2().putAll(map);
    }

    public Object remove(Object obj) {
        return k2().remove(obj);
    }

    public int size() {
        return k2().size();
    }

    public Collection values() {
        return k2().values();
    }
}
