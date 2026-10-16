package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class UiSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IUiSettingsDelegate f73115a;

    UiSettings(IUiSettingsDelegate iUiSettingsDelegate) {
        this.f73115a = iUiSettingsDelegate;
    }

    public void a(boolean z2) {
        try {
            this.f73115a.z2(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void b(boolean z2) {
        try {
            this.f73115a.j2(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void c(boolean z2) {
        try {
            this.f73115a.p1(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void d(boolean z2) {
        try {
            this.f73115a.T(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void e(boolean z2) {
        try {
            this.f73115a.B3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void f(boolean z2) {
        try {
            this.f73115a.o4(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void g(boolean z2) {
        try {
            this.f73115a.A2(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void h(boolean z2) {
        try {
            this.f73115a.i3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void i(boolean z2) {
        try {
            this.f73115a.v3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public void j(boolean z2) {
        try {
            this.f73115a.k3(z2);
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }
}
