package cz.mobilesoft.coreblock.util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class InterstitialUtils extends BaseInterstitialUtils<InterstitialAd, InterstitialAdProvider> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final InterstitialUtils f127880h = new InterstitialUtils();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f127881i = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InterstitialAdProvider extends BaseInterstitialUtils.BaseInterstitialAdProvider<InterstitialAd> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InterstitialAdProvider(AdUnitId adUnitId) {
            super(adUnitId);
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        }

        @Override // cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils.BaseInterstitialAdProvider
        public void g(final Context context, final Boolean bool, final PremiumState premiumState) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            if (premiumState.f(Product.ADS)) {
                return;
            }
            InterstitialAd.load(context, b().getId(), AdsUtils.r(bool), new InterstitialAdLoadCallback() { // from class: cz.mobilesoft.coreblock.util.InterstitialUtils$InterstitialAdProvider$loadInterstitialAd$1
                @Override // com.google.android.gms.ads.AdLoadCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onAdLoaded(InterstitialAd ad) {
                    Intrinsics.checkNotNullParameter(ad, "ad");
                    super.onAdLoaded(ad);
                    AnswersHelper.f128199a.v2();
                    this.i(System.currentTimeMillis());
                    this.j(ad);
                    InterstitialAd interstitialAd = (InterstitialAd) this.c();
                    if (interstitialAd != null) {
                        final InterstitialUtils.InterstitialAdProvider interstitialAdProvider = this;
                        final Context context2 = context;
                        interstitialAd.setImmersiveMode(true);
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: cz.mobilesoft.coreblock.util.InterstitialUtils$InterstitialAdProvider$loadInterstitialAd$1$onAdLoaded$1$1
                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void b() {
                                super.b();
                                Function1 function1A = interstitialAdProvider.a();
                                if (function1A != null) {
                                    function1A.invoke(Boolean.TRUE);
                                }
                            }

                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void c(AdError loadAdError) {
                                Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
                                super.c(loadAdError);
                                if (NetworkHelperKt.b(context2)) {
                                    CrashHelper.j(new IllegalStateException(loadAdError.toString()));
                                }
                                AnswersHelper.f128199a.u2();
                                String simpleName = InterstitialUtils$InterstitialAdProvider$loadInterstitialAd$1$onAdLoaded$1$1.class.getSimpleName();
                                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                                Log.d(simpleName, "Ad failed to show.");
                            }

                            @Override // com.google.android.gms.ads.FullScreenContentCallback
                            public void e() {
                                super.e();
                                AnswersHelper.f128199a.w2();
                                interstitialAdProvider.j(null);
                            }
                        });
                    }
                }

                @Override // com.google.android.gms.ads.AdLoadCallback
                public void onAdFailedToLoad(LoadAdError adError) {
                    Intrinsics.checkNotNullParameter(adError, "adError");
                    super.onAdFailedToLoad(adError);
                    if (NetworkHelperKt.b(context)) {
                        CrashHelper.j(new IllegalStateException(adError.toString()));
                    }
                    AnswersHelper.f128199a.t2();
                    this.j(null);
                    if (this.f()) {
                        return;
                    }
                    this.k(true);
                    this.g(context, bool, premiumState);
                }
            });
        }

        @Override // cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils.BaseInterstitialAdProvider
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public InterstitialAd d() {
            InterstitialAd interstitialAd = (InterstitialAd) c();
            if (interstitialAd == null || !e()) {
                return null;
            }
            return interstitialAd;
        }
    }

    private InterstitialUtils() {
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils
    public void f(Context context, Function1 onConsentChecked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onConsentChecked, "onConsentChecked");
        onConsentChecked.invoke(null);
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public InterstitialAdProvider g(AdUnitId adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new InterstitialAdProvider(adUnitId);
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void u(Activity activity, InterstitialAd interstitialAd) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
        interstitialAd.show(activity);
    }
}
