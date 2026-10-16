package com.revenuecat.purchases.common;

import android.content.Context;
import com.revenuecat.purchases.utils.FileExtensionsKt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class FileHelper {
    private final Context applicationContext;

    public FileHelper(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    private final File getFileInFilesDir(String str) {
        return new File(getFilesDir(), str);
    }

    private final File getFilesDir() {
        File filesDir = this.applicationContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "applicationContext.filesDir");
        return filesDir;
    }

    private final void openBufferedReader(String str, Function1<? super BufferedReader, Unit> function1) {
        FileInputStream fileInputStream = new FileInputStream(getFileInFilesDir(str));
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    function1.invoke(bufferedReader);
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(bufferedReader, null);
                    CloseableKt.a(inputStreamReader, null);
                    CloseableKt.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void removeFirstLinesFromFile$default(FileHelper fileHelper, String str, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            function1 = null;
        }
        fileHelper.removeFirstLinesFromFile(str, i3, function1);
    }

    public final void appendToFile(String filePath, String contentToAppend) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(contentToAppend, "contentToAppend");
        File fileInFilesDir = getFileInFilesDir(filePath);
        File parentFile = fileInFilesDir.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileInFilesDir, true);
        try {
            byte[] bytes = contentToAppend.getBytes(Charsets.f140510b);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            Unit unit = Unit.f139807a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public final boolean deleteFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return getFileInFilesDir(filePath).delete();
    }

    public final boolean fileIsEmpty(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File fileInFilesDir = getFileInFilesDir(filePath);
        return !fileInFilesDir.exists() || fileInFilesDir.length() == 0;
    }

    public final double fileSizeInKB(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return FileExtensionsKt.getSizeInKB(getFileInFilesDir(filePath));
    }

    public final void readFilePerLines(String filePath, final Function1<? super Sequence<String>, Unit> block) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(block, "block");
        openBufferedReader(filePath, new Function1<BufferedReader, Unit>() { // from class: com.revenuecat.purchases.common.FileHelper.readFilePerLines.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BufferedReader) obj);
                return Unit.f139807a;
            }

            public final void invoke(BufferedReader bufferedReader) {
                Intrinsics.checkNotNullParameter(bufferedReader, "bufferedReader");
                block.invoke(TextStreamsKt.e(bufferedReader));
            }
        });
    }

    public final void removeFirstLinesFromFile(String filePath, final int i3, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            final StringBuilder sb = new StringBuilder();
            readFilePerLines(filePath, new Function1<Sequence<? extends String>, Unit>() { // from class: com.revenuecat.purchases.common.FileHelper.removeFirstLinesFromFile.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Sequence<String>) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Sequence<String> sequence) {
                    Intrinsics.checkNotNullParameter(sequence, "sequence");
                    Sequence sequenceW = SequencesKt.w(sequence, i3);
                    StringBuilder sb2 = sb;
                    Iterator it = sequenceW.iterator();
                    while (it.hasNext()) {
                        sb2.append((String) it.next());
                        sb2.append("\n");
                    }
                }
            });
            deleteFile(filePath);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "textToAppend.toString()");
            appendToFile(filePath, string);
        } catch (FileNotFoundException e3) {
            if (function1 != null) {
                function1.invoke(e3);
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "FileHelper: file not found when trying to remove first lines from file: " + filePath + ". Ignoring.", e3);
        } catch (Throwable th) {
            if (function1 != null) {
                function1.invoke(th);
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "FileHelper: error removing first lines from file: " + filePath + ". Ignoring.", th);
            throw th;
        }
    }
}
