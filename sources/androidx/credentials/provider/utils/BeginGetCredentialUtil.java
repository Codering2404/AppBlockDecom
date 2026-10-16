package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialResponse;
import androidx.credentials.provider.Action;
import androidx.credentials.provider.AuthenticationAction;
import androidx.credentials.provider.BeginGetCredentialOption;
import androidx.credentials.provider.BeginGetCredentialRequest;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CredentialEntry;
import androidx.credentials.provider.RemoteEntry;
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
public final class BeginGetCredentialUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f35389a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BeginGetCredentialOption c(androidx.credentials.provider.BeginGetCredentialOption beginGetCredentialOption) {
            s.a();
            return g0.a(beginGetCredentialOption.b(), beginGetCredentialOption.c(), beginGetCredentialOption.a());
        }

        private final void e(BeginGetCredentialResponse.Builder builder, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Action action = (Action) it.next();
                f0.a();
                builder.addAction(e0.a(Action.f35225d.b(action)));
            }
        }

        private final void f(BeginGetCredentialResponse.Builder builder, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AuthenticationAction authenticationAction = (AuthenticationAction) it.next();
                f0.a();
                builder.addAuthenticationAction(e0.a(AuthenticationAction.f35230c.b(authenticationAction)));
            }
        }

        private final void g(BeginGetCredentialResponse.Builder builder, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CredentialEntry credentialEntry = (CredentialEntry) it.next();
                Slice sliceB = CredentialEntry.f35307g.b(credentialEntry);
                if (sliceB != null) {
                    r.a();
                    s.a();
                    builder.addCredentialEntry(q.a(g0.a(credentialEntry.b().b(), credentialEntry.e(), Bundle.EMPTY), sliceB));
                }
            }
        }

        private final void h(BeginGetCredentialResponse.Builder builder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            l.a();
            builder.setRemoteCredentialEntry(k.a(RemoteEntry.f35375b.a(remoteEntry)));
        }

        public final BeginGetCredentialResponse b(androidx.credentials.provider.BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BeginGetCredentialResponse.Builder builderA = t.a();
            g(builderA, response.c());
            e(builderA, response.a());
            f(builderA, response.b());
            h(builderA, response.d());
            BeginGetCredentialResponse beginGetCredentialResponseBuild = builderA.build();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialResponseBuild, "frameworkBuilder.build()");
            return beginGetCredentialResponseBuild;
        }

        public final BeginGetCredentialRequest d(android.service.credentials.BeginGetCredentialRequest request) {
            CallingAppInfo callingAppInfoA;
            Intrinsics.checkNotNullParameter(request, "request");
            ArrayList arrayList = new ArrayList();
            List beginGetCredentialOptions = request.getBeginGetCredentialOptions();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialOptions, "request.beginGetCredentialOptions");
            Iterator it = beginGetCredentialOptions.iterator();
            while (it.hasNext()) {
                BeginGetCredentialOption beginGetCredentialOptionA = y.a(it.next());
                BeginGetCredentialOption.Companion companion = androidx.credentials.provider.BeginGetCredentialOption.f35257d;
                String id = beginGetCredentialOptionA.getId();
                Intrinsics.checkNotNullExpressionValue(id, "it.id");
                String type = beginGetCredentialOptionA.getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                Bundle candidateQueryData = beginGetCredentialOptionA.getCandidateQueryData();
                Intrinsics.checkNotNullExpressionValue(candidateQueryData, "it.candidateQueryData");
                arrayList.add(companion.a(id, type, candidateQueryData));
            }
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
            return new BeginGetCredentialRequest(arrayList, callingAppInfoA);
        }

        private Companion() {
        }
    }
}
