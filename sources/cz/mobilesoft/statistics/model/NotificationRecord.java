package cz.mobilesoft.statistics.model;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f133722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f133723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f133724c;

    public NotificationRecord(long j3, long j4, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133722a = j3;
        this.f133723b = j4;
        this.f133724c = name;
    }

    public final long a() {
        return this.f133722a;
    }

    public final String b() {
        return this.f133724c;
    }

    public final long c() {
        return this.f133723b;
    }

    public /* synthetic */ NotificationRecord(long j3, long j4, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, str);
    }
}
