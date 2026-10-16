package androidx.glance.appwidget;

import android.content.BroadcastReceiver;
import android.util.Log;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
@DebugMetadata(c = "androidx.glance.appwidget.CoroutineBroadcastReceiverKt$goAsync$1", f = "CoroutineBroadcastReceiver.kt", l = {45}, m = "invokeSuspend")
final class CoroutineBroadcastReceiverKt$goAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f37878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f37879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f37880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f37881d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BroadcastReceiver.PendingResult f37882f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineBroadcastReceiverKt$goAsync$1(Function2 function2, CoroutineScope coroutineScope, BroadcastReceiver.PendingResult pendingResult, Continuation continuation) {
        super(2, continuation);
        this.f37880c = function2;
        this.f37881d = coroutineScope;
        this.f37882f = pendingResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CoroutineBroadcastReceiverKt$goAsync$1 coroutineBroadcastReceiverKt$goAsync$1 = new CoroutineBroadcastReceiverKt$goAsync$1(this.f37880c, this.f37881d, this.f37882f, continuation);
        coroutineBroadcastReceiverKt$goAsync$1.f37879b = obj;
        return coroutineBroadcastReceiverKt$goAsync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f37878a;
        try {
            try {
                if (i3 != 0) {
                    try {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    } finally {
                        CoroutineScopeKt.e(this.f37881d, null, 1, null);
                    }
                } else {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f37879b;
                    Function2 function2 = this.f37880c;
                    this.f37878a = 1;
                    if (function2.invoke(coroutineScope, this) == objF) {
                        return objF;
                    }
                }
            } catch (CancellationException e3) {
                throw e3;
            } catch (Throwable th) {
                Log.e("GlanceAppWidget", "BroadcastReceiver execution failed", th);
            }
            return Unit.f139807a;
        } finally {
            try {
                this.f37882f.finish();
            } catch (IllegalStateException e4) {
                Log.e("GlanceAppWidget", "Error thrown when trying to finish broadcast", e4);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CoroutineBroadcastReceiverKt$goAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
