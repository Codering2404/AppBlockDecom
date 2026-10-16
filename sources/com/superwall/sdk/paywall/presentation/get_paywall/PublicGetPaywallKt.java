package com.superwall.sdk.paywall.presentation.get_paywall;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.TrackingResult;
import com.superwall.sdk.analytics.internal.trackable.UserInitiatedEvent;
import com.superwall.sdk.dependencies.DependencyContainer;
import com.superwall.sdk.dependencies.RequestFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.delegate.PaywallViewCallback;
import com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
public final class PublicGetPaywallKt {

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt", f = "PublicGetPaywall.kt", l = {52}, m = "getPaywall")
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
            Object paywall = PublicGetPaywallKt.getPaywall(null, null, null, null, null, this);
            return paywall == IntrinsicsKt.f() ? paywall : Result.a(paywall);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$2", f = "PublicGetPaywall.kt", l = {54}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends PaywallView>>, Object> {
        final /* synthetic */ PaywallViewCallback $delegate;
        final /* synthetic */ Map<String, Object> $params;
        final /* synthetic */ PaywallOverrides $paywallOverrides;
        final /* synthetic */ String $placement;
        final /* synthetic */ Superwall $this_getPaywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Superwall superwall, String str, Map<String, ? extends Object> map, PaywallOverrides paywallOverrides, PaywallViewCallback paywallViewCallback, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_getPaywall = superwall;
            this.$placement = str;
            this.$params = map;
            this.$paywallOverrides = paywallOverrides;
            this.$delegate = paywallViewCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_getPaywall, this.$placement, this.$params, this.$paywallOverrides, this.$delegate, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.$this_getPaywall;
                String str = this.$placement;
                Map<String, Object> map = this.$params;
                PaywallOverrides paywallOverrides = this.$paywallOverrides;
                PaywallViewDelegateAdapter paywallViewDelegateAdapter = new PaywallViewDelegateAdapter(this.$delegate);
                this.label = 1;
                obj = PublicGetPaywallKt.internallyGetPaywall(superwall, str, map, paywallOverrides, paywallViewDelegateAdapter, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Either either = (Either) obj;
            if (either instanceof Either.Success) {
                Either.Success success = (Either.Success) either;
                ((PaywallView) success.getValue()).prepareToDisplay();
                Result.Companion companion = Result.f139772b;
                objB = Result.b(success.getValue());
            } else {
                if (!(either instanceof Either.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (either instanceof Either.Success) {
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(((Either.Success) either).getValue());
                } else {
                    Result.Companion companion3 = Result.f139772b;
                    objB = Result.b(ResultKt.a(((Either.Failure) either).getError()));
                }
            }
            return Result.a(objB);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<PaywallView>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywallOrThrow$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywallOrThrow$2", f = "PublicGetPaywall.kt", l = {27}, m = "invokeSuspend")
    static final class C28382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaywallView>, Object> {
        final /* synthetic */ PaywallViewCallback $delegate;
        final /* synthetic */ Map<String, Object> $params;
        final /* synthetic */ PaywallOverrides $paywallOverrides;
        final /* synthetic */ String $placement;
        final /* synthetic */ Superwall $this_getPaywallOrThrow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28382(Superwall superwall, String str, Map<String, ? extends Object> map, PaywallOverrides paywallOverrides, PaywallViewCallback paywallViewCallback, Continuation<? super C28382> continuation) {
            super(2, continuation);
            this.$this_getPaywallOrThrow = superwall;
            this.$placement = str;
            this.$params = map;
            this.$paywallOverrides = paywallOverrides;
            this.$delegate = paywallViewCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28382(this.$this_getPaywallOrThrow, this.$placement, this.$params, this.$paywallOverrides, this.$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaywallView> continuation) {
            return ((C28382) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(jTYhJgqLBN.HwyHZwL);
                }
            } else {
                ResultKt.b(obj);
                Superwall superwall = this.$this_getPaywallOrThrow;
                String str = this.$placement;
                Map<String, Object> map = this.$params;
                PaywallOverrides paywallOverrides = this.$paywallOverrides;
                PaywallViewDelegateAdapter paywallViewDelegateAdapter = new PaywallViewDelegateAdapter(this.$delegate);
                this.label = 1;
                obj = PublicGetPaywallKt.internallyGetPaywall(superwall, str, map, paywallOverrides, paywallViewDelegateAdapter, this);
                if (obj == objF) {
                    return objF;
                }
            }
            Either either = (Either) obj;
            if (either instanceof Either.Success) {
                Result.Companion companion = Result.f139772b;
                objB = Result.b(((Either.Success) either).getValue());
            } else if (either instanceof Either.Failure) {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(ResultKt.a(((Either.Failure) either).getError()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ResultKt.b(objB);
            PaywallView paywallView = (PaywallView) objB;
            paywallView.prepareToDisplay();
            return paywallView;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$internallyGetPaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$internallyGetPaywall$2", f = "PublicGetPaywall.kt", l = {94, 109}, m = "invokeSuspend")
    static final class C28392 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends PaywallView, Throwable>>, Object> {
        final /* synthetic */ PaywallViewDelegateAdapter $delegate;
        final /* synthetic */ Map<String, Object> $params;
        final /* synthetic */ PaywallOverrides $paywallOverrides;
        final /* synthetic */ String $placement;
        final /* synthetic */ Superwall $this_internallyGetPaywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28392(Map<String, ? extends Object> map, String str, Superwall superwall, PaywallOverrides paywallOverrides, PaywallViewDelegateAdapter paywallViewDelegateAdapter, Continuation<? super C28392> continuation) {
            super(2, continuation);
            this.$params = map;
            this.$placement = str;
            this.$this_internallyGetPaywall = superwall;
            this.$paywallOverrides = paywallOverrides;
            this.$delegate = paywallViewDelegateAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28392(this.$params, this.$placement, this.$this_internallyGetPaywall, this.$paywallOverrides, this.$delegate, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objTrack;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Map<String, Object> mapEmptyMap = this.$params;
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                UserInitiatedEvent.Track track = new UserInitiatedEvent.Track(this.$placement, false, false, mapEmptyMap);
                Superwall superwall = this.$this_internallyGetPaywall;
                this.label = 1;
                objTrack = TrackingKt.track(superwall, track, this);
                if (objTrack != objF) {
                }
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            objTrack = ((Result) obj).j();
            if (Result.g(objTrack)) {
                Throwable thE = Result.e(objTrack);
                if (thE == null) {
                    thE = new IllegalStateException("Error in tracking event");
                }
                return new Either.Failure(thE);
            }
            DependencyContainer dependencyContainer$superwall_release = this.$this_internallyGetPaywall.getDependencyContainer$superwall_release();
            ResultKt.b(objTrack);
            PresentationRequest presentationRequestMakePresentationRequest$default = RequestFactory.DefaultImpls.makePresentationRequest$default(dependencyContainer$superwall_release, new PresentationInfo.ExplicitTrigger(((TrackingResult) objTrack).getData()), this.$paywallOverrides, null, null, null, false, new PresentationRequestType.GetPaywall(this.$delegate), 28, null);
            Superwall superwall2 = this.$this_internallyGetPaywall;
            this.label = 2;
            Object paywall$default = InternalGetPaywallKt.getPaywall$default(superwall2, presentationRequestMakePresentationRequest$default, null, this, 2, null);
            return paywall$default == objF ? objF : paywall$default;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<PaywallView, Throwable>> continuation) {
            return ((C28392) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @kotlin.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getPaywall(com.superwall.sdk.Superwall r12, java.lang.String r13, java.util.Map<java.lang.String, ? extends java.lang.Object> r14, com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides r15, com.superwall.sdk.paywall.view.delegate.PaywallViewCallback r16, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.paywall.view.PaywallView>> r17) throws java.lang.Throwable {
        /*
            r0 = r17
            boolean r1 = r0 instanceof com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt.AnonymousClass1
            if (r1 == 0) goto L15
            r1 = r0
            com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$1 r1 = (com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$1 r1 = new com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$1
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.ResultKt.b(r0)
            goto L4f
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
            com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$2 r5 = new com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt$getPaywall$2
            r11 = 0
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            r10 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.label = r4
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r5, r1)
            if (r0 != r2) goto L4f
            return r2
        L4f:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r12 = r0.j()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.presentation.get_paywall.PublicGetPaywallKt.getPaywall(com.superwall.sdk.Superwall, java.lang.String, java.util.Map, com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides, com.superwall.sdk.paywall.view.delegate.PaywallViewCallback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getPaywall$default(Superwall superwall, String str, Map map, PaywallOverrides paywallOverrides, PaywallViewCallback paywallViewCallback, Continuation continuation, int i3, Object obj) throws Throwable {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            paywallOverrides = null;
        }
        return getPaywall(superwall, str, map, paywallOverrides, paywallViewCallback, continuation);
    }

    @Deprecated
    public static final Object getPaywallOrThrow(Superwall superwall, String str, Map<String, ? extends Object> map, PaywallOverrides paywallOverrides, PaywallViewCallback paywallViewCallback, Continuation<? super PaywallView> continuation) throws Throwable {
        return BuildersKt.g(Dispatchers.c(), new C28382(superwall, str, map, paywallOverrides, paywallViewCallback, null), continuation);
    }

    public static /* synthetic */ Object getPaywallOrThrow$default(Superwall superwall, String str, Map map, PaywallOverrides paywallOverrides, PaywallViewCallback paywallViewCallback, Continuation continuation, int i3, Object obj) throws Throwable {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            paywallOverrides = null;
        }
        return getPaywallOrThrow(superwall, str, map, paywallOverrides, paywallViewCallback, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object internallyGetPaywall(Superwall superwall, String str, Map<String, ? extends Object> map, PaywallOverrides paywallOverrides, PaywallViewDelegateAdapter paywallViewDelegateAdapter, Continuation<? super Either<PaywallView, Throwable>> continuation) throws Throwable {
        return BuildersKt.g(Dispatchers.c(), new C28392(map, str, superwall, paywallOverrides, paywallViewDelegateAdapter, null), continuation);
    }

    static /* synthetic */ Object internallyGetPaywall$default(Superwall superwall, String str, Map map, PaywallOverrides paywallOverrides, PaywallViewDelegateAdapter paywallViewDelegateAdapter, Continuation continuation, int i3, Object obj) throws Throwable {
        if ((i3 & 2) != 0) {
            map = null;
        }
        if ((i3 & 4) != 0) {
            paywallOverrides = null;
        }
        return internallyGetPaywall(superwall, str, map, paywallOverrides, paywallViewDelegateAdapter, continuation);
    }
}
