package cz.mobilesoft.coreblock.scene.onboarding;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1", f = "OnboardingViewModelV2.kt", l = {138}, m = "invokeSuspend", v = 1)
final class OnboardingViewModelV2$checkPendingDeeplink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2 f110975b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnboardingViewModelV2 f110976a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1$1$1", f = "OnboardingViewModelV2.kt", l = {150}, m = "invokeSuspend", v = 1)
        static final class C02941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f110977a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ OnboardingViewModelV2 f110978b;

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1$1$1$1", f = "OnboardingViewModelV2.kt", l = {}, m = "invokeSuspend", v = 1)
            static final class C02951 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f110979a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                /* synthetic */ boolean f110980b;

                C02951(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    C02951 c02951 = new C02951(continuation);
                    c02951.f110980b = ((Boolean) obj).booleanValue();
                    return c02951;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    boolean z2 = this.f110980b;
                    IntrinsicsKt.f();
                    if (this.f110979a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Boxing.a(!z2);
                }

                public final Object invoke(boolean z2, Continuation continuation) {
                    return ((C02951) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02941(OnboardingViewModelV2 onboardingViewModelV2, Continuation continuation) {
                super(2, continuation);
                this.f110978b = onboardingViewModelV2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02941(this.f110978b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f110977a;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return obj;
                }
                ResultKt.b(obj);
                Flow flowZ2 = this.f110978b.n1().Z2();
                C02951 c02951 = new C02951(null);
                this.f110977a = 1;
                Object objE = FlowKt.E(flowZ2, c02951, this);
                return objE == objF ? objF : objE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C02941) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(OnboardingViewModelV2 onboardingViewModelV2) {
            this.f110976a = onboardingViewModelV2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0148, code lost:
        
            if (r9.P0(r3, r0) != r1) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x01db, code lost:
        
            if (r3.P0(r4, r0) == r1) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x021b, code lost:
        
            if (r3.P0(r4, r0) == r1) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0262, code lost:
        
            if (r9.P0(r3, r0) != r1) goto L73;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0131 A[PHI: r2 r8
          0x0131: PHI (r2v23 java.lang.String) = (r2v20 java.lang.String), (r2v26 java.lang.String) binds: [B:33:0x012d, B:20:0x009e] A[DONT_GENERATE, DONT_INLINE]
          0x0131: PHI (r8v11 cz.mobilesoft.coreblock.util.DeeplinkResult) = (r8v8 cz.mobilesoft.coreblock.util.DeeplinkResult), (r8v16 cz.mobilesoft.coreblock.util.DeeplinkResult) binds: [B:33:0x012d, B:20:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01b2 A[PHI: r2 r8 r9
          0x01b2: PHI (r2v35 java.lang.String) = (r2v32 java.lang.String), (r2v39 java.lang.String) binds: [B:50:0x01ae, B:16:0x0068] A[DONT_GENERATE, DONT_INLINE]
          0x01b2: PHI (r8v30 cz.mobilesoft.coreblock.util.DeeplinkResult) = (r8v27 cz.mobilesoft.coreblock.util.DeeplinkResult), (r8v40 cz.mobilesoft.coreblock.util.DeeplinkResult) binds: [B:50:0x01ae, B:16:0x0068] A[DONT_GENERATE, DONT_INLINE]
          0x01b2: PHI (r9v16 java.lang.Object) = (r9v15 java.lang.Object), (r9v1 java.lang.Object) binds: [B:50:0x01ae, B:16:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 648
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1.AnonymousClass1.emit(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModelV2$checkPendingDeeplink$1(OnboardingViewModelV2 onboardingViewModelV2, Continuation continuation) {
        super(2, continuation);
        this.f110975b = onboardingViewModelV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OnboardingViewModelV2$checkPendingDeeplink$1(this.f110975b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f110974a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowM2 = this.f110975b.n1().M2();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f110975b);
            this.f110974a = 1;
            if (flowM2.collect(anonymousClass1, this) == objF) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OnboardingViewModelV2$checkPendingDeeplink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
