package com.google.android.libraries.places.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzoi extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zznx f78324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzom f78325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzpu f78326c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f78328f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f78327d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableLiveData f78329g = new MutableLiveData();

    /* synthetic */ zzoi(zznx zznxVar, zzom zzomVar, zzpu zzpuVar, byte[] bArr) {
        this.f78324a = zznxVar;
        this.f78325b = zzomVar;
        this.f78326c = zzpuVar;
    }

    private final void N0(zzns zznsVar) {
        MutableLiveData mutableLiveData = this.f78329g;
        if (zznsVar.equals(mutableLiveData.f())) {
            return;
        }
        mutableLiveData.p(zznsVar);
    }

    private static Status O0(Exception exc) {
        return exc instanceof ApiException ? ((ApiException) exc).getStatus() : new Status(13, exc.getMessage());
    }

    private static boolean P0(Status status) {
        return status.C() || status.O() == 9012 || status.O() == 9011;
    }

    public final void A0(final String str, final int i3) {
        this.f78325b.e(str);
        Runnable runnable = this.f78328f;
        if (runnable != null) {
            this.f78327d.removeCallbacks(runnable);
        }
        if (str.isEmpty()) {
            this.f78324a.zzc();
            N0(zzns.i());
        } else {
            Runnable runnable2 = new Runnable() { // from class: com.google.android.libraries.places.internal.zzog
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f78318a.K0(str, i3);
                }
            };
            this.f78328f = runnable2;
            this.f78327d.postDelayed(runnable2, 100L);
            N0(zzns.j());
        }
    }

    public final void B0(final AutocompletePrediction autocompletePrediction, int i3) {
        zzom zzomVar = this.f78325b;
        zzomVar.G(i3);
        zznx zznxVar = this.f78324a;
        if (zznxVar.zzf() == zzmy.PLACES_UI_KIT) {
            Place.Builder builderC = Place.c();
            builderC.D(autocompletePrediction.d());
            Place placeA = builderC.a();
            zzomVar.c();
            N0(zzns.o(placeA));
            return;
        }
        if (zznxVar.zzf() == zzmy.ONE_PLATFORM_AUTOCOMPLETE_WIDGET) {
            zzomVar.c();
            N0(zzns.p(autocompletePrediction, zzomVar.r()));
        } else {
            Task taskB = zznxVar.b(autocompletePrediction);
            if (!taskB.isComplete()) {
                N0(zzns.j());
            }
            taskB.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzof
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final /* synthetic */ void onComplete(Task task) {
                    this.f78316a.M0(autocompletePrediction, task);
                }
            });
        }
    }

    public final void C0() {
        this.f78325b.g();
    }

    public final void D0() {
        this.f78325b.f();
        A0("", 0);
    }

    public final void E0(String str, int i3) {
        this.f78324a.zzc();
        A0(str, i3);
        N0(zzns.k());
    }

    public final void F0() {
        this.f78325b.h();
    }

    public final void G0() {
        this.f78325b.i();
    }

    public final void H0() {
        this.f78325b.H();
        N0(zzns.r());
    }

    public final void I0() {
        this.f78324a.zzd();
    }

    public final void J0() {
        this.f78324a.zze();
    }

    final /* synthetic */ void K0(final String str, int i3) {
        this.f78324a.a(str, i3).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzoe
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                this.f78314a.L0(str, task);
            }
        });
    }

    final /* synthetic */ void L0(String str, Task task) {
        if (task.isCanceled()) {
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            this.f78325b.J();
            List listA = ((FindAutocompletePredictionsResponse) task.getResult()).a();
            if (listA.isEmpty()) {
                N0(zzns.m(str));
                return;
            } else {
                N0(zzns.l(listA));
                return;
            }
        }
        String message = exception.getMessage();
        if (message != null && message.contains("Too many concurrent requests")) {
            this.f78325b.L();
            return;
        }
        this.f78325b.K();
        Status statusO0 = O0(exception);
        if (P0(statusO0)) {
            N0(zzns.s(statusO0));
        } else {
            N0(zzns.n(str, statusO0));
        }
    }

    final /* synthetic */ void M0(AutocompletePrediction autocompletePrediction, Task task) {
        if (task.isCanceled()) {
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            this.f78325b.c();
            N0(zzns.o(((FetchPlaceResponse) task.getResult()).a()));
            return;
        }
        this.f78325b.d();
        Status statusO0 = O0(exception);
        if (P0(statusO0)) {
            N0(zzns.s(statusO0));
        } else {
            N0(zzns.q(autocompletePrediction, statusO0));
        }
    }

    @Override // androidx.lifecycle.ViewModel
    protected final void onCleared() {
        try {
            this.f78324a.zzc();
            this.f78327d.removeCallbacks(this.f78328f);
            zzom zzomVar = this.f78325b;
            zzomVar.I();
            this.f78326c.c(zzomVar);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public final LiveData y0() {
        return this.f78329g;
    }

    public final void z0(Bundle bundle) {
        if (bundle == null) {
            this.f78329g.p(zzns.h());
        }
    }
}
