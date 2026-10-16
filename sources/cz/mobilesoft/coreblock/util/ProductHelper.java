package cz.mobilesoft.coreblock.util;

import android.content.res.Resources;
import com.revenuecat.purchases.models.Period;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Product;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProductHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProductHelper f127904a = new ProductHelper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f127905a;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f127905a = iArr;
        }
    }

    private ProductHelper() {
    }

    public static final int a(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return product.getLimit();
    }

    public static /* synthetic */ String c(ProductHelper productHelper, Period period, Resources resources, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return productHelper.b(period, resources, z2);
    }

    public final String b(Period billingPeriod, Resources resources, boolean z2) {
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(resources, "resources");
        int i3 = WhenMappings.f127905a[billingPeriod.getUnit().ordinal()];
        String quantityString = resources.getQuantityString(i3 != 1 ? i3 != 2 ? z2 ? R.plurals.f95758s : R.plurals.f95759t : z2 ? R.plurals.f95758s : R.plurals.f95759t : z2 ? R.plurals.f95748i : R.plurals.f95749j, billingPeriod.getValue(), Integer.valueOf(billingPeriod.getValue()));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }
}
