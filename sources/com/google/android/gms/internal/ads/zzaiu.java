package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaiu {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
    
        r7 = -9223372036854775807L;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzait zza(java.lang.String r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiu.zza(java.lang.String):com.google.android.gms.internal.ads.zzait");
    }

    public static boolean zzb(String str) {
        if (str == null) {
            return false;
        }
        String[] strArr = zza;
        for (int i3 = 0; i3 < 4; i3++) {
            if (str.contains(String.valueOf(strArr[i3]).concat("=\"1\""))) {
                return true;
            }
        }
        return false;
    }

    private static zzgwm zzc(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i3 = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzft.zzb(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZzc = zzft.zzc(xmlPullParser, strConcat2);
                String strZzc2 = zzft.zzc(xmlPullParser, strConcat3);
                String strZzc3 = zzft.zzc(xmlPullParser, strConcat4);
                String strZzc4 = zzft.zzc(xmlPullParser, strConcat5);
                if (strZzc == null || strZzc2 == null) {
                    return zzgwm.zzi();
                }
                zzgwjVar.zzf(new zzais(strZzc, strZzc2, strZzc3 != null ? Long.parseLong(strZzc3) : 0L, strZzc4 != null ? Long.parseLong(strZzc4) : 0L));
            }
        } while (!zzft.zza(xmlPullParser, str.concat(":Directory")));
        return zzgwjVar.zzi();
    }
}
