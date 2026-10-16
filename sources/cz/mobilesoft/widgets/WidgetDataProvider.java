package cz.mobilesoft.widgets;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public interface WidgetDataProvider {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WidgetColor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WidgetColor f134020a = new WidgetColor("Background", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WidgetColor f134021b = new WidgetColor("Surface", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final WidgetColor f134022c = new WidgetColor("Accent", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final WidgetColor f134023d = new WidgetColor("Premium", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final WidgetColor f134024f = new WidgetColor("Main", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final WidgetColor f134025g = new WidgetColor("Tertiary", 5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ WidgetColor[] f134026h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f134027i;

        static {
            WidgetColor[] widgetColorArrA = a();
            f134026h = widgetColorArrA;
            f134027i = EnumEntriesKt.a(widgetColorArrA);
        }

        private WidgetColor(String str, int i3) {
        }

        private static final /* synthetic */ WidgetColor[] a() {
            return new WidgetColor[]{f134020a, f134021b, f134022c, f134023d, f134024f, f134025g};
        }

        public static WidgetColor valueOf(String str) {
            return (WidgetColor) Enum.valueOf(WidgetColor.class, str);
        }

        public static WidgetColor[] values() {
            return (WidgetColor[]) f134026h.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WidgetIcon {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WidgetIcon f134028a = new WidgetIcon("Premium", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WidgetIcon f134029b = new WidgetIcon("Check", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final WidgetIcon f134030c = new WidgetIcon("Timer", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final WidgetIcon f134031d = new WidgetIcon("Start", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final WidgetIcon f134032f = new WidgetIcon("Stop", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final WidgetIcon f134033g = new WidgetIcon("Add", 5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final WidgetIcon f134034h = new WidgetIcon("Time", 6);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final WidgetIcon f134035i = new WidgetIcon("Pomodoro", 7);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final WidgetIcon f134036j = new WidgetIcon("PomodoroSmall", 8);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ WidgetIcon[] f134037k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f134038l;

        static {
            WidgetIcon[] widgetIconArrA = a();
            f134037k = widgetIconArrA;
            f134038l = EnumEntriesKt.a(widgetIconArrA);
        }

        private WidgetIcon(String str, int i3) {
        }

        private static final /* synthetic */ WidgetIcon[] a() {
            return new WidgetIcon[]{f134028a, f134029b, f134030c, f134031d, f134032f, f134033g, f134034h, f134035i, f134036j};
        }

        public static WidgetIcon valueOf(String str) {
            return (WidgetIcon) Enum.valueOf(WidgetIcon.class, str);
        }

        public static WidgetIcon[] values() {
            return (WidgetIcon[]) f134037k.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WidgetPremiumFeature {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WidgetPremiumFeature f134039a = new WidgetPremiumFeature("QuickBlockTimer", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WidgetPremiumFeature f134040b = new WidgetPremiumFeature("Schedules", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ WidgetPremiumFeature[] f134041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f134042d;

        static {
            WidgetPremiumFeature[] widgetPremiumFeatureArrA = a();
            f134041c = widgetPremiumFeatureArrA;
            f134042d = EnumEntriesKt.a(widgetPremiumFeatureArrA);
        }

        private WidgetPremiumFeature(String str, int i3) {
        }

        private static final /* synthetic */ WidgetPremiumFeature[] a() {
            return new WidgetPremiumFeature[]{f134039a, f134040b};
        }

        public static WidgetPremiumFeature valueOf(String str) {
            return (WidgetPremiumFeature) Enum.valueOf(WidgetPremiumFeature.class, str);
        }

        public static WidgetPremiumFeature[] values() {
            return (WidgetPremiumFeature[]) f134041c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WidgetQuickTimer {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WidgetQuickTimer f134043b = new WidgetQuickTimer("Start25m", 0, WidgetString.Time25m.f134068a);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final WidgetQuickTimer f134044c = new WidgetQuickTimer("Start1h", 1, WidgetString.Time1h.f134066a);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final WidgetQuickTimer f134045d = new WidgetQuickTimer("Start24h", 2, WidgetString.Time24h.f134067a);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final WidgetQuickTimer f134046f = new WidgetQuickTimer("Indefinitely", 3, null, 1, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final WidgetQuickTimer f134047g = new WidgetQuickTimer("Custom", 4, null, 1, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final WidgetQuickTimer f134048h = new WidgetQuickTimer("Pomodoro", 5, null, 1, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ WidgetQuickTimer[] f134049i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f134050j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WidgetString f134051a;

        static {
            WidgetQuickTimer[] widgetQuickTimerArrA = a();
            f134049i = widgetQuickTimerArrA;
            f134050j = EnumEntriesKt.a(widgetQuickTimerArrA);
        }

        private WidgetQuickTimer(String str, int i3, WidgetString widgetString) {
            this.f134051a = widgetString;
        }

        private static final /* synthetic */ WidgetQuickTimer[] a() {
            return new WidgetQuickTimer[]{f134043b, f134044c, f134045d, f134046f, f134047g, f134048h};
        }

        public static WidgetQuickTimer valueOf(String str) {
            return (WidgetQuickTimer) Enum.valueOf(WidgetQuickTimer.class, str);
        }

        public static WidgetQuickTimer[] values() {
            return (WidgetQuickTimer[]) f134049i.clone();
        }

        /* synthetic */ WidgetQuickTimer(String str, int i3, WidgetString widgetString, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i4 & 1) != 0 ? null : widgetString);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class WidgetString {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Active extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Active f134052a = new Active();

            private Active() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Active);
            }

            public int hashCode() {
                return 524885818;
            }

            public String toString() {
                return "Active";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Add extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Add f134053a = new Add();

            private Add() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Add);
            }

            public int hashCode() {
                return -1048386323;
            }

            public String toString() {
                return "Add";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ApplicationName extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final ApplicationName f134054a = new ApplicationName();

            private ApplicationName() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof ApplicationName);
            }

            public int hashCode() {
                return 1397433927;
            }

            public String toString() {
                return "ApplicationName";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Pomodoro extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Pomodoro f134055a = new Pomodoro();

            private Pomodoro() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Pomodoro);
            }

            public int hashCode() {
                return -153794915;
            }

            public String toString() {
                return "Pomodoro";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PomodoroBreak extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final PomodoroBreak f134056a = new PomodoroBreak();

            private PomodoroBreak() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof PomodoroBreak);
            }

            public int hashCode() {
                return -1991852958;
            }

            public String toString() {
                return "PomodoroBreak";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PomodoroBreakWithCountdown extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final PomodoroBreakWithCountdown f134057a = new PomodoroBreakWithCountdown();

            private PomodoroBreakWithCountdown() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof PomodoroBreakWithCountdown);
            }

            public int hashCode() {
                return 1129866953;
            }

            public String toString() {
                return "PomodoroBreakWithCountdown";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PomodoroFocus extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f134058a;

            public PomodoroFocus(int i3) {
                super(null);
                this.f134058a = i3;
            }

            public final int a() {
                return this.f134058a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PomodoroFocus) && this.f134058a == ((PomodoroFocus) obj).f134058a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f134058a);
            }

            public String toString() {
                return "PomodoroFocus(sessionNumber=" + this.f134058a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PomodoroFocusWithCountdown extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f134059a;

            public PomodoroFocusWithCountdown(int i3) {
                super(null);
                this.f134059a = i3;
            }

            public final int a() {
                return this.f134059a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PomodoroFocusWithCountdown) && this.f134059a == ((PomodoroFocusWithCountdown) obj).f134059a;
            }

            public int hashCode() {
                return Integer.hashCode(this.f134059a);
            }

            public String toString() {
                return "PomodoroFocusWithCountdown(sessionNumber=" + this.f134059a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Premium extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Premium f134060a = new Premium();

            private Premium() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Premium);
            }

            public int hashCode() {
                return -65063773;
            }

            public String toString() {
                return "Premium";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class QuickBlockName extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final QuickBlockName f134061a = new QuickBlockName();

            private QuickBlockName() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof QuickBlockName);
            }

            public int hashCode() {
                return 1704469887;
            }

            public String toString() {
                return "QuickBlockName";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Schedules extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Schedules f134062a = new Schedules();

            private Schedules() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Schedules);
            }

            public int hashCode() {
                return -1467628536;
            }

            public String toString() {
                return "Schedules";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Skip extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Skip f134063a = new Skip();

            private Skip() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Skip);
            }

            public int hashCode() {
                return 1860305587;
            }

            public String toString() {
                return "Skip";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Start extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Start f134064a = new Start();

            private Start() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Start);
            }

            public int hashCode() {
                return 1835158958;
            }

            public String toString() {
                return "Start";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Stop extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Stop f134065a = new Stop();

            private Stop() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Stop);
            }

            public int hashCode() {
                return 1860314422;
            }

            public String toString() {
                return "Stop";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Time1h extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Time1h f134066a = new Time1h();

            private Time1h() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Time1h);
            }

            public int hashCode() {
                return 1074166296;
            }

            public String toString() {
                return "Time1h";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Time24h extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Time24h f134067a = new Time24h();

            private Time24h() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Time24h);
            }

            public int hashCode() {
                return -1060583739;
            }

            public String toString() {
                return "Time24h";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Time25m extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Time25m f134068a = new Time25m();

            private Time25m() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Time25m);
            }

            public int hashCode() {
                return -1060583703;
            }

            public String toString() {
                return "Time25m";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Timer extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Timer f134069a = new Timer();

            private Timer() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Timer);
            }

            public int hashCode() {
                return 1835765905;
            }

            public String toString() {
                return "Timer";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TimerAndPomodoro extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final TimerAndPomodoro f134070a = new TimerAndPomodoro();

            private TimerAndPomodoro() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof TimerAndPomodoro);
            }

            public int hashCode() {
                return -1322140401;
            }

            public String toString() {
                return "TimerAndPomodoro";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TimerFormatCountDown extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final TimerFormatCountDown f134071a = new TimerFormatCountDown();

            private TimerFormatCountDown() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof TimerFormatCountDown);
            }

            public int hashCode() {
                return 1639107401;
            }

            public String toString() {
                return "TimerFormatCountDown";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WidgetOnlyForPremium extends WidgetString {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final WidgetOnlyForPremium f134072a = new WidgetOnlyForPremium();

            private WidgetOnlyForPremium() {
                super(null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof WidgetOnlyForPremium);
            }

            public int hashCode() {
                return -1463157070;
            }

            public String toString() {
                return "WidgetOnlyForPremium";
            }
        }

        public /* synthetic */ WidgetString(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private WidgetString() {
        }
    }

    static /* synthetic */ Intent b(WidgetDataProvider widgetDataProvider, Context context, Long l3, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScheduleActivity");
        }
        if ((i3 & 2) != 0) {
            l3 = null;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return widgetDataProvider.p(context, l3, z2);
    }

    static /* synthetic */ Intent h(WidgetDataProvider widgetDataProvider, Context context, WidgetQuickTimer widgetQuickTimer, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQuickBlockSetupActivityIntent");
        }
        if ((i3 & 2) != 0) {
            widgetQuickTimer = null;
        }
        return widgetDataProvider.g(context, widgetQuickTimer);
    }

    static /* synthetic */ Intent n(WidgetDataProvider widgetDataProvider, Context context, boolean z2, boolean z3, boolean z4, WidgetQuickTimer widgetQuickTimer, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQuickBlockDetailActivityIntent");
        }
        if ((i3 & 16) != 0) {
            widgetQuickTimer = null;
        }
        return widgetDataProvider.c(context, z2, z3, z4, widgetQuickTimer);
    }

    boolean a(int i3);

    Intent c(Context context, boolean z2, boolean z3, boolean z4, WidgetQuickTimer widgetQuickTimer);

    long d(WidgetColor widgetColor);

    void e(WidgetQuickTimer widgetQuickTimer);

    Intent f(Context context);

    Intent g(Context context, WidgetQuickTimer widgetQuickTimer);

    void i();

    void j();

    String k(WidgetString widgetString);

    int l(WidgetIcon widgetIcon);

    Intent m(Context context, WidgetPremiumFeature widgetPremiumFeature);

    void o(Throwable th);

    Intent p(Context context, Long l3, boolean z2);
}
