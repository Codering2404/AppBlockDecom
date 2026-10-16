package cz.mobilesoft.coreblock.activity;

import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.gms.ads.AdView;
import cz.mobilesoft.coreblock.activity.AdsBaseActivity;
import cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class AdsBaseActivity<Binding extends ViewBinding> extends BaseAdsBaseActivity<AdView, Integer, Binding> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(AdsBaseActivity adsBaseActivity, Integer num) {
        if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 2)) {
            AdsUtils.f127678i.x(adsBaseActivity, adsBaseActivity);
        } else {
            adsBaseActivity.k0(null);
        }
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    public void Z() {
        AdsUtils.f127678i.s(this, new Function1() { // from class: o0.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AdsBaseActivity.q0(this.f143789a, (Integer) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    public void k0(Boolean bool) {
        String id;
        FrameLayout frameLayoutG0;
        AdUnitId adUnitIdB0 = b0();
        if (adUnitIdB0 == null || (id = adUnitIdB0.getId()) == null || (frameLayoutG0 = g0()) == null) {
            return;
        }
        frameLayoutG0.setVisibility(f0() ? 0 : 8);
        AdView adView = new AdView(this);
        adView.setAdUnitId(id);
        adView.setAdSize(AdsUtils.B(this));
        adView.b(AdsUtils.r(bool));
        frameLayoutG0.addView(adView);
        m0(adView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AdView adView = (AdView) c0();
        if (adView != null) {
            adView.a();
        }
        super.onDestroy();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseLockableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AdView adView = (AdView) c0();
        if (adView != null) {
            adView.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseLockableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AdView adView = (AdView) c0();
        if (adView != null) {
            adView.d();
        }
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseAdsUtils.ConsentFormCallback
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void l(Integer num, boolean z2) {
        if (!z2) {
            k0(null);
        } else {
            k0(Boolean.FALSE);
            startActivity(Paywall.c(Paywall.f113165a, this, PaywallTarget.Generic.INSTANCE, "ad_consent", "ad_consent", false, false, false, null, 240, null));
        }
    }
}
