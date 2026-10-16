package com.facebook.gamingservices.model;

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
public final class CustomUpdateContentKt {
    private static final String CONTEXT_TOKEN_KEY = "context_token_id";
    private static final String CTA_KEY = "cta";
    private static final String DATA_KEY = "data";
    private static final String DEFAULT_KEY = "default";
    private static final String GIF_KEY = "gif";
    private static final String IMAGE_KEY = "image";
    private static final String LOCALIZATIONS_KEY = "localizations";
    private static final String MEDIA_KEY = "media";
    private static final String TEXT_KEY = "text";
    private static final String URL_KEY = "url";
    private static final String VIDEO_KEY = "video";
}
