package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public interface ICustomTabsCallback extends IInterface {
    public static final String P7 = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

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

    void D3(Bundle bundle);

    void E1(Bundle bundle);

    void P3(int i3, int i4, Bundle bundle);

    void P4(String str, Bundle bundle);

    void W4(Bundle bundle);

    void Z4(int i3, Uri uri, boolean z2, Bundle bundle);

    void d0(int i3, int i4, int i5, int i6, int i7, Bundle bundle);

    void s3(Bundle bundle);

    void t4(int i3, Bundle bundle);

    void u1(String str, Bundle bundle);

    Bundle w0(String str, Bundle bundle);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements ICustomTabsCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements ICustomTabsCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f81a;

            Proxy(IBinder iBinder) {
                this.f81a = iBinder;
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void D3(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void E1(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(9, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void P3(int i3, int i4, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void P4(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeString(str);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void W4(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void Z4(int i3, Uri uri, boolean z2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeInt(i3);
                    _Parcel.d(parcelObtain, uri, 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f81a;
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void d0(int i3, int i4, int i5, int i6, int i7, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeInt(i7);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(10, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void s3(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(11, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void t4(int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeInt(i3);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void u1(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeString(str);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public Bundle w0(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICustomTabsCallback.P7);
                    parcelObtain.writeString(str);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f81a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICustomTabsCallback.P7);
        }

        public static ICustomTabsCallback x3(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICustomTabsCallback.P7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICustomTabsCallback)) ? new Proxy(iBinder) : (ICustomTabsCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = ICustomTabsCallback.P7;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i3) {
                case 2:
                    t4(parcel.readInt(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    u1(parcel.readString(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 4:
                    W4((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    P4(parcel.readString(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    Z4(parcel.readInt(), (Uri) _Parcel.c(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle bundleW0 = w0(parcel.readString(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.d(parcel2, bundleW0, 1);
                    return true;
                case 8:
                    P3(parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 9:
                    E1((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 10:
                    d0(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 11:
                    s3((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
                    return true;
                case 12:
                    D3((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements ICustomTabsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle w0(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void D3(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void E1(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void W4(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void s3(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void P4(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void t4(int i3, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void u1(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void P3(int i3, int i4, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void Z4(int i3, Uri uri, boolean z2, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void d0(int i3, int i4, int i5, int i6, int i7, Bundle bundle) {
        }
    }
}
