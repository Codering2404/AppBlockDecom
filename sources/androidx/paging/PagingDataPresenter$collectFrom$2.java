package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.PagingDataPresenter$collectFrom$2", f = "PagingDataPresenter.kt", l = {121}, m = "invokeSuspend")
final class PagingDataPresenter$collectFrom$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagingDataPresenter f50366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagingData f50367c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataPresenter$collectFrom$2(PagingDataPresenter pagingDataPresenter, PagingData pagingData, Continuation continuation) {
        super(1, continuation);
        this.f50366b = pagingDataPresenter;
        this.f50367c = pagingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PagingDataPresenter$collectFrom$2(this.f50366b, this.f50367c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50365a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f50366b.f50354c = this.f50367c.d();
            Flow flowB = this.f50367c.b();
            final PagingDataPresenter pagingDataPresenter = this.f50366b;
            final PagingData pagingData = this.f50367c;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.paging.PagingDataPresenter$collectFrom$2.1

                /* JADX INFO: renamed from: androidx.paging.PagingDataPresenter$collectFrom$2$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.paging.PagingDataPresenter$collectFrom$2$1$2", f = "PagingDataPresenter.kt", l = {141, 158, 170, 173, 225, 228}, m = "invokeSuspend")
                static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f50370a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ PageEvent f50371b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ PagingDataPresenter f50372c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ PagingData f50373d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass2(PageEvent pageEvent, PagingDataPresenter pagingDataPresenter, PagingData pagingData, Continuation continuation) {
                        super(2, continuation);
                        this.f50371b = pageEvent;
                        this.f50372c = pagingDataPresenter;
                        this.f50373d = pagingData;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new AnonymousClass2(this.f50371b, this.f50372c, this.f50373d, continuation);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
                    
                        if (r14 == r0) goto L91;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d0, code lost:
                    
                        if (r1.r(r2, r3, r4, true, r6, r7, r8, r9) == r0) goto L91;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:38:0x010a, code lost:
                    
                        if (r14.s(r1, r13) != r0) goto L40;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:90:0x0248, code lost:
                    
                        if (r14.s(r1, r13) != r0) goto L92;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:102:0x0293  */
                    /* JADX WARN: Removed duplicated region for block: B:105:0x02a3 A[LOOP:0: B:103:0x029d->B:105:0x02a3, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x00f7 A[PHI: r9
                      0x00f7: PHI (r9v4 androidx.paging.PagingDataPresenter$collectFrom$2$1$2) = 
                      (r9v0 androidx.paging.PagingDataPresenter$collectFrom$2$1$2)
                      (r9v0 androidx.paging.PagingDataPresenter$collectFrom$2$1$2)
                      (r9v5 androidx.paging.PagingDataPresenter$collectFrom$2$1$2)
                     binds: [B:33:0x00ea, B:35:0x00f3, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
                    /* JADX WARN: Removed duplicated region for block: B:89:0x0235 A[PHI: r9
                      0x0235: PHI (r9v8 androidx.paging.PagingDataPresenter$collectFrom$2$1$2) = 
                      (r9v0 androidx.paging.PagingDataPresenter$collectFrom$2$1$2)
                      (r9v0 androidx.paging.PagingDataPresenter$collectFrom$2$1$2)
                      (r9v9 androidx.paging.PagingDataPresenter$collectFrom$2$1$2)
                     binds: [B:85:0x0229, B:87:0x0232, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
                    /* JADX WARN: Removed duplicated region for block: B:98:0x028b  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                        /*
                            Method dump skipped, instruction units count: 706
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataPresenter$collectFrom$2.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(PageEvent pageEvent, Continuation continuation) {
                    PagingLogger pagingLogger = PagingLogger.f50484a;
                    if (pagingLogger.a(2)) {
                        pagingLogger.b(2, "Collected " + pageEvent, null);
                    }
                    Object objG = BuildersKt.g(pagingDataPresenter.f50352a, new AnonymousClass2(pageEvent, pagingDataPresenter, pagingData, null), continuation);
                    return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
                }
            };
            this.f50365a = 1;
            if (flowB.collect(flowCollector, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PagingDataPresenter$collectFrom$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
