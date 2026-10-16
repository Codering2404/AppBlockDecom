package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zak extends zap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray f71844f;

    private zak(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.q());
        this.f71844f = new SparseArray();
        this.mLifecycleFragment.a("AutoManageHelper", this);
    }

    public static zak i(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zak zakVar = (zak) fragment.c("AutoManageHelper", zak.class);
        return zakVar != null ? zakVar : new zak(fragment);
    }

    private final zaj l(int i3) {
        if (this.f71844f.size() <= i3) {
            return null;
        }
        SparseArray sparseArray = this.f71844f;
        return (zaj) sparseArray.get(sparseArray.keyAt(i3));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void b(ConnectionResult connectionResult, int i3) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i3 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaj zajVar = (zaj) this.f71844f.get(i3);
        if (zajVar != null) {
            k(i3);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zajVar.f71842c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void c() {
        for (int i3 = 0; i3 < this.f71844f.size(); i3++) {
            zaj zajVarL = l(i3);
            if (zajVarL != null) {
                zajVarL.f71841b.d();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i3 = 0; i3 < this.f71844f.size(); i3++) {
            zaj zajVarL = l(i3);
            if (zajVarL != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zajVarL.f71840a);
                printWriter.println(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                zajVarL.f71841b.f(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void j(int i3, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.n(googleApiClient, "GoogleApiClient instance cannot be null");
        Preconditions.r(this.f71844f.indexOfKey(i3) < 0, "Already managing a GoogleApiClient with id " + i3);
        zam zamVar = (zam) this.f71857b.get();
        Log.d("AutoManageHelper", "starting AutoManage for client " + i3 + " " + this.f71856a + " " + String.valueOf(zamVar));
        zaj zajVar = new zaj(this, i3, googleApiClient, onConnectionFailedListener);
        googleApiClient.o(zajVar);
        this.f71844f.put(i3, zajVar);
        if (this.f71856a && zamVar == null) {
            Log.d("AutoManageHelper", "connecting ".concat(googleApiClient.toString()));
            googleApiClient.d();
        }
    }

    public final void k(int i3) {
        zaj zajVar = (zaj) this.f71844f.get(i3);
        this.f71844f.remove(i3);
        if (zajVar != null) {
            zajVar.f71841b.p(zajVar);
            zajVar.f71841b.e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        SparseArray sparseArray = this.f71844f;
        Log.d("AutoManageHelper", "onStart " + this.f71856a + " " + String.valueOf(sparseArray));
        if (this.f71857b.get() == null) {
            for (int i3 = 0; i3 < this.f71844f.size(); i3++) {
                zaj zajVarL = l(i3);
                if (zajVarL != null) {
                    zajVarL.f71841b.d();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        for (int i3 = 0; i3 < this.f71844f.size(); i3++) {
            zaj zajVarL = l(i3);
            if (zajVarL != null) {
                zajVarL.f71841b.e();
            }
        }
    }
}
