package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialResponse;
import androidx.credentials.provider.BeginCreateCredentialRequest;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CreateEntry;
import androidx.credentials.provider.RemoteEntry;
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
public final class BeginCreateCredentialUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f35385a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(BeginCreateCredentialResponse.Builder builder, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Slice sliceD = CreateEntry.f35295i.d((CreateEntry) it.next());
                if (sliceD != null) {
                    builder.addCreateEntry(m.a(sliceD));
                }
            }
        }

        private final void d(BeginCreateCredentialResponse.Builder builder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            l.a();
            builder.setRemoteCreateEntry(k.a(RemoteEntry.f35375b.a(remoteEntry)));
        }

        public final BeginCreateCredentialResponse a(androidx.credentials.provider.BeginCreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BeginCreateCredentialResponse.Builder builderA = b.a();
            c(builderA, response.a());
            d(builderA, response.b());
            BeginCreateCredentialResponse beginCreateCredentialResponseBuild = builderA.build();
            Intrinsics.checkNotNullExpressionValue(beginCreateCredentialResponseBuild, "frameworkBuilder.build()");
            return beginCreateCredentialResponseBuild;
        }

        public final BeginCreateCredentialRequest b(android.service.credentials.BeginCreateCredentialRequest request) {
            CallingAppInfo callingAppInfoA;
            Intrinsics.checkNotNullParameter(request, "request");
            BeginCreateCredentialRequest.Companion companion = BeginCreateCredentialRequest.f35242d;
            String type = request.getType();
            Intrinsics.checkNotNullExpressionValue(type, "request.type");
            Bundle data = request.getData();
            Intrinsics.checkNotNullExpressionValue(data, "request.data");
            android.service.credentials.CallingAppInfo callingAppInfo = request.getCallingAppInfo();
            if (callingAppInfo != null) {
                CallingAppInfo.Companion companion2 = CallingAppInfo.f35289e;
                String packageName = callingAppInfo.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "it.packageName");
                SigningInfo signingInfo = callingAppInfo.getSigningInfo();
                Intrinsics.checkNotNullExpressionValue(signingInfo, "it.signingInfo");
                callingAppInfoA = companion2.a(packageName, signingInfo, callingAppInfo.getOrigin());
            } else {
                callingAppInfoA = null;
            }
            return companion.a(type, data, callingAppInfoA);
        }

        private Companion() {
        }
    }
}
