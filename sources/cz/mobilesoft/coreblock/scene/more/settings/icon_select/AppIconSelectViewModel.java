package cz.mobilesoft.coreblock.scene.more.settings.icon_select;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.AppIcon;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.usecase.UpdateIconUseCase;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
public final class AppIconSelectViewModel extends BaseStatefulViewModel<AppIconSelectViewState, AppIconSelectViewEvent, AppIconSelectViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f109903o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f109904p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f109905q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel$1", f = "AppIconSelectViewModel.kt", l = {26}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109906a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AppIconSelectViewState q(AppIcon appIcon, AppIconSelectViewModel appIconSelectViewModel, AppIconSelectViewState appIconSelectViewState) {
            return AppIconSelectViewState.b(appIconSelectViewState, appIcon, null, appIconSelectViewModel.Z0().J().g(), 2, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AppIconSelectViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109906a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowP2 = AppIconSelectViewModel.this.Y0().p2();
                this.f109906a = 1;
                obj = FlowKt.D(flowP2, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final AppIcon appIcon = (AppIcon) obj;
            final AppIconSelectViewModel appIconSelectViewModel = AppIconSelectViewModel.this;
            appIconSelectViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AppIconSelectViewModel.AnonymousClass1.q(appIcon, appIconSelectViewModel, (AppIconSelectViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppIconSelectViewModel(Application application) {
        super(application, new AppIconSelectViewState(null, null, false, 7, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109903o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f109904p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<UpdateIconUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UpdateIconUseCase.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f109905q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr4, objArr5);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X0(Continuation continuation) throws Throwable {
        AppIconSelectViewState appIconSelectViewState = (AppIconSelectViewState) I0();
        if (appIconSelectViewState.e() == null) {
            return Unit.f139807a;
        }
        AnswersHelper.f128199a.n0("AppIcon-no" + appIconSelectViewState.e().getId());
        Object objB = a1().b(new UpdateIconUseCase.Params(appIconSelectViewState.e()), continuation);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore Y0() {
        return (CoreDataStore) this.f109903o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 Z0() {
        return (PremiumRepositoryV2) this.f109905q.getValue();
    }

    private final UpdateIconUseCase a1() {
        return (UpdateIconUseCase) this.f109904p.getValue();
    }

    private final void c1(final AppIcon appIcon) {
        if (appIcon.isPremium() && !((AppIconSelectViewState) I0()).d()) {
            G0(new AppIconSelectViewModel$updateIcon$3(this, null));
        } else {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AppIconSelectViewModel.d1(appIcon, (AppIconSelectViewState) obj);
                }
            });
            G0(new AppIconSelectViewModel$updateIcon$2(this, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIconSelectViewState d1(AppIcon appIcon, AppIconSelectViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return AppIconSelectViewState.b(updateState, null, appIcon, false, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void O0(AppIconSelectViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof AppIconSelectViewEvent.OnIconSelected) {
            c1(((AppIconSelectViewEvent.OnIconSelected) event).a());
        } else {
            if (!Intrinsics.areEqual(event, AppIconSelectViewEvent.OnRestartConfirmed.f109902a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new AppIconSelectViewModel$onEvent$1(this, null));
        }
    }
}
