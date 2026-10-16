package androidx.privacysandbox.ads.adservices.adselection;

import android.util.Log;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@ExperimentalFeatures.Ext8OptIn
public final class ReportEventRequest {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f51164f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f51167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f51168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InputEvent f51169e;

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
    private static final class Ext10Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51170a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.adselection.ReportEventRequest a(ReportEventRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                q0.a();
                android.adservices.adselection.ReportEventRequest reportEventRequestBuild = p0.a(request.b(), request.d(), request.c(), request.f()).setInputEvent(request.e()).build();
                Intrinsics.checkNotNullExpressionValue(reportEventRequestBuild, "Builder(\n               …                 .build()");
                return reportEventRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Ext8Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f51171a = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final android.adservices.adselection.ReportEventRequest a(ReportEventRequest request) {
                Intrinsics.checkNotNullParameter(request, "request");
                if (request.e() != null) {
                    Log.w("ReportEventRequest", "inputEvent is ignored. Min version to use inputEvent is API 31 ext 10");
                }
                q0.a();
                android.adservices.adselection.ReportEventRequest reportEventRequestBuild = p0.a(request.b(), request.d(), request.c(), request.f()).build();
                Intrinsics.checkNotNullExpressionValue(reportEventRequestBuild, "Builder(\n               …                 .build()");
                return reportEventRequestBuild;
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface ReportingDestination {
    }

    public final android.adservices.adselection.ReportEventRequest a() {
        AdServicesInfo adServicesInfo = AdServicesInfo.f51231a;
        return (adServicesInfo.a() >= 10 || adServicesInfo.b() >= 10) ? Ext10Impl.f51170a.a(this) : Ext8Impl.f51171a.a(this);
    }

    public final long b() {
        return this.f51165a;
    }

    public final String c() {
        return this.f51167c;
    }

    public final String d() {
        return this.f51166b;
    }

    public final InputEvent e() {
        return this.f51169e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportEventRequest)) {
            return false;
        }
        ReportEventRequest reportEventRequest = (ReportEventRequest) obj;
        return this.f51165a == reportEventRequest.f51165a && Intrinsics.areEqual(this.f51166b, reportEventRequest.f51166b) && Intrinsics.areEqual(this.f51167c, reportEventRequest.f51167c) && this.f51168d == reportEventRequest.f51168d && Intrinsics.areEqual(this.f51169e, reportEventRequest.f51169e);
    }

    public final int f() {
        return this.f51168d;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f51165a) * 31) + this.f51166b.hashCode()) * 31) + this.f51167c.hashCode()) * 31) + Integer.hashCode(this.f51168d)) * 31;
        InputEvent inputEvent = this.f51169e;
        return iHashCode + (inputEvent != null ? inputEvent.hashCode() : 0);
    }

    public String toString() {
        return "ReportEventRequest: adSelectionId=" + this.f51165a + ", eventKey=" + this.f51166b + ", eventData=" + this.f51167c + ", reportingDestinations=" + this.f51168d + "inputEvent=" + this.f51169e;
    }
}
