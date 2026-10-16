package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.animation.core.h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile boolean f71856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicReference f71857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f71858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final GoogleApiAvailability f71859d;

    zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.f71857b = new AtomicReference(null);
        this.f71858c = new com.google.android.gms.internal.base.zau(Looper.getMainLooper());
        this.f71859d = googleApiAvailability;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ConnectionResult connectionResult, int i3) {
        this.f71857b.set(null);
        b(connectionResult, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        this.f71857b.set(null);
        c();
    }

    private static final int e(zam zamVar) {
        if (zamVar == null) {
            return -1;
        }
        return zamVar.a();
    }

    protected abstract void b(ConnectionResult connectionResult, int i3);

    protected abstract void c();

    public final void h(ConnectionResult connectionResult, int i3) {
        AtomicReference atomicReference;
        zam zamVar = new zam(connectionResult, i3);
        do {
            atomicReference = this.f71857b;
            if (h.a(atomicReference, null, zamVar)) {
                this.f71858c.post(new zao(this, zamVar));
                return;
            }
        } while (atomicReference.get() == null);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onActivityResult(int i3, int i4, Intent intent) {
        zam zamVar = (zam) this.f71857b.get();
        if (i3 != 1) {
            if (i3 == 2) {
                int i5 = this.f71859d.i(getActivity());
                if (i5 == 0) {
                    d();
                    return;
                } else {
                    if (zamVar == null) {
                        return;
                    }
                    if (zamVar.b().N() == 18 && i5 == 18) {
                        return;
                    }
                }
            }
        } else if (i4 == -1) {
            d();
            return;
        } else if (i4 == 0) {
            if (zamVar != null) {
                a(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, zamVar.b().toString()), e(zamVar));
                return;
            }
            return;
        }
        if (zamVar != null) {
            a(zamVar.b(), zamVar.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        a(new ConnectionResult(13, null), e((zam) this.f71857b.get()));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f71857b.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zam zamVar = (zam) this.f71857b.get();
        if (zamVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", zamVar.a());
        bundle.putInt("failed_status", zamVar.b().N());
        bundle.putParcelable("failed_resolution", zamVar.b().g0());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        this.f71856a = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.f71856a = false;
    }
}
