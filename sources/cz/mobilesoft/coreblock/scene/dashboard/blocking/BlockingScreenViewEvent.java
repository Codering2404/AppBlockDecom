package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
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
public abstract class BlockingScreenViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAnnouncementCardRemoved extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final QuestionnaireConfig f99544a;

        public OnAnnouncementCardRemoved(QuestionnaireConfig questionnaireConfig) {
            super(null);
            this.f99544a = questionnaireConfig;
        }

        public final QuestionnaireConfig a() {
            return this.f99544a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAnnouncementCardRemoved) && Intrinsics.areEqual(this.f99544a, ((OnAnnouncementCardRemoved) obj).f99544a);
        }

        public int hashCode() {
            QuestionnaireConfig questionnaireConfig = this.f99544a;
            if (questionnaireConfig == null) {
                return 0;
            }
            return questionnaireConfig.hashCode();
        }

        public String toString() {
            return "OnAnnouncementCardRemoved(questionnaireConfig=" + this.f99544a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAutoTrialCardClosed extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAutoTrialCardClosed f99545a = new OnAutoTrialCardClosed();

        private OnAutoTrialCardClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAutoTrialCardClosed);
        }

        public int hashCode() {
            return 1303739608;
        }

        public String toString() {
            return "OnAutoTrialCardClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAutoTrialExpiredCardClosed extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAutoTrialExpiredCardClosed f99546a = new OnAutoTrialExpiredCardClosed();

        private OnAutoTrialExpiredCardClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAutoTrialExpiredCardClosed);
        }

        public int hashCode() {
            return -4974107;
        }

        public String toString() {
            return "OnAutoTrialExpiredCardClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNewProfileCreated extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f99547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f99548b;

        public OnNewProfileCreated(int i3, boolean z2) {
            super(null);
            this.f99547a = i3;
            this.f99548b = z2;
        }

        public final int a() {
            return this.f99547a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnNewProfileCreated)) {
                return false;
            }
            OnNewProfileCreated onNewProfileCreated = (OnNewProfileCreated) obj;
            return this.f99547a == onNewProfileCreated.f99547a && this.f99548b == onNewProfileCreated.f99548b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f99547a) * 31) + Boolean.hashCode(this.f99548b);
        }

        public String toString() {
            return "OnNewProfileCreated(profileTypeCombinations=" + this.f99547a + ", addProfileToFollowSchedules=" + this.f99548b + ")";
        }

        public /* synthetic */ OnNewProfileCreated(int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i4 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumExpiringCardClosed extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPremiumExpiringCardClosed f99549a = new OnPremiumExpiringCardClosed();

        private OnPremiumExpiringCardClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPremiumExpiringCardClosed);
        }

        public int hashCode() {
            return 298601732;
        }

        public String toString() {
            return "OnPremiumExpiringCardClosed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfileItemEvent extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileItemEvent f99550a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfileItemEvent(ProfileItemEvent profileItemEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(profileItemEvent, "profileItemEvent");
            this.f99550a = profileItemEvent;
        }

        public final ProfileItemEvent a() {
            return this.f99550a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnProfileItemEvent) && Intrinsics.areEqual(this.f99550a, ((OnProfileItemEvent) obj).f99550a);
        }

        public int hashCode() {
            return this.f99550a.hashCode();
        }

        public String toString() {
            return "OnProfileItemEvent(profileItemEvent=" + this.f99550a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuickBlockCustomTimeSet extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f99551a;

        public OnQuickBlockCustomTimeSet(long j3) {
            super(null);
            this.f99551a = j3;
        }

        public final long a() {
            return this.f99551a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnQuickBlockCustomTimeSet) && this.f99551a == ((OnQuickBlockCustomTimeSet) obj).f99551a;
        }

        public int hashCode() {
            return Long.hashCode(this.f99551a);
        }

        public String toString() {
            return "OnQuickBlockCustomTimeSet(time=" + this.f99551a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResumed extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResumed f99552a = new OnResumed();

        private OnResumed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnResumed);
        }

        public int hashCode() {
            return -1099597940;
        }

        public String toString() {
            return "OnResumed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakBannerClicked extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakBannerClicked f99553a = new OnStreakBannerClicked();

        private OnStreakBannerClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakBannerClicked);
        }

        public int hashCode() {
            return -1837085006;
        }

        public String toString() {
            return "OnStreakBannerClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakBannerDismissed extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakBannerDismissed f99554a = new OnStreakBannerDismissed();

        private OnStreakBannerDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakBannerDismissed);
        }

        public int hashCode() {
            return 1916898420;
        }

        public String toString() {
            return "OnStreakBannerDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTemplatesVisibilityChanged extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTemplatesVisibilityChanged f99555a = new OnTemplatesVisibilityChanged();

        private OnTemplatesVisibilityChanged() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnTemplatesVisibilityChanged);
        }

        public int hashCode() {
            return 771378484;
        }

        public String toString() {
            return "OnTemplatesVisibilityChanged";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTroubleshootingCardClicked extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTroubleshootingCardClicked f99556a = new OnTroubleshootingCardClicked();

        private OnTroubleshootingCardClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnTroubleshootingCardClicked);
        }

        public int hashCode() {
            return 1413704808;
        }

        public String toString() {
            return "OnTroubleshootingCardClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTroubleshootingCardClosed extends BlockingScreenViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTroubleshootingCardClosed f99557a = new OnTroubleshootingCardClosed();

        private OnTroubleshootingCardClosed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnTroubleshootingCardClosed);
        }

        public int hashCode() {
            return -1755318005;
        }

        public String toString() {
            return "OnTroubleshootingCardClosed";
        }
    }

    public /* synthetic */ BlockingScreenViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BlockingScreenViewEvent() {
    }
}
