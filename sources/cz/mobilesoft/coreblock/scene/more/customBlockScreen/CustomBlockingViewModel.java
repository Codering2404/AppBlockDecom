package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.StateFlow;
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
public final class CustomBlockingViewModel extends BaseStatefulViewModel<CustomBlockingViewState, CustomBlockingViewEvent, CustomBlockingViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f107075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f107076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f107077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f107078r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$1", f = "CustomBlockingViewModel.kt", l = {25}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107079a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02821<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomBlockingViewModel f107081a;

            C02821(CustomBlockingViewModel customBlockingViewModel) {
                this.f107081a = customBlockingViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CustomBlockingViewState f(List list, CustomBlockingViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return CustomBlockingViewState.b(updateState, null, CollectionsKt.plus((Collection<? extends CustomBlockingScreenConfigEntity>) list, new CustomBlockingScreenConfigEntity(null, ConfigType.ADD, null, false, 0, false, 0, null, null, null, null, 2045, null)), null, false, false, 29, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final List list, Continuation continuation) {
                this.f107081a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomBlockingViewModel.AnonymousClass1.C02821.f(list, (CustomBlockingViewState) obj);
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
            return CustomBlockingViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107079a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = CustomBlockingViewModel.this.Z0().J();
                C02821 c02821 = new C02821(CustomBlockingViewModel.this);
                this.f107079a = 1;
                if (flowJ.collect(c02821, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$2", f = "CustomBlockingViewModel.kt", l = {35}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107082a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomBlockingViewModel f107084a;

            AnonymousClass1(CustomBlockingViewModel customBlockingViewModel) {
                this.f107084a = customBlockingViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CustomBlockingViewState f(String str, CustomBlockingViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return CustomBlockingViewState.b(updateState, null, null, str, false, false, 27, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final String str, Continuation continuation) {
                this.f107084a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.s0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomBlockingViewModel.AnonymousClass2.AnonymousClass1.f(str, (CustomBlockingViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CustomBlockingViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107082a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowN0 = CustomBlockingViewModel.this.Y0().n0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(CustomBlockingViewModel.this);
                this.f107082a = 1;
                if (flowN0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$3", f = "CustomBlockingViewModel.kt", l = {45}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107085a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomBlockingViewModel f107087a;

            AnonymousClass1(CustomBlockingViewModel customBlockingViewModel) {
                this.f107087a = customBlockingViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CustomBlockingViewState f(PremiumState premiumState, CustomBlockingViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return CustomBlockingViewState.b(updateState, null, null, null, premiumState.g(), false, 23, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f107087a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.t0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomBlockingViewModel.AnonymousClass3.AnonymousClass1.f(premiumState, (CustomBlockingViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CustomBlockingViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107085a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = CustomBlockingViewModel.this.a1().K();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(CustomBlockingViewModel.this);
                this.f107085a = 1;
                if (stateFlowK.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$4", f = "CustomBlockingViewModel.kt", l = {55}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107088a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomBlockingViewModel f107090a;

            AnonymousClass1(CustomBlockingViewModel customBlockingViewModel) {
                this.f107090a = customBlockingViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final CustomBlockingViewState f(boolean z2, CustomBlockingViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return CustomBlockingViewState.b(updateState, null, null, null, false, z2, 15, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f107090a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.u0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomBlockingViewModel.AnonymousClass4.AnonymousClass1.f(z2, (CustomBlockingViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CustomBlockingViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107088a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowP = CustomBlockingViewModel.this.t0().p();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(CustomBlockingViewModel.this);
                this.f107088a = 1;
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomBlockingViewModel(Application app) {
        super(app, new CustomBlockingViewState(null, null, null, false, false, 31, null));
        Intrinsics.checkNotNullParameter(app, "app");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f107075o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CustomBlockingScreenConfigDao>() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CustomBlockingScreenConfigDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f107076p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f107077q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f107078r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr6, objArr7);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass4(null), 3, null);
    }

    public static final /* synthetic */ CustomBlockingViewState R0(CustomBlockingViewModel customBlockingViewModel) {
        return (CustomBlockingViewState) customBlockingViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore Y0() {
        return (CoreMultiProcessDataStore) this.f107076p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomBlockingScreenConfigDao Z0() {
        return (CustomBlockingScreenConfigDao) this.f107075o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 a1() {
        return (PremiumRepositoryV2) this.f107078r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f107077q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void O0(CustomBlockingViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof CustomBlockingViewEvent.OnConfigSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new CustomBlockingViewModel$onEvent$1(this, event, null), 3, null);
            return;
        }
        if (event instanceof CustomBlockingViewEvent.OnConfigDeleted) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new CustomBlockingViewModel$onEvent$2(this, event, null), 3, null);
        } else if (event instanceof CustomBlockingViewEvent.OnConfigUpdated) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new CustomBlockingViewModel$onEvent$3(this, event, null), 3, null);
        } else {
            if (!(event instanceof CustomBlockingViewEvent.OnEmojiUpdated)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new CustomBlockingViewModel$onEvent$4(this, event, null), 3, null);
        }
    }
}
