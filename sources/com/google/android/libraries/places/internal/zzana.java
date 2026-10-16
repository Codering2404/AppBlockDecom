package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzana implements zzbdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zzbdw f75727a = new zzana();

    private zzana() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdw
    public final boolean zza(int i3) {
        zzanb zzanbVar;
        switch (i3) {
            case 0:
                zzanbVar = zzanb.CONTENT_UNDEFINED;
                break;
            case 1:
                zzanbVar = zzanb.PHOTO;
                break;
            case 2:
                zzanbVar = zzanb.ADDRESS;
                break;
            case 3:
                zzanbVar = zzanb.RATING;
                break;
            case 4:
                zzanbVar = zzanb.TYPE;
                break;
            case 5:
                zzanbVar = zzanb.PRICE;
                break;
            case 6:
                zzanbVar = zzanb.ACCESSIBILITY;
                break;
            case 7:
                zzanbVar = zzanb.OPEN_NOW_STATUS;
                break;
            default:
                zzanbVar = null;
                break;
        }
        return zzanbVar != null;
    }
}
