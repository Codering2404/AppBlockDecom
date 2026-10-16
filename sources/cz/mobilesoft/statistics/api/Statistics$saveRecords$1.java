package cz.mobilesoft.statistics.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.statistics.api.Statistics$saveRecords$1", f = "Statistics.kt", l = {59, 72, 78}, m = "invokeSuspend", v = 1)
final class Statistics$saveRecords$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f133579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f133580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f133581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f133582d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f133583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f133584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f133585h;

    /* JADX INFO: renamed from: cz.mobilesoft.statistics.api.Statistics$saveRecords$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.statistics.api.Statistics$saveRecords$1$3", f = "Statistics.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f133588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f133589b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List list, Continuation continuation) {
            super(1, continuation);
            this.f133589b = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass3(this.f133589b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f133588a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Statistics.f133571a.O().N(this.f133589b);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.statistics.api.Statistics$saveRecords$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.statistics.api.Statistics$saveRecords$1$4", f = "Statistics.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f133590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f133591b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.f133591b = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass4(this.f133591b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f133590a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function0 function0 = this.f133591b;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Statistics$saveRecords$1(List list, Function0 function0, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.f133583f = list;
        this.f133584g = function0;
        this.f133585h = function02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Throwable th) {
        Function1 function1L = Statistics.L();
        if (function1L != null) {
            function1L.invoke(th);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Statistics$saveRecords$1(this.f133583f, this.f133584g, this.f133585h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a1, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r13, r3, r12) != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f133582d
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L39
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L24
            if (r1 != r2) goto L1c
            java.lang.Object r0 = r12.f133579a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r13)
            r11 = r12
            goto La4
        L1c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L24:
            java.lang.Object r1 = r12.f133579a
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r13)
            r11 = r12
            goto L8a
        L2d:
            java.lang.Object r1 = r12.f133580b
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            java.lang.Object r1 = r12.f133579a
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r13)
            goto L6a
        L39:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.statistics.api.Statistics r13 = cz.mobilesoft.statistics.api.Statistics.f133571a
            cz.mobilesoft.statistics.util.Transformer r13 = cz.mobilesoft.statistics.api.Statistics.b(r13)
            java.util.List r1 = r12.f133583f
            java.util.List r1 = r13.a(r1)
            kotlin.jvm.functions.Function0 r13 = r12.f133584g
            if (r13 == 0) goto L6a
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.statistics.api.Statistics$saveRecords$1$1$1 r7 = new cz.mobilesoft.statistics.api.Statistics$saveRecords$1$1$1
            r7.<init>(r13, r5)
            r12.f133579a = r1
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
            r12.f133580b = r13
            r13 = 0
            r12.f133581c = r13
            r12.f133582d = r4
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.g(r6, r7, r12)
            if (r13 != r0) goto L6a
            r11 = r12
            goto La3
        L6a:
            cz.mobilesoft.statistics.api.b r9 = new cz.mobilesoft.statistics.api.b
            r9.<init>()
            cz.mobilesoft.statistics.api.Statistics$saveRecords$1$3 r10 = new cz.mobilesoft.statistics.api.Statistics$saveRecords$1$3
            r10.<init>(r1, r5)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r12.f133579a = r13
            r12.f133580b = r5
            r12.f133582d = r3
            r6 = 20
            r7 = 1000(0x3e8, double:4.94E-321)
            r11 = r12
            java.lang.Object r13 = cz.mobilesoft.statistics.util.StatisticsDatabaseExtKt.a(r6, r7, r9, r10, r11)
            if (r13 != r0) goto L8a
            goto La3
        L8a:
            kotlinx.coroutines.MainCoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.statistics.api.Statistics$saveRecords$1$4 r3 = new cz.mobilesoft.statistics.api.Statistics$saveRecords$1$4
            kotlin.jvm.functions.Function0 r4 = r11.f133585h
            r3.<init>(r4, r5)
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r11.f133579a = r1
            r11.f133582d = r2
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.g(r13, r3, r12)
            if (r13 != r0) goto La4
        La3:
            return r0
        La4:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.statistics.api.Statistics$saveRecords$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((Statistics$saveRecords$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
