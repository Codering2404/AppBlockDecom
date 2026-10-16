package com.superwall.sdk.store.abstractions.product.receipt;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class LatestSubscriptionOfferType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LatestSubscriptionOfferType[] $VALUES;
    public static final LatestSubscriptionOfferType TRIAL = new LatestSubscriptionOfferType("TRIAL", 0);
    public static final LatestSubscriptionOfferType CODE = new LatestSubscriptionOfferType("CODE", 1);
    public static final LatestSubscriptionOfferType PROMOTIONAL = new LatestSubscriptionOfferType("PROMOTIONAL", 2);
    public static final LatestSubscriptionOfferType WINBACK = new LatestSubscriptionOfferType("WINBACK", 3);

    private static final /* synthetic */ LatestSubscriptionOfferType[] $values() {
        return new LatestSubscriptionOfferType[]{TRIAL, CODE, PROMOTIONAL, WINBACK};
    }

    static {
        LatestSubscriptionOfferType[] latestSubscriptionOfferTypeArr$values = $values();
        $VALUES = latestSubscriptionOfferTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(latestSubscriptionOfferTypeArr$values);
    }

    private LatestSubscriptionOfferType(String str, int i3) {
    }

    public static EnumEntries<LatestSubscriptionOfferType> getEntries() {
        return $ENTRIES;
    }

    public static LatestSubscriptionOfferType valueOf(String str) {
        return (LatestSubscriptionOfferType) Enum.valueOf(LatestSubscriptionOfferType.class, str);
    }

    public static LatestSubscriptionOfferType[] values() {
        return (LatestSubscriptionOfferType[]) $VALUES.clone();
    }
}
