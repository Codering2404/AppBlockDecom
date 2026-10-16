package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlinx.coroutines.flow.internal.CombineKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final /* synthetic */ class FlowKt__ZipKt {
    public static final Flow b(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt.J(flow, flow2, function3);
    }

    public static final Flow c(Flow flow, Flow flow2, Flow flow3, final Function4 function4) {
        final Flow[] flowArr = {flow, flow2, flow3};
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", l = {259, 258}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f142053a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f142054b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f142055c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function4 f142056d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Continuation continuation, Function4 function4) {
                    super(3, continuation);
                    this.f142056d = function4;
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.f142056d);
                    anonymousClass2.f142054b = flowCollector;
                    anonymousClass2.f142055c = objArr;
                    return anonymousClass2.invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
                
                    if (r1.emit(r8, r7) == r0) goto L15;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                    /*
                        r7 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r7.f142053a
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L22
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.b(r8)
                        goto L56
                    L12:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r0)
                        throw r8
                    L1a:
                        java.lang.Object r1 = r7.f142054b
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        kotlin.ResultKt.b(r8)
                        goto L4a
                    L22:
                        kotlin.ResultKt.b(r8)
                        java.lang.Object r8 = r7.f142054b
                        r1 = r8
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        java.lang.Object r8 = r7.f142055c
                        java.lang.Object[] r8 = (java.lang.Object[]) r8
                        kotlin.jvm.functions.Function4 r4 = r7.f142056d
                        r5 = 0
                        r5 = r8[r5]
                        r6 = r8[r3]
                        r8 = r8[r2]
                        r7.f142054b = r1
                        r7.f142053a = r3
                        r3 = 6
                        kotlin.jvm.internal.InlineMarker.c(r3)
                        java.lang.Object r8 = r4.invoke(r5, r6, r8, r7)
                        r3 = 7
                        kotlin.jvm.internal.InlineMarker.c(r3)
                        if (r8 != r0) goto L4a
                        goto L55
                    L4a:
                        r3 = 0
                        r7.f142054b = r3
                        r7.f142053a = r2
                        java.lang.Object r8 = r1.emit(r8, r7)
                        if (r8 != r0) goto L56
                    L55:
                        return r0
                    L56:
                        kotlin.Unit r8 = kotlin.Unit.f139807a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objA = CombineKt.a(flowCollector, flowArr, FlowKt__ZipKt.g(), new AnonymousClass2(null, function4), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        };
    }

    public static final Flow d(Flow flow, Flow flow2, Flow flow3, Flow flow4, final Function5 function5) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4};
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", l = {259, 258}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f142059a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f142060b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f142061c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function5 f142062d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Continuation continuation, Function5 function5) {
                    super(3, continuation);
                    this.f142062d = function5;
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.f142062d);
                    anonymousClass2.f142060b = flowCollector;
                    anonymousClass2.f142061c = objArr;
                    return anonymousClass2.invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
                
                    if (r1.emit(r11, r10) == r0) goto L15;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r10.f142059a
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L24
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L13
                        kotlin.ResultKt.b(r11)
                        r9 = r10
                        goto L5c
                    L13:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L1b:
                        java.lang.Object r1 = r10.f142060b
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        kotlin.ResultKt.b(r11)
                        r9 = r10
                        goto L50
                    L24:
                        kotlin.ResultKt.b(r11)
                        java.lang.Object r11 = r10.f142060b
                        r1 = r11
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        java.lang.Object r11 = r10.f142061c
                        java.lang.Object[] r11 = (java.lang.Object[]) r11
                        kotlin.jvm.functions.Function5 r4 = r10.f142062d
                        r5 = 0
                        r5 = r11[r5]
                        r6 = r11[r3]
                        r7 = r11[r2]
                        r8 = 3
                        r8 = r11[r8]
                        r10.f142060b = r1
                        r10.f142059a = r3
                        r11 = 6
                        kotlin.jvm.internal.InlineMarker.c(r11)
                        r9 = r10
                        java.lang.Object r11 = r4.invoke(r5, r6, r7, r8, r9)
                        r3 = 7
                        kotlin.jvm.internal.InlineMarker.c(r3)
                        if (r11 != r0) goto L50
                        goto L5b
                    L50:
                        r3 = 0
                        r9.f142060b = r3
                        r9.f142059a = r2
                        java.lang.Object r11 = r1.emit(r11, r10)
                        if (r11 != r0) goto L5c
                    L5b:
                        return r0
                    L5c:
                        kotlin.Unit r11 = kotlin.Unit.f139807a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objA = CombineKt.a(flowCollector, flowArr, FlowKt__ZipKt.g(), new AnonymousClass2(null, function5), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        };
    }

    public static final Flow e(Flow flow, Flow flow2, Flow flow3, Flow flow4, Flow flow5, final Function6 function6) {
        final Flow[] flowArr = {flow, flow2, flow3, flow4, flow5};
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", l = {259, 258}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f142065a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f142066b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f142067c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function6 f142068d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(Continuation continuation, Function6 function6) {
                    super(3, continuation);
                    this.f142068d = function6;
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation, this.f142068d);
                    anonymousClass2.f142066b = flowCollector;
                    anonymousClass2.f142067c = objArr;
                    return anonymousClass2.invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
                
                    if (r1.emit(r12, r11) == r0) goto L15;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                    /*
                        r11 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r11.f142065a
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L24
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L13
                        kotlin.ResultKt.b(r12)
                        r10 = r11
                        goto L5f
                    L13:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r0)
                        throw r12
                    L1b:
                        java.lang.Object r1 = r11.f142066b
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        kotlin.ResultKt.b(r12)
                        r10 = r11
                        goto L53
                    L24:
                        kotlin.ResultKt.b(r12)
                        java.lang.Object r12 = r11.f142066b
                        r1 = r12
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        java.lang.Object r12 = r11.f142067c
                        java.lang.Object[] r12 = (java.lang.Object[]) r12
                        kotlin.jvm.functions.Function6 r4 = r11.f142068d
                        r5 = 0
                        r5 = r12[r5]
                        r6 = r12[r3]
                        r7 = r12[r2]
                        r8 = 3
                        r8 = r12[r8]
                        r9 = 4
                        r9 = r12[r9]
                        r11.f142066b = r1
                        r11.f142065a = r3
                        r12 = 6
                        kotlin.jvm.internal.InlineMarker.c(r12)
                        r10 = r11
                        java.lang.Object r12 = r4.k(r5, r6, r7, r8, r9, r10)
                        r3 = 7
                        kotlin.jvm.internal.InlineMarker.c(r3)
                        if (r12 != r0) goto L53
                        goto L5e
                    L53:
                        r3 = 0
                        r10.f142066b = r3
                        r10.f142065a = r2
                        java.lang.Object r12 = r1.emit(r12, r11)
                        if (r12 != r0) goto L5f
                    L5e:
                        return r0
                    L5f:
                        kotlin.Unit r12 = kotlin.Unit.f139807a
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objA = CombineKt.a(flowCollector, flowArr, FlowKt__ZipKt.g(), new AnonymousClass2(null, function6), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        };
    }

    public static final Flow f(final Flow flow, final Flow flow2, final Function3 function3) {
        return new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objA = CombineKt.a(flowCollector, new Flow[]{flow, flow2}, FlowKt__ZipKt.g(), new FlowKt__ZipKt$combine$1$1(function3, null), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 g() {
        return new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Void invoke() {
                return null;
            }
        };
    }
}
