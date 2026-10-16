package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    protected ForwardingMultimap() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Multimap I1();

    public Collection a(Object obj) {
        return I1().a(obj);
    }

    @Override // com.google.common.collect.Multimap
    public Map a1() {
        return I1().a1();
    }

    @Override // com.google.common.collect.Multimap
    public Collection b() {
        return I1().b();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        I1().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return I1().containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean equals(Object obj) {
        return obj == this || I1().equals(obj);
    }

    public Collection get(Object obj) {
        return I1().get(obj);
    }

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return I1().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return I1().isEmpty();
    }

    @Override // com.google.common.collect.Multimap
    public Set keySet() {
        return I1().keySet();
    }

    @Override // com.google.common.collect.Multimap
    public Multiset keys() {
        return I1().keys();
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        return I1().put(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        return I1().remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return I1().size();
    }

    @Override // com.google.common.collect.Multimap
    public Collection values() {
        return I1().values();
    }

    @Override // com.google.common.collect.Multimap
    public boolean w1(Object obj, Object obj2) {
        return I1().w1(obj, obj2);
    }
}
