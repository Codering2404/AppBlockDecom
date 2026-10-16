package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f90029f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final double f90030g = Math.random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseApp f90031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseInstallationsApi f90032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SessionsSettings f90033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EventGDTLoggerInterface f90034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoroutineContext f90035e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(sessionSettings, "sessionSettings");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.f90031a = firebaseApp;
        this.f90032b = firebaseInstallations;
        this.f90033c = sessionSettings;
        this.f90034d = eventGDTLogger;
        this.f90035e = backgroundDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(SessionEvent sessionEvent) {
        try {
            this.f90034d.a(sessionEvent);
            Log.d("FirebaseSessions", "Successfully logged Session Start event.");
        } catch (RuntimeException e3) {
            Log.e("FirebaseSessions", "Error logging Session Start event to DataTransport: ", e3);
        }
    }

    private final boolean h() {
        return f90030g <= this.f90033c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            if (r0 == 0) goto L13
            r0 = r9
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1) r0
            int r1 = r0.f90048d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f90048d = r1
            goto L18
        L13:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f90046b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f90048d
            r3 = 2
            r4 = 0
            java.lang.String r5 = "FirebaseSessions"
            r6 = 1
            if (r2 == 0) goto L43
            if (r2 == r6) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.f90045a
            com.google.firebase.sessions.SessionFirelogPublisherImpl r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r0
            kotlin.ResultKt.b(r9)
            goto L8e
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            java.lang.Object r2 = r0.f90045a
            com.google.firebase.sessions.SessionFirelogPublisherImpl r2 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r2
            kotlin.ResultKt.b(r9)
            goto L54
        L43:
            kotlin.ResultKt.b(r9)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r9 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f90125a
            r0.f90045a = r8
            r0.f90048d = r6
            java.lang.Object r9 = r9.c(r0)
            if (r9 != r1) goto L53
            goto L8c
        L53:
            r2 = r8
        L54:
            java.util.Map r9 = (java.util.Map) r9
            java.util.Collection r9 = r9.values()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r7 = r9 instanceof java.util.Collection
            if (r7 == 0) goto L6a
            r7 = r9
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L6a
            goto Lb5
        L6a:
            java.util.Iterator r9 = r9.iterator()
        L6e:
            boolean r7 = r9.hasNext()
            if (r7 == 0) goto Lb5
            java.lang.Object r7 = r9.next()
            com.google.firebase.sessions.api.SessionSubscriber r7 = (com.google.firebase.sessions.api.SessionSubscriber) r7
            boolean r7 = r7.a()
            if (r7 == 0) goto L6e
            com.google.firebase.sessions.settings.SessionsSettings r9 = r2.f90033c
            r0.f90045a = r2
            r0.f90048d = r3
            java.lang.Object r9 = r9.f(r0)
            if (r9 != r1) goto L8d
        L8c:
            return r1
        L8d:
            r0 = r2
        L8e:
            com.google.firebase.sessions.settings.SessionsSettings r9 = r0.f90033c
            boolean r9 = r9.c()
            if (r9 != 0) goto La0
            java.lang.String r9 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r9
        La0:
            boolean r9 = r0.h()
            if (r9 != 0) goto Lb0
            java.lang.String r9 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r9
        Lb0:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r9
        Lb5:
            java.lang.String r9 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void a(SessionDetails sessionDetails) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(this.f90035e), null, null, new SessionFirelogPublisherImpl$mayLogSession$1(this, sessionDetails, null), 3, null);
    }
}
