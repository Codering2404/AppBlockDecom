package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeButtonState;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeApprovalEvents$1;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeApprovalEvents$1", f = "StrictMode3ViewModel.kt", l = {115}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$observeApprovalEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121252b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observeApprovalEvents$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewModel f121253a;

        AnonymousClass1(StrictMode3ViewModel strictMode3ViewModel) {
            this.f121253a = strictMode3ViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState k(StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Loading.f127895a, null, null, 0L, 1966079, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState l(ApprovalEvent approvalEvent, StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, ((ApprovalEvent.Error) approvalEvent).a(), null, null, 0L, 1966079, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState m(StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Success.f128020a, null, null, 0L, 1966079, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState n(StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, StrictMode3ViewState.ActiveState.b(updateState.g(), null, true, false, false, StrictModeButtonState.ApprovalRequest, 13, null), null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2097150, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState o(StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, StrictMode3ViewState.ActiveState.b(updateState.g(), null, true, false, false, StrictModeButtonState.Deactivate, 13, null), null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2097150, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState p(StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, StrictMode3ViewState.ActiveState.b(updateState.g(), null, false, false, false, StrictModeButtonState.ApprovalRequestSent, 13, null), null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2097150, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Object emit(final ApprovalEvent approvalEvent, Continuation continuation) {
            if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.Loading.f121707a)) {
                this.f121253a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.k3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$observeApprovalEvents$1.AnonymousClass1.k((StrictMode3ViewState) obj);
                    }
                });
            } else if (approvalEvent instanceof ApprovalEvent.Error) {
                this.f121253a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.l3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$observeApprovalEvents$1.AnonymousClass1.l(approvalEvent, (StrictMode3ViewState) obj);
                    }
                });
            } else if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.Success.f121712a)) {
                this.f121253a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.m3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$observeApprovalEvents$1.AnonymousClass1.m((StrictMode3ViewState) obj);
                    }
                });
            } else if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.ResendEmailCountdownEnded.f121710a)) {
                this.f121253a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.n3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$observeApprovalEvents$1.AnonymousClass1.n((StrictMode3ViewState) obj);
                    }
                });
            } else if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.ReadyToDeactivate.f121709a)) {
                if (StrictMode3ViewModel.h1(this.f121253a).g().e() == StrictModeState.Active) {
                    this.f121253a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.o3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StrictMode3ViewModel$observeApprovalEvents$1.AnonymousClass1.o((StrictMode3ViewState) obj);
                        }
                    });
                }
            } else if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.ResendEmailCountdownRunning.f121711a)) {
                this.f121253a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.p3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$observeApprovalEvents$1.AnonymousClass1.p((StrictMode3ViewState) obj);
                    }
                });
            } else {
                if (!Intrinsics.areEqual(approvalEvent, ApprovalEvent.ReadyToActivate.f121708a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.f121253a.O1();
            }
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$observeApprovalEvents$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121252b = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$observeApprovalEvents$1(this.f121252b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121251a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SharedFlow sharedFlowX = this.f121252b.Y1().x();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f121252b);
            this.f121251a = 1;
            if (sharedFlowX.collect(anonymousClass1, this) == objF) {
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
        return ((StrictMode3ViewModel$observeApprovalEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
