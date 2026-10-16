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
public final class VirtualCurrencyStrings {
    public static final String ERROR_DECODING_CACHED_VIRTUAL_CURRENCIES = "Couldn't decode cached VirtualCurrencies. Error: %s";
    public static final VirtualCurrencyStrings INSTANCE = new VirtualCurrencyStrings();
    public static final String INVALIDATING_VIRTUAL_CURRENCIES_CACHE = "Invalidating VirtualCurrencies cache.";
    public static final String NO_CACHED_VIRTUAL_CURRENCIES = "There are no cached VirtualCurrencies.";
    public static final String VENDING_FROM_CACHE = "Vending VirtualCurrencies from cache.";
    public static final String VIRTUAL_CURRENCIES_STALE_UPDATING_FROM_NETWORK = "VirtualCurrencies cache is stale, updating from network.";
    public static final String VIRTUAL_CURRENCIES_UPDATED_FROM_NETWORK = "VirtualCurrencies updated from the network.";
    public static final String VIRTUAL_CURRENCIES_UPDATED_FROM_NETWORK_ERROR = "Attempt to update VirtualCurrencies from network failed. Error: %s";

    private VirtualCurrencyStrings() {
    }
}
