package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface ITrustedWebActivityService extends IInterface {
    public static final String U7 = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements ITrustedWebActivityService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i3) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i3);
            }
        }
    }

    Bundle D0(String str, Bundle bundle, IBinder iBinder);

    Bundle D1(Bundle bundle);

    Bundle I2();

    int Q3();

    Bundle S3(Bundle bundle);

    Bundle h1();

    void k4(Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements ITrustedWebActivityService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements ITrustedWebActivityService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f86a;

            Proxy(IBinder iBinder) {
                this.f86a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f86a;
            }
        }

        public static ITrustedWebActivityService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ITrustedWebActivityService.U7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ITrustedWebActivityService)) ? new Proxy(iBinder) : (ITrustedWebActivityService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = ITrustedWebActivityService.U7;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i3) {
                case 2:
                    Bundle bundleD1 = D1((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.d(parcel2, bundleD1, 1);
                    return true;
                case 3:
                    k4((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int iQ3 = Q3();
                    parcel2.writeNoException();
                    parcel2.writeInt(iQ3);
                    return true;
                case 5:
                    Bundle bundleI2 = I2();
                    parcel2.writeNoException();
                    _Parcel.d(parcel2, bundleI2, 1);
                    return true;
                case 6:
                    Bundle bundleS3 = S3((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.d(parcel2, bundleS3, 1);
                    return true;
                case 7:
                    Bundle bundleH1 = h1();
                    parcel2.writeNoException();
                    _Parcel.d(parcel2, bundleH1, 1);
                    return true;
                case 8:
                default:
                    return super.onTransact(i3, parcel, parcel2, i4);
                case 9:
                    Bundle bundleD0 = D0(parcel.readString(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    _Parcel.d(parcel2, bundleD0, 1);
                    return true;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
