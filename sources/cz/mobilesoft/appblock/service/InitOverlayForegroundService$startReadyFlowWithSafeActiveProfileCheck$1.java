package cz.mobilesoft.appblock.service;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1", f = "InitOverlayForegroundService.kt", l = {386, 387}, m = "invokeSuspend", v = 1)
final class InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InitOverlayForegroundService f94189b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1(InitOverlayForegroundService initOverlayForegroundService, Continuation continuation) {
        super(2, continuation);
        this.f94189b = initOverlayForegroundService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1(this.f94189b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r6 == r0) goto L15;
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
            int r1 = r5.f94188a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L37
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L2c
        L1e:
            kotlin.ResultKt.b(r6)
            r5.f94188a = r3
            r3 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
            if (r6 != r0) goto L2c
            goto L36
        L2c:
            cz.mobilesoft.appblock.service.InitOverlayForegroundService r6 = r5.f94189b
            r5.f94188a = r2
            java.lang.Object r6 = cz.mobilesoft.appblock.service.InitOverlayForegroundService.d(r6, r5)
            if (r6 != r0) goto L37
        L36:
            return r0
        L37:
            cz.mobilesoft.appblock.service.InitOverlayForegroundService$RequiredServices r6 = (cz.mobilesoft.appblock.service.InitOverlayForegroundService.RequiredServices) r6
            boolean r0 = r6.b()
            java.lang.String r1 = "InitOverlayService"
            if (r0 != 0) goto L50
            java.lang.String r6 = "initOverlayService nothing is being blocked -> stopping overlay"
            android.util.Log.d(r1, r6)
            cz.mobilesoft.appblock.service.InitOverlayForegroundService r6 = r5.f94189b
            java.lang.String r0 = "no_active_blocking_profile"
            cz.mobilesoft.appblock.service.InitOverlayForegroundService.i(r6, r0)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L50:
            boolean r0 = r6.c()
            boolean r2 = r6.a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "initOverlayService waiting for services: app="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " accessibility="
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            android.util.Log.d(r1, r0)
            cz.mobilesoft.appblock.service.InitOverlayForegroundService r0 = r5.f94189b
            cz.mobilesoft.appblock.service.InitOverlayForegroundService.h(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InitOverlayForegroundService$startReadyFlowWithSafeActiveProfileCheck$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
