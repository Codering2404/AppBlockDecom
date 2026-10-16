package androidx.compose.animation.core;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.KeyframeBaseEntity;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class KeyframesSpecBaseConfig<T, E extends KeyframeBaseEntity<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableIntObjectMap f4012c;

    public /* synthetic */ KeyframesSpecBaseConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a() {
        return this.f4011b;
    }

    public final int b() {
        return this.f4010a;
    }

    public final MutableIntObjectMap c() {
        return this.f4012c;
    }

    public final void d(int i3) {
        this.f4010a = i3;
    }

    public final KeyframeBaseEntity e(KeyframeBaseEntity keyframeBaseEntity, Easing easing) {
        keyframeBaseEntity.c(easing);
        return keyframeBaseEntity;
    }

    private KeyframesSpecBaseConfig() {
        this.f4010a = 300;
        this.f4012c = IntObjectMapKt.c();
    }
}
