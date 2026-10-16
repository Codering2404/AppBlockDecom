package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzaer {
    public static String zza(zzaes zzaesVar, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance("SHA-256").digest(str.getBytes()));
            int length = str2.length();
            int i3 = 0;
            while (i3 < length) {
                if (zzg.zza(str2.charAt(i3))) {
                    char[] charArray = str2.toCharArray();
                    while (i3 < length) {
                        char c3 = charArray[i3];
                        if (zzg.zza(c3)) {
                            charArray[i3] = (char) (c3 ^ ' ');
                        }
                        i3++;
                    }
                    return String.valueOf(charArray);
                }
                i3++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaes.zza.c("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }

    public static void zzb(zzaes zzaesVar, String str) {
        zzaesVar.zza(str, null);
    }
}
