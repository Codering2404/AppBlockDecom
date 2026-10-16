package com.google.firebase.crashlytics.internal.settings;

import com.facebook.AccessToken;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CachedSettingsIo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f89047a;

    public CachedSettingsIo(FileStore fileStore) {
        this.f89047a = fileStore.g("com.crashlytics.settings.json");
    }

    private File a() {
        return this.f89047a;
    }

    public JSONObject b() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        Logger.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File fileA = a();
                if (fileA.exists()) {
                    fileInputStream = new FileInputStream(fileA);
                    try {
                        jSONObject = new JSONObject(CommonUtils.B(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e3) {
                        e = e3;
                        Logger.f().e("Failed to fetch cached settings", e);
                        CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    Logger.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.f(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.f(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.f(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j3, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        Logger.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put(AccessToken.EXPIRES_AT_KEY, j3);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                CommonUtils.f(fileWriter, "Failed to close settings writer.");
            } catch (Exception e4) {
                e = e4;
                fileWriter2 = fileWriter;
                Logger.f().e("Failed to cache settings", e);
                CommonUtils.f(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                CommonUtils.f(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
