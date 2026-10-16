package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import cz.mobilesoft.coreblock.util.ads.BaseBannerUtils;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockScreenBannerUtils extends BaseBannerUtils<AdView> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LockScreenBannerUtils f127896d = new LockScreenBannerUtils();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f127897f = 8;

    private LockScreenBannerUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AdView adView) {
        adView.a();
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseBannerUtils
    public void d(Context context, Function1 onConsentChecked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onConsentChecked, "onConsentChecked");
        onConsentChecked.invoke(null);
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseBannerUtils
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void e(final AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cz.mobilesoft.coreblock.util.t
            @Override // java.lang.Runnable
            public final void run() {
                LockScreenBannerUtils.p(adView);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseBannerUtils
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public AdView h(Context context, Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        AdView adView = new AdView(context);
        adView.setAdUnitId(AdUnitId.LOCK_SCREEN_BANNER.getId());
        adView.setAdSize(AdsUtils.B(context));
        adView.setAdListener(new AdListener() { // from class: cz.mobilesoft.coreblock.util.LockScreenBannerUtils$initBanner$1
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                LockScreenBannerUtils.f127896d.l(System.currentTimeMillis());
            }
        });
        adView.b(AdsUtils.r(bool));
        return adView;
    }
}
