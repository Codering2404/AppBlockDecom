package cz.mobilesoft.statistics.di;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.statistics.di.Repository$updateApplicationsToInsights$2", f = "Repository.kt", l = {29}, m = "invokeSuspend", v = 1)
final class Repository$updateApplicationsToInsights$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f133682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f133683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f133684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f133685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f133686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f133687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f133688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f133689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ List f133690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Repository f133691k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Repository$updateApplicationsToInsights$2(List list, Repository repository, Continuation continuation) {
        super(1, continuation);
        this.f133690j = list;
        this.f133691k = repository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Repository$updateApplicationsToInsights$2(this.f133690j, this.f133691k, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0074 -> B:14:0x0077). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f133689i
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 != r3) goto L22
            int r1 = r12.f133687g
            java.lang.Object r4 = r12.f133686f
            cz.mobilesoft.statistics.api.AppWithCategoryAndType r4 = (cz.mobilesoft.statistics.api.AppWithCategoryAndType) r4
            java.lang.Object r5 = r12.f133684c
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r12.f133683b
            cz.mobilesoft.statistics.di.Repository r6 = (cz.mobilesoft.statistics.di.Repository) r6
            java.lang.Object r7 = r12.f133682a
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            kotlin.ResultKt.b(r13)
            goto L77
        L22:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L2a:
            kotlin.ResultKt.b(r13)
            java.util.List r13 = r12.f133690j
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            cz.mobilesoft.statistics.di.Repository r1 = r12.f133691k
            java.util.Iterator r4 = r13.iterator()
            r7 = r13
            r6 = r1
            r1 = r2
            r5 = r4
        L3b:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto L92
            java.lang.Object r13 = r5.next()
            r4 = r13
            cz.mobilesoft.statistics.api.AppWithCategoryAndType r4 = (cz.mobilesoft.statistics.api.AppWithCategoryAndType) r4
            cz.mobilesoft.statistics.model.datasource.StatisticsDatabase r8 = cz.mobilesoft.statistics.di.Repository.a(r6)
            cz.mobilesoft.statistics.model.dao.RecordDao r8 = r8.p()
            java.lang.String r9 = r4.c()
            java.lang.String r10 = r4.b()
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r12.f133682a = r11
            r12.f133683b = r6
            r12.f133684c = r5
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r12.f133685d = r13
            r12.f133686f = r4
            r12.f133687g = r1
            r12.f133688h = r2
            r12.f133689i = r3
            java.lang.Object r13 = r8.s(r9, r10, r12)
            if (r13 != r0) goto L77
            return r0
        L77:
            java.lang.String r13 = r4.a()
            if (r13 == 0) goto L3b
            cz.mobilesoft.statistics.model.datasource.StatisticsDatabase r8 = cz.mobilesoft.statistics.di.Repository.a(r6)
            cz.mobilesoft.statistics.model.dao.ApplicationAppTypeDao r8 = r8.n()
            cz.mobilesoft.statistics.model.ApplicationAppType r9 = new cz.mobilesoft.statistics.model.ApplicationAppType
            java.lang.String r4 = r4.c()
            r9.<init>(r4, r13)
            r8.i(r9)
            goto L3b
        L92:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.di.Repository$updateApplicationsToInsights$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((Repository$updateApplicationsToInsights$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
