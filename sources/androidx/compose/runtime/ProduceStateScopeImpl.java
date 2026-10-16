package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

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
final class ProduceStateScopeImpl<T> implements ProduceStateScope<T>, MutableState<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f24006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ MutableState f24007b;

    public ProduceStateScopeImpl(MutableState mutableState, CoroutineContext coroutineContext) {
        this.f24006a = coroutineContext;
        this.f24007b = mutableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(kotlin.jvm.functions.Function0 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1 r0 = (androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1) r0
            int r1 = r0.f24011d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f24011d = r1
            goto L18
        L13:
            androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1 r0 = new androidx.compose.runtime.ProduceStateScopeImpl$awaitDispose$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f24009b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f24011d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            java.lang.Object r5 = r0.f24008a
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L35
            goto L5a
        L35:
            r6 = move-exception
            goto L60
        L37:
            kotlin.ResultKt.b(r6)
            r0.f24008a = r5     // Catch: java.lang.Throwable -> L35
            r0.f24011d = r3     // Catch: java.lang.Throwable -> L35
            kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L35
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)     // Catch: java.lang.Throwable -> L35
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L35
            r6.C()     // Catch: java.lang.Throwable -> L35
            java.lang.Object r6 = r6.v()     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()     // Catch: java.lang.Throwable -> L35
            if (r6 != r2) goto L57
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch: java.lang.Throwable -> L35
        L57:
            if (r6 != r1) goto L5a
            return r1
        L5a:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L35
            r6.<init>()     // Catch: java.lang.Throwable -> L35
            throw r6     // Catch: java.lang.Throwable -> L35
        L60:
            r5.invoke()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProduceStateScopeImpl.b(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f24006a;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public Object getValue() {
        return this.f24007b.getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(Object obj) {
        this.f24007b.setValue(obj);
    }
}
