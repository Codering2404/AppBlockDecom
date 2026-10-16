package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class OnboardingViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAlreadyAMemberLoggedIn extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAlreadyAMemberLoggedIn f104514a = new OnAlreadyAMemberLoggedIn();

        private OnAlreadyAMemberLoggedIn() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAlreadyAMemberLoggedIn);
        }

        public int hashCode() {
            return 400026188;
        }

        public String toString() {
            return "OnAlreadyAMemberLoggedIn";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDeveloperOnboardingSkipped extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDeveloperOnboardingSkipped f104515a = new OnDeveloperOnboardingSkipped();

        private OnDeveloperOnboardingSkipped() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDeveloperOnboardingSkipped);
        }

        public int hashCode() {
            return 1061539053;
        }

        public String toString() {
            return "OnDeveloperOnboardingSkipped";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMultiSelectContinueClicked extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMultiSelectContinueClicked f104516a = new OnMultiSelectContinueClicked();

        private OnMultiSelectContinueClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMultiSelectContinueClicked);
        }

        public int hashCode() {
            return 1346287661;
        }

        public String toString() {
            return "OnMultiSelectContinueClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPrivacyExplanationClosed extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPrivacyExplanationClosed f104517a = new OnPrivacyExplanationClosed();

        private OnPrivacyExplanationClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPrivacyExplanationClosed);
        }

        public int hashCode() {
            return 243711423;
        }

        public String toString() {
            return "OnPrivacyExplanationClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuestion1Answer extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OnboardingHelpItem f104518a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnQuestion1Answer(OnboardingHelpItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.f104518a = item;
        }

        public final OnboardingHelpItem a() {
            return this.f104518a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnQuestion1Answer) && Intrinsics.areEqual(this.f104518a, ((OnQuestion1Answer) obj).f104518a);
        }

        public int hashCode() {
            return this.f104518a.hashCode();
        }

        public String toString() {
            return "OnQuestion1Answer(item=" + this.f104518a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuickBlockSetUpClicked extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnQuickBlockSetUpClicked f104519a = new OnQuickBlockSetUpClicked();

        private OnQuickBlockSetUpClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnQuickBlockSetUpClicked);
        }

        public int hashCode() {
            return -507205236;
        }

        public String toString() {
            return "OnQuickBlockSetUpClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuickBlockSetUpSkipped extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnQuickBlockSetUpSkipped f104520a = new OnQuickBlockSetUpSkipped();

        private OnQuickBlockSetUpSkipped() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnQuickBlockSetUpSkipped);
        }

        public int hashCode() {
            return 779714709;
        }

        public String toString() {
            return "OnQuickBlockSetUpSkipped";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSetUpSkipped extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSetUpSkipped f104521a = new OnSetUpSkipped();

        private OnSetUpSkipped() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSetUpSkipped);
        }

        public int hashCode() {
            return 1001290837;
        }

        public String toString() {
            return "OnSetUpSkipped";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStatsQuestion1Answer extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f104522a;

        public OnStatsQuestion1Answer(int i3) {
            super(null);
            this.f104522a = i3;
        }

        public final int a() {
            return this.f104522a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStatsQuestion1Answer) && this.f104522a == ((OnStatsQuestion1Answer) obj).f104522a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f104522a);
        }

        public String toString() {
            return "OnStatsQuestion1Answer(answer=" + this.f104522a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStatsQuestion2Answer extends OnboardingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f104523a;

        public OnStatsQuestion2Answer(int i3) {
            super(null);
            this.f104523a = i3;
        }

        public final int a() {
            return this.f104523a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStatsQuestion2Answer) && this.f104523a == ((OnStatsQuestion2Answer) obj).f104523a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f104523a);
        }

        public String toString() {
            return "OnStatsQuestion2Answer(answer=" + this.f104523a + ")";
        }
    }

    public /* synthetic */ OnboardingViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OnboardingViewEvent() {
    }
}
