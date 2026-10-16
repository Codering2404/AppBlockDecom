package cz.mobilesoft.coreblock.storage.room.dao.core;

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
public final class CustomBlockingScreenConfigDaoKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r5, cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt$selectDefaultConfig$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt$selectDefaultConfig$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt$selectDefaultConfig$1) r0
            int r1 = r0.f125847f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125847f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt$selectDefaultConfig$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt$selectDefaultConfig$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f125846d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125847f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.f125845c
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r5 = (cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity) r5
            java.lang.Object r6 = r0.f125844b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore) r6
            java.lang.Object r6 = r0.f125843a
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao) r6
            kotlin.ResultKt.b(r7)
            return r5
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            java.lang.Object r5 = r0.f125844b
            r6 = r5
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore) r6
            java.lang.Object r5 = r0.f125843a
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r5 = (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao) r5
            kotlin.ResultKt.b(r7)
            goto L63
        L4d:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType r7 = cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType.DEFAULT
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f125843a = r2
            r0.f125844b = r6
            r0.f125847f = r4
            java.lang.Object r7 = r5.L(r7, r0)
            if (r7 != r1) goto L63
            goto L8f
        L63:
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r7 = (cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity) r7
            if (r7 != 0) goto L75
            cz.mobilesoft.coreblock.util.CrashHelper r5 = cz.mobilesoft.coreblock.util.CrashHelper.f127788a
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Error: no CustomBlockingScreenConfig of type DEFAULT in DB, cannot select it."
            r6.<init>(r7)
            r5.h(r7, r6)
            r5 = 0
            return r5
        L75:
            java.lang.String r2 = r7.i()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f125843a = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f125844b = r5
            r0.f125845c = r7
            r0.f125847f = r3
            java.lang.Object r5 = r6.S0(r2, r0)
            if (r5 != r1) goto L90
        L8f:
            return r1
        L90:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt.a(cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao, cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
