package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Singleton
@Metadata
public final class SharedSessionRepositoryImpl implements SharedSessionRepository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SessionsSettings f90070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SessionGenerator f90071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SessionFirelogPublisher f90072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeProvider f90073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataStore f90074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ProcessDataManager f90075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineContext f90076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SessionData f90077i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f90078j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private NotificationType f90079k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f90080l;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$1", f = "SharedSessionRepository.kt", l = {94}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f90081a;

        /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$1$1", f = "SharedSessionRepository.kt", l = {92}, m = "invokeSuspend")
        static final class C01671 extends SuspendLambda implements Function3<FlowCollector<? super SessionData>, Throwable, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f90083a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f90084b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f90085c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ SharedSessionRepositoryImpl f90086d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01671(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation continuation) {
                super(3, continuation);
                this.f90086d = sharedSessionRepositoryImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f90083a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    FlowCollector flowCollector = (FlowCollector) this.f90084b;
                    Throwable th = (Throwable) this.f90085c;
                    SessionData sessionData = new SessionData(this.f90086d.f90071c.a(null), (Time) null, (Map) null, 4, (DefaultConstructorMarker) null);
                    Log.d("FirebaseSessions", "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + sessionData.f().b());
                    this.f90084b = null;
                    this.f90083a = 1;
                    if (flowCollector.emit(sessionData, this) == objF) {
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

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
                C01671 c01671 = new C01671(this.f90086d, continuation);
                c01671.f90084b = flowCollector;
                c01671.f90085c = th;
                return c01671.invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SharedSessionRepositoryImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f90081a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowH = FlowKt.h(SharedSessionRepositoryImpl.this.f90074f.getData(), new C01671(SharedSessionRepositoryImpl.this, null));
                final SharedSessionRepositoryImpl sharedSessionRepositoryImpl = SharedSessionRepositoryImpl.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.google.firebase.sessions.SharedSessionRepositoryImpl.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(SessionData sessionData, Continuation continuation) throws Throwable {
                        sharedSessionRepositoryImpl.r(sessionData);
                        Object objQ = sharedSessionRepositoryImpl.q(sessionData.f().b(), NotificationType.f90088a, continuation);
                        return objQ == IntrinsicsKt.f() ? objQ : Unit.f139807a;
                    }
                };
                this.f90081a = 1;
                if (flowH.collect(flowCollector, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotificationType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NotificationType f90088a = new NotificationType("GENERAL", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final NotificationType f90089b = new NotificationType("FALLBACK", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ NotificationType[] f90090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f90091d;

        static {
            NotificationType[] notificationTypeArrA = a();
            f90090c = notificationTypeArrA;
            f90091d = EnumEntriesKt.a(notificationTypeArrA);
        }

        private NotificationType(String str, int i3) {
        }

        private static final /* synthetic */ NotificationType[] a() {
            return new NotificationType[]{f90088a, f90089b};
        }

        public static NotificationType valueOf(String str) {
            return (NotificationType) Enum.valueOf(NotificationType.class, str);
        }

        public static NotificationType[] values() {
            return (NotificationType[]) f90090c.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f90092a;

        static {
            int[] iArr = new int[NotificationType.values().length];
            try {
                iArr[NotificationType.f90088a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationType.f90089b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f90092a = iArr;
        }
    }

    public SharedSessionRepositoryImpl(SessionsSettings sessionsSettings, SessionGenerator sessionGenerator, SessionFirelogPublisher sessionFirelogPublisher, TimeProvider timeProvider, DataStore sessionDataStore, ProcessDataManager processDataManager, CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(sessionsSettings, "sessionsSettings");
        Intrinsics.checkNotNullParameter(sessionGenerator, "sessionGenerator");
        Intrinsics.checkNotNullParameter(sessionFirelogPublisher, "sessionFirelogPublisher");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(sessionDataStore, "sessionDataStore");
        Intrinsics.checkNotNullParameter(processDataManager, "processDataManager");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.f90070b = sessionsSettings;
        this.f90071c = sessionGenerator;
        this.f90072d = sessionFirelogPublisher;
        this.f90073e = timeProvider;
        this.f90074f = sessionDataStore;
        this.f90075g = processDataManager;
        this.f90076h = backgroundDispatcher;
        this.f90079k = NotificationType.f90088a;
        this.f90080l = "";
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(SessionData sessionData) {
        Map mapE = sessionData.e();
        if (mapE == null) {
            Log.d("FirebaseSessions", "No process data map");
            return true;
        }
        boolean zE = this.f90075g.e(mapE);
        if (zE) {
            Log.d("FirebaseSessions", "Cold app start detected");
        }
        return zE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(SessionData sessionData) {
        Map mapE = sessionData.e();
        if (mapE == null) {
            Log.d("FirebaseSessions", "No process data for " + this.f90075g.a());
            return true;
        }
        boolean zB = this.f90075g.b(mapE);
        if (zB) {
            Log.d("FirebaseSessions", "Process " + this.f90075g.a() + " is stale");
        }
        return zB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(SessionData sessionData) {
        Time timeD = sessionData.d();
        if (timeD == null) {
            Log.d("FirebaseSessions", "Session " + sessionData.f().b() + " has not backgrounded yet");
            return false;
        }
        boolean z2 = Duration.h(this.f90073e.a().c(timeD), this.f90070b.b()) > 0;
        if (z2) {
            Log.d("FirebaseSessions", "Session " + sessionData.f().b() + " is expired");
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(java.lang.String r6, com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SharedSessionRepositoryImpl.q(java.lang.String, com.google.firebase.sessions.SharedSessionRepositoryImpl$NotificationType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public boolean a() {
        return this.f90078j;
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public void b() {
        this.f90078j = false;
        if (this.f90077i == null) {
            Log.d("FirebaseSessions", "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d("FirebaseSessions", "App backgrounded on " + this.f90075g.a());
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(this.f90076h), null, null, new SharedSessionRepositoryImpl$appBackground$1(this, null), 3, null);
    }

    @Override // com.google.firebase.sessions.SharedSessionRepository
    public void c() {
        this.f90078j = true;
        if (this.f90077i == null) {
            Log.d("FirebaseSessions", "App foregrounded, but local SessionData not initialized");
            return;
        }
        SessionData sessionDataM = m();
        Log.d("FirebaseSessions", "App foregrounded on " + this.f90075g.a());
        if (p(sessionDataM) || o(sessionDataM)) {
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(this.f90076h), null, null, new SharedSessionRepositoryImpl$appForeground$1(this, sessionDataM, null), 3, null);
        }
    }

    public final SessionData m() {
        SessionData sessionData = this.f90077i;
        if (sessionData != null) {
            return sessionData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localSessionData");
        return null;
    }

    public final void r(SessionData sessionData) {
        Intrinsics.checkNotNullParameter(sessionData, "<set-?>");
        this.f90077i = sessionData;
    }
}
