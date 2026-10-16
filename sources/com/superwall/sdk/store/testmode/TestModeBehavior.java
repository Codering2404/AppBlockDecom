package com.superwall.sdk.store.testmode;

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
public final class TestModeBehavior {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TestModeBehavior[] $VALUES;
    public static final TestModeBehavior AUTOMATIC = new TestModeBehavior("AUTOMATIC", 0);
    public static final TestModeBehavior WHEN_ENABLED_FOR_USER = new TestModeBehavior("WHEN_ENABLED_FOR_USER", 1);
    public static final TestModeBehavior NEVER = new TestModeBehavior("NEVER", 2);
    public static final TestModeBehavior ALWAYS = new TestModeBehavior("ALWAYS", 3);

    private static final /* synthetic */ TestModeBehavior[] $values() {
        return new TestModeBehavior[]{AUTOMATIC, WHEN_ENABLED_FOR_USER, NEVER, ALWAYS};
    }

    static {
        TestModeBehavior[] testModeBehaviorArr$values = $values();
        $VALUES = testModeBehaviorArr$values;
        $ENTRIES = EnumEntriesKt.a(testModeBehaviorArr$values);
    }

    private TestModeBehavior(String str, int i3) {
    }

    public static EnumEntries<TestModeBehavior> getEntries() {
        return $ENTRIES;
    }

    public static TestModeBehavior valueOf(String str) {
        return (TestModeBehavior) Enum.valueOf(TestModeBehavior.class, str);
    }

    public static TestModeBehavior[] values() {
        return (TestModeBehavior[]) $VALUES.clone();
    }
}
