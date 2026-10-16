package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzamf implements zzbdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zzbdw f75681a = new zzamf();

    private zzamf() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdw
    public final boolean zza(int i3) {
        zzamg zzamgVar;
        switch (i3) {
            case 0:
                zzamgVar = zzamg.CONTENT_UNDEFINED;
                break;
            case 1:
                zzamgVar = zzamg.PHOTO;
                break;
            case 2:
                zzamgVar = zzamg.ADDRESS;
                break;
            case 3:
                zzamgVar = zzamg.RATING;
                break;
            case 4:
                zzamgVar = zzamg.TYPE;
                break;
            case 5:
                zzamgVar = zzamg.PRICE;
                break;
            case 6:
                zzamgVar = zzamg.ACCESSIBILITY;
                break;
            case 7:
                zzamgVar = zzamg.MAPS_LINK;
                break;
            case 8:
                zzamgVar = zzamg.DIRECTIONS_LINK;
                break;
            case 9:
                zzamgVar = zzamg.OPEN_NOW_STATUS;
                break;
            case 10:
                zzamgVar = zzamg.SUMMARY;
                break;
            case 11:
                zzamgVar = zzamg.OPENING_HOURS;
                break;
            case 12:
                zzamgVar = zzamg.WEBSITE;
                break;
            case 13:
                zzamgVar = zzamg.PHONE_NUMBER;
                break;
            case 14:
                zzamgVar = zzamg.TYPE_SPECIFIC_HIGHLIGHTS;
                break;
            case 15:
                zzamgVar = zzamg.REVIEWS;
                break;
            case 16:
                zzamgVar = zzamg.PLUS_CODE;
                break;
            case 17:
                zzamgVar = zzamg.FEATURES;
                break;
            case 18:
                zzamgVar = zzamg.GENERATIVE_SUMMARY;
                break;
            default:
                zzamgVar = null;
                break;
        }
        return zzamgVar != null;
    }
}
