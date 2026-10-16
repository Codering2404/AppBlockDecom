package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StreetViewPanorama {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IStreetViewPanoramaDelegate f73100a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnStreetViewPanoramaCameraChangeListener {
        void a(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnStreetViewPanoramaChangeListener {
        void a(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnStreetViewPanoramaClickListener {
        void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnStreetViewPanoramaLongClickListener {
        void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f73100a = (IStreetViewPanoramaDelegate) Preconditions.n(iStreetViewPanoramaDelegate, "delegate");
    }

    public StreetViewPanoramaLocation a() {
        try {
            return this.f73100a.r0();
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void b(OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        try {
            if (onStreetViewPanoramaCameraChangeListener == null) {
                this.f73100a.I1(null);
            } else {
                this.f73100a.I1(new zzak(this, onStreetViewPanoramaCameraChangeListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void c(OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        try {
            if (onStreetViewPanoramaChangeListener == null) {
                this.f73100a.J2(null);
            } else {
                this.f73100a.J2(new zzaj(this, onStreetViewPanoramaChangeListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void d(OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        try {
            if (onStreetViewPanoramaClickListener == null) {
                this.f73100a.o3(null);
            } else {
                this.f73100a.o3(new zzal(this, onStreetViewPanoramaClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public final void e(OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        try {
            if (onStreetViewPanoramaLongClickListener == null) {
                this.f73100a.P(null);
            } else {
                this.f73100a.P(new zzam(this, onStreetViewPanoramaLongClickListener));
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(boolean z2) {
        try {
            this.f73100a.E2(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(boolean z2) {
        try {
            this.f73100a.Z3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(boolean z2) {
        try {
            this.f73100a.z1(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(boolean z2) {
        try {
            this.f73100a.d3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
