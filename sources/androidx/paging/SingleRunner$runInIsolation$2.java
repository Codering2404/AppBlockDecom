package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", l = {53, 59, 61, 61}, m = "invokeSuspend")
final class SingleRunner$runInIsolation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f50684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SingleRunner f50685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f50686d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f50687f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleRunner$runInIsolation$2(SingleRunner singleRunner, int i3, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f50685c = singleRunner;
        this.f50686d = i3;
        this.f50687f = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SingleRunner$runInIsolation$2 singleRunner$runInIsolation$2 = new SingleRunner$runInIsolation$2(this.f50685c, this.f50686d, this.f50687f, continuation);
        singleRunner$runInIsolation$2.f50684b = obj;
        return singleRunner$runInIsolation$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
    
        if (r9.a(r1, r8) != r0) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.paging.SingleRunner$Holder] */
    /* JADX WARN: Type inference failed for: r9v15, types: [androidx.paging.SingleRunner$Holder] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f50683a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L3c
            if (r1 == r5) goto L34
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L25
            if (r1 == r2) goto L1c
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            java.lang.Object r0 = r8.f50684b
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.b(r9)
            goto La0
        L25:
            kotlin.ResultKt.b(r9)
            goto La1
        L2a:
            java.lang.Object r1 = r8.f50684b
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r9 = move-exception
            goto L8e
        L34:
            java.lang.Object r1 = r8.f50684b
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.b(r9)
            goto L67
        L3c:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.f50684b
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.coroutines.CoroutineContext r9 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.v8
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r1)
            if (r9 == 0) goto La4
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            androidx.paging.SingleRunner r1 = r8.f50685c
            androidx.paging.SingleRunner$Holder r1 = androidx.paging.SingleRunner.a(r1)
            int r6 = r8.f50686d
            r8.f50684b = r9
            r8.f50683a = r5
            java.lang.Object r1 = r1.b(r6, r9, r8)
            if (r1 != r0) goto L64
            goto L9e
        L64:
            r7 = r1
            r1 = r9
            r9 = r7
        L67:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto La1
            kotlin.jvm.functions.Function1 r9 = r8.f50687f     // Catch: java.lang.Throwable -> L32
            r8.f50684b = r1     // Catch: java.lang.Throwable -> L32
            r8.f50683a = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r9 = r9.invoke(r8)     // Catch: java.lang.Throwable -> L32
            if (r9 != r0) goto L7c
            goto L9e
        L7c:
            androidx.paging.SingleRunner r9 = r8.f50685c
            androidx.paging.SingleRunner$Holder r9 = androidx.paging.SingleRunner.a(r9)
            r2 = 0
            r8.f50684b = r2
            r8.f50683a = r3
            java.lang.Object r9 = r9.a(r1, r8)
            if (r9 != r0) goto La1
            goto L9e
        L8e:
            androidx.paging.SingleRunner r3 = r8.f50685c
            androidx.paging.SingleRunner$Holder r3 = androidx.paging.SingleRunner.a(r3)
            r8.f50684b = r9
            r8.f50683a = r2
            java.lang.Object r1 = r3.a(r1, r8)
            if (r1 != r0) goto L9f
        L9e:
            return r0
        L9f:
            r0 = r9
        La0:
            throw r0
        La1:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        La4:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Internal error. coroutineScope should've created a job."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner$runInIsolation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SingleRunner$runInIsolation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
