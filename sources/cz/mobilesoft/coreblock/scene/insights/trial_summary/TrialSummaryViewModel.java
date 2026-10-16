package cz.mobilesoft.coreblock.scene.insights.trial_summary;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.TrialSummaryData;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class TrialSummaryViewModel extends BaseStatefulViewModel<TrialSummaryViewState, TrialSummaryViewEvent, TrialSummaryViewCommand> implements KoinComponent {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f103599o;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel$1", f = "TrialSummaryViewModel.kt", l = {20, 29}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f103600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f103601b;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TrialSummaryViewState q(TrialSummaryData trialSummaryData, TrialSummaryViewState trialSummaryViewState) {
            return trialSummaryViewState.a(trialSummaryData);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return TrialSummaryViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        
            if (r1.P0(r3, r4) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.f103601b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r4.f103600a
                cz.mobilesoft.coreblock.dto.TrialSummaryData r0 = (cz.mobilesoft.coreblock.dto.TrialSummaryData) r0
                kotlin.ResultKt.b(r5)
                goto L58
            L16:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1e:
                kotlin.ResultKt.b(r5)
                goto L36
            L22:
                kotlin.ResultKt.b(r5)
                cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel r5 = cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.this
                cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase r5 = cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.R0(r5)
                cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase$Params r1 = cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase.Params.f103756a
                r4.f103601b = r3
                java.lang.Object r5 = r5.c(r1, r4)
                if (r5 != r0) goto L36
                goto L57
            L36:
                cz.mobilesoft.coreblock.dto.TrialSummaryData r5 = (cz.mobilesoft.coreblock.dto.TrialSummaryData) r5
                if (r5 == 0) goto L45
                cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel r0 = cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.this
                cz.mobilesoft.coreblock.scene.insights.trial_summary.r r1 = new cz.mobilesoft.coreblock.scene.insights.trial_summary.r
                r1.<init>()
                cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.T0(r0, r1)
                goto L58
            L45:
                cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel r1 = cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.this
                cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewCommand$GoToDashboard r3 = cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewCommand.GoToDashboard.f103598a
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
                r4.f103600a = r5
                r4.f103601b = r2
                java.lang.Object r5 = cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.S0(r1, r3, r4)
                if (r5 != r0) goto L58
            L57:
                return r0
            L58:
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TrialSummaryViewModel(Application application) {
        super(application, new TrialSummaryViewState(null, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f103599o = LazyKt.a(lazyThreadSafetyModeB, new Function0<FetchTrialSummaryUseCase>() { // from class: cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchTrialSummaryUseCase.class), qualifier, objArr);
            }
        });
        G0(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchTrialSummaryUseCase U0() {
        return (FetchTrialSummaryUseCase) this.f103599o.getValue();
    }
}
