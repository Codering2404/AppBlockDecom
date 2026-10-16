package com.applovin.impl;

import androidx.arch.core.util.Function;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class tl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f63952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f63953b = new Object();

    public tl(JSONObject jSONObject) {
        this.f63952a = jSONObject;
    }

    public Object a(Function function) {
        Object objApply;
        synchronized (this.f63953b) {
            objApply = function.apply(this);
        }
        return objApply;
    }

    public List b(String str, List list) {
        List<String> stringList;
        synchronized (this.f63953b) {
            stringList = JsonUtils.getStringList(this.f63952a, str, list);
        }
        return stringList;
    }

    public void c(String str) {
        synchronized (this.f63953b) {
            this.f63952a.remove(str);
        }
    }

    public String toString() {
        String string;
        synchronized (this.f63953b) {
            string = this.f63952a.toString();
        }
        return string;
    }

    public void a(Consumer consumer) {
        synchronized (this.f63953b) {
            consumer.accept(this);
        }
    }

    public Object b(String str) {
        Object objOpt;
        synchronized (this.f63953b) {
            objOpt = this.f63952a.opt(str);
        }
        return objOpt;
    }

    public void b(String str, int i3) {
        synchronized (this.f63953b) {
            JsonUtils.putInt(this.f63952a, str, i3);
        }
    }

    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f63953b) {
            bool2 = JsonUtils.getBoolean(this.f63952a, str, bool);
        }
        return bool2;
    }

    public double a(String str, double d3) {
        double d4;
        synchronized (this.f63953b) {
            d4 = JsonUtils.getDouble(this.f63952a, str, d3);
        }
        return d4;
    }

    public void b(String str, long j3) {
        synchronized (this.f63953b) {
            JsonUtils.putLong(this.f63952a, str, j3);
        }
    }

    public float a(String str, float f3) {
        float f4;
        synchronized (this.f63953b) {
            f4 = JsonUtils.getFloat(this.f63952a, str, f3);
        }
        return f4;
    }

    public void b(String str, String str2) {
        synchronized (this.f63953b) {
            JsonUtils.putString(this.f63952a, str, str2);
        }
    }

    public int a(String str, int i3) {
        int i4;
        synchronized (this.f63953b) {
            i4 = JsonUtils.getInt(this.f63952a, str, i3);
        }
        return i4;
    }

    public List a(String str, List list) {
        List<Integer> integerList;
        synchronized (this.f63953b) {
            integerList = JsonUtils.getIntegerList(this.f63952a, str, list);
        }
        return integerList;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f63953b) {
            jSONArray2 = JsonUtils.getJSONArray(this.f63952a, str, jSONArray);
        }
        return jSONArray2;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.f63953b) {
            jSONObject2 = JsonUtils.getJSONObject(this.f63952a, str, jSONObject);
        }
        return jSONObject2;
    }

    public long a(String str, long j3) {
        long j4;
        synchronized (this.f63953b) {
            j4 = JsonUtils.getLong(this.f63952a, str, j3);
        }
        return j4;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.f63953b) {
            string = JsonUtils.getString(this.f63952a, str, str2);
        }
        return string;
    }

    public boolean a(String str) {
        boolean zHas;
        synchronized (this.f63953b) {
            zHas = this.f63952a.has(str);
        }
        return zHas;
    }

    public void a(String str, boolean z2) {
        synchronized (this.f63953b) {
            JsonUtils.putBoolean(this.f63952a, str, z2);
        }
    }

    public void a(String str, Object obj) {
        synchronized (this.f63953b) {
            JsonUtils.putObject(this.f63952a, str, obj);
        }
    }

    public JSONObject a() {
        JSONObject jSONObjectDeepCopy;
        synchronized (this.f63953b) {
            jSONObjectDeepCopy = JsonUtils.deepCopy(this.f63952a);
        }
        return jSONObjectDeepCopy;
    }
}
