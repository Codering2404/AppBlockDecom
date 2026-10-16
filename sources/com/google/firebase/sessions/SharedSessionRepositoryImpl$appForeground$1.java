package com.google.firebase.sessions;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1", f = "SharedSessionRepository.kt", l = {135, 186}, m = "invokeSuspend")
final class SharedSessionRepositoryImpl$appForeground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f90098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedSessionRepositoryImpl f90099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionData f90100c;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1", f = "SharedSessionRepository.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<SessionData, Continuation<? super SessionData>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f90101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f90102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SharedSessionRepositoryImpl f90103c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, Continuation continuation) {
            super(2, continuation);
            this.f90103c = sharedSessionRepositoryImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f90103c, continuation);
            anonymousClass1.f90102b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SessionData sessionData, Continuation continuation) {
            return ((AnonymousClass1) create(sessionData, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f90101a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SessionData sessionData = (SessionData) this.f90102b;
            boolean zP = this.f90103c.p(sessionData);
            boolean zN = this.f90103c.n(sessionData);
            boolean zO = this.f90103c.o(sessionData);
            Map mapF = zN ? this.f90103c.f90075g.f() : zO ? this.f90103c.f90075g.c(sessionData.e()) : sessionData.e();
            SessionDetails sessionDetailsF = zN ? null : sessionData.f();
            if (!zP && !zN) {
                return zO ? SessionData.c(sessionData, null, null, this.f90103c.f90075g.c(mapF), 3, null) : sessionData;
            }
            SessionDetails sessionDetailsA = this.f90103c.f90071c.a(sessionDetailsF);
            this.f90103c.f90072d.a(sessionDetailsA);
            this.f90103c.f90075g.d();
            return sessionData.b(sessionDetailsA, null, mapF);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SharedSessionRepositoryImpl$appForeground$1(SharedSessionRepositoryImpl sharedSessionRepositoryImpl, SessionData sessionData, Continuation continuation) {
        super(2, continuation);
        this.f90099b = sharedSessionRepositoryImpl;
        this.f90100c = sessionData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SharedSessionRepositoryImpl$appForeground$1(this.f90099b, this.f90100c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r10.a(r0, r9) == r1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0097, code lost:
    
        if (r10.q(r0, r3, r9) == r1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r9.f90098a
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L23
            if (r0 == r3) goto L1b
            if (r0 != r2) goto L13
            kotlin.ResultKt.b(r10)
            goto L9a
        L13:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1b:
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Exception -> L20
            goto L9a
        L20:
            r0 = move-exception
            r10 = r0
            goto L3d
        L23:
            kotlin.ResultKt.b(r10)
            com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = r9.f90099b     // Catch: java.lang.Exception -> L20
            androidx.datastore.core.DataStore r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.e(r10)     // Catch: java.lang.Exception -> L20
            com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1 r0 = new com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1$1     // Catch: java.lang.Exception -> L20
            com.google.firebase.sessions.SharedSessionRepositoryImpl r4 = r9.f90099b     // Catch: java.lang.Exception -> L20
            r5 = 0
            r0.<init>(r4, r5)     // Catch: java.lang.Exception -> L20
            r9.f90098a = r3     // Catch: java.lang.Exception -> L20
            java.lang.Object r10 = r10.a(r0, r9)     // Catch: java.lang.Exception -> L20
            if (r10 != r1) goto L9a
            goto L99
        L3d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "App foregrounded, failed to update data. Message: "
            r0.append(r3)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            java.lang.String r0 = "FirebaseSessions"
            android.util.Log.d(r0, r10)
            com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = r9.f90099b
            com.google.firebase.sessions.SessionData r0 = r9.f90100c
            boolean r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.k(r10, r0)
            if (r10 == 0) goto L9a
            com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = r9.f90099b
            com.google.firebase.sessions.SessionGenerator r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.g(r10)
            com.google.firebase.sessions.SessionData r0 = r9.f90100c
            com.google.firebase.sessions.SessionDetails r0 = r0.f()
            com.google.firebase.sessions.SessionDetails r4 = r10.a(r0)
            com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = r9.f90099b
            com.google.firebase.sessions.SessionData r3 = r9.f90100c
            r7 = 4
            r8 = 0
            r5 = 0
            r6 = 0
            com.google.firebase.sessions.SessionData r0 = com.google.firebase.sessions.SessionData.c(r3, r4, r5, r6, r7, r8)
            r10.r(r0)
            com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = r9.f90099b
            com.google.firebase.sessions.SessionFirelogPublisher r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.f(r10)
            r10.a(r4)
            com.google.firebase.sessions.SharedSessionRepositoryImpl r10 = r9.f90099b
            java.lang.String r0 = r4.b()
            com.google.firebase.sessions.SharedSessionRepositoryImpl$NotificationType r3 = com.google.firebase.sessions.SharedSessionRepositoryImpl.NotificationType.f90089b
            r9.f90098a = r2
            java.lang.Object r10 = com.google.firebase.sessions.SharedSessionRepositoryImpl.l(r10, r0, r3, r9)
            if (r10 != r1) goto L9a
        L99:
            return r1
        L9a:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SharedSessionRepositoryImpl$appForeground$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SharedSessionRepositoryImpl$appForeground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
