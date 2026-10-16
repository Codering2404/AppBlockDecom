package cz.mobilesoft.coreblock.scene.streaks;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakWriteKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlin.jvm.functions.Function1 r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakWriteKt$streakWrite$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.streaks.StreakWriteKt$streakWrite$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakWriteKt$streakWrite$1) r0
            int r1 = r0.f120595c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120595c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakWriteKt$streakWrite$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakWriteKt$streakWrite$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f120594b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120595c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f120593a
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L47 java.util.concurrent.CancellationException -> L4e
            goto L4b
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.b(r5)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)     // Catch: java.lang.Throwable -> L47 java.util.concurrent.CancellationException -> L4e
            r0.f120593a = r5     // Catch: java.lang.Throwable -> L47 java.util.concurrent.CancellationException -> L4e
            r0.f120595c = r3     // Catch: java.lang.Throwable -> L47 java.util.concurrent.CancellationException -> L4e
            java.lang.Object r4 = r4.invoke(r0)     // Catch: java.lang.Throwable -> L47 java.util.concurrent.CancellationException -> L4e
            if (r4 != r1) goto L4b
            return r1
        L47:
            r4 = move-exception
            cz.mobilesoft.coreblock.util.CrashHelper.j(r4)
        L4b:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        L4e:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakWriteKt.a(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
