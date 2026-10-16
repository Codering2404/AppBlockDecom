package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.applovin.impl.ba;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.u2;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f63411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f63412c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f63415f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f63410a = "FileManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f63413d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f63414e = new HashSet();

    l(j jVar) {
        this.f63411b = jVar;
        this.f63412c = jVar.I();
        this.f63415f = ((Boolean) jVar.a(sj.W0)).booleanValue();
    }

    private boolean f(File file) {
        if (n.a()) {
            this.f63412c.a("FileManager", "Removing file " + file.getName() + " from filesystem...");
        }
        try {
            c(file);
            boolean zDelete = file.delete();
            if (!zDelete) {
                this.f63411b.D().a(ka.U, "removeFile", (Map) CollectionUtils.hashMap("path", file.getAbsolutePath()));
            }
            g(file);
            return zDelete;
        } catch (Throwable th) {
            try {
                if (n.a()) {
                    this.f63412c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", th);
                }
                this.f63411b.D().a("FileManager", "removeFile", th);
                g(file);
                return false;
            } catch (Throwable th2) {
                g(file);
                throw th2;
            }
        }
    }

    private void g(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f63413d) {
            try {
                if (!this.f63414e.remove(absolutePath)) {
                    this.f63411b.D().a(ka.U, "unlockFile", (Map) CollectionUtils.hashMap("path", absolutePath));
                }
                this.f63413d.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f63411b.i0().a((yl) new jn(this.f63411b, false, "removeCachedResourcesForAd", new Runnable() { // from class: com.applovin.impl.sdk.b1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63240a.a(bVar, context);
            }
        }), tm.b.CACHING);
    }

    public void d(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f63411b.i0().a((yl) new jn(this.f63411b, false, "removeCachedVideoResourceForAd", new Runnable() { // from class: com.applovin.impl.sdk.c1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63253a.b(bVar, context);
            }
        }), tm.b.CACHING);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, java.io.Closeable] */
    public String e(File file) throws Throwable {
        Throwable th;
        InputStream fileInputStream;
        IOException e3;
        FileNotFoundException e4;
        if (file == null) {
            return null;
        }
        if (n.a()) {
            this.f63412c.a("FileManager", "Reading resource from filesystem: " + file.getName());
        }
        ?? BooleanValue = ((Boolean) this.f63411b.a(sj.f63809z)).booleanValue();
        boolean z2 = true;
        try {
            try {
                try {
                    try {
                        if (BooleanValue != 0) {
                            try {
                                try {
                                    FileInputStream fileInputStream2 = new FileInputStream(file);
                                    try {
                                        c(file);
                                        String strA = a(fileInputStream2);
                                        z = strA == null;
                                        fileInputStream2.close();
                                        if (z && ((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                            a(file, "removeFileAfterReadFail");
                                        }
                                        g(file);
                                        return strA;
                                    } catch (Throwable th2) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                        }
                                        throw th2;
                                    }
                                } catch (FileNotFoundException e5) {
                                    if (n.a()) {
                                        this.f63412c.d("FileManager", "File not found. " + e5);
                                    }
                                    this.f63412c.a("FileManager", e5);
                                    this.f63411b.D().a("FileManager", "readFileNotFound", e5);
                                    if (0 != 0 && ((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                        a(file, "removeFileAfterReadFail");
                                    }
                                    g(file);
                                    return null;
                                }
                            } catch (IOException e6) {
                                if (n.a()) {
                                    this.f63412c.a("FileManager", "Failed to read file: " + file.getName() + e6);
                                }
                                this.f63412c.a("FileManager", e6);
                                this.f63411b.D().a("FileManager", "readFileIO", e6);
                                if (((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return null;
                            } catch (Throwable th4) {
                                if (n.a()) {
                                    this.f63412c.a("FileManager", "Unknown failure to read file.", th4);
                                }
                                this.f63412c.a("FileManager", th4);
                                this.f63411b.D().a("FileManager", "readFile", th4);
                                if (((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return null;
                            }
                        }
                        try {
                            c(file);
                            fileInputStream = new FileInputStream(file);
                        } catch (FileNotFoundException e7) {
                            e4 = e7;
                            fileInputStream = null;
                        } catch (IOException e8) {
                            e3 = e8;
                            fileInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = null;
                        }
                        try {
                            String strA2 = a(fileInputStream);
                            z = strA2 == null;
                            yp.a(fileInputStream, this.f63411b);
                            if (z && ((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                a(file, "removeFileAfterReadFail");
                            }
                            g(file);
                            return strA2;
                        } catch (FileNotFoundException e9) {
                            e4 = e9;
                            if (n.a()) {
                                this.f63412c.d("FileManager", "File not found. " + e4);
                            }
                            this.f63411b.D().a("FileManager", "readFileNotFound", e4);
                            yp.a(fileInputStream, this.f63411b);
                            g(file);
                            return null;
                        } catch (IOException e10) {
                            e3 = e10;
                            if (n.a()) {
                                this.f63412c.a("FileManager", "Failed to read file: " + file.getName() + e3);
                            }
                            this.f63411b.D().a("FileManager", "readFileIO", e3);
                            yp.a(fileInputStream, this.f63411b);
                            if (((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                a(file, "removeFileAfterReadFail");
                            }
                            g(file);
                            return null;
                        } catch (Throwable th6) {
                            th = th6;
                            if (n.a()) {
                                this.f63412c.a("FileManager", "Unknown failure to read file.", th);
                            }
                            this.f63411b.D().a("FileManager", "readFile", th);
                            yp.a(fileInputStream, this.f63411b);
                            if (((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                                a(file, "removeFileAfterReadFail");
                            }
                            g(file);
                            return null;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        yp.a((Closeable) BooleanValue, this.f63411b);
                        if (z && ((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
                            a(file, "removeFileAfterReadFail");
                        }
                        g(file);
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    z = true;
                    yp.a((Closeable) BooleanValue, this.f63411b);
                    if (z) {
                        a(file, "removeFileAfterReadFail");
                    }
                    g(file);
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                z2 = false;
            }
        } catch (Throwable th10) {
            th = th10;
        }
        if (z2 && ((Boolean) this.f63411b.a(sj.L0)).booleanValue()) {
            a(file, "removeFileAfterReadFail");
        }
        g(file);
        throw th;
    }

    private void c(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f63413d) {
            boolean zAdd = this.f63414e.add(absolutePath);
            while (!zAdd) {
                try {
                    this.f63413d.wait();
                    zAdd = this.f63414e.add(absolutePath);
                } catch (InterruptedException e3) {
                    if (n.a()) {
                        this.f63412c.a("FileManager", "Lock '" + absolutePath + "' interrupted", e3);
                    }
                    throw new RuntimeException(e3);
                }
            }
        }
    }

    private boolean d(File file) {
        if (file == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f63413d) {
            try {
                if (this.f63414e.contains(absolutePath)) {
                    return false;
                }
                c(file);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String a(Context context, String str, String str2, List list, boolean z2, u2 u2Var, int i3) {
        return a(context, str, str2, list, z2, false, u2Var, i3);
    }

    public boolean b(InputStream inputStream, File file, boolean z2) {
        return a(inputStream, file, z2, false);
    }

    public String a(Context context, String str, String str2, List list, boolean z2, boolean z3, u2 u2Var, int i3) {
        if (!StringUtils.isValidString(str)) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Nothing to cache, skipping...");
            }
            this.f63411b.D().a(ka.U, "cacheResource");
            return null;
        }
        String strA = yp.a(Uri.parse(str), str2, this.f63411b);
        File fileA = a(strA, context);
        if (!a(fileA, str, list, z2, u2Var, i3)) {
            return null;
        }
        if (n.a()) {
            this.f63412c.a("FileManager", "Caching succeeded for file " + strA);
        }
        return z3 ? Uri.fromFile(fileA).toString() : strA;
    }

    public void b(Context context) {
        if (this.f63411b.v0()) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Compacting cache...");
            }
            a(a(context), context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.ad.b bVar, Context context) {
        if (bVar.u0() == null) {
            return;
        }
        f(a(bVar.u0().getLastPathSegment(), context));
    }

    private File d(Context context) {
        return new File(context.getFilesDir(), "al");
    }

    private boolean b(File file) {
        boolean zContains;
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f63413d) {
            zContains = this.f63414e.contains(absolutePath);
        }
        return zContains;
    }

    private List c(Context context) {
        File[] fileArrListFiles;
        File fileD = d(context);
        if (fileD.isDirectory() && (fileArrListFiles = fileD.listFiles()) != null) {
            return Arrays.asList(fileArrListFiles);
        }
        return Collections.EMPTY_LIST;
    }

    public boolean a(File file, String str, List list, u2 u2Var, int i3) {
        return a(file, str, list, true, u2Var, i3);
    }

    private boolean a(File file, String str, List list, boolean z2, u2 u2Var) throws Throwable {
        InputStream inputStreamA;
        Boolean bool = (Boolean) this.f63411b.a(sj.X0);
        if (bool.booleanValue()) {
            c(file);
        }
        if (a(file)) {
            if (n.a()) {
                this.f63412c.a("FileManager", "File exists for " + str);
            }
            if (u2Var != null) {
                u2Var.a(file.length());
            }
        }
        if (((Boolean) this.f63411b.a(sj.f63809z)).booleanValue()) {
            try {
                InputStream inputStreamA2 = a(str, list, z2, u2Var);
                try {
                    boolean zA = a(inputStreamA2, file, bool.booleanValue());
                    if (inputStreamA2 != null) {
                        inputStreamA2.close();
                    }
                    if (bool.booleanValue()) {
                        g(file);
                    }
                    return zA;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    this.f63412c.a("FileManager", th);
                    this.f63411b.D().a("FileManager", "loadAndCacheResource", th);
                    if (!bool.booleanValue()) {
                        return false;
                    }
                    g(file);
                    return false;
                } finally {
                    if (bool.booleanValue()) {
                        g(file);
                    }
                }
            }
        }
        try {
            inputStreamA = a(str, list, z2, u2Var);
            try {
                boolean zA2 = a(inputStreamA, file, bool.booleanValue());
                if (bool.booleanValue()) {
                    g(file);
                }
                yp.a(inputStreamA, this.f63411b);
                return zA2;
            } catch (Throwable th2) {
                th = th2;
                if (bool.booleanValue()) {
                    g(file);
                }
                yp.a(inputStreamA, this.f63411b);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamA = null;
        }
    }

    public boolean b(String str, Context context) {
        return a(a(str, false, context));
    }

    public boolean c(String str, Context context) {
        if (this.f63415f) {
            return b(str, context);
        }
        boolean z2 = false;
        File fileA = a(str, false, context);
        if (!d(fileA)) {
            return false;
        }
        if (fileA.exists() && !fileA.isDirectory()) {
            z2 = true;
        }
        g(fileA);
        return z2;
    }

    private boolean a(File file, String str, List list, boolean z2, u2 u2Var, int i3) {
        HashMap map = new HashMap(1);
        map.put("url", str);
        this.f63411b.D().a(ka.f60960m, (Map) map);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i4 = 1;
        while (i4 <= i3) {
            File file2 = file;
            String str2 = str;
            List list2 = list;
            if (a(file2, str2, list2, z2, u2Var)) {
                a(true, str2, i4, jElapsedRealtime);
                return true;
            }
            i4++;
            str = str2;
            file = file2;
            list = list2;
        }
        a(false, str, i3, jElapsedRealtime);
        return false;
    }

    public InputStream a(String str, List list, boolean z2, u2 u2Var) {
        HttpURLConnection httpURLConnection;
        if (z2 && !yp.a(str, list)) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            }
            return null;
        }
        if (((Boolean) this.f63411b.a(sj.W2)).booleanValue() && !str.contains("https://")) {
            if (n.a()) {
                this.f63412c.k("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            }
            str = str.replace("http://", "https://");
        }
        if (n.a()) {
            this.f63412c.a("FileManager", "Loading " + str + "...");
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(((Integer) this.f63411b.a(sj.U2)).intValue());
                httpURLConnection.setReadTimeout(((Integer) this.f63411b.a(sj.V2)).intValue());
                httpURLConnection.setDefaultUseCaches(true);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                u2Var.a(responseCode);
                this.f63411b.D().a("loadResource", str, responseCode);
                if (responseCode >= 200 && responseCode < 300) {
                    if (n.a()) {
                        this.f63412c.a("FileManager", "Opened stream to resource " + str);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (((Boolean) this.f63411b.a(sj.t3)).booleanValue()) {
                        yp.a(httpURLConnection, this.f63411b);
                    }
                    return inputStream;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                try {
                    if (n.a()) {
                        this.f63412c.a("FileManager", "Error loading " + str, th);
                    }
                    this.f63411b.D().a("FileManager", "loadResource", th, CollectionUtils.hashMap("url", str));
                    u2Var.a(th);
                    if (((Boolean) this.f63411b.a(sj.t3)).booleanValue()) {
                        yp.a(httpURLConnection, this.f63411b);
                    }
                    return null;
                } finally {
                    if (((Boolean) this.f63411b.a(sj.t3)).booleanValue()) {
                        yp.a(httpURLConnection, this.f63411b);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    public void e(Context context) {
        try {
            a(".nomedia", context);
            File file = new File(d(context), ".nomedia");
            if (a(file)) {
                return;
            }
            if (n.a()) {
                this.f63412c.a("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
            }
            if (file.createNewFile()) {
                return;
            }
            if (n.a()) {
                this.f63412c.b("FileManager", "Failed to create .nomedia file");
            }
            this.f63411b.D().a(ka.U, "createNoMediaFile");
        } catch (IOException e3) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Failed to create .nomedia file", e3);
            }
        }
    }

    public File a(String str, Context context) {
        return a(str, true, context);
    }

    private File a(String str, boolean z2, Context context) {
        if (!StringUtils.isValidString(str)) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (n.a()) {
            this.f63412c.a("FileManager", "Looking up cached resource: " + str);
        }
        String strReplace = str.contains("icon") ? str.replace("/", "_").replace(".", "_") : str;
        File fileD = d(context);
        File file = new File(fileD, strReplace);
        if (yp.a(sj.N0, this.f63411b)) {
            boolean z3 = file.length() == 0;
            boolean zEquals = str.equals(".nomedia");
            if (file.exists() && z3 && !zEquals) {
                this.f63411b.D().a(ka.U, "removeEmptyCachedResource", (Map) CollectionUtils.hashMap("path", file.getAbsolutePath()));
                f(file);
            }
        }
        if (!z2) {
            return file;
        }
        try {
            fileD.mkdirs();
            return file;
        } catch (Throwable th) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Unable to make cache directory at " + fileD, th);
            }
            this.f63411b.D().a("FileManager", "createCacheDir", th);
            return null;
        }
    }

    public String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        if (((Boolean) this.f63411b.a(sj.f63809z)).booleanValue()) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                } finally {
                }
            } catch (Throwable th) {
                this.f63412c.a("FileManager", th);
                this.f63411b.D().a("FileManager", "readInputStreamAsString", th);
                return null;
            }
            while (true) {
                int i3 = inputStream.read(bArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                if (i3 >= 0) {
                    byteArrayOutputStream.write(bArr, 0, i3);
                } else {
                    String string = byteArrayOutputStream.toString(Utf8Charset.NAME);
                    byteArrayOutputStream.close();
                    return string;
                }
                this.f63412c.a("FileManager", th);
                this.f63411b.D().a("FileManager", "readInputStreamAsString", th);
                return null;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int i4 = inputStream.read(bArr2, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (i4 >= 0) {
                try {
                    byteArrayOutputStream2.write(bArr2, 0, i4);
                } catch (Throwable th2) {
                    yp.a(byteArrayOutputStream2, this.f63411b);
                    this.f63411b.D().a("FileManager", "readInputStreamAsString", th2);
                    return null;
                }
            } else {
                return byteArrayOutputStream2.toString(Utf8Charset.NAME);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a0 A[Catch: all -> 0x0134, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0134, blocks: (B:78:0x0130, B:81:0x0137, B:84:0x0143, B:86:0x0149, B:88:0x014f, B:89:0x016a, B:97:0x018d, B:99:0x0191, B:104:0x01a0), top: B:179:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0204 A[Catch: all -> 0x020a, TRY_LEAVE, TryCatch #2 {all -> 0x020a, blocks: (B:135:0x01fe, B:137:0x0204), top: B:169:0x01fe }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01e9 A[EDGE_INSN: B:195:0x01e9->B:127:0x01e9 BREAK  A[LOOP:1: B:107:0x01ab->B:196:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fd A[Catch: all -> 0x0103, TryCatch #0 {all -> 0x0103, blocks: (B:57:0x00f7, B:59:0x00fd, B:62:0x0106), top: B:165:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0191 A[Catch: all -> 0x0134, TRY_LEAVE, TryCatch #7 {all -> 0x0134, blocks: (B:78:0x0130, B:81:0x0137, B:84:0x0143, B:86:0x0149, B:88:0x014f, B:89:0x016a, B:97:0x018d, B:99:0x0191, B:104:0x01a0), top: B:179:0x0130 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.InputStream r19, java.io.File r20, boolean r21, boolean r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.l.a(java.io.InputStream, java.io.File, boolean, boolean):boolean");
    }

    private void a(boolean z2, String str, int i3, long j3) {
        ka kaVar = z2 ? ka.f60961n : ka.f60962o;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j3;
        HashMap map = new HashMap(3);
        map.put("details", "Download attempts: " + i3);
        map.put("url", str);
        map.put("duration_ms", String.valueOf(jElapsedRealtime));
        this.f63411b.D().a(kaVar, (Map) map);
    }

    public boolean a(InputStream inputStream, File file) {
        return a(inputStream, file, false);
    }

    private boolean a(InputStream inputStream, File file, boolean z2) {
        if (file == null) {
            return false;
        }
        if (n.a()) {
            this.f63412c.a("FileManager", "Caching " + file.getAbsolutePath() + "...");
        }
        if (!a(inputStream, file, false, z2)) {
            if (n.a()) {
                this.f63412c.b("FileManager", "Unable to cache " + file.getAbsolutePath());
            }
            return false;
        }
        if (!n.a()) {
            return true;
        }
        this.f63412c.a("FileManager", "Caching completed for " + file);
        return true;
    }

    public int a(String str, com.applovin.impl.sdk.ad.b bVar) {
        List listZ = bVar.Z();
        if (bVar.U0() || listZ.contains(str)) {
            return bVar.G();
        }
        return 1;
    }

    private long a(Context context) {
        long jA = a();
        boolean z2 = jA != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        List listC = this.f63411b.c(sj.G0);
        long length = 0;
        for (File file : c(context)) {
            if (z2 && !listC.contains(file.getName()) && !b(file) && seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) > jA) {
                if (n.a()) {
                    this.f63412c.a("FileManager", "File " + file.getName() + " has expired, removing...");
                }
                if (f(file)) {
                    this.f63411b.C().c(ba.f58612j);
                }
            }
            length += file.length();
        }
        return length;
    }

    private void a(long j3, Context context) {
        long jIntValue = ((Integer) this.f63411b.a(sj.C0)).intValue();
        if (jIntValue == -1) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Cache has no maximum size set; skipping drop...");
            }
        } else {
            if (a(j3) > jIntValue) {
                if (n.a()) {
                    this.f63412c.a("FileManager", "Cache has exceeded maximum size; dropping...");
                }
                Iterator it = c(context).iterator();
                while (it.hasNext()) {
                    f((File) it.next());
                }
                this.f63411b.C().c(ba.f58613k);
                return;
            }
            if (n.a()) {
                this.f63412c.a("FileManager", "Cache is present but under size limit; not dropping...");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, Context context) {
        ArrayList arrayList = new ArrayList(bVar.i());
        CollectionUtils.addObjectIfExists(bVar.u0(), arrayList);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            f(a(((Uri) obj).getLastPathSegment(), context));
        }
    }

    public void a(File file, String str) {
        if (n.a()) {
            this.f63412c.a("FileManager", "Removing file " + file.getName() + " for source " + str + ".");
        }
        try {
            if (file.delete()) {
                return;
            }
            this.f63411b.D().a(ka.U, str, (Map) CollectionUtils.hashMap("path", file.getAbsolutePath()));
        } catch (Throwable th) {
            if (n.a()) {
                this.f63412c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem after failed operation.", th);
            }
            this.f63411b.D().a("FileManager", str, th);
        }
    }

    private long a() {
        long jLongValue = ((Long) this.f63411b.a(sj.B0)).longValue();
        if (jLongValue >= 0) {
            return jLongValue;
        }
        return -1L;
    }

    private long a(long j3) {
        return j3 / 1048576;
    }

    public boolean a(File file) {
        if (!yp.a(sj.Q0, this.f63411b)) {
            return (file == null || !file.exists() || file.isDirectory()) ? false : true;
        }
        if (file == null) {
            return false;
        }
        yp.a();
        c(file);
        boolean z2 = file.exists() && !file.isDirectory();
        g(file);
        return z2;
    }
}
