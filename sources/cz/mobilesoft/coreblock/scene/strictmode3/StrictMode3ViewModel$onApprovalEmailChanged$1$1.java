package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import kotlin.Metadata;
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

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onApprovalEmailChanged$1$1", f = "StrictMode3ViewModel.kt", l = {526}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onApprovalEmailChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f121321c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onApprovalEmailChanged$1$1(StrictMode3ViewModel strictMode3ViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.f121320b = strictMode3ViewModel;
        this.f121321c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(StrictMode3ViewModel strictMode3ViewModel, final ApprovalEvent approvalEvent) {
        if ((approvalEvent instanceof ApprovalEvent.Success) || (approvalEvent instanceof ApprovalEvent.ReadyToActivate)) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.a4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$onApprovalEmailChanged$1$1.G((StrictMode3ViewState) obj);
                }
            });
        } else if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.Loading.f121707a)) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.b4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$onApprovalEmailChanged$1$1.J((StrictMode3ViewState) obj);
                }
            });
        } else if (approvalEvent instanceof ApprovalEvent.Error) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.c4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$onApprovalEmailChanged$1$1.K(approvalEvent, (StrictMode3ViewState) obj);
                }
            });
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState G(StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Success.f128020a, null, null, 0L, 1966079, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState J(StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Loading.f127895a, null, null, 0L, 1966079, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState K(ApprovalEvent approvalEvent, StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, ((ApprovalEvent.Error) approvalEvent).a(), null, null, 0L, 1966079, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$onApprovalEmailChanged$1$1(this.f121320b, this.f121321c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121319a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ApprovalRepository approvalRepositoryY1 = this.f121320b.Y1();
            String str = this.f121321c;
            final StrictMode3ViewModel strictMode3ViewModel = this.f121320b;
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.z3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StrictMode3ViewModel$onApprovalEmailChanged$1$1.A(strictMode3ViewModel, (ApprovalEvent) obj2);
                }
            };
            this.f121319a = 1;
            if (approvalRepositoryY1.m(str, function1, this) == objF) {
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
        return ((StrictMode3ViewModel$onApprovalEmailChanged$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
