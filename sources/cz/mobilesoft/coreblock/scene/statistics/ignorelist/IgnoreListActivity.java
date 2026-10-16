package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityStatisticsDetailBinding;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
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
public final class IgnoreListActivity extends BaseActivitySurface<ActivityStatisticsDetailBinding> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f119956t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f119957u = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private IgnoreListsFragment f119958s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final IgnoreListsFragment z0() {
        return IgnoreListsFragment.f119996f.a();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public ActivityStatisticsDetailBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityStatisticsDetailBinding activityStatisticsDetailBindingC = ActivityStatisticsDetailBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityStatisticsDetailBindingC, "inflate(...)");
        return activityStatisticsDetailBindingC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.b(this, null, null, 3, null);
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
        String string = getString(R.string.hg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface, cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void l0(ActivityStatisticsDetailBinding activityStatisticsDetailBinding, Bundle bundle) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(activityStatisticsDetailBinding, MrGIhy.YjKkSSVEa);
        super.l0(activityStatisticsDetailBinding, bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(true);
            supportActionBar.x(R.drawable.G0);
        }
        if (bundle != null) {
            Fragment fragmentM0 = getSupportFragmentManager().m0(R.id.f95664t0);
            this.f119958s = fragmentM0 instanceof IgnoreListsFragment ? (IgnoreListsFragment) fragmentM0 : null;
            return;
        }
        this.f119958s = z0();
        FragmentTransaction fragmentTransactionQ = getSupportFragmentManager().q();
        int i3 = R.id.f95664t0;
        IgnoreListsFragment ignoreListsFragment = this.f119958s;
        Intrinsics.checkNotNull(ignoreListsFragment);
        fragmentTransactionQ.b(i3, ignoreListsFragment).j();
    }
}
