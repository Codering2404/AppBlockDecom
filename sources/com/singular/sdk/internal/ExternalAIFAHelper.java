package com.singular.sdk.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class ExternalAIFAHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92565a = SingularLog.f(ExternalAIFAHelper.class.getSimpleName());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface GoogleAdvertisingInfo extends IInterface {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static abstract class GoogleAdvertisingInfoBinder extends Binder implements GoogleAdvertisingInfo {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private static class GoogleAdvertisingInfoImplementation implements GoogleAdvertisingInfo {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private IBinder f92566a;

                GoogleAdvertisingInfoImplementation(IBinder iBinder) {
                    this.f92566a = iBinder;
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return this.f92566a;
                }

                @Override // com.singular.sdk.internal.ExternalAIFAHelper.GoogleAdvertisingInfo
                public String getId() {
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        this.f92566a.transact(1, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        return parcelObtain2.readString();
                    } finally {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                }
            }

            public static GoogleAdvertisingInfo x3(IBinder iBinder) {
                if (iBinder == null) {
                    ExternalAIFAHelper.f92565a.a("GoogleAdvertisingInfoBinder.Create: binder is null, cannot create advertising info");
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof GoogleAdvertisingInfo)) ? new GoogleAdvertisingInfoImplementation(iBinder) : (GoogleAdvertisingInfo) iInterfaceQueryLocalInterface;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
                if (i3 == 1) {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String id = getId();
                    parcel2.writeNoException();
                    parcel2.writeString(id);
                    return true;
                }
                if (i3 != 2) {
                    return super.onTransact(i3, parcel, parcel2, i4);
                }
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean zL0 = l0(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(zL0 ? 1 : 0);
                return true;
            }
        }

        String getId();

        boolean l0(boolean z2);
    }

    public static String b(Context context) {
        try {
            String strC = c(context);
            f92565a.a("Got AIFA by querying Google Play service");
            return strC;
        } catch (Throwable unused) {
            f92565a.a("Could not determine AIFA");
            return null;
        }
    }

    static String c(Context context) {
        GoogleAdvertisingServiceConnection googleAdvertisingServiceConnection = new GoogleAdvertisingServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, googleAdvertisingServiceConnection, 1)) {
            return "";
        }
        try {
            return GoogleAdvertisingInfo.GoogleAdvertisingInfoBinder.x3(googleAdvertisingServiceConnection.a()).getId();
        } catch (Throwable th) {
            try {
                f92565a.c("Failed to query advertising ID from service: " + Utils.l(th));
                return "";
            } finally {
                context.unbindService(googleAdvertisingServiceConnection);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GoogleAdvertisingServiceConnection implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f92567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue f92568b;

        private GoogleAdvertisingServiceConnection() {
            this.f92567a = false;
            this.f92568b = new LinkedBlockingQueue();
        }

        public IBinder a() {
            if (this.f92567a) {
                throw new IllegalStateException();
            }
            this.f92567a = true;
            return (IBinder) this.f92568b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f92568b.put(iBinder);
            } catch (InterruptedException e3) {
                ExternalAIFAHelper.f92565a.a("Interrupted while adding binder to queue: " + Utils.l(e3));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
