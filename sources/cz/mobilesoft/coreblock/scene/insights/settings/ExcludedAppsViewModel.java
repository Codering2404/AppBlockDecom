package cz.mobilesoft.coreblock.scene.insights.settings;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ExcludedAppsViewModel extends BaseStatefulViewModel<ExcludedAppsViewState, ExcludedAppsViewEvent, ExcludedAppsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f103448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f103449p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$1", f = "ExcludedAppsViewModel.kt", l = {23}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103450a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02771<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ExcludedAppsViewModel f103452a;

            C02771(ExcludedAppsViewModel excludedAppsViewModel) {
                this.f103452a = excludedAppsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ExcludedAppsViewState f(PremiumState premiumState, ExcludedAppsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ExcludedAppsViewState.b(updateState, null, null, 0, premiumState.f(Product.STATISTICS), 7, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f103452a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExcludedAppsViewModel.AnonymousClass1.C02771.f(premiumState, (ExcludedAppsViewState) obj);
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
            return ExcludedAppsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103450a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = ExcludedAppsViewModel.this.W0().K();
                C02771 c02771 = new C02771(ExcludedAppsViewModel.this);
                this.f103450a = 1;
                if (stateFlowK.collect(c02771, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$2", f = "ExcludedAppsViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f103453a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ExcludedAppsViewModel f103455a;

            AnonymousClass1(ExcludedAppsViewModel excludedAppsViewModel) {
                this.f103455a = excludedAppsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ExcludedAppsViewState f(List list, List list2, ExcludedAppsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ExcludedAppsViewState.b(updateState, list, list2, 0, false, 12, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(List list, Continuation continuation) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (T t2 : list) {
                    if (((IgnoredStatisticsItem) t2).b() == IgnoredStatisticsItem.ItemSourceType.CUSTOM) {
                        arrayList.add(t2);
                    } else {
                        arrayList2.add(t2);
                    }
                }
                Pair pair = new Pair(arrayList, arrayList2);
                final List list2 = (List) pair.a();
                final List list3 = (List) pair.b();
                this.f103455a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExcludedAppsViewModel.AnonymousClass2.AnonymousClass1.f(list2, list3, (ExcludedAppsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ExcludedAppsViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f103453a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowS = ExcludedAppsViewModel.this.V0().S(true);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ExcludedAppsViewModel.this);
                this.f103453a = 1;
                if (flowS.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExcludedAppsViewModel(Application application) {
        super(application, new ExcludedAppsViewState(null, null, 0, false, 15, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f103448o = LazyKt.a(lazyThreadSafetyModeB, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f103449p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.ExcludedAppsViewModel$special$$inlined$inject$default$2
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
        G0(new AnonymousClass1(null));
        G0(new AnonymousClass2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao V0() {
        return (IgnoredStatisticsItemDao) this.f103448o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 W0() {
        return (PremiumRepositoryV2) this.f103449p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExcludedAppsViewState Y0(ExcludedAppsViewEvent excludedAppsViewEvent, ExcludedAppsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ExcludedAppsViewState.b(updateState, null, null, ((ExcludedAppsViewEvent.OnTabSelected) excludedAppsViewEvent).a(), false, 11, null);
    }

    private final void Z0(IgnoredStatisticsItem ignoredStatisticsItem) {
        G0(new ExcludedAppsViewModel$removeItemFromIgnored$1(this, ignoredStatisticsItem, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public void O0(final ExcludedAppsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ExcludedAppsViewEvent.OnTabSelected) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.settings.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExcludedAppsViewModel.Y0(event, (ExcludedAppsViewState) obj);
                }
            });
        } else {
            if (!(event instanceof ExcludedAppsViewEvent.OnRemoveClicked)) {
                throw new NoWhenBranchMatchedException();
            }
            Z0(((ExcludedAppsViewEvent.OnRemoveClicked) event).a());
        }
    }
}
