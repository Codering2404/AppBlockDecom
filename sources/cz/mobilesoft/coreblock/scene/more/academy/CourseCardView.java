package cz.mobilesoft.coreblock.scene.more.academy;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.LayoutCourseCardBinding;
import cz.mobilesoft.coreblock.scene.more.academy.CourseCardView;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class CourseCardView extends MaterialCardView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CountDownTimer f106071t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CourseDTO f106072u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CourseCardState f106073v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f106074w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f106075x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private LayoutCourseCardBinding f106076y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Companion f106070z = new Companion(null);
    public static final int A = 8;
    private static final int[] B = {R.attr.f95436c};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CourseCardState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CourseCardState[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<Integer, CourseCardState>> valuesById$delegate;
        private final Integer iconRes;
        private final int id;
        private final int textColorRes;
        public static final CourseCardState AVAILABLE = new CourseCardState("AVAILABLE", 0, AcademyCourseState.AVAILABLE.getId(), null, 0, 6, null);
        public static final CourseCardState CURRENT = new CourseCardState("CURRENT", 1, AcademyCourseState.CURRENT.getId(), Integer.valueOf(R.drawable.J1), R.color.f95446a);
        public static final CourseCardState PAUSED = new CourseCardState("PAUSED", 2, AcademyCourseState.PAUSED.getId(), Integer.valueOf(R.drawable.L1), R.color.f95455j);
        public static final CourseCardState COMPLETE = new CourseCardState("COMPLETE", 3, AcademyCourseState.COMPLETE.getId(), Integer.valueOf(R.drawable.I1), R.color.f95463r);
        public static final CourseCardState LOCKED = new CourseCardState("LOCKED", 4, -1, Integer.valueOf(R.drawable.K1), 0, 4, null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map c() {
                return (Map) CourseCardState.valuesById$delegate.getValue();
            }

            public final CourseCardState a(AcademyCourseState courseState) {
                Intrinsics.checkNotNullParameter(courseState, "courseState");
                return b(courseState.getId());
            }

            public final CourseCardState b(int i3) {
                CourseCardState courseCardState = (CourseCardState) c().get(Integer.valueOf(i3));
                return courseCardState == null ? CourseCardState.AVAILABLE : courseCardState;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ CourseCardState[] $values() {
            return new CourseCardState[]{AVAILABLE, CURRENT, PAUSED, COMPLETE, LOCKED};
        }

        static {
            CourseCardState[] courseCardStateArr$values = $values();
            $VALUES = courseCardStateArr$values;
            $ENTRIES = EnumEntriesKt.a(courseCardStateArr$values);
            Companion = new Companion(null);
            valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CourseCardView.CourseCardState.valuesById_delegate$lambda$0();
                }
            });
        }

        private CourseCardState(String str, int i3, int i4, Integer num, int i5) {
            this.id = i4;
            this.iconRes = num;
            this.textColorRes = i5;
        }

        public static EnumEntries<CourseCardState> getEntries() {
            return $ENTRIES;
        }

        public static CourseCardState valueOf(String str) {
            return (CourseCardState) Enum.valueOf(CourseCardState.class, str);
        }

        public static CourseCardState[] values() {
            return (CourseCardState[]) $VALUES.clone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map valuesById_delegate$lambda$0() {
            CourseCardState[] courseCardStateArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(courseCardStateArrValues.length), 16));
            for (CourseCardState courseCardState : courseCardStateArrValues) {
                linkedHashMap.put(Integer.valueOf(courseCardState.id), courseCardState);
            }
            return linkedHashMap;
        }

        public final Integer getIconRes() {
            return this.iconRes;
        }

        public final int getId() {
            return this.id;
        }

        public final int getTextColorRes() {
            return this.textColorRes;
        }

        /* synthetic */ CourseCardState(String str, int i3, int i4, Integer num, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, i4, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? R.color.f95456k : i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CourseDTO {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Companion f106077h = new Companion(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f106078i = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f106079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AcademyCourseState f106080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f106081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f106082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f106083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f106084f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CourseCardState f106085g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final CourseDTO a(AcademyCourseEntity course, List lessons, CourseCardState viewState) {
                Intrinsics.checkNotNullParameter(course, "course");
                Intrinsics.checkNotNullParameter(lessons, "lessons");
                Intrinsics.checkNotNullParameter(viewState, "viewState");
                long jC = course.c();
                AcademyCourseState academyCourseStateA = course.a();
                String strB = course.b();
                String strF = course.f();
                String strD = course.d();
                List list = lessons;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(LessonDTO.f106086d.a((AcademyLessonEntity) it.next()));
                }
                return new CourseDTO(jC, academyCourseStateA, strB, strF, strD, arrayList, viewState);
            }

            private Companion() {
            }
        }

        public CourseDTO(long j3, AcademyCourseState state, String iconUrl, String title, String lead, List lessons, CourseCardState viewState) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(lead, "lead");
            Intrinsics.checkNotNullParameter(lessons, "lessons");
            Intrinsics.checkNotNullParameter(viewState, "viewState");
            this.f106079a = j3;
            this.f106080b = state;
            this.f106081c = iconUrl;
            this.f106082d = title;
            this.f106083e = lead;
            this.f106084f = lessons;
            this.f106085g = viewState;
        }

        public final String a() {
            return this.f106081c;
        }

        public final long b() {
            return this.f106079a;
        }

        public final String c() {
            return this.f106083e;
        }

        public final List d() {
            return this.f106084f;
        }

        public final AcademyCourseState e() {
            return this.f106080b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourseDTO)) {
                return false;
            }
            CourseDTO courseDTO = (CourseDTO) obj;
            return this.f106079a == courseDTO.f106079a && this.f106080b == courseDTO.f106080b && Intrinsics.areEqual(this.f106081c, courseDTO.f106081c) && Intrinsics.areEqual(this.f106082d, courseDTO.f106082d) && Intrinsics.areEqual(this.f106083e, courseDTO.f106083e) && Intrinsics.areEqual(this.f106084f, courseDTO.f106084f) && this.f106085g == courseDTO.f106085g;
        }

        public final String f() {
            return this.f106082d;
        }

        public final CourseCardState g() {
            return this.f106085g;
        }

        public int hashCode() {
            return (((((((((((Long.hashCode(this.f106079a) * 31) + this.f106080b.hashCode()) * 31) + this.f106081c.hashCode()) * 31) + this.f106082d.hashCode()) * 31) + this.f106083e.hashCode()) * 31) + this.f106084f.hashCode()) * 31) + this.f106085g.hashCode();
        }

        public String toString() {
            return "CourseDTO(id=" + this.f106079a + ", state=" + this.f106080b + ", iconUrl=" + this.f106081c + ", title=" + this.f106082d + ", lead=" + this.f106083e + ", lessons=" + this.f106084f + ", viewState=" + this.f106085g + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LessonDTO {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f106086d = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f106087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AcademyLessonState f106088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f106089c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LessonDTO a(AcademyLessonEntity lesson) {
                Intrinsics.checkNotNullParameter(lesson, "lesson");
                return new LessonDTO(lesson.d(), lesson.f(), lesson.i());
            }

            private Companion() {
            }
        }

        public LessonDTO(long j3, AcademyLessonState state, long j4) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.f106087a = j3;
            this.f106088b = state;
            this.f106089c = j4;
        }

        public final AcademyLessonState a() {
            return this.f106088b;
        }

        public final long b() {
            return this.f106089c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LessonDTO)) {
                return false;
            }
            LessonDTO lessonDTO = (LessonDTO) obj;
            return this.f106087a == lessonDTO.f106087a && this.f106088b == lessonDTO.f106088b && this.f106089c == lessonDTO.f106089c;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f106087a) * 31) + this.f106088b.hashCode()) * 31) + Long.hashCode(this.f106089c);
        }

        public String toString() {
            return "LessonDTO(id=" + this.f106087a + ", state=" + this.f106088b + ", unlockedAt=" + this.f106089c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f106090a;

        static {
            int[] iArr = new int[CourseCardState.values().length];
            try {
                iArr[CourseCardState.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CourseCardState.CURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CourseCardState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CourseCardState.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CourseCardState.LOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f106090a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CourseCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        CourseCardState courseCardState = CourseCardState.AVAILABLE;
        this.f106073v = courseCardState;
        this.f106074w = 1;
        this.f106075x = 1;
        LayoutCourseCardBinding layoutCourseCardBindingC = LayoutCourseCardBinding.c(LayoutInflater.from(context), this, false);
        Intrinsics.checkNotNullExpressionValue(layoutCourseCardBindingC, "inflate(...)");
        this.f106076y = layoutCourseCardBindingC;
        addView(layoutCourseCardBindingC.getRoot());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.f95925m0, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                setState(CourseCardState.Companion.b(typedArrayObtainStyledAttributes.getInt(R.styleable.f95929n0, courseCardState.getId())));
                setTitle(typedArrayObtainStyledAttributes.getString(R.styleable.f95937p0));
                setSummary(typedArrayObtainStyledAttributes.getString(R.styleable.f95933o0));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private final void n(LessonDTO lessonDTO) {
        CountDownTimer countDownTimer = this.f106071t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        long jF = TimeHelperExt.f128663a.f();
        if (lessonDTO.b() == 0 || lessonDTO.b() <= jF) {
            return;
        }
        final long jB = lessonDTO.b() - jF;
        this.f106071t = new CountDownTimer(jB) { // from class: cz.mobilesoft.coreblock.scene.more.academy.CourseCardView$initCountDownTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                CourseCardView courseCardView = this.f106091a;
                courseCardView.setState(courseCardView.getState());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                this.f106091a.getBinding().f96769f.setText(this.f106091a.getContext().getString(R.string.Hk, DateHelper.k(this.f106091a.getContext(), j3)));
            }
        }.start();
    }

    private final void o() {
        List listD;
        Object next;
        CourseDTO courseDTO = this.f106072u;
        if (courseDTO != null && (listD = courseDTO.d()) != null) {
            Iterator it = listD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                LessonDTO lessonDTO = (LessonDTO) next;
                if (lessonDTO.a() == AcademyLessonState.CURRENT && lessonDTO.b() > TimeHelperExt.c()) {
                    break;
                }
            }
            LessonDTO lessonDTO2 = (LessonDTO) next;
            if (lessonDTO2 != null) {
                n(lessonDTO2);
                return;
            }
        }
        CountDownTimer countDownTimer = this.f106071t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final LayoutCourseCardBinding getBinding() {
        return this.f106076y;
    }

    public final CourseDTO getCourse() {
        return this.f106072u;
    }

    public final int getCurrentLesson() {
        return this.f106074w;
    }

    public final CourseCardState getState() {
        return this.f106073v;
    }

    public final String getSummary() {
        CharSequence text = this.f106076y.f96768e.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final String getTitle() {
        CharSequence text = this.f106076y.f96770g.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final int getTotalLessons() {
        return this.f106075x;
    }

    @Override // com.google.android.material.card.MaterialCardView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
    }

    @Override // com.google.android.material.card.MaterialCardView, android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        View.mergeDrawableStates(iArrOnCreateDrawableState, B);
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.f106071t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void setBinding(LayoutCourseCardBinding layoutCourseCardBinding) {
        Intrinsics.checkNotNullParameter(layoutCourseCardBinding, "<set-?>");
        this.f106076y = layoutCourseCardBinding;
    }

    public final void setCourse(CourseDTO courseDTO) {
        int iNextIndex;
        this.f106072u = courseDTO;
        if (courseDTO != null) {
            setState(courseDTO.g());
            setTitle(courseDTO.f());
            setSummary(courseDTO.c());
            this.f106075x = courseDTO.d().size();
            List listD = courseDTO.d();
            ListIterator listIterator = listD.listIterator(listD.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                } else if (((LessonDTO) listIterator.previous()).a() == AcademyLessonState.COMPLETE) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            Integer numValueOf = Integer.valueOf(iNextIndex);
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            setCurrentLesson(numValueOf != null ? Integer.valueOf(numValueOf.intValue() + 2).intValue() : 1);
        }
    }

    public final void setCurrentLesson(int i3) {
        this.f106074w = i3;
        int i4 = (i3 - 1) * 100;
        Integer numValueOf = Integer.valueOf(this.f106075x);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = i4 / (numValueOf != null ? numValueOf.intValue() : 1);
        this.f106076y.f96766c.setSecondaryProgress(iIntValue != 0 ? iIntValue + 1 : 0);
        this.f106076y.f96766c.setProgress(iIntValue);
        ProgressBar progress = this.f106076y.f96766c;
        Intrinsics.checkNotNullExpressionValue(progress, "progress");
        progress.setVisibility(iIntValue > 0 ? 0 : 8);
        if (this.f106073v == CourseCardState.CURRENT) {
            this.f106076y.f96769f.setText(getContext().getString(R.string.H7));
        }
    }

    public final void setState(CourseCardState value) {
        boolean z2;
        Intrinsics.checkNotNullParameter(value, "value");
        this.f106073v = value;
        ImageView stateImageView = this.f106076y.f96767d;
        Intrinsics.checkNotNullExpressionValue(stateImageView, "stateImageView");
        Integer iconRes = value.getIconRes();
        if (iconRes != null) {
            this.f106076y.f96767d.setImageResource(iconRes.intValue());
            z2 = true;
        } else {
            z2 = false;
        }
        stateImageView.setVisibility(z2 ? 0 : 8);
        this.f106076y.f96769f.setTextColor(ContextCompat.getColor(getContext(), value.getTextColorRes()));
        int i3 = WhenMappings.f106090a[value.ordinal()];
        String string = null;
        if (i3 != 1) {
            if (i3 == 2) {
                string = getContext().getString(R.string.H7);
            } else if (i3 == 3) {
                string = getContext().getString(R.string.I7);
            } else if (i3 == 4) {
                string = getContext().getString(R.string.E7);
            } else if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        o();
        TextView text2 = this.f106076y.f96769f;
        Intrinsics.checkNotNullExpressionValue(text2, "text2");
        text2.setVisibility(string != null ? 0 : 8);
        this.f106076y.f96769f.setText(string);
    }

    public final void setSummary(String str) {
        this.f106076y.f96768e.setText(str);
    }

    public final void setTitle(String str) {
        this.f106076y.f96770g.setText(str);
    }

    public final void setTotalLessons(int i3) {
        this.f106075x = i3;
    }

    public final void setSummary(int i3) {
        this.f106076y.f96768e.setText(i3);
    }

    public final void setTitle(int i3) {
        this.f106076y.f96770g.setText(i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CourseCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f95434a);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CourseCardView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
