package com.superwall.sdk.storage.memory;

import java.util.HashMap;
import kotlin.Metadata;

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
public final class PerpetualCache<K, V> implements GenericCache<K, V> {
    private final HashMap<K, V> cache = new HashMap<>();

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public void clear() {
        this.cache.clear();
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public V get(K k3) {
        return this.cache.get(k3);
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public int getSize() {
        return this.cache.size();
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public V remove(K k3) {
        return this.cache.remove(k3);
    }

    @Override // com.superwall.sdk.storage.memory.GenericCache
    public void set(K k3, V v2) {
        this.cache.put(k3, v2);
    }
}
