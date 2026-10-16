package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public abstract class LocationConditionScreenNavigation {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f115411a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.d1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LocationConditionScreenNavigation.b();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) LocationConditionScreenNavigation.f115411a.getValue();
        }

        public final KSerializer<LocationConditionScreenNavigation> serializer() {
            return a();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class LocationSelection extends LocationConditionScreenNavigation {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f115412b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<LocationSelection> serializer() {
                return LocationConditionScreenNavigation$LocationSelection$$serializer.f115413a;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LocationSelection(int i3, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, LocationConditionScreenNavigation$LocationSelection$$serializer.f115413a.getDescriptor());
            }
            this.f115412b = z2;
        }

        public static final /* synthetic */ void f(LocationSelection locationSelection, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            LocationConditionScreenNavigation.d(locationSelection, compositeEncoder, serialDescriptor);
            compositeEncoder.x(serialDescriptor, 0, locationSelection.f115412b);
        }

        public final boolean e() {
            return this.f115412b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocationSelection) && this.f115412b == ((LocationSelection) obj).f115412b;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f115412b);
        }

        public String toString() {
            return "LocationSelection(animate=" + this.f115412b + ")";
        }

        public LocationSelection(boolean z2) {
            super(null);
            this.f115412b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class TimeCondition extends LocationConditionScreenNavigation {
        public static final TimeCondition INSTANCE = new TimeCondition();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ Lazy f115415b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.e1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LocationConditionScreenNavigation.TimeCondition.b();
            }
        });

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f115416c = 8;

        private TimeCondition() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation.TimeCondition", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f115415b.getValue();
        }

        public final KSerializer<TimeCondition> serializer() {
            return f();
        }
    }

    public /* synthetic */ LocationConditionScreenNavigation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new SealedClassSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation", Reflection.b(LocationConditionScreenNavigation.class), new KClass[]{Reflection.b(LocationSelection.class), Reflection.b(TimeCondition.class)}, new KSerializer[]{LocationConditionScreenNavigation$LocationSelection$$serializer.f115413a, new ObjectSerializer("cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation.TimeCondition", TimeCondition.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    private LocationConditionScreenNavigation() {
    }

    public /* synthetic */ LocationConditionScreenNavigation(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public static final /* synthetic */ void d(LocationConditionScreenNavigation locationConditionScreenNavigation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
