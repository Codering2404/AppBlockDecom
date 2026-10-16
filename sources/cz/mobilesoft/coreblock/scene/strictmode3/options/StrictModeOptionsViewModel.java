package cz.mobilesoft.coreblock.scene.strictmode3.options;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import java.util.List;
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
import kotlinx.collections.immutable.ExtensionsKt;
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
public final class StrictModeOptionsViewModel extends BaseStatefulViewModel<StrictModeOptionsViewState, StrictModeOptionsViewEvent, StrictModeOptionsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f122300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f122301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f122302q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f122303r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f122304s;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$1", f = "StrictModeOptionsViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f122305a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictModeOptionsViewState q(List list, StrictModeOptionsViewState strictModeOptionsViewState) {
            List list2 = list;
            return strictModeOptionsViewState.a(ExtensionsKt.h(list2), ExtensionsKt.h(list2));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return StrictModeOptionsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f122305a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM0 = StrictModeOptionsViewModel.this.g1().m0();
                this.f122305a = 1;
                obj = FlowKt.D(flowM0, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            final List list = (List) obj;
            StrictModeOptionsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StrictModeOptionsViewModel.AnonymousClass1.q(list, (StrictModeOptionsViewState) obj2);
                }
            });
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
        public static final /* synthetic */ int[] f122307a;

        static {
            int[] iArr = new int[StrictModeOption.values().length];
            try {
                iArr[StrictModeOption.BlockUninstalling.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f122307a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrictModeOptionsViewModel(Application application) {
        super(application, new StrictModeOptionsViewState(null, null, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122300o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f122301p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f122302q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GetMissingPermissionsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetMissingPermissionsUseCase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f122303r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f122304s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr8, objArr9);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    public static final /* synthetic */ StrictModeOptionsViewState S0(StrictModeOptionsViewModel strictModeOptionsViewModel) {
        return (StrictModeOptionsViewState) strictModeOptionsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(StrictModeOption strictModeOption) {
        if (WhenMappings.f122307a[strictModeOption.ordinal()] == 1) {
            DeviceAdminHelper.i(A0());
        }
        k1(strictModeOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
    
        if (P0(r2, r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c1(cz.mobilesoft.coreblock.enums.StrictModeOption r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$enableOption$1
            if (r0 == 0) goto L13
            r0 = r14
            cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$enableOption$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$enableOption$1) r0
            int r1 = r0.f122312f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f122312f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$enableOption$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$enableOption$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.f122310c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f122312f
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L45
            if (r2 == r3) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r13 = r0.f122309b
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r13 = r0.f122308a
            cz.mobilesoft.coreblock.enums.StrictModeOption r13 = (cz.mobilesoft.coreblock.enums.StrictModeOption) r13
            kotlin.ResultKt.b(r14)
            goto Lb2
        L35:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3d:
            java.lang.Object r13 = r0.f122308a
            cz.mobilesoft.coreblock.enums.StrictModeOption r13 = (cz.mobilesoft.coreblock.enums.StrictModeOption) r13
            kotlin.ResultKt.b(r14)
            goto L61
        L45:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase r14 = r12.e1()
            cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase$Params r2 = new cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase$Params
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r13)
            r6 = 0
            r2.<init>(r5, r6, r4, r6)
            r0.f122308a = r13
            r0.f122312f = r3
            java.lang.Object r14 = r14.b(r2, r0)
            if (r14 != r1) goto L61
            goto Lb1
        L61:
            java.util.List r14 = (java.util.List) r14
            r2 = r14
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lb5
            r2 = r14
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r3.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L7e:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L98
            java.lang.Object r5 = r2.next()
            r7 = r5
            cz.mobilesoft.coreblock.enums.Permission r7 = (cz.mobilesoft.coreblock.enums.Permission) r7
            cz.mobilesoft.coreblock.util.permissions.PermissionDTO r6 = new cz.mobilesoft.coreblock.util.permissions.PermissionDTO
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            r6.<init>(r7, r8, r9, r10, r11)
            r3.add(r6)
            goto L7e
        L98:
            cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewCommand$ShowPermissionActivity r2 = new cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewCommand$ShowPermissionActivity
            r2.<init>(r3, r13)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r0.f122308a = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r0.f122309b = r13
            r0.f122312f = r4
            java.lang.Object r13 = r12.P0(r2, r0)
            if (r13 != r1) goto Lb2
        Lb1:
            return r1
        Lb2:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        Lb5:
            r12.k1(r13)
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel.c1(cz.mobilesoft.coreblock.enums.StrictModeOption, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore d1() {
        return (EventDataStore) this.f122304s.getValue();
    }

    private final GetMissingPermissionsUseCase e1() {
        return (GetMissingPermissionsUseCase) this.f122302q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao f1() {
        return (ProfileDao) this.f122303r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore g1() {
        return (StrictModeDataStore) this.f122300o.getValue();
    }

    private final void i1(StrictModeOption strictModeOption) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictModeOptionsViewModel$onOptionClicked$1(this, strictModeOption, null), 3, null);
    }

    private final void j1() {
        H0(new StrictModeOptionsViewModel$onSaveClicked$1(this, null));
    }

    private final void k1(final StrictModeOption strictModeOption) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictModeOptionsViewModel.l1(strictModeOption, (StrictModeOptionsViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeOptionsViewState l1(StrictModeOption strictModeOption, StrictModeOptionsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeOptionsViewState.b(updateState, ExtensionsKt.h(strictModeOption.addOrRemoveIn(updateState.d())), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f122301p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void O0(StrictModeOptionsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StrictModeOptionsViewEvent.OnOptionClicked) {
            i1(((StrictModeOptionsViewEvent.OnOptionClicked) event).a());
        } else if (event instanceof StrictModeOptionsViewEvent.OnMissingPermissionsGranted) {
            k1(((StrictModeOptionsViewEvent.OnMissingPermissionsGranted) event).a());
        } else {
            if (!Intrinsics.areEqual(event, StrictModeOptionsViewEvent.OnSaveClicked.f122299a)) {
                throw new NoWhenBranchMatchedException();
            }
            j1();
        }
    }
}
