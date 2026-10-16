package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioProfile;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzub {
    private static final zzgwm zza = zzgwm.zzj(12);

    /* JADX WARN: Removed duplicated region for block: B:117:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzgwm zza(android.media.AudioDeviceInfo r10) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzub.zza(android.media.AudioDeviceInfo):com.google.android.gms.internal.ads.zzgwm");
    }

    private static zzgwm zzb(AudioDeviceInfo audioDeviceInfo) {
        List audioProfiles = audioDeviceInfo.getAudioProfiles();
        TreeSet treeSet = new TreeSet(Comparator.comparing(zzua.zza).reversed());
        Iterator it = audioProfiles.iterator();
        while (it.hasNext()) {
            AudioProfile audioProfileA = androidx.media3.exoplayer.audio.a.a(it.next());
            if (audioProfileA.getEncapsulationType() != 1 && zzfl.zzD(audioProfileA.getFormat())) {
                for (int i3 : audioProfileA.getChannelMasks()) {
                    treeSet.add(Integer.valueOf(i3));
                }
            }
        }
        return zzgwm.zzq(treeSet);
    }
}
