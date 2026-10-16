package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityStatisticsDefaultAppsBinding;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class DefaultIgnoredApplicationSelectActivity extends BaseActivitySurface<ActivityStatisticsDefaultAppsBinding> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f119934u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f119935v = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DefaultIgnoredApplicationSelectFragment f119936s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ArrayList f119937t = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Activity activity, ArrayList selectedApplications) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(selectedApplications, "selectedApplications");
            Intent intent = new Intent(activity, (Class<?>) DefaultIgnoredApplicationSelectActivity.class);
            intent.putExtra("APPLICATIONS", selectedApplications);
            return intent;
        }

        private Companion() {
        }
    }

    private final DefaultIgnoredApplicationSelectFragment A0(ArrayList arrayList) {
        return DefaultIgnoredApplicationSelectFragment.f119938d.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(DefaultIgnoredApplicationSelectActivity defaultIgnoredApplicationSelectActivity, View view) {
        Intent intent = new Intent();
        Fragment fragmentM0 = defaultIgnoredApplicationSelectActivity.getSupportFragmentManager().m0(R.id.f95664t0);
        Intrinsics.checkNotNull(fragmentM0, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultIgnoredApplicationSelectFragment");
        intent.putExtra("APPLICATIONS", ((DefaultIgnoredApplicationSelectFragment) fragmentM0).B());
        defaultIgnoredApplicationSelectActivity.setResult(-1, intent);
        defaultIgnoredApplicationSelectActivity.finish();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface, cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void l0(ActivityStatisticsDefaultAppsBinding binding, Bundle bundle) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.l0(binding, bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(true);
            supportActionBar.x(R.drawable.C1);
        }
        if (bundle == null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("APPLICATIONS");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            ArrayList arrayList = (ArrayList) serializableExtra;
            this.f119937t = arrayList;
            this.f119936s = A0(arrayList);
            FragmentTransaction fragmentTransactionQ = getSupportFragmentManager().q();
            int i3 = R.id.f95664t0;
            DefaultIgnoredApplicationSelectFragment defaultIgnoredApplicationSelectFragment = this.f119936s;
            Intrinsics.checkNotNull(defaultIgnoredApplicationSelectFragment);
            fragmentTransactionQ.b(i3, defaultIgnoredApplicationSelectFragment).j();
        } else {
            Fragment fragmentM0 = getSupportFragmentManager().m0(R.id.f95664t0);
            this.f119936s = fragmentM0 instanceof DefaultIgnoredApplicationSelectFragment ? (DefaultIgnoredApplicationSelectFragment) fragmentM0 : null;
        }
        binding.f96465b.f96853b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultIgnoredApplicationSelectActivity.C0(this.f120007a, view);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public ActivityStatisticsDefaultAppsBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityStatisticsDefaultAppsBinding activityStatisticsDefaultAppsBindingC = ActivityStatisticsDefaultAppsBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityStatisticsDefaultAppsBindingC, "inflate(...)");
        return activityStatisticsDefaultAppsBindingC;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface
    protected String v0() {
        String string = getString(R.string.n9);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
