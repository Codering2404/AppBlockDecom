package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.tm;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class vj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.applovin.impl.sdk.j f64437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SharedPreferences f64438c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f64439a;

    public vj(com.applovin.impl.sdk.j jVar) {
        this.f64439a = com.applovin.impl.sdk.j.m().getSharedPreferences("com.applovin.sdk.preferences." + jVar.a0(), 0);
        f64437b = jVar;
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    public void b(uj ujVar, Object obj) {
        b(ujVar, obj, this.f64439a);
    }

    public static void b(uj ujVar, Object obj, Context context) {
        a(ujVar.a(), obj, a(context), (SharedPreferences.Editor) null);
    }

    public Object a(uj ujVar, Object obj) {
        return a(ujVar, obj, this.f64439a);
    }

    public static Object a(uj ujVar, Object obj, Context context) {
        return a(ujVar.a(), obj, ujVar.b(), a(context));
    }

    public void b(uj ujVar, Object obj, SharedPreferences sharedPreferences) {
        a(ujVar.a(), obj, sharedPreferences);
    }

    public Object a(uj ujVar, Object obj, SharedPreferences sharedPreferences) {
        return a(ujVar.a(), obj, ujVar.b(), sharedPreferences);
    }

    public void b(uj ujVar) {
        a(this.f64439a.edit().remove(ujVar.a()));
    }

    public static Object a(uj ujVar, Object obj, SharedPreferences sharedPreferences, boolean z2) {
        return a(ujVar.a(), obj, ujVar.b(), sharedPreferences, z2);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return a(str, obj, cls, sharedPreferences, true);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences, boolean z2) {
        Object stringSet;
        long jLongValue;
        int iIntValue;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!sharedPreferences.contains(str)) {
                return obj;
            }
            if (Boolean.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                } else {
                    stringSet = Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                }
            } else if (Float.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                } else {
                    stringSet = Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                }
            } else if (Integer.class.equals(cls)) {
                if (obj != null) {
                    if (obj.getClass().equals(Long.class)) {
                        iIntValue = ((Long) obj).intValue();
                    } else {
                        iIntValue = ((Integer) obj).intValue();
                    }
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, iIntValue));
                } else {
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, 0));
                }
            } else if (Long.class.equals(cls)) {
                if (obj != null) {
                    if (obj.getClass().equals(Integer.class)) {
                        jLongValue = ((Integer) obj).longValue();
                    } else {
                        jLongValue = ((Long) obj).longValue();
                    }
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, jLongValue));
                } else {
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, 0L));
                }
            } else if (Double.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()))));
                } else {
                    stringSet = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, 0L)));
                }
            } else if (String.class.equals(cls)) {
                stringSet = sharedPreferences.getString(str, (String) obj);
            } else {
                stringSet = Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) obj) : obj;
            }
            return stringSet != null ? cls.cast(stringSet) : obj;
        } catch (Throwable th) {
            if (z2) {
                try {
                    com.applovin.impl.sdk.n.c("SharedPreferencesManager", "Error getting value for key: " + str, th);
                } finally {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                }
            }
            return obj;
        }
    }

    public Object a(uj ujVar) {
        Object objA = a(ujVar, null);
        b(ujVar);
        return objA;
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        a(str, obj, (SharedPreferences) null, editor);
    }

    public void a(String str, Object obj, SharedPreferences sharedPreferences) {
        a(str, obj, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public static void a(String str, Object obj, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z2 = editor != null;
        if (!z2) {
            editor = sharedPreferences.edit();
        }
        if (obj != null) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                editor.putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
            } else if (obj instanceof String) {
                editor.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else {
                com.applovin.impl.sdk.n.h("SharedPreferencesManager", "Unable to put default value of invalid type: " + obj);
                return;
            }
        } else {
            editor.remove(str);
        }
        if (z2) {
            return;
        }
        a(editor);
    }

    private static void a(final SharedPreferences.Editor editor) {
        try {
            if (yp.h()) {
                com.applovin.impl.sdk.j jVar = f64437b;
                if (jVar != null && jVar.i0() != null) {
                    tm tmVarI0 = f64437b.i0();
                    com.applovin.impl.sdk.j jVar2 = f64437b;
                    Objects.requireNonNull(editor);
                    tmVarI0.a((yl) new jn(jVar2, true, "commitSharedPreferencesChanges", new Runnable() { // from class: com.applovin.impl.z60
                        @Override // java.lang.Runnable
                        public final void run() {
                            editor.commit();
                        }
                    }), tm.b.OTHER);
                    return;
                }
                editor.apply();
                return;
            }
            editor.commit();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("SharedPreferencesManager", "Unable to apply changes", th);
        }
    }

    private static SharedPreferences a(Context context) {
        if (f64438c == null) {
            f64438c = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f64438c;
    }
}
