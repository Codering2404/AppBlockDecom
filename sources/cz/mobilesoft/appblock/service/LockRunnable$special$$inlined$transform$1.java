package cz.mobilesoft.appblock.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1", f = "LockRunnable.kt", l = {36}, m = "invokeSuspend", v = 1)
public final class LockRunnable$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f94501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f94502c;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowCollector f94503a;

        /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1$1", f = "LockRunnable.kt", l = {40}, m = "emit", v = 1)
        public static final class C02601 extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f94504a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f94505b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f94507d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f94508f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f94509g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            boolean f94510h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f94511i;

            public C02601(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f94504a = obj;
                this.f94505b |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector) {
            this.f94503a = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1.AnonymousClass1.C02601
                if (r0 == 0) goto L13
                r0 = r8
                cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1$1$1 r0 = (cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1.AnonymousClass1.C02601) r0
                int r1 = r0.f94505b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f94505b = r1
                goto L18
            L13:
                cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1$1$1 r0 = new cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1$1$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f94504a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f94505b
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r7 = r0.f94509g
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                java.lang.Object r7 = r0.f94508f
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                kotlin.ResultKt.b(r8)
                goto L73
            L31:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L39:
                kotlin.ResultKt.b(r8)
                kotlinx.coroutines.flow.FlowCollector r8 = r6.f94503a
                r2 = r7
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "should send: "
                r4.append(r5)
                r4.append(r2)
                java.lang.String r4 = r4.toString()
                java.lang.String r5 = "SendContactSupportDetailedRequestUseCase"
                android.util.Log.d(r5, r4)
                java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
                r0.f94507d = r7
                r0.f94508f = r0
                r0.f94509g = r8
                r0.f94510h = r2
                r7 = 0
                r0.f94511i = r7
                r0.f94505b = r3
                java.lang.Object r7 = r8.emit(r4, r0)
                if (r7 != r1) goto L73
                return r1
            L73:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockRunnable$special$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockRunnable$special$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f94502c = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LockRunnable$special$$inlined$transform$1 lockRunnable$special$$inlined$transform$1 = new LockRunnable$special$$inlined$transform$1(this.f94502c, continuation);
        lockRunnable$special$$inlined$transform$1.f94501b = obj;
        return lockRunnable$special$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94500a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f94501b;
            Flow flow = this.f94502c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector);
            this.f94501b = flowCollector;
            this.f94500a = 1;
            if (flow.collect(anonymousClass1, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((LockRunnable$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
