package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.firebase.datastorage.JavaDataStorage;
import com.google.firebase.datastorage.JavaDataStorageKt;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class HeartBeatInfoStorage {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Preferences.Key f89198b = PreferencesKeys.f(QgXempTBEfV.foO);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Preferences.Key f89199c = PreferencesKeys.f("fire-count");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Preferences.Key f89200d = PreferencesKeys.g("last-used-date");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JavaDataStorage f89201a;

    public HeartBeatInfoStorage(Context context, String str) {
        this.f89201a = new JavaDataStorage(context, "FirebaseHeartBeat" + str);
    }

    public static /* synthetic */ Unit a(long j3, MutablePreferences mutablePreferences) {
        mutablePreferences.k(f89198b, Long.valueOf(j3));
        return null;
    }

    public static /* synthetic */ Unit c(HeartBeatInfoStorage heartBeatInfoStorage, MutablePreferences mutablePreferences) {
        heartBeatInfoStorage.getClass();
        long j3 = 0;
        for (Map.Entry entry : mutablePreferences.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Preferences.Key key = (Preferences.Key) entry.getKey();
                Set set = (Set) entry.getValue();
                String strH = heartBeatInfoStorage.h(System.currentTimeMillis());
                if (set.contains(strH)) {
                    mutablePreferences.k(key, com.google.android.gms.measurement.internal.g.a(new Object[]{strH}));
                    j3++;
                } else {
                    mutablePreferences.j(key);
                }
            }
        }
        if (j3 == 0) {
            mutablePreferences.j(f89199c);
            return null;
        }
        mutablePreferences.k(f89199c, Long.valueOf(j3));
        return null;
    }

    public static /* synthetic */ Unit d(HeartBeatInfoStorage heartBeatInfoStorage, String str, MutablePreferences mutablePreferences) {
        heartBeatInfoStorage.getClass();
        mutablePreferences.k(f89200d, str);
        heartBeatInfoStorage.l(mutablePreferences, str);
        return null;
    }

    private synchronized long e(MutablePreferences mutablePreferences) {
        long j3;
        try {
            long jLongValue = ((Long) JavaDataStorageKt.a(mutablePreferences, f89199c, 0L)).longValue();
            String strA = "";
            Set hashSet = new HashSet();
            String str = null;
            for (Map.Entry entry : mutablePreferences.a().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str2 : set) {
                        if (str == null || str.compareTo(str2) > 0) {
                            strA = ((Preferences.Key) entry.getKey()).a();
                            hashSet = set;
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str);
            mutablePreferences.k(PreferencesKeys.h(strA), hashSet2);
            j3 = jLongValue - 1;
            mutablePreferences.k(f89199c, Long.valueOf(j3));
        } catch (Throwable th) {
            throw th;
        }
        return j3;
    }

    private synchronized String h(long j3) {
        return new Date(j3).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private synchronized Preferences.Key i(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry entry : mutablePreferences.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return PreferencesKeys.h(((Preferences.Key) entry.getKey()).a());
                    }
                }
            }
        }
        return null;
    }

    private synchronized void l(MutablePreferences mutablePreferences, String str) {
        try {
            Preferences.Key keyI = i(mutablePreferences, str);
            if (keyI == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.a(mutablePreferences, keyI, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                mutablePreferences.j(keyI);
            } else {
                mutablePreferences.k(keyI, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void q(MutablePreferences mutablePreferences, Preferences.Key key, String str) {
        l(mutablePreferences, str);
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.a(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.k(key, hashSet);
    }

    synchronized void f() {
        this.f89201a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeartBeatInfoStorage.c(this.f89213a, (MutablePreferences) obj);
            }
        });
    }

    synchronized List g() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String strH = h(System.currentTimeMillis());
            for (Map.Entry entry : this.f89201a.h().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(strH);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(HeartBeatResult.a(((Preferences.Key) entry.getKey()).a(), new ArrayList(hashSet)));
                    }
                }
            }
            p(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    synchronized boolean j(long j3, long j4) {
        return h(j3).equals(h(j4));
    }

    synchronized void k() {
        final String strH = h(System.currentTimeMillis());
        this.f89201a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeartBeatInfoStorage.d(this.f89207a, strH, (MutablePreferences) obj);
            }
        });
    }

    synchronized boolean m(long j3) {
        return n(f89198b, j3);
    }

    synchronized boolean n(Preferences.Key key, long j3) {
        if (j(((Long) this.f89201a.j(key, -1L)).longValue(), j3)) {
            return false;
        }
        this.f89201a.k(key, Long.valueOf(j3));
        return true;
    }

    synchronized void o(long j3, final String str) {
        final String strH = h(j3);
        final Preferences.Key keyH = PreferencesKeys.h(str);
        this.f89201a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeartBeatInfoStorage.b(this.f89209a, strH, str, keyH, (MutablePreferences) obj);
            }
        });
    }

    synchronized void p(final long j3) {
        this.f89201a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeartBeatInfoStorage.a(j3, (MutablePreferences) obj);
            }
        });
    }

    public static /* synthetic */ Unit b(HeartBeatInfoStorage heartBeatInfoStorage, String str, String str2, Preferences.Key key, MutablePreferences mutablePreferences) {
        heartBeatInfoStorage.getClass();
        Preferences.Key key2 = f89200d;
        if (((String) JavaDataStorageKt.a(mutablePreferences, key2, vfptEEmYY.udaCMLvcl)).equals(str)) {
            Preferences.Key keyI = heartBeatInfoStorage.i(mutablePreferences, str);
            if (keyI == null || keyI.a().equals(str2)) {
                return null;
            }
            heartBeatInfoStorage.q(mutablePreferences, key, str);
            return null;
        }
        Preferences.Key key3 = f89199c;
        long jLongValue = ((Long) JavaDataStorageKt.a(mutablePreferences, key3, 0L)).longValue();
        if (jLongValue + 1 == 30) {
            jLongValue = heartBeatInfoStorage.e(mutablePreferences);
        }
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.a(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.k(key, hashSet);
        mutablePreferences.k(key3, Long.valueOf(jLongValue + 1));
        mutablePreferences.k(key2, str);
        return null;
    }
}
