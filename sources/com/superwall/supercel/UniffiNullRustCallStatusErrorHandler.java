package com.superwall.supercel;

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
public final class UniffiNullRustCallStatusErrorHandler implements UniffiRustCallStatusErrorHandler<InternalException> {
    public static final UniffiNullRustCallStatusErrorHandler INSTANCE = new UniffiNullRustCallStatusErrorHandler();

    private UniffiNullRustCallStatusErrorHandler() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.superwall.supercel.UniffiRustCallStatusErrorHandler
    public InternalException lift(RustBuffer.ByValue error_buf) throws E, InternalException {
        Intrinsics.checkNotNullParameter(error_buf, "error_buf");
        RustBuffer.Companion.free$supercel_release(error_buf);
        return new InternalException("Unexpected CALL_ERROR");
    }
}
