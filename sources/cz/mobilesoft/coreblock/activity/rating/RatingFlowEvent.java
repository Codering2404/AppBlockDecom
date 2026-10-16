package cz.mobilesoft.coreblock.activity.rating;

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
public abstract class RatingFlowEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RatingFlowPhase f96124a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCloseClicked(RatingFlowPhase phase) {
            super(null);
            Intrinsics.checkNotNullParameter(phase, "phase");
            this.f96124a = phase;
        }

        public final RatingFlowPhase a() {
            return this.f96124a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCloseClicked) && this.f96124a == ((OnCloseClicked) obj).f96124a;
        }

        public int hashCode() {
            return this.f96124a.hashCode();
        }

        public String toString() {
            return "OnCloseClicked(phase=" + this.f96124a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissRequested extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissRequested f96125a = new OnDismissRequested();

        private OnDismissRequested() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissRequested);
        }

        public int hashCode() {
            return -1963332737;
        }

        public String toString() {
            return "OnDismissRequested";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFeedbackDismissed extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnFeedbackDismissed f96126a = new OnFeedbackDismissed();

        private OnFeedbackDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnFeedbackDismissed);
        }

        public int hashCode() {
            return -658283895;
        }

        public String toString() {
            return "OnFeedbackDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFeedbackSendClicked extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnFeedbackSendClicked f96127a = new OnFeedbackSendClicked();

        private OnFeedbackSendClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnFeedbackSendClicked);
        }

        public int hashCode() {
            return 717780319;
        }

        public String toString() {
            return "OnFeedbackSendClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLoveItClicked extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLoveItClicked f96128a = new OnLoveItClicked();

        private OnLoveItClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLoveItClicked);
        }

        public int hashCode() {
            return -1394205809;
        }

        public String toString() {
            return "OnLoveItClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRateNoClicked extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRateNoClicked f96129a = new OnRateNoClicked();

        private OnRateNoClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRateNoClicked);
        }

        public int hashCode() {
            return -1939334005;
        }

        public String toString() {
            return "OnRateNoClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewFlowFinished extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f96130a;

        public OnReviewFlowFinished(boolean z2) {
            super(null);
            this.f96130a = z2;
        }

        public final boolean a() {
            return this.f96130a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReviewFlowFinished) && this.f96130a == ((OnReviewFlowFinished) obj).f96130a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f96130a);
        }

        public String toString() {
            return "OnReviewFlowFinished(isSuccessful=" + this.f96130a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewPreparationCancelled extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnReviewPreparationCancelled f96131a = new OnReviewPreparationCancelled();

        private OnReviewPreparationCancelled() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnReviewPreparationCancelled);
        }

        public int hashCode() {
            return 2057140653;
        }

        public String toString() {
            return "OnReviewPreparationCancelled";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewPreparationFailed extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnReviewPreparationFailed f96132a = new OnReviewPreparationFailed();

        private OnReviewPreparationFailed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnReviewPreparationFailed);
        }

        public int hashCode() {
            return 30310753;
        }

        public String toString() {
            return "OnReviewPreparationFailed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewPreparationFinished extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f96133a;

        public OnReviewPreparationFinished(boolean z2) {
            super(null);
            this.f96133a = z2;
        }

        public final boolean a() {
            return this.f96133a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReviewPreparationFinished) && this.f96133a == ((OnReviewPreparationFinished) obj).f96133a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f96133a);
        }

        public String toString() {
            return "OnReviewPreparationFinished(isReviewInfoAvailable=" + this.f96133a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnScreenShown extends RatingFlowEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnScreenShown f96134a = new OnScreenShown();

        private OnScreenShown() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnScreenShown);
        }

        public int hashCode() {
            return -980677718;
        }

        public String toString() {
            return "OnScreenShown";
        }
    }

    public /* synthetic */ RatingFlowEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RatingFlowEvent() {
    }
}
