package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatus;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
public final class LogErrorsKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt", f = "LogErrors.kt", l = {21}, m = "logErrors")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogErrorsKt.logErrors(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$2", f = "LogErrors.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Throwable $error;
        final /* synthetic */ PresentationRequest $request;
        final /* synthetic */ Superwall $this_logErrors;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$2$1", f = "LogErrors.kt", l = {31}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Throwable $error;
            final /* synthetic */ PresentationRequest $request;
            final /* synthetic */ Superwall $this_logErrors;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PresentationRequest presentationRequest, Throwable th, Superwall superwall, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$request = presentationRequest;
                this.$error = th;
                this.$this_logErrors = superwall;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$request, this.$error, this.$this_logErrors, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    InternalSuperwallEvent.PresentationRequest presentationRequest = new InternalSuperwallEvent.PresentationRequest(this.$request.getPresentationInfo().getEventData(), this.$request.getFlags().getType(), PaywallPresentationRequestStatus.NoPresentation.INSTANCE, (PaywallPresentationRequestStatusReason) this.$error, this.$this_logErrors.getDependencyContainer$superwall_release(), null, 32, null);
                    Superwall superwall = this.$this_logErrors;
                    this.label = 1;
                    if (TrackingKt.track(superwall, presentationRequest, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    ((Result) obj).j();
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PresentationRequest presentationRequest, Throwable th, Superwall superwall, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = presentationRequest;
            this.$error = th;
            this.$this_logErrors = superwall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$request, this.$error, this.$this_logErrors, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return BuildersKt__Builders_commonKt.d((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$request, this.$error, this.$this_logErrors, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object logErrors(com.superwall.sdk.Superwall r8, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r9, java.lang.Throwable r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$1 r0 = (com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$1 r0 = new com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            r10 = r8
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.b(r11)
            goto L52
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r11)
            boolean r11 = r10 instanceof com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason
            if (r11 == 0) goto L52
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.b()
            com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$2 r2 = new com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt$logErrors$2
            r4 = 0
            r2.<init>(r9, r10, r8, r4)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r11, r2, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.info
            com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.paywallPresentation
            boolean r8 = r10 instanceof com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason
            if (r8 == 0) goto L7c
            r8 = r10
            com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason r8 = (com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason) r8
            java.lang.String r9 = r8.getDescription()
            java.lang.String r8 = r8.getInfo()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " - "
            r11.append(r9)
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            goto L80
        L7c:
            java.lang.String r8 = r10.getMessage()
        L80:
            java.lang.String r9 = kotlin.ExceptionsKt.b(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Skipped paywall presentation: "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = ", "
            r10.append(r8)
            r10.append(r9)
            java.lang.String r3 = r10.toString()
            r6 = 24
            r7 = 0
            r4 = 0
            r5 = 0
            com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt.logErrors(com.superwall.sdk.Superwall, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
