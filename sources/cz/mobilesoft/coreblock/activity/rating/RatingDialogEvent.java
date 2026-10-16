package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.base.ViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class RatingDialogEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCloseClicked extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCloseClicked f96069a = new OnCloseClicked();

        private OnCloseClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCloseClicked);
        }

        public int hashCode() {
            return 1185433764;
        }

        public String toString() {
            return "OnCloseClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDialogReady extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDialogReady f96070a = new OnDialogReady();

        private OnDialogReady() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDialogReady);
        }

        public int hashCode() {
            return 757878022;
        }

        public String toString() {
            return "OnDialogReady";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissRequested extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissRequested f96071a = new OnDismissRequested();

        private OnDismissRequested() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismissRequested);
        }

        public int hashCode() {
            return 82678553;
        }

        public String toString() {
            return "OnDismissRequested";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFeedbackDismissed extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnFeedbackDismissed f96072a = new OnFeedbackDismissed();

        private OnFeedbackDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnFeedbackDismissed);
        }

        public int hashCode() {
            return -1656443345;
        }

        public String toString() {
            return "OnFeedbackDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFeedbackSendClicked extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnFeedbackSendClicked f96073a = new OnFeedbackSendClicked();

        private OnFeedbackSendClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnFeedbackSendClicked);
        }

        public int hashCode() {
            return -735744123;
        }

        public String toString() {
            return "OnFeedbackSendClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLoveItClicked extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLoveItClicked f96074a = new OnLoveItClicked();

        private OnLoveItClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLoveItClicked);
        }

        public int hashCode() {
            return -176477643;
        }

        public String toString() {
            return "OnLoveItClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPlayStoreButtonClicked extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPlayStoreButtonClicked f96075a = new OnPlayStoreButtonClicked();

        private OnPlayStoreButtonClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPlayStoreButtonClicked);
        }

        public int hashCode() {
            return -1083530531;
        }

        public String toString() {
            return "OnPlayStoreButtonClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPlayStoreDialogDismissed extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPlayStoreDialogDismissed f96076a = new OnPlayStoreDialogDismissed();

        private OnPlayStoreDialogDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPlayStoreDialogDismissed);
        }

        public int hashCode() {
            return -1947196279;
        }

        public String toString() {
            return "OnPlayStoreDialogDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPlayStoreDialogReady extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPlayStoreDialogReady f96077a = new OnPlayStoreDialogReady();

        private OnPlayStoreDialogReady() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPlayStoreDialogReady);
        }

        public int hashCode() {
            return -1945130621;
        }

        public String toString() {
            return "OnPlayStoreDialogReady";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRateNoClicked extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRateNoClicked f96078a = new OnRateNoClicked();

        private OnRateNoClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRateNoClicked);
        }

        public int hashCode() {
            return -721605839;
        }

        public String toString() {
            return "OnRateNoClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewFlowFinished extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f96079a;

        public OnReviewFlowFinished(boolean z2) {
            super(null);
            this.f96079a = z2;
        }

        public final boolean a() {
            return this.f96079a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReviewFlowFinished) && this.f96079a == ((OnReviewFlowFinished) obj).f96079a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f96079a);
        }

        public String toString() {
            return "OnReviewFlowFinished(isSuccessful=" + this.f96079a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewPreparationCancelled extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnReviewPreparationCancelled f96080a = new OnReviewPreparationCancelled();

        private OnReviewPreparationCancelled() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnReviewPreparationCancelled);
        }

        public int hashCode() {
            return 587196615;
        }

        public String toString() {
            return "OnReviewPreparationCancelled";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewPreparationFailed extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnReviewPreparationFailed f96081a = new OnReviewPreparationFailed();

        private OnReviewPreparationFailed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnReviewPreparationFailed);
        }

        public int hashCode() {
            return 1647704199;
        }

        public String toString() {
            return "OnReviewPreparationFailed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReviewPreparationFinished extends RatingDialogEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f96082a;

        public OnReviewPreparationFinished(boolean z2) {
            super(null);
            this.f96082a = z2;
        }

        public final boolean a() {
            return this.f96082a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReviewPreparationFinished) && this.f96082a == ((OnReviewPreparationFinished) obj).f96082a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f96082a);
        }

        public String toString() {
            return "OnReviewPreparationFinished(isReviewInfoAvailable=" + this.f96082a + ")";
        }
    }

    public /* synthetic */ RatingDialogEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RatingDialogEvent() {
    }
}
