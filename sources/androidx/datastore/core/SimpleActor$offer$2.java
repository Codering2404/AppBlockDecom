package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {121, 121}, m = "invokeSuspend")
final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SimpleActor f35810c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleActor$offer$2(SimpleActor simpleActor, Continuation continuation) {
        super(2, continuation);
        this.f35810c = simpleActor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SimpleActor$offer$2(this.f35810c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        if (r1.invoke(r6, r5) != r0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[PHI: r1 r6
      0x0051: PHI (r1v1 kotlin.jvm.functions.Function2) = (r1v2 kotlin.jvm.functions.Function2), (r1v4 kotlin.jvm.functions.Function2) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r6v5 java.lang.Object) = (r6v12 java.lang.Object), (r6v0 java.lang.Object) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f35809b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L5d
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            java.lang.Object r1 = r5.f35808a
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.b(r6)
            goto L51
        L22:
            kotlin.ResultKt.b(r6)
            androidx.datastore.core.SimpleActor r6 = r5.f35810c
            androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.c(r6)
            int r6 = r6.b()
            if (r6 <= 0) goto L6c
        L31:
            androidx.datastore.core.SimpleActor r6 = r5.f35810c
            kotlinx.coroutines.CoroutineScope r6 = androidx.datastore.core.SimpleActor.d(r6)
            kotlinx.coroutines.CoroutineScopeKt.g(r6)
            androidx.datastore.core.SimpleActor r6 = r5.f35810c
            kotlin.jvm.functions.Function2 r1 = androidx.datastore.core.SimpleActor.a(r6)
            androidx.datastore.core.SimpleActor r6 = r5.f35810c
            kotlinx.coroutines.channels.Channel r6 = androidx.datastore.core.SimpleActor.b(r6)
            r5.f35808a = r1
            r5.f35809b = r3
            java.lang.Object r6 = r6.v(r5)
            if (r6 != r0) goto L51
            goto L5c
        L51:
            r4 = 0
            r5.f35808a = r4
            r5.f35809b = r2
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L5d
        L5c:
            return r0
        L5d:
            androidx.datastore.core.SimpleActor r6 = r5.f35810c
            androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.c(r6)
            int r6 = r6.a()
            if (r6 != 0) goto L31
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L6c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SimpleActor$offer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
