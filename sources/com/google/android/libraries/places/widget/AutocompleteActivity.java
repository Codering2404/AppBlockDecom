package com.google.android.libraries.places.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzmy;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.internal.zznt;
import com.google.android.libraries.places.internal.zzpr;
import com.google.android.libraries.places.internal.zzps;
import com.google.android.libraries.places.widget.internal.autocomplete.ui.AutocompleteImplFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class AutocompleteActivity extends AppCompatActivity implements PlaceSelectionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f78850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f78851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f78852c;

    public AutocompleteActivity() {
        super(R.layout.f74812w);
        this.f78852c = false;
    }

    private final void V(int i3, Place place, Status status) throws Throwable {
        try {
            Intent intent = new Intent();
            if (place != null) {
                intent.putExtra("places/selected_place", place);
            }
            intent.putExtra("places/status", status);
            setResult(i3, intent);
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

    final /* synthetic */ boolean T(AutocompleteImplFragment autocompleteImplFragment, View view, View view2, MotionEvent motionEvent) {
        this.f78852c = false;
        if (autocompleteImplFragment.getView() == null || motionEvent.getY() <= r1.getBottom()) {
            return false;
        }
        this.f78852c = true;
        view.performClick();
        return true;
    }

    final /* synthetic */ void U(View view) throws Throwable {
        if (this.f78852c) {
            V(0, null, new Status(16));
        }
    }

    @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
    public void a(Status status) throws Throwable {
        V(true != status.C() ? 2 : 0, null, status);
    }

    @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
    public void c(Place place) throws Throwable {
        V(-1, place, Status.f71537g);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        try {
            Preconditions.A(Places.c(), "Places must be initialized.");
            Preconditions.A(getCallingActivity() != null, "Cannot find caller. startActivityForResult should be used.");
            zznq zznqVarC = zznt.c(getIntent());
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            int iOrdinal = zznqVarC.d().ordinal();
            if (iOrdinal == 0) {
                this.f78850a = R.layout.f74814y;
                this.f78851b = R.style.f74886a;
            } else if (iOrdinal == 1) {
                this.f78850a = R.layout.f74815z;
                this.f78851b = R.style.f74887b;
            }
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            int i3 = this.f78850a;
            zzps zzpsVarA = zzpr.a();
            zzpsVarA.zzc(this);
            zzpsVarA.a(zzmy.AUTOCOMPLETE_WIDGET);
            supportFragmentManager.D1(new com.google.android.libraries.places.widget.internal.autocomplete.ui.zzj(i3, zzpsVarA.zza(), zznqVarC));
            setTheme(this.f78851b);
            super.onCreate(bundle);
            final AutocompleteImplFragment autocompleteImplFragment = (AutocompleteImplFragment) getSupportFragmentManager().m0(R.id.f74745m1);
            Preconditions.z(autocompleteImplFragment != null);
            autocompleteImplFragment.w(this);
            final View viewFindViewById = findViewById(android.R.id.content);
            viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.libraries.places.widget.zzb
                @Override // android.view.View.OnTouchListener
                public final /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f79436a.T(autocompleteImplFragment, viewFindViewById, view, motionEvent);
                }
            });
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zza
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) throws Throwable {
                    this.f79407a.U(view);
                }
            });
            if (zznqVarC.e().isEmpty()) {
                V(2, null, new Status(9012, "Place Fields must not be empty."));
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
