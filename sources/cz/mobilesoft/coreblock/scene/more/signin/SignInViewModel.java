package cz.mobilesoft.coreblock.scene.more.signin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Patterns;
import com.facebook.AccessToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.rest.response.ErrorBody;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class SignInViewModel extends BaseStatefulViewModel<SignInViewState, SignInViewEvent, SignInViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f110438o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f110439p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f110440q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f110441r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$1", f = "SignInViewModel.kt", l = {86}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110442a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02921<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SignInViewModel f110444a;

            C02921(SignInViewModel signInViewModel) {
                this.f110444a = signInViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SignInViewState f(String str, SignInViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return SignInViewState.b(updateState, null, null, null, null, null, null, null, false, false, null, str, null, false, false, false, false, false, false, false, false, false, null, 4193279, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final String str, Continuation continuation) {
                this.f110444a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.f3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignInViewModel.AnonymousClass1.C02921.f(str, (SignInViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SignInViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110442a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowL = SignInViewModel.this.z1().L();
                C02921 c02921 = new C02921(SignInViewModel.this);
                this.f110442a = 1;
                if (flowL.collect(c02921, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110445a;

        static {
            int[] iArr = new int[SignInMethod.values().length];
            try {
                iArr[SignInMethod.Facebook.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignInMethod.Google.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SignInMethod.Email.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SignInMethod.Apple.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f110445a = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public SignInViewModel(Application application, SignInConfig signInConfig) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(signInConfig, "signInConfig");
        SignInEntryPoint signInEntryPointB = signInConfig.b();
        Long lD = signInConfig.d();
        String strC = signInConfig.c();
        String str = strC == null ? "" : strC;
        SignInViewState.EmailSignScreen emailSignScreen = (signInConfig.c() == null && !signInConfig.j()) ? SignInViewState.EmailSignScreen.SIGN_UP : SignInViewState.EmailSignScreen.SIGN_IN;
        super(application, new SignInViewState(signInEntryPointB, lD, str, null, null, null, null, false, false, emailSignScreen, null, null, signInConfig.a(), signInConfig.g(), signInConfig.h(), signInConfig.j(), signInConfig.f(), signInConfig.e(), signInConfig.i(), false, signInConfig.k(), signInConfig.c(), 527864, null));
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f110438o = LazyKt.a(lazyThreadSafetyModeB, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f110439p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f110440q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f110441r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr6, objArr7);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void A1(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.s2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.B1(str, (SignInViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState B1(String str, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, str, null, null, null, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194171, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState D1(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, Canceled.f127782a, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState E1(SignInViewEvent signInViewEvent, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, new FailedWithError(((SignInViewEvent.OnFacebookSignInError) signInViewEvent).a(), null, null, null, 14, null), null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState F1(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, null, null, false, false, SignInViewState.EmailSignScreen.SIGN_IN, null, null, false, false, false, false, false, false, false, false, false, null, 4193791, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState G1(SignInViewEvent signInViewEvent, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, null, null, false, false, null, ((SignInViewEvent.OnNicknameChanged) signInViewEvent).a(), null, false, false, false, false, false, false, false, false, false, null, 4193279, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState H1(SignInViewEvent signInViewEvent, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, ((SignInViewEvent.OnVerificationCodeChanged) signInViewEvent).a(), null, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194287, null);
    }

    private final void I1(LoginResult loginResult) {
        AccessToken accessToken = loginResult.getAccessToken();
        if (!accessToken.getDeclinedPermissions().contains(AuthenticationTokenClaims.JSON_KEY_EMAIL)) {
            Z1(AccessToken.DEFAULT_GRAPH_DOMAIN, accessToken.getToken());
            return;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.u2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.J1((SignInViewState) obj);
            }
        });
        U1();
        a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState J1(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, new FailedWithError(null, null, new ErrorBody(115, null, null, null, 14, null), null, 11, null), null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    private final void K1(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.d3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.L1(str, (SignInViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState L1(String str, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, str, null, null, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194039, null);
    }

    private final void M1(SignInMethod signInMethod, Context context) {
        AnswersHelper.f128199a.E6(signInMethod, ((SignInViewState) I0()).g().name());
        int i3 = WhenMappings.f110445a[signInMethod.ordinal()];
        if (i3 == 1) {
            W1(context);
            return;
        }
        if (i3 == 2) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.r2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel.N1((SignInViewState) obj);
                }
            });
            Y1(context);
        } else if (i3 == 3) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onSignInMethodClicked$2(this, null), 3, null);
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onSignInMethodClicked$3(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState N1(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, null, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 3670015, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(String str, SignInMethod signInMethod) {
        AnswersHelper.f128199a.F6(signInMethod, ((SignInViewState) I0()).g().name());
        PremiumRepositoryV2.b0(y1(), null, 1, null);
        if (str == null || str.length() == 0) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onSignInSuccess$2(this, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onSignInSuccess$1(this, str, null), 3, null);
        }
    }

    private final void P1(final Context context) {
        final SignInViewState signInViewState = (SignInViewState) I0();
        Long lK = ((SignInViewState) I0()).k();
        if (lK == null) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onSignedIn$2$1(this, signInViewState, null), 3, null);
        } else {
            final long jLongValue = lK.longValue();
            e2(jLongValue, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.e3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SignInViewModel.Q1(this.f110641a, context, jLongValue, signInViewState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(SignInViewModel signInViewModel, Context context, long j3, SignInViewState signInViewState) {
        if (signInViewModel.v1(context) == null || BuildersKt__Builders_commonKt.d(signInViewModel.C0(), null, null, new SignInViewModel$onSignedIn$1$1$1$1(signInViewModel, j3, null), 3, null) == null) {
            BuildersKt__Builders_commonKt.d(signInViewModel.C0(), null, null, new SignInViewModel$onSignedIn$1$1$2$1(signInViewModel, signInViewState, null), 3, null);
            Unit unit = Unit.f139807a;
        }
        return Unit.f139807a;
    }

    private final void R1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onSkipOnboarding$1(this, null), 3, null);
    }

    private final void S1() {
        SignInViewState signInViewState = (SignInViewState) I0();
        if (signInViewState.n()) {
            return;
        }
        H0(new SignInViewModel$resetPasswordAndSignIn$1(this, signInViewState, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object T1(cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$shouldShowConsent$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$shouldShowConsent$1 r0 = (cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$shouldShowConsent$1) r0
            int r1 = r0.f110488d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f110488d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$shouldShowConsent$1 r0 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$shouldShowConsent$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f110486b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f110488d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f110485a
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r6 = (cz.mobilesoft.coreblock.scene.more.signin.SignInViewState) r6
            kotlin.ResultKt.b(r7)
            return r7
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f110485a
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r6 = (cz.mobilesoft.coreblock.scene.more.signin.SignInViewState) r6
            kotlin.ResultKt.b(r7)
            goto L52
        L40:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r7 = r5.w1()
            r0.f110485a = r6
            r0.f110488d = r4
            java.lang.Object r7 = r7.f(r0)
            if (r7 != r1) goto L52
            goto L7c
        L52:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L60
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r6
        L60:
            boolean r7 = r6.w()
            if (r7 == 0) goto L7e
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r5.x1()
            kotlinx.coroutines.flow.Flow r7 = r7.k3()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f110485a = r6
            r0.f110488d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r6 != r1) goto L7d
        L7c:
            return r1
        L7d:
            return r6
        L7e:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.T1(cz.mobilesoft.coreblock.scene.more.signin.SignInViewState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1() {
        ViewModelState viewModelStateS = ((SignInViewState) I0()).s();
        if (viewModelStateS instanceof FailedWithError) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$showErrorDialog$1(this, viewModelStateS, null), 3, null);
        }
    }

    private final void V1() {
        SignInViewState signInViewState = (SignInViewState) I0();
        if (signInViewState.x()) {
            H0(new SignInViewModel$signIn$1(this, signInViewState, null));
        }
    }

    private final void W1(Context context) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.v2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.X1((SignInViewState) obj);
            }
        });
        LoginManager.Companion companion = LoginManager.Companion;
        companion.getInstance().logOut();
        Activity activityV1 = v1(context);
        if (activityV1 != null) {
            companion.getInstance().logInWithReadPermissions(activityV1, CollectionsKt.listOf((Object[]) new String[]{AuthenticationTokenClaims.JSON_KEY_EMAIL, "public_profile"}));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState X1(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, Loading.f127895a, null, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194271, null);
    }

    private final void Y1(Context context) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$signInGoogle$1(this, context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(String str, String str2) {
        H0(new SignInViewModel$signInSocial$1(this, str, str2, null));
    }

    private final void a2() {
        t1(false);
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null) {
            return;
        }
        new GraphRequest(currentAccessToken, "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest.Callback() { // from class: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$signOutFacebook$1
            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                LoginManager.Companion.getInstance().logOut();
            }
        }, null, 32, null).executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$signOutGoogle$1(this, null), 3, null);
    }

    private final void c2() {
        SignInViewState signInViewState = (SignInViewState) I0();
        if (signInViewState.x()) {
            H0(new SignInViewModel$signUp$1(this, signInViewState, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(long j3, Function0 function0) {
        H0(new SignInViewModel$startLesson$1(j3, function0, null));
    }

    private final void e2(long j3, Function0 function0) {
        H0(new SignInViewModel$startLessonIfAvailable$1(j3, this, function0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f2(boolean r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$1 r0 = (cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$1) r0
            int r1 = r0.f110557d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f110557d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$1 r0 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f110555b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f110557d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L69
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            boolean r6 = r0.f110554a
            kotlin.ResultKt.b(r7)
            goto L54
        L3a:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.signin.q2 r7 = new cz.mobilesoft.coreblock.scene.more.signin.q2
            r7.<init>()
            r5.Q0(r7)
            cz.mobilesoft.coreblock.storage.datastore.SessionDataStore r7 = r5.z1()
            r0.f110554a = r6
            r0.f110557d = r4
            java.lang.Object r7 = r7.j0(r6, r0)
            if (r7 != r1) goto L54
            goto L68
        L54:
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$3 r2 = new cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel$startSync$3
            r4 = 0
            r2.<init>(r5, r4)
            r0.f110554a = r6
            r0.f110557d = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)
            if (r6 != r1) goto L69
        L68:
            return r1
        L69:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInViewModel.f2(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState g2(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, null, Loading.f127895a, false, false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194239, null);
    }

    public static final /* synthetic */ SignInViewState h1(SignInViewModel signInViewModel) {
        return (SignInViewState) signInViewModel.I0();
    }

    private final void h2() {
        SignInViewState signInViewState = (SignInViewState) I0();
        AnswersHelper.f128199a.H6(signInViewState.g());
        if (signInViewState.f()) {
            return;
        }
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$submitEmail$1(this, signInViewState, null), 3, null);
    }

    private final void i2() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.c3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.j2(this.f110628a, (SignInViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState j2(SignInViewModel signInViewModel, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, null, null, !Patterns.EMAIL_ADDRESS.matcher(((SignInViewState) signInViewModel.I0()).d()).matches(), false, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194175, null);
    }

    private final void k2() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.t2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.l2((SignInViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState l2(SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, null, null, null, null, null, false, updateState.m().length() < 8, null, null, null, false, false, false, false, false, false, false, false, false, null, 4194047, null);
    }

    private final void m2() {
        SignInViewState signInViewState = (SignInViewState) I0();
        AnswersHelper.f128199a.G6(signInViewState.g());
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$verifyCode$1(this, signInViewState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(final boolean z2) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.w2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInViewModel.u1(z2, (SignInViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignInViewState u1(boolean z2, SignInViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SignInViewState.b(updateState, null, null, "", "", null, null, null, false, false, (!z2 || updateState.v()) ? updateState.e() : SignInViewState.EmailSignScreen.SIGN_UP, null, SignInViewState.ForgotPasswordScreenType.EMAIL, false, false, false, false, false, false, false, false, false, null, 4191347, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity v1(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        return v1(baseContext);
    }

    private final ConsentHelper w1() {
        return (ConsentHelper) this.f110440q.getValue();
    }

    private final CoreDataStore x1() {
        return (CoreDataStore) this.f110441r.getValue();
    }

    private final PremiumRepositoryV2 y1() {
        return (PremiumRepositoryV2) this.f110439p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore z1() {
        return (SessionDataStore) this.f110438o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void O0(final SignInViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SignInViewEvent.OnSignInMethodClicked) {
            SignInViewEvent.OnSignInMethodClicked onSignInMethodClicked = (SignInViewEvent.OnSignInMethodClicked) event;
            M1(onSignInMethodClicked.b(), onSignInMethodClicked.a());
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnFacebookSignInCancel.f110423a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.x2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel.D1((SignInViewState) obj);
                }
            });
            if (!NetworkHelperKt.c(A0())) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onEvent$2(this, null), 3, null);
            }
            a2();
            return;
        }
        if (event instanceof SignInViewEvent.OnFacebookSignInError) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.y2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel.E1(event, (SignInViewState) obj);
                }
            });
            SignInViewEvent.OnFacebookSignInError onFacebookSignInError = (SignInViewEvent.OnFacebookSignInError) event;
            CrashHelper.j(onFacebookSignInError.a());
            onFacebookSignInError.a().printStackTrace();
            U1();
            a2();
            return;
        }
        if (event instanceof SignInViewEvent.OnFacebookSignInResult) {
            I1(((SignInViewEvent.OnFacebookSignInResult) event).a());
            return;
        }
        if (event instanceof SignInViewEvent.OnEmailChanged) {
            A1(((SignInViewEvent.OnEmailChanged) event).a());
            return;
        }
        if (event instanceof SignInViewEvent.OnPasswordChanged) {
            K1(((SignInViewEvent.OnPasswordChanged) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnSignUpClicked.f110434a)) {
            i2();
            k2();
            c2();
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnAlreadyHaveAccountClicked.f110419a)) {
            t1(false);
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.z2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel.F1((SignInViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnSignInClicked.f110429a)) {
            i2();
            V1();
            return;
        }
        if (event instanceof SignInViewEvent.OnNicknameChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.a3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel.G1(event, (SignInViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnNickNameContinueClicked.f110426a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new SignInViewModel$onEvent$6(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnCreatePasswordClicked.f110421a)) {
            k2();
            S1();
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnSubmitEmailClicked.f110435a)) {
            i2();
            h2();
            return;
        }
        if (event instanceof SignInViewEvent.OnVerificationCodeChanged) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.b3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SignInViewModel.H1(event, (SignInViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, SignInViewEvent.OnVerifyCodeClicked.f110437a)) {
            m2();
            return;
        }
        if (event instanceof SignInViewEvent.OnSignInWelcomeContinueClicked) {
            P1(((SignInViewEvent.OnSignInWelcomeContinueClicked) event).a());
            return;
        }
        if (event instanceof SignInViewEvent.ClearEmailAndPassword) {
            t1(((SignInViewEvent.ClearEmailAndPassword) event).a());
        } else if (event instanceof SignInViewEvent.OnAppleSignInResult) {
            Z1("apple_authorization_code", ((SignInViewEvent.OnAppleSignInResult) event).a());
        } else {
            if (!(event instanceof SignInViewEvent.OnSignInWelcomeSkipClicked)) {
                throw new NoWhenBranchMatchedException();
            }
            R1();
        }
    }
}
