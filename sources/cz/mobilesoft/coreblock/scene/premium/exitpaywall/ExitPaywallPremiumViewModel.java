package cz.mobilesoft.coreblock.scene.premium.exitpaywall;

import android.app.Application;
import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public final class ExitPaywallPremiumViewModel extends PremiumScreenViewModel {
    private final String Q;
    private final String R;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113077a;

        static {
            int[] iArr = new int[PremiumOptionPeriod.values().length];
            try {
                iArr[PremiumOptionPeriod.Monthly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumOptionPeriod.Yearly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f113077a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExitPaywallPremiumViewModel(Application application, String entrancesDetail, String entrances) {
        super(application, new PremiumScreenViewState.PremiumScreenTypeViewState() { // from class: cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallPremiumViewModel.1
        });
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(entrancesDetail, "entrancesDetail");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        this.Q = entrancesDetail;
        this.R = entrances;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence C2(PremiumOptionDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.f();
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String a2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.K4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String c2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.L4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object h2(Continuation continuation) {
        return RevenueCatPlacement.ExitDiscount;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.AnalyticsData Q1() {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.exitpaywall.ExitPaywallPremiumViewModel.Q1():cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$AnalyticsData");
    }
}
