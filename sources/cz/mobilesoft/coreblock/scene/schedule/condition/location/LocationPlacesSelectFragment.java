package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.material.snackbar.Snackbar;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.adapter.BindingListAdapter;
import cz.mobilesoft.coreblock.base.fragment.BaseSurfaceToolbarFragment;
import cz.mobilesoft.coreblock.databinding.FragmentLocationPlacesSelectBinding;
import cz.mobilesoft.coreblock.databinding.ItemListLocationPlaceBinding;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectFragment;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.KeyboardHelper;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocationPlacesSelectFragment extends BaseSurfaceToolbarFragment<FragmentLocationPlacesSelectBinding> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f115455g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f115456h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f115457f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocationPlacesSelectFragment a() {
            return new LocationPlacesSelectFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class PredictionsAdapter extends BindingListAdapter<AutocompletePrediction, ItemListLocationPlaceBinding> {
        public PredictionsAdapter() {
            super(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(LocationPlacesSelectFragment.PredictionsAdapter.q((AutocompletePrediction) obj, (AutocompletePrediction) obj2));
                }
            }, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(LocationPlacesSelectFragment.PredictionsAdapter.r((AutocompletePrediction) obj, (AutocompletePrediction) obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean q(AutocompletePrediction old, AutocompletePrediction autocompletePrediction) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(autocompletePrediction, "new");
            return Intrinsics.areEqual(old.d(), autocompletePrediction.d());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean r(AutocompletePrediction old, AutocompletePrediction autocompletePrediction) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(autocompletePrediction, "new");
            return Intrinsics.areEqual(old, autocompletePrediction);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(LocationPlacesSelectFragment locationPlacesSelectFragment, AutocompletePrediction autocompletePrediction, View view) {
            locationPlacesSelectFragment.H().P0(autocompletePrediction);
            KeyboardHelper.a(view);
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public void j(ItemListLocationPlaceBinding binding, final AutocompletePrediction item, int i3) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(item, "item");
            binding.f96734c.setText(item.e(null));
            binding.f96733b.setText(item.f(null));
            LinearLayout root = binding.getRoot();
            final LocationPlacesSelectFragment locationPlacesSelectFragment = LocationPlacesSelectFragment.this;
            root.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.o1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocationPlacesSelectFragment.PredictionsAdapter.t(locationPlacesSelectFragment, item, view);
                }
            });
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public ItemListLocationPlaceBinding k(LayoutInflater inflater, ViewGroup parent, boolean z2) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(parent, "parent");
            ItemListLocationPlaceBinding itemListLocationPlaceBindingC = ItemListLocationPlaceBinding.c(inflater, parent, z2);
            Intrinsics.checkNotNullExpressionValue(itemListLocationPlaceBindingC, "inflate(...)");
            return itemListLocationPlaceBindingC;
        }
    }

    public LocationPlacesSelectFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Fragment invoke() {
                return this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f115457f = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<LocationPlacesSelectViewModel>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(LocationPlacesSelectViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(FragmentLocationPlacesSelectBinding fragmentLocationPlacesSelectBinding, List list) {
        RecyclerView.Adapter adapter = fragmentLocationPlacesSelectBinding.f96666d.getAdapter();
        PredictionsAdapter predictionsAdapter = adapter instanceof PredictionsAdapter ? (PredictionsAdapter) adapter : null;
        if (predictionsAdapter != null) {
            predictionsAdapter.i(list);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(FragmentLocationPlacesSelectBinding fragmentLocationPlacesSelectBinding, ViewModelState viewModelState) {
        if (viewModelState instanceof Loading) {
            fragmentLocationPlacesSelectBinding.f96664b.setVisibility(0);
        } else {
            fragmentLocationPlacesSelectBinding.f96664b.setVisibility(4);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(FragmentLocationPlacesSelectBinding fragmentLocationPlacesSelectBinding, ViewModelState viewModelState) {
        RecyclerView recyclerView = fragmentLocationPlacesSelectBinding.f96666d;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        boolean z2 = viewModelState instanceof Loading;
        recyclerView.setVisibility(!z2 ? 0 : 8);
        ProgressBar progressBar = fragmentLocationPlacesSelectBinding.f96665c;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(z2 ? 0 : 8);
        if (viewModelState instanceof FailedWithError) {
            Snackbar.k0(fragmentLocationPlacesSelectBinding.getRoot(), ((FailedWithError) viewModelState).d(), -1).Y();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(LocationPlacesSelectFragment locationPlacesSelectFragment, LatLng latLng) {
        if (latLng != null) {
            Intent intent = new Intent();
            intent.putExtra("PLACE_LAT_LNG", latLng);
            locationPlacesSelectFragment.requireActivity().setResult(-1, intent);
            locationPlacesSelectFragment.requireActivity().finish();
        }
        return Unit.f139807a;
    }

    private final void O() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivityRequireActivity;
        appCompatActivity.setSupportActionBar(((FragmentLocationPlacesSelectBinding) w()).f96668f);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.x(R.drawable.G0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat Q(View view, View v2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insetsF = insets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        view.setPadding(0, insetsF.f33965b, 0, insetsF.f33967d);
        return insets;
    }

    public final LocationPlacesSelectViewModel H() {
        return (LocationPlacesSelectViewModel) this.f115457f.getValue();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void x(final FragmentLocationPlacesSelectBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, H().N0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPlacesSelectFragment.J(binding, (List) obj);
            }
        });
        LiveDataExtKt.c(this, H().O0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPlacesSelectFragment.L(binding, (ViewModelState) obj);
            }
        });
        LiveDataExtKt.c(this, H().L0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPlacesSelectFragment.M(binding, (ViewModelState) obj);
            }
        });
        LiveDataExtKt.c(this, H().M0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.m1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPlacesSelectFragment.N(this.f115574a, (LatLng) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void y(FragmentLocationPlacesSelectBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        EditText searchEditText = binding.f96667e;
        Intrinsics.checkNotNullExpressionValue(searchEditText, "searchEditText");
        searchEditText.addTextChangedListener(new TextWatcher() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectFragment$initViews$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                this.f115459a.H().T0(String.valueOf(charSequence));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }
        });
        binding.f96667e.requestFocus();
        binding.f96666d.setAdapter(new PredictionsAdapter());
        O();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public FragmentLocationPlacesSelectBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentLocationPlacesSelectBinding fragmentLocationPlacesSelectBindingC = FragmentLocationPlacesSelectBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentLocationPlacesSelectBindingC, "inflate(...)");
        return fragmentLocationPlacesSelectBindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseSurfaceToolbarFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewCompat.C0(view, new OnApplyWindowInsetsListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.n1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                return LocationPlacesSelectFragment.Q(view, view2, windowInsetsCompat);
            }
        });
    }
}
