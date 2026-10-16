package cz.mobilesoft.coreblock.scene.streaks;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public final class StreakConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreakConfiguration f120230a = new StreakConfiguration();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f120231b = TimeUnit.HOURS.toMillis(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f120232c = TimeUnit.MINUTES.toMillis(15);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List f120233d = CollectionsKt.listOf((Object[]) new Integer[]{1, 3, 7, 14, 30, 50, 100});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f120234e = 8;

    private StreakConfiguration() {
    }

    public final long a() {
        return f120232c;
    }

    public final List b() {
        return f120233d;
    }

    public final long c() {
        return f120231b;
    }
}
