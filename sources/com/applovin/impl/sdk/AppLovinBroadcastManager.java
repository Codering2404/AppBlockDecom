package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinBroadcastManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f63118a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f63119b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ArrayList f63120c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f63121d = new a(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Receiver {
        void onReceive(Intent intent, Map<String, Object> map);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AppLovinBroadcastManager.b();
            } else {
                super.handleMessage(message);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f63122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f63123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List f63124c;

        b(Intent intent, Map map, List list) {
            this.f63122a = intent;
            this.f63123b = map;
            this.f63124c = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f63125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Receiver f63126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f63127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f63128d;

        c(IntentFilter intentFilter, Receiver receiver) {
            this.f63125a = intentFilter;
            this.f63126b = receiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (f63118a) {
                try {
                    ArrayList arrayList = f63120c;
                    size = arrayList.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    arrayList.toArray(bVarArr);
                    arrayList.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = bVarArr[i3];
                if (bVar != null) {
                    for (c cVar : bVar.f63124c) {
                        if (cVar != null && !cVar.f63128d) {
                            cVar.f63126b.onReceive(bVar.f63122a, bVar.f63123b);
                        }
                    }
                }
            }
        }
    }

    public static void registerReceiver(Receiver receiver, IntentFilter intentFilter) {
        Map map = f63118a;
        synchronized (map) {
            try {
                c cVar = new c(intentFilter, receiver);
                ArrayList arrayList = (ArrayList) map.get(receiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    map.put(receiver, arrayList);
                }
                arrayList.add(cVar);
                Iterator<String> itActionsIterator = intentFilter.actionsIterator();
                while (itActionsIterator.hasNext()) {
                    String next = itActionsIterator.next();
                    Map map2 = f63119b;
                    ArrayList arrayList2 = (ArrayList) map2.get(next);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        map2.put(next, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean sendBroadcast(Intent intent, Map<String, Object> map) {
        synchronized (f63118a) {
            try {
                List listA = a(intent);
                if (listA == null) {
                    return false;
                }
                f63120c.add(new b(intent, map, listA));
                Handler handler = f63121d;
                if (!handler.hasMessages(1)) {
                    handler.sendEmptyMessage(1);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void sendBroadcastSync(Intent intent, Map<String, Object> map) {
        List<c> listA = a(intent);
        if (listA == null) {
            return;
        }
        for (c cVar : listA) {
            if (!cVar.f63128d) {
                cVar.f63126b.onReceive(intent, map);
            }
        }
    }

    public static void sendBroadcastSyncWithPendingBroadcasts(Intent intent, Map<String, Object> map) {
        if (sendBroadcast(intent, map)) {
            b();
        }
    }

    public static boolean sendBroadcastWithAdObject(String str, Object obj) {
        HashMap map = new HashMap(1);
        map.put("ad", obj);
        return sendBroadcast(new Intent(str), map);
    }

    public static void unregisterReceiver(Receiver receiver) {
        Map map = f63118a;
        synchronized (map) {
            try {
                List<c> list = (List) map.remove(receiver);
                if (list == null) {
                    return;
                }
                for (c cVar : list) {
                    cVar.f63128d = true;
                    Iterator<String> itActionsIterator = cVar.f63125a.actionsIterator();
                    while (itActionsIterator.hasNext()) {
                        String next = itActionsIterator.next();
                        List list2 = (List) f63119b.get(next);
                        if (list2 != null) {
                            Iterator it = list2.iterator();
                            while (it.hasNext()) {
                                if (((c) it.next()).f63126b == receiver) {
                                    cVar.f63128d = true;
                                    it.remove();
                                }
                            }
                            if (list2.size() <= 0) {
                                f63119b.remove(next);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static List a(Intent intent) {
        synchronized (f63118a) {
            try {
                String action = intent.getAction();
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                List<c> list = (List) f63119b.get(action);
                if (list == null) {
                    return null;
                }
                ArrayList arrayList = null;
                for (c cVar : list) {
                    if (!cVar.f63127c && cVar.f63125a.match(action, null, scheme, data, categories, "AppLovinBroadcastManager") >= 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(cVar);
                        cVar.f63127c = true;
                    }
                }
                if (arrayList == null) {
                    return null;
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((c) obj).f63127c = false;
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
