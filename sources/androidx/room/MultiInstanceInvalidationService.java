package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f52224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f52225b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RemoteCallbackList f52226c = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService$callbackList$1
        @Override // android.os.RemoteCallbackList
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(IMultiInstanceInvalidationCallback callback, Object cookie) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.f52229a.b().remove((Integer) cookie);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IMultiInstanceInvalidationService.Stub f52227d = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService$binder$1
        @Override // androidx.room.IMultiInstanceInvalidationService
        public int W2(IMultiInstanceInvalidationCallback callback, String str) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            int i3 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList remoteCallbackListA = this.f52228a.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.f52228a;
            synchronized (remoteCallbackListA) {
                try {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() + 1);
                    int iC = multiInstanceInvalidationService.c();
                    if (multiInstanceInvalidationService.a().register(callback, Integer.valueOf(iC))) {
                        multiInstanceInvalidationService.b().put(Integer.valueOf(iC), str);
                        i3 = iC;
                    } else {
                        multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() - 1);
                        multiInstanceInvalidationService.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i3;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void Y1(int i3, String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            RemoteCallbackList remoteCallbackListA = this.f52228a.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.f52228a;
            synchronized (remoteCallbackListA) {
                String str = (String) multiInstanceInvalidationService.b().get(Integer.valueOf(i3));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int iBeginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
                for (int i4 = 0; i4 < iBeginBroadcast; i4++) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i4);
                        Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService.b().get(num);
                        if (i3 != iIntValue && Intrinsics.areEqual(str, str2)) {
                            try {
                                ((IMultiInstanceInvalidationCallback) multiInstanceInvalidationService.a().getBroadcastItem(i4)).g0(tables);
                                Unit unit = Unit.f139807a;
                            } catch (RemoteException e3) {
                                Log.w("ROOM", "Error invoking a remote callback", e3);
                            }
                        }
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.a().finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.a().finishBroadcast();
                Unit unit2 = Unit.f139807a;
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void d5(IMultiInstanceInvalidationCallback callback, int i3) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            RemoteCallbackList remoteCallbackListA = this.f52228a.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.f52228a;
            synchronized (remoteCallbackListA) {
                multiInstanceInvalidationService.a().unregister(callback);
            }
        }
    };

    public final RemoteCallbackList a() {
        return this.f52226c;
    }

    public final Map b() {
        return this.f52225b;
    }

    public final int c() {
        return this.f52224a;
    }

    public final void d(int i3) {
        this.f52224a = i3;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.f52227d;
    }
}
