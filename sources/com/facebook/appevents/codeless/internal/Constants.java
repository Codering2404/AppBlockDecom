package com.facebook.appevents.codeless.internal;

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
public final class Constants {
    public static final String APP_INDEXING = "app_indexing";
    public static final String APP_INDEXING_ENABLED = "is_app_indexing_enabled";
    public static final int APP_INDEXING_SCHEDULE_INTERVAL_MS = 1000;
    public static final String BUTTON_SAMPLING = "button_sampling";
    public static final String DEVICE_SESSION_ID = "device_session_id";
    public static final String EVENT_MAPPING_PATH_TYPE_KEY = "path_type";
    public static final String EXTINFO = "extinfo";
    public static final Constants INSTANCE = new Constants();
    public static final String IS_CODELESS_EVENT_KEY = "_is_fb_codeless";
    public static final int MAX_TREE_DEPTH = 25;
    public static final String PATH_TYPE_ABSOLUTE = "absolute";
    public static final String PATH_TYPE_RELATIVE = "relative";
    public static final String PLATFORM = "android";

    private Constants() {
    }
}
