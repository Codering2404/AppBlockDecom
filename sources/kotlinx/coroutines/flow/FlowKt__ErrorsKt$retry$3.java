package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", l = {91}, m = "invokeSuspend")
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f141718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f141719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ long f141720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f141721d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f141722f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$3(long j3, Function2 function2, Continuation continuation) {
        super(4, continuation);
        this.f141721d = j3;
        this.f141722f = function2;
    }

    public final Object h(FlowCollector flowCollector, Throwable th, long j3, Continuation continuation) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.f141721d, this.f141722f, continuation);
        flowKt__ErrorsKt$retry$3.f141719b = th;
        flowKt__ErrorsKt$retry$3.f141720c = j3;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f141718a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Throwable th = (Throwable) this.f141719b;
            if (this.f141720c < this.f141721d) {
                Function2 function2 = this.f141722f;
                this.f141718a = 1;
                obj = function2.invoke(th, this);
                if (obj == objF) {
                    return objF;
                }
            }
            return Boxing.a(z);
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        boolean z2 = ((Boolean) obj).booleanValue();
        return Boxing.a(z2);
    }
}
