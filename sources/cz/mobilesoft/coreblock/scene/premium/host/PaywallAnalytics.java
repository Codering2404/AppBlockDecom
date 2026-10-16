package cz.mobilesoft.coreblock.scene.premium.host;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PaywallAnalytics {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f113166g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f113167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f113168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f113169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f113170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f113171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f113172f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PaywallAnalytics(String type, String screenType, Long l3, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        this.f113167a = type;
        this.f113168b = screenType;
        this.f113169c = l3;
        this.f113170d = str;
        this.f113171e = z2;
        this.f113172f = z3;
    }

    public final boolean a() {
        return this.f113172f;
    }

    public final Long b() {
        return this.f113169c;
    }

    public final String c() {
        return this.f113170d;
    }

    public final String d() {
        return this.f113168b;
    }

    public final boolean e() {
        return this.f113171e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallAnalytics)) {
            return false;
        }
        PaywallAnalytics paywallAnalytics = (PaywallAnalytics) obj;
        return Intrinsics.areEqual(this.f113167a, paywallAnalytics.f113167a) && Intrinsics.areEqual(this.f113168b, paywallAnalytics.f113168b) && Intrinsics.areEqual(this.f113169c, paywallAnalytics.f113169c) && Intrinsics.areEqual(this.f113170d, paywallAnalytics.f113170d) && this.f113171e == paywallAnalytics.f113171e && this.f113172f == paywallAnalytics.f113172f;
    }

    public final String f() {
        return this.f113167a;
    }

    public int hashCode() {
        int iHashCode = ((this.f113167a.hashCode() * 31) + this.f113168b.hashCode()) * 31;
        Long l3 = this.f113169c;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str = this.f113170d;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.f113171e)) * 31) + Boolean.hashCode(this.f113172f);
    }

    public String toString() {
        return "PaywallAnalytics(type=" + this.f113167a + ", screenType=" + this.f113168b + ", campaignId=" + this.f113169c + ", entrancesDetail=" + this.f113170d + ", suppressedWithoutDetail=" + this.f113171e + ", alwaysTrialMainOption=" + this.f113172f + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PaywallAnalytics(java.lang.String r2, java.lang.String r3, java.lang.Long r4, java.lang.String r5, boolean r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = "paywall"
        L6:
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto Lc
            r4 = r0
        Lc:
            r9 = r8 & 8
            if (r9 == 0) goto L11
            r5 = r0
        L11:
            r9 = r8 & 16
            r0 = 0
            if (r9 == 0) goto L17
            r6 = r0
        L17:
            r8 = r8 & 32
            if (r8 == 0) goto L23
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2a
        L23:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2a:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallAnalytics.<init>(java.lang.String, java.lang.String, java.lang.Long, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
