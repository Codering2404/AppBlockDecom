package cz.mobilesoft.coreblock.base.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseFragmentActivitySurface<Binding extends ViewBinding> extends BaseActivitySurface<Binding> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f96315s;

    protected abstract Fragment getFragment();

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface, cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    public void l0(ViewBinding binding, Bundle bundle) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.l0(binding, bundle);
        supportPostponeEnterTransition();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
        }
        if (z0()) {
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.x(R.drawable.C1);
            }
        } else {
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.x(R.drawable.G0);
            }
        }
        if (bundle == null) {
            int i3 = R.id.f95664t0;
            if (findViewById(i3) != null) {
                getSupportFragmentManager().q().b(i3, getFragment()).j();
            }
        }
        final View viewFindViewById = findViewById(android.R.id.content);
        viewFindViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface$initViews$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                viewFindViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                this.supportStartPostponedEnterTransition();
                return true;
            }
        });
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }

    protected boolean z0() {
        return this.f96315s;
    }
}
