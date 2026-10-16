package cz.mobilesoft.coreblock.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnFlow$1", f = "StrictModeRepository.kt", l = {83, 84}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$isStrictModeCurrentlyOnFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f98304b;

    StrictModeRepository$isStrictModeCurrentlyOnFlow$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeRepository$isStrictModeCurrentlyOnFlow$1 strictModeRepository$isStrictModeCurrentlyOnFlow$1 = new StrictModeRepository$isStrictModeCurrentlyOnFlow$1(continuation);
        strictModeRepository$isStrictModeCurrentlyOnFlow$1.f98304b = obj;
        return strictModeRepository$isStrictModeCurrentlyOnFlow$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003f -> B:11:0x0022). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f98304b
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r7.f98303a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L1f
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L1f
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1b:
            kotlin.ResultKt.b(r8)
            goto L2f
        L1f:
            kotlin.ResultKt.b(r8)
        L22:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            r7.f98304b = r0
            r7.f98303a = r4
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r1) goto L2f
            goto L41
        L2f:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
            r5 = 30
            long r5 = r8.toMillis(r5)
            r7.f98304b = r0
            r7.f98303a = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r1) goto L22
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((StrictModeRepository$isStrictModeCurrentlyOnFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
