package cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.List;
import java.util.NoSuchElementException;
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
public final class ExcludedUnsupportedBrowsersViewModel extends BaseStatefulViewModel<ExcludedUnsupportedBrowsersViewState, ExcludedUnsupportedBrowsersViewEvent, ExcludedUnsupportedBrowsersViewCommand> implements KoinComponent {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f109647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f109648p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1", f = "ExcludedUnsupportedBrowsersViewModel.kt", l = {40}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109649a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02891<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ExcludedUnsupportedBrowsersViewModel f109651a;

            C02891(ExcludedUnsupportedBrowsersViewModel excludedUnsupportedBrowsersViewModel) {
                this.f109651a = excludedUnsupportedBrowsersViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ExcludedUnsupportedBrowsersViewState f(List list, ExcludedUnsupportedBrowsersViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a(list);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.util.Set r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r6
                    cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1$1$emit$1) r0
                    int r1 = r0.f109655d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f109655d = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$1$1$emit$1
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.f109653b
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f109655d
                    r3 = 1
                    if (r2 == 0) goto L35
                    if (r2 != r3) goto L2d
                    java.lang.Object r5 = r0.f109652a
                    java.util.Set r5 = (java.util.Set) r5
                    kotlin.ResultKt.b(r6)
                    goto L50
                L2d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L35:
                    kotlin.ResultKt.b(r6)
                    cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel r6 = r4.f109651a
                    cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r6 = cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel.T0(r6)
                    r2 = r5
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
                    r0.f109652a = r5
                    r0.f109655d = r3
                    java.lang.Object r6 = r6.a0(r2, r0)
                    if (r6 != r1) goto L50
                    return r1
                L50:
                    java.util.List r6 = (java.util.List) r6
                    cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel r5 = r4.f109651a
                    cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.m r0 = new cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.m
                    r0.<init>()
                    cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel.V0(r5, r0)
                    kotlin.Unit r5 = kotlin.Unit.f139807a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel.AnonymousClass1.C02891.emit(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ExcludedUnsupportedBrowsersViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109649a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE0 = ExcludedUnsupportedBrowsersViewModel.this.X0().e0();
                C02891 c02891 = new C02891(ExcludedUnsupportedBrowsersViewModel.this);
                this.f109649a = 1;
                if (flowE0.collect(c02891, this) == objF) {
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
    /* JADX WARN: Multi-variable type inference failed */
    public ExcludedUnsupportedBrowsersViewModel(Application application) {
        super(application, new ExcludedUnsupportedBrowsersViewState(null, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109647o = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f109648p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewModel$special$$inlined$inject$default$2
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
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    public static final /* synthetic */ ExcludedUnsupportedBrowsersViewState S0(ExcludedUnsupportedBrowsersViewModel excludedUnsupportedBrowsersViewModel) {
        return (ExcludedUnsupportedBrowsersViewState) excludedUnsupportedBrowsersViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao W0() {
        return (ApplicationDao) this.f109647o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore X0() {
        return (CoreMultiProcessDataStore) this.f109648p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExcludedUnsupportedBrowsersViewState Z0(ExcludedUnsupportedBrowsersViewEvent excludedUnsupportedBrowsersViewEvent, ExcludedUnsupportedBrowsersViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List listB = updateState.b();
        for (Object obj : updateState.b()) {
            if (Intrinsics.areEqual(((cz.mobilesoft.coreblock.storage.room.entity.blocking.Application) obj).d(), ((ExcludedUnsupportedBrowsersViewEvent.RemoveUnsupportedBrowser) excludedUnsupportedBrowsersViewEvent).a())) {
                return updateState.a(CollectionsKt.minus(listB, obj));
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void O0(final ExcludedUnsupportedBrowsersViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof ExcludedUnsupportedBrowsersViewEvent.RemoveUnsupportedBrowser)) {
            throw new NoWhenBranchMatchedException();
        }
        AnswersHelper.f128199a.L1(((ExcludedUnsupportedBrowsersViewEvent.RemoveUnsupportedBrowser) event).a());
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExcludedUnsupportedBrowsersViewModel.Z0(event, (ExcludedUnsupportedBrowsersViewState) obj);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ExcludedUnsupportedBrowsersViewModel$onEvent$2(this, null), 3, null);
    }
}
