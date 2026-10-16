package com.google.android.libraries.places.widget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznp;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.internal.zznt;
import com.google.android.libraries.places.internal.zzor;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class AutocompleteSupportFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableLiveData f78853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableLiveData f78854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zznp f78855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PlaceSelectionListener f78856d;

    public AutocompleteSupportFragment() {
        super(R.layout.f74813x);
        this.f78853a = new MutableLiveData();
        this.f78854b = new MutableLiveData();
        this.f78855c = zznq.u(AutocompleteActivityMode.OVERLAY, ImmutableList.y(), zzor.FRAGMENT);
    }

    private final void C(View view) {
        view.setVisibility(true != TextUtils.isEmpty((CharSequence) this.f78853a.f()) ? 0 : 8);
    }

    private final void D() throws Throwable {
        Intent intentA = new Autocomplete.IntentBuilder(this.f78855c.j()).a(requireContext());
        if (requireView().isEnabled()) {
            requireView().setEnabled(false);
            startActivityForResult(intentA, 30421);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(EditText editText, View view, CharSequence charSequence) {
        try {
            editText.setHint(charSequence);
            view.setContentDescription(charSequence);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void A(EditText editText, View view, CharSequence charSequence) {
        try {
            editText.setText(charSequence);
            C(view);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i3, int i4, Intent intent) throws Throwable {
        if (i3 == 30421) {
            try {
                PlaceSelectionListener placeSelectionListener = this.f78856d;
                if (placeSelectionListener == null) {
                    if (Log.isLoggable("Places", 5)) {
                        Log.w("Places", "No PlaceSelectionListener is set. No result will be delivered.");
                    }
                } else if (intent == null) {
                    if (Log.isLoggable("Places", 6)) {
                        Log.e("Places", "Intent data was null.");
                    }
                } else {
                    if (i4 != -1) {
                        placeSelectionListener.a(Autocomplete.b(intent));
                        return;
                    }
                    Place placeA = Autocomplete.a(intent);
                    placeSelectionListener.c(placeA);
                    x(placeA.p());
                }
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
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                zznq zznqVar = (zznq) bundle.getParcelable(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                if (zznqVar == null) {
                    return;
                }
                MutableLiveData mutableLiveData = this.f78853a;
                if (mutableLiveData.f() == null) {
                    mutableLiveData.n(zznqVar.h());
                }
                MutableLiveData mutableLiveData2 = this.f78854b;
                if (mutableLiveData2.f() == null) {
                    mutableLiveData2.n(zznqVar.i());
                }
                this.f78855c = zznqVar.t();
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
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        requireView().setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, this.f78855c.j());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        final View viewFindViewById = view.findViewById(R.id.f74786y1);
        final View viewFindViewById2 = view.findViewById(R.id.f74741l1);
        final EditText editText = (EditText) view.findViewById(R.id.f74789z1);
        editText.setHint(zznt.d(requireContext(), R.string.f74824a1));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzg
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) throws Throwable {
                this.f79446a.y(view2);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzc
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) throws Throwable {
                this.f79439a.z(view2);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzd
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                this.f79440a.x(null);
            }
        });
        C(viewFindViewById2);
        this.f78853a.j(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.zze
            @Override // androidx.lifecycle.Observer
            public final /* synthetic */ void a(Object obj) {
                this.f79441a.A(editText, viewFindViewById2, (CharSequence) obj);
            }
        });
        this.f78854b.j(getViewLifecycleOwner(), new Observer() { // from class: com.google.android.libraries.places.widget.zzf
            @Override // androidx.lifecycle.Observer
            public final /* synthetic */ void a(Object obj) {
                AutocompleteSupportFragment.E(editText, viewFindViewById, (CharSequence) obj);
            }
        });
    }

    public AutocompleteSupportFragment w(PlaceSelectionListener placeSelectionListener) {
        this.f78856d = placeSelectionListener;
        return this;
    }

    public AutocompleteSupportFragment x(CharSequence charSequence) {
        try {
            this.f78855c.e(TextUtils.isEmpty(charSequence) ? null : charSequence.toString());
            this.f78853a.n(charSequence);
            return this;
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    final /* synthetic */ void y(View view) throws Throwable {
        D();
    }

    final /* synthetic */ void z(View view) throws Throwable {
        D();
    }
}
