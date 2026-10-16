package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AtomicFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f34323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f34324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f34325c;

    public AtomicFile(File file) {
        this.f34323a = file;
        this.f34324b = new File(file.getPath() + ".new");
        this.f34325c = new File(file.getPath() + ".bak");
    }

    private static void c(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
    }

    private static boolean e(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!e(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            Log.e("AtomicFile", "Failed to close file output stream", e3);
        }
        if (this.f34324b.delete()) {
            return;
        }
        Log.e("AtomicFile", "Failed to delete new file " + this.f34324b);
    }

    public void b(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!e(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            Log.e("AtomicFile", "Failed to close file output stream", e3);
        }
        c(this.f34324b, this.f34323a);
    }

    public FileOutputStream d() throws IOException {
        if (this.f34325c.exists()) {
            c(this.f34325c, this.f34323a);
        }
        try {
            return new FileOutputStream(this.f34324b);
        } catch (FileNotFoundException unused) {
            if (!this.f34324b.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.f34324b);
            }
            try {
                return new FileOutputStream(this.f34324b);
            } catch (FileNotFoundException e3) {
                throw new IOException("Failed to create new file " + this.f34324b, e3);
            }
        }
    }
}
