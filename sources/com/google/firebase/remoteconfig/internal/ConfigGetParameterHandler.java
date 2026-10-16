package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigGetParameterHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f89740e = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Pattern f89741f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Pattern f89742g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89743a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f89744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConfigCacheClient f89745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConfigCacheClient f89746d;

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.f89744b = executor;
        this.f89745c = configCacheClient;
        this.f89746d = configCacheClient2;
    }

    private void c(final String str, final ConfigContainer configContainer) {
        if (configContainer == null) {
            return;
        }
        synchronized (this.f89743a) {
            try {
                for (final BiConsumer biConsumer : this.f89743a) {
                    this.f89744b.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            biConsumer.accept(str, configContainer);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static ConfigContainer e(ConfigCacheClient configCacheClient) {
        return configCacheClient.f();
    }

    private static TreeSet g(String str, ConfigContainer configContainer) {
        TreeSet treeSet = new TreeSet();
        Iterator<String> itKeys = configContainer.g().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    private static Long i(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configContainerE = e(configCacheClient);
        if (configContainerE == null) {
            return null;
        }
        try {
            return Long.valueOf(configContainerE.g().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String k(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configContainerE = e(configCacheClient);
        if (configContainerE == null) {
            return null;
        }
        try {
            return configContainerE.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void m(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void b(BiConsumer biConsumer) {
        synchronized (this.f89743a) {
            this.f89743a.add(biConsumer);
        }
    }

    public boolean d(String str) {
        String strK = k(this.f89745c, str);
        if (strK != null) {
            if (f89741f.matcher(strK).matches()) {
                c(str, e(this.f89745c));
                return true;
            }
            if (f89742g.matcher(strK).matches()) {
                c(str, e(this.f89745c));
                return false;
            }
        }
        String strK2 = k(this.f89746d, str);
        if (strK2 != null) {
            if (f89741f.matcher(strK2).matches()) {
                return true;
            }
            if (f89742g.matcher(strK2).matches()) {
                return false;
            }
        }
        m(str, "Boolean");
        return false;
    }

    public Set f(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        ConfigContainer configContainerE = e(this.f89745c);
        if (configContainerE != null) {
            treeSet.addAll(g(str, configContainerE));
        }
        ConfigContainer configContainerE2 = e(this.f89746d);
        if (configContainerE2 != null) {
            treeSet.addAll(g(str, configContainerE2));
        }
        return treeSet;
    }

    public long h(String str) {
        Long lI = i(this.f89745c, str);
        if (lI != null) {
            c(str, e(this.f89745c));
            return lI.longValue();
        }
        Long lI2 = i(this.f89746d, str);
        if (lI2 != null) {
            return lI2.longValue();
        }
        m(str, "Long");
        return 0L;
    }

    public String j(String str) {
        String strK = k(this.f89745c, str);
        if (strK != null) {
            c(str, e(this.f89745c));
            return strK;
        }
        String strK2 = k(this.f89746d, str);
        if (strK2 != null) {
            return strK2;
        }
        m(str, "String");
        return "";
    }

    public FirebaseRemoteConfigValue l(String str) {
        String strK = k(this.f89745c, str);
        if (strK != null) {
            c(str, e(this.f89745c));
            return new FirebaseRemoteConfigValueImpl(strK, 2);
        }
        String strK2 = k(this.f89746d, str);
        if (strK2 != null) {
            return new FirebaseRemoteConfigValueImpl(strK2, 1);
        }
        m(str, "FirebaseRemoteConfigValue");
        return new FirebaseRemoteConfigValueImpl("", 0);
    }
}
