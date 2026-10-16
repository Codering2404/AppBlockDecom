package androidx.core.os;

import android.content.Context;
import android.os.ProfilingManager;
import android.os.ProfilingResult;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.core.os.Profiling$registerForAllProfilingResults$1", f = "Profiling.kt", l = {79}, m = "invokeSuspend")
final class Profiling$registerForAllProfilingResults$1 extends SuspendLambda implements Function2<ProducerScope<? super ProfilingResult>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f34168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f34169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f34170c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Profiling$registerForAllProfilingResults$1(Context context, Continuation continuation) {
        super(2, continuation);
        this.f34170c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Runnable runnable) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ProducerScope producerScope, ProfilingResult result) {
        Intrinsics.checkNotNullExpressionValue(result, "result");
        producerScope.h(result);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Profiling$registerForAllProfilingResults$1 profiling$registerForAllProfilingResults$1 = new Profiling$registerForAllProfilingResults$1(this.f34170c, continuation);
        profiling$registerForAllProfilingResults$1.f34169b = obj;
        return profiling$registerForAllProfilingResults$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f34168a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f34169b;
            final Consumer consumer = new Consumer() { // from class: androidx.core.os.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    Profiling$registerForAllProfilingResults$1.z(producerScope, (ProfilingResult) obj2);
                }
            };
            final ProfilingManager profilingManagerA = c.a(this.f34170c.getSystemService(b.a()));
            profilingManagerA.registerForAllProfilingResults(new Executor() { // from class: androidx.core.os.f
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    Profiling$registerForAllProfilingResults$1.A(runnable);
                }
            }, consumer);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.core.os.Profiling$registerForAllProfilingResults$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m292invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m292invoke() {
                    profilingManagerA.unregisterForAllProfilingResults(consumer);
                }
            };
            this.f34168a = 1;
            if (ProduceKt.a(producerScope, function0, this) == objF) {
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
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((Profiling$registerForAllProfilingResults$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
