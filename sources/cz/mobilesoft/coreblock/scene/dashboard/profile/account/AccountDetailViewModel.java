package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState;
import cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase;
import cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import java.io.File;
import java.io.IOException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import org.threeten.bp.LocalDateTime;

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
public final class AccountDetailViewModel extends BaseStatefulViewModel<AccountDetailViewState, AccountDetailViewEvent, AccountDetailViewCommand> implements KoinComponent {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f101121o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f101122p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f101123q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Uri f101124r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f101125s;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$1", f = "AccountDetailViewModel.kt", l = {42}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101126a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02751<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AccountDetailViewModel f101128a;

            C02751(AccountDetailViewModel accountDetailViewModel) {
                this.f101128a = accountDetailViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AccountDetailViewState f(SessionManager.SignInState signInState, AccountDetailViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                SessionManager.SignedIn signedIn = (SessionManager.SignedIn) signInState;
                return AccountDetailViewState.b(updateState, signedIn.e(), SessionManager.f127910a.p(signedIn), null, false, false, new AccountDetailViewState.ProfileImageState.Server(signedIn.f()), 28, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final SessionManager.SignInState signInState, Continuation continuation) {
                if (!(signInState instanceof SessionManager.SignedIn)) {
                    Object objP0 = this.f101128a.P0(AccountDetailViewCommand.OnSignedOut.f101113a, continuation);
                    return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
                }
                this.f101128a.f101125s = SessionManager.f127910a.p((SessionManager.SignedIn) signInState);
                this.f101128a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailViewModel.AnonymousClass1.C02751.f(signInState, (AccountDetailViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AccountDetailViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f101126a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowL = SessionManager.f127910a.l();
                C02751 c02751 = new C02751(AccountDetailViewModel.this);
                this.f101126a = 1;
                if (stateFlowL.collect(c02751, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$2", f = "AccountDetailViewModel.kt", l = {59}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101129a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AccountDetailViewModel f101131a;

            AnonymousClass1(AccountDetailViewModel accountDetailViewModel) {
                this.f101131a = accountDetailViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AccountDetailViewState f(boolean z2, AccountDetailViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return AccountDetailViewState.b(updateState, null, null, null, z2, false, null, 55, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f101131a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailViewModel.AnonymousClass2.AnonymousClass1.f(z2, (AccountDetailViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AccountDetailViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f101129a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowP = AccountDetailViewModel.this.t0().p();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(AccountDetailViewModel.this);
                this.f101129a = 1;
                if (stateFlowP.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AccountDetailViewModel(Application application) {
        super(application, new AccountDetailViewState(null, null, null, false, false, null, 63, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f101121o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f101122p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<UpdateUserDetailUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UpdateUserDetailUseCase.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f101123q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<UpdateUserPhotoUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UpdateUserPhotoUseCase.class), objArr4, objArr5);
            }
        });
        G0(new AnonymousClass1(null));
        G0(new AnonymousClass2(null));
    }

    public static final /* synthetic */ AccountDetailViewState V0(AccountDetailViewModel accountDetailViewModel) {
        return (AccountDetailViewState) accountDetailViewModel.I0();
    }

    private final Uri e1(Context context) throws IOException {
        LocalDateTime localDateTimeS = LocalDateTime.S();
        Intrinsics.checkNotNullExpressionValue(localDateTimeS, "now(...)");
        Uri uriH = FileProvider.h(context, context.getPackageName() + ".FileProvider", File.createTempFile("avatar_tmp_" + DateHelperExtKt.c(localDateTimeS, "ddMMyyyy_HHmmss"), ".png", context.getExternalCacheDir()));
        Intrinsics.checkNotNullExpressionValue(uriH, "getUriForFile(...)");
        return uriH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateUserDetailUseCase f1() {
        return (UpdateUserDetailUseCase) this.f101122p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateUserPhotoUseCase g1() {
        return (UpdateUserPhotoUseCase) this.f101123q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountDetailViewState k1(AccountDetailViewEvent accountDetailViewEvent, AccountDetailViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return AccountDetailViewState.b(updateState, null, ((AccountDetailViewEvent.UpdateUserNickname) accountDetailViewEvent).a(), null, false, false, null, 61, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountDetailViewState l1(AccountDetailViewEvent accountDetailViewEvent, AccountDetailViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        AccountDetailViewEvent.UpdateProfilePicture updateProfilePicture = (AccountDetailViewEvent.UpdateProfilePicture) accountDetailViewEvent;
        return AccountDetailViewState.b(updateState, null, null, null, false, false, updateProfilePicture.a() == null ? AccountDetailViewState.ProfileImageState.Deleted.f101170a : new AccountDetailViewState.ProfileImageState.Local(updateProfilePicture.a()), 31, null);
    }

    private final void m1(boolean z2) {
        if (!z2) {
            G0(new AccountDetailViewModel$signOut$3(this, null));
        } else {
            if (((AccountDetailViewState) I0()).g()) {
                return;
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccountDetailViewModel.o1((AccountDetailViewState) obj);
                }
            });
            H0(new AccountDetailViewModel$signOut$2(this, null));
        }
    }

    static /* synthetic */ void n1(AccountDetailViewModel accountDetailViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        accountDetailViewModel.m1(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountDetailViewState o1(AccountDetailViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return AccountDetailViewState.b(updateState, null, null, null, false, true, null, 47, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p1(final boolean z2, Continuation continuation) throws Throwable {
        Object objZ = SessionManager.f127910a.z(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.b0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AccountDetailViewModel.q1(this.f101183a, z2, ((Boolean) obj).booleanValue(), (String) obj2);
            }
        }, z2, continuation);
        return objZ == IntrinsicsKt.f() ? objZ : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(AccountDetailViewModel accountDetailViewModel, boolean z2, boolean z3, String str) {
        accountDetailViewModel.G0(new AccountDetailViewModel$signOutInternal$2$1(z3, accountDetailViewModel, z2, str, null));
        return Unit.f139807a;
    }

    private final void r1() {
        G0(new AccountDetailViewModel$updateUserDetails$1(this, null));
    }

    private final void s1() {
        AccountDetailViewState accountDetailViewState = (AccountDetailViewState) I0();
        if (accountDetailViewState.e() instanceof AccountDetailViewState.ProfileImageState.Server) {
            r1();
        } else {
            G0(new AccountDetailViewModel$updateUserProfilePicture$1(accountDetailViewState, this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f101121o.getValue();
    }

    public final Uri h1() {
        return this.f101124r;
    }

    public final Uri i1(Context context) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uriE1 = e1(context);
        this.f101124r = uriE1;
        return uriE1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void O0(final AccountDetailViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof AccountDetailViewEvent.UpdateUserNickname) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccountDetailViewModel.k1(event, (AccountDetailViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, AccountDetailViewEvent.SignOut.f101117a)) {
            n1(this, false, 1, null);
            return;
        }
        if (Intrinsics.areEqual(event, AccountDetailViewEvent.DeleteAccount.f101116a)) {
            m1(true);
        } else if (event instanceof AccountDetailViewEvent.UpdateProfilePicture) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.d0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccountDetailViewModel.l1(event, (AccountDetailViewState) obj);
                }
            });
        } else {
            if (!Intrinsics.areEqual(event, AccountDetailViewEvent.UpdateUserProfile.f101120a)) {
                throw new NoWhenBranchMatchedException();
            }
            s1();
        }
    }
}
