package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd implements Parcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Messenger f71387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IMessengerCompat f71388b;

    public zzd(IBinder iBinder) {
        this.f71387a = new Messenger(iBinder);
    }

    public final IBinder c() {
        Messenger messenger = this.f71387a;
        return messenger != null ? messenger.getBinder() : this.f71388b.asBinder();
    }

    public final void d(Message message) throws RemoteException {
        Messenger messenger = this.f71387a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f71388b.H2(message);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return c().equals(((zzd) obj).c());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return c().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Messenger messenger = this.f71387a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f71388b.asBinder());
        }
    }
}
