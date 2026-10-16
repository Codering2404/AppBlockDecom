package com.superwall.sdk.network.device;

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
public final class InterfaceStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InterfaceStyle[] $VALUES;
    private final String rawValue;
    public static final InterfaceStyle LIGHT = new InterfaceStyle("LIGHT", 0, "Light");
    public static final InterfaceStyle DARK = new InterfaceStyle("DARK", 1, "Dark");

    private static final /* synthetic */ InterfaceStyle[] $values() {
        return new InterfaceStyle[]{LIGHT, DARK};
    }

    static {
        InterfaceStyle[] interfaceStyleArr$values = $values();
        $VALUES = interfaceStyleArr$values;
        $ENTRIES = EnumEntriesKt.a(interfaceStyleArr$values);
    }

    private InterfaceStyle(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<InterfaceStyle> getEntries() {
        return $ENTRIES;
    }

    public static InterfaceStyle valueOf(String str) {
        return (InterfaceStyle) Enum.valueOf(InterfaceStyle.class, str);
    }

    public static InterfaceStyle[] values() {
        return (InterfaceStyle[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
