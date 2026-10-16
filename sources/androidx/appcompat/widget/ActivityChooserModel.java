package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import d.qFm.sECyKyO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
class ActivityChooserModel extends DataSetObservable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final String f1660n = "ActivityChooserModel";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f1661o = new Object();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Map f1662p = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Context f1666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f1667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Intent f1668f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private OnChooseActivityListener f1675m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1663a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f1664b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f1665c = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ActivitySorter f1669g = new DefaultSorter();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1670h = 50;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f1671i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1672j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1673k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f1674l = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    public interface ActivityChooserModelClient {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolveInfo f1676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1677b;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.f1676a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.f1677b) - Float.floatToIntBits(this.f1677b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.f1677b) == Float.floatToIntBits(((ActivityResolveInfo) obj).f1677b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1677b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f1676a.toString() + "; weight:" + new BigDecimal(this.f1677b) + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    public interface ActivitySorter {
        void a(Intent intent, List list, List list2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private static final class DefaultSorter implements ActivitySorter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f1678a = new HashMap();

        DefaultSorter() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void a(Intent intent, List list, List list2) {
            Map map = this.f1678a;
            map.clear();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) list.get(i3);
                activityResolveInfo.f1677b = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.f1676a.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f3 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = (HistoricalRecord) list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) map.get(historicalRecord.f1679a);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.f1677b += historicalRecord.f1681c * f3;
                    f3 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    public static final class HistoricalRecord {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f1679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1681c;

        public HistoricalRecord(String str, long j3, float f3) {
            this(ComponentName.unflattenFromString(str), j3, f3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.f1679a;
            if (componentName == null) {
                if (historicalRecord.f1679a != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.f1679a)) {
                return false;
            }
            return this.f1680b == historicalRecord.f1680b && Float.floatToIntBits(this.f1681c) == Float.floatToIntBits(historicalRecord.f1681c);
        }

        public int hashCode() {
            ComponentName componentName = this.f1679a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j3 = this.f1680b;
            return ((((iHashCode + 31) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Float.floatToIntBits(this.f1681c);
        }

        public String toString() {
            return "[; activity:" + this.f1679a + "; time:" + this.f1680b + "; weight:" + new BigDecimal(this.f1681c) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j3, float f3) {
            this.f1679a = componentName;
            this.f1680b = j3;
            this.f1681c = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    public interface OnChooseActivityListener {
        boolean a(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                Method dump skipped, instruction units count: 248
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.f1666d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f1667e = str;
            return;
        }
        this.f1667e = str + ".xml";
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean zAdd = this.f1665c.add(historicalRecord);
        if (zAdd) {
            this.f1673k = true;
            l();
            k();
            p();
            notifyChanged();
        }
        return zAdd;
    }

    private void c() {
        boolean zJ = j() | m();
        l();
        if (zJ) {
            p();
            notifyChanged();
        }
    }

    public static ActivityChooserModel d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f1661o) {
            try {
                Map map = f1662p;
                activityChooserModel = (ActivityChooserModel) map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    private boolean j() {
        if (!this.f1674l || this.f1668f == null) {
            return false;
        }
        this.f1674l = false;
        this.f1664b.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f1666d.getPackageManager().queryIntentActivities(this.f1668f, 0);
        int size = listQueryIntentActivities.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f1664b.add(new ActivityResolveInfo(listQueryIntentActivities.get(i3)));
        }
        return true;
    }

    private void k() {
        if (!this.f1672j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f1673k) {
            this.f1673k = false;
            if (TextUtils.isEmpty(this.f1667e)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f1665c), this.f1667e);
        }
    }

    private void l() {
        int size = this.f1665c.size() - this.f1670h;
        if (size <= 0) {
            return;
        }
        this.f1673k = true;
        for (int i3 = 0; i3 < size; i3++) {
        }
    }

    private boolean m() throws IOException {
        if (!this.f1671i || !this.f1673k || TextUtils.isEmpty(this.f1667e)) {
            return false;
        }
        this.f1671i = false;
        this.f1672j = true;
        n();
        return true;
    }

    private boolean p() {
        if (this.f1669g == null || this.f1668f == null || this.f1664b.isEmpty() || this.f1665c.isEmpty()) {
            return false;
        }
        this.f1669g.a(this.f1668f, this.f1664b, Collections.unmodifiableList(this.f1665c));
        return true;
    }

    public Intent b(int i3) {
        synchronized (this.f1663a) {
            try {
                if (this.f1668f == null) {
                    return null;
                }
                c();
                ActivityInfo activityInfo = ((ActivityResolveInfo) this.f1664b.get(i3)).f1676a.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f1668f);
                intent.setComponent(componentName);
                if (this.f1675m != null) {
                    if (this.f1675m.a(this, new Intent(intent))) {
                        return null;
                    }
                }
                a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo e(int i3) {
        ResolveInfo resolveInfo;
        synchronized (this.f1663a) {
            c();
            resolveInfo = ((ActivityResolveInfo) this.f1664b.get(i3)).f1676a;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f1663a) {
            c();
            size = this.f1664b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f1663a) {
            try {
                c();
                List list = this.f1664b;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((ActivityResolveInfo) list.get(i3)).f1676a == resolveInfo) {
                        return i3;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo h() {
        synchronized (this.f1663a) {
            try {
                c();
                if (this.f1664b.isEmpty()) {
                    return null;
                }
                return ((ActivityResolveInfo) this.f1664b.get(0)).f1676a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int i() {
        int size;
        synchronized (this.f1663a) {
            c();
            size = this.f1665c.size();
        }
        return size;
    }

    public void o(int i3) {
        synchronized (this.f1663a) {
            try {
                c();
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.f1664b.get(i3);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.f1664b.get(0);
                float f3 = activityResolveInfo2 != null ? (activityResolveInfo2.f1677b - activityResolveInfo.f1677b) + 5.0f : 1.0f;
                ActivityInfo activityInfo = activityResolveInfo.f1676a.activityInfo;
                a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f3));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n() throws IOException {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.f1666d.openFileInput(this.f1667e);
            try {
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, sECyKyO.kPp);
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!"historical-records".equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List list = this.f1665c;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput != null) {
                                    fileInputStreamOpenFileInput.close();
                                    return;
                                }
                                return;
                            } else if (next2 != 3 && next2 != 4) {
                                if (!"historical-record".equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new HistoricalRecord(xmlPullParserNewPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, "time")), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    } catch (Throwable th) {
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.e(f1660n, "Error reading historical recrod file: " + this.f1667e, e3);
                    if (fileInputStreamOpenFileInput == null) {
                        return;
                    }
                    fileInputStreamOpenFileInput.close();
                }
            } catch (XmlPullParserException e4) {
                Log.e(f1660n, "Error reading historical recrod file: " + this.f1667e, e4);
                if (fileInputStreamOpenFileInput == null) {
                    return;
                }
                fileInputStreamOpenFileInput.close();
            }
        } catch (FileNotFoundException | IOException unused2) {
        }
    }
}
