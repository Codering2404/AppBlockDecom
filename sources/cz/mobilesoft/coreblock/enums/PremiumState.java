package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicy;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public abstract class PremiumState {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f97021a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PremiumState.b();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer b() {
            return (KSerializer) PremiumState.f97021a.getValue();
        }

        public final PremiumState a(String serialized) {
            JsonPrimitive jsonPrimitiveP;
            String strA;
            JsonPrimitive jsonPrimitiveP2;
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            try {
                try {
                    return (PremiumState) Json.f142959d.d(serializer(), serialized);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    CrashHelper.j(e3);
                    return None.INSTANCE;
                }
            } catch (Exception unused) {
                JsonElement jsonElementH = Json.f142959d.h(serialized);
                JsonElement jsonElement = (JsonElement) JsonElementKt.o(jsonElementH).get("type");
                boolean zAreEqual = Intrinsics.areEqual((jsonElement == null || (jsonPrimitiveP2 = JsonElementKt.p(jsonElement)) == null) ? null : jsonPrimitiveP2.a(), "cz.mobilesoft.coreblock.enums.PremiumState.Subscription");
                JsonElement jsonElement2 = (JsonElement) JsonElementKt.o(jsonElementH).get("productId");
                if (jsonElement2 != null && (jsonPrimitiveP = JsonElementKt.p(jsonElement2)) != null && (strA = jsonPrimitiveP.a()) != null) {
                    PremiumState premiumState = (zAreEqual && StringsKt.a0(strA, "month", false, 2, null)) ? Subscription.Monthly.INSTANCE : (zAreEqual && StringsKt.a0(strA, "year", false, 2, null)) ? Subscription.Yearly.INSTANCE : None.INSTANCE;
                    if (premiumState != null) {
                        return premiumState;
                    }
                }
                return None.INSTANCE;
            }
        }

        public final KSerializer<PremiumState> serializer() {
            return b();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Lifetime extends PremiumState {
        public static final Lifetime INSTANCE = new Lifetime();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ Lazy f97022b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PremiumState.Lifetime.b();
            }
        });

        private Lifetime() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Lifetime", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer k() {
            return (KSerializer) f97022b.getValue();
        }

        public final KSerializer<Lifetime> serializer() {
            return k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class None extends PremiumState {
        public static final None INSTANCE = new None();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ Lazy f97023b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PremiumState.None.b();
            }
        });

        private None() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.None", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer k() {
            return (KSerializer) f97023b.getValue();
        }

        public final KSerializer<None> serializer() {
            return k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static abstract class Old extends PremiumState {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Lazy f97024b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PremiumState.Old.b();
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer a() {
                return (KSerializer) Old.f97024b.getValue();
            }

            public final KSerializer<Old> serializer() {
                return a();
            }

            private Companion() {
            }
        }

        public /* synthetic */ Old(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new SealedClassSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Old", Reflection.b(Old.class), new KClass[]{Reflection.b(OldFull.class), Reflection.b(OldPartial.class)}, new KSerializer[]{new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.OldFull", OldFull.INSTANCE, new Annotation[0]), PremiumState$OldPartial$$serializer.f97028a}, new Annotation[0]);
        }

        private Old() {
            super(null);
        }

        public /* synthetic */ Old(int i3, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class OldFull extends Old {
        public static final OldFull INSTANCE = new OldFull();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f97025c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PremiumState.OldFull.b();
            }
        });

        private OldFull() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.OldFull", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer m() {
            return (KSerializer) f97025c.getValue();
        }

        public final KSerializer<OldFull> serializer() {
            return m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class OldPartial extends Old {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Lazy[] f97026d = {LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PremiumState.OldPartial.m();
            }
        })};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f97027c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<OldPartial> serializer() {
                return PremiumState$OldPartial$$serializer.f97028a;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OldPartial(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, PremiumState$OldPartial$$serializer.f97028a.getDescriptor());
            }
            this.f97027c = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer m() {
            return new ArrayListSerializer(StringSerializer.f142891a);
        }

        public static final /* synthetic */ void p(OldPartial oldPartial, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            PremiumState.i(oldPartial, compositeEncoder, serialDescriptor);
            compositeEncoder.C(serialDescriptor, 0, (SerializationStrategy) f97026d[0].getValue(), oldPartial.f97027c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OldPartial) && Intrinsics.areEqual(this.f97027c, ((OldPartial) obj).f97027c);
        }

        public int hashCode() {
            return this.f97027c.hashCode();
        }

        public final List o() {
            return this.f97027c;
        }

        @Override // cz.mobilesoft.coreblock.enums.PremiumState
        public String toString() {
            return "OldPartial(productIds=" + this.f97027c + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OldPartial(List productIds) {
            super(null);
            Intrinsics.checkNotNullParameter(productIds, "productIds");
            this.f97027c = productIds;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static abstract class Subscription extends PremiumState {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Lazy f97030b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PremiumState.Subscription.b();
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer a() {
                return (KSerializer) Subscription.f97030b.getValue();
            }

            public final KSerializer<Subscription> serializer() {
                return a();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class External extends Subscription {
            public static final Companion Companion = new Companion(null);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f97031c;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<External> serializer() {
                    return PremiumState$Subscription$External$$serializer.f97032a;
                }

                private Companion() {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ External(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, PremiumState$Subscription$External$$serializer.f97032a.getDescriptor());
                }
                this.f97031c = str;
            }

            public static final /* synthetic */ void l(External external, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                PremiumState.i(external, compositeEncoder, serialDescriptor);
                compositeEncoder.y(serialDescriptor, 0, external.f97031c);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof External) && Intrinsics.areEqual(this.f97031c, ((External) obj).f97031c);
            }

            public int hashCode() {
                return this.f97031c.hashCode();
            }

            @Override // cz.mobilesoft.coreblock.enums.PremiumState
            public String toString() {
                return "External(store=" + this.f97031c + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public External(String store) {
                super(null);
                Intrinsics.checkNotNullParameter(store, "store");
                this.f97031c = store;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Monthly extends Subscription {
            public static final Monthly INSTANCE = new Monthly();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ Lazy f97034c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumState.Subscription.Monthly.b();
                }
            });

            private Monthly() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription.Monthly", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer m() {
                return (KSerializer) f97034c.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Monthly);
            }

            public int hashCode() {
                return 252094601;
            }

            public final KSerializer<Monthly> serializer() {
                return m();
            }

            @Override // cz.mobilesoft.coreblock.enums.PremiumState
            public String toString() {
                return "Monthly";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Yearly extends Subscription {
            public static final Yearly INSTANCE = new Yearly();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ Lazy f97035c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.enums.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumState.Subscription.Yearly.b();
                }
            });

            private Yearly() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription.Yearly", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer m() {
                return (KSerializer) f97035c.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Yearly);
            }

            public int hashCode() {
                return 342057614;
            }

            public final KSerializer<Yearly> serializer() {
                return m();
            }

            @Override // cz.mobilesoft.coreblock.enums.PremiumState
            public String toString() {
                return "Yearly";
            }
        }

        public /* synthetic */ Subscription(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new SealedClassSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription", Reflection.b(Subscription.class), new KClass[]{Reflection.b(External.class), Reflection.b(Monthly.class), Reflection.b(Yearly.class)}, new KSerializer[]{PremiumState$Subscription$External$$serializer.f97032a, new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription.Monthly", Monthly.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription.Yearly", Yearly.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }

        private Subscription() {
            super(null);
        }

        public /* synthetic */ Subscription(int i3, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
        }
    }

    public /* synthetic */ PremiumState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new SealedClassSerializer("cz.mobilesoft.coreblock.enums.PremiumState", Reflection.b(PremiumState.class), new KClass[]{Reflection.b(Lifetime.class), Reflection.b(None.class), Reflection.b(OldFull.class), Reflection.b(OldPartial.class), Reflection.b(Subscription.External.class), Reflection.b(Subscription.Monthly.class), Reflection.b(Subscription.Yearly.class)}, new KSerializer[]{new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Lifetime", Lifetime.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.None", None.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.OldFull", OldFull.INSTANCE, new Annotation[0]), PremiumState$OldPartial$$serializer.f97028a, PremiumState$Subscription$External$$serializer.f97032a, new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription.Monthly", Subscription.Monthly.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.enums.PremiumState.Subscription.Yearly", Subscription.Yearly.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    public final String d() {
        if (Intrinsics.areEqual(this, None.INSTANCE)) {
            return "F";
        }
        if (this instanceof OldPartial) {
            return "oPp";
        }
        if (Intrinsics.areEqual(this, OldFull.INSTANCE)) {
            return "oP";
        }
        if (this instanceof Subscription) {
            return "S";
        }
        if (Intrinsics.areEqual(this, Lifetime.INSTANCE)) {
            return "Pl";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean e() {
        return this instanceof Subscription.Monthly;
    }

    public final boolean f(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return AccessPolicy.f128865a.b(this, product);
    }

    public final boolean g() {
        return AccessPolicyKt.a(this, Capability.SubscriptionFeatures);
    }

    public final String h() {
        return Json.f142959d.b(Companion.serializer(), this);
    }

    public String toString() {
        if (Intrinsics.areEqual(this, None.INSTANCE)) {
            return "None";
        }
        if (this instanceof OldPartial) {
            return "OldPartial(productIds=[" + CollectionsKt.joinToString$default(((OldPartial) this).o(), null, null, null, 0, null, null, 63, null) + "])";
        }
        if (Intrinsics.areEqual(this, OldFull.INSTANCE)) {
            return "OldFull";
        }
        if (!(this instanceof Subscription)) {
            if (Intrinsics.areEqual(this, Lifetime.INSTANCE)) {
                return "Lifetime";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "Subscription(product=" + this + ")";
    }

    private PremiumState() {
    }

    public /* synthetic */ PremiumState(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public static final /* synthetic */ void i(PremiumState premiumState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
