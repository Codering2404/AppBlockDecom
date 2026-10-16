package cz.mobilesoft.coreblock.scene.more.help.restorepurchase;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
public final class RestorePurchaseViewModel extends BaseStatefulViewModel<RestorePurchaseViewState, RestorePurchaseViewEvent, RestorePurchaseViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f107831o;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1", f = "RestorePurchaseViewModel.kt", l = {21}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107832a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02841<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ RestorePurchaseViewModel f107834a;

            C02841(RestorePurchaseViewModel restorePurchaseViewModel) {
                this.f107834a = restorePurchaseViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final RestorePurchaseViewState f(DataState dataState, RestorePurchaseViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a(dataState);
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
            
                if (r8.P0(r2, r0) == r1) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(final cz.mobilesoft.coreblock.util.DataState r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r8
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1$emit$1) r0
                    int r1 = r0.f107838d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f107838d = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1$emit$1
                    r0.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r0.f107836b
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f107838d
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L38
                    if (r2 != r3) goto L30
                    java.lang.Object r7 = r0.f107835a
                    cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
                    kotlin.ResultKt.b(r8)
                    goto L75
                L30:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L38:
                    java.lang.Object r7 = r0.f107835a
                    cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
                    kotlin.ResultKt.b(r8)
                    goto L62
                L40:
                    kotlin.ResultKt.b(r8)
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel r8 = r6.f107834a
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.k r2 = new cz.mobilesoft.coreblock.scene.more.help.restorepurchase.k
                    r2.<init>()
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel.T0(r8, r2)
                    boolean r8 = r7 instanceof cz.mobilesoft.coreblock.util.DataState.Success
                    if (r8 == 0) goto L78
                    java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                    r0.f107835a = r8
                    r0.f107838d = r4
                    r4 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r4, r0)
                    if (r8 != r1) goto L62
                    goto L74
                L62:
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel r8 = r6.f107834a
                    cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewCommand$Exit r2 = cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewCommand.Exit.f107830a
                    java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                    r0.f107835a = r7
                    r0.f107838d = r3
                    java.lang.Object r7 = cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel.S0(r8, r2, r0)
                    if (r7 != r1) goto L75
                L74:
                    return r1
                L75:
                    kotlin.Unit r7 = kotlin.Unit.f139807a
                    return r7
                L78:
                    kotlin.Unit r7 = kotlin.Unit.f139807a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel.AnonymousClass1.C02841.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return RestorePurchaseViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107832a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE = RestorePurchaseViewModel.this.U0().e(RestoreRevenueCatPurchaseUseCase.Params.f127233a);
                C02841 c02841 = new C02841(RestorePurchaseViewModel.this);
                this.f107832a = 1;
                if (flowE.collect(c02841, this) == objF) {
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
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RestorePurchaseViewModel(Application application) {
        super(application, new RestorePurchaseViewState(DataState.Loading.f127816a));
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f107831o = LazyKt.a(lazyThreadSafetyModeB, new Function0<RestoreRevenueCatPurchaseUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RestoreRevenueCatPurchaseUseCase.class), qualifier, objArr);
            }
        });
        G0(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RestoreRevenueCatPurchaseUseCase U0() {
        return (RestoreRevenueCatPurchaseUseCase) this.f107831o.getValue();
    }
}
