package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class ScreenOfferingExtensionsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.values().length];
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt", f = "ScreenOfferingExtensions.kt", l = {14}, m = "resolveOfferingSuspend")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScreenOfferingExtensionsKt.resolveOfferingSuspend(null, null, this);
        }
    }

    public static final String resolveButtonText(CustomerCenterConfigData.Screen screen, CustomerCenterConfigData.Localization localization) {
        String buttonText;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Intrinsics.checkNotNullParameter(localization, "localization");
        CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        return (offering == null || (buttonText = offering.getButtonText()) == null) ? localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BUY_SUBSCRIPTION) : buttonText;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object resolveOfferingSuspend(com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen r5, com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType r6, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.Offering> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r5 = r0.L$0
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData$ScreenOffering r5 = (com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering) r5
            kotlin.ResultKt.b(r7)
            goto L4b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.b(r7)
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData$ScreenOffering r5 = r5.getOffering()
            if (r5 != 0) goto L40
            return r3
        L40:
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r6.awaitOfferings(r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            com.revenuecat.purchases.Offerings r7 = (com.revenuecat.purchases.Offerings) r7
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData$ScreenOffering$ScreenOfferingType r6 = r5.getType()
            int[] r0 = com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r0[r6]
            if (r6 == r4) goto L76
            r0 = 2
            if (r6 != r0) goto L70
            java.lang.String r5 = r5.getOfferingId()
            if (r5 == 0) goto L6f
            java.util.Map r6 = r7.getAll()
            java.lang.Object r5 = r6.get(r5)
            com.revenuecat.purchases.Offering r5 = (com.revenuecat.purchases.Offering) r5
            return r5
        L6f:
            return r3
        L70:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L76:
            com.revenuecat.purchases.Offering r5 = r7.getCurrent()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt.resolveOfferingSuspend(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Screen, com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
