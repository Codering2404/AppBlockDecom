package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgss {
    public static String zza(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            if (zzd(str.charAt(i3))) {
                char[] charArray = str.toCharArray();
                while (i3 < length) {
                    char c3 = charArray[i3];
                    if (zzd(c3)) {
                        charArray[i3] = (char) (c3 ^ ' ');
                    }
                    i3++;
                }
                return String.valueOf(charArray);
            }
            i3++;
        }
        return str;
    }

    public static String zzb(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            if (zzc(str.charAt(i3))) {
                char[] charArray = str.toCharArray();
                while (i3 < length) {
                    char c3 = charArray[i3];
                    if (zzc(c3)) {
                        charArray[i3] = (char) (c3 ^ ' ');
                    }
                    i3++;
                }
                return String.valueOf(charArray);
            }
            i3++;
        }
        return str;
    }

    public static boolean zzc(char c3) {
        return c3 >= 'a' && c3 <= 'z';
    }

    public static boolean zzd(char c3) {
        return c3 >= 'A' && c3 <= 'Z';
    }

    public static boolean zze(CharSequence charSequence, CharSequence charSequence2) {
        int iZzf;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = charSequence.charAt(i3);
            char cCharAt2 = charSequence2.charAt(i3);
            if (cCharAt != cCharAt2 && ((iZzf = zzf(cCharAt)) >= 26 || iZzf != zzf(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int zzf(char c3) {
        return (char) ((c3 | ' ') - 97);
    }
}
