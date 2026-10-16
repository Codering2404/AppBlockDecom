package cz.mobilesoft.coreblock.scene.strictmode3.approval;

import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$resumeApprovalResendEmailCountdownIfNeeded$1", f = "ApprovalRepository.kt", l = {98, 101}, m = "invokeSuspend", v = 1)
final class ApprovalRepository$resumeApprovalResendEmailCountdownIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f121798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f121799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f121800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictModeState f121801d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AccessMethodConfiguration f121802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ApprovalRepository f121803g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApprovalRepository$resumeApprovalResendEmailCountdownIfNeeded$1(StrictModeState strictModeState, AccessMethodConfiguration accessMethodConfiguration, ApprovalRepository approvalRepository, Continuation continuation) {
        super(2, continuation);
        this.f121801d = strictModeState;
        this.f121802f = accessMethodConfiguration;
        this.f121803g = approvalRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ApprovalRepository$resumeApprovalResendEmailCountdownIfNeeded$1(this.f121801d, this.f121802f, this.f121803g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j3;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121800c;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f121801d != StrictModeState.Active || !(this.f121802f instanceof AccessMethodConfiguration.Approval)) {
                Job job = this.f121803g.f121722h;
                if (job != null) {
                    Job.DefaultImpls.b(job, null, 1, null);
                }
                return Unit.f139807a;
            }
            Flow flowI0 = this.f121803g.A().i0();
            this.f121800c = 1;
            obj = FlowKt.D(flowI0, this);
            if (obj != objF) {
            }
            return objF;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.f121799b;
            ResultKt.b(obj);
            this.f121803g.q(j3);
            return Unit.f139807a;
        }
        ResultKt.b(obj);
        long jLongValue = ((Number) obj).longValue();
        long jA = ApprovalRepository.f121713k.a() + jLongValue;
        if (jA > System.currentTimeMillis()) {
            MutableSharedFlow mutableSharedFlow = this.f121803g.f121723i;
            ApprovalEvent.ResendEmailCountdownRunning resendEmailCountdownRunning = ApprovalEvent.ResendEmailCountdownRunning.f121711a;
            this.f121798a = jLongValue;
            this.f121799b = jA;
            this.f121800c = 2;
            if (mutableSharedFlow.emit(resendEmailCountdownRunning, this) != objF) {
                j3 = jA;
                this.f121803g.q(j3);
            }
            return objF;
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ApprovalRepository$resumeApprovalResendEmailCountdownIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
