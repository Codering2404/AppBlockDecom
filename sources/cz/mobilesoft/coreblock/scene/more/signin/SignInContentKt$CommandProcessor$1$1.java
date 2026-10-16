package cz.mobilesoft.coreblock.scene.more.signin;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import com.applovin.sdk.AppLovinEventTypes;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewCommand;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt$CommandProcessor$1$1", f = "SignInContent.kt", l = {}, m = "invokeSuspend", v = 1)
final class SignInContentKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<SignInViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f110382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavHostController f110383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SignInViewState f110384d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f110385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f110386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function1 f110387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f110388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ MutableState f110389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MutableState f110390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableState f110391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Function0 f110392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f110393n;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt$CommandProcessor$1$1$1", f = "SignInContent.kt", l = {230}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f110395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SignInViewCommand f110396c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, SignInViewCommand signInViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f110395b = scaffoldState;
            this.f110396c = signInViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f110395b, this.f110396c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110394a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f110395b.b();
                String strA = ((SignInViewCommand.ShowSnackBar) this.f110396c).a();
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f110394a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, snackbarDuration, this, 2, null) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignInContentKt$CommandProcessor$1$1(NavHostController navHostController, SignInViewState signInViewState, ManagedActivityResultLauncher managedActivityResultLauncher, Context context, Function1 function1, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Function0 function0, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f110383c = navHostController;
        this.f110384d = signInViewState;
        this.f110385f = managedActivityResultLauncher;
        this.f110386g = context;
        this.f110387h = function1;
        this.f110388i = coroutineScope;
        this.f110389j = mutableState;
        this.f110390k = mutableState2;
        this.f110391l = mutableState3;
        this.f110392m = function0;
        this.f110393n = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SignInContentKt$CommandProcessor$1$1 signInContentKt$CommandProcessor$1$1 = new SignInContentKt$CommandProcessor$1$1(this.f110383c, this.f110384d, this.f110385f, this.f110386g, this.f110387h, this.f110388i, this.f110389j, this.f110390k, this.f110391l, this.f110392m, this.f110393n, continuation);
        signInContentKt$CommandProcessor$1$1.f110382b = obj;
        return signInContentKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SignInViewCommand signInViewCommand, Continuation continuation) {
        return ((SignInContentKt$CommandProcessor$1$1) create(signInViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SignInViewCommand signInViewCommand = (SignInViewCommand) this.f110382b;
        IntrinsicsKt.f();
        if (this.f110381a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (Intrinsics.areEqual(signInViewCommand, SignInViewCommand.LaunchEmailSignIn.f110408a)) {
            NavController.P(this.f110383c, NavItem.SignInUpWithEmail.getRoute(), null, null, 6, null);
        } else if (signInViewCommand instanceof SignInViewCommand.OnFinish) {
            AnswersHelper.f128199a.J6(this.f110384d.g());
            if (((SignInViewCommand.OnFinish) signInViewCommand).a()) {
                this.f110385f.b(EmailCommunicationConsentActivity.f101711g.a(this.f110386g, AppLovinEventTypes.USER_LOGGED_IN));
            } else if (this.f110384d.p()) {
                NavController.P(this.f110383c, NavItem.RestorePurchase.getRoute(), null, null, 6, null);
            } else {
                this.f110387h.invoke(Boxing.a(true));
            }
        } else if (signInViewCommand instanceof SignInViewCommand.ShowSnackBar) {
            BuildersKt__Builders_commonKt.d(this.f110388i, null, null, new AnonymousClass1(this.f110393n, signInViewCommand, null), 3, null);
        } else if (signInViewCommand instanceof SignInViewCommand.OnSignInSuccess) {
            if (((SignInViewCommand.OnSignInSuccess) signInViewCommand).a() != null) {
                NavController.P(this.f110383c, NavItem.SignInWelcome.getRoute(), null, null, 6, null);
            } else {
                NavController.P(this.f110383c, NavItem.NickName.getRoute(), null, null, 6, null);
            }
        } else if (signInViewCommand instanceof SignInViewCommand.OnStartLesson) {
            Activity activityB = ContextExtKt.b(this.f110386g);
            if (activityB != null) {
                activityB.finish();
            }
            this.f110386g.startActivity(AcademyLessonActivity.f106211v.a(this.f110386g, ((SignInViewCommand.OnStartLesson) signInViewCommand).a()));
        } else if (signInViewCommand instanceof SignInViewCommand.ShowInfoDialog) {
            SignInViewCommand.ShowInfoDialog showInfoDialog = (SignInViewCommand.ShowInfoDialog) signInViewCommand;
            this.f110389j.setValue(TuplesKt.a(showInfoDialog.b(), showInfoDialog.a()));
            if (showInfoDialog.c()) {
                this.f110390k.setValue(Boxing.a(true));
            } else {
                this.f110391l.setValue(Boxing.a(true));
            }
        } else if (Intrinsics.areEqual(signInViewCommand, SignInViewCommand.ShowWelcomeScreen.f110416a)) {
            NavController.P(this.f110383c, NavItem.SignInWelcome.getRoute(), null, null, 6, null);
        } else if (Intrinsics.areEqual(signInViewCommand, SignInViewCommand.LaunchAppleSignIn.f110407a)) {
            MutableState mutableState = this.f110389j;
            String string = this.f110386g.getString(R.string.tf);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            mutableState.setValue(TuplesKt.a(string, this.f110386g.getString(R.string.D1)));
            this.f110391l.setValue(Boxing.a(true));
        } else {
            if (!Intrinsics.areEqual(signInViewCommand, SignInViewCommand.SkipOnboarding.f110417a)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f110392m.invoke();
        }
        return Unit.f139807a;
    }
}
