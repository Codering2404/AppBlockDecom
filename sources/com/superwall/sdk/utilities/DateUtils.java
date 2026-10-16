package com.superwall.sdk.utilities;

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
public final class DateUtils {
    public static final DateUtils INSTANCE = new DateUtils();
    private static final String ISO_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String ISO_SECONDS = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String ISO_SECONDS_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String SIMPLE = "yyyy-MM-dd HH:mm:ss";
    private static final String yyyy_MM_dd = "yyyy-MM-dd";
    private static final String HH_mm_ss = "HH:mm:ss";
    private static final String MMM_dd_yyyy = "MMM dd, yyyy";

    private DateUtils() {
    }

    public final String getHH_mm_ss() {
        return HH_mm_ss;
    }

    public final String getISO_MILLIS() {
        return ISO_MILLIS;
    }

    public final String getISO_SECONDS() {
        return ISO_SECONDS;
    }

    public final String getISO_SECONDS_TIMEZONE() {
        return ISO_SECONDS_TIMEZONE;
    }

    public final String getMMM_dd_yyyy() {
        return MMM_dd_yyyy;
    }

    public final String getSIMPLE() {
        return SIMPLE;
    }

    public final String getYyyy_MM_dd() {
        return yyyy_MM_dd;
    }
}
