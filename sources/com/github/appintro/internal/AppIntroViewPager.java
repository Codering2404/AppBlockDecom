package com.github.appintro.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.AppIntroBase;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.AppIntroViewPagerListener;
import com.github.appintro.internal.viewpager.ViewPagerTransformer;
import java.lang.reflect.Field;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppIntroViewPager extends ViewPager {
    private static final Companion Companion = new Companion(null);
    private static final int ON_ILLEGALLY_REQUESTED_NEXT_PAGE_MAX_INTERVAL = 1000;
    private float currentTouchDownX;
    private float currentTouchDownY;
    private ScrollerCustomDuration customScroller;
    private long illegallyRequestedNextPageLastCalled;
    private boolean isFullPagingEnabled;
    private boolean isPermissionSlide;
    private AppIntroViewPagerListener onNextPageRequestedListener;
    private ViewPager.OnPageChangeListener pageChangeListener;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppIntroViewPager(Context context, AttributeSet attrs) throws IllegalAccessException {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isFullPagingEnabled = true;
        try {
            Field scroller = ViewPager.class.getDeclaredField("mScroller");
            Intrinsics.checkNotNullExpressionValue(scroller, "scroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            Intrinsics.checkNotNullExpressionValue(interpolator, "interpolator");
            interpolator.setAccessible(true);
            Object obj = interpolator.get(null);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.animation.Interpolator");
            }
            ScrollerCustomDuration scrollerCustomDuration = new ScrollerCustomDuration(context, (Interpolator) obj);
            this.customScroller = scrollerCustomDuration;
            scroller.set(this, scrollerCustomDuration);
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    private final boolean handleTouchEvent(MotionEvent motionEvent) {
        AppIntroViewPagerListener appIntroViewPagerListener;
        AppIntroViewPagerListener appIntroViewPagerListener2;
        if (!this.isFullPagingEnabled) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            if (motionEvent.getAction() == 1) {
                performClick();
            }
            AppIntroViewPagerListener appIntroViewPagerListener3 = this.onNextPageRequestedListener;
            if (!(appIntroViewPagerListener3 != null ? appIntroViewPagerListener3.onCanRequestNextPage() : true) && isSwipeForward(this.currentTouchDownX, motionEvent.getX())) {
                if (userIllegallyRequestNextPage() && (appIntroViewPagerListener2 = this.onNextPageRequestedListener) != null) {
                    appIntroViewPagerListener2.onIllegallyRequestedNextPage();
                }
                return false;
            }
            if (this.isPermissionSlide && isSwipeForward(this.currentTouchDownX, motionEvent.getX()) && (appIntroViewPagerListener = this.onNextPageRequestedListener) != null) {
                appIntroViewPagerListener.onUserRequestedPermissionsDialog();
            }
        } else {
            this.currentTouchDownX = motionEvent.getX();
            this.currentTouchDownY = motionEvent.getY();
        }
        return this.isFullPagingEnabled;
    }

    private final boolean isSwipeForward(float f3, float f4) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return LayoutUtil.isRtl(context) ? f4 > f3 : f3 > f4;
    }

    private final boolean userIllegallyRequestNextPage() {
        if (System.currentTimeMillis() - this.illegallyRequestedNextPageLastCalled < 1000) {
            return false;
        }
        this.illegallyRequestedNextPageLastCalled = System.currentTimeMillis();
        return true;
    }

    public final void addOnPageChangeListener$appintro_release(AppIntroBase.OnPageChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.addOnPageChangeListener(listener);
        this.pageChangeListener = listener;
    }

    public final int getCurrentSlideNumber(int i3) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return LayoutUtil.isRtl(context) ? i3 - getCurrentItem() : getCurrentItem() + 1;
    }

    public final AppIntroViewPagerListener getOnNextPageRequestedListener() {
        return this.onNextPageRequestedListener;
    }

    public final void goToNextSlide() {
        int currentItem = getCurrentItem();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setCurrentItem(currentItem + (!LayoutUtil.isRtl(context) ? 1 : -1));
    }

    public final void goToPreviousSlide() {
        int currentItem = getCurrentItem();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setCurrentItem(currentItem + (!LayoutUtil.isRtl(context) ? -1 : 1));
    }

    public final boolean isFirstSlide(int i3) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return LayoutUtil.isRtl(context) ? (getCurrentItem() - i3) + 1 == 0 : getCurrentItem() == 0;
    }

    public final boolean isFullPagingEnabled() {
        return this.isFullPagingEnabled;
    }

    public final boolean isLastSlide(int i3) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return LayoutUtil.isRtl(context) ? getCurrentItem() == 0 : (getCurrentItem() - i3) + 1 == 0;
    }

    public final boolean isPermissionSlide() {
        return this.isPermissionSlide;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (handleTouchEvent(event)) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (handleTouchEvent(event)) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void reCenterCurrentSlide$appintro_release() {
        int currentItem = getCurrentItem();
        setCurrentItem(Math.max(currentItem - 1, 0), false);
        setCurrentItem(currentItem, false);
    }

    public final void setAppIntroPageTransformer(AppIntroPageTransformerType appIntroTransformer) {
        Intrinsics.checkNotNullParameter(appIntroTransformer, "appIntroTransformer");
        setPageTransformer(true, new ViewPagerTransformer(appIntroTransformer));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        int currentItem = super.getCurrentItem();
        super.setCurrentItem(i3);
        if (currentItem == 0 && i3 == 0 && (onPageChangeListener = this.pageChangeListener) != null) {
            onPageChangeListener.onPageSelected(0);
        }
    }

    public final void setFullPagingEnabled(boolean z2) {
        this.isFullPagingEnabled = z2;
    }

    public final void setOnNextPageRequestedListener(AppIntroViewPagerListener appIntroViewPagerListener) {
        this.onNextPageRequestedListener = appIntroViewPagerListener;
    }

    public final void setPermissionSlide(boolean z2) {
        this.isPermissionSlide = z2;
    }

    public final void setScrollDurationFactor(double d3) {
        ScrollerCustomDuration scrollerCustomDuration = this.customScroller;
        if (scrollerCustomDuration != null) {
            scrollerCustomDuration.setScrollDurationFactor(d3);
        }
    }
}
