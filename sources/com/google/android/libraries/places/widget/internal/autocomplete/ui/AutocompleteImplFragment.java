package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzef;
import com.google.android.libraries.places.internal.zzmy;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.internal.zzns;
import com.google.android.libraries.places.internal.zznt;
import com.google.android.libraries.places.internal.zznu;
import com.google.android.libraries.places.internal.zzod;
import com.google.android.libraries.places.internal.zzoh;
import com.google.android.libraries.places.internal.zzoi;
import com.google.android.libraries.places.internal.zzom;
import com.google.android.libraries.places.internal.zzpu;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AutocompleteImplFragment extends Fragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f78975v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlacesClient f78976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zznq f78977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzpu f78978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzef f78979d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzoi f78980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PlaceSelectionListener f78981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private EditText f78982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RecyclerView f78983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f78984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f78985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f78986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f78987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f78988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f78989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f78990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f78991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f78992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f78993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private zzah f78994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final zzk f78995u;

    /* synthetic */ AutocompleteImplFragment(int i3, PlacesClient placesClient, zznq zznqVar, zzpu zzpuVar, zzef zzefVar, byte[] bArr) {
        this(i3, placesClient, zznqVar, zzpuVar, zzefVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void B(View view) {
        try {
            this.f78980f.E0(this.f78982h.getText().toString(), this.f78982h.getSelectionEnd());
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void A(AutocompletePrediction autocompletePrediction, int i3) {
        try {
            this.f78980f.B0(autocompletePrediction, i3);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void z(View view) {
        try {
            this.f78980f.D0();
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void x(zzns zznsVar) throws Throwable {
        try {
            this.f78985k.setVisibility(0);
            this.f78986l.setVisibility(0);
            this.f78987m.setVisibility(8);
            this.f78988n.setVisibility(8);
            this.f78989o.setVisibility(0);
            this.f78990p.setVisibility(8);
            this.f78991q.setVisibility(8);
            this.f78992r.setVisibility(8);
            this.f78993s.setVisibility(8);
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            switch (zznsVar.g() - 1) {
                case 0:
                    zznq zznqVar = this.f78977b;
                    if (TextUtils.isEmpty(zznqVar.h())) {
                        this.f78985k.setVisibility(8);
                    }
                    this.f78982h.requestFocus();
                    this.f78982h.setText(zznqVar.h());
                    EditText editText = this.f78982h;
                    editText.setSelection(editText.getText().length());
                    return;
                case 1:
                    this.f78994t.i(null);
                    this.f78985k.setVisibility(8);
                    this.f78982h.getText().clear();
                    return;
                case 2:
                    this.f78987m.setVisibility(0);
                    return;
                case 3:
                    this.f78993s.setVisibility(8);
                    this.f78988n.setVisibility(0);
                    this.f78989o.setVisibility(8);
                    this.f78991q.setVisibility(0);
                    this.f78992r.setVisibility(0);
                    return;
                case 4:
                    this.f78994t.i(zznsVar.b());
                    this.f78990p.setVisibility(0);
                    return;
                case 5:
                    this.f78994t.i(null);
                    this.f78989o.setVisibility(8);
                    this.f78991q.setVisibility(0);
                    this.f78993s.setVisibility(4);
                    this.f78992r.setText(getString(R.string.Z0, zznsVar.a()));
                    this.f78992r.setVisibility(0);
                    return;
                case 6:
                    break;
                case 7:
                default:
                    this.f78981g.c((Place) Preconditions.t(zznsVar.c()));
                    return;
                case 8:
                    AutocompletePrediction autocompletePrediction = (AutocompletePrediction) Preconditions.u(zznsVar.d(), "Prediction should not be null.");
                    this.f78982h.clearFocus();
                    EditText editText2 = this.f78982h;
                    zzk zzkVar = this.f78995u;
                    editText2.removeTextChangedListener(zzkVar);
                    this.f78982h.setText(autocompletePrediction.e(null));
                    this.f78982h.addTextChangedListener(zzkVar);
                    break;
                case 9:
                    this.f78981g.a((Status) Preconditions.t(zznsVar.f()));
                    return;
            }
            this.f78994t.i(null);
            this.f78989o.setVisibility(8);
            this.f78991q.setVisibility(0);
            this.f78993s.setVisibility(0);
            this.f78992r.setText(getString(R.string.f74839f1));
            this.f78992r.setVisibility(0);
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

    final /* synthetic */ zzoi C() {
        return this.f78980f;
    }

    final /* synthetic */ EditText D() {
        return this.f78982h;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            zznq zznqVar = this.f78977b;
            zzom zzomVar = new zzom(zznqVar.c(), null, zznqVar.f(), zznqVar.d(), zznqVar.h(), zznqVar.s(), this.f78979d);
            zzoi zzoiVar = (zzoi) new ViewModelProvider(this, new zzoh(new zzod(this.f78976a, zznqVar, zzomVar.r(), zzmy.AUTOCOMPLETE_WIDGET), zzomVar, this.f78978c)).a(zzoi.class);
            this.f78980f = zzoiVar;
            zzoiVar.z0(bundle);
            requireActivity().getOnBackPressedDispatcher().i(this, new zza(this, true));
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f78980f.I0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f78980f.G0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f78980f.F0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(final View view, Bundle bundle) throws Throwable {
        try {
            this.f78982h = (EditText) view.findViewById(R.id.f74777v1);
            this.f78983i = (RecyclerView) view.findViewById(R.id.f74753o1);
            this.f78984j = view.findViewById(R.id.f74737k1);
            this.f78985k = view.findViewById(R.id.f74741l1);
            this.f78986l = view.findViewById(R.id.f74783x1);
            this.f78987m = view.findViewById(R.id.f74771t1);
            this.f78988n = view.findViewById(R.id.B1);
            this.f78989o = view.findViewById(R.id.f74757p1);
            this.f78990p = view.findViewById(R.id.f74761q1);
            this.f78991q = view.findViewById(R.id.f74774u1);
            this.f78992r = (TextView) view.findViewById(R.id.f74749n1);
            this.f78993s = (TextView) view.findViewById(R.id.A1);
            this.f78982h.addTextChangedListener(this.f78995u);
            this.f78982h.setOnFocusChangeListener(new zzl(null));
            EditText editText = this.f78982h;
            zznq zznqVar = this.f78977b;
            editText.setHint(TextUtils.isEmpty(zznqVar.i()) ? zznt.d(requireContext(), R.string.f74824a1) : zznqVar.i());
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            int iOrdinal = zznqVar.d().ordinal();
            if (iOrdinal == 0) {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzc
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final /* synthetic */ WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        int i3 = AutocompleteImplFragment.f78975v;
                        View view3 = view;
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        if (marginLayoutParams != null) {
                            marginLayoutParams.setMargins(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
                            view3.setLayoutParams(marginLayoutParams);
                        }
                        return windowInsets;
                    }
                });
                int iN = zznqVar.n();
                int iO = zznqVar.o();
                if (Color.alpha(iN) < 255) {
                    iN = 0;
                }
                if (iN != 0 && iO != 0) {
                    int iA = zznu.a(iN, ContextCompat.getColor(requireContext(), R.color.f74674k), ContextCompat.getColor(requireContext(), R.color.f74672i));
                    int iA2 = zznu.a(iN, ContextCompat.getColor(requireContext(), R.color.f74673j), ContextCompat.getColor(requireContext(), R.color.f74671h));
                    view.findViewById(R.id.f74780w1).setBackgroundColor(iN);
                    Window window = requireActivity().getWindow();
                    window.setStatusBarColor(iO);
                    if (zznu.b(iO, -1, -16777216)) {
                        window.getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    }
                    this.f78982h.setTextColor(iA);
                    this.f78982h.setHintTextColor(iA2);
                    zznu.c((ImageView) this.f78984j, iA);
                    zznu.c((ImageView) this.f78985k, iA);
                }
            } else if (iOrdinal == 1) {
                requireActivity().getWindow().addFlags(67108864);
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzd
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final /* synthetic */ WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        int i3 = AutocompleteImplFragment.f78975v;
                        View view3 = view;
                        view3.setPaddingRelative(view3.getPaddingStart(), windowInsets.getSystemWindowInsetTop(), view3.getPaddingEnd(), view3.getPaddingBottom());
                        return windowInsets;
                    }
                });
            }
            this.f78984j.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zze
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view2) {
                    this.f79047a.y(view2);
                }
            });
            this.f78985k.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzf
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view2) {
                    this.f79048a.z(view2);
                }
            });
            this.f78993s.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzh
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view2) {
                    this.f79050a.B(view2);
                }
            });
            this.f78994t = new zzah(new zzai() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzg
                @Override // com.google.android.libraries.places.widget.internal.autocomplete.ui.zzai
                public final /* synthetic */ void a(AutocompletePrediction autocompletePrediction, int i3) {
                    this.f79049a.A(autocompletePrediction, i3);
                }
            });
            this.f78983i.setLayoutManager(new LinearLayoutManager(requireContext()));
            this.f78983i.setItemAnimator(new zzaf(getResources()));
            this.f78983i.setAdapter(this.f78994t);
            this.f78983i.n(new zzb(this));
            this.f78980f.y0().j(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzi
                @Override // androidx.lifecycle.Observer
                public final /* synthetic */ void a(Object obj) throws Throwable {
                    this.f79051a.x((zzns) obj);
                }
            });
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

    public final void w(PlaceSelectionListener placeSelectionListener) {
        this.f78981g = placeSelectionListener;
    }

    final /* synthetic */ void y(View view) {
        this.f78980f.H0();
    }

    private AutocompleteImplFragment(int i3, PlacesClient placesClient, zznq zznqVar, zzpu zzpuVar, zzef zzefVar) {
        super(i3);
        this.f78995u = new zzk(this, null);
        this.f78976a = placesClient;
        this.f78977b = zznqVar;
        this.f78978c = zzpuVar;
        this.f78979d = zzefVar;
    }
}
