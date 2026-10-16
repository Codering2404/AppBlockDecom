package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class NonEmptyMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final int $stable = 8;
    private final Map<K, V> all;
    private final Map.Entry<K, V> entry;
    private final NonEmptySet<K> keys;

    /* JADX WARN: Multi-variable type inference failed */
    private NonEmptyMap(Map.Entry<? extends K, ? extends V> entry, Map<K, ? extends V> map) {
        this.entry = entry;
        this.all = map;
        this.keys = new NonEmptySet<>(entry.getKey(), (Iterable<? extends Object>) map.keySet());
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V compute(K k3, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfPresent(K k3, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.all.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.all.containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (!(obj instanceof NonEmptyMap)) {
            return Intrinsics.areEqual(this.all, obj);
        }
        NonEmptyMap nonEmptyMap = (NonEmptyMap) obj;
        return Intrinsics.areEqual(this.entry, nonEmptyMap.entry) && Intrinsics.areEqual(this.all, nonEmptyMap.all);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return this.all.get(obj);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.all.entrySet();
    }

    public final /* synthetic */ Map.Entry getEntry() {
        return this.entry;
    }

    public NonEmptySet<K> getKeys() {
        return this.keys;
    }

    public int getSize() {
        return this.all.size();
    }

    public Collection<V> getValues() {
        return this.all.values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.all.hashCode();
    }

    @Override // java.util.Map
    public /* synthetic */ boolean isEmpty() {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ NonEmptySet<K> keySet() {
        return getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> NonEmptyMap<R, V> mapKeys(Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Object objInvoke = transform.invoke(getEntry());
        Map map = this.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Intrinsics.areEqual(entry.getKey(), getEntry().getKey()) ? objInvoke : transform.invoke(entry), entry.getValue());
        }
        return NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(objInvoke, MapsKt.getValue(linkedHashMap, objInvoke)), linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> NonEmptyMap<K, R> mapValues(Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Map map = this.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(getEntry().getKey(), MapsKt.getValue(linkedHashMap, getEntry().getKey())), linkedHashMap);
    }

    @Override // java.util.Map
    public V merge(K k3, V v2, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V put(K k3, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V putIfAbsent(K k3, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V replace(K k3, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* synthetic */ Map toMap() {
        return this.all;
    }

    public String toString() {
        return "NonEmptyMap(" + CollectionsKt.joinToString$default(this.all.entrySet(), null, null, null, 0, null, null, 63, null) + ')';
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @Override // java.util.Map
    public V computeIfAbsent(K k3, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException(bfIdKSjLOVjG.VcunOGIsjnXobZC);
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(K k3, V v2, V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonEmptyMap(Pair<? extends K, ? extends V> entry, Map<K, ? extends V> tail) {
        this((Map.Entry) CollectionsKt.first(MapsKt.mapOf(entry).entrySet()), MapsKt.plus(tail, entry));
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(tail, "tail");
    }
}
