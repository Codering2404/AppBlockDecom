package cz.mobilesoft.appblock.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.InitOverlayForegroundService$watchFreshReadyEvent$2", f = "InitOverlayForegroundService.kt", l = {}, m = "invokeSuspend", v = 1)
final class InitOverlayForegroundService$watchFreshReadyEvent$2 extends SuspendLambda implements Function2<Long, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ long f94206b;

    InitOverlayForegroundService$watchFreshReadyEvent$2(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InitOverlayForegroundService$watchFreshReadyEvent$2 initOverlayForegroundService$watchFreshReadyEvent$2 = new InitOverlayForegroundService$watchFreshReadyEvent$2(continuation);
        initOverlayForegroundService$watchFreshReadyEvent$2.f94206b = ((Number) obj).longValue();
        return initOverlayForegroundService$watchFreshReadyEvent$2;
    }

    public final Object h(long j3, Continuation continuation) {
        return ((InitOverlayForegroundService$watchFreshReadyEvent$2) create(Long.valueOf(j3), continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return h(((Number) obj).longValue(), (Continuation) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            long r0 = r6.f94206b
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f94205a
            if (r2 != 0) goto L2c
            kotlin.ResultKt.b(r7)
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L26
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r7 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r7.f()
            long r4 = r4 - r0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L26
            r0 = 60000(0xea60, double:2.9644E-319)
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 >= 0) goto L26
            r7 = 1
            goto L27
        L26:
            r7 = 0
        L27:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r7
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.InitOverlayForegroundService$watchFreshReadyEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
