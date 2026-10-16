package cz.mobilesoft.coreblock.view.compose;

import com.facebook.share.HKJ.pnxuebdT;
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
public final class RoundButtonSize {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoundButtonSize[] $VALUES;
    public static final RoundButtonSize Tiny = new RoundButtonSize("Tiny", 0);
    public static final RoundButtonSize Small = new RoundButtonSize("Small", 1);
    public static final RoundButtonSize Medium = new RoundButtonSize("Medium", 2);
    public static final RoundButtonSize Big = new RoundButtonSize(pnxuebdT.RSRVmKnDE, 3);

    private static final /* synthetic */ RoundButtonSize[] $values() {
        return new RoundButtonSize[]{Tiny, Small, Medium, Big};
    }

    private RoundButtonSize(String str, int i3) {
    }

    public static EnumEntries<RoundButtonSize> getEntries() {
        return $ENTRIES;
    }

    public static RoundButtonSize valueOf(String str) {
        return (RoundButtonSize) Enum.valueOf(RoundButtonSize.class, str);
    }

    public static RoundButtonSize[] values() {
        return (RoundButtonSize[]) $VALUES.clone();
    }

    static {
        RoundButtonSize[] roundButtonSizeArr$values = $values();
        $VALUES = roundButtonSizeArr$values;
        $ENTRIES = EnumEntriesKt.a(roundButtonSizeArr$values);
    }
}
