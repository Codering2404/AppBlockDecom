package com.appsflyer;

import android.content.Context;
import com.appsflyer.internal.AFb1bSDK;
import com.appsflyer.internal.AFc1rSDK;
import com.appsflyer.internal.AFc1tSDK;
import com.appsflyer.internal.AFc1uSDK;
import com.appsflyer.internal.AFc1zSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class CreateOneLinkHttpTask implements AFc1uSDK {
    private final AFc1zSDK AFKeystoreWrapper;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask() {
    }

    private File AFInAppEventParameterName() {
        Context context = this.AFKeystoreWrapper.values;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File AFKeystoreWrapper() {
        File fileAFInAppEventParameterName = AFInAppEventParameterName();
        if (fileAFInAppEventParameterName == null) {
            return null;
        }
        File file = new File(fileAFInAppEventParameterName, "6.12.3");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final boolean AFInAppEventType() {
        return values(new String[0]);
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final String valueOf(Throwable th, String str) {
        String str2;
        AFb1bSDK aFb1bSDKValueOf;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        synchronized (this) {
            try {
                File fileAFKeystoreWrapper = AFKeystoreWrapper();
                str2 = null;
                if (fileAFKeystoreWrapper != null) {
                    try {
                        Intrinsics.checkNotNullParameter(th, "");
                        Intrinsics.checkNotNullParameter(str, "");
                        StringBuilder sb = new StringBuilder();
                        Intrinsics.checkNotNullParameter(th, "");
                        String name = th.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "");
                        sb.append(name);
                        sb.append(": ");
                        sb.append(str);
                        String string = sb.toString();
                        Intrinsics.checkNotNullParameter(th, "");
                        Intrinsics.checkNotNullParameter(th, "");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(th);
                        sb2.append('\n');
                        sb2.append(CollectionsKt.joinToString$default(AFc1rSDK.values(th), "\n", null, null, 0, null, AFc1rSDK.AnonymousClass3.AFInAppEventType, 30, null));
                        AFb1bSDK aFb1bSDK = new AFb1bSDK(string, AFc1tSDK.AFa1wSDK.AFInAppEventParameterName(sb2.toString()), ExceptionsKt.b(th), 0, 8, null);
                        String str3 = aFb1bSDK.values;
                        File file = new File(fileAFKeystoreWrapper, str3);
                        if (file.exists() && (aFb1bSDKValueOf = AFb1bSDK.AFa1ySDK.valueOf(FilesKt.g(file, null, 1, null))) != null) {
                            aFb1bSDKValueOf.AFInAppEventType++;
                            aFb1bSDK = aFb1bSDKValueOf;
                        }
                        StringBuilder sb3 = new StringBuilder("label=");
                        sb3.append(AFc1tSDK.AFa1wSDK.AFKeystoreWrapper(aFb1bSDK.AFKeystoreWrapper));
                        sb3.append("\nhashName=");
                        sb3.append(AFc1tSDK.AFa1wSDK.AFKeystoreWrapper(aFb1bSDK.values));
                        sb3.append("\nstackTrace=");
                        sb3.append(AFc1tSDK.AFa1wSDK.AFKeystoreWrapper(aFb1bSDK.valueOf));
                        sb3.append("\nc=");
                        sb3.append(aFb1bSDK.AFInAppEventType);
                        FilesKt.j(file, sb3.toString(), null, 2, null);
                        str2 = str3;
                    } catch (Exception e3) {
                        StringBuilder sb4 = new StringBuilder("Could not cache exception\n");
                        StringBuilder sb5 = new StringBuilder(" ");
                        sb5.append(e3.getMessage());
                        String string2 = sb5.toString();
                        Intrinsics.checkNotNullParameter(string2, "");
                        sb4.append("[Exception Manager]: ".concat(String.valueOf(string2)));
                        AFLogger.afRDLog(sb4.toString());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str2;
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final List<AFb1bSDK> values() {
        List<AFb1bSDK> listEmptyList;
        synchronized (this) {
            try {
                File fileAFKeystoreWrapper = AFKeystoreWrapper();
                listEmptyList = null;
                if (fileAFKeystoreWrapper != null) {
                    try {
                        File[] fileArrListFiles = fileAFKeystoreWrapper.listFiles();
                        if (fileArrListFiles != null) {
                            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                            ArrayList arrayList = new ArrayList();
                            for (File file : fileArrListFiles) {
                                AFb1bSDK.AFa1ySDK aFa1ySDK = AFb1bSDK.AFa1ySDK;
                                Intrinsics.checkNotNullExpressionValue(file, "");
                                AFb1bSDK aFb1bSDKValueOf = AFb1bSDK.AFa1ySDK.valueOf(FilesKt.g(file, null, 1, null));
                                if (aFb1bSDKValueOf != null) {
                                    arrayList.add(aFb1bSDKValueOf);
                                }
                            }
                            listEmptyList = arrayList;
                        }
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder("Could not get stored exceptions\n ");
                        sb.append(th.getMessage());
                        String string = sb.toString();
                        Intrinsics.checkNotNullParameter(string, "");
                        AFLogger.afRDLog("[Exception Manager]: ".concat(String.valueOf(string)));
                    }
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return listEmptyList;
    }

    public CreateOneLinkHttpTask(AFc1zSDK aFc1zSDK) {
        Intrinsics.checkNotNullParameter(aFc1zSDK, "");
        this.AFKeystoreWrapper = aFc1zSDK;
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final boolean values(String... strArr) {
        boolean zP;
        Intrinsics.checkNotNullParameter(strArr, "");
        synchronized (this) {
            try {
                File fileAFInAppEventParameterName = AFInAppEventParameterName();
                zP = true;
                if (fileAFInAppEventParameterName != null) {
                    if (strArr.length == 0) {
                        Intrinsics.checkNotNullParameter("delete all exceptions", "");
                        AFLogger.afRDLog("[Exception Manager]: ".concat("delete all exceptions"));
                        zP = FilesKt.p(fileAFInAppEventParameterName);
                    } else {
                        StringBuilder sb = new StringBuilder("delete all exceptions except for: ");
                        sb.append(ArraysKt.joinToString$default(strArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                        String string = sb.toString();
                        Intrinsics.checkNotNullParameter(string, "");
                        AFLogger.afRDLog("[Exception Manager]: ".concat(String.valueOf(string)));
                        File[] fileArrListFiles = fileAFInAppEventParameterName.listFiles();
                        if (fileArrListFiles != null) {
                            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "");
                            ArrayList arrayList = new ArrayList();
                            for (File file : fileArrListFiles) {
                                if (!ArraysKt.contains(strArr, file.getName())) {
                                    arrayList.add(file);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                            int size = arrayList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                Object obj = arrayList.get(i3);
                                i3++;
                                File file2 = (File) obj;
                                Intrinsics.checkNotNullExpressionValue(file2, "");
                                arrayList2.add(Boolean.valueOf(FilesKt.p(file2)));
                            }
                            Set set = CollectionsKt.toSet(arrayList2);
                            if (set.isEmpty()) {
                                set = SetsKt.setOf(Boolean.TRUE);
                            }
                            Set set2 = set;
                            if (set2.size() != 1 || !((Boolean) CollectionsKt.first(set2)).booleanValue()) {
                                zP = false;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zP;
    }

    @Override // com.appsflyer.internal.AFc1uSDK
    public final int valueOf() {
        Iterator<T> it = values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((AFb1bSDK) it.next()).AFInAppEventType;
        }
        return i3;
    }
}
