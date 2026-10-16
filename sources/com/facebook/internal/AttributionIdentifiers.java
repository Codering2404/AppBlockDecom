package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    public static volatile AttributionIdentifiers cachedIdentifiers;
    private String androidAdvertiserIdValue;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean isTrackingLimited;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
            return attributionIdentifiers;
        }

        private final AttributionIdentifiers getAndroidId(Context context) {
            AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
            if (androidIdViaReflection != null) {
                return androidIdViaReflection;
            }
            AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
            return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context) {
            Method methodQuietly;
            Object objInvokeMethodQuietly;
            try {
                if (!isGooglePlayServicesAvailable(context) || (methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class})) == null || (objInvokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                    return null;
                }
                Method methodQuietly2 = Utility.getMethodQuietly(objInvokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Method methodQuietly3 = Utility.getMethodQuietly(objInvokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly2 != null && methodQuietly3 != null) {
                    AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                    attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly2, new Object[0]);
                    Boolean bool = (Boolean) Utility.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly3, new Object[0]);
                    attributionIdentifiers.isTrackingLimited = bool != null ? bool.booleanValue() : false;
                    return attributionIdentifiers;
                }
                return null;
            } catch (Exception e3) {
                Utility.logd("android_id", e3);
                return null;
            }
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context) {
            if (!isGooglePlayServicesAvailable(context)) {
                return null;
            }
            GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                try {
                    if (context.bindService(intent, googleAdServiceConnection, 1)) {
                        GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                        attributionIdentifiers.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                        attributionIdentifiers.isTrackingLimited = googleAdInfo.isTrackingLimited();
                        return attributionIdentifiers;
                    }
                } catch (Exception e3) {
                    Utility.logd("android_id", e3);
                } finally {
                    context.unbindService(googleAdServiceConnection);
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        private final String getInstallerPackageName(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getInstallerPackageName(context.getPackageName());
            }
            return null;
        }

        private final boolean isGooglePlayServicesAvailable(Context context) {
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Object objInvokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            return (objInvokeMethodQuietly instanceof Integer) && Intrinsics.areEqual(objInvokeMethodQuietly, (Object) 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[Catch: all -> 0x0033, Exception -> 0x0037, TryCatch #5 {Exception -> 0x0037, all -> 0x0033, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:14:0x003c, B:16:0x0057, B:18:0x0064, B:25:0x0083, B:27:0x0089, B:29:0x008e, B:31:0x0093, B:21:0x006e, B:23:0x007b, B:53:0x00f1, B:54:0x00f8), top: B:66:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[Catch: all -> 0x0033, Exception -> 0x0037, TryCatch #5 {Exception -> 0x0037, all -> 0x0033, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:14:0x003c, B:16:0x0057, B:18:0x0064, B:25:0x0083, B:27:0x0089, B:29:0x008e, B:31:0x0093, B:21:0x006e, B:23:0x007b, B:53:0x00f1, B:54:0x00f8), top: B:66:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[Catch: all -> 0x0033, Exception -> 0x0037, TRY_LEAVE, TryCatch #5 {Exception -> 0x0037, all -> 0x0033, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:14:0x003c, B:16:0x0057, B:18:0x0064, B:25:0x0083, B:27:0x0089, B:29:0x008e, B:31:0x0093, B:21:0x006e, B:23:0x007b, B:53:0x00f1, B:54:0x00f8), top: B:66:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:68:? A[SYNTHETIC] */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r12) {
            /*
                Method dump skipped, instruction units count: 288
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        @JvmStatic
        public final boolean isTrackingLimited(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
            return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
        }

        private Companion() {
        }

        public static /* synthetic */ void getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations() {
        }

        public static /* synthetic */ void getCachedIdentifiers$facebook_core_release$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class GoogleAdInfo implements IInterface {
        public static final Companion Companion = new Companion(null);
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private final IBinder binder;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public GoogleAdInfo(IBinder binder) {
            Intrinsics.checkNotNullParameter(binder, "binder");
            this.binder = binder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
            Parcel parcelObtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain()");
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
            Parcel parcelObtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain()");
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @JvmStatic
    public static final AttributionIdentifiers getAttributionIdentifiers(Context context) {
        return Companion.getAttributionIdentifiers(context);
    }

    @JvmStatic
    public static final boolean isTrackingLimited(Context context) {
        return Companion.isTrackingLimited(context);
    }

    public final String getAndroidAdvertiserId() {
        if (FacebookSdk.isInitialized() && FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return this.androidAdvertiserIdValue;
        }
        return null;
    }

    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private final AtomicBoolean consumed = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(false, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            IBinder iBinderTake = this.queue.take();
            Intrinsics.checkNotNullExpressionValue(iBinderTake, "queue.take()");
            return iBinderTake;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException e3) {
                    Utility.logd(AttributionIdentifiers.TAG, "Service connection interrupted", e3);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
