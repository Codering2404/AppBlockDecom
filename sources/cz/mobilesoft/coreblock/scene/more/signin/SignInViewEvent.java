package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
import com.facebook.login.LoginResult;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class SignInViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ClearEmailAndPassword extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f110418a;

        public ClearEmailAndPassword(boolean z2) {
            super(null);
            this.f110418a = z2;
        }

        public final boolean a() {
            return this.f110418a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClearEmailAndPassword) && this.f110418a == ((ClearEmailAndPassword) obj).f110418a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f110418a);
        }

        public String toString() {
            return "ClearEmailAndPassword(shouldResetEmailScreen=" + this.f110418a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAlreadyHaveAccountClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAlreadyHaveAccountClicked f110419a = new OnAlreadyHaveAccountClicked();

        private OnAlreadyHaveAccountClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAlreadyHaveAccountClicked);
        }

        public int hashCode() {
            return -1345869728;
        }

        public String toString() {
            return "OnAlreadyHaveAccountClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAppleSignInResult extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110420a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAppleSignInResult(String authorizationCode) {
            super(null);
            Intrinsics.checkNotNullParameter(authorizationCode, "authorizationCode");
            this.f110420a = authorizationCode;
        }

        public final String a() {
            return this.f110420a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAppleSignInResult) && Intrinsics.areEqual(this.f110420a, ((OnAppleSignInResult) obj).f110420a);
        }

        public int hashCode() {
            return this.f110420a.hashCode();
        }

        public String toString() {
            return "OnAppleSignInResult(authorizationCode=" + this.f110420a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCreatePasswordClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCreatePasswordClicked f110421a = new OnCreatePasswordClicked();

        private OnCreatePasswordClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnCreatePasswordClicked);
        }

        public int hashCode() {
            return -1383152490;
        }

        public String toString() {
            return "OnCreatePasswordClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailChanged extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmailChanged(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f110422a = email;
        }

        public final String a() {
            return this.f110422a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmailChanged) && Intrinsics.areEqual(this.f110422a, ((OnEmailChanged) obj).f110422a);
        }

        public int hashCode() {
            return this.f110422a.hashCode();
        }

        public String toString() {
            return "OnEmailChanged(email=" + this.f110422a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFacebookSignInCancel extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnFacebookSignInCancel f110423a = new OnFacebookSignInCancel();

        private OnFacebookSignInCancel() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnFacebookSignInCancel);
        }

        public int hashCode() {
            return -1022879268;
        }

        public String toString() {
            return "OnFacebookSignInCancel";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFacebookSignInError extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Exception f110424a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFacebookSignInError(Exception error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f110424a = error;
        }

        public final Exception a() {
            return this.f110424a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnFacebookSignInError) && Intrinsics.areEqual(this.f110424a, ((OnFacebookSignInError) obj).f110424a);
        }

        public int hashCode() {
            return this.f110424a.hashCode();
        }

        public String toString() {
            return "OnFacebookSignInError(error=" + this.f110424a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFacebookSignInResult extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoginResult f110425a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFacebookSignInResult(LoginResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.f110425a = result;
        }

        public final LoginResult a() {
            return this.f110425a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnFacebookSignInResult) && Intrinsics.areEqual(this.f110425a, ((OnFacebookSignInResult) obj).f110425a);
        }

        public int hashCode() {
            return this.f110425a.hashCode();
        }

        public String toString() {
            return "OnFacebookSignInResult(result=" + this.f110425a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNickNameContinueClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnNickNameContinueClicked f110426a = new OnNickNameContinueClicked();

        private OnNickNameContinueClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnNickNameContinueClicked);
        }

        public int hashCode() {
            return 47147448;
        }

        public String toString() {
            return "OnNickNameContinueClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnNicknameChanged extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110427a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnNicknameChanged(String nickname) {
            super(null);
            Intrinsics.checkNotNullParameter(nickname, "nickname");
            this.f110427a = nickname;
        }

        public final String a() {
            return this.f110427a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnNicknameChanged) && Intrinsics.areEqual(this.f110427a, ((OnNicknameChanged) obj).f110427a);
        }

        public int hashCode() {
            return this.f110427a.hashCode();
        }

        public String toString() {
            return "OnNicknameChanged(nickname=" + this.f110427a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPasswordChanged extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110428a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPasswordChanged(String password) {
            super(null);
            Intrinsics.checkNotNullParameter(password, "password");
            this.f110428a = password;
        }

        public final String a() {
            return this.f110428a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPasswordChanged) && Intrinsics.areEqual(this.f110428a, ((OnPasswordChanged) obj).f110428a);
        }

        public int hashCode() {
            return this.f110428a.hashCode();
        }

        public String toString() {
            return "OnPasswordChanged(password=" + this.f110428a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignInClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSignInClicked f110429a = new OnSignInClicked();

        private OnSignInClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSignInClicked);
        }

        public int hashCode() {
            return 1450299435;
        }

        public String toString() {
            return "OnSignInClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignInMethodClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SignInMethod f110430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f110431b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSignInMethodClicked(SignInMethod method, Context context) {
            super(null);
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(context, "context");
            this.f110430a = method;
            this.f110431b = context;
        }

        public final Context a() {
            return this.f110431b;
        }

        public final SignInMethod b() {
            return this.f110430a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSignInMethodClicked)) {
                return false;
            }
            OnSignInMethodClicked onSignInMethodClicked = (OnSignInMethodClicked) obj;
            return this.f110430a == onSignInMethodClicked.f110430a && Intrinsics.areEqual(this.f110431b, onSignInMethodClicked.f110431b);
        }

        public int hashCode() {
            return (this.f110430a.hashCode() * 31) + this.f110431b.hashCode();
        }

        public String toString() {
            return "OnSignInMethodClicked(method=" + this.f110430a + ", context=" + this.f110431b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignInWelcomeContinueClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f110432a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSignInWelcomeContinueClicked(Context context) {
            super(null);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f110432a = context;
        }

        public final Context a() {
            return this.f110432a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSignInWelcomeContinueClicked) && Intrinsics.areEqual(this.f110432a, ((OnSignInWelcomeContinueClicked) obj).f110432a);
        }

        public int hashCode() {
            return this.f110432a.hashCode();
        }

        public String toString() {
            return "OnSignInWelcomeContinueClicked(context=" + this.f110432a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignInWelcomeSkipClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSignInWelcomeSkipClicked f110433a = new OnSignInWelcomeSkipClicked();

        private OnSignInWelcomeSkipClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSignInWelcomeSkipClicked);
        }

        public int hashCode() {
            return -1832208798;
        }

        public String toString() {
            return "OnSignInWelcomeSkipClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSignUpClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSignUpClicked f110434a = new OnSignUpClicked();

        private OnSignUpClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSignUpClicked);
        }

        public int hashCode() {
            return 426335733;
        }

        public String toString() {
            return "OnSignUpClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSubmitEmailClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSubmitEmailClicked f110435a = new OnSubmitEmailClicked();

        private OnSubmitEmailClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSubmitEmailClicked);
        }

        public int hashCode() {
            return 186579645;
        }

        public String toString() {
            return "OnSubmitEmailClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnVerificationCodeChanged extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f110436a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnVerificationCodeChanged(String code) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            this.f110436a = code;
        }

        public final String a() {
            return this.f110436a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnVerificationCodeChanged) && Intrinsics.areEqual(this.f110436a, ((OnVerificationCodeChanged) obj).f110436a);
        }

        public int hashCode() {
            return this.f110436a.hashCode();
        }

        public String toString() {
            return "OnVerificationCodeChanged(code=" + this.f110436a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnVerifyCodeClicked extends SignInViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnVerifyCodeClicked f110437a = new OnVerifyCodeClicked();

        private OnVerifyCodeClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnVerifyCodeClicked);
        }

        public int hashCode() {
            return -211378585;
        }

        public String toString() {
            return "OnVerifyCodeClicked";
        }
    }

    public /* synthetic */ SignInViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SignInViewEvent() {
    }
}
