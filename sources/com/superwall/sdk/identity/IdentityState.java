package com.superwall.sdk.identity;

import com.superwall.sdk.SdkContext;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.identity.IdentityState;
import com.superwall.sdk.misc.String_SHA256Kt;
import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.TypedAction;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.storage.DidTrackFirstSeen;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class IdentityState {
    private final String aliasId;
    private final String appInstalledAtString;
    private final String appUserId;
    private final Phase phase;
    private final int seed;
    private final Map<String, Object> userAttributes;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Actions implements TypedAction<IdentityContext> {
        private final Function2<IdentityContext, Continuation<? super Unit>, Object> execute;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CheckWebEntitlements extends Actions {
            public static final CheckWebEntitlements INSTANCE = new CheckWebEntitlements();

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$CheckWebEntitlements$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$CheckWebEntitlements$1", f = "IdentityManagerActor.kt", l = {362}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        WebPaywallRedeemer webPaywallRedeemer = (WebPaywallRedeemer) ((IdentityContext) this.L$0).getWebPaywallRedeemer().invoke();
                        WebPaywallRedeemer.RedeemType.Existing existing = WebPaywallRedeemer.RedeemType.Existing.INSTANCE;
                        this.label = 1;
                        if (webPaywallRedeemer.redeem(existing, this) == objF) {
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
            }

            private CheckWebEntitlements() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Configure extends Actions {
            private final boolean neverCalledStaticConfig;

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$Configure$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$Configure$1", f = "IdentityManagerActor.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ boolean $neverCalledStaticConfig;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(boolean z2, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$neverCalledStaticConfig = z2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$neverCalledStaticConfig, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    IdentityContext identityContext = (IdentityContext) this.L$0;
                    boolean zShouldGetAssignments = IdentityLogic.INSTANCE.shouldGetAssignments(((IdentityState) identityContext.getActor().getState().getValue()).isLoggedIn(), this.$neverCalledStaticConfig, !(((Boolean) identityContext.getStorage().read(DidTrackFirstSeen.INSTANCE)) != null ? r0.booleanValue() : false));
                    identityContext.update(new Updates.Configure(zShouldGetAssignments));
                    if (zShouldGetAssignments) {
                        identityContext.effect(FetchAssignments.INSTANCE);
                    }
                    return Unit.f139807a;
                }
            }

            public Configure(boolean z2) {
                super(new AnonymousClass1(z2, null), null);
                this.neverCalledStaticConfig = z2;
            }

            public static /* synthetic */ Configure copy$default(Configure configure, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z2 = configure.neverCalledStaticConfig;
                }
                return configure.copy(z2);
            }

            public final boolean component1() {
                return this.neverCalledStaticConfig;
            }

            public final Configure copy(boolean z2) {
                return new Configure(z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Configure) && this.neverCalledStaticConfig == ((Configure) obj).neverCalledStaticConfig;
            }

            public final boolean getNeverCalledStaticConfig() {
                return this.neverCalledStaticConfig;
            }

            public int hashCode() {
                return Boolean.hashCode(this.neverCalledStaticConfig);
            }

            public String toString() {
                return "Configure(neverCalledStaticConfig=" + this.neverCalledStaticConfig + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FetchAssignments extends Actions {
            public static final FetchAssignments INSTANCE = new FetchAssignments();

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$FetchAssignments$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$FetchAssignments$1", f = "IdentityManagerActor.kt", l = {355}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IdentityContext identityContext;
                    Throwable th;
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        identityContext = (IdentityContext) this.L$0;
                        try {
                            ResultKt.b(obj);
                            identityContext.update(Updates.AssignmentsCompleted.INSTANCE);
                            return Unit.f139807a;
                        } catch (Throwable th2) {
                            th = th2;
                            identityContext.update(Updates.AssignmentsCompleted.INSTANCE);
                            throw th;
                        }
                    }
                    ResultKt.b(obj);
                    IdentityContext identityContext2 = (IdentityContext) this.L$0;
                    try {
                        SdkContext sdkContext = identityContext2.getSdkContext();
                        this.L$0 = identityContext2;
                        this.label = 1;
                        if (sdkContext.fetchAssignments(this) == objF) {
                            return objF;
                        }
                        identityContext = identityContext2;
                        identityContext.update(Updates.AssignmentsCompleted.INSTANCE);
                        return Unit.f139807a;
                    } catch (Throwable th3) {
                        identityContext = identityContext2;
                        th = th3;
                        identityContext.update(Updates.AssignmentsCompleted.INSTANCE);
                        throw th;
                    }
                }
            }

            private FetchAssignments() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FullReset extends Actions {
            public static final FullReset INSTANCE = new FullReset();

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$FullReset$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$FullReset$1", f = "IdentityManagerActor.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    IdentityContext identityContext = (IdentityContext) this.L$0;
                    identityContext.update(Updates.Reset.INSTANCE);
                    IdentityState identityState = (IdentityState) identityContext.getState().getValue();
                    identityContext.track(new InternalSuperwallEvent.Attributes(identityState.getAppInstalledAtString(), new HashMap(identityState.getUserAttributes())));
                    identityContext.getCompleteReset().invoke();
                    return Unit.f139807a;
                }
            }

            private FullReset() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Identify extends Actions {
            private final IdentityOptions options;
            private final String userId;

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$Identify$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$Identify$1", f = "IdentityManagerActor.kt", l = {281, 288}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ IdentityOptions $options;
                final /* synthetic */ String $userId;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, IdentityOptions identityOptions, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$userId = str;
                    this.$options = identityOptions;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$userId, this.$options, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
                
                    if (r4.immediate(r3, r9) != r0) goto L36;
                 */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 210
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.identity.IdentityState.Actions.Identify.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Identify(String userId, IdentityOptions identityOptions) {
                super(new AnonymousClass1(userId, identityOptions, null), null);
                Intrinsics.checkNotNullParameter(userId, "userId");
                this.userId = userId;
                this.options = identityOptions;
            }

            public static /* synthetic */ Identify copy$default(Identify identify, String str, IdentityOptions identityOptions, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = identify.userId;
                }
                if ((i3 & 2) != 0) {
                    identityOptions = identify.options;
                }
                return identify.copy(str, identityOptions);
            }

            public final String component1() {
                return this.userId;
            }

            public final IdentityOptions component2() {
                return this.options;
            }

            public final Identify copy(String userId, IdentityOptions identityOptions) {
                Intrinsics.checkNotNullParameter(userId, "userId");
                return new Identify(userId, identityOptions);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Identify)) {
                    return false;
                }
                Identify identify = (Identify) obj;
                return Intrinsics.areEqual(this.userId, identify.userId) && Intrinsics.areEqual(this.options, identify.options);
            }

            public final IdentityOptions getOptions() {
                return this.options;
            }

            public final String getUserId() {
                return this.userId;
            }

            public int hashCode() {
                int iHashCode = this.userId.hashCode() * 31;
                IdentityOptions identityOptions = this.options;
                return iHashCode + (identityOptions == null ? 0 : identityOptions.hashCode());
            }

            public String toString() {
                return "Identify(userId=" + this.userId + ", options=" + this.options + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class IdentityChanged extends Actions {
            private final String alias;
            private final String id;
            private final Boolean restoreAssignments;

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$IdentityChanged$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$IdentityChanged$1", f = "IdentityManagerActor.kt", l = {317, 321}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $alias;
                final /* synthetic */ String $id;
                final /* synthetic */ Boolean $restoreAssignments;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, String str2, Boolean bool, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$id = str;
                    this.$alias = str2;
                    this.$restoreAssignments = bool;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$id, this.$alias, this.$restoreAssignments, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
                
                    if (r1.immediate(r9, r8) == r0) goto L17;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r1 = r8.label
                        r2 = 2
                        r3 = 0
                        r4 = 1
                        if (r1 == 0) goto L24
                        if (r1 == r4) goto L1c
                        if (r1 != r2) goto L14
                        kotlin.ResultKt.b(r9)
                        goto L93
                    L14:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1c:
                        java.lang.Object r1 = r8.L$0
                        com.superwall.sdk.identity.IdentityContext r1 = (com.superwall.sdk.identity.IdentityContext) r1
                        kotlin.ResultKt.b(r9)
                        goto L75
                    L24:
                        kotlin.ResultKt.b(r9)
                        java.lang.Object r9 = r8.L$0
                        r1 = r9
                        com.superwall.sdk.identity.IdentityContext r1 = (com.superwall.sdk.identity.IdentityContext) r1
                        com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$IdentityAlias r9 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$IdentityAlias
                        r9.<init>(r3, r4, r3)
                        r1.track(r9)
                        kotlinx.coroutines.flow.StateFlow r9 = r1.getState()
                        java.lang.Object r9 = r9.getValue()
                        com.superwall.sdk.identity.IdentityState r9 = (com.superwall.sdk.identity.IdentityState) r9
                        com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$Attributes r5 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$Attributes
                        java.lang.String r6 = r9.getAppInstalledAtString()
                        java.util.HashMap r7 = new java.util.HashMap
                        java.util.Map r9 = r9.getUserAttributes()
                        r7.<init>(r9)
                        r5.<init>(r6, r7)
                        r1.track(r5)
                        com.superwall.sdk.identity.IdentityState$Actions$ResolveSeed r9 = new com.superwall.sdk.identity.IdentityState$Actions$ResolveSeed
                        java.lang.String r5 = r8.$id
                        r9.<init>(r5)
                        r1.effect(r9)
                        com.superwall.sdk.identity.IdentityState$Actions$CheckWebEntitlements r9 = com.superwall.sdk.identity.IdentityState.Actions.CheckWebEntitlements.INSTANCE
                        r1.effect(r9)
                        com.superwall.sdk.SdkContext r9 = r1.getSdkContext()
                        java.lang.String r5 = r8.$id
                        java.lang.String r6 = r8.$alias
                        r8.L$0 = r1
                        r8.label = r4
                        java.lang.Object r9 = r9.reevaluateTestMode(r5, r6, r8)
                        if (r9 != r0) goto L75
                        goto L8d
                    L75:
                        java.lang.Boolean r9 = r8.$restoreAssignments
                        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
                        boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r4)
                        if (r9 == 0) goto L8e
                        com.superwall.sdk.identity.IdentityState$Actions$FetchAssignments r9 = com.superwall.sdk.identity.IdentityState.Actions.FetchAssignments.INSTANCE
                        r8.L$0 = r3
                        r8.label = r2
                        java.lang.Object r9 = r1.immediate(r9, r8)
                        if (r9 != r0) goto L93
                    L8d:
                        return r0
                    L8e:
                        com.superwall.sdk.identity.IdentityState$Actions$FetchAssignments r9 = com.superwall.sdk.identity.IdentityState.Actions.FetchAssignments.INSTANCE
                        r1.effect(r9)
                    L93:
                        kotlin.Unit r9 = kotlin.Unit.f139807a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.identity.IdentityState.Actions.IdentityChanged.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public IdentityChanged(String id, String alias, Boolean bool) {
                super(new AnonymousClass1(id, alias, bool, null), null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(alias, "alias");
                this.id = id;
                this.alias = alias;
                this.restoreAssignments = bool;
            }

            public static /* synthetic */ IdentityChanged copy$default(IdentityChanged identityChanged, String str, String str2, Boolean bool, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = identityChanged.id;
                }
                if ((i3 & 2) != 0) {
                    str2 = identityChanged.alias;
                }
                if ((i3 & 4) != 0) {
                    bool = identityChanged.restoreAssignments;
                }
                return identityChanged.copy(str, str2, bool);
            }

            public final String component1() {
                return this.id;
            }

            public final String component2() {
                return this.alias;
            }

            public final Boolean component3() {
                return this.restoreAssignments;
            }

            public final IdentityChanged copy(String id, String alias, Boolean bool) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(alias, "alias");
                return new IdentityChanged(id, alias, bool);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof IdentityChanged)) {
                    return false;
                }
                IdentityChanged identityChanged = (IdentityChanged) obj;
                return Intrinsics.areEqual(this.id, identityChanged.id) && Intrinsics.areEqual(this.alias, identityChanged.alias) && Intrinsics.areEqual(this.restoreAssignments, identityChanged.restoreAssignments);
            }

            public final String getAlias() {
                return this.alias;
            }

            public final String getId() {
                return this.id;
            }

            public final Boolean getRestoreAssignments() {
                return this.restoreAssignments;
            }

            public int hashCode() {
                int iHashCode = ((this.id.hashCode() * 31) + this.alias.hashCode()) * 31;
                Boolean bool = this.restoreAssignments;
                return iHashCode + (bool == null ? 0 : bool.hashCode());
            }

            public String toString() {
                return "IdentityChanged(id=" + this.id + ", alias=" + this.alias + ", restoreAssignments=" + this.restoreAssignments + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MergeAttributes extends Actions {
            private final Map<String, Object> attrs;
            private final boolean shouldNotify;
            private final boolean shouldTrackMerge;

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$MergeAttributes$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$MergeAttributes$1", f = "IdentityManagerActor.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ Map<String, Object> $attrs;
                final /* synthetic */ boolean $shouldNotify;
                final /* synthetic */ boolean $shouldTrackMerge;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Map<String, ? extends Object> map, boolean z2, boolean z3, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$attrs = map;
                    this.$shouldTrackMerge = z2;
                    this.$shouldNotify = z3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$attrs, this.$shouldTrackMerge, this.$shouldNotify, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    IdentityContext identityContext = (IdentityContext) this.L$0;
                    identityContext.update(new Updates.AttributesMerged(this.$attrs));
                    if (this.$shouldTrackMerge) {
                        IdentityState identityState = (IdentityState) identityContext.getState().getValue();
                        identityContext.track(new InternalSuperwallEvent.Attributes(identityState.getAppInstalledAtString(), new HashMap(identityState.getUserAttributes())));
                    }
                    if (this.$shouldNotify) {
                        identityContext.effect(new NotifyUserChange(((IdentityState) identityContext.getState().getValue()).getUserAttributes()));
                    }
                    return Unit.f139807a;
                }
            }

            public /* synthetic */ MergeAttributes(Map map, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(map, (i3 & 2) != 0 ? true : z2, (i3 & 4) != 0 ? false : z3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MergeAttributes copy$default(MergeAttributes mergeAttributes, Map map, boolean z2, boolean z3, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    map = mergeAttributes.attrs;
                }
                if ((i3 & 2) != 0) {
                    z2 = mergeAttributes.shouldTrackMerge;
                }
                if ((i3 & 4) != 0) {
                    z3 = mergeAttributes.shouldNotify;
                }
                return mergeAttributes.copy(map, z2, z3);
            }

            public final Map<String, Object> component1() {
                return this.attrs;
            }

            public final boolean component2() {
                return this.shouldTrackMerge;
            }

            public final boolean component3() {
                return this.shouldNotify;
            }

            public final MergeAttributes copy(Map<String, ? extends Object> attrs, boolean z2, boolean z3) {
                Intrinsics.checkNotNullParameter(attrs, "attrs");
                return new MergeAttributes(attrs, z2, z3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MergeAttributes)) {
                    return false;
                }
                MergeAttributes mergeAttributes = (MergeAttributes) obj;
                return Intrinsics.areEqual(this.attrs, mergeAttributes.attrs) && this.shouldTrackMerge == mergeAttributes.shouldTrackMerge && this.shouldNotify == mergeAttributes.shouldNotify;
            }

            public final Map<String, Object> getAttrs() {
                return this.attrs;
            }

            public final boolean getShouldNotify() {
                return this.shouldNotify;
            }

            public final boolean getShouldTrackMerge() {
                return this.shouldTrackMerge;
            }

            public int hashCode() {
                return (((this.attrs.hashCode() * 31) + Boolean.hashCode(this.shouldTrackMerge)) * 31) + Boolean.hashCode(this.shouldNotify);
            }

            public String toString() {
                return "MergeAttributes(attrs=" + this.attrs + ", shouldTrackMerge=" + this.shouldTrackMerge + ", shouldNotify=" + this.shouldNotify + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MergeAttributes(Map<String, ? extends Object> attrs, boolean z2, boolean z3) {
                super(new AnonymousClass1(attrs, z2, z3, null), null);
                Intrinsics.checkNotNullParameter(attrs, "attrs");
                this.attrs = attrs;
                this.shouldTrackMerge = z2;
                this.shouldNotify = z3;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NotifyUserChange extends Actions {
            private final Map<String, Object> attributes;

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$NotifyUserChange$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$NotifyUserChange$1", f = "IdentityManagerActor.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ Map<String, Object> $attributes;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Map<String, ? extends Object> map, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$attributes = map;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$attributes, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    Function1<Map<String, ? extends Object>, Unit> notifyUserChange = ((IdentityContext) this.L$0).getNotifyUserChange();
                    if (notifyUserChange != null) {
                        notifyUserChange.invoke(this.$attributes);
                    }
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotifyUserChange(Map<String, ? extends Object> attributes) {
                super(new AnonymousClass1(attributes, null), null);
                Intrinsics.checkNotNullParameter(attributes, "attributes");
                this.attributes = attributes;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ NotifyUserChange copy$default(NotifyUserChange notifyUserChange, Map map, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    map = notifyUserChange.attributes;
                }
                return notifyUserChange.copy(map);
            }

            public final Map<String, Object> component1() {
                return this.attributes;
            }

            public final NotifyUserChange copy(Map<String, ? extends Object> attributes) {
                Intrinsics.checkNotNullParameter(attributes, "attributes");
                return new NotifyUserChange(attributes);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NotifyUserChange) && Intrinsics.areEqual(this.attributes, ((NotifyUserChange) obj).attributes);
            }

            public final Map<String, Object> getAttributes() {
                return this.attributes;
            }

            public int hashCode() {
                return this.attributes.hashCode();
            }

            public String toString() {
                return "NotifyUserChange(attributes=" + this.attributes + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Reset extends Actions {
            public static final Reset INSTANCE = new Reset();

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$Reset$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$Reset$1", f = "IdentityManagerActor.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    IdentityContext identityContext = (IdentityContext) this.L$0;
                    identityContext.update(Updates.Reset.INSTANCE);
                    IdentityState identityState = (IdentityState) identityContext.getState().getValue();
                    identityContext.track(new InternalSuperwallEvent.Attributes(identityState.getAppInstalledAtString(), new HashMap(identityState.getUserAttributes())));
                    return Unit.f139807a;
                }
            }

            private Reset() {
                super(new AnonymousClass1(null), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ResolveSeed extends Actions {
            private final String userId;

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityState$Actions$ResolveSeed$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.identity.IdentityState$Actions$ResolveSeed$1", f = "IdentityManagerActor.kt", l = {331}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<IdentityContext, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $userId;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$userId = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$userId, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(IdentityContext identityContext, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(identityContext, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IdentityContext identityContext;
                    Config config;
                    Integer numSha256MappedToRange;
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        IdentityContext identityContext2 = (IdentityContext) this.L$0;
                        try {
                            SdkContext sdkContext = identityContext2.getSdkContext();
                            this.L$0 = identityContext2;
                            this.label = 1;
                            Object objAwaitConfig = sdkContext.awaitConfig(this);
                            if (objAwaitConfig == objF) {
                                return objF;
                            }
                            identityContext = identityContext2;
                            obj = objAwaitConfig;
                            config = (Config) obj;
                            if (config == null) {
                                identityContext.update(Updates.SeedSkipped.INSTANCE);
                            } else {
                                identityContext.update(Updates.SeedSkipped.INSTANCE);
                            }
                        } catch (Exception unused) {
                            identityContext = identityContext2;
                            identityContext.update(Updates.SeedSkipped.INSTANCE);
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        identityContext = (IdentityContext) this.L$0;
                        try {
                            ResultKt.b(obj);
                            config = (Config) obj;
                            if (config == null && config.getFeatureFlags().getEnableUserIdSeed() && (numSha256MappedToRange = String_SHA256Kt.sha256MappedToRange(this.$userId)) != null) {
                                identityContext.update(new Updates.SeedResolved(numSha256MappedToRange.intValue()));
                                IdentityState identityState = (IdentityState) identityContext.getState().getValue();
                                identityContext.track(new InternalSuperwallEvent.Attributes(identityState.getAppInstalledAtString(), new HashMap(identityState.getUserAttributes())));
                            } else {
                                identityContext.update(Updates.SeedSkipped.INSTANCE);
                            }
                        } catch (Exception unused2) {
                            identityContext.update(Updates.SeedSkipped.INSTANCE);
                        }
                    }
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResolveSeed(String userId) {
                super(new AnonymousClass1(userId, null), null);
                Intrinsics.checkNotNullParameter(userId, "userId");
                this.userId = userId;
            }

            public static /* synthetic */ ResolveSeed copy$default(ResolveSeed resolveSeed, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = resolveSeed.userId;
                }
                return resolveSeed.copy(str);
            }

            public final String component1() {
                return this.userId;
            }

            public final ResolveSeed copy(String userId) {
                Intrinsics.checkNotNullParameter(userId, "userId");
                return new ResolveSeed(userId);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ResolveSeed) && Intrinsics.areEqual(this.userId, ((ResolveSeed) obj).userId);
            }

            public final String getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return this.userId.hashCode();
            }

            public String toString() {
                return "ResolveSeed(userId=" + this.userId + ")";
            }
        }

        public /* synthetic */ Actions(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(function2);
        }

        @Override // com.superwall.sdk.misc.primitives.TypedAction
        public Function2<IdentityContext, Continuation<? super Unit>, Object> getExecute() {
            return this.execute;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Actions(Function2<? super IdentityContext, ? super Continuation<? super Unit>, ? extends Object> function2) {
            this.execute = function2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Pending {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Assignments extends Pending {
            public static final Assignments INSTANCE = new Assignments();

            private Assignments() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Attributes extends Pending {
            public static final Attributes INSTANCE = new Attributes();

            private Attributes() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Configuration extends Pending {
            public static final Configuration INSTANCE = new Configuration();

            private Configuration() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Identification extends Pending {
            private final String id;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Identification(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public static /* synthetic */ Identification copy$default(Identification identification, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = identification.id;
                }
                return identification.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final Identification copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new Identification(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Identification) && Intrinsics.areEqual(this.id, ((Identification) obj).id);
            }

            public final String getId() {
                return this.id;
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "Identification(id=" + this.id + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Reset extends Pending {
            public static final Reset INSTANCE = new Reset();

            private Reset() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Seed extends Pending {
            public static final Seed INSTANCE = new Seed();

            private Seed() {
                super(null);
            }
        }

        public /* synthetic */ Pending(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Pending() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Phase {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Pending extends Phase {
            private final Set<Pending> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Pending(Set<? extends Pending> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Pending copy$default(Pending pending, Set set, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    set = pending.items;
                }
                return pending.copy(set);
            }

            public final Set<Pending> component1() {
                return this.items;
            }

            public final Pending copy(Set<? extends Pending> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new Pending(items);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Pending) && Intrinsics.areEqual(this.items, ((Pending) obj).items);
            }

            public final Set<Pending> getItems() {
                return this.items;
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "Pending(items=" + this.items + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Ready extends Phase {
            public static final Ready INSTANCE = new Ready();

            private Ready() {
                super(null);
            }
        }

        public /* synthetic */ Phase(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Phase() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Updates implements Reducer<IdentityState> {
        private final Function1<IdentityState, IdentityState> reduce;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AssignmentsCompleted extends Updates {
            public static final AssignmentsCompleted INSTANCE = new AssignmentsCompleted();

            private AssignmentsCompleted() {
                super(new Function1() { // from class: com.superwall.sdk.identity.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.AssignmentsCompleted._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return state.resolve(Pending.Assignments.INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AttributesMerged extends Updates {
            private final Map<String, Object> attrs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AttributesMerged(final Map<String, ? extends Object> attrs) {
                super(new Function1() { // from class: com.superwall.sdk.identity.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.AttributesMerged._init_$lambda$0(attrs, (IdentityState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(attrs, "attrs");
                this.attrs = attrs;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(Map map, IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return IdentityState.copy$default(state, null, null, 0, IdentityLogic.INSTANCE.mergeAttributes(map, state.getUserAttributes(), state.getAppInstalledAtString()), null, null, 55, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AttributesMerged copy$default(AttributesMerged attributesMerged, Map map, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    map = attributesMerged.attrs;
                }
                return attributesMerged.copy(map);
            }

            public final Map<String, Object> component1() {
                return this.attrs;
            }

            public final AttributesMerged copy(Map<String, ? extends Object> attrs) {
                Intrinsics.checkNotNullParameter(attrs, "attrs");
                return new AttributesMerged(attrs);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AttributesMerged) && Intrinsics.areEqual(this.attrs, ((AttributesMerged) obj).attrs);
            }

            public final Map<String, Object> getAttrs() {
                return this.attrs;
            }

            public int hashCode() {
                return this.attrs.hashCode();
            }

            public String toString() {
                return "AttributesMerged(attrs=" + this.attrs + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class BeginAttributes extends Updates {
            public static final BeginAttributes INSTANCE = new BeginAttributes();

            private BeginAttributes() {
                super(new Function1() { // from class: com.superwall.sdk.identity.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.BeginAttributes._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Set<Pending> setEmptySet;
                Intrinsics.checkNotNullParameter(state, "state");
                Phase phase = state.getPhase();
                Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
                if (pending == null || (setEmptySet = pending.getItems()) == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                return IdentityState.copy$default(state, null, null, 0, null, new Phase.Pending(SetsKt.plus(setEmptySet, Pending.Attributes.INSTANCE)), null, 47, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class BeginIdentify extends Updates {
            private final String id;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BeginIdentify(final String id) {
                super(new Function1() { // from class: com.superwall.sdk.identity.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.BeginIdentify._init_$lambda$0(id, (IdentityState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(String str, IdentityState state) {
                Set<Pending> setEmptySet;
                Intrinsics.checkNotNullParameter(state, "state");
                Phase phase = state.getPhase();
                Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
                if (pending == null || (setEmptySet = pending.getItems()) == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                return IdentityState.copy$default(state, null, null, 0, null, new Phase.Pending(SetsKt.plus(setEmptySet, new Pending.Identification(str))), null, 47, null);
            }

            public static /* synthetic */ BeginIdentify copy$default(BeginIdentify beginIdentify, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = beginIdentify.id;
                }
                return beginIdentify.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final BeginIdentify copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new BeginIdentify(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof BeginIdentify) && Intrinsics.areEqual(this.id, ((BeginIdentify) obj).id);
            }

            public final String getId() {
                return this.id;
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "BeginIdentify(id=" + this.id + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class BeginReset extends Updates {
            public static final BeginReset INSTANCE = new BeginReset();

            private BeginReset() {
                super(new Function1() { // from class: com.superwall.sdk.identity.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.BeginReset._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Set<Pending> setEmptySet;
                Intrinsics.checkNotNullParameter(state, "state");
                Phase phase = state.getPhase();
                Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
                if (pending == null || (setEmptySet = pending.getItems()) == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                return IdentityState.copy$default(state, null, null, 0, null, new Phase.Pending(SetsKt.plus(setEmptySet, Pending.Reset.INSTANCE)), null, 47, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Configure extends Updates {
            private final boolean needsAssignments;

            public Configure(final boolean z2) {
                super(new Function1() { // from class: com.superwall.sdk.identity.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.Configure._init_$lambda$0(z2, (IdentityState) obj);
                    }
                }, null);
                this.needsAssignments = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(boolean z2, IdentityState state) {
                Set<Pending> setEmptySet;
                Intrinsics.checkNotNullParameter(state, "state");
                Phase phase = state.getPhase();
                Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
                if (pending == null || (setEmptySet = pending.getItems()) == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                Set setPlus = SetsKt.plus(SetsKt.minus(setEmptySet, Pending.Configuration.INSTANCE), (Iterable) (z2 ? SetsKt.setOf(Pending.Assignments.INSTANCE) : SetsKt.emptySet()));
                return setPlus.isEmpty() ? IdentityState.copy$default(state, null, null, 0, null, Phase.Ready.INSTANCE, null, 47, null) : IdentityState.copy$default(state, null, null, 0, null, new Phase.Pending(setPlus), null, 47, null);
            }

            public static /* synthetic */ Configure copy$default(Configure configure, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z2 = configure.needsAssignments;
                }
                return configure.copy(z2);
            }

            public final boolean component1() {
                return this.needsAssignments;
            }

            public final Configure copy(boolean z2) {
                return new Configure(z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Configure) && this.needsAssignments == ((Configure) obj).needsAssignments;
            }

            public final boolean getNeedsAssignments() {
                return this.needsAssignments;
            }

            public int hashCode() {
                return Boolean.hashCode(this.needsAssignments);
            }

            public String toString() {
                return "Configure(needsAssignments=" + this.needsAssignments + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class EndAttributes extends Updates {
            public static final EndAttributes INSTANCE = new EndAttributes();

            private EndAttributes() {
                super(new Function1() { // from class: com.superwall.sdk.identity.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.EndAttributes._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return state.resolve(Pending.Attributes.INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class EndIdentify extends Updates {
            private final String id;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EndIdentify(final String id) {
                super(new Function1() { // from class: com.superwall.sdk.identity.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.EndIdentify._init_$lambda$0(id, (IdentityState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(String str, IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return state.resolve(new Pending.Identification(str));
            }

            public static /* synthetic */ EndIdentify copy$default(EndIdentify endIdentify, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = endIdentify.id;
                }
                return endIdentify.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final EndIdentify copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new EndIdentify(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof EndIdentify) && Intrinsics.areEqual(this.id, ((EndIdentify) obj).id);
            }

            public final String getId() {
                return this.id;
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return "EndIdentify(id=" + this.id + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class EndReset extends Updates {
            public static final EndReset INSTANCE = new EndReset();

            private EndReset() {
                super(new Function1() { // from class: com.superwall.sdk.identity.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.EndReset._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return state.resolve(Pending.Reset.INSTANCE);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Identify extends Updates {
            private final boolean restoreAssignments;
            private final String userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Identify(final String userId, final boolean z2) {
                super(new Function1() { // from class: com.superwall.sdk.identity.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.Identify._init_$lambda$1(userId, z2, (IdentityState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(userId, "userId");
                this.userId = userId;
                this.restoreAssignments = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$1(String str, boolean z2, IdentityState state) {
                IdentityState identityState;
                Intrinsics.checkNotNullParameter(state, "state");
                if (Intrinsics.areEqual(str, state.getAppUserId())) {
                    return state;
                }
                if (state.getAppUserId() != null) {
                    identityState = new IdentityState(null, null, 0, null, Phase.Ready.INSTANCE, state.getAppInstalledAtString(), 15, null);
                } else {
                    identityState = state;
                }
                Map<String, Object> mapMergeAttributes = IdentityLogic.INSTANCE.mergeAttributes(MapsKt.mapOf(TuplesKt.a(Keys.APP_USER_ID, str), TuplesKt.a(Keys.ALIAS_ID, identityState.getAliasId()), TuplesKt.a(Keys.SEED, Integer.valueOf(identityState.getSeed()))), identityState.getUserAttributes(), state.getAppInstalledAtString());
                Phase phase = state.getPhase();
                Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
                Set<Pending> items = pending != null ? pending.getItems() : null;
                if (items == null) {
                    items = SetsKt.emptySet();
                }
                Set setCreateSetBuilder = SetsKt.createSetBuilder();
                setCreateSetBuilder.add(Pending.Seed.INSTANCE);
                if (z2) {
                    setCreateSetBuilder.add(Pending.Assignments.INSTANCE);
                }
                Unit unit = Unit.f139807a;
                return IdentityState.copy$default(identityState, str, null, 0, mapMergeAttributes, new Phase.Pending(SetsKt.plus((Set) items, (Iterable) SetsKt.build(setCreateSetBuilder))), null, 38, null);
            }

            public static /* synthetic */ Identify copy$default(Identify identify, String str, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = identify.userId;
                }
                if ((i3 & 2) != 0) {
                    z2 = identify.restoreAssignments;
                }
                return identify.copy(str, z2);
            }

            public final String component1() {
                return this.userId;
            }

            public final boolean component2() {
                return this.restoreAssignments;
            }

            public final Identify copy(String userId, boolean z2) {
                Intrinsics.checkNotNullParameter(userId, "userId");
                return new Identify(userId, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Identify)) {
                    return false;
                }
                Identify identify = (Identify) obj;
                return Intrinsics.areEqual(this.userId, identify.userId) && this.restoreAssignments == identify.restoreAssignments;
            }

            public final boolean getRestoreAssignments() {
                return this.restoreAssignments;
            }

            public final String getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return (this.userId.hashCode() * 31) + Boolean.hashCode(this.restoreAssignments);
            }

            public String toString() {
                return "Identify(userId=" + this.userId + ", restoreAssignments=" + this.restoreAssignments + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Reset extends Updates {
            public static final Reset INSTANCE = new Reset();

            private Reset() {
                super(new Function1() { // from class: com.superwall.sdk.identity.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.Reset._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                IdentityState identityState = new IdentityState(null, null, 0, null, null, state.getAppInstalledAtString(), 31, null);
                Map<String, Object> mapMergeAttributes = IdentityLogic.INSTANCE.mergeAttributes(MapsKt.mapOf(TuplesKt.a(Keys.ALIAS_ID, identityState.getAliasId()), TuplesKt.a(Keys.SEED, Integer.valueOf(identityState.getSeed()))), MapsKt.emptyMap(), state.getAppInstalledAtString());
                Phase phase = state.getPhase();
                Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
                Set<Pending> items = pending != null ? pending.getItems() : null;
                if (items == null) {
                    items = SetsKt.emptySet();
                }
                return IdentityState.copy$default(identityState, null, null, 0, mapMergeAttributes, items.isEmpty() ? Phase.Ready.INSTANCE : new Phase.Pending(items), null, 39, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SeedResolved extends Updates {
            private final int seed;

            public SeedResolved(final int i3) {
                super(new Function1() { // from class: com.superwall.sdk.identity.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.SeedResolved._init_$lambda$0(i3, (IdentityState) obj);
                    }
                }, null);
                this.seed = i3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(int i3, IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return IdentityState.copy$default(state, null, null, i3, IdentityLogic.INSTANCE.mergeAttributes(MapsKt.mapOf(TuplesKt.a(Keys.APP_USER_ID, state.getUserId()), TuplesKt.a(Keys.ALIAS_ID, state.getAliasId()), TuplesKt.a(Keys.SEED, Integer.valueOf(i3))), state.getUserAttributes(), state.getAppInstalledAtString()), null, null, 51, null).resolve(Pending.Seed.INSTANCE);
            }

            public static /* synthetic */ SeedResolved copy$default(SeedResolved seedResolved, int i3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i3 = seedResolved.seed;
                }
                return seedResolved.copy(i3);
            }

            public final int component1() {
                return this.seed;
            }

            public final SeedResolved copy(int i3) {
                return new SeedResolved(i3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SeedResolved) && this.seed == ((SeedResolved) obj).seed;
            }

            public final int getSeed() {
                return this.seed;
            }

            public int hashCode() {
                return Integer.hashCode(this.seed);
            }

            public String toString() {
                return "SeedResolved(seed=" + this.seed + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SeedSkipped extends Updates {
            public static final SeedSkipped INSTANCE = new SeedSkipped();

            private SeedSkipped() {
                super(new Function1() { // from class: com.superwall.sdk.identity.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IdentityState.Updates.SeedSkipped._init_$lambda$0((IdentityState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final IdentityState _init_$lambda$0(IdentityState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return state.resolve(Pending.Seed.INSTANCE);
            }
        }

        public /* synthetic */ Updates(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1);
        }

        @Override // com.superwall.sdk.misc.primitives.Reducer
        public Function1<IdentityState, IdentityState> getReduce() {
            return this.reduce;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Updates(Function1<? super IdentityState, IdentityState> function1) {
            this.reduce = function1;
        }
    }

    public IdentityState() {
        this(null, null, 0, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IdentityState copy$default(IdentityState identityState, String str, String str2, int i3, Map map, Phase phase, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = identityState.appUserId;
        }
        if ((i4 & 2) != 0) {
            str2 = identityState.aliasId;
        }
        if ((i4 & 4) != 0) {
            i3 = identityState.seed;
        }
        if ((i4 & 8) != 0) {
            map = identityState.userAttributes;
        }
        if ((i4 & 16) != 0) {
            phase = identityState.phase;
        }
        if ((i4 & 32) != 0) {
            str3 = identityState.appInstalledAtString;
        }
        Phase phase2 = phase;
        String str4 = str3;
        return identityState.copy(str, str2, i3, map, phase2, str4);
    }

    public final String component1() {
        return this.appUserId;
    }

    public final String component2() {
        return this.aliasId;
    }

    public final int component3() {
        return this.seed;
    }

    public final Map<String, Object> component4() {
        return this.userAttributes;
    }

    public final Phase component5() {
        return this.phase;
    }

    public final String component6() {
        return this.appInstalledAtString;
    }

    public final IdentityState copy(String str, String aliasId, int i3, Map<String, ? extends Object> userAttributes, Phase phase, String appInstalledAtString) {
        Intrinsics.checkNotNullParameter(aliasId, "aliasId");
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
        return new IdentityState(str, aliasId, i3, userAttributes, phase, appInstalledAtString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdentityState)) {
            return false;
        }
        IdentityState identityState = (IdentityState) obj;
        return Intrinsics.areEqual(this.appUserId, identityState.appUserId) && Intrinsics.areEqual(this.aliasId, identityState.aliasId) && this.seed == identityState.seed && Intrinsics.areEqual(this.userAttributes, identityState.userAttributes) && Intrinsics.areEqual(this.phase, identityState.phase) && Intrinsics.areEqual(this.appInstalledAtString, identityState.appInstalledAtString);
    }

    public final String getAliasId() {
        return this.aliasId;
    }

    public final String getAppInstalledAtString() {
        return this.appInstalledAtString;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final Map<String, Object> getEnrichedAttributes() {
        Map<String, Object> mutableMap = MapsKt.toMutableMap(this.userAttributes);
        String str = this.appUserId;
        if (str != null) {
            mutableMap.put(Keys.APP_USER_ID, str);
        }
        mutableMap.put(Keys.ALIAS_ID, this.aliasId);
        return mutableMap;
    }

    public final boolean getHasPendingIdentityResolution() {
        Set<Pending> pending = getPending();
        if ((pending instanceof Collection) && pending.isEmpty()) {
            return false;
        }
        for (Pending pending2 : pending) {
            if ((pending2 instanceof Pending.Identification) || (pending2 instanceof Pending.Attributes) || (pending2 instanceof Pending.Reset) || (pending2 instanceof Pending.Seed) || (pending2 instanceof Pending.Assignments)) {
                return true;
            }
        }
        return false;
    }

    public final Set<Pending> getPending() {
        Set<Pending> items;
        Phase phase = this.phase;
        Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
        return (pending == null || (items = pending.getItems()) == null) ? SetsKt.emptySet() : items;
    }

    public final Phase getPhase() {
        return this.phase;
    }

    public final int getSeed() {
        return this.seed;
    }

    public final Map<String, Object> getUserAttributes() {
        return this.userAttributes;
    }

    public final String getUserId() {
        String str = this.appUserId;
        return str == null ? this.aliasId : str;
    }

    public int hashCode() {
        String str = this.appUserId;
        return ((((((((((str == null ? 0 : str.hashCode()) * 31) + this.aliasId.hashCode()) * 31) + Integer.hashCode(this.seed)) * 31) + this.userAttributes.hashCode()) * 31) + this.phase.hashCode()) * 31) + this.appInstalledAtString.hashCode();
    }

    public final boolean isLoggedIn() {
        return this.appUserId != null;
    }

    public final boolean isReady() {
        return this.phase instanceof Phase.Ready;
    }

    public final IdentityState resolve(Pending item) {
        Set<Pending> items;
        Intrinsics.checkNotNullParameter(item, "item");
        Phase phase = this.phase;
        Phase.Pending pending = phase instanceof Phase.Pending ? (Phase.Pending) phase : null;
        if (pending == null || (items = pending.getItems()) == null) {
            return this;
        }
        Set setMinus = SetsKt.minus(items, item);
        return copy$default(this, null, null, 0, null, setMinus.isEmpty() ? Phase.Ready.INSTANCE : new Phase.Pending(setMinus), null, 47, null);
    }

    public String toString() {
        return "IdentityState(appUserId=" + this.appUserId + ", aliasId=" + this.aliasId + ", seed=" + this.seed + ", userAttributes=" + this.userAttributes + ", phase=" + this.phase + ", appInstalledAtString=" + this.appInstalledAtString + ")";
    }

    public IdentityState(String str, String aliasId, int i3, Map<String, ? extends Object> userAttributes, Phase phase, String appInstalledAtString) {
        Intrinsics.checkNotNullParameter(aliasId, "aliasId");
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
        this.appUserId = str;
        this.aliasId = aliasId;
        this.seed = i3;
        this.userAttributes = userAttributes;
        this.phase = phase;
        this.appInstalledAtString = appInstalledAtString;
    }

    public /* synthetic */ IdentityState(String str, String str2, int i3, Map map, Phase phase, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? IdentityLogic.INSTANCE.generateAlias() : str2, (i4 & 4) != 0 ? IdentityLogic.INSTANCE.generateSeed() : i3, (i4 & 8) != 0 ? MapsKt.emptyMap() : map, (i4 & 16) != 0 ? new Phase.Pending(SetsKt.setOf(Pending.Configuration.INSTANCE)) : phase, (i4 & 32) != 0 ? "" : str3);
    }
}
