package cz.mobilesoft.coreblock.scene.auto_trial.screens;

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
final class AutoTrialPhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AutoTrialPhase[] $VALUES;
    public static final AutoTrialPhase Intro = new AutoTrialPhase("Intro", 0);
    public static final AutoTrialPhase Celebrating = new AutoTrialPhase("Celebrating", 1);
    public static final AutoTrialPhase Settled = new AutoTrialPhase("Settled", 2);

    private static final /* synthetic */ AutoTrialPhase[] $values() {
        return new AutoTrialPhase[]{Intro, Celebrating, Settled};
    }

    static {
        AutoTrialPhase[] autoTrialPhaseArr$values = $values();
        $VALUES = autoTrialPhaseArr$values;
        $ENTRIES = EnumEntriesKt.a(autoTrialPhaseArr$values);
    }

    private AutoTrialPhase(String str, int i3) {
    }

    public static EnumEntries<AutoTrialPhase> getEntries() {
        return $ENTRIES;
    }

    public static AutoTrialPhase valueOf(String str) {
        return (AutoTrialPhase) Enum.valueOf(AutoTrialPhase.class, str);
    }

    public static AutoTrialPhase[] values() {
        return (AutoTrialPhase[]) $VALUES.clone();
    }
}
