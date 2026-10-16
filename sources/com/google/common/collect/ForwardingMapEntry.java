package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    protected ForwardingMapEntry() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public abstract Map.Entry o2();

    protected boolean S1(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.a(getKey(), entry.getKey()) && Objects.a(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        return o2().equals(obj);
    }

    @Override // java.util.Map.Entry
    public Object getKey() {
        return o2().getKey();
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return o2().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return o2().hashCode();
    }

    public Object setValue(Object obj) {
        return o2().setValue(obj);
    }
}
