package com.google.firebase.crashlytics.internal.metadata;

import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MetaDataStore {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f88522b = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileStore f88523a;

    public MetaDataStore(FileStore fileStore) {
        this.f88523a = fileStore;
    }

    private static Map e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, p(jSONObject, next));
        }
        return map;
    }

    private static List f(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String string = jSONArray.getString(i3);
            try {
                arrayList.add(RolloutAssignment.a(string));
            } catch (Exception e3) {
                Logger.f().l("Failed de-serializing rollouts state. " + string, e3);
            }
        }
        return arrayList;
    }

    private String g(String str) {
        return p(new JSONObject(str), "userId");
    }

    private static String h(Map map) {
        return new JSONObject(map).toString();
    }

    private static String l(List list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                jSONArray.put(new JSONObject(RolloutAssignment.f88550a.b(list.get(i3))));
            } catch (JSONException e3) {
                Logger.f().l("Exception parsing rollout assignment!", e3);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    private static void m(File file) {
        if (file.exists() && file.delete()) {
            Logger.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static void n(File file, String str) {
        if (file.exists() && file.delete()) {
            Logger.f().g(String.format("Deleted corrupt file: %s\nReason: %s", file.getAbsolutePath(), str));
        }
    }

    private static String o(String str) {
        return new JSONObject(str) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f88524a;

            {
                this.f88524a = str;
                put("userId", str);
            }
        }.toString();
    }

    private static String p(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return this.f88523a.q(str, "internal-keys");
    }

    public File b(String str) {
        return this.f88523a.q(str, "keys");
    }

    public File c(String str) {
        return this.f88523a.q(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f88523a.q(str, "user-data");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    Map i(String str, boolean z2) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e3;
        File fileA = z2 ? a(str) : b(str);
        if (!fileA.exists() || fileA.length() == 0) {
            n(fileA, "The file has a length of zero for session: " + str);
            return Collections.EMPTY_MAP;
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileA);
                try {
                    Map mapE = e(CommonUtils.B(fileInputStream));
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return mapE;
                } catch (Exception e4) {
                    e3 = e4;
                    Logger.f().l("Error deserializing user metadata.", e3);
                    m(fileA);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.EMPTY_MAP;
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.f(, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            e3 = e5;
        } catch (Throwable th3) {
            ?? r12 = 0;
            th = th3;
            CommonUtils.f(r12, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List j(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileC = c(str);
        if (!fileC.exists() || fileC.length() == 0) {
            n(fileC, "The file has a length of zero for session: " + str);
            return Collections.EMPTY_LIST;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(fileC);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            List listF = f(CommonUtils.B(fileInputStream));
            Logger.f().b("Loaded rollouts state:\n" + listF + "\nfor session " + str);
            CommonUtils.f(fileInputStream, "Failed to close rollouts state file.");
            return listF;
        } catch (Exception e4) {
            e = e4;
            fileInputStream2 = fileInputStream;
            Logger.f().l("Error deserializing rollouts state.", e);
            m(fileC);
            CommonUtils.f(fileInputStream2, "Failed to close rollouts state file.");
            return Collections.EMPTY_LIST;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            CommonUtils.f(fileInputStream2, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public String k(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileD = d(str);
        FileInputStream fileInputStream2 = null;
        if (!fileD.exists() || fileD.length() == 0) {
            Logger.f().b("No userId set for session " + str);
            m(fileD);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileD);
            try {
                try {
                    String strG = g(CommonUtils.B(fileInputStream));
                    Logger.f().b("Loaded userId " + strG + " for session " + str);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return strG;
                } catch (Exception e3) {
                    e = e3;
                    Logger.f().l("Error deserializing user metadata.", e);
                    m(fileD);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void q(String str, Map map) throws Throwable {
        r(str, map, false);
    }

    public void r(String str, Map map, boolean z2) throws Throwable {
        String strH;
        BufferedWriter bufferedWriter;
        File fileA = z2 ? a(str) : b(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                strH = h(map);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), f88522b));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e3) {
            e = e3;
        }
        try {
            bufferedWriter.write(strH);
            bufferedWriter.flush();
            CommonUtils.f(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e4) {
            e = e4;
            bufferedWriter2 = bufferedWriter;
            Logger.f().l("Error serializing key/value metadata.", e);
            m(fileA);
            CommonUtils.f(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.f(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    public void s(String str, List list) throws Throwable {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e3;
        File fileC = c(str);
        ?? IsEmpty = list.isEmpty();
        if (IsEmpty != 0) {
            n(fileC, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            try {
                String strL = l(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), f88522b));
                try {
                    bufferedWriter.write(strL);
                    bufferedWriter.flush();
                    CommonUtils.f(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Exception e4) {
                    e3 = e4;
                    Logger.f().l("Error serializing rollouts state.", e3);
                    m(fileC);
                    CommonUtils.f(bufferedWriter, "Failed to close rollouts state file.");
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.f(IsEmpty, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e5) {
            bufferedWriter = null;
            e3 = e5;
        } catch (Throwable th3) {
            IsEmpty = 0;
            th = th3;
            CommonUtils.f(IsEmpty, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public void t(String str, String str2) throws Throwable {
        String strO;
        BufferedWriter bufferedWriter;
        File fileD = d(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                strO = o(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileD), f88522b));
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(strO);
            bufferedWriter.flush();
            CommonUtils.f(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e4) {
            e = e4;
            bufferedWriter2 = bufferedWriter;
            Logger.f().l("Error serializing user metadata.", e);
            CommonUtils.f(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.f(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
