package com.google.firebase.crashlytics.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class ProcessDetailsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProcessDetailsProvider f88283a = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    public static /* synthetic */ CrashlyticsReport.Session.Event.Application.ProcessDetails c(ProcessDetailsProvider processDetailsProvider, String str, int i3, int i4, boolean z2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        if ((i5 & 8) != 0) {
            z2 = false;
        }
        return processDetailsProvider.b(str, i3, i4, z2);
    }

    private final String f() {
        if (Build.VERSION.SDK_INT <= 33) {
            String processName = Application.getProcessName();
            return processName == null ? "" : processName;
        }
        String strMyProcessName = Process.myProcessName();
        Intrinsics.checkNotNull(strMyProcessName);
        return strMyProcessName;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails a(String processName, int i3, int i4) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        return c(this, processName, i3, i4, false, 8, null);
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails b(String processName, int i3, int i4, boolean z2) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetailsA = CrashlyticsReport.Session.Event.Application.ProcessDetails.a().e(processName).d(i3).c(i4).b(z2).a();
        Intrinsics.checkNotNullExpressionValue(processDetailsA, "build(...)");
        return processDetailsA;
    }

    public final List d(Context context) {
        List<ActivityManager.RunningAppProcessInfo> listEmptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (listEmptyList = activityManager.getRunningAppProcesses()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(listEmptyList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFilterNotNull) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i3) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj2;
            arrayList2.add(CrashlyticsReport.Session.Event.Application.ProcessDetails.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(Intrinsics.areEqual(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails e(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        int iMyPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((CrashlyticsReport.Session.Event.Application.ProcessDetails) next).c() == iMyPid) {
                break;
            }
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) next;
        return processDetails == null ? c(this, f(), iMyPid, 0, false, 12, null) : processDetails;
    }
}
