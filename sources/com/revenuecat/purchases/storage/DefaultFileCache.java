package com.revenuecat.purchases.storage;

import android.content.Context;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.ChecksumKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DefaultFileCache implements LocalFileCache {
    private static final int BUFFER_SIZE = 262144;
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_SUBDIR = "rc_files";
    private final Lazy cacheDir$delegate;
    private final Context context;
    private final Lazy md$delegate;
    private final String subDir;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DefaultFileCache(Context context, String subDir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subDir, "subDir");
        this.context = context;
        this.subDir = subDir;
        this.md$delegate = LazyKt.b(new Function0<MessageDigest>() { // from class: com.revenuecat.purchases.storage.DefaultFileCache$md$2
            @Override // kotlin.jvm.functions.Function0
            public final MessageDigest invoke() {
                return MessageDigest.getInstance("MD5");
            }
        });
        this.cacheDir$delegate = LazyKt.b(new Function0<File>() { // from class: com.revenuecat.purchases.storage.DefaultFileCache$cacheDir$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file = new File(this.this$0.context.getCacheDir(), this.this$0.subDir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }
        });
    }

    private final File getCacheDir() {
        return (File) this.cacheDir$delegate.getValue();
    }

    private final MessageDigest getMd() {
        Object value = this.md$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-md>(...)");
        return (MessageDigest) value;
    }

    private final boolean isFalse(boolean z2) {
        return !z2;
    }

    private final String md5Hex(byte[] bArr) {
        byte[] bArrDigest = getMd().digest(bArr);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "md.digest(bytes)");
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.revenuecat.purchases.storage.DefaultFileCache.md5Hex.1
            public final CharSequence invoke(byte b3) {
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    private final void streamToFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            ByteStreamsKt.a(inputStream, fileOutputStream, BUFFER_SIZE);
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    private final boolean streamToFileAndCompareChecksum(InputStream inputStream, File file, Checksum checksum) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(checksum.getAlgorithm().getAlgorithmName());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[BUFFER_SIZE];
            while (true) {
                int i3 = inputStream.read(bArr);
                if (i3 == -1) {
                    fileOutputStream.flush();
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(fileOutputStream, null);
                    byte[] hash = messageDigest.digest();
                    Checksum.Algorithm algorithm = checksum.getAlgorithm();
                    Intrinsics.checkNotNullExpressionValue(hash, "hash");
                    return Intrinsics.areEqual(checksum, new Checksum(algorithm, ChecksumKt.toHexString(hash)));
                }
                messageDigest.update(bArr, 0, i3);
                fileOutputStream.write(bArr, 0, i3);
            }
        } finally {
        }
    }

    @Override // com.revenuecat.purchases.storage.LocalFileCache
    public boolean cachedContentExists(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new File(uri).exists();
    }

    @Override // com.revenuecat.purchases.storage.LocalFileCache
    public URI generateLocalFilesystemURI(URL remoteURL, Checksum checksum) {
        String value;
        Intrinsics.checkNotNullParameter(remoteURL, "remoteURL");
        String string = remoteURL.toString();
        Intrinsics.checkNotNullExpressionValue(string, "remoteURL.toString()");
        byte[] bytes = string.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strMd5Hex = md5Hex(bytes);
        StringBuilder sb = new StringBuilder();
        sb.append(new File(strMd5Hex).getName());
        if (checksum == null || (value = checksum.getValue()) == null) {
            value = "";
        }
        sb.append(value);
        String string2 = sb.toString();
        if (string2.length() == 0) {
            return null;
        }
        String path = remoteURL.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "remoteURL.path");
        return new File(getCacheDir(), string2 + '.' + StringsKt.g1(path, '.', "")).toURI();
    }

    @Override // com.revenuecat.purchases.storage.LocalFileCache
    public void saveData(InputStream inputStream, URI uri, Checksum checksum) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(uri, "uri");
        File file = new File(uri);
        File tempFile = File.createTempFile("rc_download_", ".tmp", file.getParentFile());
        try {
            if (checksum != null) {
                Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
                if (isFalse(streamToFileAndCompareChecksum(inputStream, tempFile, checksum))) {
                    tempFile.delete();
                    return;
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
                streamToFile(inputStream, tempFile);
            }
            if (!tempFile.renameTo(file)) {
                try {
                    FilesKt.o(tempFile, file, true, 0, 4, null);
                } catch (Exception e3) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Failed to copy temp file to final file: " + e3.getMessage());
                    }
                    file.delete();
                }
            }
            tempFile.delete();
        } catch (Throwable th) {
            tempFile.delete();
            throw th;
        }
    }

    public /* synthetic */ DefaultFileCache(Context context, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? DEFAULT_SUBDIR : str);
    }
}
