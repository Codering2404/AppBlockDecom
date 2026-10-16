package cz.mobilesoft.coreblock.scene.schedule.detail;

import cz.mobilesoft.coreblock.R;
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
public final class LockType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LockType[] $VALUES;
    private final int titleRes;
    public static final LockType Time = new LockType("Time", 0, R.string.oj);
    public static final LockType Charger = new LockType("Charger", 1, R.string.nj);

    private static final /* synthetic */ LockType[] $values() {
        return new LockType[]{Time, Charger};
    }

    static {
        LockType[] lockTypeArr$values = $values();
        $VALUES = lockTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(lockTypeArr$values);
    }

    private LockType(String str, int i3, int i4) {
        this.titleRes = i4;
    }

    public static EnumEntries<LockType> getEntries() {
        return $ENTRIES;
    }

    public static LockType valueOf(String str) {
        return (LockType) Enum.valueOf(LockType.class, str);
    }

    public static LockType[] values() {
        return (LockType[]) $VALUES.clone();
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
