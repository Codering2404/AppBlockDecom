package cz.mobilesoft.coreblock.rest.interceptor;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor$onCallFailed$1", f = "ErrorLogInterceptor.kt", l = {117, 119}, m = "invokeSuspend", v = 1)
final class ErrorLogInterceptor$onCallFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f98540d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f98541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Pair f98542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function3 f98543h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ErrorLogInterceptor$onCallFailed$1(List list, Pair pair, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f98541f = list;
        this.f98542g = pair;
        this.f98543h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ErrorLogInterceptor$onCallFailed$1(this.f98541f, this.f98542g, this.f98543h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (r1.invoke(r3, r6, r5) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f98540d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r5.f98539c
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r5.f98538b
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r6)
            goto L60
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L22:
            kotlin.ResultKt.b(r6)
            goto L36
        L26:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.rest.interceptor.ErrorLogStore r6 = cz.mobilesoft.coreblock.rest.interceptor.ErrorLogStore.f98544a
            java.util.List r1 = r5.f98541f
            r5.f98540d = r3
            java.lang.Object r6 = r6.e(r1, r5)
            if (r6 != r0) goto L36
            goto L5f
        L36:
            kotlin.Pair r6 = r5.f98542g
            if (r6 == 0) goto L60
            kotlin.jvm.functions.Function3 r1 = r5.f98543h
            java.lang.Object r3 = r6.a()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r6 = r6.b()
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
            r5.f98538b = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f98539c = r4
            r4 = 0
            r5.f98537a = r4
            r5.f98540d = r2
            java.lang.Object r6 = r1.invoke(r3, r6, r5)
            if (r6 != r0) goto L60
        L5f:
            return r0
        L60:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor$onCallFailed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ErrorLogInterceptor$onCallFailed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
