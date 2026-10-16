package cz.mobilesoft.coreblock.scene.schedule.detail;

import cz.mobilesoft.coreblock.enums.PremiumFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class ExtraOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f116572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PremiumFeature f116573b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AddNewlyInstalledApps extends ExtraOption {
        public AddNewlyInstalledApps(boolean z2) {
            super(z2, PremiumFeature.ADD_NEWLY_INSTALLED_APPS, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AdultContentBlocking extends ExtraOption {
        public AdultContentBlocking(boolean z2) {
            super(z2, PremiumFeature.ADULT_CONTENT_BLOCKING, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BlockUnsupportedBrowsers extends ExtraOption {
        public BlockUnsupportedBrowsers(boolean z2) {
            super(z2, PremiumFeature.BLOCK_UNSUPPORTED_BROWSERS, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InAppPurchasesBlocking extends ExtraOption {
        public InAppPurchasesBlocking(boolean z2) {
            super(z2, PremiumFeature.IN_APP_PURCHASES_BLOCKING, null);
        }
    }

    public /* synthetic */ ExtraOption(boolean z2, PremiumFeature premiumFeature, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, premiumFeature);
    }

    public final PremiumFeature a() {
        return this.f116573b;
    }

    public boolean b() {
        return this.f116572a;
    }

    private ExtraOption(boolean z2, PremiumFeature premiumFeature) {
        this.f116572a = z2;
        this.f116573b = premiumFeature;
    }
}
