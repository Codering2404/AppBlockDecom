package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.appsflyer.AFLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class AFa1hSDK implements AFa1cSDK {
    private final AFc1zSDK values;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AFa1wSDK implements IInterface {
        private final IBinder AFInAppEventType;

        AFa1wSDK(IBinder iBinder) {
            this.AFInAppEventType = iBinder;
        }

        public final String AFInAppEventType() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.AFInAppEventType.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.AFInAppEventType;
        }

        final boolean valueOf() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.AFInAppEventType.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AFa1xSDK {
        private final boolean AFInAppEventParameterName;
        final String values;

        AFa1xSDK(String str, boolean z2) {
            this.values = str;
            this.AFInAppEventParameterName = z2;
        }

        final boolean AFKeystoreWrapper() {
            return this.AFInAppEventParameterName;
        }
    }

    AFa1hSDK() {
    }

    static AFa1xSDK AFInAppEventType(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        AFa1ySDK aFa1ySDK = new AFa1ySDK((byte) 0);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, aFa1ySDK, 1)) {
                context.unbindService(aFa1ySDK);
                throw new IOException("Google Play connection failed");
            }
            if (aFa1ySDK.AFInAppEventType) {
                throw new IllegalStateException("Cannot call get on this connection more than once");
            }
            aFa1ySDK.AFInAppEventType = true;
            IBinder iBinderPoll = aFa1ySDK.valueOf.poll(10L, TimeUnit.SECONDS);
            if (iBinderPoll == null) {
                throw new TimeoutException("Timed out waiting for the service connection");
            }
            AFa1wSDK aFa1wSDK = new AFa1wSDK(iBinderPoll);
            return new AFa1xSDK(aFa1wSDK.AFInAppEventType(), aFa1wSDK.valueOf());
        } finally {
            context.unbindService(aFa1ySDK);
        }
    }

    @Override // com.appsflyer.internal.AFa1cSDK
    public final void AFInAppEventParameterName() {
        try {
            if (new File(this.values.values.getFilesDir(), "AFRequestCache").exists()) {
                return;
            }
            new File(this.values.values.getFilesDir(), "AFRequestCache").mkdir();
        } catch (Exception e3) {
            AFLogger.afErrorLog("CACHE: Could not create cache directory", e3);
        }
    }

    @Override // com.appsflyer.internal.AFa1cSDK
    public final List<AFa1uSDK> AFKeystoreWrapper() {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(this.values.values.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    StringBuilder sb = new StringBuilder("CACHE: Found cached request");
                    sb.append(file2.getName());
                    AFLogger.afInfoLog(sb.toString());
                    arrayList.add(AFInAppEventType(file2));
                }
            }
            return arrayList;
        } catch (Exception e3) {
            AFLogger.afErrorLog("CACHE: Could not get cached requests", e3);
            return arrayList;
        }
    }

    @Override // com.appsflyer.internal.AFa1cSDK
    public final boolean valueOf(String str) {
        File file = new File(new File(this.values.values.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("CACHE: Deleting ");
        sb.append(str);
        sb.append(" from cache");
        AFLogger.afInfoLog(sb.toString());
        if (!file.exists()) {
            return true;
        }
        try {
            return file.delete();
        } catch (Exception e3) {
            StringBuilder sb2 = new StringBuilder("CACHE: Could not delete ");
            sb2.append(str);
            sb2.append(" from cache");
            AFLogger.afErrorLog(sb2.toString(), e3);
            return false;
        }
    }

    @Override // com.appsflyer.internal.AFa1cSDK
    public final void values() {
        try {
            File file = new File(this.values.values.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                StringBuilder sb = new StringBuilder("CACHE: Found cached request");
                sb.append(file2.getName());
                AFLogger.afInfoLog(sb.toString());
                StringBuilder sb2 = new StringBuilder("CACHE: Deleting ");
                sb2.append(file2.getName());
                sb2.append(" from cache");
                AFLogger.afInfoLog(sb2.toString());
                file2.delete();
            }
        } catch (Exception e3) {
            AFLogger.afErrorLog("CACHE: Could not cache request", e3);
        }
    }

    public AFa1hSDK(AFc1zSDK aFc1zSDK) {
        this.values = aFc1zSDK;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AFa1ySDK implements ServiceConnection {
        boolean AFInAppEventType;
        final LinkedBlockingQueue<IBinder> valueOf;

        private AFa1ySDK() {
            this.valueOf = new LinkedBlockingQueue<>(1);
            this.AFInAppEventType = false;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.valueOf.put(iBinder);
            } catch (InterruptedException e3) {
                AFLogger.afErrorLogForExcManagerOnly("onServiceConnected Interrupted", e3);
            }
        }

        /* synthetic */ AFa1ySDK(byte b3) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.appsflyer.internal.AFa1cSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String AFInAppEventType(com.appsflyer.internal.AFa1uSDK r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1hSDK.AFInAppEventType(com.appsflyer.internal.AFa1uSDK):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.appsflyer.internal.AFa1uSDK AFInAppEventType(java.io.File r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "could not close load reader"
            r1 = 0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.nio.charset.Charset r4 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            long r3 = r5.length()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            char[] r3 = new char[r3]     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r2.read(r3)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            com.appsflyer.internal.AFa1uSDK r4 = new com.appsflyer.internal.AFa1uSDK     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r4.AFKeystoreWrapper = r5     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            r2.close()     // Catch: java.io.IOException -> L2a
            return r4
        L2a:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
            return r4
        L2f:
            r5 = move-exception
            r1 = r2
            goto L48
        L32:
            r5 = move-exception
            goto L38
        L34:
            r5 = move-exception
            goto L48
        L36:
            r5 = move-exception
            r2 = r1
        L38:
            java.lang.String r3 = "error while loading request from cache"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r5)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L47
            r2.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L47:
            return r1
        L48:
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r1 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L52:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1hSDK.AFInAppEventType(java.io.File):com.appsflyer.internal.AFa1uSDK");
    }
}
