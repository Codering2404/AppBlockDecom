package cz.mobilesoft.coreblock.service;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.CrashHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ForegroundServiceLauncher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f123105f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f123106g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f123107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f123108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f123109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f123110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f123111e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class ForegroundService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f123112a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DirectBinder extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ForegroundService f123113a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f123114b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Function0 f123115c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f123116d;

            public DirectBinder(ForegroundService service, int i3, Function0 notificationProvider) {
                Intrinsics.checkNotNullParameter(service, "service");
                Intrinsics.checkNotNullParameter(notificationProvider, "notificationProvider");
                this.f123113a = service;
                this.f123114b = i3;
                this.f123115c = notificationProvider;
            }

            public final void a(boolean z2) {
                this.f123116d = z2;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Intrinsics.checkNotNullParameter(message, "message");
                Log.d("ForegroundService", LockieApplication.f95363i + " received message " + message.what);
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return;
                    }
                    this.f123113a.stopSelf();
                } else {
                    if (this.f123116d) {
                        return;
                    }
                    try {
                        this.f123113a.startForeground(this.f123114b, (Notification) this.f123115c.invoke());
                    } catch (Exception e3) {
                        CrashHelper.j(e3);
                    }
                }
            }
        }

        public abstract int g();

        public abstract Function0 h();

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Messenger messenger = new Messenger(new DirectBinder(this, g(), h()));
            this.f123112a = messenger;
            return messenger.getBinder();
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            Messenger messenger = this.f123112a;
            IBinder binder = messenger != null ? messenger.getBinder() : null;
            DirectBinder directBinder = binder instanceof DirectBinder ? (DirectBinder) binder : null;
            if (directBinder != null) {
                directBinder.a(true);
            }
        }
    }

    public ForegroundServiceLauncher(Class clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.f123107a = clazz;
    }

    private final void a(final Context context, final int i3, Bundle bundle) {
        Log.d("ForegroundService", LockieApplication.f95363i + " binding for message " + i3);
        context.bindService(c(context, bundle), new ServiceConnection() { // from class: cz.mobilesoft.coreblock.service.ForegroundServiceLauncher$bindToService$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(service, "service");
                try {
                    Log.d("ForegroundService", LockieApplication.f95363i + " sending message " + i3);
                    new Messenger(service).send(Message.obtain(null, i3, 0, 0));
                    context.unbindService(this);
                } catch (Exception e3) {
                    CrashHelper.j(e3);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Intrinsics.checkNotNullParameter(name, "name");
                Log.d("ForegroundService", LockieApplication.f95363i + " disconnected");
            }
        }, 1);
    }

    static /* synthetic */ void b(ForegroundServiceLauncher foregroundServiceLauncher, Context context, int i3, Bundle bundle, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            bundle = null;
        }
        foregroundServiceLauncher.a(context, i3, bundle);
    }

    private final Intent c(Context context, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) this.f123107a);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public final boolean d() {
        return this.f123111e;
    }

    public final synchronized void e(Service service) {
        try {
            Intrinsics.checkNotNullParameter(service, "service");
            this.f123108b = false;
            if (this.f123109c) {
                this.f123109c = false;
                service.stopSelf();
            } else {
                this.f123111e = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f123111e) {
            if (this.f123108b) {
                long j3 = jCurrentTimeMillis - this.f123110d;
                if (1 <= j3 && j3 < 6001) {
                    return;
                }
            }
            this.f123110d = jCurrentTimeMillis;
            this.f123108b = true;
            this.f123109c = false;
        }
        Intrinsics.checkNotNull(applicationContext);
        ContextCompat.startForegroundService(applicationContext, c(applicationContext, bundle));
        a(applicationContext, 1, bundle);
    }

    public final synchronized void g(Context context) throws Throwable {
        Throwable th;
        try {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                Context applicationContext = context.getApplicationContext();
                if (this.f123108b) {
                    try {
                        this.f123109c = true;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    this.f123111e = false;
                    Intrinsics.checkNotNull(applicationContext);
                    b(this, applicationContext, 2, null, 4, null);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }
}
