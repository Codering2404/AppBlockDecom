package cz.mobilesoft.coreblock.scene.more.academy;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.LayoutLessonCardBinding;
import cz.mobilesoft.coreblock.scene.more.academy.LessonCardView;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyLessonUnavailableActivity;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
public final class LessonCardView extends MaterialCardView {
    private long A;
    private boolean B;
    private final LayoutLessonCardBinding C;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private MaterialButton f106092t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CountDownTimer f106093u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Function0 f106094v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Function0 f106095w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private LessonDTO f106096x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private LessonCardState f106097y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f106098z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CourseDTO {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f106099f = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f106100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AcademyCourseState f106101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f106102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f106103d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f106104e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final CourseDTO a(AcademyCourseEntity course) {
                Intrinsics.checkNotNullParameter(course, "course");
                return new CourseDTO(course.c(), course.a(), course.b(), course.f(), course.d());
            }

            private Companion() {
            }
        }

        public CourseDTO(long j3, AcademyCourseState state, String iconUrl, String title, String lead) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(lead, "lead");
            this.f106100a = j3;
            this.f106101b = state;
            this.f106102c = iconUrl;
            this.f106103d = title;
            this.f106104e = lead;
        }

        public final String a() {
            return this.f106102c;
        }

        public final long b() {
            return this.f106100a;
        }

        public final String c() {
            return this.f106104e;
        }

        public final AcademyCourseState d() {
            return this.f106101b;
        }

        public final String e() {
            return this.f106103d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourseDTO)) {
                return false;
            }
            CourseDTO courseDTO = (CourseDTO) obj;
            return this.f106100a == courseDTO.f106100a && this.f106101b == courseDTO.f106101b && Intrinsics.areEqual(this.f106102c, courseDTO.f106102c) && Intrinsics.areEqual(this.f106103d, courseDTO.f106103d) && Intrinsics.areEqual(this.f106104e, courseDTO.f106104e);
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.f106100a) * 31) + this.f106101b.hashCode()) * 31) + this.f106102c.hashCode()) * 31) + this.f106103d.hashCode()) * 31) + this.f106104e.hashCode();
        }

        public String toString() {
            return "CourseDTO(id=" + this.f106100a + ", state=" + this.f106101b + ", iconUrl=" + this.f106102c + ", title=" + this.f106103d + ", lead=" + this.f106104e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LessonDTO {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Companion f106105j = new Companion(null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f106106k = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f106107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f106108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AcademyLessonState f106109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f106110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f106111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f106112f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final CourseDTO f106113g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private LessonCardState f106114h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f106115i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LessonDTO a(AcademyLessonEntity lesson, AcademyCourseEntity course, LessonCardState viewState, boolean z2) {
                Intrinsics.checkNotNullParameter(lesson, "lesson");
                Intrinsics.checkNotNullParameter(course, "course");
                Intrinsics.checkNotNullParameter(viewState, "viewState");
                return new LessonDTO(lesson.d(), lesson.g(), lesson.f(), lesson.h(), lesson.e(), lesson.i(), CourseDTO.f106099f.a(course), viewState, z2);
            }

            private Companion() {
            }
        }

        public LessonDTO(long j3, int i3, AcademyLessonState state, String title, String lead, long j4, CourseDTO course, LessonCardState viewState, boolean z2) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(lead, "lead");
            Intrinsics.checkNotNullParameter(course, "course");
            Intrinsics.checkNotNullParameter(viewState, "viewState");
            this.f106107a = j3;
            this.f106108b = i3;
            this.f106109c = state;
            this.f106110d = title;
            this.f106111e = lead;
            this.f106112f = j4;
            this.f106113g = course;
            this.f106114h = viewState;
            this.f106115i = z2;
        }

        public final CourseDTO a() {
            return this.f106113g;
        }

        public final long b() {
            return this.f106107a;
        }

        public final String c() {
            return this.f106111e;
        }

        public final int d() {
            return this.f106108b;
        }

        public final AcademyLessonState e() {
            return this.f106109c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LessonDTO)) {
                return false;
            }
            LessonDTO lessonDTO = (LessonDTO) obj;
            return this.f106107a == lessonDTO.f106107a && this.f106108b == lessonDTO.f106108b && this.f106109c == lessonDTO.f106109c && Intrinsics.areEqual(this.f106110d, lessonDTO.f106110d) && Intrinsics.areEqual(this.f106111e, lessonDTO.f106111e) && this.f106112f == lessonDTO.f106112f && Intrinsics.areEqual(this.f106113g, lessonDTO.f106113g) && this.f106114h == lessonDTO.f106114h && this.f106115i == lessonDTO.f106115i;
        }

        public final String f() {
            return this.f106110d;
        }

        public final long g() {
            return this.f106112f;
        }

        public final LessonCardState h() {
            return this.f106114h;
        }

        public int hashCode() {
            return (((((((((((((((Long.hashCode(this.f106107a) * 31) + Integer.hashCode(this.f106108b)) * 31) + this.f106109c.hashCode()) * 31) + this.f106110d.hashCode()) * 31) + this.f106111e.hashCode()) * 31) + Long.hashCode(this.f106112f)) * 31) + this.f106113g.hashCode()) * 31) + this.f106114h.hashCode()) * 31) + Boolean.hashCode(this.f106115i);
        }

        public final boolean i() {
            return this.f106115i;
        }

        public final void j(long j3) {
            this.f106112f = j3;
        }

        public final void k(LessonCardState lessonCardState) {
            Intrinsics.checkNotNullParameter(lessonCardState, "<set-?>");
            this.f106114h = lessonCardState;
        }

        public String toString() {
            return "LessonDTO(id=" + this.f106107a + ", order=" + this.f106108b + ", state=" + this.f106109c + ", title=" + this.f106110d + ", lead=" + this.f106111e + ", unlockedAt=" + this.f106112f + ", course=" + this.f106113g + ", viewState=" + this.f106114h + ", isOneTimePremiumOnlyActive=" + this.f106115i + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f106116a;

        static {
            int[] iArr = new int[LessonCardState.values().length];
            try {
                iArr[LessonCardState.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LessonCardState.CURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LessonCardState.FUTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LessonCardState.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LessonCardState.LOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f106116a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LessonCardView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f106097y = LessonCardState.AVAILABLE;
        LayoutLessonCardBinding layoutLessonCardBindingC = LayoutLessonCardBinding.c(LayoutInflater.from(context), this, false);
        Intrinsics.checkNotNullExpressionValue(layoutLessonCardBindingC, "inflate(...)");
        this.C = layoutLessonCardBindingC;
        addView(layoutLessonCardBindingC.getRoot());
        layoutLessonCardBindingC.f96791c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LessonCardView.q(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Context context, View view) {
        AnswersHelper.f128199a.G();
        context.startActivity(AcademyLessonUnavailableActivity.f106231t.a(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(LessonCardView lessonCardView, View view) {
        Function0 function0 = lessonCardView.f106094v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(LessonCardView lessonCardView, View view) {
        Function0 function0 = lessonCardView.f106094v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void u() {
        CountDownTimer countDownTimer = this.f106093u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Button explanationButton = this.C.f96791c;
        Intrinsics.checkNotNullExpressionValue(explanationButton, "explanationButton");
        explanationButton.setVisibility(8);
    }

    private final void v() {
        boolean z2;
        CountDownTimer countDownTimer = this.f106093u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        long jF = TimeHelperExt.f128663a.f();
        Button explanationButton = this.C.f96791c;
        Intrinsics.checkNotNullExpressionValue(explanationButton, "explanationButton");
        long j3 = this.A;
        if (j3 == 0 || j3 <= jF) {
            z2 = false;
        } else {
            final long j4 = j3 - jF;
            this.f106093u = new CountDownTimer(j4) { // from class: cz.mobilesoft.coreblock.scene.more.academy.LessonCardView$initCountDownTimer$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    this.f106117a.setState(LessonCardView.LessonCardState.CURRENT);
                    Function0<Unit> onUnlocked = this.f106117a.getOnUnlocked();
                    if (onUnlocked != null) {
                        onUnlocked.invoke();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j5) {
                    MaterialButton materialButton = this.f106117a.f106092t;
                    if (materialButton != null) {
                        materialButton.setText(this.f106117a.getContext().getString(R.string.Ii, DateHelper.k(this.f106117a.getContext(), j5)));
                    }
                }
            }.start();
            z2 = true;
        }
        explanationButton.setVisibility(z2 ? 0 : 8);
    }

    public final LayoutLessonCardBinding getBinding() {
        return this.C;
    }

    public final LessonDTO getLesson() {
        return this.f106096x;
    }

    public final Integer getNumber() {
        return StringsKt.u(this.C.f96794f.getText().toString());
    }

    public final Function0<Unit> getOnButtonClick() {
        return this.f106094v;
    }

    public final Function0<Unit> getOnUnlocked() {
        return this.f106095w;
    }

    public final LessonCardState getState() {
        return this.f106097y;
    }

    public final String getSubtitle() {
        CharSequence text = this.C.f96795g.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final String getSummary() {
        CharSequence text = this.C.f96796h.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final String getTitle() {
        CharSequence text = this.C.f96797i.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final long getUnlockedAt() {
        return this.A;
    }

    @Override // com.google.android.material.card.MaterialCardView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f106097y == LessonCardState.FUTURE) {
            v();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public final void setLesson(LessonDTO lessonDTO) {
        this.f106096x = lessonDTO;
        if (lessonDTO != null) {
            setState(lessonDTO.h());
            setTitle(lessonDTO.f());
            setSummary(lessonDTO.c());
            setUnlockedAt(lessonDTO.g());
            setStarted(lessonDTO.a().d() == AcademyCourseState.CURRENT);
            setOneTimePremiumOnlyActive(lessonDTO.i());
        }
    }

    public final void setNumber(Integer num) {
        this.C.f96794f.setText(num != null ? String.valueOf(num.intValue()) : null);
    }

    public final void setOnButtonClick(Function0<Unit> function0) {
        this.f106094v = function0;
    }

    public final void setOnUnlocked(Function0<Unit> function0) {
        this.f106095w = function0;
    }

    public final void setOneTimePremiumOnlyActive(boolean z2) {
        MaterialButton materialButton;
        if (this.f106097y == LessonCardState.LOCKED && (materialButton = this.f106092t) != null) {
            materialButton.setText(z2 ? R.string.Ie : R.string.Me);
        }
        this.B = z2;
    }

    public final void setStarted(boolean z2) {
        if (this.f106097y == LessonCardState.CURRENT) {
            if (z2) {
                MaterialButton materialButton = this.f106092t;
                if (materialButton != null) {
                    materialButton.setText(R.string.l8);
                }
            } else {
                MaterialButton materialButton2 = this.f106092t;
                if (materialButton2 != null) {
                    materialButton2.setText(R.string.J7);
                }
            }
        }
        this.f106098z = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setState(cz.mobilesoft.coreblock.scene.more.academy.LessonCardView.LessonCardState r13) {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.academy.LessonCardView.setState(cz.mobilesoft.coreblock.scene.more.academy.LessonCardView$LessonCardState):void");
    }

    public final void setSubtitle(String str) {
        this.C.f96795g.setText(str);
        TextView text1 = this.C.f96795g;
        Intrinsics.checkNotNullExpressionValue(text1, "text1");
        text1.setVisibility(str != null && this.f106097y.getCardSubtitleColor() != null ? 0 : 8);
    }

    public final void setSummary(String str) {
        this.C.f96796h.setText(str);
        TextView text2 = this.C.f96796h;
        Intrinsics.checkNotNullExpressionValue(text2, "text2");
        text2.setVisibility(str != null && this.f106097y.getCardSummaryColor() != null ? 0 : 8);
    }

    public final void setTitle(String str) {
        this.C.f96797i.setText(str);
    }

    public final void setUnlockedAt(long j3) {
        this.A = j3;
        if (this.f106097y == LessonCardState.FUTURE) {
            v();
        }
    }

    public final void setTitle(int i3) {
        this.C.f96797i.setText(i3);
    }

    public final void setSummary(int i3) {
        this.C.f96796h.setText(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LessonCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f95434a);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LessonCardView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LessonCardState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LessonCardState[] $VALUES;
        public static final LessonCardState AVAILABLE;
        public static final LessonCardState COMPLETE;
        public static final LessonCardState CURRENT;
        public static final Companion Companion;
        public static final LessonCardState FUTURE;
        public static final LessonCardState LOCKED;
        private static final Lazy<Map<Integer, LessonCardState>> valuesById$delegate;
        private final Integer buttonLayout;
        private final int cardBackgroundColor;
        private final Integer cardElevation;
        private final Integer cardNumberBackgroundColor;
        private final Integer cardNumberColor;
        private final Integer cardStrokeColor;
        private final Integer cardSubtitleColor;
        private final Integer cardSummaryColor;
        private final int cardTitleColor;
        private final int id;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map c() {
                return (Map) LessonCardState.valuesById$delegate.getValue();
            }

            public final LessonCardState a(AcademyLessonState lessonState) {
                Intrinsics.checkNotNullParameter(lessonState, "lessonState");
                return b(lessonState.getId());
            }

            public final LessonCardState b(int i3) {
                LessonCardState lessonCardState = (LessonCardState) c().get(Integer.valueOf(i3));
                return lessonCardState == null ? LessonCardState.AVAILABLE : lessonCardState;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ LessonCardState[] $values() {
            return new LessonCardState[]{AVAILABLE, CURRENT, FUTURE, COMPLETE, LOCKED};
        }

        /* JADX WARN: Multi-variable type inference failed */
        static {
            int id = AcademyLessonState.AVAILABLE.getId();
            Integer numValueOf = Integer.valueOf(R.color.f95461p);
            int i3 = R.color.f95457l;
            AVAILABLE = new LessonCardState("AVAILABLE", 0, id, null, 0, null, 0, null, null, numValueOf, Integer.valueOf(i3), null, 638, null);
            int id2 = AcademyLessonState.CURRENT.getId();
            int i4 = R.dimen.f95479m;
            Integer numValueOf2 = Integer.valueOf(i4);
            int i5 = R.color.f95446a;
            int i6 = R.color.f95466u;
            CURRENT = new LessonCardState("CURRENT", 1, id2, numValueOf2, i5, null, i6, Integer.valueOf(i6), Integer.valueOf(i6), Integer.valueOf(i6), Integer.valueOf(i6), Integer.valueOf(R.layout.f95689c0), 8, null);
            int id3 = AcademyLessonState.FUTURE.getId();
            Integer numValueOf3 = Integer.valueOf(i4);
            int i7 = R.color.f95459n;
            int i8 = R.color.f95456k;
            FUTURE = new LessonCardState("FUTURE", 2, id3, numValueOf3, i7, null, i8, Integer.valueOf(i5), Integer.valueOf(i8), Integer.valueOf(i3), Integer.valueOf(i3), Integer.valueOf(R.layout.f95691d0), 8, null);
            COMPLETE = new LessonCardState("COMPLETE", 3, AcademyLessonState.COMPLETE.getId(), Integer.valueOf(i4), i6, null, i3, Integer.valueOf(R.color.f95463r), null, null, null, null, 968, 0 == true ? 1 : 0);
            Integer numValueOf4 = Integer.valueOf(i4);
            int i9 = R.color.f95464s;
            int i10 = R.color.f95465t;
            LOCKED = new LessonCardState("LOCKED", 4, -1, numValueOf4, i9, Integer.valueOf(i10), i8, Integer.valueOf(i10), Integer.valueOf(i8), Integer.valueOf(i10), Integer.valueOf(i8), Integer.valueOf(R.layout.f95693e0));
            LessonCardState[] lessonCardStateArr$values = $values();
            $VALUES = lessonCardStateArr$values;
            $ENTRIES = EnumEntriesKt.a(lessonCardStateArr$values);
            Companion = new Companion(null);
            valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LessonCardView.LessonCardState.valuesById_delegate$lambda$0();
                }
            });
        }

        private LessonCardState(String str, int i3, int i4, Integer num, int i5, Integer num2, int i6, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
            this.id = i4;
            this.cardElevation = num;
            this.cardBackgroundColor = i5;
            this.cardStrokeColor = num2;
            this.cardTitleColor = i6;
            this.cardSubtitleColor = num3;
            this.cardSummaryColor = num4;
            this.cardNumberBackgroundColor = num5;
            this.cardNumberColor = num6;
            this.buttonLayout = num7;
        }

        public static EnumEntries<LessonCardState> getEntries() {
            return $ENTRIES;
        }

        public static LessonCardState valueOf(String str) {
            return (LessonCardState) Enum.valueOf(LessonCardState.class, str);
        }

        public static LessonCardState[] values() {
            return (LessonCardState[]) $VALUES.clone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map valuesById_delegate$lambda$0() {
            LessonCardState[] lessonCardStateArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(lessonCardStateArrValues.length), 16));
            for (LessonCardState lessonCardState : lessonCardStateArrValues) {
                linkedHashMap.put(Integer.valueOf(lessonCardState.id), lessonCardState);
            }
            return linkedHashMap;
        }

        public final Integer getButtonLayout() {
            return this.buttonLayout;
        }

        public final int getCardBackgroundColor() {
            return this.cardBackgroundColor;
        }

        public final Integer getCardElevation() {
            return this.cardElevation;
        }

        public final Integer getCardNumberBackgroundColor() {
            return this.cardNumberBackgroundColor;
        }

        public final Integer getCardNumberColor() {
            return this.cardNumberColor;
        }

        public final Integer getCardStrokeColor() {
            return this.cardStrokeColor;
        }

        public final Integer getCardSubtitleColor() {
            return this.cardSubtitleColor;
        }

        public final Integer getCardSummaryColor() {
            return this.cardSummaryColor;
        }

        public final int getCardTitleColor() {
            return this.cardTitleColor;
        }

        public final int getId() {
            return this.id;
        }

        /* synthetic */ LessonCardState(String str, int i3, int i4, Integer num, int i5, Integer num2, int i6, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, i4, (i7 & 2) != 0 ? null : num, (i7 & 4) != 0 ? android.R.color.transparent : i5, (i7 & 8) != 0 ? null : num2, (i7 & 16) != 0 ? R.color.f95462q : i6, (i7 & 32) != 0 ? null : num3, (i7 & 64) != 0 ? null : num4, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : num5, (i7 & Function.MAX_NARGS) != 0 ? null : num6, (i7 & 512) != 0 ? null : num7);
        }
    }
}
