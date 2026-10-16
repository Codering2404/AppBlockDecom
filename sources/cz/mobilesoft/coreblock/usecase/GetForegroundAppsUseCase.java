package cz.mobilesoft.coreblock.usecase;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.util.Log;
import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
import cz.mobilesoft.coreblock.usecase.UseCase;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class GetForegroundAppsUseCase extends UseCase<Params, AppsDTO> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f127089b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f127090c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127091a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class EventState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f127099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f127100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f127101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f127102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f127103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f127104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f127105g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f127106h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f127107i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f127108j;

        public final String a() {
            return this.f127107i;
        }

        public final long b() {
            return this.f127105g;
        }

        public final long c() {
            return this.f127106h;
        }

        public final String d() {
            return this.f127104f;
        }

        public final String e() {
            return this.f127103e;
        }

        public final String f() {
            return this.f127100b;
        }

        public final boolean g() {
            return this.f127108j;
        }

        public final String h() {
            return this.f127099a;
        }

        public final String i() {
            return this.f127102d;
        }

        public final String j() {
            return this.f127101c;
        }

        public final void k(String str) {
            this.f127107i = str;
        }

        public final void l(long j3) {
            this.f127105g = j3;
        }

        public final void m(long j3) {
            this.f127106h = j3;
        }

        public final void n(String str) {
            this.f127104f = str;
        }

        public final void o(String str) {
            this.f127103e = str;
        }

        public final void p(String str) {
            this.f127100b = str;
        }

        public final void q(boolean z2) {
            this.f127108j = z2;
        }

        public final void r(String str) {
            this.f127099a = str;
        }

        public final void s(String str) {
            this.f127102d = str;
        }

        public final void t(String str) {
            this.f127101c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f127109a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return 1577293894;
        }

        public String toString() {
            return "Params";
        }
    }

    public GetForegroundAppsUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f127091a = context;
    }

    private final void a(UsageEvents.Event event, EventState eventState) {
        String packageName = event.getPackageName();
        String className = event.getClassName();
        long timeStamp = event.getTimeStamp();
        if (eventState.b() == 0 || timeStamp - eventState.b() >= 50) {
            eventState.t(null);
            eventState.s(null);
        } else {
            eventState.t(eventState.h());
            eventState.s(eventState.f());
        }
        if (eventState.h() != null && !Intrinsics.areEqual(eventState.h(), packageName)) {
            eventState.o(eventState.h());
            eventState.n(eventState.f());
        }
        eventState.r(packageName);
        eventState.p(className);
        eventState.l(timeStamp);
        eventState.q(false);
    }

    private final void b(UsageEvents.Event event, EventState eventState) {
        String packageName = event.getPackageName();
        String className = event.getClassName();
        long timeStamp = event.getTimeStamp();
        if (Intrinsics.areEqual(packageName, eventState.h()) && Intrinsics.areEqual(className, eventState.f())) {
            eventState.m(timeStamp);
        }
        if (Intrinsics.areEqual(eventState.e(), packageName) && Intrinsics.areEqual(eventState.d(), className)) {
            eventState.o(null);
            eventState.n(null);
        }
        if (eventState.c() > eventState.b()) {
            if (eventState.e() != null && eventState.d() != null) {
                boolean z2 = Intrinsics.areEqual(eventState.e(), eventState.j()) && Intrinsics.areEqual(eventState.d(), eventState.i());
                eventState.r(eventState.e());
                eventState.p(eventState.d());
                eventState.o(null);
                eventState.n(null);
                eventState.q(!z2);
            }
            eventState.t(null);
            eventState.s(null);
        }
        if (Intrinsics.areEqual(packageName, eventState.j())) {
            eventState.t(null);
            eventState.s(null);
        }
    }

    private final void d(UsageEvents.Event event, EventState eventState) {
        int eventType = event.getEventType();
        if (eventType == 1) {
            f(event, eventState);
            a(event, eventState);
            return;
        }
        if (eventType != 2) {
            if (eventType == 16) {
                e(eventState);
                return;
            } else if (eventType != 23) {
                return;
            }
        }
        b(event, eventState);
    }

    private final void e(EventState eventState) {
        eventState.n(null);
        eventState.o(null);
        eventState.r(null);
        eventState.p(null);
        eventState.t(null);
        eventState.s(null);
    }

    private final void f(UsageEvents.Event event, EventState eventState) {
        String packageName = event.getPackageName();
        if (packageName == null) {
            return;
        }
        String className = event.getClassName();
        if (className == null) {
            className = "";
        }
        if (StringsKt.U(className, "com.android.billingclient.api.ProxyBillingActivity", false, 2, null)) {
            eventState.k(packageName);
        } else {
            if (!Intrinsics.areEqual(packageName, "com.android.vending") || StringsKt.Y(className, "billing.acquire", true)) {
                return;
            }
            eventState.k(null);
        }
    }

    public AppsDTO c(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            Object systemService = this.f127091a.getSystemService("usagestats");
            UsageStatsManager usageStatsManager = systemService instanceof UsageStatsManager ? (UsageStatsManager) systemService : null;
            if (usageStatsManager == null) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            UsageEvents usageEventsQueryEvents = usageStatsManager.queryEvents(jCurrentTimeMillis - 3600000, jCurrentTimeMillis);
            UsageEvents.Event event = new UsageEvents.Event();
            EventState eventState = new EventState();
            while (usageEventsQueryEvents.hasNextEvent()) {
                usageEventsQueryEvents.getNextEvent(event);
                d(event, eventState);
            }
            String strH = eventState.h();
            if (strH == null) {
                return null;
            }
            AppsDTO appsDTO = new AppsDTO(strH, eventState.j(), eventState.g());
            appsDTO.o(eventState.f());
            appsDTO.p(eventState.i());
            appsDTO.n(eventState.a());
            return appsDTO;
        } catch (Exception e3) {
            Log.e("GetForegroundAppsUseCase", "Failed to get foreground apps", e3);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppsDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f127093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f127094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f127095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f127096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f127097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Lazy f127098g;

        public AppsDTO(String primaryPackage, String str, boolean z2) {
            Intrinsics.checkNotNullParameter(primaryPackage, "primaryPackage");
            this.f127092a = primaryPackage;
            this.f127093b = str;
            this.f127094c = z2;
            this.f127098g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.usecase.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GetForegroundAppsUseCase.AppsDTO.d(this.f127518a);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List d(AppsDTO appsDTO) {
            return CollectionsKt.listOfNotNull((Object[]) new String[]{appsDTO.f127092a, appsDTO.f127093b});
        }

        public final boolean b(Set classNames) {
            Intrinsics.checkNotNullParameter(classNames, "classNames");
            Set set = classNames;
            return CollectionsKt.contains(set, this.f127095d) || CollectionsKt.contains(set, this.f127096e);
        }

        public final boolean c(String str) {
            return Intrinsics.areEqual(this.f127092a, str) || Intrinsics.areEqual(this.f127093b, str);
        }

        public final boolean e(String str) {
            if (Intrinsics.areEqual(this.f127092a, str)) {
                return Intrinsics.areEqual(this.f127093b, str) || this.f127093b == null;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AppsDTO)) {
                return false;
            }
            AppsDTO appsDTO = (AppsDTO) obj;
            return Intrinsics.areEqual(this.f127092a, appsDTO.f127092a) && Intrinsics.areEqual(this.f127093b, appsDTO.f127093b) && this.f127094c == appsDTO.f127094c;
        }

        public final List f() {
            return (List) this.f127098g.getValue();
        }

        public final String g() {
            return this.f127097f;
        }

        public final String h() {
            return this.f127095d;
        }

        public int hashCode() {
            int iHashCode = this.f127092a.hashCode() * 31;
            String str = this.f127093b;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f127094c);
        }

        public final String i() {
            return this.f127092a;
        }

        public final String j() {
            return this.f127096e;
        }

        public final String k() {
            return this.f127093b;
        }

        public final boolean l() {
            if (this.f127092a.length() != 0) {
                return false;
            }
            String str = this.f127093b;
            return str == null || str.length() == 0;
        }

        public final boolean m() {
            return this.f127094c;
        }

        public final void n(String str) {
            this.f127097f = str;
        }

        public final void o(String str) {
            this.f127095d = str;
        }

        public final void p(String str) {
            this.f127096e = str;
        }

        public final List q() {
            return f();
        }

        public String toString() {
            return "AppsDTO(primaryPackage='" + this.f127092a + "', secondaryPackage='" + this.f127093b + "', primaryClassName=" + this.f127095d + ", secondaryClassName=" + this.f127096e + ", isPrimaryInferred=" + this.f127094c + ")";
        }

        public /* synthetic */ AppsDTO(String str, String str2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? false : z2);
        }
    }
}
