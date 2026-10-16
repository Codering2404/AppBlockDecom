package com.superwall.sdk.paywall.presentation.internal;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class GetPaywallComponentsKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$confirmAssignment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt", f = "GetPaywallComponents.kt", l = {72, 73, 77, 79}, m = "confirmAssignment")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetPaywallComponentsKt.confirmAssignment(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$getPaywallComponents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt", f = "GetPaywallComponents.kt", l = {19}, m = "getPaywallComponents")
    static final class C28421 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28421(Continuation<? super C28421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object paywallComponents = GetPaywallComponentsKt.getPaywallComponents(null, null, null, this);
            return paywallComponents == IntrinsicsKt.f() ? paywallComponents : Result.a(paywallComponents);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$getPaywallComponentsSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$getPaywallComponentsSync$1", f = "GetPaywallComponents.kt", l = {105}, m = "invokeSuspend")
    static final class C28431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends PaywallComponents>>, Object> {
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        final /* synthetic */ PresentationRequest $request;
        final /* synthetic */ Superwall $this_getPaywallComponentsSync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28431(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super C28431> continuation) {
            super(2, continuation);
            this.$this_getPaywallComponentsSync = superwall;
            this.$request = presentationRequest;
            this.$publisher = mutableSharedFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28431(this.$this_getPaywallComponentsSync, this.$request, this.$publisher, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objRunGetPaywallComponents;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                GetPaywallComponentsFactory getPaywallComponentsFactory$superwall_release = this.$this_getPaywallComponentsSync.getDependencyContainer$superwall_release().getGetPaywallComponentsFactory$superwall_release();
                PresentationRequest presentationRequest = this.$request;
                MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
                this.label = 1;
                objRunGetPaywallComponents = GetPaywallComponentsKt.runGetPaywallComponents(getPaywallComponentsFactory$superwall_release, presentationRequest, mutableSharedFlow, this);
                if (objRunGetPaywallComponents == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objRunGetPaywallComponents = ((Result) obj).j();
            }
            return Result.a(objRunGetPaywallComponents);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<PaywallComponents>> continuation) {
            return ((C28431) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$runGetPaywallComponents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt", f = "GetPaywallComponents.kt", l = {31, 34, 36, 39, 42, 45, 52}, m = "runGetPaywallComponents")
    static final class C28441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C28441(Continuation<? super C28441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objRunGetPaywallComponents = GetPaywallComponentsKt.runGetPaywallComponents(null, null, null, this);
            return objRunGetPaywallComponents == IntrinsicsKt.f() ? objRunGetPaywallComponents : Result.a(objRunGetPaywallComponents);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c7, code lost:
    
        if (r2.confirmPaywallAssignment(r8, r9, r10, r0) != r1) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095 A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:15:0x0033, B:46:0x00cc, B:47:0x00d9, B:20:0x004a, B:42:0x00aa, B:23:0x0056, B:37:0x008f, B:39:0x0095, B:49:0x00df, B:50:0x00e6, B:27:0x006c, B:33:0x0080, B:30:0x0073), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df A[Catch: all -> 0x00e7, TryCatch #0 {all -> 0x00e7, blocks: (B:15:0x0033, B:46:0x00cc, B:47:0x00d9, B:20:0x004a, B:42:0x00aa, B:23:0x0056, B:37:0x008f, B:39:0x0095, B:49:0x00df, B:50:0x00e6, B:27:0x006c, B:33:0x0080, B:30:0x0073), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object confirmAssignment(com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory r8, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r9, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.assignment.ConfirmedAssignment, java.lang.Throwable>> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.confirmAssignment(com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPaywallComponents(com.superwall.sdk.Superwall r4, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r5, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r6, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents>> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.C28421
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$getPaywallComponents$1 r0 = (com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.C28421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$getPaywallComponents$1 r0 = new com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt$getPaywallComponents$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r4 = r7.j()
            return r4
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.b(r7)
            com.superwall.sdk.dependencies.DependencyContainer r4 = r4.getDependencyContainer$superwall_release()
            com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory r4 = r4.getGetPaywallComponentsFactory$superwall_release()
            r0.label = r3
            java.lang.Object r4 = runGetPaywallComponents(r4, r5, r6, r0)
            if (r4 != r1) goto L4b
            return r1
        L4b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.getPaywallComponents(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getPaywallComponents$default(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, Continuation continuation, int i3, Object obj) throws Throwable {
        if ((i3 & 2) != 0) {
            mutableSharedFlow = null;
        }
        return getPaywallComponents(superwall, presentationRequest, mutableSharedFlow, continuation);
    }

    public static final Object getPaywallComponentsSync(Superwall superwall, PresentationRequest request, MutableSharedFlow<PaywallState> mutableSharedFlow) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        return ((Result) BuildersKt__BuildersKt.b(null, new C28431(superwall, request, mutableSharedFlow, null), 1, null)).j();
    }

    public static /* synthetic */ Object getPaywallComponentsSync$default(Superwall superwall, PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            mutableSharedFlow = null;
        }
        return getPaywallComponentsSync(superwall, presentationRequest, mutableSharedFlow);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9 A[PHI: r0 r1 r2 r5 r6
      0x00a9: PHI (r0v25 com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome) = 
      (r0v22 com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome)
      (r0v28 com.superwall.sdk.paywall.presentation.rule_logic.RuleEvaluationOutcome)
     binds: [B:47:0x0153, B:24:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r1v20 java.util.Map<java.lang.String, ? extends java.lang.Object>) = 
      (r1v17 java.util.Map<java.lang.String, ? extends java.lang.Object>)
      (r1v23 java.util.Map<java.lang.String, ? extends java.lang.Object>)
     binds: [B:47:0x0153, B:24:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r2v14 kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState>) = 
      (r2v11 kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState>)
      (r2v16 kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState>)
     binds: [B:47:0x0153, B:24:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r5v12 com.superwall.sdk.paywall.presentation.internal.PresentationRequest) = 
      (r5v9 com.superwall.sdk.paywall.presentation.internal.PresentationRequest)
      (r5v15 com.superwall.sdk.paywall.presentation.internal.PresentationRequest)
     binds: [B:47:0x0153, B:24:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x00a9: PHI (r6v1 com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory) = 
      (r6v0 com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory)
      (r6v4 com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory)
     binds: [B:47:0x0153, B:24:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca A[PHI: r0 r1 r2 r3 r5
      0x00ca: PHI (r0v20 java.util.Map<java.lang.String, ? extends java.lang.Object>) = 
      (r0v17 java.util.Map<java.lang.String, ? extends java.lang.Object>)
      (r0v24 java.util.Map<java.lang.String, ? extends java.lang.Object>)
     binds: [B:44:0x0138, B:27:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r1v16 kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState>) = 
      (r1v13 kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState>)
      (r1v19 kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState>)
     binds: [B:44:0x0138, B:27:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r2v10 com.superwall.sdk.paywall.presentation.internal.PresentationRequest) = 
      (r2v7 com.superwall.sdk.paywall.presentation.internal.PresentationRequest)
      (r2v13 com.superwall.sdk.paywall.presentation.internal.PresentationRequest)
     binds: [B:44:0x0138, B:27:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r3v7 java.lang.Object) = (r3v6 java.lang.Object), (r3v11 java.lang.Object) binds: [B:44:0x0138, B:27:0x00c1] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r5v8 com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory) = 
      (r5v5 com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory)
      (r5v11 com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory)
     binds: [B:44:0x0138, B:27:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bc A[Catch: all -> 0x01d1, TryCatch #0 {all -> 0x01d1, blocks: (B:14:0x0046, B:61:0x01b2, B:63:0x01bc, B:66:0x01c2, B:67:0x01c6, B:18:0x0064, B:57:0x018b, B:21:0x0083, B:53:0x016c, B:24:0x00a6, B:49:0x0156, B:27:0x00c1, B:46:0x013c, B:30:0x00e0, B:43:0x0129, B:33:0x00f0, B:39:0x010d, B:36:0x00fc), top: B:85:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c2 A[Catch: all -> 0x01d1, TryCatch #0 {all -> 0x01d1, blocks: (B:14:0x0046, B:61:0x01b2, B:63:0x01bc, B:66:0x01c2, B:67:0x01c6, B:18:0x0064, B:57:0x018b, B:21:0x0083, B:53:0x016c, B:24:0x00a6, B:49:0x0156, B:27:0x00c1, B:46:0x013c, B:30:0x00e0, B:43:0x0129, B:33:0x00f0, B:39:0x010d, B:36:0x00fc), top: B:85:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object runGetPaywallComponents(com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory r19, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r20, kotlinx.coroutines.flow.MutableSharedFlow<com.superwall.sdk.paywall.presentation.internal.state.PaywallState> r21, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.presentation.get_paywall.PaywallComponents>> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsKt.runGetPaywallComponents(com.superwall.sdk.paywall.presentation.internal.GetPaywallComponentsFactory, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, kotlinx.coroutines.flow.MutableSharedFlow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object runGetPaywallComponents$default(GetPaywallComponentsFactory getPaywallComponentsFactory, PresentationRequest presentationRequest, MutableSharedFlow mutableSharedFlow, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            mutableSharedFlow = null;
        }
        return runGetPaywallComponents(getPaywallComponentsFactory, presentationRequest, mutableSharedFlow, continuation);
    }
}
