package com.superwall.sdk.store.testmode;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.misc.CurrentActivityTracker;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.storage.IsTestModeActiveSubscription;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.storage.StoredTestModeSettings;
import com.superwall.sdk.storage.TestModeSettings;
import com.superwall.sdk.store.Entitlements;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.testmode.TestModeReason;
import com.superwall.sdk.store.testmode.TestModeState;
import com.superwall.sdk.store.testmode.models.SuperwallEntitlementRef;
import com.superwall.sdk.store.testmode.models.SuperwallProduct;
import com.superwall.sdk.store.testmode.models.SuperwallProductsResponse;
import com.superwall.sdk.store.testmode.models.TestStoreUser;
import com.superwall.sdk.store.testmode.models.TestStoreUserType;
import com.superwall.sdk.store.testmode.ui.EntitlementSelection;
import com.superwall.sdk.store.testmode.ui.EntitlementStateOption;
import com.superwall.sdk.store.testmode.ui.OfferTypeOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.TimeoutKt;

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
public final class TestMode {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Boolean> isTestEnvironment$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.store.testmode.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(TestMode.isTestEnvironment_delegate$lambda$22());
        }
    });
    private final Function0<ActivityProvider> activityProvider;
    private final Function0<CurrentActivityTracker> activityTracker;
    private final Function0<String> apiKey;
    private final Function0<String> dashboardBaseUrl;
    private final Entitlements entitlements;
    private final Function1<Continuation<? super Either<SuperwallProductsResponse, NetworkError>>, Object> getSuperwallProducts;
    private final Function0<Boolean> hasExternalPurchaseController;
    private final boolean isTestEnvironment;
    private TestModeState state;
    private final Storage storage;
    private final Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> track;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestMode$1", f = "TestMode.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Either.Failure<NetworkError>>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return new Either.Failure(new NetworkError.Unknown(null, 1, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Either.Failure<NetworkError>> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestMode$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestMode$7", f = "TestMode.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(InternalSuperwallEvent internalSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(internalSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isTestEnvironment() {
            return ((Boolean) TestMode.isTestEnvironment$delegate.getValue()).booleanValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TestModeBehavior.values().length];
            try {
                iArr[TestModeBehavior.NEVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TestModeBehavior.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TestModeBehavior.WHEN_ENABLED_FOR_USER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TestModeBehavior.AUTOMATIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TestStoreUserType.values().length];
            try {
                iArr2[TestStoreUserType.UserId.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[TestStoreUserType.AliasId.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[FreeTrialOverride.values().length];
            try {
                iArr3[FreeTrialOverride.UseDefault.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[FreeTrialOverride.ForceAvailable.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[FreeTrialOverride.ForceUnavailable.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestMode$activate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestMode", f = "TestMode.kt", l = {311, 313}, m = "activate")
    static final class C29291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C29291(Continuation<? super C29291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TestMode.this.activate(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestMode$presentModal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestMode", f = "TestMode.kt", l = {357, 370, 383, RCHTTPStatusCodes.BAD_REQUEST}, m = "presentModal")
    static final class C29301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C29301(Continuation<? super C29301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TestMode.this.presentModal(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.TestMode$refreshProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.TestMode", f = "TestMode.kt", l = {319}, m = "refreshProducts")
    static final class C29311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29311(Continuation<? super C29311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TestMode.this.refreshProducts(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TestMode(Storage storage, boolean z2, Function1<? super Continuation<? super Either<SuperwallProductsResponse, NetworkError>>, ? extends Object> getSuperwallProducts, Entitlements entitlements, Function0<? extends ActivityProvider> activityProvider, Function0<CurrentActivityTracker> activityTracker, Function0<Boolean> hasExternalPurchaseController, Function0<String> apiKey, Function0<String> dashboardBaseUrl, Function2<? super InternalSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(getSuperwallProducts, "getSuperwallProducts");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(activityTracker, "activityTracker");
        Intrinsics.checkNotNullParameter(hasExternalPurchaseController, "hasExternalPurchaseController");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(dashboardBaseUrl, "dashboardBaseUrl");
        Intrinsics.checkNotNullParameter(track, "track");
        this.storage = storage;
        this.isTestEnvironment = z2;
        this.getSuperwallProducts = getSuperwallProducts;
        this.entitlements = entitlements;
        this.activityProvider = activityProvider;
        this.activityTracker = activityTracker;
        this.hasExternalPurchaseController = hasExternalPurchaseController;
        this.apiKey = apiKey;
        this.dashboardBaseUrl = dashboardBaseUrl;
        this.track = track;
        this.state = TestModeState.Inactive.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$2() {
        return "";
    }

    private final void activateWithReason(TestModeReason testModeReason) {
        TestModeState.Active active;
        TestModeState testModeState = this.state;
        if (testModeState instanceof TestModeState.Active) {
            TestModeState.Active active2 = (TestModeState.Active) testModeState;
            if (!Intrinsics.areEqual(active2.getReason(), testModeReason)) {
                active2.getSession().getEntitlementIds().clear();
                active2.getSession().setEntitlementSelections(CollectionsKt.emptyList());
                active2.getSession().setOverriddenSubscriptionStatus(null);
                this.storage.write(IsTestModeActiveSubscription.INSTANCE, Boolean.FALSE);
            }
            active = TestModeState.Active.copy$default(active2, testModeReason, null, 2, null);
        } else {
            active = new TestModeState.Active(testModeReason, null, 2, null);
        }
        this.state = active;
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.info;
        LogScope logScope = LogScope.superwallCore;
        TestModeReason testModeReason2 = getTestModeReason();
        Logger.debug$default(logger, logLevel, logScope, "Test mode activated: " + (testModeReason2 != null ? testModeReason2.getDescription() : null), (Map) null, (Throwable) null, 24, (Object) null);
    }

    /* JADX INFO: renamed from: awaitTestProducts-VtjQ1oo$default, reason: not valid java name */
    public static /* synthetic */ Object m1343awaitTestProductsVtjQ1oo$default(TestMode testMode, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            Duration.Companion companion = Duration.f140631b;
            j3 = DurationKt.s(5, DurationUnit.f140641f);
        }
        return testMode.m1344awaitTestProductsVtjQ1oo(j3, continuation);
    }

    private final boolean checkConfigMatch(Config config, String str, String str2) {
        boolean zAreEqual;
        List<TestStoreUser> testModeUserIds = config.getTestModeUserIds();
        if (testModeUserIds == null) {
            return false;
        }
        for (TestStoreUser testStoreUser : testModeUserIds) {
            int i3 = WhenMappings.$EnumSwitchMapping$1[testStoreUser.getType().ordinal()];
            if (i3 == 1) {
                zAreEqual = Intrinsics.areEqual(str, testStoreUser.getValue());
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                zAreEqual = Intrinsics.areEqual(str2, testStoreUser.getValue());
            }
            if (zAreEqual) {
                activateWithReason(new TestModeReason.ConfigMatch(testStoreUser.getValue()));
                return true;
            }
        }
        return false;
    }

    private final boolean checkPackageNameMismatch(Config config, String str) {
        String bundleIdConfig = config.getBundleIdConfig();
        if (bundleIdConfig == null || bundleIdConfig.length() == 0 || Intrinsics.areEqual(bundleIdConfig, str)) {
            return false;
        }
        if (StringsKt.U(str, bundleIdConfig + ".", false, 2, null)) {
            return false;
        }
        activateWithReason(new TestModeReason.ApplicationIdMismatch(bundleIdConfig, str));
        return true;
    }

    private final void deactivateIfActive() {
        if (isTestMode()) {
            clearTestModeState();
        }
    }

    public static /* synthetic */ void evaluateTestMode$default(TestMode testMode, Config config, String str, String str2, String str3, TestModeBehavior testModeBehavior, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            testModeBehavior = TestModeBehavior.AUTOMATIC;
        }
        testMode.evaluateTestMode(config, str, str2, str3, testModeBehavior);
    }

    private final TestModeSessionData getSession() {
        TestModeState testModeState = this.state;
        TestModeState.Active active = testModeState instanceof TestModeState.Active ? (TestModeState.Active) testModeState : null;
        if (active != null) {
            return active.getSession();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTestEnvironment_delegate$lambda$22() {
        Object objB;
        Object objB2;
        Object objB3;
        try {
            try {
                Result.Companion companion = Result.f139772b;
                Class.forName("org.junit.Test");
                objB = Result.b(Boolean.TRUE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(ResultKt.a(th));
            }
            Object obj = null;
            if (Result.g(objB)) {
                objB = null;
            }
            Boolean bool = (Boolean) objB;
            if (!(bool != null ? bool.booleanValue() : false)) {
                try {
                    Class.forName("androidx.test.espresso.Espresso");
                    objB2 = Result.b(Boolean.TRUE);
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.f139772b;
                    objB2 = Result.b(ResultKt.a(th2));
                }
                if (Result.g(objB2)) {
                    objB2 = null;
                }
                Boolean bool2 = (Boolean) objB2;
                if (!(bool2 != null ? bool2.booleanValue() : false)) {
                    try {
                        Class.forName("android.support.test.espresso.Espresso");
                        objB3 = Result.b(Boolean.TRUE);
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.f139772b;
                        objB3 = Result.b(ResultKt.a(th3));
                    }
                    if (!Result.g(objB3)) {
                        obj = objB3;
                    }
                    Boolean bool3 = (Boolean) obj;
                    if (!(bool3 != null ? bool3.booleanValue() : false)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01da, code lost:
    
        if (r1.invoke(r3, r11) != r2) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object presentModal(com.superwall.sdk.models.config.Config r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.testmode.TestMode.presentModal(com.superwall.sdk.models.config.Config, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:12:0x002a, B:23:0x004b, B:25:0x0051, B:26:0x0068, B:28:0x006e, B:30:0x007d, B:32:0x0083, B:33:0x0087, B:35:0x00a6, B:36:0x00cc, B:37:0x00f8, B:39:0x00fc, B:47:0x013f, B:48:0x0144), top: B:59:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8 A[Catch: all -> 0x002e, TryCatch #1 {all -> 0x002e, blocks: (B:12:0x002a, B:23:0x004b, B:25:0x0051, B:26:0x0068, B:28:0x006e, B:30:0x007d, B:32:0x0083, B:33:0x0087, B:35:0x00a6, B:36:0x00cc, B:37:0x00f8, B:39:0x00fc, B:47:0x013f, B:48:0x0144), top: B:59:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshProducts(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.testmode.TestMode.refreshProducts(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r2.presentModal(r6, r0) == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object activate(com.superwall.sdk.models.config.Config r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.store.testmode.TestMode.C29291
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.store.testmode.TestMode$activate$1 r0 = (com.superwall.sdk.store.testmode.TestMode.C29291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.store.testmode.TestMode$activate$1 r0 = new com.superwall.sdk.store.testmode.TestMode$activate$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L65
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            com.superwall.sdk.models.config.Config r6 = (com.superwall.sdk.models.config.Config) r6
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.store.testmode.TestMode r2 = (com.superwall.sdk.store.testmode.TestMode) r2
            kotlin.ResultKt.b(r8)
            goto L55
        L42:
            kotlin.ResultKt.b(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.refreshProducts(r0)
            if (r8 != r1) goto L54
            goto L64
        L54:
            r2 = r5
        L55:
            if (r7 == 0) goto L68
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r2.presentModal(r6, r0)
            if (r6 != r1) goto L65
        L64:
            return r1
        L65:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L68:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.testmode.TestMode.activate(com.superwall.sdk.models.config.Config, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Set<String> allEntitlements() {
        List<SuperwallProduct> products = getProducts();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = products.iterator();
        while (it.hasNext()) {
            List<SuperwallEntitlementRef> entitlements = ((SuperwallProduct) it.next()).getEntitlements();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(entitlements, 10));
            Iterator<T> it2 = entitlements.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((SuperwallEntitlementRef) it2.next()).getIdentifier());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return CollectionsKt.toSet(arrayList);
    }

    /* JADX INFO: renamed from: awaitTestProducts-VtjQ1oo, reason: not valid java name */
    public final Object m1344awaitTestProductsVtjQ1oo(long j3, Continuation<? super Unit> continuation) {
        TestModeSessionData session = getSession();
        return session == null ? Unit.f139807a : TimeoutKt.f(j3, new TestMode$awaitTestProducts$2(session, null), continuation);
    }

    public final SubscriptionStatus buildSubscriptionStatus() {
        if (getTestEntitlementIds().isEmpty()) {
            return SubscriptionStatus.Inactive.INSTANCE;
        }
        List<EntitlementSelection> testEntitlementSelections = getTestEntitlementSelections();
        ArrayList arrayList = new ArrayList();
        for (Object obj : testEntitlementSelections) {
            if (((EntitlementSelection) obj).getState().isActive()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            Set<String> testEntitlementIds = getTestEntitlementIds();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(testEntitlementIds, 10));
            Iterator<T> it = testEntitlementIds.iterator();
            while (it.hasNext()) {
                arrayList2.add(new Entitlement((String) it.next()));
            }
            return new SubscriptionStatus.Active(CollectionsKt.toSet(arrayList2));
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList3.add(((EntitlementSelection) obj2).toEntitlement());
        }
        return new SubscriptionStatus.Active(CollectionsKt.toSet(arrayList3));
    }

    public final void clearSettings() {
        this.storage.delete(StoredTestModeSettings.INSTANCE);
    }

    public final void clearTestModeState() {
        this.state = TestModeState.Inactive.INSTANCE;
        this.storage.delete(IsTestModeActiveSubscription.INSTANCE);
        clearSettings();
    }

    public final List<SuperwallEntitlementRef> entitlementsForProduct(SuperwallProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return product.getEntitlements();
    }

    public final void evaluateTestMode(Config config, String bundleId, String str, String str2, TestModeBehavior testModeBehavior) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bundleId, "bundleId");
        Intrinsics.checkNotNullParameter(testModeBehavior, "testModeBehavior");
        int i3 = WhenMappings.$EnumSwitchMapping$0[testModeBehavior.ordinal()];
        if (i3 == 1) {
            deactivateIfActive();
            return;
        }
        if (i3 == 2) {
            activateWithReason(TestModeReason.TestModeOption.INSTANCE);
            return;
        }
        if (i3 == 3) {
            if (checkConfigMatch(config, str, str2)) {
                return;
            }
            deactivateIfActive();
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.isTestEnvironment) {
                deactivateIfActive();
            } else {
                if (checkConfigMatch(config, str, str2) || checkPackageNameMismatch(config, bundleId)) {
                    return;
                }
                deactivateIfActive();
            }
        }
    }

    public final void fakePurchase(List<SuperwallEntitlementRef> entitlementRefs) {
        Set<String> entitlementIds;
        Intrinsics.checkNotNullParameter(entitlementRefs, "entitlementRefs");
        List<SuperwallEntitlementRef> list = entitlementRefs;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SuperwallEntitlementRef) it.next()).getIdentifier());
        }
        TestModeSessionData session = getSession();
        if (session != null && (entitlementIds = session.getEntitlementIds()) != null) {
            entitlementIds.addAll(arrayList);
        }
        this.storage.write(IsTestModeActiveSubscription.INSTANCE, Boolean.valueOf(!getTestEntitlementIds().isEmpty()));
    }

    public final FreeTrialOverride getFreeTrialOverride() {
        FreeTrialOverride freeTrialOverride;
        TestModeSessionData session = getSession();
        return (session == null || (freeTrialOverride = session.getFreeTrialOverride()) == null) ? FreeTrialOverride.UseDefault : freeTrialOverride;
    }

    public final SubscriptionStatus getOverriddenSubscriptionStatus() {
        TestModeSessionData session = getSession();
        if (session != null) {
            return session.getOverriddenSubscriptionStatus();
        }
        return null;
    }

    public final List<SuperwallProduct> getProducts() {
        List<SuperwallProduct> products;
        TestModeSessionData session = getSession();
        return (session == null || (products = session.getProducts()) == null) ? CollectionsKt.emptyList() : products;
    }

    public final TestModeState getState() {
        return this.state;
    }

    public final Set<String> getTestEntitlementIds() {
        Set<String> entitlementIds;
        TestModeSessionData session = getSession();
        return (session == null || (entitlementIds = session.getEntitlementIds()) == null) ? SetsKt.emptySet() : entitlementIds;
    }

    public final List<EntitlementSelection> getTestEntitlementSelections() {
        List<EntitlementSelection> entitlementSelections;
        TestModeSessionData session = getSession();
        return (session == null || (entitlementSelections = session.getEntitlementSelections()) == null) ? CollectionsKt.emptyList() : entitlementSelections;
    }

    public final TestModeReason getTestModeReason() {
        TestModeState testModeState = this.state;
        TestModeState.Active active = testModeState instanceof TestModeState.Active ? (TestModeState.Active) testModeState : null;
        if (active != null) {
            return active.getReason();
        }
        return null;
    }

    public final Map<String, StoreProduct> getTestProductsByFullId$superwall_release() {
        Map<String, StoreProduct> testProductsByFullId;
        TestModeSessionData session = getSession();
        return (session == null || (testProductsByFullId = session.getTestProductsByFullId()) == null) ? MapsKt.emptyMap() : testProductsByFullId;
    }

    public final boolean isTestMode() {
        return this.state instanceof TestModeState.Active;
    }

    public final TestModeSettings loadSettings() {
        return (TestModeSettings) this.storage.read(StoredTestModeSettings.INSTANCE);
    }

    public final void resetEntitlements() {
        Set<String> entitlementIds;
        TestModeSessionData session = getSession();
        if (session != null && (entitlementIds = session.getEntitlementIds()) != null) {
            entitlementIds.clear();
        }
        TestModeSessionData session2 = getSession();
        if (session2 != null) {
            session2.setEntitlementSelections(CollectionsKt.emptyList());
        }
        this.storage.write(IsTestModeActiveSubscription.INSTANCE, Boolean.FALSE);
    }

    public final void saveSettings() {
        this.storage.write(StoredTestModeSettings.INSTANCE, new TestModeSettings(getTestEntitlementSelections(), getFreeTrialOverride()));
    }

    public final void setEntitlements(List<EntitlementSelection> selections) {
        Intrinsics.checkNotNullParameter(selections, "selections");
        TestModeSessionData session = getSession();
        if (session == null) {
            return;
        }
        session.setEntitlementSelections(selections);
        session.getEntitlementIds().clear();
        Set<String> entitlementIds = session.getEntitlementIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : selections) {
            if (((EntitlementSelection) obj).getState().isActive()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((EntitlementSelection) obj2).getIdentifier());
        }
        entitlementIds.addAll(arrayList2);
        this.storage.write(IsTestModeActiveSubscription.INSTANCE, Boolean.valueOf(!session.getEntitlementIds().isEmpty()));
    }

    public final void setFreeTrialOverride(FreeTrialOverride override) {
        Intrinsics.checkNotNullParameter(override, "override");
        TestModeSessionData session = getSession();
        if (session != null) {
            session.setFreeTrialOverride(override);
        }
    }

    public final void setOverriddenSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        TestModeSessionData session = getSession();
        if (session != null) {
            session.setOverriddenSubscriptionStatus(subscriptionStatus);
        }
    }

    public final void setProducts(List<SuperwallProduct> products) {
        Intrinsics.checkNotNullParameter(products, "products");
        TestModeSessionData session = getSession();
        if (session != null) {
            session.setProducts(products);
        }
    }

    public final void setTestProducts(Map<String, StoreProduct> productsByFullId) {
        Intrinsics.checkNotNullParameter(productsByFullId, "productsByFullId");
        TestModeSessionData session = getSession();
        if (session != null) {
            session.setTestProductsByFullId(productsByFullId);
            session.getProductsLoaded().J(Unit.f139807a);
        }
    }

    public final boolean shouldShowFreeTrial(boolean z2) {
        int i3 = WhenMappings.$EnumSwitchMapping$2[getFreeTrialOverride().ordinal()];
        if (i3 == 1) {
            return z2;
        }
        if (i3 == 2) {
            return true;
        }
        if (i3 == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ TestMode(Storage storage, boolean z2, Function1 function1, Entitlements entitlements, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage, (i3 & 2) != 0 ? Companion.isTestEnvironment() : z2, (i3 & 4) != 0 ? new AnonymousClass1(null) : function1, (i3 & 8) != 0 ? null : entitlements, (i3 & 16) != 0 ? new Function0() { // from class: com.superwall.sdk.store.testmode.TestMode.2
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        } : function0, (i3 & 32) != 0 ? new Function0() { // from class: com.superwall.sdk.store.testmode.TestMode.3
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        } : function02, (i3 & 64) != 0 ? new Function0() { // from class: com.superwall.sdk.store.testmode.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TestMode._init_$lambda$0());
            }
        } : function03, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new Function0() { // from class: com.superwall.sdk.store.testmode.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestMode._init_$lambda$1();
            }
        } : function04, (i3 & Function.MAX_NARGS) != 0 ? new Function0() { // from class: com.superwall.sdk.store.testmode.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TestMode._init_$lambda$2();
            }
        } : function05, (i3 & 512) != 0 ? new AnonymousClass7(null) : function2);
    }

    public final void setEntitlements(Set<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Set<String> set = ids;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(new EntitlementSelection((String) it.next(), EntitlementStateOption.Subscribed, (OfferTypeOption) null, 4, (DefaultConstructorMarker) null));
        }
        setEntitlements(arrayList);
    }
}
