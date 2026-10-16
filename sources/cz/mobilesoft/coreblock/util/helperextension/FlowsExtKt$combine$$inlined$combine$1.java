package cz.mobilesoft.coreblock.util.helperextension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;
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
public final class FlowsExtKt$combine$$inlined$combine$1 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Flow[] f128593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function8 f128594b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$1$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f128595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f128596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowsExtKt$combine$$inlined$combine$1 f128597c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f128595a = obj;
            this.f128596b |= Integer.MIN_VALUE;
            return this.f128597c.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$1$3", f = "FlowsExt.kt", l = {235, 234}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f128600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f128601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function8 f128602d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f128603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f128604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f128605h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f128606i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Continuation continuation, Function8 function8) {
            super(3, continuation);
            this.f128602d = function8;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.f128602d);
            anonymousClass3.f128600b = flowCollector;
            anonymousClass3.f128601c = objArr;
            return anonymousClass3.invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00a8, code lost:
        
            if (r1.emit(r15, r14) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r14.f128599a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3d
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                java.lang.Object r0 = r14.f128601c
                java.lang.Object[] r0 = (java.lang.Object[]) r0
                java.lang.Object r0 = r14.f128600b
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                kotlin.ResultKt.b(r15)
                r12 = r14
                goto Lab
            L1c:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L24:
                java.lang.Object r1 = r14.f128605h
                java.lang.Object[] r1 = (java.lang.Object[]) r1
                java.lang.Object r1 = r14.f128604g
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                java.lang.Object r1 = r14.f128603f
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r3 = r14.f128601c
                java.lang.Object[] r3 = (java.lang.Object[]) r3
                java.lang.Object r4 = r14.f128600b
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.ResultKt.b(r15)
                r12 = r14
                goto L8f
            L3d:
                kotlin.ResultKt.b(r15)
                java.lang.Object r15 = r14.f128600b
                r1 = r15
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r15 = r14.f128601c
                java.lang.Object[] r15 = (java.lang.Object[]) r15
                kotlin.jvm.functions.Function8 r4 = r14.f128602d
                r5 = 0
                r6 = r5
                r5 = r15[r6]
                r7 = r6
                r6 = r15[r3]
                r8 = r7
                r7 = r15[r2]
                r9 = 3
                r9 = r15[r9]
                r10 = 4
                r10 = r15[r10]
                r11 = 5
                r11 = r15[r11]
                r12 = 6
                r12 = r15[r12]
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
                r14.f128600b = r13
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r15)
                r14.f128601c = r13
                r14.f128603f = r1
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
                r14.f128604g = r13
                java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r15)
                r14.f128605h = r13
                r14.f128606i = r8
                r14.f128599a = r3
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r14
                java.lang.Object r3 = r4.f(r5, r6, r7, r8, r9, r10, r11, r12)
                if (r3 != r0) goto L8b
                goto Laa
            L8b:
                r4 = r3
                r3 = r15
                r15 = r4
                r4 = r1
            L8f:
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
                r12.f128600b = r4
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
                r12.f128601c = r3
                r3 = 0
                r12.f128603f = r3
                r12.f128604g = r3
                r12.f128605h = r3
                r12.f128599a = r2
                java.lang.Object r15 = r1.emit(r15, r14)
                if (r15 != r0) goto Lab
            Laa:
                return r0
            Lab:
                kotlin.Unit r15 = kotlin.Unit.f139807a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        final Flow[] flowArr = this.f128593a;
        Object objA = CombineKt.a(flowCollector, flowArr, new Function0<Object[]>() { // from class: cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt$combine$$inlined$combine$1.2
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object[] invoke() {
                return new Object[flowArr.length];
            }
        }, new AnonymousClass3(null, this.f128594b), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }
}
