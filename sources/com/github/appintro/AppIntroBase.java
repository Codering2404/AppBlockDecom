package com.github.appintro;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.indicator.DotIndicatorController;
import com.github.appintro.indicator.IndicatorController;
import com.github.appintro.indicator.ProgressIndicatorController;
import com.github.appintro.internal.AppIntroViewPager;
import com.github.appintro.internal.LayoutUtil;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.PermissionWrapper;
import com.github.appintro.internal.viewpager.PagerAdapter;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class AppIntroBase extends AppCompatActivity implements AppIntroViewPagerListener {
    private static final String ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED = "colorTransitionEnabled";
    private static final String ARG_BUNDLE_CURRENT_ITEM = "currentItem";
    private static final String ARG_BUNDLE_IS_BUTTONS_ENABLED = "isButtonsEnabled";
    private static final String ARG_BUNDLE_IS_FULL_PAGING_ENABLED = "isFullPagingEnabled";
    private static final String ARG_BUNDLE_IS_INDICATOR_ENABLED = "isIndicatorEnabled";
    private static final String ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED = "isSkipButtonsEnabled";
    private static final String ARG_BUNDLE_PERMISSION_MAP = "permissionMap";
    private static final String ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED = "retainIsButtonsEnabled";
    private static final String ARG_BUNDLE_SLIDES_NUMBER = "slidesNumber";
    private static final int DEFAULT_SCROLL_DURATION_FACTOR = 1;
    private static final long DEFAULT_VIBRATE_DURATION = 20;
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    private View backButton;
    private View doneButton;
    private ViewGroup indicatorContainer;
    private IndicatorController indicatorController;
    private boolean isColorTransitionsEnabled;
    private boolean isSystemBackButtonLocked;
    private boolean isVibrate;
    private boolean isWizardMode;
    private View nextButton;
    private AppIntroViewPager pager;
    private PagerAdapter pagerAdapter;
    private int savedCurrentItem;
    private View skipButton;
    private int slidesNumber;
    private Vibrator vibrator;
    private static final Companion Companion = new Companion(null);
    private static final String TAG = LogHelper.makeLogTag((Class<?>) AppIntroBase.class);
    private boolean isButtonsEnabled = true;
    private boolean isSkipButtonEnabled = true;
    private boolean isIndicatorEnabled = true;
    private long vibrateDuration = DEFAULT_VIBRATE_DURATION;
    private int currentlySelectedItem = -1;
    private final List<Fragment> fragments = new ArrayList();
    private HashMap<Integer, PermissionWrapper> permissionsMap = new HashMap<>();
    private boolean retainIsButtonsEnabled = true;
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class NextSlideOnClickListener implements View.OnClickListener {
        private boolean isLastSlide;

        public NextSlideOnClickListener(boolean z2) {
            this.isLastSlide = z2;
        }

        public final boolean isLastSlide() {
            return this.isLastSlide;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AppIntroBase.this.dispatchVibration();
            if (!AppIntroBase.this.onCanRequestNextPage()) {
                AppIntroBase.this.onIllegallyRequestedNextPage();
                return;
            }
            if (AppIntroBase.this.shouldRequestPermission()) {
                AppIntroBase.this.requestPermissions();
                return;
            }
            Fragment item = AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem());
            if (this.isLastSlide) {
                AppIntroBase.this.onDonePressed(item);
            } else {
                AppIntroBase.this.onNextPressed(item);
            }
            AppIntroBase.this.goToNextSlide(this.isLastSlide);
        }

        public final void setLastSlide(boolean z2) {
            this.isLastSlide = z2;
        }
    }

    public static final /* synthetic */ AppIntroViewPager access$getPager$p(AppIntroBase appIntroBase) {
        AppIntroViewPager appIntroViewPager = appIntroBase.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        return appIntroViewPager;
    }

    public static final /* synthetic */ PagerAdapter access$getPagerAdapter$p(AppIntroBase appIntroBase) {
        PagerAdapter pagerAdapter = appIntroBase.pagerAdapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        return pagerAdapter;
    }

    public static /* synthetic */ void askForPermissions$default(AppIntroBase appIntroBase, String[] strArr, int i3, boolean z2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: askForPermissions");
        }
        if ((i4 & 4) != 0) {
            z2 = true;
        }
        appIntroBase.askForPermissions(strArr, i3, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchSlideChangedCallbacks(Fragment fragment, Fragment fragment2) {
        if (fragment instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment).onSlideDeselected();
        }
        if (fragment2 instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment2).onSlideSelected();
        }
        onSlideChanged(fragment, fragment2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchVibration() {
        if (this.isVibrate) {
            Vibrator vibrator = this.vibrator;
            if (vibrator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vibrator");
            }
            vibrator.vibrate(this.vibrateDuration);
        }
    }

    private final int getCurrentSlideNumber() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        return appIntroViewPager.getCurrentSlideNumber(this.fragments.size());
    }

    public static /* synthetic */ void goToNextSlide$default(AppIntroBase appIntroBase, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToNextSlide");
        }
        if ((i3 & 1) != 0) {
            AppIntroViewPager appIntroViewPager = appIntroBase.pager;
            if (appIntroViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
            }
            z2 = appIntroViewPager.isLastSlide(appIntroBase.fragments.size());
        }
        appIntroBase.goToNextSlide(z2);
    }

    private final void handleDeniedPermission(String str) {
        if (!ActivityCompat.h(this, str)) {
            onUserDisabledPermission(str);
            return;
        }
        onUserDeniedPermission(str);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper == null || permissionWrapper.getRequired()) {
            return;
        }
        this.permissionsMap.remove(Integer.valueOf(permissionWrapper.getPosition()));
        goToNextSlide$default(this, false, 1, null);
    }

    private final void initializeIndicator() {
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorContainer");
        }
        IndicatorController indicatorController = this.indicatorController;
        viewGroup.addView(indicatorController != null ? indicatorController.newInstance(this) : null);
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.initialize(this.slidesNumber);
        }
        IndicatorController indicatorController3 = this.indicatorController;
        if (indicatorController3 != null) {
            indicatorController3.selectPosition(this.currentlySelectedItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPermissionSlide() {
        HashMap<Integer, PermissionWrapper> map = this.permissionsMap;
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        return map.containsKey(Integer.valueOf(appIntroViewPager.getCurrentSlideNumber(this.fragments.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void performColorTransition(Fragment fragment, Fragment fragment2, float f3) {
        if (!(fragment instanceof SlideBackgroundColorHolder) || !(fragment2 instanceof SlideBackgroundColorHolder)) {
            throw new IllegalStateException("Color transitions are only available if all slides implement SlideBackgroundColorHolder.");
        }
        if (fragment.isAdded() && fragment2.isAdded()) {
            SlideBackgroundColorHolder slideBackgroundColorHolder = (SlideBackgroundColorHolder) fragment;
            SlideBackgroundColorHolder slideBackgroundColorHolder2 = (SlideBackgroundColorHolder) fragment2;
            Object objEvaluate = this.argbEvaluator.evaluate(f3, Integer.valueOf(slideBackgroundColorHolder.getDefaultBackgroundColor()), Integer.valueOf(slideBackgroundColorHolder2.getDefaultBackgroundColor()));
            if (objEvaluate == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int iIntValue = ((Integer) objEvaluate).intValue();
            slideBackgroundColorHolder.setBackgroundColor(iIntValue);
            slideBackgroundColorHolder2.setBackgroundColor(iIntValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPermissions() {
        setSwipeLock(true);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper != null) {
            ActivityCompat.e(this, permissionWrapper.getPermissions(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRequestPermission() {
        return this.permissionsMap.containsKey(Integer.valueOf(getCurrentSlideNumber()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtonsVisibility() {
        boolean z2 = false;
        if (!this.isButtonsEnabled) {
            View view = this.nextButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            }
            AppIntroBaseKt.setVisible(view, false);
            View view2 = this.doneButton;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doneButton");
            }
            AppIntroBaseKt.setVisible(view2, false);
            View view3 = this.backButton;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            AppIntroBaseKt.setVisible(view3, false);
            View view4 = this.skipButton;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipButton");
            }
            AppIntroBaseKt.setVisible(view4, false);
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        boolean zIsLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        boolean zIsFirstSlide = appIntroViewPager2.isFirstSlide(this.fragments.size());
        View view5 = this.nextButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        AppIntroBaseKt.setVisible(view5, !zIsLastSlide);
        View view6 = this.doneButton;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
        }
        AppIntroBaseKt.setVisible(view6, zIsLastSlide);
        View view7 = this.skipButton;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        AppIntroBaseKt.setVisible(view7, this.isSkipButtonEnabled && !zIsLastSlide);
        View view8 = this.backButton;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        if (this.isWizardMode && !zIsFirstSlide) {
            z2 = true;
        }
        AppIntroBaseKt.setVisible(view8, z2);
    }

    protected final void addSlide(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (isRtl$appintro_release()) {
            this.fragments.add(0, fragment);
        } else {
            this.fragments.add(fragment);
        }
        if (this.isWizardMode) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
            }
            appIntroViewPager.setOffscreenPageLimit(this.fragments.size());
        }
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        pagerAdapter.notifyDataSetChanged();
    }

    protected final void askForPermissions(String[] strArr, int i3) {
        askForPermissions$default(this, strArr, i3, false, 4, null);
    }

    protected final IndicatorController getIndicatorController() {
        return this.indicatorController;
    }

    protected abstract int getLayoutId();

    protected final long getVibrateDuration() {
        return this.vibrateDuration;
    }

    protected final void goToNextSlide(boolean z2) {
        if (z2) {
            onIntroFinished();
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.goToNextSlide();
        onNextSlide();
    }

    protected final void goToPreviousSlide() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.goToPreviousSlide();
    }

    protected final boolean isButtonsEnabled() {
        return this.isButtonsEnabled;
    }

    protected final boolean isColorTransitionsEnabled() {
        return this.isColorTransitionsEnabled;
    }

    protected final boolean isIndicatorEnabled() {
        return this.isIndicatorEnabled;
    }

    public final boolean isRtl$appintro_release() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return LayoutUtil.isRtl(applicationContext);
    }

    protected final boolean isSkipButtonEnabled() {
        return this.isSkipButtonEnabled;
    }

    protected final boolean isSystemBackButtonLocked() {
        return this.isSystemBackButtonLocked;
    }

    protected final boolean isVibrate() {
        return this.isVibrate;
    }

    protected final boolean isWizardMode() {
        return this.isWizardMode;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isSystemBackButtonLocked) {
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        if (appIntroViewPager.isFirstSlide(this.fragments.size())) {
            super.onBackPressed();
            return;
        }
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager2.goToPreviousSlide();
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public boolean onCanRequestNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        ActivityResultCaller item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
        if (!(item instanceof SlidePolicy) || ((SlidePolicy) item).isPolicyRespected()) {
            LogHelper.d(TAG, "Change request will be allowed.");
            return true;
        }
        LogHelper.d(TAG, "Slide policy not respected, denying change request.");
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        AppCompatDelegate.P(true);
        super.onCreate(bundle);
        this.indicatorController = new DotIndicatorController(this);
        showStatusBar(false);
        setContentView(getLayoutId());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.indicator_container);
        if (viewGroup == null) {
            throw new IllegalStateException("Missing Indicator Container: R.id.indicator_container");
        }
        this.indicatorContainer = viewGroup;
        View viewFindViewById = findViewById(R.id.next);
        if (viewFindViewById == null) {
            throw new IllegalStateException("Missing Next button: R.id.next");
        }
        this.nextButton = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.done);
        if (viewFindViewById2 == null) {
            throw new IllegalStateException(cJfnYMIyomoWf.izXq);
        }
        this.doneButton = viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.skip);
        if (viewFindViewById3 == null) {
            throw new IllegalStateException("Missing Skip button: R.id.skip");
        }
        this.skipButton = viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.back);
        if (viewFindViewById4 == null) {
            throw new IllegalStateException("Missing Back button: R.id.back");
        }
        this.backButton = viewFindViewById4;
        View view = this.nextButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        TooltipCompat.a(view, getString(R.string.app_intro_next_button));
        View view2 = this.skipButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        if (view2 instanceof ImageButton) {
            View view3 = this.skipButton;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipButton");
            }
            TooltipCompat.a(view3, getString(R.string.app_intro_skip_button));
        }
        View view4 = this.doneButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
        }
        if (view4 instanceof ImageButton) {
            View view5 = this.doneButton;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doneButton");
            }
            TooltipCompat.a(view5, getString(R.string.app_intro_done_button));
        }
        View view6 = this.backButton;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        if (view6 instanceof ImageButton) {
            View view7 = this.backButton;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            TooltipCompat.a(view7, getString(R.string.app_intro_back_button));
        }
        if (isRtl$appintro_release()) {
            View view8 = this.nextButton;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            }
            view8.setScaleX(-1.0f);
            View view9 = this.backButton;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            view9.setScaleX(-1.0f);
        }
        Object systemService = getSystemService("vibrator");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
        }
        this.vibrator = (Vibrator) systemService;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        this.pagerAdapter = new PagerAdapter(supportFragmentManager, this.fragments);
        View viewFindViewById5 = findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.view_pager)");
        this.pager = (AppIntroViewPager) viewFindViewById5;
        View view10 = this.doneButton;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
        }
        view10.setOnClickListener(new NextSlideOnClickListener(true));
        View view11 = this.nextButton;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        view11.setOnClickListener(new NextSlideOnClickListener(false));
        View view12 = this.backButton;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        view12.setOnClickListener(new View.OnClickListener() { // from class: com.github.appintro.AppIntroBase.onCreate.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view13) {
                AppIntroBase.access$getPager$p(AppIntroBase.this).goToPreviousSlide();
            }
        });
        View view13 = this.skipButton;
        if (view13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
        }
        view13.setOnClickListener(new View.OnClickListener() { // from class: com.github.appintro.AppIntroBase.onCreate.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view14) {
                AppIntroBase.this.dispatchVibration();
                AppIntroBase appIntroBase = AppIntroBase.this;
                appIntroBase.onSkipPressed(AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()));
            }
        });
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        appIntroViewPager.setAdapter(pagerAdapter);
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager2.addOnPageChangeListener$appintro_release(new OnPageChangeListener());
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager3.setOnNextPageRequestedListener(this);
        setScrollDurationFactor(1);
    }

    protected void onDonePressed(Fragment fragment) {
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onIllegallyRequestedNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        ActivityResultCaller item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
        if (item instanceof SlidePolicy) {
            SlidePolicy slidePolicy = (SlidePolicy) item;
            if (slidePolicy.isPolicyRespected()) {
                return;
            }
            slidePolicy.onUserIllegallyRequestedNextPage();
        }
    }

    protected void onIntroFinished() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (i3 != 66 && i3 != 96 && i3 != 23) {
            return super.onKeyDown(i3, event);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        boolean zIsLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
        goToNextSlide(zIsLastSlide);
        if (!zIsLastSlide) {
            return false;
        }
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        onDonePressed(pagerAdapter.getItem(appIntroViewPager2.getCurrentItem()));
        return false;
    }

    protected void onNextPressed(Fragment fragment) {
    }

    protected void onNextSlide() {
    }

    protected void onPageSelected(int i3) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.slidesNumber = this.fragments.size();
        initializeIndicator();
        this.retainIsButtonsEnabled = this.isButtonsEnabled;
        if (isRtl$appintro_release()) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
            }
            appIntroViewPager.setCurrentItem(this.fragments.size() - this.savedCurrentItem);
        } else {
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
            }
            appIntroViewPager2.setCurrentItem(this.savedCurrentItem);
        }
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager3.post(new Runnable() { // from class: com.github.appintro.AppIntroBase.onPostCreate.1
            @Override // java.lang.Runnable
            public final void run() {
                if (AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()) == null) {
                    AppIntroBase.this.finish();
                } else {
                    AppIntroBase appIntroBase = AppIntroBase.this;
                    appIntroBase.dispatchSlideChangedCallbacks(null, AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()));
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i3, permissions, grantResults);
        int i4 = 0;
        setSwipeLock(false);
        if (i3 != 1) {
            return;
        }
        ArrayList arrayList = new ArrayList(grantResults.length);
        int length = grantResults.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            arrayList.add(TuplesKt.a(permissions[i6], Integer.valueOf(grantResults[i5])));
            i5++;
            i6++;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            if (((Number) ((Pair) obj).b()).intValue() == -1) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        int i8 = 0;
        while (i8 < size2) {
            Object obj2 = arrayList2.get(i8);
            i8++;
            arrayList3.add((String) ((Pair) obj2).a());
        }
        if (arrayList3.isEmpty()) {
            this.permissionsMap.remove(Integer.valueOf(getCurrentSlideNumber()));
            goToNextSlide$default(this, false, 1, null);
            return;
        }
        int size3 = arrayList3.size();
        while (i4 < size3) {
            Object obj3 = arrayList3.get(i4);
            i4++;
            handleDeniedPermission((String) obj3);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.reCenterCurrentSlide$appintro_release();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_BUNDLE_SLIDES_NUMBER, this.slidesNumber);
        outState.putBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED, this.retainIsButtonsEnabled);
        outState.putBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED, this.isButtonsEnabled);
        outState.putBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED, this.isSkipButtonEnabled);
        outState.putBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED, this.isIndicatorEnabled);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        outState.putInt(ARG_BUNDLE_CURRENT_ITEM, appIntroViewPager.getCurrentItem());
        AppIntroViewPager appIntroViewPager2 = this.pager;
        if (appIntroViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        outState.putBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED, appIntroViewPager2.isFullPagingEnabled());
        outState.putSerializable(ARG_BUNDLE_PERMISSION_MAP, this.permissionsMap);
        outState.putBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED, this.isColorTransitionsEnabled);
    }

    protected void onSkipPressed(Fragment fragment) {
    }

    protected void onSlideChanged(Fragment fragment, Fragment fragment2) {
    }

    protected void onUserDeniedPermission(String permissionName) {
        Intrinsics.checkNotNullParameter(permissionName, "permissionName");
    }

    protected void onUserDisabledPermission(String permissionName) {
        Intrinsics.checkNotNullParameter(permissionName, "permissionName");
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onUserRequestedPermissionsDialog() {
        LogHelper.d(TAG, "Requesting Permissions on " + getCurrentSlideNumber());
        requestPermissions();
    }

    protected final void setButtonsEnabled(boolean z2) {
        this.isButtonsEnabled = z2;
        updateButtonsVisibility();
    }

    protected final void setColorTransitionsEnabled(boolean z2) {
        this.isColorTransitionsEnabled = z2;
    }

    protected final void setCustomTransformer(ViewPager.PageTransformer pageTransformer) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.setPageTransformer(true, pageTransformer);
    }

    protected final void setImmersiveMode() {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
    }

    protected final void setIndicatorColor(int i3, int i4) {
        IndicatorController indicatorController = this.indicatorController;
        if (indicatorController != null) {
            indicatorController.setSelectedIndicatorColor(i3);
        }
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.setUnselectedIndicatorColor(i4);
        }
    }

    protected final void setIndicatorController(IndicatorController indicatorController) {
        this.indicatorController = indicatorController;
    }

    protected final void setIndicatorEnabled(boolean z2) {
        this.isIndicatorEnabled = z2;
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorContainer");
        }
        AppIntroBaseKt.setVisible(viewGroup, z2);
    }

    protected final void setNavBarColor(int i3) {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.setNavigationBarColor(i3);
    }

    protected final void setNavBarColorRes(int i3) {
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.setNavigationBarColor(ContextCompat.getColor(this, i3));
    }

    @Deprecated
    protected final void setNextPageSwipeLock(boolean z2) {
        LogHelper.w$default(TAG, "Calling setNextPageSwipeLock has not effect here. Please switch to setSwipeLock or SlidePolicy", null, 4, null);
    }

    protected final void setProgressIndicator() {
        this.indicatorController = new ProgressIndicatorController(this, null, 0, 6, null);
    }

    protected final void setScrollDurationFactor(int i3) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.setScrollDurationFactor(i3);
    }

    protected final void setSkipButtonEnabled(boolean z2) {
        this.isSkipButtonEnabled = z2;
        updateButtonsVisibility();
    }

    protected final void setStatusBarColor(int i3) {
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        window.setStatusBarColor(i3);
    }

    protected final void setStatusBarColorRes(int i3) {
        setStatusBarColor(ContextCompat.getColor(this, i3));
    }

    protected final void setSwipeLock(boolean z2) {
        if (z2) {
            this.retainIsButtonsEnabled = this.isButtonsEnabled;
            setButtonsEnabled(true);
        } else {
            setButtonsEnabled(this.retainIsButtonsEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.setFullPagingEnabled(!z2);
    }

    protected final void setSystemBackButtonLocked(boolean z2) {
        this.isSystemBackButtonLocked = z2;
    }

    protected final void setTransformer(AppIntroPageTransformerType appIntroTransformer) {
        Intrinsics.checkNotNullParameter(appIntroTransformer, "appIntroTransformer");
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.setAppIntroPageTransformer(appIntroTransformer);
    }

    protected final void setVibrate(boolean z2) {
        this.isVibrate = z2;
    }

    protected final void setVibrateDuration(long j3) {
        this.vibrateDuration = j3;
    }

    protected final void setWizardMode(boolean z2) {
        this.isWizardMode = z2;
        setSkipButtonEnabled(!z2);
        updateButtonsVisibility();
    }

    protected final void showStatusBar(boolean z2) {
        if (z2) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().setFlags(1024, 1024);
        }
    }

    protected final void askForPermissions(String[] permissions, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (i3 > 0) {
            this.permissionsMap.put(Integer.valueOf(i3), new PermissionWrapper(permissions, i3, z2));
            return;
        }
        throw new IllegalStateException(("Invalid Slide Number: " + i3).toString());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.slidesNumber = savedInstanceState.getInt(CbYNFSEGaQj.wlKNiZlgbyDAanN);
        this.retainIsButtonsEnabled = savedInstanceState.getBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED);
        setButtonsEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED));
        setSkipButtonEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED));
        setIndicatorEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED));
        this.savedCurrentItem = savedInstanceState.getInt(ARG_BUNDLE_CURRENT_ITEM);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        appIntroViewPager.setFullPagingEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED));
        HashMap<Integer, PermissionWrapper> map = (HashMap) savedInstanceState.getSerializable(ARG_BUNDLE_PERMISSION_MAP);
        if (map == null) {
            map = new HashMap<>();
        }
        this.permissionsMap = map;
        this.isColorTransitionsEnabled = savedInstanceState.getBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class OnPageChangeListener implements ViewPager.OnPageChangeListener {
        public OnPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f3, int i4) {
            if (!AppIntroBase.this.isColorTransitionsEnabled() || i3 >= AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getCount() - 1) {
                return;
            }
            AppIntroBase.this.performColorTransition(AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(i3), AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(i3 + 1), f3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            IndicatorController indicatorController;
            if (AppIntroBase.this.slidesNumber >= 1 && (indicatorController = AppIntroBase.this.getIndicatorController()) != null) {
                indicatorController.selectPosition(i3);
            }
            AppIntroBase.this.updateButtonsVisibility();
            AppIntroBase.access$getPager$p(AppIntroBase.this).setPermissionSlide(AppIntroBase.this.isPermissionSlide());
            AppIntroBase.this.onPageSelected(i3);
            if (AppIntroBase.this.slidesNumber > 0) {
                if (AppIntroBase.this.currentlySelectedItem == -1) {
                    AppIntroBase appIntroBase = AppIntroBase.this;
                    appIntroBase.dispatchSlideChangedCallbacks(null, AppIntroBase.access$getPagerAdapter$p(appIntroBase).getItem(i3));
                } else {
                    AppIntroBase appIntroBase2 = AppIntroBase.this;
                    appIntroBase2.dispatchSlideChangedCallbacks(AppIntroBase.access$getPagerAdapter$p(appIntroBase2).getItem(AppIntroBase.this.currentlySelectedItem), AppIntroBase.access$getPagerAdapter$p(AppIntroBase.this).getItem(AppIntroBase.access$getPager$p(AppIntroBase.this).getCurrentItem()));
                }
            }
            AppIntroBase.this.currentlySelectedItem = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }
    }
}
