package cz.mobilesoft.appblock.service;

import android.content.Context;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

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
public final class LockServiceReasonsHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LockServiceReasonsHelper f94527a = new LockServiceReasonsHelper();

    private LockServiceReasonsHelper() {
    }

    public static final Set b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Set) BuildersKt__BuildersKt.b(null, new LockServiceReasonsHelper$reasonsBlocking$1(context, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(android.content.Context r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.appblock.service.LockServiceReasonsHelper$reasons$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.appblock.service.LockServiceReasonsHelper$reasons$1 r0 = (cz.mobilesoft.appblock.service.LockServiceReasonsHelper$reasons$1) r0
            int r1 = r0.f94531d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f94531d = r1
            goto L18
        L13:
            cz.mobilesoft.appblock.service.LockServiceReasonsHelper$reasons$1 r0 = new cz.mobilesoft.appblock.service.LockServiceReasonsHelper$reasons$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f94529b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f94531d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f94528a
            android.content.Context r6 = (android.content.Context) r6
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Exception -> L2d
            goto L54
        L2d:
            r6 = move-exception
            goto L57
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.b(r7)
            java.lang.Class<cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase> r7 = cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase.class
            r2 = 6
            r4 = 0
            java.lang.Object r7 = org.koin.java.KoinJavaComponent.c(r7, r4, r4, r2, r4)     // Catch: java.lang.Exception -> L2d
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase r7 = (cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase) r7     // Catch: java.lang.Exception -> L2d
            cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$Params r2 = new cz.mobilesoft.coreblock.usecase.lockservice.GetLockServiceRunReasonsUseCase$Params     // Catch: java.lang.Exception -> L2d
            r2.<init>(r6)     // Catch: java.lang.Exception -> L2d
            r0.f94528a = r6     // Catch: java.lang.Exception -> L2d
            r0.f94531d = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r7 = r7.h(r2, r0)     // Catch: java.lang.Exception -> L2d
            if (r7 != r1) goto L54
            return r1
        L54:
            java.util.Set r7 = (java.util.Set) r7     // Catch: java.lang.Exception -> L2d
            return r7
        L57:
            kotlin.coroutines.CoroutineContext r7 = r0.getContext()
            kotlinx.coroutines.JobKt.k(r7)
            cz.mobilesoft.coreblock.util.CrashHelper.j(r6)
            cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason r6 = cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason.BLOCKING
            java.util.Set r6 = kotlin.collections.SetsKt.setOf(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockServiceReasonsHelper.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
