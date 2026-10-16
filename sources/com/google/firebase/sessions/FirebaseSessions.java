package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class FirebaseSessions {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f89961c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseApp f89962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SessionsSettings f89963b;

    /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {51, 55}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f89964a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SessionsActivityLifecycleCallbacks f89966c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks, Continuation continuation) {
            super(2, continuation);
            this.f89966c = sessionsActivityLifecycleCallbacks;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FirebaseSessions.this.new AnonymousClass1(this.f89966c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
        
            if (r6.f(r5) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f89964a
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.b(r6)
                goto L69
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                kotlin.ResultKt.b(r6)
                goto L2e
            L20:
                kotlin.ResultKt.b(r6)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r6 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f90125a
                r5.f89964a = r4
                java.lang.Object r6 = r6.c(r5)
                if (r6 != r0) goto L2e
                goto L68
            L2e:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                boolean r1 = r6 instanceof java.util.Collection
                if (r1 == 0) goto L44
                r1 = r6
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L44
                goto L92
            L44:
                java.util.Iterator r6 = r6.iterator()
            L48:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L92
                java.lang.Object r1 = r6.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L48
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.FirebaseSessions.b(r6)
                r5.f89964a = r3
                java.lang.Object r6 = r6.f(r5)
                if (r6 != r0) goto L69
            L68:
                return r0
            L69:
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.FirebaseSessions.b(r6)
                boolean r6 = r6.c()
                if (r6 != 0) goto L7f
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                kotlin.coroutines.jvm.internal.Boxing.d(r6)
                goto L9b
            L7f:
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.FirebaseApp r6 = com.google.firebase.sessions.FirebaseSessions.a(r6)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks r0 = r5.f89966c
                com.google.firebase.sessions.b r1 = new com.google.firebase.sessions.b
                r1.<init>()
                r6.h(r1)
                kotlin.Unit r6 = kotlin.Unit.f139807a
                goto L9b
            L92:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                kotlin.coroutines.jvm.internal.Boxing.d(r6)
            L9b:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp, SessionsSettings settings, CoroutineContext backgroundDispatcher, SessionsActivityLifecycleCallbacks sessionsActivityLifecycleCallbacks) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(sessionsActivityLifecycleCallbacks, "sessionsActivityLifecycleCallbacks");
        this.f89962a = firebaseApp;
        this.f89963b = settings;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions 3.0.2.");
        Context applicationContext = firebaseApp.l().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(sessionsActivityLifecycleCallbacks);
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(backgroundDispatcher), null, null, new AnonymousClass1(sessionsActivityLifecycleCallbacks, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }
}
