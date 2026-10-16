package com.revenuecat.purchases.common;

import com.revenuecat.purchases.strings.Emojis;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public enum LogIntent {
    DEBUG(CollectionsKt.listOf(Emojis.INFO)),
    GOOGLE_ERROR(CollectionsKt.listOf((Object[]) new String[]{Emojis.ROBOT, Emojis.DOUBLE_EXCLAMATION})),
    GOOGLE_WARNING(CollectionsKt.listOf((Object[]) new String[]{Emojis.ROBOT, Emojis.DOUBLE_EXCLAMATION})),
    INFO(CollectionsKt.listOf(Emojis.INFO)),
    PURCHASE(CollectionsKt.listOf(Emojis.MONEY_BAG)),
    RC_ERROR(CollectionsKt.listOf((Object[]) new String[]{Emojis.SAD_CAT_EYES, Emojis.DOUBLE_EXCLAMATION})),
    RC_PURCHASE_SUCCESS(CollectionsKt.listOf((Object[]) new String[]{Emojis.HEART_CAT_EYES, Emojis.MONEY_BAG})),
    RC_SUCCESS(CollectionsKt.listOf(Emojis.HEART_CAT_EYES)),
    USER(CollectionsKt.listOf(Emojis.PERSON)),
    WARNING(CollectionsKt.listOf(Emojis.WARNING)),
    AMAZON_WARNING(CollectionsKt.listOf((Object[]) new String[]{Emojis.BOX, Emojis.DOUBLE_EXCLAMATION})),
    AMAZON_ERROR(CollectionsKt.listOf((Object[]) new String[]{Emojis.BOX, Emojis.DOUBLE_EXCLAMATION})),
    GALAXY_WARNING(CollectionsKt.listOf((Object[]) new String[]{Emojis.STARS, Emojis.DOUBLE_EXCLAMATION})),
    GALAXY_ERROR(CollectionsKt.listOf((Object[]) new String[]{Emojis.STARS, Emojis.DOUBLE_EXCLAMATION}));

    private final List<String> emojiList;

    LogIntent(List list) {
        this.emojiList = list;
    }

    public final List<String> getEmojiList() {
        return this.emojiList;
    }
}
