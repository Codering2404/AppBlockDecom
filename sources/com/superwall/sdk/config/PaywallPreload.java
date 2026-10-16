package com.superwall.sdk.config;

import android.content.Context;
import androidx.compose.animation.core.h;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.dependencies.RequestFactory;
import com.superwall.sdk.dependencies.RuleAttributesFactory;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.ScopesKt;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.triggers.Trigger;
import com.superwall.sdk.paywall.manager.PaywallManager;
import com.superwall.sdk.paywall.presentation.rule_logic.javascript.RuleEvaluator;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.storage.LocalStorage;
import d.qFm.sECyKyO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class PaywallPreload {
    public static final Companion Companion = new Companion(null);
    private final Assignments assignments;
    private Job currentPreloadingTask;
    private final Factory factory;
    private final AtomicReference<String> lastFingerprint;
    private final PaywallManager paywallManager;
    private final IOScope scope;
    private final LocalStorage storage;
    private final Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> track;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<String> changedPaywallIds$superwall_release(Config oldConfig, Config newConfig) {
            Intrinsics.checkNotNullParameter(oldConfig, "oldConfig");
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            List<Paywall> paywalls = oldConfig.getPaywalls();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paywalls, 10));
            for (Paywall paywall : paywalls) {
                arrayList.add(TuplesKt.a(paywall.getIdentifier(), paywall.getCacheKey()));
            }
            Map map = MapsKt.toMap(arrayList);
            List<Paywall> paywalls2 = newConfig.getPaywalls();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(paywalls2, 10));
            for (Paywall paywall2 : paywalls2) {
                arrayList2.add(TuplesKt.a(paywall2.getIdentifier(), paywall2.getCacheKey()));
            }
            Map map2 = MapsKt.toMap(arrayList2);
            Set set = CollectionsKt.toSet(SetsKt.minus(map.keySet(), (Iterable) map2.keySet()));
            List<Paywall> paywalls3 = newConfig.getPaywalls();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : paywalls3) {
                Paywall paywall3 = (Paywall) obj;
                String str = (String) map.get(paywall3.getIdentifier());
                boolean zAreEqual = Intrinsics.areEqual(str, map2.get(paywall3.getIdentifier()));
                if (str != null && !zAreEqual) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            int size = arrayList3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList3.get(i3);
                i3++;
                arrayList4.add(((Paywall) obj2).getIdentifier());
            }
            return SetsKt.plus(set, (Iterable) arrayList4);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends RequestFactory, RuleAttributesFactory, RuleEvaluator.Factory {
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2", f = "PaywallPreload.kt", l = {71, 89, 95, 99, 105, 112}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Config $config;
        final /* synthetic */ Context $context;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Config config, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$config = config;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallPreload.this.new AnonymousClass2(this.$context, this.$config, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x017f, code lost:
        
            if (r1.preloadPaywalls((java.util.Set) r15, r14) != r0) goto L53;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0132 A[PHI: r1 r3 r4 r5 r8
          0x0132: PHI (r1v19 java.util.Set<com.superwall.sdk.models.triggers.Trigger>) = 
          (r1v16 java.util.Set<com.superwall.sdk.models.triggers.Trigger>)
          (r1v23 java.util.Set<com.superwall.sdk.models.triggers.Trigger>)
         binds: [B:38:0x012f, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]
          0x0132: PHI (r3v12 java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment$Variant>) = 
          (r3v9 java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment$Variant>)
          (r3v14 java.util.Map<java.lang.String, com.superwall.sdk.models.triggers.Experiment$Variant>)
         binds: [B:38:0x012f, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]
          0x0132: PHI (r4v6 java.util.Set<com.superwall.sdk.models.triggers.Trigger>) = 
          (r4v3 java.util.Set<com.superwall.sdk.models.triggers.Trigger>)
          (r4v9 java.util.Set<com.superwall.sdk.models.triggers.Trigger>)
         binds: [B:38:0x012f, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]
          0x0132: PHI (r5v5 com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating) = 
          (r5v2 com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating)
          (r5v7 com.superwall.sdk.paywall.presentation.rule_logic.expression_evaluator.ExpressionEvaluating)
         binds: [B:38:0x012f, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]
          0x0132: PHI (r8v10 com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2) = 
          (r8v8 com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2)
          (r8v11 com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2)
         binds: [B:38:0x012f, B:9:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0174 A[PHI: r8 r15
          0x0174: PHI (r8v17 com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2) = 
          (r8v14 com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2)
          (r8v18 com.superwall.sdk.config.PaywallPreload$preloadAllPaywalls$2)
         binds: [B:48:0x0171, B:7:0x0018] A[DONT_GENERATE, DONT_INLINE]
          0x0174: PHI (r15v17 java.lang.Object) = (r15v16 java.lang.Object), (r15v0 java.lang.Object) binds: [B:48:0x0171, B:7:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 412
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.PaywallPreload.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.PaywallPreload$preloadPaywalls$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.PaywallPreload", f = "PaywallPreload.kt", l = {134}, m = "preloadPaywalls")
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallPreload.this.preloadPaywalls(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2", f = "PaywallPreload.kt", l = {177, 178}, m = "invokeSuspend")
    static final class C27882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $paywallCount;
        final /* synthetic */ Set<String> $paywallIdentifiers;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PaywallPreload this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27882(Set<String> set, PaywallPreload paywallPreload, int i3, Continuation<? super C27882> continuation) {
            super(2, continuation);
            this.$paywallIdentifiers = set;
            this.this$0 = paywallPreload;
            this.$paywallCount = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C27882 c27882 = new C27882(this.$paywallIdentifiers, this.this$0, this.$paywallCount, continuation);
            c27882.L$0 = obj;
            return c27882;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            if (r11.invoke(r1, r10) == r0) goto L19;
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
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r11)
                goto L72
            L12:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1a:
                kotlin.ResultKt.b(r11)
                goto L5a
            L1e:
                kotlin.ResultKt.b(r11)
                java.lang.Object r11 = r10.L$0
                r4 = r11
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                java.util.Set<java.lang.String> r1 = r10.$paywallIdentifiers
                java.util.Iterator r1 = r1.iterator()
            L31:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L51
                java.lang.Object r5 = r1.next()
                java.lang.String r5 = (java.lang.String) r5
                com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2$task$1 r7 = new com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2$task$1
                com.superwall.sdk.config.PaywallPreload r6 = r10.this$0
                r8 = 0
                r7.<init>(r6, r5, r8)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.Deferred r5 = kotlinx.coroutines.BuildersKt.b(r4, r5, r6, r7, r8, r9)
                r11.add(r5)
                goto L31
            L51:
                r10.label = r3
                java.lang.Object r11 = kotlinx.coroutines.AwaitKt.a(r11, r10)
                if (r11 != r0) goto L5a
                goto L71
            L5a:
                com.superwall.sdk.config.PaywallPreload r11 = r10.this$0
                kotlin.jvm.functions.Function2 r11 = com.superwall.sdk.config.PaywallPreload.access$getTrack$p(r11)
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallPreload r1 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallPreload
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallPreload$State r3 = com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.PaywallPreload.State.Complete
                int r4 = r10.$paywallCount
                r1.<init>(r3, r4)
                r10.label = r2
                java.lang.Object r11 = r11.invoke(r1, r10)
                if (r11 != r0) goto L72
            L71:
                return r0
            L72:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.PaywallPreload.C27882.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27882) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private final Set<String> getTreatmentPaywallIds(Config config, Set<Trigger> set) {
        ConfigLogic configLogic = ConfigLogic.INSTANCE;
        Set<Trigger> setFilterTriggers = configLogic.filterTriggers(set, config.getPreloadingDisabled());
        return setFilterTriggers.isEmpty() ? SetsKt.emptySet() : configLogic.getActiveTreatmentPaywallIds(setFilterTriggers, this.storage.getConfirmedAssignments(), this.assignments.getUnconfirmedAssignments());
    }

    public static /* synthetic */ Object preloadAllPaywalls$default(PaywallPreload paywallPreload, Config config, Context context, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        return paywallPreload.preloadAllPaywalls(config, context, str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object preloadPaywalls(java.util.Set<java.lang.String> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.config.PaywallPreload.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.config.PaywallPreload$preloadPaywalls$1 r0 = (com.superwall.sdk.config.PaywallPreload.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.config.PaywallPreload$preloadPaywalls$1 r0 = new com.superwall.sdk.config.PaywallPreload$preloadPaywalls$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r7 = r0.I$0
            java.lang.Object r1 = r0.L$1
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r0 = r0.L$0
            com.superwall.sdk.config.PaywallPreload r0 = (com.superwall.sdk.config.PaywallPreload) r0
            kotlin.ResultKt.b(r8)
            r8 = r7
            r7 = r1
            goto L5d
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.b(r8)
            int r8 = r7.size()
            kotlin.jvm.functions.Function2<com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r2 = r6.track
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallPreload r4 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallPreload
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallPreload$State r5 = com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.PaywallPreload.State.Start
            r4.<init>(r5, r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r0 = r2.invoke(r4, r0)
            if (r0 != r1) goto L5c
            return r1
        L5c:
            r0 = r6
        L5d:
            com.superwall.sdk.paywall.view.webview.WebviewChecker r1 = com.superwall.sdk.paywall.view.webview.WebviewChecker.INSTANCE
            boolean r1 = r1.getWebviewExists()
            if (r1 == 0) goto L70
            com.superwall.sdk.misc.IOScope r1 = r0.scope
            com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2 r2 = new com.superwall.sdk.config.PaywallPreload$preloadPaywalls$2
            r3 = 0
            r2.<init>(r7, r0, r8, r3)
            com.superwall.sdk.misc.ScopesKt.launchWithTracking(r1, r2)
        L70:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.config.PaywallPreload.preloadPaywalls(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Assignments getAssignments() {
        return this.assignments;
    }

    public final Factory getFactory() {
        return this.factory;
    }

    public final AtomicReference<String> getLastFingerprint$superwall_release() {
        return this.lastFingerprint;
    }

    public final PaywallManager getPaywallManager() {
        return this.paywallManager;
    }

    public final IOScope getScope() {
        return this.scope;
    }

    public final LocalStorage getStorage() {
        return this.storage;
    }

    public final void invalidatePreloadFingerprint$superwall_release() {
        this.lastFingerprint.set(null);
    }

    public final Object preloadAllPaywalls(Config config, Context context, String str, Continuation<? super Unit> continuation) {
        if (str != null) {
            String str2 = this.lastFingerprint.get();
            if (Intrinsics.areEqual(str2, str)) {
                return Unit.f139807a;
            }
            if (!h.a(this.lastFingerprint, str2, str)) {
                return Unit.f139807a;
            }
            if (this.currentPreloadingTask != null) {
                h.a(this.lastFingerprint, str, str2);
                return Unit.f139807a;
            }
        } else if (this.currentPreloadingTask != null) {
            return Unit.f139807a;
        }
        this.currentPreloadingTask = ScopesKt.launchWithTracking(this.scope, new AnonymousClass2(context, config, null));
        return Unit.f139807a;
    }

    public final Object preloadPaywallsByNames(Config config, Set<String> set, Continuation<? super Unit> continuation) throws Throwable {
        Set<Trigger> triggers = config.getTriggers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : triggers) {
            if (set.contains(((Trigger) obj).getEventName())) {
                arrayList.add(obj);
            }
        }
        Object objPreloadPaywalls = preloadPaywalls(getTreatmentPaywallIds(config, CollectionsKt.toSet(arrayList)), continuation);
        return objPreloadPaywalls == IntrinsicsKt.f() ? objPreloadPaywalls : Unit.f139807a;
    }

    public final Object removeUnusedPaywallVCsFromCache$superwall_release(Config config, Config config2, Continuation<? super Unit> continuation) {
        PaywallViewState state;
        Paywall paywall;
        PaywallView currentView = this.paywallManager.getCurrentView();
        List listFilterNotNull = CollectionsKt.filterNotNull(SetsKt.minus(Companion.changedPaywallIds$superwall_release(config, config2), (currentView == null || (state = currentView.getState()) == null || (paywall = state.getPaywall()) == null) ? null : paywall.getIdentifier()));
        Iterator it = listFilterNotNull.iterator();
        while (it.hasNext()) {
            this.paywallManager.removePaywallView((String) it.next());
        }
        if (!listFilterNotNull.isEmpty()) {
            invalidatePreloadFingerprint$superwall_release();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallPreload(Factory factory, IOScope scope, LocalStorage storage, Assignments assignments, PaywallManager paywallManager, Function2<? super InternalSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(assignments, "assignments");
        Intrinsics.checkNotNullParameter(paywallManager, "paywallManager");
        Intrinsics.checkNotNullParameter(function2, sECyKyO.cUzZSEfluywZhw);
        this.factory = factory;
        this.scope = scope;
        this.storage = storage;
        this.assignments = assignments;
        this.paywallManager = paywallManager;
        this.track = function2;
        this.lastFingerprint = new AtomicReference<>(null);
    }
}
