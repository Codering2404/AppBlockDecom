package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SafeParcelable.Class
public final class CredentialOption extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f72815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f72816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f72817d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f72818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f72819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f72813h = new Companion(null);
    public static final Parcelable.Creator<CredentialOption> CREATOR = new CredentialOptionCreator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CredentialOption(String type, Bundle credentialRetrievalData, Bundle candidateQueryData, String requestMatcher, String requestType, String protocolType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(credentialRetrievalData, "credentialRetrievalData");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        Intrinsics.checkNotNullParameter(requestMatcher, "requestMatcher");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(protocolType, "protocolType");
        this.f72814a = type;
        this.f72815b = credentialRetrievalData;
        this.f72816c = candidateQueryData;
        this.f72817d = requestMatcher;
        this.f72818f = requestType;
        this.f72819g = protocolType;
        boolean z2 = (StringsKt.p0(requestType) || StringsKt.p0(protocolType)) ? false : true;
        boolean z3 = !StringsKt.p0(type) && requestType.length() == 0 && protocolType.length() == 0;
        if (z2 || z3) {
            return;
        }
        throw new IllegalArgumentException("Either type: " + type + ", or requestType: " + requestType + " and protocolType: " + protocolType + " must be specified, but at least one contains an invalid blank value.");
    }

    public final Bundle M() {
        return this.f72816c;
    }

    public final Bundle N() {
        return this.f72815b;
    }

    public final String O() {
        return this.f72819g;
    }

    public final String g0() {
        return this.f72817d;
    }

    public final String j0() {
        return this.f72818f;
    }

    public final String w0() {
        return this.f72814a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        CredentialOptionCreator.c(this, dest, i3);
    }
}
