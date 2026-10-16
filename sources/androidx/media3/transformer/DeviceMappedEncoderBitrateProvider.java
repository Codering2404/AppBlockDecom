package androidx.media3.transformer;

import android.os.Build;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
class DeviceMappedEncoderBitrateProvider implements EncoderBitrateProvider {
    DeviceMappedEncoderBitrateProvider() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static double b(String str, int i3, String str2, String str3, int i4) {
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        str.getClass();
        switch (str) {
            case "OMX.IMG.TOPAZ.VIDEO.Encoder":
                str2.getClass();
                switch (str2) {
                    case "ANE-LX1":
                    case "ANE-LX2":
                        str3.getClass();
                        switch (str3) {
                            case "1280x720":
                                return 0.245d;
                            case "1920x1080":
                                return i4 != 60 ? 0.2625d : 0.1925d;
                            case "3840x2160":
                                return 0.23208d;
                            default:
                                return 0.28d;
                        }
                    case "FIG-LX1":
                        return 0.245d;
                    default:
                        return 0.28d;
                }
            case "OMX.Exynos.AVC.Encoder":
                switch (i3) {
                    case 24:
                        str2.getClass();
                        if (str2.equals("SM-G920V")) {
                            return 0.245d;
                        }
                        return !str2.equals("SM-G935F") ? 0.37188d : 0.2625d;
                    case 25:
                    default:
                        return 1.4d;
                    case 26:
                        str2.getClass();
                        switch (str2) {
                            case "SM-A520F":
                            case "SM-J600G":
                                return 0.3325d;
                            case "SM-G930F":
                                return 0.20125d;
                            case "SM-G935F":
                                str3.getClass();
                                return !str3.equals("1920x1080") ? 0.315d : 0.1225d;
                            case "SM-G950F":
                                return 0.2975d;
                            case "SM-G955F":
                                str3.getClass();
                                switch (str3.hashCode()) {
                                    case -2077737242:
                                        if (!str3.equals("640x480")) {
                                        }
                                        break;
                                    case 802059049:
                                        if (!str3.equals("1920x1080")) {
                                        }
                                        break;
                                    case 1514345136:
                                        if (!str3.equals("3840x2160")) {
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                /*  JADX ERROR: Method code generation error
                                    java.lang.NullPointerException: Switch insn not found in header
                                    	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    */
                                /*
                                    Method dump skipped, instruction units count: 7870
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.transformer.DeviceMappedEncoderBitrateProvider.b(java.lang.String, int, java.lang.String, java.lang.String, int):double");
                            }

                            public int a(String str, int i3, int i4, float f3) {
                                return (int) (((double) (i3 * i4 * f3)) * b(str, Util.f41609a, Build.MODEL, "" + i3 + "x" + i4, Math.round(f3)));
                            }
                        }
