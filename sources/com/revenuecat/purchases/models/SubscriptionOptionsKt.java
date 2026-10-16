package com.revenuecat.purchases.models;

import com.revenuecat.purchases.models.Period;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

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
public final class SubscriptionOptionsKt {
    private static final int DAYS_IN_DAY = 1;
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_WEEK = 7;
    private static final int DAYS_IN_YEAR = 365;
    private static final Map<Period.Unit, Integer> DAYS_IN_UNIT = MapsKt.mapOf(TuplesKt.a(Period.Unit.DAY, 1), TuplesKt.a(Period.Unit.WEEK, 7), TuplesKt.a(Period.Unit.MONTH, 30), TuplesKt.a(Period.Unit.YEAR, Integer.valueOf(DAYS_IN_YEAR)));
}
