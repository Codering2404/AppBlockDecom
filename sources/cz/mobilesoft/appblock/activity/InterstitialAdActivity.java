package cz.mobilesoft.appblock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.ActivityInterstitialAdBinding;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.view.GradientUtils;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import java.text.MessageFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class InterstitialAdActivity extends AppCompatActivity implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f93937a;

    /* JADX WARN: Multi-variable type inference failed */
    public InterstitialAdActivity() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f93937a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.appblock.activity.InterstitialAdActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
    }

    private final PremiumRepositoryV2 V() {
        return (PremiumRepositoryV2) this.f93937a.getValue();
    }

    private final void W(View view) {
        int id = view.getId();
        if (id == R.id.closeButton) {
            finish();
        } else {
            if (id != R.id.premiumButton) {
                return;
            }
            Intent intentC = Paywall.c(Paywall.f113165a, this, PaywallTarget.Generic.INSTANCE, "interstitial_ad", "interstitial_ad", false, false, false, null, 240, null);
            intentC.setFlags(268468224);
            startActivity(intentC);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(final InterstitialAdActivity interstitialAdActivity, boolean z2) {
        if (z2) {
            ActivityInterstitialAdBinding activityInterstitialAdBindingC = ActivityInterstitialAdBinding.c(interstitialAdActivity.getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(activityInterstitialAdBindingC, "inflate(...)");
            interstitialAdActivity.setContentView(activityInterstitialAdBindingC.getRoot());
            activityInterstitialAdBindingC.f93989c.setText(MessageFormat.format("{0}. {1}", interstitialAdActivity.getString(R.string.interstitial_ads_title, interstitialAdActivity.getString(R.string.app_name)), interstitialAdActivity.getString(R.string.interstitial_ads_explanation)));
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cz.mobilesoft.appblock.activity.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InterstitialAdActivity.Y(this.f93962a, view);
                }
            };
            activityInterstitialAdBindingC.f93988b.setOnClickListener(onClickListener);
            activityInterstitialAdBindingC.f93991e.setOnClickListener(onClickListener);
        } else {
            interstitialAdActivity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(InterstitialAdActivity interstitialAdActivity, View view) {
        Intrinsics.checkNotNull(view);
        interstitialAdActivity.W(view);
    }

    @Override // android.app.Activity
    public void finish() {
        finishAndRemoveTask();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ViewHelper.e(this)) {
            GradientUtils.a(this);
        }
        InterstitialUtils.f127880h.t(this, AdUnitId.LOCK_SCREEN_INTERSTITIAL, V().J(), new Function1() { // from class: cz.mobilesoft.appblock.activity.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InterstitialAdActivity.X(this.f93961a, ((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
