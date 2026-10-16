package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LottieNetworkCacheProvider f56941a;

    public NetworkCache(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.f56941a = lottieNetworkCacheProvider;
    }

    private static String b(String str, FileExtension fileExtension, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z2 ? fileExtension.b() : fileExtension.f56940a);
        return sb.toString();
    }

    private File c(String str) {
        File file = new File(d(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File fileA = this.f56941a.a();
        if (fileA.isFile()) {
            fileA.delete();
        }
        if (!fileA.exists()) {
            fileA.mkdirs();
        }
        return fileA;
    }

    Pair a(String str) {
        try {
            File fileC = c(str);
            if (fileC == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileC);
            FileExtension fileExtension = fileC.getAbsolutePath().endsWith(".zip") ? FileExtension.ZIP : FileExtension.JSON;
            Logger.a("Cache hit for " + str + " at " + fileC.getAbsolutePath());
            return new Pair(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void e(String str, FileExtension fileExtension) {
        File file = new File(d(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        Logger.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        Logger.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    File f(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(d(), b(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i3);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
