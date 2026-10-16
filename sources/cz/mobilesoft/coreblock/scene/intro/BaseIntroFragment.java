package cz.mobilesoft.coreblock.scene.intro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;

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
public abstract class BaseIntroFragment<Binding extends ViewBinding> extends BaseScrollViewFragment<Binding> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f104451d = R.id.O;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f104452f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f104453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f104454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Button f104455i;

    public BaseIntroFragment() {
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: cz.mobilesoft.coreblock.scene.intro.BaseIntroFragment$special$$inlined$sharedViewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final FragmentActivity invoke() {
                FragmentActivity fragmentActivityRequireActivity = this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                return fragmentActivityRequireActivity;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f104454h = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<OnboardingViewModelV2>() { // from class: cz.mobilesoft.coreblock.scene.intro.BaseIntroFragment$special$$inlined$sharedViewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                Fragment fragment = this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(OnboardingViewModelV2.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(BaseIntroFragment baseIntroFragment, View view) {
        baseIntroFragment.N();
    }

    public final Button H() {
        return this.f104455i;
    }

    public int I() {
        return this.f104451d;
    }

    public boolean L() {
        return this.f104453g;
    }

    public boolean M() {
        return this.f104452f;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    public void y(ViewBinding binding, View view, Bundle bundle) {
        ActionBar supportActionBar;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        Button button = (Button) view.findViewById(I());
        this.f104455i = button;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.intro.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseIntroFragment.J(this.f104598a, view2);
                }
            });
        }
        FragmentActivity activity = getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.t(M());
        }
        Button button2 = this.f104455i;
        if (button2 != null) {
            button2.setEnabled(L());
        }
    }

    public void N() {
    }
}
