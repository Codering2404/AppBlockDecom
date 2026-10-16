package cz.mobilesoft.coreblock.util.constants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public enum AdUnitId {
    DASHBOARD_AD("ca-app-pub-2248939034695615/2996213407"),
    DASHBOARD_AD_2(DEBUG_DASHBOARD),
    DASHBOARD_AD_SMALL("ca-app-pub-2248939034695615/5072243919"),
    PROFILE_LIST_BANNER("ca-app-pub-2248939034695615/2160775281"),
    LOCK_SCREEN_BANNER("ca-app-pub-2248939034695615/9414230486"),
    LOCK_SCREEN_INTERSTITIAL("ca-app-pub-2248939034695615/1654558883"),
    PROFILE_INTERSTITIAL("ca-app-pub-2248939034695615/8121824950"),
    APP_INTERSTITIAL("ca-app-pub-2248939034695615/8129471885");

    private static final String DEBUG_BANNER = "ca-app-pub-3940256099942544/6300978111";
    private static final String DEBUG_DASHBOARD = "ca-app-pub-2248939034695615/9292066930";
    private static final String DEBUG_INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712";
    private String id;

    AdUnitId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }
}
