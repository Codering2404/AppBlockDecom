package com.facebook.internal.instrument.errorreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ErrorReportHandler {
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    @JvmStatic
    public static final void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    @JvmStatic
    public static final File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] fileArrListFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: r.a
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return ErrorReportHandler.listErrorReportFiles$lambda$3(file, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "reportDir.listFiles { di…OR_REPORT_PREFIX)))\n    }");
        return fileArrListFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean listErrorReportFiles$lambda$3(File file, String name) {
        Intrinsics.checkNotNullExpressionValue(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ERROR_REPORT_PREFIX}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return new Regex(str).k(name);
    }

    @JvmStatic
    public static final void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void sendErrorReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] fileArrListErrorReportFiles = listErrorReportFiles();
        final ArrayList arrayList = new ArrayList();
        for (File file : fileArrListErrorReportFiles) {
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.isValid()) {
                arrayList.add(errorReportData);
            }
        }
        CollectionsKt.sortWith(arrayList, new Comparator() { // from class: r.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ErrorReportHandler.sendErrorReports$lambda$0((ErrorReportData) obj, (ErrorReportData) obj2);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size() && i3 < 1000; i3++) {
            jSONArray.put(arrayList.get(i3));
        }
        InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest.Callback() { // from class: r.c
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                ErrorReportHandler.sendErrorReports$lambda$2(arrayList, graphResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sendErrorReports$lambda$0(ErrorReportData errorReportData, ErrorReportData o22) {
        Intrinsics.checkNotNullExpressionValue(o22, "o2");
        return errorReportData.compareTo(o22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendErrorReports$lambda$2(ArrayList validReports, GraphResponse response) {
        JSONObject jsonObject;
        Intrinsics.checkNotNullParameter(validReports, "$validReports");
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            if (response.getError() == null && (jsonObject = response.getJsonObject()) != null && jsonObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                int size = validReports.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = validReports.get(i3);
                    i3++;
                    ((ErrorReportData) obj).clear();
                }
            }
        } catch (JSONException unused) {
        }
    }
}
