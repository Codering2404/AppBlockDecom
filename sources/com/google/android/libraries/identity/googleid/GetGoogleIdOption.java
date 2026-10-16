package com.google.android.libraries.identity.googleid;

import androidx.credentials.GetCustomCredentialOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class GetGoogleIdOption extends GetCustomCredentialOption {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f74608p = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f74609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f74610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f74611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f74612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f74613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f74614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f74615o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final boolean g() {
        return this.f74615o;
    }

    public final boolean h() {
        return this.f74611k;
    }

    public final List i() {
        return this.f74613m;
    }

    public final String j() {
        return this.f74612l;
    }

    public final String k() {
        return this.f74610j;
    }

    public final boolean l() {
        return this.f74614n;
    }

    public final String m() {
        return this.f74609i;
    }
}
