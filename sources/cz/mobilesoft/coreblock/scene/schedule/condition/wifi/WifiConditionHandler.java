package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface WifiConditionHandler {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Comparable T(WifiConditionHandler wifiConditionHandler, Wifi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!wifiConditionHandler.R().k().contains(it.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Comparable Z(Wifi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.d().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Comparable g0(Wifi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!it.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Comparable k0(Wifi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.valueOf(!it.h());
    }

    default List A(List wifis, List knownWifis) {
        Intrinsics.checkNotNullParameter(wifis, "wifis");
        Intrinsics.checkNotNullParameter(knownWifis, "knownWifis");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : wifis) {
            linkedHashMap.put(((Wifi) obj).c(), obj);
        }
        Iterator it = knownWifis.iterator();
        while (it.hasNext()) {
            Wifi wifi = (Wifi) it.next();
            String strC = wifi.c();
            Wifi wifiB = (Wifi) linkedHashMap.get(strC);
            if (wifiB != null) {
                if (wifi.f()) {
                    wifiB = Wifi.b(wifiB, null, null, true, false, false, false, 59, null);
                }
                if (wifiB != null) {
                    wifi = wifiB;
                }
            }
            linkedHashMap.put(strC, wifi);
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    default boolean G(String ssid) {
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        return ssid.length() > 0 && !Intrinsics.areEqual(ssid, "<unknown ssid>") && StringHelper.w(ssid).length() > 0;
    }

    default void I() {
        Context context = getContext();
        String[] strArrD = PermissionHelper.d();
        List listJ = PermissionHelper.j(context, (String[]) Arrays.copyOf(strArrD, strArrD.length));
        if (listJ.size() <= 0) {
            l();
            return;
        }
        s(WifiConfigurationViewState.d(Y(), null, false, false, null, null, null, null, true, false, false, 895, null));
        if (listJ.contains("android.permission.ACCESS_FINE_LOCATION") || listJ.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            c0();
        } else {
            Intrinsics.checkNotNull(listJ);
            q(listJ);
        }
    }

    WifiManager J();

    WifiConfigurationViewState R();

    WifiConfigurationViewState Y();

    CoroutineScope a();

    void c(int i3);

    void c0();

    Context getContext();

    CoroutineScope getScope();

    default ImmutableList j0(List wifis, String query) {
        Intrinsics.checkNotNullParameter(wifis, "wifis");
        Intrinsics.checkNotNullParameter(query, "query");
        if (!StringsKt.p0(query)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : wifis) {
                if (StringsKt.Y(((Wifi) obj).d(), query, true)) {
                    arrayList.add(obj);
                }
            }
            wifis = arrayList;
        }
        return ExtensionsKt.h(wifis);
    }

    default void k(SharedWifiConditionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SharedWifiConditionEvent.OnWifiCheckedChanged) {
            SharedWifiConditionEvent.OnWifiCheckedChanged onWifiCheckedChanged = (SharedWifiConditionEvent.OnWifiCheckedChanged) event;
            u0(onWifiCheckedChanged.a(), onWifiCheckedChanged.b());
            return;
        }
        if (Intrinsics.areEqual(event, SharedWifiConditionEvent.OnLocationServicesEnabled.f115991a)) {
            BuildersKt__Builders_commonKt.d(a(), null, null, new WifiConditionHandler$handleSharedWifiConditionEvent$1(this, null), 3, null);
            return;
        }
        if (event instanceof SharedWifiConditionEvent.OnQueryChanged) {
            WifiConfigurationViewState wifiConfigurationViewStateY = Y();
            SharedWifiConditionEvent.OnQueryChanged onQueryChanged = (SharedWifiConditionEvent.OnQueryChanged) event;
            s(WifiConfigurationViewState.d(wifiConfigurationViewStateY, null, false, false, onQueryChanged.a(), null, j0(wifiConfigurationViewStateY.e(), onQueryChanged.a()), null, false, false, false, 983, null));
            return;
        }
        if (event instanceof SharedWifiConditionEvent.OnSearchOpenStateChanged) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new WifiConditionHandler$handleSharedWifiConditionEvent$2(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, SharedWifiConditionEvent.CheckPermissionState.f115990a)) {
            if (Y().h()) {
                return;
            }
            s(WifiConfigurationViewState.d(Y(), null, false, false, null, null, null, null, false, true, false, 767, null));
            I();
            return;
        }
        if (Intrinsics.areEqual(event, SharedWifiConditionEvent.OnPermissionsGranted.f115993a)) {
            I();
        } else {
            if (!Intrinsics.areEqual(event, SharedWifiConditionEvent.OnPermissionsDenied.f115992a)) {
                throw new NoWhenBranchMatchedException();
            }
            s(WifiConfigurationViewState.d(Y(), null, false, false, null, null, null, null, false, false, false, 511, null));
        }
    }

    void l();

    default void l0(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.net.wifi.SCAN_RESULTS") && ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            BuildersKt__Builders_commonKt.d(getScope(), null, null, new WifiConditionHandler$onWifiScanReceived$1(this, null), 3, null);
        }
    }

    default void m0() {
        ArrayList arrayList;
        boolean z2;
        Wifi wifi;
        String ssid;
        if (Intrinsics.areEqual(Y().l(), Success.f128020a)) {
            return;
        }
        getContext().registerReceiver(z(), new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        J().startScan();
        s(WifiConfigurationViewState.d(Y(), null, false, true, null, null, null, null, false, false, false, 1019, null));
        WifiInfo connectionInfo = J().getConnectionInfo();
        String str = (connectionInfo == null || (ssid = connectionInfo.getSSID()) == null || !G(ssid)) ? null : ssid;
        List<WifiConfiguration> configuredNetworks = J().getConfiguredNetworks();
        if (configuredNetworks != null) {
            arrayList = new ArrayList();
            Iterator<T> it = configuredNetworks.iterator();
            z2 = false;
            while (it.hasNext()) {
                String str2 = ((WifiConfiguration) it.next()).SSID;
                Intrinsics.checkNotNull(str2);
                if (G(str2)) {
                    boolean zAreEqual = Intrinsics.areEqual(str2, str);
                    if (zAreEqual) {
                        z2 = true;
                    }
                    wifi = new Wifi(str2, StringHelper.w(str2), zAreEqual, false, false, false, 56, null);
                } else {
                    wifi = null;
                }
                if (wifi != null) {
                    arrayList.add(wifi);
                }
            }
        } else {
            arrayList = new ArrayList();
            z2 = false;
        }
        ArrayList arrayList2 = arrayList;
        if (!z2 && str != null) {
            arrayList2.add(0, new Wifi(str, StringHelper.w(str), true, false, false, false, 56, null));
        }
        WifiConfigurationViewState wifiConfigurationViewStateY = Y();
        ImmutableList immutableListW0 = w0(A(wifiConfigurationViewStateY.e(), arrayList2));
        s(WifiConfigurationViewState.d(wifiConfigurationViewStateY, Success.f128020a, false, false, null, null, j0(immutableListW0, wifiConfigurationViewStateY.j()), immutableListW0, false, false, false, 926, null));
    }

    void q(List list);

    void s(WifiConfigurationViewState wifiConfigurationViewState);

    default List s0(List wifis, List scannedWifis) {
        Wifi wifiB;
        Intrinsics.checkNotNullParameter(wifis, "wifis");
        Intrinsics.checkNotNullParameter(scannedWifis, "scannedWifis");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : wifis) {
            linkedHashMap.put(((Wifi) obj).c(), obj);
        }
        Iterator it = scannedWifis.iterator();
        while (it.hasNext()) {
            Wifi wifi = (Wifi) it.next();
            String strC = wifi.c();
            Wifi wifi2 = (Wifi) linkedHashMap.get(strC);
            if (wifi2 != null && (wifiB = Wifi.b(wifi2, null, null, false, true, false, false, 55, null)) != null) {
                wifi = wifiB;
            }
            linkedHashMap.put(strC, wifi);
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    default void u0(Wifi wifi, boolean z2) {
        Intrinsics.checkNotNullParameter(wifi, "wifi");
        BuildersKt__Builders_commonKt.d(getScope(), null, null, new WifiConditionHandler$onWifiCheckedChanged$1(wifi, z2, this, null), 3, null);
    }

    default ImmutableList w0(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return ExtensionsKt.h(CollectionsKt.sortedWith(list, ComparisonsKt.b(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiConditionHandler.T(this.f116148a, (Wifi) obj);
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiConditionHandler.g0((Wifi) obj);
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiConditionHandler.k0((Wifi) obj);
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WifiConditionHandler.Z((Wifi) obj);
            }
        })));
    }

    BroadcastReceiver z();
}
