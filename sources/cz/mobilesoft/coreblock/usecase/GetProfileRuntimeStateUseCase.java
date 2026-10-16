package cz.mobilesoft.coreblock.usecase;

import android.content.Context;
import android.location.LocationManager;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperExtKt;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class GetProfileRuntimeStateUseCase extends SuspendUseCase<Params, Boolean> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127110a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProfileWithConfiguration f127111a;

        public Params(ProfileWithConfiguration profile) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            this.f127111a = profile;
        }

        public final ProfileWithConfiguration a() {
            return this.f127111a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f127111a, ((Params) obj).f127111a);
        }

        public int hashCode() {
            return this.f127111a.hashCode();
        }

        public String toString() {
            return "Params(profile=" + this.f127111a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetProfileRuntimeStateUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127110a = LazyKt.a(lazyThreadSafetyModeB, new Function0<Context>() { // from class: cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Context.class), qualifier, objArr);
            }
        });
    }

    private final Context c() {
        return (Context) this.f127110a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String d(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r5.getSystemService(r0)
            boolean r1 = r0 instanceof android.net.ConnectivityManager
            r2 = 0
            if (r1 == 0) goto Le
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            goto Lf
        Le:
            r0 = r2
        Lf:
            if (r0 != 0) goto L12
            return r2
        L12:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            if (r1 < r3) goto L3a
            android.net.Network r5 = r0.getActiveNetwork()
            if (r5 != 0) goto L1f
            return r2
        L1f:
            android.net.NetworkCapabilities r5 = r0.getNetworkCapabilities(r5)
            if (r5 != 0) goto L26
            return r2
        L26:
            r0 = 1
            boolean r0 = r5.hasTransport(r0)
            if (r0 == 0) goto L38
            android.net.TransportInfo r5 = cz.mobilesoft.coreblock.usecase.b.a(r5)
            boolean r0 = r5 instanceof android.net.wifi.WifiInfo
            if (r0 == 0) goto L38
            android.net.wifi.WifiInfo r5 = (android.net.wifi.WifiInfo) r5
            goto L52
        L38:
            r5 = r2
            goto L52
        L3a:
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r0 = "wifi"
            java.lang.Object r5 = r5.getSystemService(r0)
            boolean r0 = r5 instanceof android.net.wifi.WifiManager
            if (r0 == 0) goto L4b
            android.net.wifi.WifiManager r5 = (android.net.wifi.WifiManager) r5
            goto L4c
        L4b:
            r5 = r2
        L4c:
            if (r5 == 0) goto L38
            android.net.wifi.WifiInfo r5 = r5.getConnectionInfo()
        L52:
            if (r5 == 0) goto L69
            java.lang.String r5 = r5.getSSID()
            if (r5 == 0) goto L69
            boolean r0 = r4.g(r5)
            if (r0 == 0) goto L61
            goto L62
        L61:
            r5 = r2
        L62:
            if (r5 == 0) goto L69
            java.lang.String r5 = cz.mobilesoft.coreblock.util.helperextension.StringHelper.w(r5)
            return r5
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase.d(android.content.Context):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r17, android.content.Context r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase.f(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean g(String str) {
        return (StringsKt.p0(str) || Intrinsics.areEqual(str, "<unknown ssid>") || StringsKt.p0(StringHelper.w(str))) ? false : true;
    }

    private final Boolean h(ProfileWithConfiguration profileWithConfiguration, Context context) {
        if (!profileWithConfiguration.t().isEmpty()) {
            String[] strArrD = PermissionHelper.d();
            List listJ = PermissionHelper.j(context, (String[]) Arrays.copyOf(strArrD, strArrD.length));
            Intrinsics.checkNotNullExpressionValue(listJ, "hasRequestPermission(...)");
            if (listJ.isEmpty()) {
                Object systemService = context.getSystemService("location");
                LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
                if (locationManager == null || !PermissionHelperExtKt.b(locationManager, context)) {
                    return null;
                }
                try {
                    String strD = d(context);
                    if (strD == null) {
                        return null;
                    }
                    List listT = profileWithConfiguration.t();
                    boolean z2 = false;
                    if (!(listT instanceof Collection) || !listT.isEmpty()) {
                        Iterator it = listT.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (Intrinsics.areEqual(StringHelper.w(((WifiNetwork) it.next()).c()), strD)) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    return Boolean.valueOf(z2);
                } catch (Throwable th) {
                    CrashHelper.j(th);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r10, android.content.Context r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase.i(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int j(int i3, int i4, boolean z2) {
        return z2 ? i3 | i4 : i3 & (~i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase.Params r42, kotlin.coroutines.Continuation r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase.e(cz.mobilesoft.coreblock.usecase.GetProfileRuntimeStateUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
