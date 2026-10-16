package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation;
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
public abstract class WifiConditionScreenNavigation {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f116029a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.j1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return WifiConditionScreenNavigation.b();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) WifiConditionScreenNavigation.f116029a.getValue();
        }

        public final KSerializer<WifiConditionScreenNavigation> serializer() {
            return a();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class TimeCondition extends WifiConditionScreenNavigation {
        public static final TimeCondition INSTANCE = new TimeCondition();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ Lazy f116030b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.k1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WifiConditionScreenNavigation.TimeCondition.b();
            }
        });

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f116031c = 8;

        private TimeCondition() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation.TimeCondition", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer e() {
            return (KSerializer) f116030b.getValue();
        }

        public final KSerializer<TimeCondition> serializer() {
            return e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class WifiSelection extends WifiConditionScreenNavigation {
        public static final WifiSelection INSTANCE = new WifiSelection();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ Lazy f116032b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.l1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WifiConditionScreenNavigation.WifiSelection.b();
            }
        });

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f116033c = 8;

        private WifiSelection() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation.WifiSelection", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer e() {
            return (KSerializer) f116032b.getValue();
        }

        public final KSerializer<WifiSelection> serializer() {
            return e();
        }
    }

    public /* synthetic */ WifiConditionScreenNavigation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new SealedClassSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation", Reflection.b(WifiConditionScreenNavigation.class), new KClass[]{Reflection.b(TimeCondition.class), Reflection.b(WifiSelection.class)}, new KSerializer[]{new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation.TimeCondition", TimeCondition.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation.WifiSelection", WifiSelection.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    private WifiConditionScreenNavigation() {
    }
}
