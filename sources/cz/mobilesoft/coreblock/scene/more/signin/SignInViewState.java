package cz.mobilesoft.coreblock.scene.more.signin;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class SignInViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SignInEntryPoint f110573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f110574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f110575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f110576d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f110577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ViewModelState f110578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewModelState f110579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f110580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f110581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final EmailSignScreen f110582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f110583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ForgotPasswordScreenType f110584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f110585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f110586o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f110587p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f110588q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f110589r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f110590s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f110591t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f110592u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f110593v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f110594w;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EmailSignScreen {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EmailSignScreen[] $VALUES;
        public static final EmailSignScreen SIGN_IN = new EmailSignScreen("SIGN_IN", 0);
        public static final EmailSignScreen SIGN_UP = new EmailSignScreen("SIGN_UP", 1);

        private static final /* synthetic */ EmailSignScreen[] $values() {
            return new EmailSignScreen[]{SIGN_IN, SIGN_UP};
        }

        static {
            EmailSignScreen[] emailSignScreenArr$values = $values();
            $VALUES = emailSignScreenArr$values;
            $ENTRIES = EnumEntriesKt.a(emailSignScreenArr$values);
        }

        private EmailSignScreen(String str, int i3) {
        }

        public static EnumEntries<EmailSignScreen> getEntries() {
            return $ENTRIES;
        }

        public static EmailSignScreen valueOf(String str) {
            return (EmailSignScreen) Enum.valueOf(EmailSignScreen.class, str);
        }

        public static EmailSignScreen[] values() {
            return (EmailSignScreen[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ForgotPasswordScreenType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ForgotPasswordScreenType[] $VALUES;
        public static final ForgotPasswordScreenType EMAIL = new ForgotPasswordScreenType("EMAIL", 0);
        public static final ForgotPasswordScreenType VERIFICATION = new ForgotPasswordScreenType("VERIFICATION", 1);
        public static final ForgotPasswordScreenType CREATE_NEW_PASSWORD = new ForgotPasswordScreenType("CREATE_NEW_PASSWORD", 2);

        private static final /* synthetic */ ForgotPasswordScreenType[] $values() {
            return new ForgotPasswordScreenType[]{EMAIL, VERIFICATION, CREATE_NEW_PASSWORD};
        }

        static {
            ForgotPasswordScreenType[] forgotPasswordScreenTypeArr$values = $values();
            $VALUES = forgotPasswordScreenTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(forgotPasswordScreenTypeArr$values);
        }

        private ForgotPasswordScreenType(String str, int i3) {
        }

        public static EnumEntries<ForgotPasswordScreenType> getEntries() {
            return $ENTRIES;
        }

        public static ForgotPasswordScreenType valueOf(String str) {
            return (ForgotPasswordScreenType) Enum.valueOf(ForgotPasswordScreenType.class, str);
        }

        public static ForgotPasswordScreenType[] values() {
            return (ForgotPasswordScreenType[]) $VALUES.clone();
        }
    }

    public SignInViewState(SignInEntryPoint entryPoint, Long l3, String email, String password, String verificationCode, ViewModelState signInState, ViewModelState syncState, boolean z2, boolean z3, EmailSignScreen emailSignInScreen, String nickName, ForgotPasswordScreenType forgotPasswordScreenType, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(verificationCode, "verificationCode");
        Intrinsics.checkNotNullParameter(signInState, "signInState");
        Intrinsics.checkNotNullParameter(syncState, "syncState");
        Intrinsics.checkNotNullParameter(emailSignInScreen, "emailSignInScreen");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(forgotPasswordScreenType, "forgotPasswordScreenType");
        this.f110573a = entryPoint;
        this.f110574b = l3;
        this.f110575c = email;
        this.f110576d = password;
        this.f110577f = verificationCode;
        this.f110578g = signInState;
        this.f110579h = syncState;
        this.f110580i = z2;
        this.f110581j = z3;
        this.f110582k = emailSignInScreen;
        this.f110583l = nickName;
        this.f110584m = forgotPasswordScreenType;
        this.f110585n = z4;
        this.f110586o = z5;
        this.f110587p = z6;
        this.f110588q = z7;
        this.f110589r = z8;
        this.f110590s = z9;
        this.f110591t = z10;
        this.f110592u = z11;
        this.f110593v = z12;
        this.f110594w = str;
    }

    public static /* synthetic */ SignInViewState b(SignInViewState signInViewState, SignInEntryPoint signInEntryPoint, Long l3, String str, String str2, String str3, ViewModelState viewModelState, ViewModelState viewModelState2, boolean z2, boolean z3, EmailSignScreen emailSignScreen, String str4, ForgotPasswordScreenType forgotPasswordScreenType, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str5, int i3, Object obj) {
        String str6;
        boolean z13;
        SignInEntryPoint signInEntryPoint2 = (i3 & 1) != 0 ? signInViewState.f110573a : signInEntryPoint;
        Long l4 = (i3 & 2) != 0 ? signInViewState.f110574b : l3;
        String str7 = (i3 & 4) != 0 ? signInViewState.f110575c : str;
        String str8 = (i3 & 8) != 0 ? signInViewState.f110576d : str2;
        String str9 = (i3 & 16) != 0 ? signInViewState.f110577f : str3;
        ViewModelState viewModelState3 = (i3 & 32) != 0 ? signInViewState.f110578g : viewModelState;
        ViewModelState viewModelState4 = (i3 & 64) != 0 ? signInViewState.f110579h : viewModelState2;
        boolean z14 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? signInViewState.f110580i : z2;
        boolean z15 = (i3 & Function.MAX_NARGS) != 0 ? signInViewState.f110581j : z3;
        EmailSignScreen emailSignScreen2 = (i3 & 512) != 0 ? signInViewState.f110582k : emailSignScreen;
        String str10 = (i3 & 1024) != 0 ? signInViewState.f110583l : str4;
        ForgotPasswordScreenType forgotPasswordScreenType2 = (i3 & 2048) != 0 ? signInViewState.f110584m : forgotPasswordScreenType;
        boolean z16 = (i3 & 4096) != 0 ? signInViewState.f110585n : z4;
        boolean z17 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? signInViewState.f110586o : z5;
        SignInEntryPoint signInEntryPoint3 = signInEntryPoint2;
        boolean z18 = (i3 & 16384) != 0 ? signInViewState.f110587p : z6;
        boolean z19 = (i3 & 32768) != 0 ? signInViewState.f110588q : z7;
        boolean z20 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? signInViewState.f110589r : z8;
        boolean z21 = (i3 & 131072) != 0 ? signInViewState.f110590s : z9;
        boolean z22 = (i3 & 262144) != 0 ? signInViewState.f110591t : z10;
        boolean z23 = (i3 & 524288) != 0 ? signInViewState.f110592u : z11;
        boolean z24 = (i3 & 1048576) != 0 ? signInViewState.f110593v : z12;
        if ((i3 & 2097152) != 0) {
            z13 = z24;
            str6 = signInViewState.f110594w;
        } else {
            str6 = str5;
            z13 = z24;
        }
        return signInViewState.a(signInEntryPoint3, l4, str7, str8, str9, viewModelState3, viewModelState4, z14, z15, emailSignScreen2, str10, forgotPasswordScreenType2, z16, z17, z18, z19, z20, z21, z22, z23, z13, str6);
    }

    public final SignInViewState a(SignInEntryPoint entryPoint, Long l3, String email, String password, String verificationCode, ViewModelState signInState, ViewModelState syncState, boolean z2, boolean z3, EmailSignScreen emailSignInScreen, String nickName, ForgotPasswordScreenType forgotPasswordScreenType, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(verificationCode, "verificationCode");
        Intrinsics.checkNotNullParameter(signInState, "signInState");
        Intrinsics.checkNotNullParameter(syncState, "syncState");
        Intrinsics.checkNotNullParameter(emailSignInScreen, "emailSignInScreen");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(forgotPasswordScreenType, "forgotPasswordScreenType");
        return new SignInViewState(entryPoint, l3, email, password, verificationCode, signInState, syncState, z2, z3, emailSignInScreen, nickName, forgotPasswordScreenType, z4, z5, z6, z7, z8, z9, z10, z11, z12, str);
    }

    public final boolean c() {
        return this.f110585n;
    }

    public final String d() {
        return this.f110575c;
    }

    public final EmailSignScreen e() {
        return this.f110582k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInViewState)) {
            return false;
        }
        SignInViewState signInViewState = (SignInViewState) obj;
        return this.f110573a == signInViewState.f110573a && Intrinsics.areEqual(this.f110574b, signInViewState.f110574b) && Intrinsics.areEqual(this.f110575c, signInViewState.f110575c) && Intrinsics.areEqual(this.f110576d, signInViewState.f110576d) && Intrinsics.areEqual(this.f110577f, signInViewState.f110577f) && Intrinsics.areEqual(this.f110578g, signInViewState.f110578g) && Intrinsics.areEqual(this.f110579h, signInViewState.f110579h) && this.f110580i == signInViewState.f110580i && this.f110581j == signInViewState.f110581j && this.f110582k == signInViewState.f110582k && Intrinsics.areEqual(this.f110583l, signInViewState.f110583l) && this.f110584m == signInViewState.f110584m && this.f110585n == signInViewState.f110585n && this.f110586o == signInViewState.f110586o && this.f110587p == signInViewState.f110587p && this.f110588q == signInViewState.f110588q && this.f110589r == signInViewState.f110589r && this.f110590s == signInViewState.f110590s && this.f110591t == signInViewState.f110591t && this.f110592u == signInViewState.f110592u && this.f110593v == signInViewState.f110593v && Intrinsics.areEqual(this.f110594w, signInViewState.f110594w);
    }

    public final boolean f() {
        return this.f110580i;
    }

    public final SignInEntryPoint g() {
        return this.f110573a;
    }

    public final String h() {
        return this.f110594w;
    }

    public int hashCode() {
        int iHashCode = this.f110573a.hashCode() * 31;
        Long l3 = this.f110574b;
        int iHashCode2 = (((((((((((((((((((((((((((((((((((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + this.f110575c.hashCode()) * 31) + this.f110576d.hashCode()) * 31) + this.f110577f.hashCode()) * 31) + this.f110578g.hashCode()) * 31) + this.f110579h.hashCode()) * 31) + Boolean.hashCode(this.f110580i)) * 31) + Boolean.hashCode(this.f110581j)) * 31) + this.f110582k.hashCode()) * 31) + this.f110583l.hashCode()) * 31) + this.f110584m.hashCode()) * 31) + Boolean.hashCode(this.f110585n)) * 31) + Boolean.hashCode(this.f110586o)) * 31) + Boolean.hashCode(this.f110587p)) * 31) + Boolean.hashCode(this.f110588q)) * 31) + Boolean.hashCode(this.f110589r)) * 31) + Boolean.hashCode(this.f110590s)) * 31) + Boolean.hashCode(this.f110591t)) * 31) + Boolean.hashCode(this.f110592u)) * 31) + Boolean.hashCode(this.f110593v)) * 31;
        String str = this.f110594w;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final ForgotPasswordScreenType i() {
        return this.f110584m;
    }

    public final boolean j() {
        return this.f110592u;
    }

    public final Long k() {
        return this.f110574b;
    }

    public final String l() {
        return this.f110583l;
    }

    public final String m() {
        return this.f110576d;
    }

    public final boolean n() {
        return this.f110581j;
    }

    public final boolean o() {
        return this.f110590s;
    }

    public final boolean p() {
        return this.f110589r;
    }

    public final boolean q() {
        return this.f110586o;
    }

    public final boolean r() {
        return this.f110587p;
    }

    public final ViewModelState s() {
        return this.f110578g;
    }

    public final boolean t() {
        return this.f110591t;
    }

    public String toString() {
        return "SignInViewState(entryPoint=" + this.f110573a + ", lessonId=" + this.f110574b + ", email=" + this.f110575c + ", password=" + this.f110576d + ", verificationCode=" + this.f110577f + ", signInState=" + this.f110578g + ", syncState=" + this.f110579h + ", emailValidationError=" + this.f110580i + ", passwordValidationError=" + this.f110581j + ", emailSignInScreen=" + this.f110582k + ", nickName=" + this.f110583l + ", forgotPasswordScreenType=" + this.f110584m + ", continueWithoutAccount=" + this.f110585n + ", showCloseButton=" + this.f110586o + ", showScreenProgressBar=" + this.f110587p + ", isAlreadyAMember=" + this.f110588q + ", shouldRestorePurchase=" + this.f110589r + ", requiredSignIn=" + this.f110590s + ", signUpAfterPurchase=" + this.f110591t + ", googleSignInEnabled=" + this.f110592u + ", isOnboarding=" + this.f110593v + ", finishRegistrationEmail=" + this.f110594w + ")";
    }

    public final String u() {
        return this.f110577f;
    }

    public final boolean v() {
        return this.f110588q;
    }

    public final boolean w() {
        return this.f110593v;
    }

    public final boolean x() {
        return this.f110575c.length() > 0 && this.f110576d.length() > 0 && !this.f110580i && !this.f110581j;
    }

    public /* synthetic */ SignInViewState(SignInEntryPoint signInEntryPoint, Long l3, String str, String str2, String str3, ViewModelState viewModelState, ViewModelState viewModelState2, boolean z2, boolean z3, EmailSignScreen emailSignScreen, String str4, ForgotPasswordScreenType forgotPasswordScreenType, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? SignInEntryPoint.UNKNOWN : signInEntryPoint, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? Success.f128020a : viewModelState, (i3 & 64) != 0 ? Success.f128020a : viewModelState2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2, (i3 & Function.MAX_NARGS) != 0 ? false : z3, (i3 & 512) != 0 ? EmailSignScreen.SIGN_UP : emailSignScreen, (i3 & 1024) == 0 ? str4 : "", (i3 & 2048) != 0 ? ForgotPasswordScreenType.EMAIL : forgotPasswordScreenType, (i3 & 4096) != 0 ? false : z4, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z5, (i3 & 16384) != 0 ? false : z6, z7, (65536 & i3) != 0 ? false : z8, (131072 & i3) != 0 ? false : z9, (262144 & i3) != 0 ? false : z10, (524288 & i3) != 0 ? true : z11, (1048576 & i3) != 0 ? false : z12, (i3 & 2097152) != 0 ? null : str5);
    }
}
