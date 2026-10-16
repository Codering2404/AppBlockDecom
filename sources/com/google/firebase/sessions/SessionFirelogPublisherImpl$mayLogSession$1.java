package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$mayLogSession$1", f = "SessionFirelogPublisher.kt", l = {70, 71, 77}, m = "invokeSuspend")
final class SessionFirelogPublisherImpl$mayLogSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f90036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f90037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f90038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f90039d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f90040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f90041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f90042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ SessionFirelogPublisherImpl f90043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ SessionDetails f90044j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionFirelogPublisherImpl$mayLogSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, Continuation continuation) {
        super(2, continuation);
        this.f90043i = sessionFirelogPublisherImpl;
        this.f90044j = sessionDetails;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SessionFirelogPublisherImpl$mayLogSession$1(this.f90043i, this.f90044j, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f90042h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L45
            if (r1 == r4) goto L41
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r0 = r8.f90041g
            com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
            java.lang.Object r1 = r8.f90040f
            com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
            java.lang.Object r2 = r8.f90039d
            com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
            java.lang.Object r3 = r8.f90038c
            com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
            java.lang.Object r4 = r8.f90037b
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
            java.lang.Object r5 = r8.f90036a
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            kotlin.ResultKt.b(r9)
            r7 = r3
            r3 = r0
            r0 = r7
            r7 = r2
            r2 = r1
            r1 = r7
        L32:
            r7 = r4
            goto L9d
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3d:
            kotlin.ResultKt.b(r9)
            goto L6c
        L41:
            kotlin.ResultKt.b(r9)
            goto L53
        L45:
            kotlin.ResultKt.b(r9)
            com.google.firebase.sessions.SessionFirelogPublisherImpl r9 = r8.f90043i
            r8.f90042h = r4
            java.lang.Object r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.f(r9, r8)
            if (r9 != r0) goto L53
            goto L95
        L53:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lb0
            com.google.firebase.sessions.InstallationId$Companion r9 = com.google.firebase.sessions.InstallationId.f89981c
            com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = r8.f90043i
            com.google.firebase.installations.FirebaseInstallationsApi r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.d(r1)
            r8.f90042h = r3
            java.lang.Object r9 = r9.a(r1, r8)
            if (r9 != r0) goto L6c
            goto L95
        L6c:
            r5 = r9
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = r8.f90043i
            com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.f90026a
            com.google.firebase.FirebaseApp r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.c(r4)
            com.google.firebase.sessions.SessionDetails r1 = r8.f90044j
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r8.f90043i
            com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.e(r6)
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f90125a
            r8.f90036a = r5
            r8.f90037b = r4
            r8.f90038c = r3
            r8.f90039d = r9
            r8.f90040f = r1
            r8.f90041g = r6
            r8.f90042h = r2
            java.lang.Object r2 = r7.c(r8)
            if (r2 != r0) goto L96
        L95:
            return r0
        L96:
            r0 = r1
            r1 = r9
            r9 = r2
            r2 = r0
            r0 = r3
            r3 = r6
            goto L32
        L9d:
            r4 = r9
            java.util.Map r4 = (java.util.Map) r4
            r9 = r5
            java.lang.String r5 = r9.b()
            java.lang.String r6 = r9.a()
            com.google.firebase.sessions.SessionEvent r9 = r0.a(r1, r2, r3, r4, r5, r6)
            com.google.firebase.sessions.SessionFirelogPublisherImpl.b(r7, r9)
        Lb0:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl$mayLogSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SessionFirelogPublisherImpl$mayLogSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
