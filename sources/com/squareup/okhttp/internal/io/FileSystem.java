package com.squareup.okhttp.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface FileSystem {

    /* JADX INFO: renamed from: com.squareup.okhttp.internal.io.FileSystem$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AnonymousClass1 implements FileSystem {
        @Override // com.squareup.okhttp.internal.io.FileSystem
        public void a(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public boolean b(File file) {
            return file.exists();
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public Sink c(File file) {
            try {
                return Okio.a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.a(file);
            }
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public long d(File file) {
            return file.length();
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public Source e(File file) {
            return Okio.k(file);
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public Sink f(File file) {
            try {
                return Okio.f(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return Okio.f(file);
            }
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public void g(File file, File file2) throws IOException {
            h(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // com.squareup.okhttp.internal.io.FileSystem
        public void h(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }
    }

    void a(File file);

    boolean b(File file);

    Sink c(File file);

    long d(File file);

    Source e(File file);

    Sink f(File file);

    void g(File file, File file2);

    void h(File file);
}
