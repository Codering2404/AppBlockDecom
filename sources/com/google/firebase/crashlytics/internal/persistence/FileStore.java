package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FileStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f89014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f89015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f89016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f89017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f89018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f89019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final File f89020g;

    public FileStore(Context context) {
        String str;
        String strD = ProcessDetailsProvider.f88283a.e(context).d();
        this.f89014a = strD;
        File filesDir = context.getFilesDir();
        this.f89015b = filesDir;
        if (x()) {
            str = ".crashlytics.v3" + File.separator + w(strD);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileS = s(new File(filesDir, str));
        this.f89016c = fileS;
        this.f89017d = s(new File(fileS, "open-sessions"));
        this.f89018e = s(new File(fileS, "reports"));
        this.f89019f = s(new File(fileS, "priority-reports"));
        this.f89020g = s(new File(fileS, "native-reports"));
    }

    private void b(String str) {
        File file = new File(this.f89015b, str);
        if (file.exists() && u(file)) {
            Logger.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private void c(final String str) {
        String[] list;
        if (!this.f89015b.exists() || (list = this.f89015b.list(new FilenameFilter() { // from class: w.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return str2.startsWith(str);
            }
        })) == null) {
            return;
        }
        for (String str2 : list) {
            b(str2);
        }
    }

    private File p(String str) {
        return t(new File(this.f89017d, str));
    }

    private static synchronized File s(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                Logger.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                file.delete();
            }
            if (!file.mkdirs()) {
                Logger.f().d("Could not create Crashlytics-specific directory: " + file);
            }
            return file;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static File t(File file) {
        file.mkdirs();
        return file;
    }

    static boolean u(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                u(file2);
            }
        }
        return file.delete();
    }

    private static List v(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    static String w(String str) {
        return str.length() > 40 ? CommonUtils.A(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    private boolean x() {
        return !this.f89014a.isEmpty();
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (x()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return u(new File(this.f89017d, str));
    }

    public List f() {
        return v(this.f89017d.list());
    }

    public File g(String str) {
        return new File(this.f89016c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return v(this.f89016c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f89020g, str);
    }

    public List j() {
        return v(this.f89020g.listFiles());
    }

    public File k(String str) {
        return t(new File(p(str), AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE));
    }

    public File l(String str) {
        return new File(this.f89019f, str);
    }

    public List m() {
        return v(this.f89019f.listFiles());
    }

    public File n(String str) {
        return new File(this.f89018e, str);
    }

    public List o() {
        return v(this.f89018e.listFiles());
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return v(p(str).listFiles(filenameFilter));
    }
}
