package com.superwall.sdk.paywall.presentation;

import com.facebook.GraphResponse;
import com.facebook.login.LoginLogger;
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
public final class CustomCallbackResultStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CustomCallbackResultStatus[] $VALUES;
    private final String rawValue;
    public static final CustomCallbackResultStatus SUCCESS = new CustomCallbackResultStatus("SUCCESS", 0, GraphResponse.SUCCESS_KEY);
    public static final CustomCallbackResultStatus FAILURE = new CustomCallbackResultStatus("FAILURE", 1, LoginLogger.EVENT_EXTRAS_FAILURE);

    private static final /* synthetic */ CustomCallbackResultStatus[] $values() {
        return new CustomCallbackResultStatus[]{SUCCESS, FAILURE};
    }

    static {
        CustomCallbackResultStatus[] customCallbackResultStatusArr$values = $values();
        $VALUES = customCallbackResultStatusArr$values;
        $ENTRIES = EnumEntriesKt.a(customCallbackResultStatusArr$values);
    }

    private CustomCallbackResultStatus(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<CustomCallbackResultStatus> getEntries() {
        return $ENTRIES;
    }

    public static CustomCallbackResultStatus valueOf(String str) {
        return (CustomCallbackResultStatus) Enum.valueOf(CustomCallbackResultStatus.class, str);
    }

    public static CustomCallbackResultStatus[] values() {
        return (CustomCallbackResultStatus[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
