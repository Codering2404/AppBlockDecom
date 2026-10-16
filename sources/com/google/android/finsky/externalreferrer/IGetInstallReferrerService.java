package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface IGetInstallReferrerService extends IInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Stub extends b implements IGetInstallReferrerService {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Proxy extends a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            public final Bundle c(Bundle bundle) {
                Parcel parcelX3 = x3();
                c.b(parcelX3, bundle);
                Parcel parcelH5 = h5(parcelX3);
                Bundle bundle2 = (Bundle) c.a(parcelH5, Bundle.CREATOR);
                parcelH5.recycle();
                return bundle2;
            }
        }

        public static IGetInstallReferrerService h5(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterfaceQueryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.a.b
        protected final boolean x3(int i3, Parcel parcel, Parcel parcel2) {
            if (i3 != 1) {
                return false;
            }
            Bundle bundleC = c((Bundle) c.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            c.c(parcel2, bundleC);
            return true;
        }
    }

    Bundle c(Bundle bundle);
}
