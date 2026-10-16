package com.superwall.sdk.analytics;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.content.ContextCompat;
import com.superwall.sdk.analytics.CPUInfo;
import com.superwall.sdk.analytics.DeviceClassifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface ClassifierDataFactory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static long advertisedMemory(ClassifierDataFactory classifierDataFactory) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            getActivityManager(classifierDataFactory).getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 34) {
                return ((memoryInfo.advertisedMem > 0L ? 1 : (memoryInfo.advertisedMem == 0L ? 0 : -1)) != 0 ? ((memoryInfo.advertisedMem - memoryInfo.totalMem) * ((long) 100)) / memoryInfo.advertisedMem : 31L) > 30 ? memoryInfo.totalMem : memoryInfo.advertisedMem;
            }
            return memoryInfo.totalMem;
        }

        public static List<String> codecs(ClassifierDataFactory classifierDataFactory) {
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            Intrinsics.checkNotNullExpressionValue(codecInfos, "getCodecInfos(...)");
            ArrayList arrayList = new ArrayList();
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                Intrinsics.checkNotNullExpressionValue(supportedTypes, "getSupportedTypes(...)");
                CollectionsKt.addAll(arrayList, ArraysKt.toList(supportedTypes));
            }
            return arrayList;
        }

        private static ActivityManager getActivityManager(ClassifierDataFactory classifierDataFactory) {
            Object systemService = ContextCompat.getSystemService(classifierDataFactory.context(), ActivityManager.class);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            return (ActivityManager) systemService;
        }

        public static CPUInfo.Data getCpuInfo(ClassifierDataFactory classifierDataFactory) {
            return new CPUInfo().getCpuData();
        }

        public static DeviceClassifier.Orientation getOrientation(ClassifierDataFactory classifierDataFactory) {
            int i3 = classifierDataFactory.context().getResources().getConfiguration().orientation;
            return i3 != 1 ? i3 != 2 ? DeviceClassifier.Orientation.UNDEFINED : DeviceClassifier.Orientation.LANDSCAPE : DeviceClassifier.Orientation.PORTRAIT;
        }

        public static int getScreenHeight(ClassifierDataFactory classifierDataFactory) {
            if (Build.VERSION.SDK_INT < 30) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ContextCompat.getDisplayOrDefault(classifierDataFactory.context()).getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            WindowMetrics currentWindowMetrics = getWindowManager(classifierDataFactory).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars()), "getInsetsIgnoringVisibility(...)");
            return currentWindowMetrics.getBounds().height();
        }

        public static double getScreenSize(ClassifierDataFactory classifierDataFactory) {
            Point point = new Point();
            ContextCompat.getDisplayOrDefault(classifierDataFactory.context()).getRealSize(point);
            Intrinsics.checkNotNullExpressionValue(classifierDataFactory.context().getResources().getDisplayMetrics(), "getDisplayMetrics(...)");
            int i3 = point.x;
            int i4 = point.y;
            return Math.round(Math.sqrt(Math.pow(((double) i3) / ((double) r7.xdpi), 2.0d) + Math.pow(((double) i4) / ((double) r7.ydpi), 2.0d)) * 10.0d) / 10.0d;
        }

        public static int getScreenWidth(ClassifierDataFactory classifierDataFactory) {
            if (Build.VERSION.SDK_INT < 30) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ContextCompat.getDisplayOrDefault(classifierDataFactory.context()).getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            WindowMetrics currentWindowMetrics = getWindowManager(classifierDataFactory).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars()), "getInsetsIgnoringVisibility(...)");
            return currentWindowMetrics.getBounds().width();
        }

        private static WindowManager getWindowManager(ClassifierDataFactory classifierDataFactory) {
            Object systemService = ContextCompat.getSystemService(classifierDataFactory.context(), WindowManager.class);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService;
        }

        public static boolean isTabletMinWidth(ClassifierDataFactory classifierDataFactory) {
            return classifierDataFactory.context().getResources().getConfiguration().smallestScreenWidthDp >= 600;
        }
    }

    long advertisedMemory();

    List<String> codecs();

    Context context();

    CPUInfo.Data getCpuInfo();

    DeviceClassifier.Orientation getOrientation();

    int getScreenHeight();

    double getScreenSize();

    int getScreenWidth();

    boolean isTabletMinWidth();
}
