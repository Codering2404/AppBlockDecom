package cz.mobilesoft.coreblock.scene.more.guestpassshare;

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
public final class GuestPassShareFlowScenario {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GuestPassShareFlowScenario[] $VALUES;
    public static final GuestPassShareFlowScenario ActivateOnly;
    public static final Companion Companion;
    public static final GuestPassShareFlowScenario EligibleGuestPassShare;
    public static final GuestPassShareFlowScenario OnboardingShareOnly;
    public static final GuestPassShareFlowScenario ShareOnly;
    private final List<GuestPassShareFlowStep> steps;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GuestPassShareFlowScenario a(String str) {
            GuestPassShareFlowScenario next;
            Iterator<GuestPassShareFlowScenario> it = GuestPassShareFlowScenario.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.name(), str)) {
                    break;
                }
            }
            GuestPassShareFlowScenario guestPassShareFlowScenario = next;
            return guestPassShareFlowScenario == null ? GuestPassShareFlowScenario.EligibleGuestPassShare : guestPassShareFlowScenario;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ GuestPassShareFlowScenario[] $values() {
        return new GuestPassShareFlowScenario[]{EligibleGuestPassShare, ShareOnly, ActivateOnly, OnboardingShareOnly};
    }

    static {
        GuestPassShareFlowStep guestPassShareFlowStep = GuestPassShareFlowStep.GuestPassEligibleShare;
        GuestPassShareFlowStep guestPassShareFlowStep2 = GuestPassShareFlowStep.ActivateSharedGuestPass;
        GuestPassShareFlowStep guestPassShareFlowStep3 = GuestPassShareFlowStep.GuestPassActivated;
        EligibleGuestPassShare = new GuestPassShareFlowScenario("EligibleGuestPassShare", 0, CollectionsKt.listOf((Object[]) new GuestPassShareFlowStep[]{guestPassShareFlowStep, guestPassShareFlowStep2, guestPassShareFlowStep3}));
        GuestPassShareFlowStep guestPassShareFlowStep4 = GuestPassShareFlowStep.ShareWithActivePremium;
        GuestPassShareFlowStep guestPassShareFlowStep5 = GuestPassShareFlowStep.ThanksForSharing;
        ShareOnly = new GuestPassShareFlowScenario("ShareOnly", 1, CollectionsKt.listOf((Object[]) new GuestPassShareFlowStep[]{guestPassShareFlowStep4, guestPassShareFlowStep5}));
        ActivateOnly = new GuestPassShareFlowScenario("ActivateOnly", 2, CollectionsKt.listOf((Object[]) new GuestPassShareFlowStep[]{GuestPassShareFlowStep.ActivateReceivedGuestPass, guestPassShareFlowStep3}));
        OnboardingShareOnly = new GuestPassShareFlowScenario("OnboardingShareOnly", 3, CollectionsKt.listOf((Object[]) new GuestPassShareFlowStep[]{GuestPassShareFlowStep.OnboardingShare, guestPassShareFlowStep5}));
        GuestPassShareFlowScenario[] guestPassShareFlowScenarioArr$values = $values();
        $VALUES = guestPassShareFlowScenarioArr$values;
        $ENTRIES = EnumEntriesKt.a(guestPassShareFlowScenarioArr$values);
        Companion = new Companion(null);
    }

    private GuestPassShareFlowScenario(String str, int i3, List list) {
        this.steps = list;
    }

    public static EnumEntries<GuestPassShareFlowScenario> getEntries() {
        return $ENTRIES;
    }

    public static GuestPassShareFlowScenario valueOf(String str) {
        return (GuestPassShareFlowScenario) Enum.valueOf(GuestPassShareFlowScenario.class, str);
    }

    public static GuestPassShareFlowScenario[] values() {
        return (GuestPassShareFlowScenario[]) $VALUES.clone();
    }

    public final List<GuestPassShareFlowStep> getSteps() {
        return this.steps;
    }
}
