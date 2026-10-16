package cz.mobilesoft.coreblock.scene.onboarding;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingFlowVariant {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnboardingFlowVariant[] $VALUES;
    public static final Companion Companion;
    public static final OnboardingFlowVariant Default = new OnboardingFlowVariant("Default", 0, "V0", CollectionsKt.listOf((Object[]) new String[]{"welcome", "sign_in", "data_info", "time_on_phone", "stats_permission", "statistics", "graph", "years_spent_splash", "years_spent", "your_potential", "crucial_week", "blocking_test", "app_block_can_help_you", "first_focus_splash", "first_focus"}));
    public static final OnboardingFlowVariant EarlyPaywall = new OnboardingFlowVariant("EarlyPaywall", 1, "V1", CollectionsKt.listOf((Object[]) new String[]{"welcome", "sign_in", "data_info", "time_on_phone", "stats_permission", "statistics", "graph", "years_spent_splash", "years_spent", "your_potential", "crucial_week", "app_block_can_help_you", "blocking_test", "first_focus_splash", "first_focus"}));
    private final String key;
    private final List<String> screenOrder;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingFlowVariant a(String key) {
            OnboardingFlowVariant next;
            Intrinsics.checkNotNullParameter(key, "key");
            Iterator<OnboardingFlowVariant> it = OnboardingFlowVariant.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getKey(), key)) {
                    break;
                }
            }
            OnboardingFlowVariant onboardingFlowVariant = next;
            return onboardingFlowVariant == null ? OnboardingFlowVariant.Default : onboardingFlowVariant;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ OnboardingFlowVariant[] $values() {
        return new OnboardingFlowVariant[]{Default, EarlyPaywall};
    }

    static {
        OnboardingFlowVariant[] onboardingFlowVariantArr$values = $values();
        $VALUES = onboardingFlowVariantArr$values;
        $ENTRIES = EnumEntriesKt.a(onboardingFlowVariantArr$values);
        Companion = new Companion(null);
    }

    private OnboardingFlowVariant(String str, int i3, String str2, List list) {
        this.key = str2;
        this.screenOrder = list;
    }

    public static EnumEntries<OnboardingFlowVariant> getEntries() {
        return $ENTRIES;
    }

    public static OnboardingFlowVariant valueOf(String str) {
        return (OnboardingFlowVariant) Enum.valueOf(OnboardingFlowVariant.class, str);
    }

    public static OnboardingFlowVariant[] values() {
        return (OnboardingFlowVariant[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public final List<String> getScreenOrder() {
        return this.screenOrder;
    }
}
