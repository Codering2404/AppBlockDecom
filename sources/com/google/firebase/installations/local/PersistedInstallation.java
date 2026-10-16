package com.google.firebase.installations.local;

import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class PersistedInstallation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f89286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseApp f89287b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(FirebaseApp firebaseApp) {
        this.f89287b = firebaseApp;
    }

    private File a() {
        if (this.f89286a == null) {
            synchronized (this) {
                try {
                    if (this.f89286a == null) {
                        this.f89286a = new File(this.f89287b.l().getFilesDir(), "PersistedInstallation." + this.f89287b.q() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.f89286a;
    }

    private JSONObject c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int i3 = fileInputStream.read(bArr, 0, 16384);
                    if (i3 < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    public PersistedInstallationEntry b(PersistedInstallationEntry persistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.d());
            jSONObject.put("Status", persistedInstallationEntry.g().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.b());
            jSONObject.put("RefreshToken", persistedInstallationEntry.f());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.h());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.c());
            jSONObject.put("FisError", persistedInstallationEntry.e());
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f89287b.l().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(Utf8Charset.NAME));
            fileOutputStream.close();
            if (!fileCreateTempFile.renameTo(a())) {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
        return persistedInstallationEntry;
    }

    public PersistedInstallationEntry d() {
        JSONObject jSONObjectC = c();
        String strOptString = jSONObjectC.optString("Fid", null);
        int iOptInt = jSONObjectC.optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String strOptString2 = jSONObjectC.optString("AuthToken", null);
        String strOptString3 = jSONObjectC.optString("RefreshToken", null);
        long jOptLong = jSONObjectC.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObjectC.optLong("ExpiresInSecs", 0L);
        return PersistedInstallationEntry.a().d(strOptString).g(RegistrationStatus.values()[iOptInt]).b(strOptString2).f(strOptString3).h(jOptLong).c(jOptLong2).e(jSONObjectC.optString("FisError", null)).a();
    }
}
