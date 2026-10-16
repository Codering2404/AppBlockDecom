package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.customtabs.ICustomTabsCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface ICustomTabsService extends IInterface {
    public static final String Q7 = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements ICustomTabsService {
        @Override // android.support.customtabs.ICustomTabsService
        public boolean A4(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int T3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return 0;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean U(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean d4(ICustomTabsCallback iCustomTabsCallback) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean n3(long j3) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean o1(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean r1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean v2(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List list) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object d(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void e(Parcel parcel, List list, int i3) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i4 = 0; i4 < size; i4++) {
                f(parcel, (Parcelable) list.get(i4), i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void f(Parcel parcel, Parcelable parcelable, int i3) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i3);
            }
        }
    }

    boolean A4(ICustomTabsCallback iCustomTabsCallback, Uri uri);

    boolean B1(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle);

    boolean G1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    int T3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle);

    boolean U(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle);

    boolean c5(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean d4(ICustomTabsCallback iCustomTabsCallback);

    boolean i0(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i3, Bundle bundle);

    boolean n3(long j3);

    boolean o1(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle);

    boolean r1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle);

    boolean v2(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List list);

    Bundle y0(String str, Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements ICustomTabsService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements ICustomTabsService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f82a;

            Proxy(IBinder iBinder) {
                this.f82a = iBinder;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean A4(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.f(parcelObtain, uri, 0);
                    this.f82a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public int T3(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    parcelObtain.writeString(str);
                    _Parcel.f(parcelObtain, bundle, 0);
                    this.f82a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean U(ICustomTabsCallback iCustomTabsCallback, int i3, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    parcelObtain.writeInt(i3);
                    _Parcel.f(parcelObtain, uri, 0);
                    _Parcel.f(parcelObtain, bundle, 0);
                    this.f82a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f82a;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean d4(ICustomTabsCallback iCustomTabsCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    this.f82a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean n3(long j3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeLong(j3);
                    this.f82a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean o1(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.f(parcelObtain, uri, 0);
                    _Parcel.f(parcelObtain, bundle, 0);
                    this.f82a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean r1(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.f(parcelObtain, bundle, 0);
                    this.f82a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean v2(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List list) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsService.Q7);
                    parcelObtain.writeStrongInterface(iCustomTabsCallback);
                    _Parcel.f(parcelObtain, uri, 0);
                    _Parcel.f(parcelObtain, bundle, 0);
                    _Parcel.e(parcelObtain, list, 0);
                    this.f82a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ICustomTabsService x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICustomTabsService.Q7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICustomTabsService)) ? new Proxy(iBinder) : (ICustomTabsService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = ICustomTabsService.Q7;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i3) {
                case 2:
                    boolean zN3 = n3(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zN3 ? 1 : 0);
                    return true;
                case 3:
                    boolean zD4 = d4(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zD4 ? 1 : 0);
                    return true;
                case 4:
                    ICustomTabsCallback iCustomTabsCallbackX3 = ICustomTabsCallback.Stub.x3(parcel.readStrongBinder());
                    Uri uri = (Uri) _Parcel.d(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zV2 = v2(iCustomTabsCallbackX3, uri, (Bundle) _Parcel.d(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(zV2 ? 1 : 0);
                    return true;
                case 5:
                    Bundle bundleY0 = y0(parcel.readString(), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.f(parcel2, bundleY0, 1);
                    return true;
                case 6:
                    boolean zG1 = G1(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zG1 ? 1 : 0);
                    return true;
                case 7:
                    boolean zA4 = A4(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Uri) _Parcel.d(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zA4 ? 1 : 0);
                    return true;
                case 8:
                    int iT3 = T3(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), parcel.readString(), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iT3);
                    return true;
                case 9:
                    boolean zU = U(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), parcel.readInt(), (Uri) _Parcel.d(parcel, Uri.CREATOR), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zU ? 1 : 0);
                    return true;
                case 10:
                    boolean zR1 = r1(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zR1 ? 1 : 0);
                    return true;
                case 11:
                    boolean zO1 = o1(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Uri) _Parcel.d(parcel, Uri.CREATOR), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zO1 ? 1 : 0);
                    return true;
                case 12:
                    boolean zI0 = i0(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Uri) _Parcel.d(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zI0 ? 1 : 0);
                    return true;
                case 13:
                    boolean zC5 = c5(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zC5 ? 1 : 0);
                    return true;
                case 14:
                    boolean zB1 = B1(ICustomTabsCallback.Stub.x3(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) _Parcel.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zB1 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i3, parcel, parcel2, i4);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
