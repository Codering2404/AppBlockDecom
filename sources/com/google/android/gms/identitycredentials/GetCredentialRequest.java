package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SafeParcelable.Class
public final class GetCredentialRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f72824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResultReceiver f72826d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f72822f = new Companion(null);
    public static final Parcelable.Creator<GetCredentialRequest> CREATOR = new GetCredentialRequestCreator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GetCredentialRequest(List credentialOptions, Bundle data, String str, ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(credentialOptions, "credentialOptions");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.f72823a = credentialOptions;
        this.f72824b = data;
        this.f72825c = str;
        this.f72826d = resultReceiver;
    }

    public final List M() {
        return this.f72823a;
    }

    public final Bundle N() {
        return this.f72824b;
    }

    public final String O() {
        return this.f72825c;
    }

    public final ResultReceiver g0() {
        return this.f72826d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        GetCredentialRequestCreator.c(this, dest, i3);
    }
}
