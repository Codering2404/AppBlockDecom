package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public final class WebSourceParams {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f51337c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f51338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f51339b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(List request) {
            Intrinsics.checkNotNullParameter(request, "request");
            ArrayList arrayList = new ArrayList();
            Iterator it = request.iterator();
            while (it.hasNext()) {
                WebSourceParams webSourceParams = (WebSourceParams) it.next();
                s.a();
                android.adservices.measurement.WebSourceParams webSourceParamsBuild = r.a(webSourceParams.b()).setDebugKeyAllowed(webSourceParams.a()).build();
                Intrinsics.checkNotNullExpressionValue(webSourceParamsBuild, "Builder(param.registrati…                 .build()");
                arrayList.add(webSourceParamsBuild);
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    public final boolean a() {
        return this.f51339b;
    }

    public final Uri b() {
        return this.f51338a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceParams)) {
            return false;
        }
        WebSourceParams webSourceParams = (WebSourceParams) obj;
        return Intrinsics.areEqual(this.f51338a, webSourceParams.f51338a) && this.f51339b == webSourceParams.f51339b;
    }

    public int hashCode() {
        return (this.f51338a.hashCode() * 31) + Boolean.hashCode(this.f51339b);
    }

    public String toString() {
        return "WebSourceParams { RegistrationUri=" + this.f51338a + ", DebugKeyAllowed=" + this.f51339b + " }";
    }
}
