package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1$1", f = "ReportDrawn.kt", l = {159}, m = "invokeSuspend")
final class ReportDrawnKt$ReportDrawnAfter$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FullyDrawnReporter f500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f501d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnAfter$1$1(FullyDrawnReporter fullyDrawnReporter, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f500c = fullyDrawnReporter;
        this.f501d = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ReportDrawnKt$ReportDrawnAfter$1$1(this.f500c, this.f501d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FullyDrawnReporter fullyDrawnReporter;
        Throwable th;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f499b;
        if (i3 == 0) {
            ResultKt.b(obj);
            FullyDrawnReporter fullyDrawnReporter2 = this.f500c;
            Function1 function1 = this.f501d;
            fullyDrawnReporter2.c();
            if (!fullyDrawnReporter2.e()) {
                try {
                    this.f498a = fullyDrawnReporter2;
                    this.f499b = 1;
                    if (function1.invoke(this) == objF) {
                        return objF;
                    }
                    fullyDrawnReporter = fullyDrawnReporter2;
                    fullyDrawnReporter.g();
                } catch (Throwable th2) {
                    fullyDrawnReporter = fullyDrawnReporter2;
                    th = th2;
                    fullyDrawnReporter.g();
                    throw th;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fullyDrawnReporter = (FullyDrawnReporter) this.f498a;
            try {
                ResultKt.b(obj);
                fullyDrawnReporter.g();
            } catch (Throwable th3) {
                th = th3;
                fullyDrawnReporter.g();
                throw th;
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ReportDrawnKt$ReportDrawnAfter$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
