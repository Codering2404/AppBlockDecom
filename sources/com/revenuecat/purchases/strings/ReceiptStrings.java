package com.revenuecat.purchases.strings;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ReceiptStrings {
    public static final String CHECKING_IF_CACHE_STALE = "Checking if cache is stale AppInBackground %s";
    public static final String CLEANING_PREV_SENT_HASHED_TOKEN = "Cleaning previously sent tokens";
    public static final ReceiptStrings INSTANCE = new ReceiptStrings();
    public static final String SAVING_TOKENS = "Saving tokens %s";
    public static final String SAVING_TOKENS_WITH_HASH = "Saving token %s with hash %s";
    public static final String TOKENS_ALREADY_POSTED = "Tokens already posted: %s";
    public static final String TOKENS_IN_CACHE = "Tokens in cache before saving %s";

    private ReceiptStrings() {
    }
}
