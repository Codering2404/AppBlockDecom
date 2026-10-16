package cz.mobilesoft.coreblock.storage.room.entity.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppVersionEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f126545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f126546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f126547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f126548g;

    public AppVersionEntity(long j3, String versionName, long j4, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        this.f126542a = j3;
        this.f126543b = versionName;
        this.f126544c = j4;
        this.f126545d = z2;
        this.f126546e = z3;
        this.f126547f = z4;
        this.f126548g = z5;
    }

    public final boolean a() {
        return this.f126546e;
    }

    public final boolean b() {
        return this.f126545d;
    }

    public final long c() {
        return this.f126544c;
    }

    public final long d() {
        return this.f126542a;
    }

    public final String e() {
        return this.f126543b;
    }

    public final boolean f() {
        return this.f126548g;
    }

    public final boolean g() {
        return this.f126547f;
    }
}
