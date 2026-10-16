package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LocalBroadcastManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f40322f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static LocalBroadcastManager f40323g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f40324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f40325b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f40326c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f40327d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f40328e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BroadcastRecord {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f40330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList f40331b;

        BroadcastRecord(Intent intent, ArrayList arrayList) {
            this.f40330a = intent;
            this.f40331b = arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ReceiverRecord {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f40332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f40333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f40334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f40335d;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f40332a = intentFilter;
            this.f40333b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            sb.append("Receiver{");
            sb.append(this.f40333b);
            sb.append(" filter=");
            sb.append(this.f40332a);
            if (this.f40335d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.f40324a = context;
        this.f40328e = new Handler(context.getMainLooper()) { // from class: androidx.localbroadcastmanager.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.a();
                }
            }
        };
    }

    public static LocalBroadcastManager b(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f40322f) {
            try {
                if (f40323g == null) {
                    f40323g = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = f40323g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    void a() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.f40325b) {
                try {
                    size = this.f40327d.size();
                    if (size <= 0) {
                        return;
                    }
                    broadcastRecordArr = new BroadcastRecord[size];
                    this.f40327d.toArray(broadcastRecordArr);
                    this.f40327d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i3];
                int size2 = broadcastRecord.f40331b.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) broadcastRecord.f40331b.get(i4);
                    if (!receiverRecord.f40335d) {
                        receiverRecord.f40333b.onReceive(this.f40324a, broadcastRecord.f40330a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f40325b) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f40325b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f40325b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(receiverRecord);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList arrayList2 = (ArrayList) this.f40326c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f40326c.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        String str;
        synchronized (this.f40325b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f40324a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z2 = (intent.getFlags() & 8) != 0;
                if (z2) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList = (ArrayList) this.f40326c.get(intent.getAction());
                if (arrayList != null) {
                    if (z2) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                    }
                    ArrayList arrayList2 = null;
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(i3);
                        if (z2) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.f40332a);
                        }
                        if (receiverRecord.f40334c) {
                            if (z2) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            str = action;
                        } else {
                            int iMatch = receiverRecord.f40332a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z2) {
                                    StringBuilder sb = new StringBuilder();
                                    str = action;
                                    sb.append("  Filter matched!  match=0x");
                                    sb.append(Integer.toHexString(iMatch));
                                    Log.v("LocalBroadcastManager", sb.toString());
                                } else {
                                    str = action;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(receiverRecord);
                                receiverRecord.f40334c = true;
                            } else {
                                str = action;
                                if (z2) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                                }
                            }
                        }
                        i3++;
                        action = str;
                    }
                    if (arrayList2 != null) {
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            ((ReceiverRecord) arrayList2.get(i4)).f40334c = false;
                        }
                        this.f40327d.add(new BroadcastRecord(intent, arrayList2));
                        if (!this.f40328e.hasMessages(1)) {
                            this.f40328e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f40325b) {
            try {
                ArrayList arrayList = (ArrayList) this.f40325b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(size);
                    receiverRecord.f40335d = true;
                    for (int i3 = 0; i3 < receiverRecord.f40332a.countActions(); i3++) {
                        String action = receiverRecord.f40332a.getAction(i3);
                        ArrayList arrayList2 = (ArrayList) this.f40326c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList2.get(size2);
                                if (receiverRecord2.f40333b == broadcastReceiver) {
                                    receiverRecord2.f40335d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f40326c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
