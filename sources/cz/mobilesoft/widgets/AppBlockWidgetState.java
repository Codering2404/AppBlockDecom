package cz.mobilesoft.widgets;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
public final class AppBlockWidgetState {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f133888e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy[] f133889f = {LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppBlockWidgetState.b();
        }
    }), null, null, null};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final QuickBlockWidgetState f133890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SchedulesWidgetState f133891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f133892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f133893d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AppBlockWidgetState> serializer() {
            return AppBlockWidgetState$$serializer.f133894a;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static abstract class QuickBlockWidgetState {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Lazy f133896a = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppBlockWidgetState.QuickBlockWidgetState.b();
            }
        });

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static abstract class Blocking extends QuickBlockWidgetState {
            public static final Companion Companion = new Companion(null);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final Lazy f133897b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBlockWidgetState.QuickBlockWidgetState.Blocking.b();
                }
            });

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private final /* synthetic */ KSerializer a() {
                    return (KSerializer) Blocking.f133897b.getValue();
                }

                public final KSerializer<Blocking> serializer() {
                    return a();
                }

                private Companion() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public static final class Pomodoro extends Blocking {
                public static final Companion Companion = new Companion(null);

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final PomodoroSession f133898c;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer<Pomodoro> serializer() {
                        return AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer.f133899a;
                    }

                    private Companion() {
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @Serializable
                public static final class PomodoroSession {
                    public static final Companion Companion = new Companion(null);

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    private final boolean f133901a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private final int f133902b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    private final long f133903c;

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        public final KSerializer<PomodoroSession> serializer() {
                            return AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer.f133904a;
                        }

                        private Companion() {
                        }
                    }

                    public /* synthetic */ PomodoroSession(int i3, boolean z2, int i4, long j3, SerializationConstructorMarker serializationConstructorMarker) {
                        if (7 != (i3 & 7)) {
                            PluginExceptionsKt.b(i3, 7, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer.f133904a.getDescriptor());
                        }
                        this.f133901a = z2;
                        this.f133902b = i4;
                        this.f133903c = j3;
                    }

                    public static final /* synthetic */ void d(PomodoroSession pomodoroSession, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                        compositeEncoder.x(serialDescriptor, 0, pomodoroSession.f133901a);
                        compositeEncoder.w(serialDescriptor, 1, pomodoroSession.f133902b);
                        compositeEncoder.F(serialDescriptor, 2, pomodoroSession.f133903c);
                    }

                    public final long a() {
                        return this.f133903c;
                    }

                    public final int b() {
                        return this.f133902b;
                    }

                    public final boolean c() {
                        return this.f133901a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof PomodoroSession)) {
                            return false;
                        }
                        PomodoroSession pomodoroSession = (PomodoroSession) obj;
                        return this.f133901a == pomodoroSession.f133901a && this.f133902b == pomodoroSession.f133902b && this.f133903c == pomodoroSession.f133903c;
                    }

                    public int hashCode() {
                        return (((Boolean.hashCode(this.f133901a) * 31) + Integer.hashCode(this.f133902b)) * 31) + Long.hashCode(this.f133903c);
                    }

                    public String toString() {
                        return "PomodoroSession(isCurrentlyOnBreak=" + this.f133901a + ", sessionNumber=" + this.f133902b + ", currentNodeActiveUntil=" + this.f133903c + ")";
                    }

                    public PomodoroSession(boolean z2, int i3, long j3) {
                        this.f133901a = z2;
                        this.f133902b = i3;
                        this.f133903c = j3;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Pomodoro(int i3, PomodoroSession pomodoroSession, SerializationConstructorMarker serializationConstructorMarker) {
                    super(i3, serializationConstructorMarker);
                    if (1 != (i3 & 1)) {
                        PluginExceptionsKt.b(i3, 1, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer.f133899a.getDescriptor());
                    }
                    this.f133898c = pomodoroSession;
                }

                public static final /* synthetic */ void k(Pomodoro pomodoro, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                    QuickBlockWidgetState.f(pomodoro, compositeEncoder, serialDescriptor);
                    compositeEncoder.C(serialDescriptor, 0, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer.f133904a, pomodoro.f133898c);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Pomodoro) && Intrinsics.areEqual(this.f133898c, ((Pomodoro) obj).f133898c);
                }

                @Override // cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Blocking
                public Long h() {
                    return Long.valueOf(this.f133898c.a());
                }

                public int hashCode() {
                    return this.f133898c.hashCode();
                }

                public final PomodoroSession j() {
                    return this.f133898c;
                }

                public String toString() {
                    return "Pomodoro(session=" + this.f133898c + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Pomodoro(PomodoroSession session) {
                    super(null);
                    Intrinsics.checkNotNullParameter(session, "session");
                    this.f133898c = session;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @Serializable
            public static final class Simple extends Blocking {
                public static final Companion Companion = new Companion(null);

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final Long f133906c;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final KSerializer<Simple> serializer() {
                        return AppBlockWidgetState$QuickBlockWidgetState$Blocking$Simple$$serializer.f133907a;
                    }

                    private Companion() {
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Simple() {
                    this((Long) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
                }

                public static final /* synthetic */ void j(Simple simple, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                    QuickBlockWidgetState.f(simple, compositeEncoder, serialDescriptor);
                    if (!compositeEncoder.z(serialDescriptor, 0) && simple.h() == null) {
                        return;
                    }
                    compositeEncoder.i(serialDescriptor, 0, LongSerializer.f142836a, simple.h());
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Simple) && Intrinsics.areEqual(this.f133906c, ((Simple) obj).f133906c);
                }

                @Override // cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Blocking
                public Long h() {
                    return this.f133906c;
                }

                public int hashCode() {
                    Long l3 = this.f133906c;
                    if (l3 == null) {
                        return 0;
                    }
                    return l3.hashCode();
                }

                public /* synthetic */ Simple(int i3, Long l3, SerializationConstructorMarker serializationConstructorMarker) {
                    super(i3, serializationConstructorMarker);
                    if ((i3 & 1) == 0) {
                        this.f133906c = null;
                    } else {
                        this.f133906c = l3;
                    }
                }

                public String toString() {
                    return "Simple(until=" + this.f133906c + YznnJpHcAmeoW.qhlrlsfex;
                }

                public Simple(Long l3) {
                    super(null);
                    this.f133906c = l3;
                }

                public /* synthetic */ Simple(Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? null : l3);
                }
            }

            public /* synthetic */ Blocking(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new SealedClassSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Blocking", Reflection.b(Blocking.class), new KClass[]{Reflection.b(Pomodoro.class), Reflection.b(Simple.class)}, new KSerializer[]{AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer.f133899a, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Simple$$serializer.f133907a}, new Annotation[0]);
            }

            public abstract Long h();

            private Blocking() {
                super(null);
            }

            public /* synthetic */ Blocking(int i3, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer a() {
                return (KSerializer) QuickBlockWidgetState.f133896a.getValue();
            }

            public final KSerializer<QuickBlockWidgetState> serializer() {
                return a();
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class NotSetUp extends QuickBlockWidgetState {
            public static final NotSetUp INSTANCE = new NotSetUp();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final /* synthetic */ Lazy f133909b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBlockWidgetState.QuickBlockWidgetState.NotSetUp.b();
                }
            });

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f133910c = 8;

            private NotSetUp() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.NotSetUp", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer h() {
                return (KSerializer) f133909b.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NotSetUp);
            }

            public int hashCode() {
                return -464153342;
            }

            public final KSerializer<NotSetUp> serializer() {
                return h();
            }

            public String toString() {
                return "NotSetUp";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class OnboardingNotFinished extends QuickBlockWidgetState {
            public static final OnboardingNotFinished INSTANCE = new OnboardingNotFinished();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final /* synthetic */ Lazy f133911b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished.b();
                }
            });

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f133912c = 8;

            private OnboardingNotFinished() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer h() {
                return (KSerializer) f133911b.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof OnboardingNotFinished);
            }

            public int hashCode() {
                return -1865227054;
            }

            public final KSerializer<OnboardingNotFinished> serializer() {
                return h();
            }

            public String toString() {
                return "OnboardingNotFinished";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        @Deprecated
        public static final class Running extends QuickBlockWidgetState {
            public static final Companion Companion = new Companion(null);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Long f133913b;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Running> serializer() {
                    return AppBlockWidgetState$QuickBlockWidgetState$Running$$serializer.f133914a;
                }

                private Companion() {
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Running() {
                this((Long) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            public static final /* synthetic */ void h(Running running, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                QuickBlockWidgetState.f(running, compositeEncoder, serialDescriptor);
                if (!compositeEncoder.z(serialDescriptor, 0) && running.f133913b == null) {
                    return;
                }
                compositeEncoder.i(serialDescriptor, 0, LongSerializer.f142836a, running.f133913b);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Running) && Intrinsics.areEqual(this.f133913b, ((Running) obj).f133913b);
            }

            public final Long g() {
                return this.f133913b;
            }

            public int hashCode() {
                Long l3 = this.f133913b;
                if (l3 == null) {
                    return 0;
                }
                return l3.hashCode();
            }

            public String toString() {
                return "Running(timer=" + this.f133913b + ")";
            }

            public /* synthetic */ Running(int i3, Long l3, SerializationConstructorMarker serializationConstructorMarker) {
                super(i3, serializationConstructorMarker);
                if ((i3 & 1) == 0) {
                    this.f133913b = null;
                } else {
                    this.f133913b = l3;
                }
            }

            public Running(Long l3) {
                super(null);
                this.f133913b = l3;
            }

            public /* synthetic */ Running(Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? null : l3);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Stopped extends QuickBlockWidgetState {
            public static final Stopped INSTANCE = new Stopped();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final /* synthetic */ Lazy f133916b = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBlockWidgetState.QuickBlockWidgetState.Stopped.b();
                }
            });

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f133917c = 8;

            private Stopped() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer b() {
                return new ObjectSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Stopped", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer h() {
                return (KSerializer) f133916b.getValue();
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Stopped);
            }

            public int hashCode() {
                return -1811229355;
            }

            public final KSerializer<Stopped> serializer() {
                return h();
            }

            public String toString() {
                return "Stopped";
            }
        }

        public /* synthetic */ QuickBlockWidgetState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new SealedClassSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState", Reflection.b(QuickBlockWidgetState.class), new KClass[]{Reflection.b(Blocking.Pomodoro.class), Reflection.b(Blocking.Simple.class), Reflection.b(NotSetUp.class), Reflection.b(OnboardingNotFinished.class), Reflection.b(Running.class), Reflection.b(Stopped.class)}, new KSerializer[]{AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer.f133899a, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Simple$$serializer.f133907a, new ObjectSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.NotSetUp", NotSetUp.INSTANCE, new Annotation[0]), new ObjectSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished", OnboardingNotFinished.INSTANCE, new Annotation[0]), AppBlockWidgetState$QuickBlockWidgetState$Running$$serializer.f133914a, new ObjectSerializer("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Stopped", Stopped.INSTANCE, new Annotation[0])}, new Annotation[0]);
        }

        public final Long d() {
            if (this instanceof Blocking) {
                return ((Blocking) this).h();
            }
            if (this instanceof Running) {
                return ((Running) this).g();
            }
            return null;
        }

        public final boolean e() {
            return (this instanceof Blocking) || (this instanceof Running);
        }

        private QuickBlockWidgetState() {
        }

        public /* synthetic */ QuickBlockWidgetState(int i3, SerializationConstructorMarker serializationConstructorMarker) {
        }

        public static final /* synthetic */ void f(QuickBlockWidgetState quickBlockWidgetState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class SchedulesWidgetState {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f133918b = 8;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Lazy[] f133919c = {LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: cz.mobilesoft.widgets.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppBlockWidgetState.SchedulesWidgetState.b();
            }
        })};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f133920a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<SchedulesWidgetState> serializer() {
                return AppBlockWidgetState$SchedulesWidgetState$$serializer.f133921a;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Schedule {
            public static final Companion Companion = new Companion(null);

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f133923a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f133924b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f133925c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final boolean f133926d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final Integer f133927e;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<Schedule> serializer() {
                    return AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer.f133928a;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Schedule(int i3, long j3, String str, String str2, boolean z2, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
                if (31 != (i3 & 31)) {
                    PluginExceptionsKt.b(i3, 31, AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer.f133928a.getDescriptor());
                }
                this.f133923a = j3;
                this.f133924b = str;
                this.f133925c = str2;
                this.f133926d = z2;
                this.f133927e = num;
            }

            public static final /* synthetic */ void f(Schedule schedule, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.F(serialDescriptor, 0, schedule.f133923a);
                compositeEncoder.y(serialDescriptor, 1, schedule.f133924b);
                compositeEncoder.y(serialDescriptor, 2, schedule.f133925c);
                compositeEncoder.x(serialDescriptor, 3, schedule.f133926d);
                compositeEncoder.i(serialDescriptor, 4, IntSerializer.f142823a, schedule.f133927e);
            }

            public final long a() {
                return this.f133923a;
            }

            public final Integer b() {
                return this.f133927e;
            }

            public final String c() {
                return this.f133925c;
            }

            public final String d() {
                return this.f133924b;
            }

            public final boolean e() {
                return this.f133926d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Schedule)) {
                    return false;
                }
                Schedule schedule = (Schedule) obj;
                return this.f133923a == schedule.f133923a && Intrinsics.areEqual(this.f133924b, schedule.f133924b) && Intrinsics.areEqual(this.f133925c, schedule.f133925c) && this.f133926d == schedule.f133926d && Intrinsics.areEqual(this.f133927e, schedule.f133927e);
            }

            public int hashCode() {
                int iHashCode = ((((((Long.hashCode(this.f133923a) * 31) + this.f133924b.hashCode()) * 31) + this.f133925c.hashCode()) * 31) + Boolean.hashCode(this.f133926d)) * 31;
                Integer num = this.f133927e;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "Schedule(id=" + this.f133923a + ", title=" + this.f133924b + ", subtitle=" + this.f133925c + ", isCurrentlyOn=" + this.f133926d + ", stateIconResId=" + this.f133927e + ")";
            }

            public Schedule(long j3, String title, String subtitle, boolean z2, Integer num) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                this.f133923a = j3;
                this.f133924b = title;
                this.f133925c = subtitle;
                this.f133926d = z2;
                this.f133927e = num;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SchedulesWidgetState() {
            this((List) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ArrayListSerializer(AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer.f133928a);
        }

        public static final /* synthetic */ void f(SchedulesWidgetState schedulesWidgetState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            Lazy[] lazyArr = f133919c;
            if (!compositeEncoder.z(serialDescriptor, 0) && Intrinsics.areEqual(schedulesWidgetState.f133920a, CollectionsKt.emptyList())) {
                return;
            }
            compositeEncoder.C(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), schedulesWidgetState.f133920a);
        }

        public final SchedulesWidgetState d(List schedules) {
            Intrinsics.checkNotNullParameter(schedules, "schedules");
            return new SchedulesWidgetState(schedules);
        }

        public final List e() {
            return this.f133920a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SchedulesWidgetState) && Intrinsics.areEqual(this.f133920a, ((SchedulesWidgetState) obj).f133920a);
        }

        public int hashCode() {
            return this.f133920a.hashCode();
        }

        public String toString() {
            return "SchedulesWidgetState(schedules=" + this.f133920a + ")";
        }

        public /* synthetic */ SchedulesWidgetState(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i3 & 1) == 0) {
                this.f133920a = CollectionsKt.emptyList();
            } else {
                this.f133920a = list;
            }
        }

        public SchedulesWidgetState(List schedules) {
            Intrinsics.checkNotNullParameter(schedules, "schedules");
            this.f133920a = schedules;
        }

        public /* synthetic */ SchedulesWidgetState(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    public AppBlockWidgetState() {
        this((QuickBlockWidgetState) null, (SchedulesWidgetState) null, false, 0, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return QuickBlockWidgetState.Companion.serializer();
    }

    public static /* synthetic */ AppBlockWidgetState e(AppBlockWidgetState appBlockWidgetState, QuickBlockWidgetState quickBlockWidgetState, SchedulesWidgetState schedulesWidgetState, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            quickBlockWidgetState = appBlockWidgetState.f133890a;
        }
        if ((i4 & 2) != 0) {
            schedulesWidgetState = appBlockWidgetState.f133891b;
        }
        if ((i4 & 4) != 0) {
            z2 = appBlockWidgetState.f133892c;
        }
        if ((i4 & 8) != 0) {
            i3 = appBlockWidgetState.f133893d;
        }
        return appBlockWidgetState.d(quickBlockWidgetState, schedulesWidgetState, z2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void i(AppBlockWidgetState appBlockWidgetState, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Lazy[] lazyArr = f133889f;
        if (compositeEncoder.z(serialDescriptor, 0) || !Intrinsics.areEqual(appBlockWidgetState.f133890a, QuickBlockWidgetState.OnboardingNotFinished.INSTANCE)) {
            compositeEncoder.C(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), appBlockWidgetState.f133890a);
        }
        int i3 = 1;
        if (compositeEncoder.z(serialDescriptor, 1) || !Intrinsics.areEqual(appBlockWidgetState.f133891b, new SchedulesWidgetState((List) null, i3, (DefaultConstructorMarker) (0 == true ? 1 : 0)))) {
            compositeEncoder.C(serialDescriptor, 1, AppBlockWidgetState$SchedulesWidgetState$$serializer.f133921a, appBlockWidgetState.f133891b);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || appBlockWidgetState.f133892c) {
            compositeEncoder.x(serialDescriptor, 2, appBlockWidgetState.f133892c);
        }
        if (!compositeEncoder.z(serialDescriptor, 3) && appBlockWidgetState.f133893d == 1) {
            return;
        }
        compositeEncoder.w(serialDescriptor, 3, appBlockWidgetState.f133893d);
    }

    public final AppBlockWidgetState d(QuickBlockWidgetState quickBlockWidgetState, SchedulesWidgetState schedulesWidgetState, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(quickBlockWidgetState, "quickBlockWidgetState");
        Intrinsics.checkNotNullParameter(schedulesWidgetState, "schedulesWidgetState");
        return new AppBlockWidgetState(quickBlockWidgetState, schedulesWidgetState, z2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppBlockWidgetState)) {
            return false;
        }
        AppBlockWidgetState appBlockWidgetState = (AppBlockWidgetState) obj;
        return Intrinsics.areEqual(this.f133890a, appBlockWidgetState.f133890a) && Intrinsics.areEqual(this.f133891b, appBlockWidgetState.f133891b) && this.f133892c == appBlockWidgetState.f133892c && this.f133893d == appBlockWidgetState.f133893d;
    }

    public final QuickBlockWidgetState f() {
        return this.f133890a;
    }

    public final SchedulesWidgetState g() {
        return this.f133891b;
    }

    public final boolean h() {
        return this.f133892c;
    }

    public int hashCode() {
        return (((((this.f133890a.hashCode() * 31) + this.f133891b.hashCode()) * 31) + Boolean.hashCode(this.f133892c)) * 31) + Integer.hashCode(this.f133893d);
    }

    public String toString() {
        return "AppBlockWidgetState(quickBlockWidgetState=" + this.f133890a + ", schedulesWidgetState=" + this.f133891b + ", isPremium=" + this.f133892c + ", version=" + this.f133893d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AppBlockWidgetState(int i3, QuickBlockWidgetState quickBlockWidgetState, SchedulesWidgetState schedulesWidgetState, boolean z2, int i4, SerializationConstructorMarker serializationConstructorMarker) {
        this.f133890a = (i3 & 1) == 0 ? QuickBlockWidgetState.OnboardingNotFinished.INSTANCE : quickBlockWidgetState;
        int i5 = 1;
        if ((i3 & 2) == 0) {
            this.f133891b = new SchedulesWidgetState((List) null, i5, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        } else {
            this.f133891b = schedulesWidgetState;
        }
        if ((i3 & 4) == 0) {
            this.f133892c = false;
        } else {
            this.f133892c = z2;
        }
        if ((i3 & 8) == 0) {
            this.f133893d = 1;
        } else {
            this.f133893d = i4;
        }
    }

    public AppBlockWidgetState(QuickBlockWidgetState quickBlockWidgetState, SchedulesWidgetState schedulesWidgetState, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(quickBlockWidgetState, "quickBlockWidgetState");
        Intrinsics.checkNotNullParameter(schedulesWidgetState, "schedulesWidgetState");
        this.f133890a = quickBlockWidgetState;
        this.f133891b = schedulesWidgetState;
        this.f133892c = z2;
        this.f133893d = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AppBlockWidgetState(QuickBlockWidgetState quickBlockWidgetState, SchedulesWidgetState schedulesWidgetState, boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? QuickBlockWidgetState.OnboardingNotFinished.INSTANCE : quickBlockWidgetState, (i4 & 2) != 0 ? new SchedulesWidgetState((List) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : schedulesWidgetState, (i4 & 4) != 0 ? false : z2, (i4 & 8) != 0 ? 1 : i3);
    }
}
