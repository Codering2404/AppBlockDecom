package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzakz implements zzbdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zzbdw f75656a = new zzakz();

    private zzakz() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdw
    public final boolean zza(int i3) {
        zzala zzalaVar;
        switch (i3) {
            case 0:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_UNSPECIFIED;
                break;
            case 1:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_OTHER;
                break;
            case 2:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_J1772;
                break;
            case 3:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_TYPE_2;
                break;
            case 4:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_CHADEMO;
                break;
            case 5:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_CCS_COMBO_1;
                break;
            case 6:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_CCS_COMBO_2;
                break;
            case 7:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_TESLA;
                break;
            case 8:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T;
                break;
            case 9:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET;
                break;
            case 10:
                zzalaVar = zzala.EV_CONNECTOR_TYPE_NACS;
                break;
            default:
                zzalaVar = null;
                break;
        }
        return zzalaVar != null;
    }
}
