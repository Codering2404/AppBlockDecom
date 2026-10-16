package com.applovin.impl.sdk;

import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NativeCrashReporter implements g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f63151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f63152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NativeCrashReporter f63153c = new NativeCrashReporter();

    private NativeCrashReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(g.b bVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "ad_unit_id", bVar.a());
        JsonUtils.putString(jSONObject, "ad_format", bVar.g());
        JsonUtils.putString(jSONObject, "network_name", bVar.c());
        JsonUtils.putString(jSONObject, "adapter_class", bVar.b());
        JsonUtils.putString(jSONObject, "adapter_version", bVar.d());
        JsonUtils.putString(jSONObject, "bcode", bVar.e());
        JsonUtils.putString(jSONObject, "creative_id", bVar.f());
        JsonUtils.putString(jSONObject, "operation", bVar.i().toString());
        updateAdInfo(bVar.h(), jSONObject.toString());
    }

    private native void disable();

    private native void enable(String str, int[] iArr, boolean z2);

    private native void removeAdInfo(int i3);

    private native void updateAdInfo(int i3, String str);

    public static void a(j jVar) {
        if (jVar == null) {
            return;
        }
        if (!((Boolean) jVar.a(sj.s4)).booleanValue() && !yp.i(j.m())) {
            if (f63152b) {
                try {
                    g gVarK = jVar.k();
                    NativeCrashReporter nativeCrashReporter = f63153c;
                    gVarK.a(nativeCrashReporter);
                    nativeCrashReporter.disable();
                    return;
                } catch (Throwable th) {
                    jVar.I();
                    if (n.a()) {
                        jVar.I().a("NativeCrashReporter", "Failed to disable native crash reporter", th);
                    }
                    jVar.D().a("NativeCrashReporter", "disableInstance", th);
                    return;
                }
            }
            return;
        }
        if (a()) {
            List listC = jVar.c(sj.t4);
            int[] iArr = new int[listC.size()];
            for (int i3 = 0; i3 < listC.size(); i3++) {
                try {
                    iArr[i3] = Integer.parseInt((String) listC.get(i3));
                } catch (NumberFormatException unused) {
                }
            }
            File file = new File(j.m().getCacheDir(), "al-reports");
            if (file.exists()) {
                a(file, jVar);
            } else if (!file.mkdir()) {
                jVar.I();
                if (n.a()) {
                    jVar.I().b("NativeCrashReporter", "Failed to create reports directory");
                    return;
                }
                return;
            }
            try {
                NativeCrashReporter nativeCrashReporter2 = f63153c;
                nativeCrashReporter2.enable(file.getAbsolutePath(), iArr, ((Boolean) jVar.a(sj.u4)).booleanValue());
                HashSet hashSet = new HashSet();
                hashSet.add(g.c.SHOW);
                hashSet.add(g.c.CLICK);
                hashSet.add(g.c.SHOW_ERROR);
                hashSet.add(g.c.DESTROY);
                jVar.k().a(nativeCrashReporter2, hashSet);
            } catch (Throwable th2) {
                jVar.I();
                if (n.a()) {
                    jVar.I().a("NativeCrashReporter", "Failed to enable native crash reporter", th2);
                }
                jVar.D().a("NativeCrashReporter", "enableInstance", th2);
            }
        }
    }

    private static boolean a() {
        if (!f63151a) {
            f63151a = true;
            try {
                System.loadLibrary("applovin-native-crash-reporter");
                f63152b = true;
            } catch (Throwable th) {
                n.b("NativeCrashReporter", "Failed to load native crash reporter library", th);
            }
        }
        return f63152b;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.io.File r16, com.applovin.impl.sdk.j r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.NativeCrashReporter.a(java.io.File, com.applovin.impl.sdk.j):void");
    }

    @Override // com.applovin.impl.sdk.g.d
    public void a(final g.b bVar) {
        if (bVar.i() == g.c.DESTROY) {
            removeAdInfo(bVar.h());
        } else {
            yp.a(new Runnable() { // from class: com.applovin.impl.sdk.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63644a.b(bVar);
                }
            });
        }
    }
}
