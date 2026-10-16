package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewModelKt;
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
public final class WifiConditionViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final WifiConditionViewState b(Context context, ConditionDTO.WifisDTO wifisDTO, boolean z2, PremiumRepositoryV2 premiumRepositoryV2) {
        return new WifiConditionViewState(false, z2, TimeConditionViewModelKt.b(context, wifisDTO != null ? wifisDTO.e() : null, premiumRepositoryV2.J().g(), (wifisDTO != null ? wifisDTO.e() : null) == null, premiumRepositoryV2.J().f(Product.TIMES)), c(wifisDTO), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState c(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.WifisDTO r18) {
        /*
            r0 = 0
            r1 = 10
            if (r18 == 0) goto L34
            java.util.ArrayList r2 = r18.f()
            if (r2 == 0) goto L34
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r1)
            r3.<init>(r4)
            int r4 = r2.size()
            r5 = r0
        L19:
            if (r5 >= r4) goto L2b
            java.lang.Object r6 = r2.get(r5)
            int r5 = r5 + 1
            cz.mobilesoft.coreblock.scene.schedule.condition.WifiDTO r6 = (cz.mobilesoft.coreblock.scene.schedule.condition.WifiDTO) r6
            java.lang.String r6 = r6.a()
            r3.add(r6)
            goto L19
        L2b:
            kotlinx.collections.immutable.ImmutableSet r2 = kotlinx.collections.immutable.ExtensionsKt.j(r3)
            if (r2 != 0) goto L32
            goto L34
        L32:
            r8 = r2
            goto L39
        L34:
            kotlinx.collections.immutable.PersistentSet r2 = kotlinx.collections.immutable.ExtensionsKt.c()
            goto L32
        L39:
            if (r18 == 0) goto L7d
            java.util.ArrayList r2 = r18.f()
            if (r2 == 0) goto L7d
            java.util.ArrayList r3 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r1)
            r3.<init>(r1)
            int r1 = r2.size()
        L4e:
            if (r0 >= r1) goto L75
            java.lang.Object r4 = r2.get(r0)
            int r0 = r0 + 1
            cz.mobilesoft.coreblock.scene.schedule.condition.WifiDTO r4 = (cz.mobilesoft.coreblock.scene.schedule.condition.WifiDTO) r4
            cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi r9 = new cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi
            java.lang.String r10 = r4.a()
            java.lang.String r4 = r4.a()
            java.lang.String r11 = cz.mobilesoft.coreblock.util.helperextension.StringHelper.w(r4)
            r16 = 28
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            r3.add(r9)
            goto L4e
        L75:
            kotlinx.collections.immutable.PersistentList r0 = kotlinx.collections.immutable.ExtensionsKt.k(r3)
            if (r0 == 0) goto L7d
        L7b:
            r10 = r0
            goto L82
        L7d:
            kotlinx.collections.immutable.PersistentList r0 = kotlinx.collections.immutable.ExtensionsKt.a()
            goto L7b
        L82:
            cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState r3 = new cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 943(0x3af, float:1.321E-42)
            r15 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewModelKt.c(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$WifisDTO):cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState");
    }
}
