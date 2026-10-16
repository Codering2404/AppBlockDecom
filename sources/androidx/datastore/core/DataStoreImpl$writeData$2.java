package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", l = {352, 353}, m = "invokeSuspend")
final class DataStoreImpl$writeData$2<T> extends SuspendLambda implements Function2<WriteScope<T>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f35684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f35685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Object f35687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f35688h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$writeData$2(Ref.IntRef intRef, DataStoreImpl dataStoreImpl, Object obj, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f35685d = intRef;
        this.f35686f = dataStoreImpl;
        this.f35687g = obj;
        this.f35688h = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(this.f35685d, this.f35686f, this.f35687g, this.f35688h, continuation);
        dataStoreImpl$writeData$2.f35684c = obj;
        return dataStoreImpl$writeData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(WriteScope writeScope, Continuation continuation) {
        return ((DataStoreImpl$writeData$2) create(writeScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        if (r3.a(r7, r6) == r0) goto L16;
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
            int r1 = r6.f35683b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L5d
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f35682a
            kotlin.jvm.internal.Ref$IntRef r1 = (kotlin.jvm.internal.Ref.IntRef) r1
            java.lang.Object r3 = r6.f35684c
            androidx.datastore.core.WriteScope r3 = (androidx.datastore.core.WriteScope) r3
            kotlin.ResultKt.b(r7)
            goto L45
        L26:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f35684c
            androidx.datastore.core.WriteScope r7 = (androidx.datastore.core.WriteScope) r7
            kotlin.jvm.internal.Ref$IntRef r1 = r6.f35685d
            androidx.datastore.core.DataStoreImpl r4 = r6.f35686f
            androidx.datastore.core.InterProcessCoordinator r4 = androidx.datastore.core.DataStoreImpl.c(r4)
            r6.f35684c = r7
            r6.f35682a = r1
            r6.f35683b = r3
            java.lang.Object r3 = r4.e(r6)
            if (r3 != r0) goto L42
            goto L5c
        L42:
            r5 = r3
            r3 = r7
            r7 = r5
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r1.f140142a = r7
            java.lang.Object r7 = r6.f35687g
            r1 = 0
            r6.f35684c = r1
            r6.f35682a = r1
            r6.f35683b = r2
            java.lang.Object r7 = r3.a(r7, r6)
            if (r7 != r0) goto L5d
        L5c:
            return r0
        L5d:
            boolean r7 = r6.f35688h
            if (r7 == 0) goto L7d
            androidx.datastore.core.DataStoreImpl r7 = r6.f35686f
            androidx.datastore.core.DataStoreInMemoryCache r7 = androidx.datastore.core.DataStoreImpl.d(r7)
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            java.lang.Object r1 = r6.f35687g
            if (r1 == 0) goto L72
            int r2 = r1.hashCode()
            goto L73
        L72:
            r2 = 0
        L73:
            kotlin.jvm.internal.Ref$IntRef r3 = r6.f35685d
            int r3 = r3.f140142a
            r0.<init>(r1, r2, r3)
            r7.c(r0)
        L7d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$writeData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
