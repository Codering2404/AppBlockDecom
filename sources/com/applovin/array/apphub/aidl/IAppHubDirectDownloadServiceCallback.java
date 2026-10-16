package com.applovin.array.apphub.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IAppHubDirectDownloadServiceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback";

    void onAppDetailsDismissed(String str) throws RemoteException;

    void onAppDetailsShown(String str) throws RemoteException;

    void onDownloadStarted(String str) throws RemoteException;

    void onError(String str, String str2) throws RemoteException;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IAppHubDirectDownloadServiceCallback {
        static final int TRANSACTION_onAppDetailsDismissed = 2;
        static final int TRANSACTION_onAppDetailsShown = 1;
        static final int TRANSACTION_onDownloadStarted = 3;
        static final int TRANSACTION_onError = 4;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IAppHubDirectDownloadServiceCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppHubDirectDownloadServiceCallback.DESCRIPTOR;
            }

            @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
            public void onAppDetailsDismissed(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
            public void onAppDetailsShown(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
            public void onDownloadStarted(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
            public void onError(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
        }

        public static IAppHubDirectDownloadServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAppHubDirectDownloadServiceCallback)) ? new Proxy(iBinder) : (IAppHubDirectDownloadServiceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(IAppHubDirectDownloadServiceCallback.DESCRIPTOR);
                return true;
            }
            if (i3 == 1) {
                onAppDetailsShown(parcel.readString());
            } else if (i3 == 2) {
                onAppDetailsDismissed(parcel.readString());
            } else if (i3 == 3) {
                onDownloadStarted(parcel.readString());
            } else {
                if (i3 != 4) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                onError(parcel.readString(), parcel.readString());
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IAppHubDirectDownloadServiceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
        public void onAppDetailsDismissed(String str) throws RemoteException {
        }

        @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
        public void onAppDetailsShown(String str) throws RemoteException {
        }

        @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
        public void onDownloadStarted(String str) throws RemoteException {
        }

        @Override // com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback
        public void onError(String str, String str2) throws RemoteException {
        }
    }
}
