package com.google.firebase.crashlytics.internal.metadata;

import androidx.compose.animation.core.h;
import com.facebook.internal.Utility;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class UserMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MetaDataStore f88553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CrashlyticsWorkers f88554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f88555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SerializeableKeysMap f88556d = new SerializeableKeysMap(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SerializeableKeysMap f88557e = new SerializeableKeysMap(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RolloutAssignmentList f88558f = new RolloutAssignmentList(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicMarkableReference f88559g = new AtomicMarkableReference(null, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class SerializeableKeysMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicMarkableReference f88560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicReference f88561b = new AtomicReference(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f88562c;

        public SerializeableKeysMap(boolean z2) {
            this.f88562c = z2;
            this.f88560a = new AtomicMarkableReference(new KeysMap(64, z2 ? Utility.DEFAULT_STREAM_BUFFER_SIZE : 1024), false);
        }

        public static /* synthetic */ void a(SerializeableKeysMap serializeableKeysMap) throws Throwable {
            serializeableKeysMap.f88561b.set(null);
            serializeableKeysMap.d();
        }

        private void c() {
            Runnable runnable = new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.d
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    UserMetadata.SerializeableKeysMap.a(this.f88571a);
                }
            };
            if (h.a(this.f88561b, null, runnable)) {
                UserMetadata.this.f88554b.f88492b.d(runnable);
            }
        }

        private void d() throws Throwable {
            Map mapA;
            synchronized (this) {
                try {
                    if (this.f88560a.isMarked()) {
                        mapA = ((KeysMap) this.f88560a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f88560a;
                        atomicMarkableReference.set((KeysMap) atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (mapA != null) {
                UserMetadata.this.f88553a.r(UserMetadata.this.f88555c, mapA, this.f88562c);
            }
        }

        public Map b() {
            return ((KeysMap) this.f88560a.getReference()).a();
        }

        public boolean e(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((KeysMap) this.f88560a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f88560a;
                    atomicMarkableReference.set((KeysMap) atomicMarkableReference.getReference(), true);
                    c();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        this.f88555c = str;
        this.f88553a = new MetaDataStore(fileStore);
        this.f88554b = crashlyticsWorkers;
    }

    public static /* synthetic */ void c(UserMetadata userMetadata, String str, Map map, List list) throws Throwable {
        if (userMetadata.j() != null) {
            userMetadata.f88553a.t(str, userMetadata.j());
        }
        if (!map.isEmpty()) {
            userMetadata.f88553a.q(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        userMetadata.f88553a.s(str, list);
    }

    public static UserMetadata k(String str, FileStore fileStore, CrashlyticsWorkers crashlyticsWorkers) {
        MetaDataStore metaDataStore = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsWorkers);
        ((KeysMap) userMetadata.f88556d.f88560a.getReference()).e(metaDataStore.i(str, false));
        ((KeysMap) userMetadata.f88557e.f88560a.getReference()).e(metaDataStore.i(str, true));
        userMetadata.f88559g.set(metaDataStore.k(str), false);
        userMetadata.f88558f.c(metaDataStore.j(str));
        return userMetadata;
    }

    public static String l(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() throws Throwable {
        boolean z2;
        String strJ;
        synchronized (this.f88559g) {
            try {
                z2 = false;
                if (this.f88559g.isMarked()) {
                    strJ = j();
                    this.f88559g.set(strJ, false);
                    z2 = true;
                } else {
                    strJ = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.f88553a.t(this.f88555c, strJ);
        }
    }

    public Map g(Map map) {
        if (map.isEmpty()) {
            return this.f88556d.b();
        }
        HashMap map2 = new HashMap(this.f88556d.b());
        int i3 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String strC = KeysMap.c((String) entry.getKey(), 1024);
            if (map2.size() < 64 || map2.containsKey(strC)) {
                map2.put(strC, KeysMap.c((String) entry.getValue(), 1024));
            } else {
                i3++;
            }
        }
        if (i3 > 0) {
            Logger.f().k("Ignored " + i3 + " keys when adding event specific keys. Maximum allowable: 1024");
        }
        return Collections.unmodifiableMap(map2);
    }

    public Map h() {
        return this.f88557e.b();
    }

    public List i() {
        return this.f88558f.a();
    }

    public String j() {
        return (String) this.f88559g.getReference();
    }

    public boolean n(String str, String str2) {
        return this.f88556d.e(str, str2);
    }

    public boolean o(String str, String str2) {
        return this.f88557e.e(str, str2);
    }

    public void p(final String str) {
        synchronized (this.f88555c) {
            this.f88555c = str;
            final Map mapB = this.f88556d.b();
            final List listB = this.f88558f.b();
            this.f88554b.f88492b.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.a
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    UserMetadata.c(this.f88564a, str, mapB, listB);
                }
            });
        }
    }

    public void q(String str) {
        String strC = KeysMap.c(str, 1024);
        synchronized (this.f88559g) {
            try {
                if (CommonUtils.z(strC, (String) this.f88559g.getReference())) {
                    return;
                }
                this.f88559g.set(strC, true);
                this.f88554b.f88492b.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.b
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.f88568a.m();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean r(List list) {
        synchronized (this.f88558f) {
            try {
                if (!this.f88558f.c(list)) {
                    return false;
                }
                final List listB = this.f88558f.b();
                this.f88554b.f88492b.d(new Runnable() { // from class: com.google.firebase.crashlytics.internal.metadata.c
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        UserMetadata userMetadata = this.f88569a;
                        userMetadata.f88553a.s(userMetadata.f88555c, listB);
                    }
                });
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
