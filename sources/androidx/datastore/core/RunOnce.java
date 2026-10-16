package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public abstract class RunOnce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mutex f35791a = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CompletableDeferred f35792b = CompletableDeferredKt.b(null, 1, null);

    public final Object a(Continuation continuation) {
        Object objAwait = this.f35792b.await(continuation);
        return objAwait == IntrinsicsKt.f() ? objAwait : Unit.f139807a;
    }

    protected abstract Object b(Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.f35797f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f35797f = r1
            goto L18
        L13:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f35795c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f35797f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f35794b
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.f35793a
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L35
            goto L8b
        L35:
            r7 = move-exception
            goto L96
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3f:
            java.lang.Object r2 = r0.f35794b
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.f35793a
            androidx.datastore.core.RunOnce r4 = (androidx.datastore.core.RunOnce) r4
            kotlin.ResultKt.b(r7)
            r7 = r2
            goto L6a
        L4c:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.CompletableDeferred r7 = r6.f35792b
            boolean r7 = r7.isCompleted()
            if (r7 == 0) goto L5a
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L5a:
            kotlinx.coroutines.sync.Mutex r7 = r6.f35791a
            r0.f35793a = r6
            r0.f35794b = r7
            r0.f35797f = r4
            java.lang.Object r2 = r7.f(r5, r0)
            if (r2 != r1) goto L69
            goto L88
        L69:
            r4 = r6
        L6a:
            kotlinx.coroutines.CompletableDeferred r2 = r4.f35792b     // Catch: java.lang.Throwable -> L78
            boolean r2 = r2.isCompleted()     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L7c
            kotlin.Unit r0 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L78
            r7.i(r5)
            return r0
        L78:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L96
        L7c:
            r0.f35793a = r4     // Catch: java.lang.Throwable -> L78
            r0.f35794b = r7     // Catch: java.lang.Throwable -> L78
            r0.f35797f = r3     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = r4.b(r0)     // Catch: java.lang.Throwable -> L78
            if (r0 != r1) goto L89
        L88:
            return r1
        L89:
            r1 = r7
            r0 = r4
        L8b:
            kotlinx.coroutines.CompletableDeferred r7 = r0.f35792b     // Catch: java.lang.Throwable -> L35
            kotlin.Unit r0 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L35
            r7.J(r0)     // Catch: java.lang.Throwable -> L35
            r1.i(r5)
            return r0
        L96:
            r1.i(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.c(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
