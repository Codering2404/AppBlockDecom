package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", l = {218, 226}, m = "invokeSuspend")
final class DataStoreImpl$readState$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super State<T>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f35657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f35659c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readState$2(DataStoreImpl dataStoreImpl, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f35658b = dataStoreImpl;
        this.f35659c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DataStoreImpl$readState$2(this.f35658b, this.f35659c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        if (r5 == r0) goto L22;
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
            int r1 = r4.f35657a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L54
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L1e
            goto L47
        L1e:
            r5 = move-exception
            goto L57
        L20:
            kotlin.ResultKt.b(r5)
            androidx.datastore.core.DataStoreImpl r5 = r4.f35658b
            androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.d(r5)
            androidx.datastore.core.State r5 = r5.a()
            boolean r5 = r5 instanceof androidx.datastore.core.Final
            if (r5 == 0) goto L3c
            androidx.datastore.core.DataStoreImpl r5 = r4.f35658b
            androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.d(r5)
            androidx.datastore.core.State r5 = r5.a()
            return r5
        L3c:
            androidx.datastore.core.DataStoreImpl r5 = r4.f35658b     // Catch: java.lang.Throwable -> L1e
            r4.f35657a = r3     // Catch: java.lang.Throwable -> L1e
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.k(r5, r4)     // Catch: java.lang.Throwable -> L1e
            if (r5 != r0) goto L47
            goto L53
        L47:
            androidx.datastore.core.DataStoreImpl r5 = r4.f35658b
            boolean r1 = r4.f35659c
            r4.f35657a = r2
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.l(r5, r1, r4)
            if (r5 != r0) goto L54
        L53:
            return r0
        L54:
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
            return r5
        L57:
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r1 = -1
            r0.<init>(r5, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DataStoreImpl$readState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
