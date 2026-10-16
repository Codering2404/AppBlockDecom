package cz.mobilesoft.coreblock.util.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.compose.FlowExtKt$collectAsStateFlow$1", f = "FlowExt.kt", l = {87, 87}, m = "invokeSuspend", v = 1)
final class FlowExtKt$collectAsStateFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Flow f128237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f128238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FlowCollector f128239d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$collectAsStateFlow$1(Flow flow, CoroutineScope coroutineScope, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.f128237b = flow;
        this.f128238c = coroutineScope;
        this.f128239d = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowExtKt$collectAsStateFlow$1(this.f128237b, this.f128238c, this.f128239d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (((kotlinx.coroutines.flow.StateFlow) r5).collect(r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f128236a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 == r2) goto L16
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L16:
            kotlin.ResultKt.b(r5)
            goto L3b
        L1a:
            kotlin.ResultKt.b(r5)
            goto L2e
        L1e:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.flow.Flow r5 = r4.f128237b
            kotlinx.coroutines.CoroutineScope r1 = r4.f128238c
            r4.f128236a = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.g0(r5, r1, r4)
            if (r5 != r0) goto L2e
            goto L3a
        L2e:
            kotlinx.coroutines.flow.StateFlow r5 = (kotlinx.coroutines.flow.StateFlow) r5
            kotlinx.coroutines.flow.FlowCollector r1 = r4.f128239d
            r4.f128236a = r2
            java.lang.Object r5 = r5.collect(r1, r4)
            if (r5 != r0) goto L3b
        L3a:
            return r0
        L3b:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.FlowExtKt$collectAsStateFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlowExtKt$collectAsStateFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
