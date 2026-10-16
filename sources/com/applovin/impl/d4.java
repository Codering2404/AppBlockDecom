package com.applovin.impl;

import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List f59066e = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f59067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f59068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final dg f59069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f59070d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f59071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f59072b;

        public long a() {
            return this.f59071a;
        }

        public long b() {
            return this.f59072b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j3) {
            this.f59071a = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j3) {
            this.f59072b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f59073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.network.a f59074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f59075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f59076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f59077e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f59078f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final e f59079g;

        private c(String str, com.applovin.impl.sdk.network.a aVar, String str2, Object obj, boolean z2, b bVar, e eVar) {
            this.f59073a = str;
            this.f59074b = aVar;
            this.f59075c = str2;
            this.f59076d = obj;
            this.f59077e = z2;
            this.f59078f = bVar;
            this.f59079g = eVar;
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0054: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:85), block:B:32:0x0053 */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01d9  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01df  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01f1 A[Catch: all -> 0x0211, TryCatch #0 {all -> 0x0211, blocks: (B:86:0x01e6, B:88:0x01f1, B:90:0x01f5, B:91:0x0209), top: B:101:0x01e6 }] */
        @Override // androidx.core.util.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void accept(com.applovin.impl.dg.d r12) {
            /*
                Method dump skipped, instruction units count: 600
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.d4.c.accept(com.applovin.impl.dg$d):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f59081a = System.currentTimeMillis();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f59082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f59083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f59084d;

        public d(String str, long j3, long j4) {
            this.f59082b = str;
            this.f59083c = j3;
            this.f59084d = j4;
        }

        protected boolean a(Object obj) {
            return obj instanceof d;
        }

        public long b() {
            return this.f59083c;
        }

        public long c() {
            return this.f59081a;
        }

        public String d() {
            return this.f59082b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this) || c() != dVar.c() || b() != dVar.b() || a() != dVar.a()) {
                return false;
            }
            String strD = d();
            String strD2 = dVar.d();
            return strD != null ? strD.equals(strD2) : strD2 == null;
        }

        public int hashCode() {
            long jC = c();
            long jB = b();
            int i3 = ((((int) (jC ^ (jC >>> 32))) + 59) * 59) + ((int) (jB ^ (jB >>> 32)));
            long jA = a();
            String strD = d();
            return (((i3 * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (strD == null ? 43 : strD.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + c() + ", urlHostAndPathString=" + d() + ", responseSizeBytes=" + b() + ", connectionTimeMillis=" + a() + ")";
        }

        public long a() {
            return this.f59084d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface e {
        void a(String str, int i3, String str2, Object obj);

        void a(String str, Object obj, int i3);
    }

    public d4(com.applovin.impl.sdk.j jVar) {
        this.f59067a = jVar;
        this.f59068b = jVar.I();
        dg dgVar = new dg(jVar);
        this.f59069c = dgVar;
        dgVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    public d a() {
        return this.f59070d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (obj instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (obj instanceof es) {
                return fs.a(str, this.f59067a);
            }
            if (obj instanceof String) {
                return str;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f59068b.b("ConnectionManager", "Failed to process response of type '" + obj.getClass().getName() + "'");
            }
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0248 A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #0 {all -> 0x0173, blocks: (B:48:0x0136, B:52:0x0163, B:51:0x015f, B:59:0x019d, B:61:0x01b5, B:67:0x01d7, B:82:0x022e, B:85:0x023d, B:87:0x0248, B:69:0x01db, B:72:0x01e3, B:77:0x01fa, B:79:0x0200, B:80:0x021a, B:63:0x01c4, B:90:0x0251, B:74:0x01f4), top: B:115:0x0136, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.applovin.impl.sdk.network.a r20, com.applovin.impl.d4.b r21, com.applovin.impl.d4.e r22) {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.d4.a(com.applovin.impl.sdk.network.a, com.applovin.impl.d4$b, com.applovin.impl.d4$e):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i3, long j3) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f59068b.d("ConnectionManager", "Successful " + str + " returned " + i3 + " in " + (j3 / 1000.0f) + " s over " + e4.g(this.f59067a) + " to " + a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i3, long j3, Throwable th) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f59068b.a("ConnectionManager", "Failed " + str + " returned " + i3 + " in " + (j3 / 1000.0f) + " s over " + e4.g(this.f59067a) + " to " + a(str2), th);
        }
    }

    private String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }
}
