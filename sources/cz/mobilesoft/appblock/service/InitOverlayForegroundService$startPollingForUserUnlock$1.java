package cz.mobilesoft.appblock.service;

import android.os.UserManager;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$startPollingForUserUnlock$1", f = "InitOverlayForegroundService.kt", l = {243, 247}, m = "invokeSuspend", v = 1)
final class InitOverlayForegroundService$startPollingForUserUnlock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UserManager f94184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ InitOverlayForegroundService f94185c;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.InitOverlayForegroundService$startPollingForUserUnlock$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$startPollingForUserUnlock$1$1", f = "InitOverlayForegroundService.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ InitOverlayForegroundService f94187b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InitOverlayForegroundService initOverlayForegroundService, Continuation continuation) {
            super(2, continuation);
            this.f94187b = initOverlayForegroundService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f94187b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f94186a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f94187b.w();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitOverlayForegroundService$startPollingForUserUnlock$1(UserManager userManager, InitOverlayForegroundService initOverlayForegroundService, Continuation continuation) {
        super(2, continuation);
        this.f94184b = userManager;
        this.f94185c = initOverlayForegroundService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InitOverlayForegroundService$startPollingForUserUnlock$1(this.f94184b, this.f94185c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r8, r1, r7) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f94183a
            java.lang.String r2 = "InitOverlayService"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            kotlin.ResultKt.b(r8)
            goto L5b
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1c:
            kotlin.ResultKt.b(r8)
            goto L28
        L20:
            kotlin.ResultKt.b(r8)
            java.lang.String r8 = "Starting to poll for user unlock"
            android.util.Log.d(r2, r8)
        L28:
            android.os.UserManager r8 = r7.f94184b
            boolean r8 = r8.isUserUnlocked()
            if (r8 != 0) goto L3b
            r7.f94183a = r4
            r5 = 200(0xc8, double:9.9E-322)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r0) goto L28
            goto L5a
        L3b:
            java.lang.String r8 = "User unlock detected via polling"
            android.util.Log.d(r2, r8)
            cz.mobilesoft.appblock.service.InitOverlayForegroundService r8 = r7.f94185c
            r1 = 0
            cz.mobilesoft.appblock.service.InitOverlayForegroundService.f(r8, r1)
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$startPollingForUserUnlock$1$1 r1 = new cz.mobilesoft.appblock.service.InitOverlayForegroundService$startPollingForUserUnlock$1$1
            cz.mobilesoft.appblock.service.InitOverlayForegroundService r2 = r7.f94185c
            r4 = 0
            r1.<init>(r2, r4)
            r7.f94183a = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r8, r1, r7)
            if (r8 != r0) goto L5b
        L5a:
            return r0
        L5b:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InitOverlayForegroundService$startPollingForUserUnlock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InitOverlayForegroundService$startPollingForUserUnlock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
