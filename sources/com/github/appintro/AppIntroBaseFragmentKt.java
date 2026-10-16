package com.github.appintro;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppIntroBaseFragmentKt {
    public static final String ARG_BG_COLOR = "bg_color";
    public static final String ARG_BG_DRAWABLE = "bg_drawable";
    public static final String ARG_DESC = "desc";
    public static final String ARG_DESC_COLOR = "desc_color";
    public static final String ARG_DESC_TYPEFACE = "desc_typeface";
    public static final String ARG_DESC_TYPEFACE_RES = "desc_typeface_res";
    public static final String ARG_DRAWABLE = "drawable";
    public static final String ARG_TITLE = "title";
    public static final String ARG_TITLE_COLOR = "title_color";
    public static final String ARG_TITLE_TYPEFACE = "title_typeface";
    public static final String ARG_TITLE_TYPEFACE_RES = "title_typeface_res";
}
