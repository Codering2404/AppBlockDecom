package com.google.android.libraries.places.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.internal.autocomplete.ui.BaseAutocompleteImplFragment;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzni extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f78247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f78248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseAutocompleteImplFragment f78249c;

    public zzni() {
        super(R.layout.f74792c);
        this.f78248b = R.style.f74888c;
    }

    public final void T(int i3, Place place, Status status) throws Throwable {
        try {
            Intent intent = new Intent();
            if (place != null) {
                intent.putExtra("places/selected_place", place);
            }
            intent.putExtra("places/status", status);
            setResult(i3, intent);
            BaseAutocompleteImplFragment baseAutocompleteImplFragment = this.f78249c;
            if (baseAutocompleteImplFragment != null) {
                baseAutocompleteImplFragment.w();
            }
            finish();
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

    public final void U(int i3, AutocompletePrediction autocompletePrediction, AutocompleteSessionToken autocompleteSessionToken, Status status) throws Throwable {
        try {
            Intent intent = new Intent();
            if (autocompletePrediction != null && autocompleteSessionToken != null) {
                intent.putExtra("places/selected_prediction", autocompletePrediction);
                intent.putExtra("places/session_token", autocompleteSessionToken);
            }
            intent.putExtra("places/status", status);
            setResult(i3, intent);
            BaseAutocompleteImplFragment baseAutocompleteImplFragment = this.f78249c;
            if (baseAutocompleteImplFragment != null) {
                baseAutocompleteImplFragment.w();
            }
            finish();
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

    public final void V(int i3, Status status) {
        try {
            Intent intent = new Intent();
            intent.putExtra("places/status", status);
            setResult(i3, intent);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        Integer numE;
        try {
            Preconditions.A(Places.c(), "Places must be initialized.");
            Preconditions.A(getCallingActivity() != null, "Cannot find caller. startActivityForResult should be used.");
            zznq zznqVarC = zznt.c(getIntent());
            AutocompleteUiCustomization autocompleteUiCustomizationQ = zznqVarC.q();
            if (autocompleteUiCustomizationQ != null && (numE = autocompleteUiCustomizationQ.e()) != null) {
                this.f78248b = numE.intValue();
            }
            this.f78247a = R.layout.f74793d;
            setTheme(this.f78248b);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            int i3 = this.f78247a;
            zzps zzpsVarA = zzpr.a();
            zzpsVarA.zzc(this);
            zzpsVarA.a(zznqVarC.c() == zzow.JWT_AND_ONE_PLATFORM ? zzmy.PLACES_UI_KIT : zzmy.ONE_PLATFORM_AUTOCOMPLETE_WIDGET);
            supportFragmentManager.D1(new com.google.android.libraries.places.widget.internal.autocomplete.ui.zzab(i3, zzpsVarA.zza(), zznqVarC, this.f78248b));
            super.onCreate(bundle);
            BaseAutocompleteImplFragment baseAutocompleteImplFragment = (BaseAutocompleteImplFragment) getSupportFragmentManager().m0(R.id.f74743m);
            this.f78249c = baseAutocompleteImplFragment;
            Preconditions.z(baseAutocompleteImplFragment != null);
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
