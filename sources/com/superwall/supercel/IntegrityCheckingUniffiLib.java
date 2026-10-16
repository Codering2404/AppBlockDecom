package com.superwall.supercel;

import com.sun.jna.Library;
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
public interface IntegrityCheckingUniffiLib extends Library {
    int ffi_cel_eval_uniffi_contract_version();

    short uniffi_cel_eval_checksum_func_evaluate_ast();

    short uniffi_cel_eval_checksum_func_evaluate_ast_with_context();

    short uniffi_cel_eval_checksum_func_evaluate_with_context();

    short uniffi_cel_eval_checksum_func_parse_to_ast();

    short uniffi_cel_eval_checksum_method_hostcontext_computed_property();

    short uniffi_cel_eval_checksum_method_hostcontext_device_property();

    short uniffi_cel_eval_checksum_method_resultcallback_on_result();
}
