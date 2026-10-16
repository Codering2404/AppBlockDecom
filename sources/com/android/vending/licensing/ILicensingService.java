package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.android.vending.licensing.ILicenseResultListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ILicensingService extends IInterface {
    void N1(long j3, String str, ILicenseResultListener iLicenseResultListener);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements ILicensingService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements ILicensingService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f57601a;

            Proxy(IBinder iBinder) {
                this.f57601a = iBinder;
            }

            @Override // com.android.vending.licensing.ILicensingService
            public void N1(long j3, String str, ILicenseResultListener iLicenseResultListener) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    parcelObtain.writeLong(j3);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLicenseResultListener != null ? iLicenseResultListener.asBinder() : null);
                    this.f57601a.transact(1, parcelObtain, null, 1);
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f57601a;
            }
        }

        public static ILicensingService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILicensingService)) ? new Proxy(iBinder) : (ILicensingService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 == 1) {
                parcel.enforceInterface("com.android.vending.licensing.ILicensingService");
                N1(parcel.readLong(), parcel.readString(), ILicenseResultListener.Stub.x3(parcel.readStrongBinder()));
                return true;
            }
            if (i3 != 1598968902) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            parcel2.writeString("com.android.vending.licensing.ILicensingService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
