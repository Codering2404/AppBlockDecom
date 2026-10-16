package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenNavigation;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@Serializable
public abstract class CustomCombinationScreenNavigation {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f116260a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.p0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CustomCombinationScreenNavigation.b();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) CustomCombinationScreenNavigation.f116260a.getValue();
        }

        public final KSerializer<CustomCombinationScreenNavigation> serializer() {
            return a();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class CustomCombination extends CustomCombinationScreenNavigation {
        public static final CustomCombination INSTANCE = new CustomCombination();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ Lazy f116261b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomCombinationScreenNavigation.CustomCombination.b();
            }
        });

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f116262c = 8;

        private CustomCombination() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenNavigation.CustomCombination", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer e() {
            return (KSerializer) f116261b.getValue();
        }

        public final KSerializer<CustomCombination> serializer() {
            return e();
        }
    }

    public /* synthetic */ CustomCombinationScreenNavigation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new SealedClassSerializer("cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenNavigation", Reflection.b(CustomCombinationScreenNavigation.class), new KClass[]{Reflection.b(CustomCombination.class)}, new KSerializer[]{new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenNavigation.CustomCombination", CustomCombination.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    private CustomCombinationScreenNavigation() {
    }
}
