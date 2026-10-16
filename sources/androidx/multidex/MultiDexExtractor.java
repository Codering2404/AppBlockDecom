package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MultiDexExtractor implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f48733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f48734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f48735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RandomAccessFile f48736d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileChannel f48737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FileLock f48738g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ExtractedDex extends File {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f48740a;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.f48740a = -1L;
        }
    }

    MultiDexExtractor(File file, File file2) throws Throwable {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f48733a = file;
        this.f48735c = file2;
        this.f48734b = j(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f48736d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f48737f = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f48738g = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e3) {
                e = e3;
                b(this.f48737f);
                throw e;
            } catch (Error e4) {
                e = e4;
                b(this.f48737f);
                throw e;
            } catch (RuntimeException e5) {
                e = e5;
                b(this.f48737f);
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
            b(this.f48736d);
            throw e;
        } catch (Error e7) {
            e = e7;
            b(this.f48736d);
            throw e;
        } catch (RuntimeException e8) {
            e = e8;
            b(this.f48736d);
            throw e;
        }
    }

    private void a() {
        File[] fileArrListFiles = this.f48735c.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f48735c.getPath() + ").");
            return;
        }
        for (File file : fileArrListFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e3) {
            Log.w("MultiDex", "Failed to close resource", e3);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i3 = inputStream.read(bArr); i3 != -1; i3 = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i3);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    b(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            b(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    private static SharedPreferences f(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    private static long i(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    private static long j(File file) throws IOException {
        long jC = ZipUtil.c(file);
        return jC == -1 ? jC - 1 : jC;
    }

    private static boolean k(Context context, File file, long j3, String str) {
        SharedPreferences sharedPreferencesF = f(context);
        if (sharedPreferencesF.getLong(str + "timestamp", -1L) != i(file)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("crc");
        return sharedPreferencesF.getLong(sb.toString(), -1L) != j3;
    }

    private List m(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f48733a.getName() + ".classes";
        SharedPreferences sharedPreferencesF = f(context);
        int i3 = sharedPreferencesF.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i3 + (-1));
        int i4 = 2;
        while (i4 <= i3) {
            ExtractedDex extractedDex = new ExtractedDex(this.f48735c, str2 + i4 + ".zip");
            if (!extractedDex.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            extractedDex.f48740a = j(extractedDex);
            long j3 = sharedPreferencesF.getLong(str + "dex.crc." + i4, -1L);
            long j4 = sharedPreferencesF.getLong(str + "dex.time." + i4, -1L);
            long jLastModified = extractedDex.lastModified();
            if (j4 == jLastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = sharedPreferencesF;
                if (j3 == extractedDex.f48740a) {
                    arrayList.add(extractedDex);
                    i4++;
                    sharedPreferencesF = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j4 + ", modification time: " + jLastModified + ", expected crc: " + j3 + ", file crc: " + extractedDex.f48740a);
        }
        return arrayList;
    }

    private List n() {
        boolean z2;
        String str = this.f48733a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f48733a);
        try {
            int i3 = 2;
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.f48735c, str + i3 + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                int i4 = 0;
                boolean z3 = false;
                while (i4 < 3 && !z3) {
                    int i5 = i4 + 1;
                    c(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.f48740a = j(extractedDex);
                        z2 = true;
                    } catch (IOException e3) {
                        Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e3);
                        z2 = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z2 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.f48740a);
                    Log.i("MultiDex", sb.toString());
                    if (!z2) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z3 = z2;
                    i4 = i5;
                }
                if (!z3) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                }
                i3++;
                entry = zipFile.getEntry("classes" + i3 + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            return arrayList;
        } finally {
        }
    }

    private static void r(Context context, String str, long j3, long j4, List list) {
        SharedPreferences.Editor editorEdit = f(context).edit();
        editorEdit.putLong(str + "timestamp", j3);
        editorEdit.putLong(str + "crc", j4);
        editorEdit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i3 = 2;
        while (it.hasNext()) {
            ExtractedDex extractedDex = (ExtractedDex) it.next();
            editorEdit.putLong(str + "dex.crc." + i3, extractedDex.f48740a);
            editorEdit.putLong(str + "dex.time." + i3, extractedDex.lastModified());
            i3++;
        }
        editorEdit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f48738g.release();
        this.f48737f.close();
        this.f48736d.close();
    }

    List l(Context context, String str, boolean z2) {
        List listN;
        List listM;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f48733a.getPath() + ", " + z2 + ", " + str + ")");
        if (!this.f48738g.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z2 && !k(context, this.f48733a, this.f48734b, str)) {
            try {
                listM = m(context, str);
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e3);
                listN = n();
                r(context, str, i(this.f48733a), this.f48734b, listN);
                listM = listN;
            }
            Log.i("MultiDex", "load found " + listM.size() + " secondary dex files");
            return listM;
        }
        if (z2) {
            Log.i("MultiDex", "Forced extraction must be performed.");
        } else {
            Log.i("MultiDex", "Detected that extraction must be performed.");
        }
        listN = n();
        r(context, str, i(this.f48733a), this.f48734b, listN);
        listM = listN;
        Log.i("MultiDex", "load found " + listM.size() + " secondary dex files");
        return listM;
    }
}
