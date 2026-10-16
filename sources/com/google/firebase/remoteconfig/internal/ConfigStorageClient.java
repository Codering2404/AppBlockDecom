package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.facebook.stetho.common.Utf8Charset;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ConfigStorageClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f89793c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89795b;

    private ConfigStorageClient(Context context, String str) {
        this.f89794a = context;
        this.f89795b = str;
    }

    public static synchronized ConfigStorageClient c(Context context, String str) {
        Map map;
        try {
            map = f89793c;
            if (!map.containsKey(str)) {
                map.put(str, new ConfigStorageClient(context, str));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (ConfigStorageClient) map.get(str);
    }

    public synchronized Void a() {
        this.f89794a.deleteFile(this.f89795b);
        return null;
    }

    String b() {
        return this.f89795b;
    }

    public synchronized ConfigContainer d() {
        FileInputStream fileInputStreamOpenFileInput;
        Throwable th;
        try {
            fileInputStreamOpenFileInput = this.f89794a.openFileInput(this.f89795b);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th2) {
            fileInputStreamOpenFileInput = null;
            th = th2;
        }
        try {
            int iAvailable = fileInputStreamOpenFileInput.available();
            byte[] bArr = new byte[iAvailable];
            fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
            ConfigContainer configContainerB = ConfigContainer.b(new JSONObject(new String(bArr, Utf8Charset.NAME)));
            fileInputStreamOpenFileInput.close();
            return configContainerB;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStreamOpenFileInput != null) {
                fileInputStreamOpenFileInput.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStreamOpenFileInput != null) {
                fileInputStreamOpenFileInput.close();
            }
            throw th;
        }
    }

    public synchronized Void e(ConfigContainer configContainer) {
        FileOutputStream fileOutputStreamOpenFileOutput = this.f89794a.openFileOutput(this.f89795b, 0);
        try {
            fileOutputStreamOpenFileOutput.write(configContainer.toString().getBytes(Utf8Charset.NAME));
        } finally {
            fileOutputStreamOpenFileOutput.close();
        }
        return null;
    }
}
