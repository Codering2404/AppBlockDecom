package cz.mobilesoft.coreblock.base.activity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.AdsBaseActivity;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.util.view.GradientUtils;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public abstract class BaseActivitySurface<Binding extends ViewBinding> extends AdsBaseActivity<Binding> implements BaseScrollViewFragment.OnScrollStateChangedListener {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f96280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f96281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Toolbar f96282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f96283q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.base.activity.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Float.valueOf(BaseActivitySurface.y0(this.f96322a));
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f96284r = true;

    private final void u0() throws IllegalAccessException {
        if (!this.f96281o) {
            throw new IllegalAccessException("Accessing toolbar before initViews was called! It is not yet set!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float y0(BaseActivitySurface baseActivitySurface) {
        return baseActivitySurface.getResources().getDimensionPixelSize(R.dimen.f95488v);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment.OnScrollStateChangedListener
    public void e(boolean z2) throws IllegalAccessException {
        if (this.f96284r != z2) {
            this.f96284r = z2;
            if (z2) {
                Toolbar toolbarW0 = w0();
                if (toolbarW0 != null) {
                    toolbarW0.setElevation(0.0f);
                    return;
                }
                return;
            }
            Toolbar toolbarW02 = w0();
            if (toolbarW02 != null) {
                toolbarW02.setElevation(x0());
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public ActionBar getSupportActionBar() throws IllegalAccessException {
        u0();
        return super.getSupportActionBar();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    public void l0(ViewBinding binding, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.l0(binding, bundle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.f95636l2);
        if (toolbar != null) {
            toolbar.setTitle(v0());
            toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.L3));
            this.f96282p = toolbar;
            setSupportActionBar(toolbar);
        }
        this.f96281o = true;
        if (ViewHelper.e(this)) {
            return;
        }
        GradientUtils.a(this);
    }

    protected String v0() {
        return this.f96280n;
    }

    protected final Toolbar w0() throws IllegalAccessException {
        u0();
        return this.f96282p;
    }

    protected final float x0() {
        return ((Number) this.f96283q.getValue()).floatValue();
    }
}
