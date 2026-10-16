package com.revenuecat.purchases.paywalls;

import android.content.Context;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfo;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.Result;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
public final class FontLoader {
    private final Lazy cacheDirectory$delegate;
    private final Map<String, DownloadedFontFamily> cachedFontFamilyByFamilyName;
    private final Map<DownloadableFontInfo, String> cachedFontFamilyByFontInfo;
    private final Context context;
    private final Map<String, Set<DownloadableFontInfo>> fontInfosForHash;
    private AtomicBoolean hasCheckedFoldersExist;
    private final CoroutineScope ioScope;
    private final Object lock;
    private final Lazy md$delegate;
    private final File providedCacheDir;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1", f = "FontLoader.kt", l = {}, m = "invokeSuspend")
    static final class C23641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $expectedMd5;
        final /* synthetic */ DownloadableFontInfo $fontInfo;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C23641(String str, String str2, DownloadableFontInfo downloadableFontInfo, Continuation<? super C23641> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$expectedMd5 = str2;
            this.$fontInfo = downloadableFontInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FontLoader.this.new C23641(this.$url, this.$expectedMd5, this.$fontInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2;
            FontLoader fontLoader;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            File cacheDirectory = FontLoader.this.getCacheDirectory();
            if (cacheDirectory == null) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Cannot download font: cache directory is not available", null);
                return Unit.f139807a;
            }
            if (!FontLoader.this.ensureFoldersExist(cacheDirectory)) {
                return Unit.f139807a;
            }
            FontLoader fontLoader2 = FontLoader.this;
            byte[] bytes = this.$url.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String strMd5Hex = fontLoader2.md5Hex(bytes);
            String strG1 = StringsKt.g1(this.$url, '.', "");
            File file = new File(cacheDirectory, strMd5Hex + '.' + strG1);
            Object obj3 = FontLoader.this.lock;
            FontLoader fontLoader3 = FontLoader.this;
            DownloadableFontInfo downloadableFontInfo = this.$fontInfo;
            String str = this.$url;
            synchronized (obj3) {
                Set set = (Set) fontLoader3.fontInfosForHash.get(strMd5Hex);
                if (set != null) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font download already in progress for " + str);
                    }
                    set.add(downloadableFontInfo);
                    return Unit.f139807a;
                }
                fontLoader3.fontInfosForHash.put(strMd5Hex, SetsKt.mutableSetOf(downloadableFontInfo));
                Unit unit = Unit.f139807a;
                if (file.exists()) {
                    FontLoader.this.addFileToCache(strMd5Hex, file);
                    return Unit.f139807a;
                }
                try {
                    Object objM573performDownloadAndCacheyxL6bBk = FontLoader.this.m573performDownloadAndCacheyxL6bBk(this.$url, this.$expectedMd5, strMd5Hex, strG1, cacheDirectory);
                    FontLoader fontLoader4 = FontLoader.this;
                    if (Result.h(objM573performDownloadAndCacheyxL6bBk)) {
                        fontLoader4.addFileToCache(strMd5Hex, (File) objM573performDownloadAndCacheyxL6bBk);
                    }
                    DownloadableFontInfo downloadableFontInfo2 = this.$fontInfo;
                    if (Result.e(objM573performDownloadAndCacheyxL6bBk) != null) {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to download font for " + downloadableFontInfo2.getFamily(), null);
                    }
                    obj2 = FontLoader.this.lock;
                    fontLoader = FontLoader.this;
                } catch (Throwable th) {
                    try {
                        String str2 = this.$url;
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading remote font from " + str2, th);
                        obj2 = FontLoader.this.lock;
                        FontLoader fontLoader5 = FontLoader.this;
                        synchronized (obj2) {
                        }
                    } catch (Throwable th2) {
                        Object obj4 = FontLoader.this.lock;
                        FontLoader fontLoader6 = FontLoader.this;
                        synchronized (obj4) {
                            throw th2;
                        }
                    }
                }
                synchronized (obj2) {
                    return Unit.f139807a;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23641) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public FontLoader(Context context, File file, CoroutineScope ioScope, UrlConnectionFactory urlConnectionFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "urlConnectionFactory");
        this.context = context;
        this.providedCacheDir = file;
        this.ioScope = ioScope;
        this.urlConnectionFactory = urlConnectionFactory;
        this.hasCheckedFoldersExist = new AtomicBoolean(false);
        this.cacheDirectory$delegate = LazyKt.a(LazyThreadSafetyMode.f139761a, new Function0<File>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$cacheDirectory$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file2 = this.this$0.providedCacheDir;
                if (file2 != null) {
                    return file2;
                }
                File cacheDir = this.this$0.context.getCacheDir();
                if (cacheDir != null) {
                    return new File(cacheDir, "rc_paywall_fonts");
                }
                return null;
            }
        });
        this.md$delegate = LazyKt.b(new Function0<MessageDigest>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$md$2
            @Override // kotlin.jvm.functions.Function0
            public final MessageDigest invoke() {
                return MessageDigest.getInstance("MD5");
            }
        });
        this.fontInfosForHash = new LinkedHashMap();
        this.lock = new Object();
        this.cachedFontFamilyByFontInfo = new LinkedHashMap();
        this.cachedFontFamilyByFamilyName = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(String str, File file) {
        synchronized (this.lock) {
            try {
                Set<DownloadableFontInfo> setEmptySet = this.fontInfosForHash.get(str);
                if (setEmptySet == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                for (DownloadableFontInfo downloadableFontInfo : setEmptySet) {
                    String family = downloadableFontInfo.getFamily();
                    if (this.cachedFontFamilyByFontInfo.get(downloadableFontInfo) != null) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font already cached for " + family + ". Skipping download.");
                        }
                    } else {
                        DownloadedFontFamily downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(family);
                        if (downloadedFontFamily != null) {
                            this.cachedFontFamilyByFamilyName.put(family, new DownloadedFontFamily(downloadedFontFamily.getFamily(), CollectionsKt.plus((Collection<? extends DownloadedFont>) downloadedFontFamily.getFonts(), new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file))));
                            this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                        } else {
                            DownloadedFontFamily downloadedFontFamily2 = new DownloadedFontFamily(family, CollectionsKt.listOf(new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file)));
                            this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                            this.cachedFontFamilyByFamilyName.put(family, downloadedFontFamily2);
                        }
                    }
                }
                this.fontInfosForHash.remove(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void downloadToFile(String str, File file) throws Throwable {
        UrlConnection urlConnectionCreateConnection$default;
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Downloading remote font from " + str);
        }
        UrlConnection urlConnection = null;
        try {
            urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(this.urlConnectionFactory, str, null, 2, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (urlConnectionCreateConnection$default.getResponseCode() != 200) {
                throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading paywall font: " + str);
            }
            InputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
            try {
                writeStream(inputStream, file);
                Unit unit = Unit.f139807a;
                CloseableKt.a(inputStream, null);
                urlConnectionCreateConnection$default.disconnect();
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            urlConnection = urlConnectionCreateConnection$default;
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ensureFoldersExist(File file) {
        boolean z2 = true;
        if (this.hasCheckedFoldersExist.get()) {
            return true;
        }
        if (file.exists() || file.mkdirs()) {
            if (!file.isDirectory()) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Remote fonts cache path exists but is not a directory: " + file.getAbsolutePath(), null);
            }
            this.hasCheckedFoldersExist.set(z2);
            return z2;
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unable to create cache directory for remote fonts: " + file.getAbsolutePath(), null);
        z2 = false;
        this.hasCheckedFoldersExist.set(z2);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return (File) this.cacheDirectory$delegate.getValue();
    }

    private final MessageDigest getMd() {
        Object value = this.md$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-md>(...)");
        return (MessageDigest) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String md5Hex(byte[] bArr) {
        byte[] digest = getMd().digest(bArr);
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.revenuecat.purchases.paywalls.FontLoader.md5Hex.1
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performDownloadAndCache-yxL6bBk, reason: not valid java name */
    public final Object m573performDownloadAndCacheyxL6bBk(String str, String str2, String str3, String str4, File file) throws Throwable {
        File file2 = new File(file, str3 + '.' + str4);
        StringBuilder sb = new StringBuilder();
        sb.append('.');
        sb.append(str4);
        File tempFile = File.createTempFile("rc_paywall_font_download_", sb.toString(), file);
        try {
            Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
            downloadToFile(str, tempFile);
            String strMd5Hex = md5Hex(FilesKt.e(tempFile));
            if (StringsKt.F(strMd5Hex, str2, true)) {
                if (!tempFile.renameTo(file2)) {
                    FilesKt.o(tempFile, file2, true, 0, 4, null);
                    tempFile.delete();
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Font downloaded successfully from " + str);
                }
                return Result.b(file2);
            }
            tempFile.delete();
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Downloaded font file is corrupt for " + str + ". expected=" + str2 + ", actual=" + strMd5Hex, null);
            Result.Companion companion = Result.f139772b;
            return Result.b(ResultKt.a(new IOException("Downloaded font file is corrupt for " + str)));
        } catch (IOException e3) {
            if (tempFile.exists()) {
                tempFile.delete();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading font from " + str + ": " + e3.getMessage(), null);
            Result.Companion companion2 = Result.f139772b;
            return Result.b(ResultKt.a(e3));
        }
    }

    private final void startFontDownload(DownloadableFontInfo downloadableFontInfo) {
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C23641(downloadableFontInfo.getUrl(), downloadableFontInfo.getExpectedMd5(), downloadableFontInfo, null), 3, null);
    }

    private final void writeStream(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            while (true) {
                int i3 = inputStream.read(bArr);
                if (i3 < 0) {
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(fileOutputStream, null);
                    return;
                }
                fileOutputStream.write(bArr, 0, i3);
            }
        } finally {
        }
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        DownloadedFontFamily downloadedFontFamily;
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        com.revenuecat.purchases.utils.Result downloadableFontInfo = DownloadableFontInfoKt.toDownloadableFontInfo(fontInfo);
        if (!(downloadableFontInfo instanceof Result.Success)) {
            if (!(downloadableFontInfo instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) ((Result.Error) downloadableFontInfo).getValue(), null);
            return null;
        }
        DownloadableFontInfo downloadableFontInfo2 = (DownloadableFontInfo) ((Result.Success) downloadableFontInfo).getValue();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(this.cachedFontFamilyByFontInfo.get(downloadableFontInfo2));
            objectRef.f140144a = downloadedFontFamily;
            Unit unit = Unit.f139807a;
        }
        if (downloadedFontFamily != null) {
            List fonts = downloadedFontFamily.getFonts();
            if (!(fonts instanceof Collection) || !fonts.isEmpty()) {
                Iterator it = fonts.iterator();
                while (it.hasNext()) {
                    if (!((DownloadedFont) it.next()).getFile().exists()) {
                        LogLevel logLevel = LogLevel.WARN;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.w("[Purchases] - " + logLevel.name(), "Cached font files missing for " + ((DownloadedFontFamily) objectRef.f140144a).getFamily() + ", re-downloading");
                        }
                        synchronized (this.lock) {
                            try {
                                DownloadedFontFamily downloadedFontFamily2 = this.cachedFontFamilyByFamilyName.get(((DownloadedFontFamily) objectRef.f140144a).getFamily());
                                Object obj = objectRef.f140144a;
                                if (downloadedFontFamily2 == obj) {
                                    this.cachedFontFamilyByFamilyName.remove(((DownloadedFontFamily) obj).getFamily());
                                    CollectionsKt.removeAll(this.cachedFontFamilyByFontInfo.entrySet(), new Function1<Map.Entry<DownloadableFontInfo, String>, Boolean>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$getCachedFontFamilyOrStartDownload$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(Map.Entry<DownloadableFontInfo, String> it2) {
                                            Intrinsics.checkNotNullParameter(it2, "it");
                                            return Boolean.valueOf(Intrinsics.areEqual(it2.getValue(), ((DownloadedFontFamily) objectRef.f140144a).getFamily()));
                                        }
                                    });
                                }
                                Unit unit2 = Unit.f139807a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            }
            return (DownloadedFontFamily) objectRef.f140144a;
        }
        startFontDownload(downloadableFontInfo2);
        return null;
    }

    public /* synthetic */ FontLoader(Context context, File file, CoroutineScope coroutineScope, UrlConnectionFactory urlConnectionFactory, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : file, (i3 & 4) != 0 ? CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.b())) : coroutineScope, (i3 & 8) != 0 ? new DefaultUrlConnectionFactory() : urlConnectionFactory);
    }
}
