package cz.mobilesoft.coreblock.scene.password;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PassCodeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PassCodeType[] $VALUES;
    public static final PassCodeType Create = new PassCodeType("Create", 0);
    public static final PassCodeType Check = new PassCodeType("Check", 1);
    public static final PassCodeType Remove = new PassCodeType("Remove", 2);

    private static final /* synthetic */ PassCodeType[] $values() {
        return new PassCodeType[]{Create, Check, Remove};
    }

    static {
        PassCodeType[] passCodeTypeArr$values = $values();
        $VALUES = passCodeTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(passCodeTypeArr$values);
    }

    private PassCodeType(String str, int i3) {
    }

    public static EnumEntries<PassCodeType> getEntries() {
        return $ENTRIES;
    }

    public static PassCodeType valueOf(String str) {
        return (PassCodeType) Enum.valueOf(PassCodeType.class, str);
    }

    public static PassCodeType[] values() {
        return (PassCodeType[]) $VALUES.clone();
    }
}
