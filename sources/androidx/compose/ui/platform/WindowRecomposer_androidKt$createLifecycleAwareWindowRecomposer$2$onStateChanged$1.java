package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", l = {388}, m = "invokeSuspend")
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f28301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f28302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f28303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Recomposer f28304d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f28305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 f28306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ View f28307h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(Ref.ObjectRef objectRef, Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2, View view, Continuation continuation) {
        super(2, continuation);
        this.f28303c = objectRef;
        this.f28304d = recomposer;
        this.f28305f = lifecycleOwner;
        this.f28306g = windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2;
        this.f28307h = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1 = new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.f28303c, this.f28304d, this.f28305f, this.f28306g, this.f28307h, continuation);
        windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1.f28302b = obj;
        return windowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        ?? r12;
        Job jobD;
        Object objF = IntrinsicsKt.f();
        ?? r13 = this.f28301a;
        try {
            if (r13 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f28302b;
                try {
                    MotionDurationScaleImpl motionDurationScaleImpl = (MotionDurationScaleImpl) this.f28303c.f140144a;
                    if (motionDurationScaleImpl != null) {
                        StateFlow stateFlowE = WindowRecomposer_androidKt.e(this.f28307h.getContext().getApplicationContext());
                        motionDurationScaleImpl.d(((Number) stateFlowE.getValue()).floatValue());
                        jobD = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1(stateFlowE, motionDurationScaleImpl, null), 3, null);
                    } else {
                        jobD = null;
                    }
                    Recomposer recomposer = this.f28304d;
                    this.f28302b = jobD;
                    this.f28301a = 1;
                    r13 = jobD;
                    if (recomposer.N0(this) == objF) {
                        return objF;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r12 = 0;
                    if (r12 != 0) {
                        Job.DefaultImpls.b(r12, null, 1, null);
                    }
                    this.f28305f.getLifecycle().removeObserver(this.f28306g);
                    throw th;
                }
            } else {
                if (r13 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Job job = (Job) this.f28302b;
                ResultKt.b(obj);
                r13 = job;
            }
            if (r13 != 0) {
                Job.DefaultImpls.b(r13, null, 1, null);
            }
            this.f28305f.getLifecycle().removeObserver(this.f28306g);
            return Unit.f139807a;
        } catch (Throwable th3) {
            th = th3;
            r12 = r13;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
