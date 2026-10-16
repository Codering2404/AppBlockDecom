package com.google.android.gms.ads.internal.util;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzch {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List f70320b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f70319a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f70321c = new Object();

    private static Integer[] b(Range range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }

    public static List a(String str) {
        ArrayList arrayList;
        Object obj = f70321c;
        synchronized (obj) {
            Map map = f70319a;
            if (map.containsKey(str)) {
                return (List) map.get(str);
            }
            try {
                synchronized (obj) {
                    try {
                        if (f70320b == null) {
                            f70320b = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        }
                        arrayList = new ArrayList();
                        for (MediaCodecInfo mediaCodecInfo : f70320b) {
                            if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                                HashMap map2 = new HashMap();
                                map2.put("codecName", mediaCodecInfo.getName());
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                ArrayList arrayList2 = new ArrayList();
                                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                    arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                                }
                                map2.put("profileLevels", arrayList2);
                                MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                if (videoCapabilities != null) {
                                    map2.put("bitRatesBps", b(videoCapabilities.getBitrateRange()));
                                    map2.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                                    map2.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                                    map2.put("frameRates", b(videoCapabilities.getSupportedFrameRates()));
                                    map2.put("widths", b(videoCapabilities.getSupportedWidths()));
                                    map2.put(MHoiDDglUlPJC.ZpZdnrnp, b(videoCapabilities.getSupportedHeights()));
                                }
                                map2.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                                arrayList.add(map2);
                            }
                        }
                        f70319a.put(str, arrayList);
                    } finally {
                    }
                }
                return arrayList;
            } catch (LinkageError e3) {
                e = e3;
                HashMap map3 = new HashMap();
                map3.put("error", e.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(map3);
                f70319a.put(str, arrayList3);
                return arrayList3;
            } catch (RuntimeException e4) {
                e = e4;
                HashMap map32 = new HashMap();
                map32.put("error", e.getClass().getSimpleName());
                ArrayList arrayList32 = new ArrayList();
                arrayList32.add(map32);
                f70319a.put(str, arrayList32);
                return arrayList32;
            }
        }
    }
}
