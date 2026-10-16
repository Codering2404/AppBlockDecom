package com.superwall.supercel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class UniffiHandleMap<T> {
    private final ConcurrentHashMap<Long, T> map = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public final T get(long j3) throws InternalException {
        T t2 = this.map.get(Long.valueOf(j3));
        if (t2 != null) {
            return t2;
        }
        throw new InternalException("UniffiHandleMap.get: Invalid handle");
    }

    public final int getSize() {
        return this.map.size();
    }

    public final long insert(T obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        long andAdd = this.counter.getAndAdd(1L);
        this.map.put(Long.valueOf(andAdd), obj);
        return andAdd;
    }

    public final T remove(long j3) throws InternalException {
        T tRemove = this.map.remove(Long.valueOf(j3));
        if (tRemove != null) {
            return tRemove;
        }
        throw new InternalException("UniffiHandleMap: Invalid handle");
    }
}
