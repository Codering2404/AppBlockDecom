package cz.mobilesoft.coreblock.scene.strictmode3.access;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.util.SessionManager;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
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
public final class StrictModeAccessViewModel extends BaseStatefulViewModel<StrictModeAccessViewState, StrictModeAccessViewEvent, StrictModeAccessViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f121533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f121534p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$1", f = "StrictModeAccessViewModel.kt", l = {24}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121535a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C03011<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ StrictModeAccessViewModel f121537a;

            C03011(StrictModeAccessViewModel strictModeAccessViewModel) {
                this.f121537a = strictModeAccessViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StrictModeAccessViewState f(PremiumState premiumState, StrictModeAccessViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return StrictModeAccessViewState.b(updateState, null, null, premiumState, false, false, false, null, 123, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f121537a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessViewModel.AnonymousClass1.C03011.f(premiumState, (StrictModeAccessViewState) obj);
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
            return StrictModeAccessViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f121535a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = StrictModeAccessViewModel.this.Y0().K();
                C03011 c03011 = new C03011(StrictModeAccessViewModel.this);
                this.f121535a = 1;
                if (stateFlowK.collect(c03011, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$2", f = "StrictModeAccessViewModel.kt", l = {33}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121538a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ StrictModeAccessViewModel f121540a;

            AnonymousClass1(StrictModeAccessViewModel strictModeAccessViewModel) {
                this.f121540a = strictModeAccessViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StrictModeAccessViewState f(boolean z2, StrictModeAccessViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return StrictModeAccessViewState.b(updateState, null, null, null, z2, false, false, null, 119, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f121540a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.f1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessViewModel.AnonymousClass2.AnonymousClass1.f(z2, (StrictModeAccessViewState) obj);
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
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return StrictModeAccessViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f121538a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowS = StrictModeAccessViewModel.this.Y0().S();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(StrictModeAccessViewModel.this);
                this.f121538a = 1;
                if (stateFlowS.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$3", f = "StrictModeAccessViewModel.kt", l = {40}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121541a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ StrictModeAccessViewModel f121543a;

            AnonymousClass1(StrictModeAccessViewModel strictModeAccessViewModel) {
                this.f121543a = strictModeAccessViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StrictModeAccessViewState f(SessionManager.SignInState signInState, StrictModeAccessViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return StrictModeAccessViewState.b(updateState, null, null, null, false, false, signInState instanceof SessionManager.SignedIn, null, 95, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final SessionManager.SignInState signInState, Continuation continuation) {
                this.f121543a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.g1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessViewModel.AnonymousClass3.AnonymousClass1.f(signInState, (StrictModeAccessViewState) obj);
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
            return StrictModeAccessViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f121541a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowL = SessionManager.f127910a.l();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(StrictModeAccessViewModel.this);
                this.f121541a = 1;
                if (stateFlowL.collect(anonymousClass1, this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrictModeAccessViewModel(Application application) {
        super(application, new StrictModeAccessViewState(null, null, null, false, false, false, null, 127, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        this.f121533o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.f121534p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr3, objArr4);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
    }

    public static final /* synthetic */ StrictModeAccessViewState T0(StrictModeAccessViewModel strictModeAccessViewModel) {
        return (StrictModeAccessViewState) strictModeAccessViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 Y0() {
        return (PremiumRepositoryV2) this.f121534p.getValue();
    }

    private final StrictModeDataStore Z0() {
        return (StrictModeDataStore) this.f121533o.getValue();
    }

    private final void a1(StrictModeAccessMethod strictModeAccessMethod) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictModeAccessViewModel$onAccessMethodClicked$1(strictModeAccessMethod, this, null), 3, null);
    }

    private final void b1(AccessMethodConfiguration accessMethodConfiguration) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictModeAccessViewModel$onAccessMethodConfigured$1(this, accessMethodConfiguration, null), 3, null);
    }

    private final void c1() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictModeAccessViewModel.d1((StrictModeAccessViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeAccessViewState d1(StrictModeAccessViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeAccessViewState.b(updateState, null, null, null, false, false, false, null, 111, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$showEmailBottomSheet$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$showEmailBottomSheet$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$showEmailBottomSheet$1) r0
            int r1 = r0.f121555c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121555c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$showEmailBottomSheet$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$showEmailBottomSheet$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f121553a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121555c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r5 = r4.Z0()
            kotlinx.coroutines.flow.Flow r5 = r5.h0()
            r0.f121555c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.String r5 = (java.lang.String) r5
            cz.mobilesoft.coreblock.scene.strictmode3.access.d1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.access.d1
            r0.<init>()
            r4.Q0(r0)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel.f1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeAccessViewState g1(String str, StrictModeAccessViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeAccessViewState.b(updateState, null, null, null, false, true, false, str, 47, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void O0(StrictModeAccessViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StrictModeAccessViewEvent.OnAccessMethodClicked) {
            a1(((StrictModeAccessViewEvent.OnAccessMethodClicked) event).a());
            return;
        }
        if (event instanceof StrictModeAccessViewEvent.OnPinConfirmed) {
            b1(new AccessMethodConfiguration.PinCode(((StrictModeAccessViewEvent.OnPinConfirmed) event).a()));
            return;
        }
        if (event instanceof StrictModeAccessViewEvent.OnTimerSet) {
            b1(new AccessMethodConfiguration.Timer(((StrictModeAccessViewEvent.OnTimerSet) event).a()));
            return;
        }
        if (event instanceof StrictModeAccessViewEvent.OnSchedulesSet) {
            StrictModeAccessViewEvent.OnSchedulesSet onSchedulesSet = (StrictModeAccessViewEvent.OnSchedulesSet) event;
            b1(new AccessMethodConfiguration.Schedules(onSchedulesSet.b(), onSchedulesSet.a()));
        } else if (event instanceof StrictModeAccessViewEvent.OnCooldownSet) {
            b1(new AccessMethodConfiguration.Cooldown(((StrictModeAccessViewEvent.OnCooldownSet) event).a()));
        } else if (event instanceof StrictModeAccessViewEvent.OnEmailSet) {
            b1(new AccessMethodConfiguration.Approval(((StrictModeAccessViewEvent.OnEmailSet) event).a()));
        } else {
            if (!Intrinsics.areEqual(event, StrictModeAccessViewEvent.OnEmailDismiss.f121527a)) {
                throw new NoWhenBranchMatchedException();
            }
            c1();
        }
    }
}
