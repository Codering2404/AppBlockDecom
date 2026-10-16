package cz.mobilesoft.coreblock.scene.intro.strictmode;

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
public final class StrictModeIntroNavigation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StrictModeIntroNavigation[] $VALUES;
    private final String route;
    public static final StrictModeIntroNavigation Start = new StrictModeIntroNavigation("Start", 0, "start");
    public static final StrictModeIntroNavigation SmartLock = new StrictModeIntroNavigation("SmartLock", 1, "smart_lock");
    public static final StrictModeIntroNavigation StrictModeExplanation = new StrictModeIntroNavigation("StrictModeExplanation", 2, "strict_mode_explanation");
    public static final StrictModeIntroNavigation HowDoesItWorkSplashScreen = new StrictModeIntroNavigation("HowDoesItWorkSplashScreen", 3, "how_does_it_work_splash_screen");
    public static final StrictModeIntroNavigation BlockingTestScreen = new StrictModeIntroNavigation("BlockingTestScreen", 4, "blocking_test_screen");
    public static final StrictModeIntroNavigation WhatStrictModeDoes = new StrictModeIntroNavigation("WhatStrictModeDoes", 5, "what_strict_mode_does");
    public static final StrictModeIntroNavigation WhatAreTheBenefits = new StrictModeIntroNavigation("WhatAreTheBenefits", 6, "what_are_the_benefits");
    public static final StrictModeIntroNavigation GainControlScreen = new StrictModeIntroNavigation("GainControlScreen", 7, "gain_control_screen");
    public static final StrictModeIntroNavigation YouDecideScreen = new StrictModeIntroNavigation("YouDecideScreen", 8, "you_decide_screen");
    public static final StrictModeIntroNavigation UnlocksScreen = new StrictModeIntroNavigation("UnlocksScreen", 9, "unlocks_screen");
    public static final StrictModeIntroNavigation RecommendedUnlocksScreen = new StrictModeIntroNavigation("RecommendedUnlocksScreen", 10, "recommended_unlocks_screen");
    public static final StrictModeIntroNavigation ThatIsItScreen = new StrictModeIntroNavigation("ThatIsItScreen", 11, "that_is_it_screen");
    public static final StrictModeIntroNavigation ActivateWhenReadyScreen = new StrictModeIntroNavigation("ActivateWhenReadyScreen", 12, "activate_when_ready_screen");

    private static final /* synthetic */ StrictModeIntroNavigation[] $values() {
        return new StrictModeIntroNavigation[]{Start, SmartLock, StrictModeExplanation, HowDoesItWorkSplashScreen, BlockingTestScreen, WhatStrictModeDoes, WhatAreTheBenefits, GainControlScreen, YouDecideScreen, UnlocksScreen, RecommendedUnlocksScreen, ThatIsItScreen, ActivateWhenReadyScreen};
    }

    static {
        StrictModeIntroNavigation[] strictModeIntroNavigationArr$values = $values();
        $VALUES = strictModeIntroNavigationArr$values;
        $ENTRIES = EnumEntriesKt.a(strictModeIntroNavigationArr$values);
    }

    private StrictModeIntroNavigation(String str, int i3, String str2) {
        this.route = str2;
    }

    public static EnumEntries<StrictModeIntroNavigation> getEntries() {
        return $ENTRIES;
    }

    public static StrictModeIntroNavigation valueOf(String str) {
        return (StrictModeIntroNavigation) Enum.valueOf(StrictModeIntroNavigation.class, str);
    }

    public static StrictModeIntroNavigation[] values() {
        return (StrictModeIntroNavigation[]) $VALUES.clone();
    }

    public final String getRoute() {
        return this.route;
    }
}
