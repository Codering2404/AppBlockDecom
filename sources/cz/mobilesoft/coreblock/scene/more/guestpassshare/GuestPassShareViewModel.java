package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import android.app.Application;
import android.content.Context;
import com.revenuecat.purchases.Offering;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
public final class GuestPassShareViewModel extends PremiumScreenViewModel {
    private final boolean Q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f107459a;

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
            f107459a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuestPassShareViewModel(Application application, boolean z2) {
        super(application, new PremiumScreenViewState.PremiumScreenTypeViewState() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareViewModel.1

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final boolean f107458j = true;

            @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
            public boolean c() {
                return this.f107458j;
            }
        });
        Intrinsics.checkNotNullParameter(application, "application");
        this.Q = z2;
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence C2(PremiumOptionDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.AnalyticsData Q1() {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareViewModel.Q1():cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$AnalyticsData");
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String a2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String c2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object h2(Continuation continuation) {
        return this.Q ? RevenueCatPlacement.ReceivedGuestPass : RevenueCatPlacement.SharedGuestPass;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object z2(Offering offering, Continuation continuation) {
        return Boxing.a(false);
    }
}
