package cz.mobilesoft.coreblock.util.monetization;

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
public final class MonetizationConfigKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt$monetizationConfig$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt$monetizationConfig$1 r0 = (cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt$monetizationConfig$1) r0
            int r1 = r0.f128879f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128879f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt$monetizationConfig$1 r0 = new cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt$monetizationConfig$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f128878d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128879f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f128877c
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = r0.f128876b
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig$Companion r1 = (cz.mobilesoft.coreblock.util.monetization.MonetizationConfig.Companion) r1
            java.lang.Object r0 = r0.f128875a
            cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore r0 = (cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore) r0
            kotlin.ResultKt.b(r7)
            goto L85
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            java.lang.Object r6 = r0.f128876b
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig$Companion r6 = (cz.mobilesoft.coreblock.util.monetization.MonetizationConfig.Companion) r6
            java.lang.Object r2 = r0.f128875a
            cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore r2 = (cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore) r2
            kotlin.ResultKt.b(r7)
            r5 = r2
            r2 = r6
            r6 = r5
            goto L68
        L4f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig$Companion r7 = cz.mobilesoft.coreblock.util.monetization.MonetizationConfig.f128870c
            kotlinx.coroutines.flow.Flow r2 = r6.z()
            r0.f128875a = r6
            r0.f128876b = r7
            r0.f128879f = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L65
            goto L80
        L65:
            r5 = r2
            r2 = r7
            r7 = r5
        L68:
            java.lang.String r7 = (java.lang.String) r7
            kotlinx.coroutines.flow.Flow r4 = r6.x()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f128875a = r6
            r0.f128876b = r2
            r0.f128877c = r7
            r0.f128879f = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r4, r0)
            if (r6 != r1) goto L81
        L80:
            return r1
        L81:
            r1 = r7
            r7 = r6
            r6 = r1
            r1 = r2
        L85:
            java.lang.String r7 = (java.lang.String) r7
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig r6 = r1.a(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt.a(cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
