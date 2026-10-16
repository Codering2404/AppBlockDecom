package cz.mobilesoft.coreblock.scene.more.settings;

import cz.mobilesoft.coreblock.scene.more.settings.NavPremiumSettings;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

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
@Serializable
public final class NavPremiumSettings {
    public static final NavPremiumSettings INSTANCE = new NavPremiumSettings();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ Lazy f108037a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: c1.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NavPremiumSettings.b();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f108038b = 8;

    private NavPremiumSettings() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new ObjectSerializer("cz.mobilesoft.coreblock.scene.more.settings.NavPremiumSettings", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer c() {
        return (KSerializer) f108037a.getValue();
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof NavPremiumSettings);
    }

    public int hashCode() {
        return -1439287210;
    }

    public final KSerializer<NavPremiumSettings> serializer() {
        return c();
    }

    public String toString() {
        return "NavPremiumSettings";
    }
}
