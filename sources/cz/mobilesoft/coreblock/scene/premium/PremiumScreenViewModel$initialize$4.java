package cz.mobilesoft.coreblock.scene.premium;

import cz.mobilesoft.coreblock.storage.datastore.entity.IntroTrialToggleScreenType;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class PremiumScreenViewModel$initialize$4<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112410a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112411a;

        static {
            int[] iArr = new int[IntroTrialToggleScreenType.values().length];
            try {
                iArr[IntroTrialToggleScreenType.TrialNoToggle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IntroTrialToggleScreenType.TrialToggleDisabled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IntroTrialToggleScreenType.TrialToggleEnabled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f112411a = iArr;
        }
    }

    PremiumScreenViewModel$initialize$4(PremiumScreenViewModel premiumScreenViewModel) {
        this.f112410a = premiumScreenViewModel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0213, code lost:
    
        if (r1.u2(r13, r9, r5, r2) != r3) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0113 A[PHI: r1 r4 r10 r11 r12 r13
      0x0113: PHI (r1v19 java.lang.Object) = (r1v18 java.lang.Object), (r1v1 java.lang.Object) binds: [B:32:0x010f, B:17:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r4v6 boolean) = (r4v5 boolean), (r4v11 boolean) binds: [B:32:0x010f, B:17:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r10v5 boolean) = (r10v4 boolean), (r10v11 boolean) binds: [B:32:0x010f, B:17:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r11v5 java.lang.String) = (r11v4 java.lang.String), (r11v12 java.lang.String) binds: [B:32:0x010f, B:17:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r12v6 cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$RevenueCatProducts) = 
      (r12v5 cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$RevenueCatProducts)
      (r12v11 cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$RevenueCatProducts)
     binds: [B:32:0x010f, B:17:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0113: PHI (r13v3 com.revenuecat.purchases.CustomerInfo) = (r13v2 com.revenuecat.purchases.CustomerInfo), (r13v6 com.revenuecat.purchases.CustomerInfo) binds: [B:32:0x010f, B:17:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(kotlin.Pair r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$4.emit(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
