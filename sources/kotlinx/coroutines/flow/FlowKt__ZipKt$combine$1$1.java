package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {29, 29}, m = "invokeSuspend")
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f142082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f142083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f142084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f142085d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ZipKt$combine$1$1(Function3 function3, Continuation continuation) {
        super(3, continuation);
        this.f142085d = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.f142085d, continuation);
        flowKt__ZipKt$combine$1$1.f142083b = flowCollector;
        flowKt__ZipKt$combine$1$1.f142084c = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r1.emit(r7, r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f142082a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L4c
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f142083b
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.b(r7)
            goto L40
        L22:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f142083b
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r7 = r6.f142084c
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            kotlin.jvm.functions.Function3 r4 = r6.f142085d
            r5 = 0
            r5 = r7[r5]
            r7 = r7[r3]
            r6.f142083b = r1
            r6.f142082a = r3
            java.lang.Object r7 = r4.invoke(r5, r7, r6)
            if (r7 != r0) goto L40
            goto L4b
        L40:
            r3 = 0
            r6.f142083b = r3
            r6.f142082a = r2
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto L4c
        L4b:
            return r0
        L4c:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
