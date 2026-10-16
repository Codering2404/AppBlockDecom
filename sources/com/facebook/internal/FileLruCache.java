package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    private final Condition condition;
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private final AtomicLong lastClearCacheTime;
    private final Limits limits;
    private final ReentrantLock lock;
    private final String tag;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        public static final BufferFile INSTANCE = new BufferFile();
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.l
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return FileLruCache.BufferFile.filterExcludeBufferFiles$lambda$0(file, str);
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.m
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return FileLruCache.BufferFile.filterExcludeNonBufferFiles$lambda$1(file, str);
            }
        };

        private BufferFile() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean filterExcludeBufferFiles$lambda$0(File file, String filename) {
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            return !StringsKt.U(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean filterExcludeNonBufferFiles$lambda$1(File file, String filename) {
            Intrinsics.checkNotNullExpressionValue(filename, "filename");
            return StringsKt.U(filename, FILE_NAME_PREFIX, false, 2, null);
        }

        public final void deleteAll(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            File[] fileArrListFiles = root.listFiles(excludeNonBufferFiles());
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
        }

        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        public final File newFile(File file) {
            return new File(file, FILE_NAME_PREFIX + FileLruCache.bufferIndex.incrementAndGet());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CloseCallbackOutputStream extends OutputStream {
        private final StreamCloseCallback callback;
        private final OutputStream innerStream;

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.innerStream.flush();
        }

        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        @Override // java.io.OutputStream
        public void write(byte[] buffer, int i3, int i4) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            this.innerStream.write(buffer, i3, i4);
        }

        public CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback callback) {
            Intrinsics.checkNotNullParameter(outputStream, KrzujOtzIk.oKsKavnNhBA);
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.innerStream = outputStream;
            this.callback = callback;
        }

        @Override // java.io.OutputStream
        public void write(byte[] buffer) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            this.innerStream.write(buffer);
        }

        @Override // java.io.OutputStream
        public void write(int i3) throws IOException {
            this.innerStream.write(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return FileLruCache.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setByteCount(int i3) {
            if (i3 < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i3;
        }

        public final void setFileCount(int i3) {
            if (i3 < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ModifiedFile implements Comparable<ModifiedFile> {
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public ModifiedFile(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.modified = file.lastModified();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER)));
        }

        @Override // java.lang.Comparable
        public int compareTo(ModifiedFile another) {
            Intrinsics.checkNotNullParameter(another, "another");
            long j3 = this.modified;
            long j4 = another.modified;
            if (j3 < j4) {
                return -1;
            }
            if (j3 > j4) {
                return 1;
            }
            return this.file.compareTo(another.file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    interface StreamCloseCallback {
        void onClose();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class StreamHeader {
        private static final int HEADER_VERSION = 0;
        public static final StreamHeader INSTANCE = new StreamHeader();

        private StreamHeader() {
        }

        public final JSONObject readHeader(InputStream stream) throws IOException {
            Intrinsics.checkNotNullParameter(stream, "stream");
            if (stream.read() != 0) {
                return null;
            }
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = stream.read();
                if (i6 == -1) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String TAG = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    companion.log(loggingBehavior, TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i4 = (i4 << 8) + (i6 & 255);
            }
            byte[] bArr = new byte[i4];
            while (i3 < i4) {
                int i7 = stream.read(bArr, i3, i4 - i3);
                if (i7 < 1) {
                    Logger.Companion companion2 = Logger.Companion;
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    String TAG2 = FileLruCache.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion2.log(loggingBehavior2, TAG2, "readHeader: stream.read stopped at " + Integer.valueOf(i3) + " when expected " + i4);
                    return null;
                }
                i3 += i7;
            }
            try {
                Object objNextValue = new JSONTokener(new String(bArr, Charsets.f140510b)).nextValue();
                if (objNextValue instanceof JSONObject) {
                    return (JSONObject) objNextValue;
                }
                Logger.Companion companion3 = Logger.Companion;
                LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                String TAG3 = FileLruCache.Companion.getTAG();
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                companion3.log(loggingBehavior3, TAG3, "readHeader: expected JSONObject, got " + objNextValue.getClass().getCanonicalName());
                return null;
            } catch (JSONException e3) {
                throw new IOException(e3.getMessage());
            }
        }

        public final void writeHeader(OutputStream stream, JSONObject header) throws IOException {
            Intrinsics.checkNotNullParameter(stream, "stream");
            Intrinsics.checkNotNullParameter(header, "header");
            String string = header.toString();
            Intrinsics.checkNotNullExpressionValue(string, "header.toString()");
            byte[] bytes = string.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            stream.write(0);
            stream.write((bytes.length >> 16) & 255);
            stream.write((bytes.length >> 8) & 255);
            stream.write(bytes.length & 255);
            stream.write(bytes);
        }
    }

    public FileLruCache(String tag, Limits limits) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.tag = tag;
        this.limits = limits;
        File file = new File(FacebookSdk.getCacheDir(), tag);
        this.directory = file;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.lastClearCacheTime = new AtomicLong(0L);
        if (file.mkdirs() || file.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCache$lambda$1(File[] filesToDelete) {
        Intrinsics.checkNotNullExpressionValue(filesToDelete, "filesToDelete");
        for (File file : filesToDelete) {
            file.delete();
        }
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i3, Object obj) throws IOException {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.get(str, str2);
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i3, Object obj) throws IOException {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileLruCache.postTrim$lambda$3$lambda$2(this.f68166a);
                    }
                });
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postTrim$lambda$3$lambda$2(FileLruCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    private final void trim() {
        PriorityQueue priorityQueue;
        long j3;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            try {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "trim started");
                PriorityQueue priorityQueue2 = new PriorityQueue();
                File[] fileArrListFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long length = 0;
                if (fileArrListFiles != null) {
                    int length2 = fileArrListFiles.length;
                    int i3 = 0;
                    j3 = 0;
                    while (i3 < length2) {
                        File file = fileArrListFiles[i3];
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue2.add(modifiedFile);
                        Logger.Companion companion2 = Logger.Companion;
                        LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                        String TAG3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        companion2.log(loggingBehavior2, TAG3, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                        length += file.length();
                        j3++;
                        i3++;
                        priorityQueue2 = priorityQueue2;
                    }
                    priorityQueue = priorityQueue2;
                } else {
                    priorityQueue = priorityQueue2;
                    j3 = 0;
                }
                while (true) {
                    if (length <= this.limits.getByteCount() && j3 <= this.limits.getFileCount()) {
                        this.lock.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            Unit unit2 = Unit.f139807a;
                            return;
                        } finally {
                        }
                    }
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.Companion companion3 = Logger.Companion;
                    LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                    String TAG4 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                    companion3.log(loggingBehavior3, TAG4, "  trim removing " + file2.getName());
                    length -= file2.length();
                    j3 += -1;
                    file2.delete();
                }
            } catch (Throwable th) {
                this.lock.lock();
                try {
                    this.isTrimInProgress = false;
                    this.condition.signalAll();
                    Unit unit3 = Unit.f139807a;
                    throw th;
                } finally {
                }
            }
        } finally {
        }
    }

    public final void clearCache() {
        final File[] fileArrListFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (fileArrListFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.j
                @Override // java.lang.Runnable
                public final void run() {
                    FileLruCache.clearCache$lambda$1(fileArrListFiles);
                }
            });
        }
    }

    public final InputStream get(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        return get$default(this, key, null, 2, null);
    }

    public final String getLocation() {
        String path = this.directory.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "directory.path");
        return path;
    }

    public final InputStream interceptAndPut(String key, InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(input, "input");
        return new CopyingInputStream(input, openPutStream$default(this, key, null, 2, null));
    }

    public final OutputStream openPutStream(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        return openPutStream$default(this, key, null, 2, null);
    }

    public final long sizeInBytesForTest() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.condition.await();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        Unit unit = Unit.f139807a;
        reentrantLock.unlock();
        File[] fileArrListFiles = this.directory.listFiles();
        long length = 0;
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                length += file.length();
            }
        }
        return length;
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + '}';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CopyingInputStream extends InputStream {
        private final InputStream input;
        private final OutputStream output;

        public CopyingInputStream(InputStream input, OutputStream output) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(output, "output");
            this.input = input;
            this.output = output;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.input.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        public final InputStream getInput() {
            return this.input;
        }

        public final OutputStream getOutput() {
            return this.output;
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read(byte[] buffer) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i3 = this.input.read(buffer);
            if (i3 > 0) {
                this.output.write(buffer, 0, i3);
            }
            return i3;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j3) throws IOException {
            int i3;
            byte[] bArr = new byte[1024];
            long j4 = 0;
            while (j4 < j3 && (i3 = read(bArr, 0, (int) Math.min(j3 - j4, 1024))) >= 0) {
                j4 += (long) i3;
            }
            return j4;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i3 = this.input.read();
            if (i3 >= 0) {
                this.output.write(i3);
            }
            return i3;
        }

        @Override // java.io.InputStream
        public int read(byte[] buffer, int i3, int i4) throws IOException {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int i5 = this.input.read(buffer, i3, i4);
            if (i5 > 0) {
                this.output.write(buffer, i3, i5);
            }
            return i5;
        }
    }

    public final InputStream get(String key, String str) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        File file = new File(this.directory, Utility.md5hash(key));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                JSONObject header = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (header == null) {
                    return null;
                }
                if (!Intrinsics.areEqual(header.optString("key"), key)) {
                    return null;
                }
                String strOptString = header.optString("tag", null);
                if (str != null && !Intrinsics.areEqual(str, strOptString)) {
                    return null;
                }
                long time = new Date().getTime();
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, TAG2, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                file.setLastModified(time);
                return bufferedInputStream;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final OutputStream openPutStream(final String key, String str) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        final File fileNewFile = BufferFile.INSTANCE.newFile(this.directory);
        fileNewFile.delete();
        if (!fileNewFile.createNewFile()) {
            throw new IOException("Could not create file at " + fileNewFile.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNewFile);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() { // from class: com.facebook.internal.FileLruCache$openPutStream$renameToTargetCallback$1
                @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                public void onClose() {
                    if (jCurrentTimeMillis < this.lastClearCacheTime.get()) {
                        fileNewFile.delete();
                    } else {
                        this.renameToTargetAndTrim(key, fileNewFile);
                    }
                }
            }), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", key);
                    if (!Utility.isNullOrEmpty(str)) {
                        jSONObject.put("tag", str);
                    }
                    StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e3) {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion.log(loggingBehavior, 5, TAG2, "Error creating JSON header for cache file: " + e3);
                    throw new IOException(e3.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e4) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            companion2.log(loggingBehavior2, 5, TAG3, "Error creating buffer output stream: " + e4);
            throw new IOException(e4.getMessage());
        }
    }
}
