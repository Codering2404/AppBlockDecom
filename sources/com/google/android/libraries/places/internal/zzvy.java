package com.google.android.libraries.places.internal;

import android.os.Build;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvy extends zzvq {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final boolean f78706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f78707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final boolean f78708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicReference f78709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicLong f78710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ConcurrentLinkedQueue f78711h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile zzup f78712b;

    private zzvy(String str) {
        super(str);
        if (f78706c || f78707d) {
            this.f78712b = new zzvr().zza(c());
        } else if (f78708e) {
            this.f78712b = zzwc.d().a(false).zza(c());
        } else {
            this.f78712b = null;
        }
    }

    public static zzup d(String str) {
        AtomicReference atomicReference = f78709f;
        if (atomicReference.get() != null) {
            return ((zzvs) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char cCharAt = str.charAt(length);
                if (cCharAt != '$') {
                    if (cCharAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace('$', '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzvy zzvyVar = new zzvy(str);
        ConcurrentLinkedQueue concurrentLinkedQueue = zzvw.f78703a;
        concurrentLinkedQueue.offer(zzvyVar);
        if (atomicReference.get() != null) {
            while (true) {
                zzvy zzvyVar2 = (zzvy) concurrentLinkedQueue.poll();
                if (zzvyVar2 == null) {
                    break;
                }
                zzvyVar2.f78712b = ((zzvs) atomicReference.get()).zza(zzvyVar2.c());
            }
            e();
        }
        return zzvyVar;
    }

    private static void e() {
        while (true) {
            zzvx zzvxVar = (zzvx) f78711h.poll();
            if (zzvxVar == null) {
                return;
            }
            f78710g.getAndDecrement();
            zzup zzupVarA = zzvxVar.a();
            zzun zzunVarB = zzvxVar.b();
            if (zzunVarB.zzk() || zzupVarA.a(zzunVarB.zze())) {
                zzupVarA.b(zzunVarB);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzup
    public final boolean a(Level level) {
        return this.f78712b == null || this.f78712b.a(level);
    }

    @Override // com.google.android.libraries.places.internal.zzup
    public final void b(zzun zzunVar) {
        if (this.f78712b != null) {
            this.f78712b.b(zzunVar);
            return;
        }
        if (f78710g.incrementAndGet() > 20) {
            f78711h.poll();
            Log.w("ProxyAndroidLoggerBackend", "Too many Flogger logs received before configuration. Dropping old logs.");
        }
        f78711h.offer(new zzvx(this, zzunVar));
        if (this.f78712b != null) {
            e();
        }
    }

    static {
        String str = Build.FINGERPRINT;
        f78706c = str == null || vgWWUoTKYyuC.zQVhVxlxzUMgkN.equals(str);
        String str2 = Build.HARDWARE;
        f78707d = "goldfish".equals(str2) || "ranchu".equals(str2);
        String str3 = Build.TYPE;
        f78708e = "eng".equals(str3) || "userdebug".equals(str3);
        f78709f = new AtomicReference();
        f78710g = new AtomicLong();
        f78711h = new ConcurrentLinkedQueue();
    }
}
