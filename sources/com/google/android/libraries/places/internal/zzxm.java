package com.google.android.libraries.places.internal;

import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableSet f78832a = ImmutableSet.D("http", "https", "mailto", "ftp");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ImmutableSet f78833b = ImmutableSet.G("audio/3gpp2", "audio/3gpp", "audio/aac", "audio/midi", "audio/mp3", "audio/mp4", "audio/mpeg", "audio/oga", KrzujOtzIk.CkxMRYNndNzdaKg, "audio/opus", "audio/x-m4a", "audio/x-matroska", "audio/x-wav", "audio/wav", "audio/webm", "image/bmp", "image/gif", "image/jpeg", "image/jpg", "image/png", "image/svg+xml", "image/tiff", "image/webp", "image/x-icon", "video/mpeg", "video/mp4", "video/ogg", "video/webm", "video/x-matroska", "font/ttf");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ImmutableSet f78834c = ImmutableSet.z();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f78835d = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static zzxl a(String str, zzxl zzxlVar) {
        char cCharAt;
        int i3;
        char cCharAt2;
        char cCharAt3;
        ImmutableSet immutableSet = f78834c;
        String strE = Ascii.e(str);
        UnmodifiableIterator it = f78832a.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (strE.startsWith("data:")) {
                    String strE2 = Ascii.e(str);
                    if (strE2.startsWith("data:") && strE2.length() > 5) {
                        int i4 = 5;
                        while (i4 < strE2.length() && (cCharAt3 = strE2.charAt(i4)) != ';' && cCharAt3 != ',') {
                            i4++;
                        }
                        if (f78833b.contains(strE2.substring(5, i4)) && strE2.startsWith(";base64,", i4) && (i3 = i4 + 8) < strE2.length()) {
                            while (i3 < strE2.length() && (cCharAt2 = strE2.charAt(i3)) != '=') {
                                if ((cCharAt2 < 'a' || cCharAt2 > 'z') && !((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '+' || cCharAt2 == '/')) {
                                    break;
                                }
                                i3++;
                            }
                            while (i3 < strE2.length()) {
                                if (strE2.charAt(i3) == '=') {
                                    i3++;
                                }
                            }
                        }
                    }
                    return zzxlVar;
                }
                Iterator<E> it2 = immutableSet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (strE.startsWith(String.valueOf(Ascii.e(((zzxh) it2.next()).name()).replace('_', '-')).concat(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR))) {
                            break;
                        }
                    } else {
                        for (int i5 = 0; i5 < str.length() && (cCharAt = str.charAt(i5)) != '#' && cCharAt != '/'; i5++) {
                            if (cCharAt != ':') {
                                if (cCharAt == '?') {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                if (strE.startsWith(String.valueOf((String) it.next()).concat(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR))) {
                    break;
                }
            }
        }
        return new zzxl(str);
    }
}
