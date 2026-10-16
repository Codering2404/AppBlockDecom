package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", l = {370, 371}, m = "invokeSuspend")
final class DataStoreImpl$readDataOrHandleCorruption$2<T> extends SuspendLambda implements Function2<Boolean, Continuation<? super Data<T>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ boolean f35649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35650d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f35651f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataOrHandleCorruption$2(DataStoreImpl dataStoreImpl, int i3, Continuation continuation) {
        super(2, continuation);
        this.f35650d = dataStoreImpl;
        this.f35651f = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$2 = new DataStoreImpl$readDataOrHandleCorruption$2(this.f35650d, this.f35651f, continuation);
        dataStoreImpl$readDataOrHandleCorruption$2.f35649c = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataOrHandleCorruption$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f35648b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r0 = r5.f35647a
            kotlin.ResultKt.b(r6)
            goto L49
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            boolean r1 = r5.f35649c
            kotlin.ResultKt.b(r6)
            goto L34
        L22:
            kotlin.ResultKt.b(r6)
            boolean r1 = r5.f35649c
            androidx.datastore.core.DataStoreImpl r6 = r5.f35650d
            r5.f35649c = r1
            r5.f35648b = r3
            java.lang.Object r6 = androidx.datastore.core.DataStoreImpl.m(r6, r5)
            if (r6 != r0) goto L34
            goto L46
        L34:
            if (r1 == 0) goto L50
            androidx.datastore.core.DataStoreImpl r1 = r5.f35650d
            androidx.datastore.core.InterProcessCoordinator r1 = androidx.datastore.core.DataStoreImpl.c(r1)
            r5.f35647a = r6
            r5.f35648b = r2
            java.lang.Object r1 = r1.a(r5)
            if (r1 != r0) goto L47
        L46:
            return r0
        L47:
            r0 = r6
            r6 = r1
        L49:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            goto L55
        L50:
            int r0 = r5.f35651f
            r4 = r0
            r0 = r6
            r6 = r4
        L55:
            androidx.datastore.core.Data r1 = new androidx.datastore.core.Data
            if (r0 == 0) goto L5e
            int r2 = r0.hashCode()
            goto L5f
        L5e:
            r2 = 0
        L5f:
            r1.<init>(r0, r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(boolean z2, Continuation continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$2) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
    }
}
