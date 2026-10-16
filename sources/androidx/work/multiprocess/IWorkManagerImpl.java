package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IWorkManagerImpl extends IInterface {
    public static final String q8 = "androidx$work$multiprocess$IWorkManagerImpl".replace('$', '.');

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Default implements IWorkManagerImpl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    void Q1(String str, byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    void R4(String str, IWorkManagerImplCallback iWorkManagerImplCallback);

    void S(String str, IWorkManagerImplCallback iWorkManagerImplCallback);

    void b0(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    void e2(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    void h0(IWorkManagerImplCallback iWorkManagerImplCallback);

    void l2(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    void r3(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    void s1(String str, IWorkManagerImplCallback iWorkManagerImplCallback);

    void z4(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends Binder implements IWorkManagerImpl {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Proxy implements IWorkManagerImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f55272a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f55272a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            String str = IWorkManagerImpl.q8;
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i3) {
                case 1:
                    b0(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 2:
                    Q1(parcel.readString(), parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 3:
                    l2(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 4:
                    s1(parcel.readString(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 5:
                    R4(parcel.readString(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 6:
                    S(parcel.readString(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 7:
                    h0(IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 8:
                    r3(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 9:
                    e2(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
                    return true;
                case 10:
                    z4(parcel.createByteArray(), IWorkManagerImplCallback.Stub.x3(parcel.readStrongBinder()));
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
