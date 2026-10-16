package cz.mobilesoft.coreblock.scene.onboarding.statistics;

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
final class AnimationState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnimationState[] $VALUES;
    public static final AnimationState Waiting = new AnimationState("Waiting", 0);
    public static final AnimationState TrendIconInitial = new AnimationState("TrendIconInitial", 1);
    public static final AnimationState TrendIconAndData = new AnimationState("TrendIconAndData", 2);
    public static final AnimationState Report = new AnimationState("Report", 3);

    private static final /* synthetic */ AnimationState[] $values() {
        return new AnimationState[]{Waiting, TrendIconInitial, TrendIconAndData, Report};
    }

    static {
        AnimationState[] animationStateArr$values = $values();
        $VALUES = animationStateArr$values;
        $ENTRIES = EnumEntriesKt.a(animationStateArr$values);
    }

    private AnimationState(String str, int i3) {
    }

    public static EnumEntries<AnimationState> getEntries() {
        return $ENTRIES;
    }

    public static AnimationState valueOf(String str) {
        return (AnimationState) Enum.valueOf(AnimationState.class, str);
    }

    public static AnimationState[] values() {
        return (AnimationState[]) $VALUES.clone();
    }
}
