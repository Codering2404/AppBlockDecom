package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ILicenseResultListener extends IInterface {
    void b2(int i3, String str, String str2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements ILicenseResultListener {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements ILicenseResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f57600a;

            Proxy(IBinder iBinder) {
                this.f57600a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f57600a;
            }
        }

        public Stub() {
            attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
        }

        public static ILicenseResultListener x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicenseResultListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILicenseResultListener)) ? new Proxy(iBinder) : (ILicenseResultListener) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 == 1) {
                parcel.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
                b2(parcel.readInt(), parcel.readString(), parcel.readString());
                return true;
            }
            if (i3 != 1598968902) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            parcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
