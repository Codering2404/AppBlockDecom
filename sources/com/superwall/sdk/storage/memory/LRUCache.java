package com.superwall.sdk.storage.memory;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LRUCache<K, V> implements GenericCache<K, V> {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_SIZE = 100;
    private static final boolean PRESENT = true;
    private final GenericCache<K, V> delegate;
    private K eldestKeyToRemove;
    private final LRUCache$keyMap$1 keyMap;
    private final int minimalSize;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LRUCache(GenericCache<K, V> delegate, final int i3) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.minimalSize = i3;
        this.keyMap = new LinkedHashMap<K, Boolean>(this, i3) { // from class: com.superwall.sdk.storage.memory.LRUCache$keyMap$1
            final /* synthetic */ LRUCache<K, V> this$0;

            {
                this.this$0 = this;
            }

            public /* bridge */ boolean containsValue(Boolean bool) {
                return super.containsValue((Object) bool);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<K, Boolean>> entrySet() {
                return (Set<Map.Entry<K, Boolean>>) getEntries();
            }

            public /* bridge */ Set<Map.Entry<Object, Boolean>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<Object> getKeys() {
                return super.keySet();
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<Boolean> getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<K> keySet() {
                return (Set<K>) getKeys();
            }

            public /* bridge */ boolean remove(Object obj, Boolean bool) {
                return super.remove(obj, (Object) bool);
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<K, Boolean> eldest) {
                Intrinsics.checkNotNullParameter(eldest, "eldest");
                boolean z2 = size() > ((LRUCache) this.this$0).minimalSize;
                if (z2) {
                    ((LRUCache) this.this$0).eldestKeyToRemove = eldest.getKey();
                }
                return z2;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Boolean> values() {
                return getValues();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Boolean) {
                    return containsValue((Boolean) obj);
                }
                return false;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if (obj2 instanceof Boolean) {
                    return remove(obj, (Boolean) obj2);
                }
                return false;
            }
        };
    }

    private final void cycleKeyMap(K k3) {
        put(k3, Boolean.TRUE);
        K k4 = this.eldestKeyToRemove;
        if (k4 != null) {
            this.delegate.remove(k4);
        }
        this.eldestKeyToRemove = null;
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public void clear() {
        clear();
        this.delegate.clear();
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public V get(K k3) {
        get(k3);
        return this.delegate.get(k3);
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public int getSize() {
        return this.delegate.getSize();
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public V remove(K k3) {
        return this.delegate.remove(k3);
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public void set(K k3, V v2) {
        this.delegate.set(k3, v2);
        cycleKeyMap(k3);
    }

    public /* synthetic */ LRUCache(GenericCache genericCache, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(genericCache, (i4 & 2) != 0 ? 100 : i3);
    }
}
