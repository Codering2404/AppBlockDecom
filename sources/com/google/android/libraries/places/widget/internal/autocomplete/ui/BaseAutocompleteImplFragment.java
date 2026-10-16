package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzapa;
import com.google.android.libraries.places.internal.zzef;
import com.google.android.libraries.places.internal.zzmy;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.internal.zzns;
import com.google.android.libraries.places.internal.zznt;
import com.google.android.libraries.places.internal.zzod;
import com.google.android.libraries.places.internal.zzoh;
import com.google.android.libraries.places.internal.zzoi;
import com.google.android.libraries.places.internal.zzok;
import com.google.android.libraries.places.internal.zzom;
import com.google.android.libraries.places.internal.zzos;
import com.google.android.libraries.places.internal.zzot;
import com.google.android.libraries.places.internal.zzow;
import com.google.android.libraries.places.internal.zzox;
import com.google.android.libraries.places.internal.zzpj;
import com.google.android.libraries.places.internal.zzpu;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.listener.PredictionSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BaseAutocompleteImplFragment extends Fragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f78996w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlacesClient f78997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zznq f78998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzpu f78999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzef f79000d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f79001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzoi f79002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PlaceSelectionListener f79003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PredictionSelectionListener f79004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f79005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RecyclerView f79006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f79007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f79008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f79009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LinearLayout f79010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LinearLayout f79011p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f79012q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageButton f79013r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private zzn f79014s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final zzac f79015t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f79016u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f79017v;

    /* synthetic */ BaseAutocompleteImplFragment(int i3, PlacesClient placesClient, zznq zznqVar, zzpu zzpuVar, zzef zzefVar, int i4, byte[] bArr) {
        this(i3, placesClient, zznqVar, zzpuVar, zzefVar, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final void E() {
        this.f79016u = true;
        zzpj zzpjVar = new zzpj(requireContext(), this.f79017v, ImmutableList.y());
        zzpjVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzz
            @Override // android.content.DialogInterface.OnDismissListener
            public final /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
                this.f79082a.D(dialogInterface);
            }
        });
        zzpjVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void C(AutocompletePrediction autocompletePrediction, int i3) {
        try {
            this.f79002g.B0(autocompletePrediction, i3);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void B(View view) {
        try {
            this.f79002g.D0();
            this.f79005j.requestFocus();
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void z(zzns zznsVar) throws Throwable {
        try {
            this.f79008m.setVisibility(0);
            this.f79011p.setVisibility(8);
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            int iG = zznsVar.g() - 1;
            if (iG == 0) {
                zznq zznqVar = this.f78998b;
                if (TextUtils.isEmpty(zznqVar.h())) {
                    this.f79008m.setVisibility(8);
                    this.f79010o.setVisibility(8);
                }
                this.f79005j.requestFocus();
                this.f79005j.setText(zznqVar.h());
                EditText editText = this.f79005j;
                editText.setSelection(editText.getText().length());
                return;
            }
            if (iG == 1) {
                this.f79014s.i(null);
                this.f79008m.setVisibility(8);
                this.f79005j.getText().clear();
                this.f79010o.setVisibility(8);
                return;
            }
            switch (iG) {
                case 4:
                    this.f79014s.i(zznsVar.b());
                    this.f79010o.setVisibility(0);
                    return;
                case 5:
                    this.f79014s.i(null);
                    this.f79012q.setText(this.f79001f);
                    this.f79011p.setVisibility(0);
                    this.f79010o.setVisibility(0);
                    return;
                case 6:
                    break;
                case 7:
                    PlaceSelectionListener placeSelectionListener = this.f79003h;
                    if (placeSelectionListener != null) {
                        placeSelectionListener.c((Place) Preconditions.t(zznsVar.c()));
                    }
                    PredictionSelectionListener predictionSelectionListener = this.f79004i;
                    if (predictionSelectionListener != null) {
                        predictionSelectionListener.p((AutocompletePrediction) Preconditions.t(zznsVar.d()), (AutocompleteSessionToken) Preconditions.t(zznsVar.e()));
                        return;
                    }
                    return;
                case 8:
                    AutocompletePrediction autocompletePrediction = (AutocompletePrediction) Preconditions.u(zznsVar.d(), "Prediction should not be null.");
                    this.f79005j.clearFocus();
                    EditText editText2 = this.f79005j;
                    zzac zzacVar = this.f79015t;
                    editText2.removeTextChangedListener(zzacVar);
                    this.f79005j.setText(autocompletePrediction.e(null));
                    this.f79005j.addTextChangedListener(zzacVar);
                    break;
                case 9:
                    PlaceSelectionListener placeSelectionListener2 = this.f79003h;
                    if (placeSelectionListener2 != null) {
                        placeSelectionListener2.a((Status) Preconditions.t(zznsVar.f()));
                    }
                    PredictionSelectionListener predictionSelectionListener2 = this.f79004i;
                    if (predictionSelectionListener2 != null) {
                        predictionSelectionListener2.a((Status) Preconditions.t(zznsVar.f()));
                    }
                    Status statusF = zznsVar.f();
                    if (statusF != null && !statusF.equals(Status.f71541k)) {
                        this.f79012q.setText(zznt.d(requireContext(), R.string.f74822a));
                        this.f79011p.setVisibility(0);
                    }
                    this.f79010o.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.f79014s.i(null);
            PlaceSelectionListener placeSelectionListener3 = this.f79003h;
            if (placeSelectionListener3 != null) {
                placeSelectionListener3.a((Status) Preconditions.t(zznsVar.f()));
            }
            PredictionSelectionListener predictionSelectionListener3 = this.f79004i;
            if (predictionSelectionListener3 != null) {
                predictionSelectionListener3.a((Status) Preconditions.t(zznsVar.f()));
            }
            this.f79012q.setText(zznt.d(requireContext(), R.string.f74822a));
            this.f79011p.setVisibility(0);
            this.f79010o.setVisibility(8);
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    final /* synthetic */ void A(View view) {
        this.f79002g.H0();
    }

    final /* synthetic */ void D(DialogInterface dialogInterface) {
        this.f79016u = false;
    }

    final /* synthetic */ zzoi F() {
        return this.f79002g;
    }

    final /* synthetic */ EditText G() {
        return this.f79005j;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        try {
            zznq zznqVar = this.f78998b;
            zzom zzomVar = new zzom(zznqVar.c(), zznqVar.q(), zznqVar.f(), zznqVar.d(), zznqVar.h(), zznqVar.s(), this.f79000d);
            zzapa zzapaVarA = zzox.a(requireContext(), this.f79017v);
            zzomVar.o(new zzok(zzapaVarA.G(), zzapaVarA.H(), zzapaVarA.I(), zzapaVarA.J(), zzapaVarA.K()));
            zzoi zzoiVar = (zzoi) new ViewModelProvider(this, new zzoh(new zzod(this.f78997a, zznqVar, zzomVar.r(), zznqVar.c() == zzow.JWT_AND_ONE_PLATFORM ? zzmy.PLACES_UI_KIT : zzmy.ONE_PLATFORM_AUTOCOMPLETE_WIDGET), zzomVar, this.f78999c)).a(zzoi.class);
            this.f79002g = zzoiVar;
            zzoiVar.z0(bundle);
            requireActivity().getOnBackPressedDispatcher().i(this, new zzr(this, true));
        } catch (Error e3) {
            e = e3;
            Throwable th = e;
            zznb.b(th);
            throw th;
        } catch (RuntimeException e4) {
            e = e4;
            Throwable th2 = e;
            zznb.b(th2);
            throw th2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f79002g.G0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f79002g.F0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("arg-show-legal-disclosures", this.f79016u);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(final View view, Bundle bundle) throws Throwable {
        ActionBar supportActionBar;
        try {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Window window = fragmentActivityRequireActivity.getWindow();
            if ((fragmentActivityRequireActivity instanceof AppCompatActivity) && (supportActionBar = ((AppCompatActivity) fragmentActivityRequireActivity).getSupportActionBar()) != null) {
                supportActionBar.k();
            }
            int i3 = this.f79017v;
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(fragmentActivityRequireActivity, i3);
            TypedValue typedValue = new TypedValue();
            if (contextThemeWrapper.getTheme().resolveAttribute(R.attr.f74659v, typedValue, true)) {
                window.setBackgroundDrawable(new ColorDrawable(typedValue.data));
            }
            this.f79005j = (EditText) view.findViewById(R.id.f74778w);
            this.f79006k = (RecyclerView) view.findViewById(R.id.f74769t);
            this.f79007l = view.findViewById(R.id.f74735k);
            this.f79008m = view.findViewById(R.id.f74739l);
            this.f79009n = view.findViewById(R.id.f74759q);
            this.f79010o = (LinearLayout) view.findViewById(R.id.f74755p);
            this.f79011p = (LinearLayout) view.findViewById(R.id.f74763r);
            this.f79012q = (TextView) view.findViewById(R.id.f74766s);
            int i4 = R.id.f74747n;
            ImageButton imageButton = (ImageButton) view.findViewById(i4);
            this.f79013r = imageButton;
            imageButton.setOnClickListener(new zzs(this));
            this.f79001f = zznt.d(requireContext(), R.string.f74825b);
            this.f79005j.addTextChangedListener(this.f79015t);
            this.f79005j.setOnFocusChangeListener(new zzad(null));
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            zznq zznqVar = this.f78998b;
            int iOrdinal = zznqVar.d().ordinal();
            if (iOrdinal == 0) {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzu
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final /* synthetic */ WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        int i5 = BaseAutocompleteImplFragment.f78996w;
                        View view3 = view;
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        if (marginLayoutParams != null) {
                            marginLayoutParams.setMargins(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
                            view3.setLayoutParams(marginLayoutParams);
                        }
                        return windowInsets;
                    }
                });
            } else if (iOrdinal == 1) {
                requireActivity().getWindow().addFlags(67108864);
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzv
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final /* synthetic */ WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        int i5 = BaseAutocompleteImplFragment.f78996w;
                        View view3 = view;
                        view3.setPaddingRelative(view3.getPaddingStart(), windowInsets.getSystemWindowInsetTop(), view3.getPaddingEnd(), view3.getPaddingBottom());
                        return windowInsets;
                    }
                });
                this.f79009n.setVisibility(8);
            }
            this.f79007l.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzw
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view2) {
                    this.f79079a.A(view2);
                }
            });
            this.f79008m.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzx
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view2) {
                    this.f79080a.B(view2);
                }
            });
            this.f79014s = new zzn(new zzp() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzy
                @Override // com.google.android.libraries.places.widget.internal.autocomplete.ui.zzp
                public final /* synthetic */ void a(AutocompletePrediction autocompletePrediction, int i5) {
                    this.f79081a.C(autocompletePrediction, i5);
                }
            }, zznqVar, i3);
            this.f79006k.setLayoutManager(new LinearLayoutManager(requireContext()));
            this.f79006k.setItemAnimator(new zzaf(getResources()));
            this.f79006k.setAdapter(this.f79014s);
            this.f79006k.n(new zzt(this));
            AutocompleteUiCustomization autocompleteUiCustomizationQ = zznqVar.q();
            if (autocompleteUiCustomizationQ != null) {
                String strG = autocompleteUiCustomizationQ.g();
                if (strG == null) {
                    strG = zznt.d(requireContext(), R.string.f74828c);
                }
                this.f79005j.setHint(strG);
                String strF = autocompleteUiCustomizationQ.f();
                if (strF != null) {
                    this.f79001f = strF;
                }
            }
            Context context = getContext();
            if (context != null) {
                zzot zzotVar = zzot.f78364c;
                int iA = zzos.a(context, i3);
                ((ImageView) requireView().findViewById(R.id.f74751o)).setColorFilter(iA);
                ((ImageButton) requireView().findViewById(i4)).setColorFilter(iA);
            }
            this.f79002g.y0().j(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzaa
                @Override // androidx.lifecycle.Observer
                public final /* synthetic */ void a(Object obj) throws Throwable {
                    this.f79019a.z((zzns) obj);
                }
            });
            if (bundle != null) {
                boolean z2 = bundle.getBoolean("arg-show-legal-disclosures");
                this.f79016u = z2;
                if (z2) {
                    E();
                }
            }
            this.f79002g.J0();
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    public final void w() {
        this.f79002g.I0();
    }

    public final void x(PlaceSelectionListener placeSelectionListener) {
        this.f79003h = placeSelectionListener;
    }

    public final void y(PredictionSelectionListener predictionSelectionListener) {
        this.f79004i = predictionSelectionListener;
    }

    private BaseAutocompleteImplFragment(int i3, PlacesClient placesClient, zznq zznqVar, zzpu zzpuVar, zzef zzefVar, int i4) {
        super(i3);
        this.f79015t = new zzac(this, null);
        this.f79016u = false;
        this.f78997a = placesClient;
        this.f78998b = zznqVar;
        this.f78999c = zzpuVar;
        this.f79000d = zzefVar;
        this.f79017v = i4;
    }
}
