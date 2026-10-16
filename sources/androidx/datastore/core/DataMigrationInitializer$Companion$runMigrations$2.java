package androidx.datastore.core;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
final class DataMigrationInitializer$Companion$runMigrations$2 extends SuspendLambda implements Function2<Object, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f35530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f35531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f35532d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f35533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f35534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ List f35535h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$2(List list, List list2, Continuation continuation) {
        super(2, continuation);
        this.f35534g = list;
        this.f35535h = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DataMigrationInitializer$Companion$runMigrations$2 dataMigrationInitializer$Companion$runMigrations$2 = new DataMigrationInitializer$Companion$runMigrations$2(this.f35534g, this.f35535h, continuation);
        dataMigrationInitializer$Companion$runMigrations$2.f35533f = obj;
        return dataMigrationInitializer$Companion$runMigrations$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f35532d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L37
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r9.f35529a
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r9.f35533f
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.b(r10)
            goto L46
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            java.lang.Object r1 = r9.f35531c
            java.lang.Object r4 = r9.f35530b
            androidx.datastore.core.DataMigration r4 = (androidx.datastore.core.DataMigration) r4
            java.lang.Object r5 = r9.f35529a
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r9.f35533f
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r10)
            r8 = r6
            r6 = r4
            r4 = r8
            goto L68
        L37:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.f35533f
            java.util.List r1 = r9.f35534g
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r4 = r9.f35535h
            java.util.Iterator r1 = r1.iterator()
        L46:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L8e
            java.lang.Object r5 = r1.next()
            androidx.datastore.core.DataMigration r5 = (androidx.datastore.core.DataMigration) r5
            r9.f35533f = r4
            r9.f35529a = r1
            r9.f35530b = r5
            r9.f35531c = r10
            r9.f35532d = r3
            java.lang.Object r6 = r5.a(r10, r9)
            if (r6 != r0) goto L63
            goto L89
        L63:
            r8 = r1
            r1 = r10
            r10 = r6
            r6 = r5
            r5 = r8
        L68:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L8c
            androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1 r10 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1
            r7 = 0
            r10.<init>(r6, r7)
            r4.add(r10)
            r9.f35533f = r4
            r9.f35529a = r5
            r9.f35530b = r7
            r9.f35531c = r7
            r9.f35532d = r2
            java.lang.Object r10 = r6.c(r1, r9)
            if (r10 != r0) goto L8a
        L89:
            return r0
        L8a:
            r1 = r5
            goto L46
        L8c:
            r10 = r1
            goto L8a
        L8e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation continuation) {
        return ((DataMigrationInitializer$Companion$runMigrations$2) create(obj, continuation)).invokeSuspend(Unit.f139807a);
    }
}
