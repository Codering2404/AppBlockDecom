package cz.mobilesoft.coreblock.scene.subscriptionob;

import cz.mobilesoft.coreblock.scene.subscriptionob.Screen;
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
public abstract class Screen {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f122691b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Screen.b();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f122692a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Allowlist extends Screen {
        public static final Allowlist INSTANCE = new Allowlist();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122693c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.Allowlist.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122694d = 8;

        private Allowlist() {
            super("unlockedAllowlist", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Allowlist", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122693c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Allowlist);
        }

        public int hashCode() {
            return 231499158;
        }

        public final KSerializer<Allowlist> serializer() {
            return f();
        }

        public String toString() {
            return "Allowlist";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer a() {
            return (KSerializer) Screen.f122691b.getValue();
        }

        public final KSerializer<Screen> serializer() {
            return a();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Confirmation extends Screen {
        public static final Confirmation INSTANCE = new Confirmation();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122695c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.Confirmation.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122696d = 8;

        private Confirmation() {
            super("enjoyAllPremiumFeatures", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Confirmation", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122695c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Confirmation);
        }

        public int hashCode() {
            return -771077210;
        }

        public final KSerializer<Confirmation> serializer() {
            return f();
        }

        public String toString() {
            return "Confirmation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class QuickBlockOverview extends Screen {
        public static final QuickBlockOverview INSTANCE = new QuickBlockOverview();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122697c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.QuickBlockOverview.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122698d = 8;

        private QuickBlockOverview() {
            super("timerAndPomodoro", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.QuickBlockOverview", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122697c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof QuickBlockOverview);
        }

        public int hashCode() {
            return 121680618;
        }

        public final KSerializer<QuickBlockOverview> serializer() {
            return f();
        }

        public String toString() {
            return "QuickBlockOverview";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ScheduleCustomization extends Screen {
        public static final ScheduleCustomization INSTANCE = new ScheduleCustomization();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122699c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.ScheduleCustomization.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122700d = 8;

        private ScheduleCustomization() {
            super("unlimitedFunctions", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.ScheduleCustomization", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122699c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ScheduleCustomization);
        }

        public int hashCode() {
            return 715424299;
        }

        public final KSerializer<ScheduleCustomization> serializer() {
            return f();
        }

        public String toString() {
            return "ScheduleCustomization";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ScheduleOverview extends Screen {
        public static final ScheduleOverview INSTANCE = new ScheduleOverview();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122701c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.ScheduleOverview.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122702d = 8;

        private ScheduleOverview() {
            super("unlimitedSchedules", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.ScheduleOverview", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122701c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ScheduleOverview);
        }

        public int hashCode() {
            return 548535329;
        }

        public final KSerializer<ScheduleOverview> serializer() {
            return f();
        }

        public String toString() {
            return "ScheduleOverview";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class StrictMode extends Screen {
        public static final StrictMode INSTANCE = new StrictMode();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122703c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.StrictMode.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122704d = 8;

        private StrictMode() {
            super("unlimitedStrictMode", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.StrictMode", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122703c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof StrictMode);
        }

        public int hashCode() {
            return -1959630915;
        }

        public final KSerializer<StrictMode> serializer() {
            return f();
        }

        public String toString() {
            return "StrictMode";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Trial extends Screen {
        public static final Trial INSTANCE = new Trial();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122705c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.Trial.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122706d = 8;

        private Trial() {
            super("notificationsTrialReminder", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Trial", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122705c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Trial);
        }

        public int hashCode() {
            return 1341742277;
        }

        public final KSerializer<Trial> serializer() {
            return f();
        }

        public String toString() {
            return "Trial";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Welcome extends Screen {
        public static final Welcome INSTANCE = new Welcome();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Lazy f122707c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Screen.Welcome.b();
            }
        });

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f122708d = 8;

        private Welcome() {
            super("loginAfterPurchase", null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Welcome", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer f() {
            return (KSerializer) f122707c.getValue();
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Welcome);
        }

        public int hashCode() {
            return -1077659311;
        }

        public final KSerializer<Welcome> serializer() {
            return f();
        }

        public String toString() {
            return "Welcome";
        }
    }

    public /* synthetic */ Screen(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new SealedClassSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen", Reflection.b(Screen.class), new KClass[]{Reflection.b(Allowlist.class), Reflection.b(Confirmation.class), Reflection.b(QuickBlockOverview.class), Reflection.b(ScheduleCustomization.class), Reflection.b(ScheduleOverview.class), Reflection.b(StrictMode.class), Reflection.b(Trial.class), Reflection.b(Welcome.class)}, new KSerializer[]{new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Allowlist", Allowlist.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Confirmation", Confirmation.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.QuickBlockOverview", QuickBlockOverview.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.ScheduleCustomization", ScheduleCustomization.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.ScheduleOverview", ScheduleOverview.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.StrictMode", StrictMode.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Trial", Trial.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.coreblock.scene.subscriptionob.Screen.Welcome", Welcome.INSTANCE, new Annotation[0])}, new Annotation[0]);
    }

    public final String d() {
        return this.f122692a;
    }

    private Screen(String str) {
        this.f122692a = str;
    }
}
