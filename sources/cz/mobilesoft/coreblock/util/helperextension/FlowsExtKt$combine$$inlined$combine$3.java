package cz.mobilesoft.coreblock.util.helperextension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;

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
public final class FlowsExtKt$combine$$inlined$combine$3 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Flow[] f128621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function10 f128622b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$3$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f128623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f128624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowsExtKt$combine$$inlined$combine$3 f128625c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f128623a = obj;
            this.f128624b |= Integer.MIN_VALUE;
            return this.f128625c.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$3$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$3$3", f = "FlowsExt.kt", l = {235, 234}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f128628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f128629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function10 f128630d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f128631f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f128632g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f128633h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f128634i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Continuation continuation, Function10 function10) {
            super(3, continuation);
            this.f128630d = function10;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.f128630d);
            anonymousClass3.f128628b = flowCollector;
            anonymousClass3.f128629c = objArr;
            return anonymousClass3.invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00b4, code lost:
        
            if (r13.emit(r0, r17) == r11) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                r17 = this;
                r10 = r17
                java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r10.f128627a
                r12 = 2
                r1 = 1
                if (r0 == 0) goto L40
                if (r0 == r1) goto L25
                if (r0 != r12) goto L1d
                java.lang.Object r0 = r10.f128629c
                java.lang.Object[] r0 = (java.lang.Object[]) r0
                java.lang.Object r0 = r10.f128628b
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                kotlin.ResultKt.b(r18)
                goto Lb7
            L1d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L25:
                java.lang.Object r0 = r10.f128633h
                java.lang.Object[] r0 = (java.lang.Object[]) r0
                java.lang.Object r0 = r10.f128632g
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                java.lang.Object r0 = r10.f128631f
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = r10.f128629c
                java.lang.Object[] r1 = (java.lang.Object[]) r1
                java.lang.Object r2 = r10.f128628b
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.b(r18)
                r13 = r0
                r0 = r18
                goto L9a
            L40:
                kotlin.ResultKt.b(r18)
                java.lang.Object r0 = r10.f128628b
                r13 = r0
                kotlinx.coroutines.flow.FlowCollector r13 = (kotlinx.coroutines.flow.FlowCollector) r13
                java.lang.Object r0 = r10.f128629c
                r14 = r0
                java.lang.Object[] r14 = (java.lang.Object[]) r14
                kotlin.jvm.functions.Function10 r0 = r10.f128630d
                r2 = 0
                r3 = r14[r2]
                r4 = r14[r1]
                r5 = r3
                r3 = r14[r12]
                r6 = 3
                r6 = r14[r6]
                r7 = 4
                r7 = r14[r7]
                r8 = 5
                r8 = r14[r8]
                r9 = 6
                r9 = r14[r9]
                r15 = 7
                r15 = r14[r15]
                r16 = 8
                r16 = r14[r16]
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
                r10.f128628b = r12
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
                r10.f128629c = r12
                r10.f128631f = r13
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
                r10.f128632g = r12
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
                r10.f128633h = r12
                r10.f128634i = r2
                r10.f128627a = r1
                r2 = r4
                r1 = r5
                r4 = r6
                r5 = r7
                r6 = r8
                r7 = r9
                r8 = r15
                r9 = r16
                java.lang.Object r0 = r0.F(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                if (r0 != r11) goto L98
                goto Lb6
            L98:
                r2 = r13
                r1 = r14
            L9a:
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
                r10.f128628b = r2
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
                r10.f128629c = r1
                r1 = 0
                r10.f128631f = r1
                r10.f128632g = r1
                r10.f128633h = r1
                r1 = 2
                r10.f128627a = r1
                java.lang.Object r0 = r13.emit(r0, r10)
                if (r0 != r11) goto Lb7
            Lb6:
                return r11
            Lb7:
                kotlin.Unit r0 = kotlin.Unit.f139807a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$3.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        final Flow[] flowArr = this.f128621a;
        Object objA = CombineKt.a(flowCollector, flowArr, new Function0<Object[]>() { // from class: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$3.2
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new Object[flowArr.length];
            }
        }, new AnonymousClass3(null, this.f128622b), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }
}
