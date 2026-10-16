package com.superwall.supercel;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import com.superwall.supercel.RustBuffer;
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
public final class RustBufferByReference extends ByReference {
    public RustBufferByReference() {
        super(16);
    }

    public final RustBuffer.ByValue getValue() {
        Pointer pointer = getPointer();
        RustBuffer.ByValue byValue = new RustBuffer.ByValue();
        byValue.writeField("capacity", Long.valueOf(pointer.getLong(0L)));
        byValue.writeField("len", Long.valueOf(pointer.getLong(8L)));
        byValue.writeField("data", Long.valueOf(pointer.getLong(16L)));
        return byValue;
    }

    public final void setValue(RustBuffer.ByValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Pointer pointer = getPointer();
        pointer.setLong(0L, value.capacity);
        pointer.setLong(8L, value.len);
        pointer.setPointer(16L, value.data);
    }
}
