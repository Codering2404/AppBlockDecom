package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class PomodoroViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f114136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PomodoroConfiguration.Focus f114137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PomodoroConfiguration.Break f114138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PomodoroConfiguration.Sessions f114139d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f114140f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class PomodoroConfiguration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f114141a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Break extends PomodoroConfiguration {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f114142b;

            public Break(long j3) {
                super(R.string.ko, null);
                this.f114142b = j3;
            }

            @Override // cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewState.PomodoroConfiguration
            public String a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                String strL = DateHelper.l(context, this.f114142b, false);
                Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
                return strL;
            }

            public final Break c(long j3) {
                return new Break(j3);
            }

            public final long d() {
                return this.f114142b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Break) && this.f114142b == ((Break) obj).f114142b;
            }

            public int hashCode() {
                return Long.hashCode(this.f114142b);
            }

            public String toString() {
                return "Break(time=" + this.f114142b + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Focus extends PomodoroConfiguration {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f114143b;

            public Focus(long j3) {
                super(R.string.no, null);
                this.f114143b = j3;
            }

            @Override // cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewState.PomodoroConfiguration
            public String a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                String strL = DateHelper.l(context, this.f114143b, false);
                Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
                return strL;
            }

            public final Focus c(long j3) {
                return new Focus(j3);
            }

            public final long d() {
                return this.f114143b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Focus) && this.f114143b == ((Focus) obj).f114143b;
            }

            public int hashCode() {
                return Long.hashCode(this.f114143b);
            }

            public String toString() {
                return "Focus(time=" + this.f114143b + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Sessions extends PomodoroConfiguration {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f114144b;

            public Sessions(int i3) {
                super(R.string.uo, null);
                this.f114144b = i3;
            }

            @Override // cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewState.PomodoroConfiguration
            public String a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return String.valueOf(this.f114144b);
            }

            public final Sessions c(int i3) {
                return new Sessions(i3);
            }

            public final int d() {
                return this.f114144b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Sessions) && this.f114144b == ((Sessions) obj).f114144b;
            }

            public int hashCode() {
                return Integer.hashCode(this.f114144b);
            }

            public String toString() {
                return "Sessions(sessions=" + this.f114144b + ")";
            }
        }

        public /* synthetic */ PomodoroConfiguration(int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3);
        }

        public abstract String a(Context context);

        public final int b() {
            return this.f114141a;
        }

        private PomodoroConfiguration(int i3) {
            this.f114141a = i3;
        }
    }

    public PomodoroViewState(long j3, PomodoroConfiguration.Focus pomodoroFocus, PomodoroConfiguration.Break pomodoroBreak, PomodoroConfiguration.Sessions pomodoroSessions, List pomodoroHistory) {
        Intrinsics.checkNotNullParameter(pomodoroFocus, "pomodoroFocus");
        Intrinsics.checkNotNullParameter(pomodoroBreak, "pomodoroBreak");
        Intrinsics.checkNotNullParameter(pomodoroSessions, "pomodoroSessions");
        Intrinsics.checkNotNullParameter(pomodoroHistory, "pomodoroHistory");
        this.f114136a = j3;
        this.f114137b = pomodoroFocus;
        this.f114138c = pomodoroBreak;
        this.f114139d = pomodoroSessions;
        this.f114140f = pomodoroHistory;
    }

    public static /* synthetic */ PomodoroViewState b(PomodoroViewState pomodoroViewState, long j3, PomodoroConfiguration.Focus focus, PomodoroConfiguration.Break r11, PomodoroConfiguration.Sessions sessions, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = pomodoroViewState.f114136a;
        }
        long j4 = j3;
        if ((i3 & 2) != 0) {
            focus = pomodoroViewState.f114137b;
        }
        PomodoroConfiguration.Focus focus2 = focus;
        if ((i3 & 4) != 0) {
            r11 = pomodoroViewState.f114138c;
        }
        PomodoroConfiguration.Break r4 = r11;
        if ((i3 & 8) != 0) {
            sessions = pomodoroViewState.f114139d;
        }
        PomodoroConfiguration.Sessions sessions2 = sessions;
        if ((i3 & 16) != 0) {
            list = pomodoroViewState.f114140f;
        }
        return pomodoroViewState.a(j4, focus2, r4, sessions2, list);
    }

    public final PomodoroViewState a(long j3, PomodoroConfiguration.Focus pomodoroFocus, PomodoroConfiguration.Break pomodoroBreak, PomodoroConfiguration.Sessions pomodoroSessions, List pomodoroHistory) {
        Intrinsics.checkNotNullParameter(pomodoroFocus, "pomodoroFocus");
        Intrinsics.checkNotNullParameter(pomodoroBreak, "pomodoroBreak");
        Intrinsics.checkNotNullParameter(pomodoroSessions, "pomodoroSessions");
        Intrinsics.checkNotNullParameter(pomodoroHistory, "pomodoroHistory");
        return new PomodoroViewState(j3, pomodoroFocus, pomodoroBreak, pomodoroSessions, pomodoroHistory);
    }

    public final String c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = DateHelperExtKt.i(context, true, true).format(new Date(TimeHelperExt.f128663a.f() + h()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final PomodoroConfiguration.Break d() {
        return this.f114138c;
    }

    public final PomodoroConfiguration.Focus e() {
        return this.f114137b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PomodoroViewState)) {
            return false;
        }
        PomodoroViewState pomodoroViewState = (PomodoroViewState) obj;
        return this.f114136a == pomodoroViewState.f114136a && Intrinsics.areEqual(this.f114137b, pomodoroViewState.f114137b) && Intrinsics.areEqual(this.f114138c, pomodoroViewState.f114138c) && Intrinsics.areEqual(this.f114139d, pomodoroViewState.f114139d) && Intrinsics.areEqual(this.f114140f, pomodoroViewState.f114140f);
    }

    public final List f() {
        return this.f114140f;
    }

    public final PomodoroConfiguration.Sessions g() {
        return this.f114139d;
    }

    public final long h() {
        return ((this.f114137b.d() + this.f114138c.d()) * ((long) this.f114139d.d())) - this.f114138c.d();
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.f114136a) * 31) + this.f114137b.hashCode()) * 31) + this.f114138c.hashCode()) * 31) + this.f114139d.hashCode()) * 31) + this.f114140f.hashCode();
    }

    public final String i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strL = DateHelper.l(context, h(), false);
        Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
        return strL;
    }

    public String toString() {
        return "PomodoroViewState(time=" + this.f114136a + ", pomodoroFocus=" + this.f114137b + ", pomodoroBreak=" + this.f114138c + ", pomodoroSessions=" + this.f114139d + ", pomodoroHistory=" + this.f114140f + ")";
    }

    public /* synthetic */ PomodoroViewState(long j3, PomodoroConfiguration.Focus focus, PomodoroConfiguration.Break r11, PomodoroConfiguration.Sessions sessions, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? new PomodoroConfiguration.Focus(TimeUnit.MINUTES.toMillis(25L)) : focus, (i3 & 4) != 0 ? new PomodoroConfiguration.Break(TimeUnit.MINUTES.toMillis(5L)) : r11, (i3 & 8) != 0 ? new PomodoroConfiguration.Sessions(4) : sessions, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list);
    }
}
