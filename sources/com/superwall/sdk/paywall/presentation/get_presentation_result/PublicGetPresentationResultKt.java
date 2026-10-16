package com.superwall.sdk.paywall.presentation.get_presentation_result;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.result.PresentationResult;
import java.util.Map;
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
public final class PublicGetPresentationResultKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$getPresentationResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt", f = "PublicGetPresentationResult.kt", l = {43}, m = "getPresentationResult")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object presentationResult = PublicGetPresentationResultKt.getPresentationResult(null, null, null, this);
            return presentationResult == IntrinsicsKt.f() ? presentationResult : Result.a(presentationResult);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$getPresentationResultSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$getPresentationResultSync$1", f = "PublicGetPresentationResult.kt", l = {69}, m = "invokeSuspend")
    static final class C28401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends PresentationResult>>, Object> {
        final /* synthetic */ Map<String, Object> $params;
        final /* synthetic */ String $placement;
        final /* synthetic */ Superwall $this_getPresentationResultSync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28401(Superwall superwall, String str, Map<String, ? extends Object> map, Continuation<? super C28401> continuation) {
            super(2, continuation);
            this.$this_getPresentationResultSync = superwall;
            this.$placement = str;
            this.$params = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28401(this.$this_getPresentationResultSync, this.$placement, this.$params, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object presentationResult;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.$this_getPresentationResultSync;
                String str = this.$placement;
                Map<String, Object> map = this.$params;
                this.label = 1;
                presentationResult = PublicGetPresentationResultKt.getPresentationResult(superwall, str, map, this);
                if (presentationResult == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                presentationResult = ((Result) obj).j();
            }
            return Result.a(presentationResult);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends PresentationResult>> continuation) {
            return ((C28401) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$internallyGetPresentationResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt", f = "PublicGetPresentationResult.kt", l = {81, 106}, m = "internallyGetPresentationResult")
    static final class C28411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C28411(Continuation<? super C28411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PublicGetPresentationResultKt.internallyGetPresentationResult(null, null, false, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPresentationResult(com.superwall.sdk.Superwall r4, java.lang.String r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.superwall.sdk.paywall.presentation.result.PresentationResult>> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$getPresentationResult$1 r0 = (com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$getPresentationResult$1 r0 = new com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$getPresentationResult$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L56
            goto L4e
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r7)
            java.util.HashMap r7 = new java.util.HashMap     // Catch: java.lang.Throwable -> L56
            if (r6 != 0) goto L3c
            java.util.Map r6 = kotlin.collections.MapsKt.emptyMap()     // Catch: java.lang.Throwable -> L56
        L3c:
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L56
            com.superwall.sdk.analytics.internal.trackable.UserInitiatedEvent$Track r6 = new com.superwall.sdk.analytics.internal.trackable.UserInitiatedEvent$Track     // Catch: java.lang.Throwable -> L56
            r2 = 0
            r6.<init>(r5, r2, r2, r7)     // Catch: java.lang.Throwable -> L56
            r0.label = r3     // Catch: java.lang.Throwable -> L56
            java.lang.Object r7 = internallyGetPresentationResult(r4, r6, r2, r0)     // Catch: java.lang.Throwable -> L56
            if (r7 != r1) goto L4e
            return r1
        L4e:
            com.superwall.sdk.paywall.presentation.result.PresentationResult r7 = (com.superwall.sdk.paywall.presentation.result.PresentationResult) r7     // Catch: java.lang.Throwable -> L56
            com.superwall.sdk.misc.Either$Success r4 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L56
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L56
            goto L72
        L56:
            r4 = move-exception
            boolean r5 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r4)
            if (r5 == 0) goto L6c
            com.superwall.sdk.Superwall$Companion r5 = com.superwall.sdk.Superwall.Companion
            boolean r6 = r5.getInitialized()
            if (r6 == 0) goto L6c
            com.superwall.sdk.Superwall r5 = r5.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r5, r4)
        L6c:
            com.superwall.sdk.misc.Either$Failure r5 = new com.superwall.sdk.misc.Either$Failure
            r5.<init>(r4)
            r4 = r5
        L72:
            boolean r5 = r4 instanceof com.superwall.sdk.misc.Either.Success
            if (r5 == 0) goto L84
            kotlin.Result$Companion r5 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Success r4 = (com.superwall.sdk.misc.Either.Success) r4
            java.lang.Object r4 = r4.getValue()
            java.lang.Object r4 = kotlin.Result.b(r4)
            goto L98
        L84:
            boolean r5 = r4 instanceof com.superwall.sdk.misc.Either.Failure
            if (r5 == 0) goto L99
            kotlin.Result$Companion r5 = kotlin.Result.f139772b
            com.superwall.sdk.misc.Either$Failure r4 = (com.superwall.sdk.misc.Either.Failure) r4
            java.lang.Throwable r4 = r4.getError()
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L98:
            return r4
        L99:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt.getPresentationResult(com.superwall.sdk.Superwall, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getPresentationResult$default(Superwall superwall, String str, Map map, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        return getPresentationResult(superwall, str, map, continuation);
    }

    public static final Object getPresentationResultSync(Superwall superwall, String placement, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(placement, "placement");
        return ((Result) BuildersKt__BuildersKt.b(null, new C28401(superwall, placement, map, null), 1, null)).j();
    }

    public static /* synthetic */ Object getPresentationResultSync$default(Superwall superwall, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        return getPresentationResultSync(superwall, str, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object internallyGetPresentationResult(com.superwall.sdk.Superwall r21, com.superwall.sdk.analytics.internal.trackable.Trackable r22, boolean r23, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.presentation.result.PresentationResult> r24) {
        /*
            r0 = r22
            r1 = r24
            boolean r2 = r1 instanceof com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt.C28411
            if (r2 == 0) goto L17
            r2 = r1
            com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$internallyGetPresentationResult$1 r2 = (com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt.C28411) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$internallyGetPresentationResult$1 r2 = new com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt$internallyGetPresentationResult$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L4d
            if (r4 == r6) goto L38
            if (r4 != r5) goto L30
            kotlin.ResultKt.b(r1)
            return r1
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            boolean r0 = r2.Z$0
            java.lang.Object r4 = r2.L$2
            java.util.Date r4 = (java.util.Date) r4
            java.lang.Object r6 = r2.L$1
            com.superwall.sdk.analytics.internal.trackable.Trackable r6 = (com.superwall.sdk.analytics.internal.trackable.Trackable) r6
            java.lang.Object r7 = r2.L$0
            com.superwall.sdk.Superwall r7 = (com.superwall.sdk.Superwall) r7
            kotlin.ResultKt.b(r1)
            r9 = r0
            r0 = r6
        L4b:
            r14 = r4
            goto L7e
        L4d:
            kotlin.ResultKt.b(r1)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            com.superwall.sdk.analytics.internal.TrackingLogic$Companion r1 = com.superwall.sdk.analytics.internal.TrackingLogic.Companion
            com.superwall.sdk.dependencies.DependencyContainer r7 = r21.getDependencyContainer$superwall_release()
            com.superwall.sdk.analytics.session.AppSessionManager r7 = r7.getAppSessionManager()
            com.superwall.sdk.analytics.session.AppSession r7 = r7.getAppSession()
            java.lang.String r7 = r7.getId()
            r8 = r21
            r2.L$0 = r8
            r2.L$1 = r0
            r2.L$2 = r4
            r9 = r23
            r2.Z$0 = r9
            r2.label = r6
            java.lang.Object r1 = r1.processParameters(r0, r7, r2)
            if (r1 != r3) goto L7c
            goto Lc6
        L7c:
            r7 = r8
            goto L4b
        L7e:
            com.superwall.sdk.analytics.internal.TrackingParameters r1 = (com.superwall.sdk.analytics.internal.TrackingParameters) r1
            com.superwall.sdk.models.events.EventData r10 = new com.superwall.sdk.models.events.EventData
            java.lang.String r12 = r0.getRawName()
            java.util.Map r13 = r1.getAudienceFilterParams()
            r15 = 1
            r16 = 0
            r11 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16)
            com.superwall.sdk.dependencies.DependencyContainer r11 = r7.getDependencyContainer$superwall_release()
            com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo$ExplicitTrigger r12 = new com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo$ExplicitTrigger
            r12.<init>(r10)
            r0 = 0
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            if (r9 == 0) goto La6
            com.superwall.sdk.paywall.presentation.internal.PresentationRequestType$GetImplicitPresentationResult r0 = com.superwall.sdk.paywall.presentation.internal.PresentationRequestType.GetImplicitPresentationResult.INSTANCE
        La3:
            r18 = r0
            goto La9
        La6:
            com.superwall.sdk.paywall.presentation.internal.PresentationRequestType$GetPresentationResult r0 = com.superwall.sdk.paywall.presentation.internal.PresentationRequestType.GetPresentationResult.INSTANCE
            goto La3
        La9:
            r19 = 22
            r20 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest r0 = com.superwall.sdk.dependencies.RequestFactory.DefaultImpls.makePresentationRequest$default(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r1 = 0
            r2.L$0 = r1
            r2.L$1 = r1
            r2.L$2 = r1
            r2.label = r5
            java.lang.Object r0 = com.superwall.sdk.paywall.presentation.get_presentation_result.InternalGetPresentationResultKt.getPresentationResult(r7, r0, r2)
            if (r0 != r3) goto Lc7
        Lc6:
            return r3
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.get_presentation_result.PublicGetPresentationResultKt.internallyGetPresentationResult(com.superwall.sdk.Superwall, com.superwall.sdk.analytics.internal.trackable.Trackable, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
