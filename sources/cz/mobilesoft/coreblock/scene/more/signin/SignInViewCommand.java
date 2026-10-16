package cz.mobilesoft.coreblock.scene.more.signin;

import cz.mobilesoft.coreblock.base.ViewCommand;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class SignInViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchAppleSignIn extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LaunchAppleSignIn f110407a = new LaunchAppleSignIn();

        private LaunchAppleSignIn() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LaunchAppleSignIn);
        }

        public int hashCode() {
            return 1913720511;
        }

        public String toString() {
            return "LaunchAppleSignIn";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchEmailSignIn extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LaunchEmailSignIn f110408a = new LaunchEmailSignIn();

        private LaunchEmailSignIn() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LaunchEmailSignIn);
        }

        public int hashCode() {
            return 1936530817;
        }

        public String toString() {
            return "LaunchEmailSignIn";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFinish extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f110409a;

        public OnFinish(boolean z2) {
            super(null);
            this.f110409a = z2;
        }

        public final boolean a() {
            return this.f110409a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnFinish) && this.f110409a == ((OnFinish) obj).f110409a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f110409a);
        }

        public String toString() {
            return "OnFinish(showConsent=" + this.f110409a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignInSuccess extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110410a;

        public OnSignInSuccess(String str) {
            super(null);
            this.f110410a = str;
        }

        public final String a() {
            return this.f110410a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSignInSuccess) && Intrinsics.areEqual(this.f110410a, ((OnSignInSuccess) obj).f110410a);
        }

        public int hashCode() {
            String str = this.f110410a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "OnSignInSuccess(nickname=" + this.f110410a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStartLesson extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f110411a;

        public OnStartLesson(long j3) {
            super(null);
            this.f110411a = j3;
        }

        public final long a() {
            return this.f110411a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStartLesson) && this.f110411a == ((OnStartLesson) obj).f110411a;
        }

        public int hashCode() {
            return Long.hashCode(this.f110411a);
        }

        public String toString() {
            return "OnStartLesson(lessonId=" + this.f110411a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowInfoDialog extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f110413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f110414c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInfoDialog(String title, String message, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            this.f110412a = title;
            this.f110413b = message;
            this.f110414c = z2;
        }

        public final String a() {
            return this.f110413b;
        }

        public final String b() {
            return this.f110412a;
        }

        public final boolean c() {
            return this.f110414c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowInfoDialog)) {
                return false;
            }
            ShowInfoDialog showInfoDialog = (ShowInfoDialog) obj;
            return Intrinsics.areEqual(this.f110412a, showInfoDialog.f110412a) && Intrinsics.areEqual(this.f110413b, showInfoDialog.f110413b) && this.f110414c == showInfoDialog.f110414c;
        }

        public int hashCode() {
            return (((this.f110412a.hashCode() * 31) + this.f110413b.hashCode()) * 31) + Boolean.hashCode(this.f110414c);
        }

        public String toString() {
            return "ShowInfoDialog(title=" + this.f110412a + ", message=" + this.f110413b + ", isConfirmDialog=" + this.f110414c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackBar extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110415a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSnackBar(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f110415a = message;
        }

        public final String a() {
            return this.f110415a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackBar) && Intrinsics.areEqual(this.f110415a, ((ShowSnackBar) obj).f110415a);
        }

        public int hashCode() {
            return this.f110415a.hashCode();
        }

        public String toString() {
            return "ShowSnackBar(message=" + this.f110415a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowWelcomeScreen extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowWelcomeScreen f110416a = new ShowWelcomeScreen();

        private ShowWelcomeScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowWelcomeScreen);
        }

        public int hashCode() {
            return -803346649;
        }

        public String toString() {
            return "ShowWelcomeScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SkipOnboarding extends SignInViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SkipOnboarding f110417a = new SkipOnboarding();

        private SkipOnboarding() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SkipOnboarding);
        }

        public int hashCode() {
            return 364820484;
        }

        public String toString() {
            return "SkipOnboarding";
        }
    }

    public /* synthetic */ SignInViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SignInViewCommand() {
    }
}
