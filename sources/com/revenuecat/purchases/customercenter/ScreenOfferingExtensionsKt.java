package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ScreenOfferingExtensionsKt {
    public static final void resolveOffering(CustomerCenterConfigData.Screen screen, Purchases purchases, Function1<? super PurchasesError, Unit> onError, final Function1<? super Offering, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        final CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        if (offering == null) {
            onSuccess.invoke(null);
        } else {
            ListenerConversionsCommonKt.getOfferingsWith(purchases, onError, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt.resolveOffering.2

                /* JADX INFO: renamed from: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt$resolveOffering$2$WhenMappings */
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Offerings) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Offerings offerings) {
                    Offering current;
                    Intrinsics.checkNotNullParameter(offerings, "offerings");
                    int i3 = WhenMappings.$EnumSwitchMapping$0[offering.getType().ordinal()];
                    if (i3 == 1) {
                        current = offerings.getCurrent();
                    } else {
                        if (i3 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String offeringId = offering.getOfferingId();
                        current = offeringId != null ? offerings.getAll().get(offeringId) : null;
                    }
                    onSuccess.invoke(current);
                }
            });
        }
    }

    public static /* synthetic */ void resolveOffering$default(CustomerCenterConfigData.Screen screen, Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.customercenter.ScreenOfferingExtensionsKt.resolveOffering.1
                public final void invoke(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((PurchasesError) obj2);
                    return Unit.f139807a;
                }
            };
        }
        resolveOffering(screen, purchases, function1, function12);
    }
}
