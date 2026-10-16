package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {54}, m = "invokeSuspend")
final class WorkConstraintsTrackerKt$listen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f54867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WorkConstraintsTracker f54868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WorkSpec f54869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnConstraintsStateChangedListener f54870d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, Continuation continuation) {
        super(2, continuation);
        this.f54868b = workConstraintsTracker;
        this.f54869c = workSpec;
        this.f54870d = onConstraintsStateChangedListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WorkConstraintsTrackerKt$listen$1(this.f54868b, this.f54869c, this.f54870d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f54867a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowB = this.f54868b.b(this.f54869c);
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.f54870d;
            final WorkSpec workSpec = this.f54869c;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(ConstraintsState constraintsState, Continuation continuation) {
                    onConstraintsStateChangedListener.e(workSpec, constraintsState);
                    return Unit.f139807a;
                }
            };
            this.f54867a = 1;
            if (flowB.collect(flowCollector, this) == objF) {
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
        return ((WorkConstraintsTrackerKt$listen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
