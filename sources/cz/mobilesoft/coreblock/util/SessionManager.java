package cz.mobilesoft.coreblock.util;

import android.content.Context;
import androidx.credentials.CredentialManager;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.enums.EmailConsentState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.TokenFCMRepository;
import cz.mobilesoft.coreblock.rest.response.LoginResponse;
import cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class SessionManager implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionManager f127910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f127911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f127912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f127913d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f127914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f127915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final StateFlow f127916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f127917i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class SignInState {
        public /* synthetic */ SignInState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private SignInState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SignedIn extends SignInState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f127919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f127920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f127921d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f127922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f127923f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f127924g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedIn(String token, String customerId, String userEmail, String str, String str2, String str3, String str4) {
            super(null);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(customerId, "customerId");
            Intrinsics.checkNotNullParameter(userEmail, "userEmail");
            this.f127918a = token;
            this.f127919b = customerId;
            this.f127920c = userEmail;
            this.f127921d = str;
            this.f127922e = str2;
            this.f127923f = str3;
            this.f127924g = str4;
        }

        public final String a() {
            return this.f127919b;
        }

        public final String b() {
            return this.f127922e;
        }

        public final String c() {
            return this.f127921d;
        }

        public final String d() {
            return this.f127918a;
        }

        public final String e() {
            return this.f127920c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SignedIn)) {
                return false;
            }
            SignedIn signedIn = (SignedIn) obj;
            return Intrinsics.areEqual(this.f127918a, signedIn.f127918a) && Intrinsics.areEqual(this.f127919b, signedIn.f127919b) && Intrinsics.areEqual(this.f127920c, signedIn.f127920c) && Intrinsics.areEqual(this.f127921d, signedIn.f127921d) && Intrinsics.areEqual(this.f127922e, signedIn.f127922e) && Intrinsics.areEqual(this.f127923f, signedIn.f127923f) && Intrinsics.areEqual(this.f127924g, signedIn.f127924g);
        }

        public final String f() {
            return this.f127924g;
        }

        public final String g() {
            return this.f127923f;
        }

        public int hashCode() {
            int iHashCode = ((((this.f127918a.hashCode() * 31) + this.f127919b.hashCode()) * 31) + this.f127920c.hashCode()) * 31;
            String str = this.f127921d;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f127922e;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f127923f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f127924g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "SignedIn(token=" + this.f127918a + ", customerId=" + this.f127919b + ", userEmail=" + this.f127920c + ", provider=" + this.f127921d + ", nickName=" + this.f127922e + ", userRegisteredAt=" + this.f127923f + ", userPicture=" + this.f127924g + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SignedOut extends SignInState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SignedOut f127925a = new SignedOut();

        private SignedOut() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SignedOut);
        }

        public int hashCode() {
            return -2017315044;
        }

        public String toString() {
            return "SignedOut";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final SessionManager sessionManager = new SessionManager();
        f127910a = sessionManager;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f127911b = LazyKt.a(lazyThreadSafetyModeB, new Function0<TokenFCMRepository>() { // from class: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = sessionManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TokenFCMRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f127912c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = sessionManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f127913d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = sessionManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f127914f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakSnapshotSync>() { // from class: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = sessionManager;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakSnapshotSync.class), objArr6, objArr7);
            }
        });
        f127915g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionManager.q();
            }
        });
        final Flow[] flowArr = {sessionManager.k().O(), sessionManager.k().H(), sessionManager.k().S(), sessionManager.k().R(), sessionManager.k().L(), sessionManager.k().N(), sessionManager.k().T()};
        Flow<SignInState> flow = new Flow<SignInState>() { // from class: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$combine$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$combine$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$combine$1$3", f = "SessionManager.kt", l = {234}, m = "invokeSuspend", v = 1)
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super SessionManager.SignInState>, Object[], Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f127966a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f127967b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                /* synthetic */ Object f127968c;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.f127967b = flowCollector;
                    anonymousClass3.f127968c = objArr;
                    return anonymousClass3.invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object signedIn;
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f127966a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        FlowCollector flowCollector = (FlowCollector) this.f127967b;
                        Object[] objArr = (Object[]) this.f127968c;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        Object obj7 = objArr[5];
                        String str = (String) objArr[6];
                        String str2 = (String) obj7;
                        String str3 = (String) obj6;
                        String str4 = (String) obj5;
                        String str5 = (String) obj4;
                        String str6 = (String) obj3;
                        String str7 = (String) obj2;
                        if (str7.length() == 0 || str5.length() == 0) {
                            signedIn = SessionManager.SignedOut.f127925a;
                        } else {
                            if (Intrinsics.areEqual(str4, "")) {
                                str4 = null;
                            }
                            signedIn = new SessionManager.SignedIn(str7, str6, str5, str4, str3, DateHelperExtKt.b(str2, "MMMM yyyy"), str);
                        }
                        this.f127967b = SpillingKt.a(flowCollector);
                        this.f127968c = SpillingKt.a(objArr);
                        this.f127966a = 1;
                        if (flowCollector.emit(signedIn, this) == objF) {
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

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object objA = CombineKt.a(flowCollector, flowArr2, new Function0<Object[]>() { // from class: cz.mobilesoft.coreblock.util.SessionManager$special$$inlined$combine$1.2
                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Object[] invoke() {
                        return new Object[flowArr2.length];
                    }
                }, new AnonymousClass3(null), continuation);
                return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
            }
        };
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        f127916h = FlowKt.h0(flow, applicationScope, SharingStarted.f142210a.c(), SignedOut.f127925a);
        f127917i = 8;
    }

    private SessionManager() {
    }

    public static /* synthetic */ Object A(SessionManager sessionManager, Function2 function2, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function2 = null;
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return sessionManager.z(function2, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0101, code lost:
    
        if (r7.g(r0) != r1) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SessionManager.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final CredentialManager h() {
        return (CredentialManager) f127915g.getValue();
    }

    private final PremiumRepositoryV2 i() {
        return (PremiumRepositoryV2) f127913d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore k() {
        return (SessionDataStore) f127912c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakSnapshotSync m() {
        return (StreakSnapshotSync) f127914f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TokenFCMRepository o() {
        return (TokenFCMRepository) f127911b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CredentialManager q() {
        CredentialManager.Companion companion = CredentialManager.f34753a;
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
        return companion.a(contextG);
    }

    public static /* synthetic */ Object u(SessionManager sessionManager, LoginResponse loginResponse, String str, String str2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        return sessionManager.t(loginResponse, str, str2, continuation);
    }

    private final Object v(boolean z2, String str, Function2 function2, Continuation continuation) {
        Object objG;
        return (function2 == null || (objG = BuildersKt.g(Dispatchers.c(), new SessionManager$onSignedOut$2$1(function2, z2, str, null), continuation)) != IntrinsicsKt.f()) ? Unit.f139807a : objG;
    }

    static /* synthetic */ Object w(SessionManager sessionManager, boolean z2, String str, Function2 function2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return sessionManager.v(z2, str, function2, continuation);
    }

    public final void C(String token, String str) {
        Intrinsics.checkNotNullParameter(token, "token");
        CoroutinesHelperExtKt.d(new SessionManager$tokenRefreshed$1(token, str, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x014d, code lost:
    
        if (r14.n0(r7, r0) != r1) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SessionManager.D(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.SessionManager$clearGoogleCredentials$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.SessionManager$clearGoogleCredentials$1 r0 = (cz.mobilesoft.coreblock.util.SessionManager$clearGoogleCredentials$1) r0
            int r1 = r0.f127928c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127928c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.SessionManager$clearGoogleCredentials$1 r0 = new cz.mobilesoft.coreblock.util.SessionManager$clearGoogleCredentials$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f127926a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127928c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Exception -> L29
            goto L4c
        L29:
            r6 = move-exception
            goto L49
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L33:
            kotlin.ResultKt.b(r6)
            androidx.credentials.CredentialManager r6 = r5.h()     // Catch: java.lang.Exception -> L29
            androidx.credentials.ClearCredentialStateRequest r2 = new androidx.credentials.ClearCredentialStateRequest     // Catch: java.lang.Exception -> L29
            r4 = 0
            r2.<init>(r4, r3, r4)     // Catch: java.lang.Exception -> L29
            r0.f127928c = r3     // Catch: java.lang.Exception -> L29
            java.lang.Object r6 = r6.c(r2, r0)     // Catch: java.lang.Exception -> L29
            if (r6 != r1) goto L4c
            return r1
        L49:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r6)
        L4c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SessionManager.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String g() {
        String strN = n();
        if (strN == null) {
            return null;
        }
        return "Bearer " + strN;
    }

    public final String j() {
        Object value = f127916h.getValue();
        SignedIn signedIn = value instanceof SignedIn ? (SignedIn) value : null;
        if (signedIn != null) {
            return signedIn.c();
        }
        return null;
    }

    public final StateFlow l() {
        return f127916h;
    }

    public final String n() {
        Object value = f127916h.getValue();
        SignedIn signedIn = value instanceof SignedIn ? (SignedIn) value : null;
        if (signedIn != null) {
            return signedIn.d();
        }
        return null;
    }

    public final String p(SignedIn signedIn) {
        Intrinsics.checkNotNullParameter(signedIn, "<this>");
        String strB = signedIn.b();
        return (strB == null || StringsKt.p0(strB)) ? "" : signedIn.b();
    }

    public final boolean r() {
        return f127916h.getValue() instanceof SignedIn;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(android.app.Activity r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.util.SessionManager$launchGoogleSignIn$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.util.SessionManager$launchGoogleSignIn$1 r0 = (cz.mobilesoft.coreblock.util.SessionManager$launchGoogleSignIn$1) r0
            int r1 = r0.f127934g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127934g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.SessionManager$launchGoogleSignIn$1 r0 = new cz.mobilesoft.coreblock.util.SessionManager$launchGoogleSignIn$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f127932d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127934g
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.f127931c
            androidx.credentials.GetCredentialRequest r8 = (androidx.credentials.GetCredentialRequest) r8
            java.lang.Object r8 = r0.f127930b
            com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption r8 = (com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption) r8
            java.lang.Object r8 = r0.f127929a
            android.app.Activity r8 = (android.app.Activity) r8
            kotlin.ResultKt.b(r9)
            goto L8f
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.ResultKt.b(r9)
            com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption$Builder r9 = new com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption$Builder
            android.content.Context r2 = cz.mobilesoft.coreblock.LockieApplication.g()
            int r4 = cz.mobilesoft.coreblock.R.string.ni
            java.lang.String r2 = r2.getString(r4)
            java.lang.String r4 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r9.<init>(r2)
            com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption r9 = r9.a()
            androidx.credentials.GetCredentialRequest$Builder r2 = new androidx.credentials.GetCredentialRequest$Builder
            r2.<init>()
            androidx.credentials.GetCredentialRequest$Builder r2 = r2.a(r9)
            androidx.credentials.GetCredentialRequest r2 = r2.b()
            androidx.credentials.CredentialManager$Companion r4 = androidx.credentials.CredentialManager.f34753a
            android.content.Context r5 = cz.mobilesoft.coreblock.LockieApplication.g()
            java.lang.String r6 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            androidx.credentials.CredentialManager r4 = r4.a(r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f127929a = r5
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f127930b = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f127931c = r9
            r0.f127934g = r3
            java.lang.Object r9 = r4.b(r8, r2, r0)
            if (r9 != r1) goto L8f
            return r1
        L8f:
            androidx.credentials.GetCredentialResponse r9 = (androidx.credentials.GetCredentialResponse) r9
            androidx.credentials.Credential r8 = r9.a()
            java.lang.String r9 = r8.b()
            java.lang.String r0 = "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            r0 = 0
            if (r9 == 0) goto Lb5
            com.google.android.libraries.identity.googleid.GoogleIdTokenCredential$Companion r9 = com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.f74623k     // Catch: java.lang.Exception -> Lb1
            android.os.Bundle r8 = r8.a()     // Catch: java.lang.Exception -> Lb1
            com.google.android.libraries.identity.googleid.GoogleIdTokenCredential r8 = r9.a(r8)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r0 = r8.c()     // Catch: java.lang.Exception -> Lb1
            goto Lb5
        Lb1:
            r8 = move-exception
            cz.mobilesoft.coreblock.util.CrashHelper.j(r8)
        Lb5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SessionManager.s(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0263, code lost:
    
        if (r0.c0(r7, r1) != r3) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0147 A[PHI: r4 r6 r7
      0x0147: PHI (r4v10 java.lang.String) = (r4v7 java.lang.String), (r4v12 java.lang.String) binds: [B:36:0x0143, B:19:0x00aa] A[DONT_GENERATE, DONT_INLINE]
      0x0147: PHI (r6v10 java.lang.String) = (r6v7 java.lang.String), (r6v12 java.lang.String) binds: [B:36:0x0143, B:19:0x00aa] A[DONT_GENERATE, DONT_INLINE]
      0x0147: PHI (r7v9 cz.mobilesoft.coreblock.rest.response.LoginResponse) = (r7v6 cz.mobilesoft.coreblock.rest.response.LoginResponse), (r7v11 cz.mobilesoft.coreblock.rest.response.LoginResponse) binds: [B:36:0x0143, B:19:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0168 A[PHI: r4 r6 r7
      0x0168: PHI (r4v13 java.lang.String) = (r4v10 java.lang.String), (r4v15 java.lang.String) binds: [B:39:0x0164, B:18:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r6v13 java.lang.String) = (r6v10 java.lang.String), (r6v15 java.lang.String) binds: [B:39:0x0164, B:18:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r7v12 cz.mobilesoft.coreblock.rest.response.LoginResponse) = (r7v9 cz.mobilesoft.coreblock.rest.response.LoginResponse), (r7v14 cz.mobilesoft.coreblock.rest.response.LoginResponse) binds: [B:39:0x0164, B:18:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018c A[PHI: r4 r6 r7
      0x018c: PHI (r4v16 java.lang.String) = (r4v13 java.lang.String), (r4v18 java.lang.String) binds: [B:45:0x0188, B:17:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x018c: PHI (r6v16 java.lang.String) = (r6v13 java.lang.String), (r6v18 java.lang.String) binds: [B:45:0x0188, B:17:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x018c: PHI (r7v15 cz.mobilesoft.coreblock.rest.response.LoginResponse) = 
      (r7v12 cz.mobilesoft.coreblock.rest.response.LoginResponse)
      (r7v17 cz.mobilesoft.coreblock.rest.response.LoginResponse)
     binds: [B:45:0x0188, B:17:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b0 A[PHI: r4 r6 r7
      0x01b0: PHI (r4v19 java.lang.String) = (r4v16 java.lang.String), (r4v21 java.lang.String) binds: [B:51:0x01ac, B:16:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x01b0: PHI (r6v19 java.lang.String) = (r6v16 java.lang.String), (r6v21 java.lang.String) binds: [B:51:0x01ac, B:16:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x01b0: PHI (r7v18 cz.mobilesoft.coreblock.rest.response.LoginResponse) = 
      (r7v15 cz.mobilesoft.coreblock.rest.response.LoginResponse)
      (r7v20 cz.mobilesoft.coreblock.rest.response.LoginResponse)
     binds: [B:51:0x01ac, B:16:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d4 A[PHI: r4 r6 r7
      0x01d4: PHI (r4v22 java.lang.String) = (r4v19 java.lang.String), (r4v24 java.lang.String) binds: [B:57:0x01d0, B:15:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x01d4: PHI (r6v22 java.lang.String) = (r6v19 java.lang.String), (r6v24 java.lang.String) binds: [B:57:0x01d0, B:15:0x0066] A[DONT_GENERATE, DONT_INLINE]
      0x01d4: PHI (r7v21 cz.mobilesoft.coreblock.rest.response.LoginResponse) = 
      (r7v18 cz.mobilesoft.coreblock.rest.response.LoginResponse)
      (r7v23 cz.mobilesoft.coreblock.rest.response.LoginResponse)
     binds: [B:57:0x01d0, B:15:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f8 A[PHI: r4 r6 r7
      0x01f8: PHI (r4v25 java.lang.String) = (r4v22 java.lang.String), (r4v27 java.lang.String) binds: [B:63:0x01f5, B:14:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01f8: PHI (r6v25 java.lang.String) = (r6v22 java.lang.String), (r6v28 java.lang.String) binds: [B:63:0x01f5, B:14:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01f8: PHI (r7v24 cz.mobilesoft.coreblock.rest.response.LoginResponse) = 
      (r7v21 cz.mobilesoft.coreblock.rest.response.LoginResponse)
      (r7v26 cz.mobilesoft.coreblock.rest.response.LoginResponse)
     binds: [B:63:0x01f5, B:14:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(cz.mobilesoft.coreblock.rest.response.LoginResponse r17, java.lang.String r18, java.lang.String r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SessionManager.t(cz.mobilesoft.coreblock.rest.response.LoginResponse, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object x(EmailConsentState emailConsentState, Continuation continuation) {
        Object objC0 = k().c0(emailConsentState, continuation);
        return objC0 == IntrinsicsKt.f() ? objC0 : Unit.f139807a;
    }

    public final Object y(String str, Continuation continuation) {
        Object objF0 = k().f0(str, continuation);
        return objF0 == IntrinsicsKt.f() ? objF0 : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0145, code lost:
    
        if (f(r5) == r0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0193, code lost:
    
        if (w(r11, true, null, r4, r5, 2, null) != r0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01e7, code lost:
    
        if (v(false, r6, r3, r5) != r0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x022e, code lost:
    
        if (w(r4, true, null, r12, r5, 2, null) == r0) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[PHI: r1 r2 r3 r12 r13
      0x0081: PHI (r1v21 java.lang.String) = (r1v18 java.lang.String), (r1v24 java.lang.String) binds: [B:46:0x0168, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r2v16 java.lang.String) = (r2v13 java.lang.String), (r2v19 java.lang.String) binds: [B:46:0x0168, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r3v9 kotlin.jvm.functions.Function2) = (r3v6 kotlin.jvm.functions.Function2), (r3v12 kotlin.jvm.functions.Function2) binds: [B:46:0x0168, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r12v15 boolean) = (r12v13 boolean), (r12v18 boolean) binds: [B:46:0x0168, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r13v17 cz.mobilesoft.coreblock.rest.ApiResponse) = (r13v14 cz.mobilesoft.coreblock.rest.ApiResponse), (r13v20 cz.mobilesoft.coreblock.rest.ApiResponse) binds: [B:46:0x0168, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0218 A[PHI: r4 r12 r13
      0x0218: PHI (r4v9 cz.mobilesoft.coreblock.util.SessionManager) = (r4v7 cz.mobilesoft.coreblock.util.SessionManager), (r4v11 cz.mobilesoft.coreblock.util.SessionManager) binds: [B:71:0x0201, B:76:0x0215] A[DONT_GENERATE, DONT_INLINE]
      0x0218: PHI (r12v33 kotlin.jvm.functions.Function2) = (r12v29 kotlin.jvm.functions.Function2), (r12v36 kotlin.jvm.functions.Function2) binds: [B:71:0x0201, B:76:0x0215] A[DONT_GENERATE, DONT_INLINE]
      0x0218: PHI (r13v24 boolean) = (r13v21 boolean), (r13v27 boolean) binds: [B:71:0x0201, B:76:0x0215] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(kotlin.jvm.functions.Function2 r12, boolean r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SessionManager.z(kotlin.jvm.functions.Function2, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
