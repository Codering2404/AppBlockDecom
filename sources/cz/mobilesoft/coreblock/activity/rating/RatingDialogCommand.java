package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
public abstract class RatingDialogCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close extends RatingDialogCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f96063a;

        public Close(boolean z2) {
            super(null);
            this.f96063a = z2;
        }

        public final boolean a() {
            return this.f96063a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Close) && this.f96063a == ((Close) obj).f96063a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f96063a);
        }

        public String toString() {
            return "Close(wasOutsideNavigation=" + this.f96063a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishActivity extends RatingDialogCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FinishActivity f96064a = new FinishActivity();

        private FinishActivity() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof FinishActivity);
        }

        public int hashCode() {
            return 498152839;
        }

        public String toString() {
            return "FinishActivity";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchInAppReview extends RatingDialogCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LaunchInAppReview f96065a = new LaunchInAppReview();

        private LaunchInAppReview() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LaunchInAppReview);
        }

        public int hashCode() {
            return 753945756;
        }

        public String toString() {
            return "LaunchInAppReview";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenGooglePlayStore extends RatingDialogCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenGooglePlayStore f96066a = new OpenGooglePlayStore();

        private OpenGooglePlayStore() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenGooglePlayStore);
        }

        public int hashCode() {
            return -678518139;
        }

        public String toString() {
            return "OpenGooglePlayStore";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowFeedbackDialog extends RatingDialogCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowFeedbackDialog f96067a = new ShowFeedbackDialog();

        private ShowFeedbackDialog() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowFeedbackDialog);
        }

        public int hashCode() {
            return 39071695;
        }

        public String toString() {
            return "ShowFeedbackDialog";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StartSupportIntent extends RatingDialogCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StartSupportIntent f96068a = new StartSupportIntent();

        private StartSupportIntent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof StartSupportIntent);
        }

        public int hashCode() {
            return 1818300494;
        }

        public String toString() {
            return "StartSupportIntent";
        }
    }

    public /* synthetic */ RatingDialogCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RatingDialogCommand() {
    }
}
