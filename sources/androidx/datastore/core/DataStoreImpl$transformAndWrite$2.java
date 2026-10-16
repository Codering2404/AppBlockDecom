package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", l = {330, 331, 337}, m = "invokeSuspend")
final class DataStoreImpl$transformAndWrite$2<T> extends SuspendLambda implements Function1<Continuation<? super T>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineContext f35664d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f35665f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$transformAndWrite$2(DataStoreImpl dataStoreImpl, CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        super(1, continuation);
        this.f35663c = dataStoreImpl;
        this.f35664d = coroutineContext;
        this.f35665f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$transformAndWrite$2(this.f35663c, this.f35664d, this.f35665f, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f35662b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r8.f35661a
            kotlin.ResultKt.b(r9)
            return r0
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.f35661a
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            kotlin.ResultKt.b(r9)
            goto L51
        L27:
            kotlin.ResultKt.b(r9)
            goto L39
        L2b:
            kotlin.ResultKt.b(r9)
            androidx.datastore.core.DataStoreImpl r9 = r8.f35663c
            r8.f35662b = r4
            java.lang.Object r9 = androidx.datastore.core.DataStoreImpl.n(r9, r4, r8)
            if (r9 != r0) goto L39
            goto L6a
        L39:
            r1 = r9
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            kotlin.coroutines.CoroutineContext r9 = r8.f35664d
            androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
            kotlin.jvm.functions.Function2 r6 = r8.f35665f
            r7 = 0
            r5.<init>(r6, r1, r7)
            r8.f35661a = r1
            r8.f35662b = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r9, r5, r8)
            if (r9 != r0) goto L51
            goto L6a
        L51:
            r1.b()
            java.lang.Object r1 = r1.c()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r9)
            if (r1 != 0) goto L6b
            androidx.datastore.core.DataStoreImpl r1 = r8.f35663c
            r8.f35661a = r9
            r8.f35662b = r2
            java.lang.Object r1 = r1.B(r9, r4, r8)
            if (r1 != r0) goto L6b
        L6a:
            return r0
        L6b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$transformAndWrite$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DataStoreImpl$transformAndWrite$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
