package dev.doubledot.doki.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import dev.doubledot.doki.R;
import dev.doubledot.doki.api.extensions.ConstantsKt;
import dev.doubledot.doki.api.models.DokiManufacturer;
import dev.doubledot.doki.api.tasks.DokiApi;
import dev.doubledot.doki.api.tasks.DokiApiCallback;
import dev.doubledot.doki.extensions.ActivityKt;
import dev.doubledot.doki.extensions.ContextKt;
import dev.doubledot.doki.extensions.ViewKt;
import dev.doubledot.doki.models.Device;
import dev.doubledot.doki.views.DokiRatingView;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

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
public final class DokiContentView extends LinearLayout {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "api", "getApi()Ldev/doubledot/doki/api/tasks/DokiApi;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "appBarLayout", "getAppBarLayout()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "footerLayout", "getFooterLayout()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "headerBackground", "getHeaderBackground()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "deviceManufacturerHeader", "getDeviceManufacturerHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "deviceManufacturer", "getDeviceManufacturer()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "deviceModelHeader", "getDeviceModelHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "deviceModel", "getDeviceModel()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "deviceAndroidVersionHeader", "getDeviceAndroidVersionHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "deviceAndroidVersion", "getDeviceAndroidVersion()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "manufacturerRatingHeader", "getManufacturerRatingHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "manufacturerRating", "getManufacturerRating()Ldev/doubledot/doki/views/DokiRatingView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentLoadingView", "getContentLoadingView()Landroid/widget/ProgressBar;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentScrollView", "getContentScrollView()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentExplanationHeader", "getContentExplanationHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentExplanation", "getContentExplanation()Ldev/doubledot/doki/views/DokiHtmlTextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentSolutionHeader", "getContentSolutionHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentSolution", "getContentSolution()Ldev/doubledot/doki/views/DokiHtmlTextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentDeveloperSolutionHeader", "getContentDeveloperSolutionHeader()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentDeveloperSolution", FptyjHFU.nqSB)), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "contentAttribution", "getContentAttribution()Ldev/doubledot/doki/views/DokiHtmlTextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "buttonContainer", "getButtonContainer()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "closeBtn", "getCloseBtn()Landroid/widget/TextView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "divider1", "getDivider1()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "divider2", "getDivider2()Landroid/view/View;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiContentView.class), "divider3", "getDivider3()Landroid/view/View;"))};
    private int activeIconsColor;
    private Drawable activeIconsDrawable;
    private final Lazy api$delegate;
    private final Lazy appBarLayout$delegate;
    private final Lazy buttonContainer$delegate;
    private int buttonsTextColor;
    private final Lazy closeBtn$delegate;
    private final Lazy contentAttribution$delegate;
    private final Lazy contentDeveloperSolution$delegate;
    private final Lazy contentDeveloperSolutionHeader$delegate;
    private final Lazy contentExplanation$delegate;
    private final Lazy contentExplanationHeader$delegate;
    private final Lazy contentLoadingView$delegate;
    private final Lazy contentScrollView$delegate;
    private final Lazy contentSolution$delegate;
    private final Lazy contentSolutionHeader$delegate;
    private String devSolutionMessage;
    private Device device;
    private final Lazy deviceAndroidVersion$delegate;
    private final Lazy deviceAndroidVersionHeader$delegate;
    private final Lazy deviceManufacturer$delegate;
    private final Lazy deviceManufacturerHeader$delegate;
    private final Lazy deviceModel$delegate;
    private final Lazy deviceModelHeader$delegate;
    private final Lazy divider1$delegate;
    private final Lazy divider2$delegate;
    private final Lazy divider3$delegate;
    private int dividerColor;
    private String explanationTitleText;
    private final Lazy footerLayout$delegate;
    private final Lazy headerBackground$delegate;
    private int headerBackgroundColor;
    private DokiRatingView.Style iconsStyle;
    private int inactiveIconsColor;
    private Drawable inactiveIconsDrawable;
    private float lineHeight;
    private float lineSeparation;
    private DokiManufacturer manufacturer;
    private final Lazy manufacturerRating$delegate;
    private final Lazy manufacturerRatingHeader$delegate;
    private int primaryTextColor;
    private int rootBackgroundColor;
    private int secondaryTextColor;
    private String solutionTitleText;

    public DokiContentView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final DokiApi getApi() {
        Lazy lazy = this.api$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (DokiApi) lazy.getValue();
    }

    private final View getAppBarLayout() {
        Lazy lazy = this.appBarLayout$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (View) lazy.getValue();
    }

    private final View getButtonContainer() {
        Lazy lazy = this.buttonContainer$delegate;
        KProperty kProperty = $$delegatedProperties[21];
        return (View) lazy.getValue();
    }

    private final TextView getCloseBtn() {
        Lazy lazy = this.closeBtn$delegate;
        KProperty kProperty = $$delegatedProperties[22];
        return (TextView) lazy.getValue();
    }

    private final DokiHtmlTextView getContentAttribution() {
        Lazy lazy = this.contentAttribution$delegate;
        KProperty kProperty = $$delegatedProperties[20];
        return (DokiHtmlTextView) lazy.getValue();
    }

    private final DokiHtmlTextView getContentDeveloperSolution() {
        Lazy lazy = this.contentDeveloperSolution$delegate;
        KProperty kProperty = $$delegatedProperties[19];
        return (DokiHtmlTextView) lazy.getValue();
    }

    private final TextView getContentDeveloperSolutionHeader() {
        Lazy lazy = this.contentDeveloperSolutionHeader$delegate;
        KProperty kProperty = $$delegatedProperties[18];
        return (TextView) lazy.getValue();
    }

    private final DokiHtmlTextView getContentExplanation() {
        Lazy lazy = this.contentExplanation$delegate;
        KProperty kProperty = $$delegatedProperties[15];
        return (DokiHtmlTextView) lazy.getValue();
    }

    private final TextView getContentExplanationHeader() {
        Lazy lazy = this.contentExplanationHeader$delegate;
        KProperty kProperty = $$delegatedProperties[14];
        return (TextView) lazy.getValue();
    }

    private final ProgressBar getContentLoadingView() {
        Lazy lazy = this.contentLoadingView$delegate;
        KProperty kProperty = $$delegatedProperties[12];
        return (ProgressBar) lazy.getValue();
    }

    private final View getContentScrollView() {
        Lazy lazy = this.contentScrollView$delegate;
        KProperty kProperty = $$delegatedProperties[13];
        return (View) lazy.getValue();
    }

    private final DokiHtmlTextView getContentSolution() {
        Lazy lazy = this.contentSolution$delegate;
        KProperty kProperty = $$delegatedProperties[17];
        return (DokiHtmlTextView) lazy.getValue();
    }

    private final TextView getContentSolutionHeader() {
        Lazy lazy = this.contentSolutionHeader$delegate;
        KProperty kProperty = $$delegatedProperties[16];
        return (TextView) lazy.getValue();
    }

    private final TextView getDeviceAndroidVersion() {
        Lazy lazy = this.deviceAndroidVersion$delegate;
        KProperty kProperty = $$delegatedProperties[9];
        return (TextView) lazy.getValue();
    }

    private final TextView getDeviceAndroidVersionHeader() {
        Lazy lazy = this.deviceAndroidVersionHeader$delegate;
        KProperty kProperty = $$delegatedProperties[8];
        return (TextView) lazy.getValue();
    }

    private final TextView getDeviceManufacturer() {
        Lazy lazy = this.deviceManufacturer$delegate;
        KProperty kProperty = $$delegatedProperties[5];
        return (TextView) lazy.getValue();
    }

    private final TextView getDeviceManufacturerHeader() {
        Lazy lazy = this.deviceManufacturerHeader$delegate;
        KProperty kProperty = $$delegatedProperties[4];
        return (TextView) lazy.getValue();
    }

    private final TextView getDeviceModel() {
        Lazy lazy = this.deviceModel$delegate;
        KProperty kProperty = $$delegatedProperties[7];
        return (TextView) lazy.getValue();
    }

    private final TextView getDeviceModelHeader() {
        Lazy lazy = this.deviceModelHeader$delegate;
        KProperty kProperty = $$delegatedProperties[6];
        return (TextView) lazy.getValue();
    }

    private final View getDivider1() {
        Lazy lazy = this.divider1$delegate;
        KProperty kProperty = $$delegatedProperties[23];
        return (View) lazy.getValue();
    }

    private final View getDivider2() {
        Lazy lazy = this.divider2$delegate;
        KProperty kProperty = $$delegatedProperties[24];
        return (View) lazy.getValue();
    }

    private final View getDivider3() {
        Lazy lazy = this.divider3$delegate;
        KProperty kProperty = $$delegatedProperties[25];
        return (View) lazy.getValue();
    }

    private final View getFooterLayout() {
        Lazy lazy = this.footerLayout$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (View) lazy.getValue();
    }

    private final View getHeaderBackground() {
        Lazy lazy = this.headerBackground$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (View) lazy.getValue();
    }

    private final DokiRatingView getManufacturerRating() {
        Lazy lazy = this.manufacturerRating$delegate;
        KProperty kProperty = $$delegatedProperties[11];
        return (DokiRatingView) lazy.getValue();
    }

    private final TextView getManufacturerRatingHeader() {
        Lazy lazy = this.manufacturerRatingHeader$delegate;
        KProperty kProperty = $$delegatedProperties[10];
        return (TextView) lazy.getValue();
    }

    private final DokiRatingView.Style getStyledIconsStyle(TypedArray typedArray) {
        int i3 = -1;
        if (typedArray != null) {
            try {
                i3 = typedArray.getInt(R.styleable.DokiContentView_dokiIconsStyle, -1);
            } catch (Exception unused) {
            }
        }
        if (i3 >= 0) {
            return DokiRatingView.Style.Companion.getFromId(i3);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb A[Catch: Exception -> 0x00ff, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ff, blocks: (B:69:0x00f1, B:72:0x00fb), top: B:97:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011c A[Catch: Exception -> 0x0120, TRY_LEAVE, TryCatch #0 {Exception -> 0x0120, blocks: (B:79:0x0112, B:82:0x011c), top: B:95:0x0112 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initFromAttrs(android.util.AttributeSet r6) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.doubledot.doki.views.DokiContentView.initFromAttrs(android.util.AttributeSet):void");
    }

    public static /* synthetic */ DokiApi loadContent$default(DokiContentView dokiContentView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = ConstantsKt.getDONT_KILL_MY_APP_DEFAULT_MANUFACTURER();
        }
        return dokiContentView.loadContent(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCloseListener$default(DokiContentView dokiContentView, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = new Function1<View, Unit>() { // from class: dev.doubledot.doki.views.DokiContentView.setOnCloseListener.1
                public final void invoke(View view) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((View) obj2);
                    return Unit.f139807a;
                }
            };
        }
        dokiContentView.setOnCloseListener(function1);
    }

    private final void setRootBackgroundColor(int i3) {
        View appBarLayout = getAppBarLayout();
        if (appBarLayout != null) {
            appBarLayout.setBackgroundColor(i3);
        }
        View footerLayout = getFooterLayout();
        if (footerLayout != null) {
            footerLayout.setBackgroundColor(i3);
        }
        this.rootBackgroundColor = i3;
    }

    public final int getActiveIconsColor() {
        return this.activeIconsColor;
    }

    public final Drawable getActiveIconsDrawable() {
        return this.activeIconsDrawable;
    }

    public final int getButtonsTextColor() {
        return this.buttonsTextColor;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final int getDividerColor() {
        return this.dividerColor;
    }

    public final String getExplanationTitleText() {
        return this.explanationTitleText;
    }

    public final int getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    public final DokiRatingView.Style getIconsStyle() {
        return this.iconsStyle;
    }

    public final int getInactiveIconsColor() {
        return this.inactiveIconsColor;
    }

    public final Drawable getInactiveIconsDrawable() {
        return this.inactiveIconsDrawable;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final float getLineSeparation() {
        return this.lineSeparation;
    }

    public final DokiManufacturer getManufacturer() {
        return this.manufacturer;
    }

    public final int getPrimaryTextColor() {
        return this.primaryTextColor;
    }

    public final int getSecondaryTextColor() {
        return this.secondaryTextColor;
    }

    public final String getSolutionTitleText() {
        return this.solutionTitleText;
    }

    public final DokiApi loadContent(String manufacturerId) {
        Intrinsics.checkParameterIsNotNull(manufacturerId, "manufacturerId");
        getApi().setCallback(new DokiApiCallback() { // from class: dev.doubledot.doki.views.DokiContentView.loadContent.1
            @Override // dev.doubledot.doki.api.tasks.DokiApiCallback
            public Unit onError(Throwable th) {
                return DokiApiCallback.DefaultImpls.onError(this, th);
            }

            @Override // dev.doubledot.doki.api.tasks.DokiApiCallback
            public void onStart() {
                DokiApiCallback.DefaultImpls.onStart(this);
            }

            @Override // dev.doubledot.doki.api.tasks.DokiApiCallback
            public void onSuccess(DokiManufacturer dokiManufacturer) {
                DokiContentView.this.setManufacturer(dokiManufacturer);
            }
        });
        getApi().getManufacturer(manufacturerId);
        return getApi();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getApi().cancel();
    }

    public final void setActiveIconsColor(int i3) {
        DokiRatingView manufacturerRating = getManufacturerRating();
        if (manufacturerRating != null) {
            manufacturerRating.setActiveIconsColor(i3);
        }
        this.activeIconsColor = i3;
    }

    public final void setActiveIconsDrawable(Drawable drawable) {
        DokiRatingView manufacturerRating = getManufacturerRating();
        if (manufacturerRating != null) {
            manufacturerRating.setActiveIconsDrawable(drawable);
        }
        this.activeIconsDrawable = drawable;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        setRootBackgroundColor(i3);
    }

    public final void setButtonsTextColor(int i3) {
        TextView closeBtn = getCloseBtn();
        if (closeBtn != null) {
            closeBtn.setTextColor(i3);
        }
        DokiHtmlTextView contentExplanation = getContentExplanation();
        if (contentExplanation != null) {
            contentExplanation.setLinkHighlightColor(i3);
        }
        DokiHtmlTextView contentSolution = getContentSolution();
        if (contentSolution != null) {
            contentSolution.setLinkHighlightColor(i3);
        }
        DokiHtmlTextView contentDeveloperSolution = getContentDeveloperSolution();
        if (contentDeveloperSolution != null) {
            contentDeveloperSolution.setLinkHighlightColor(i3);
        }
        DokiHtmlTextView contentAttribution = getContentAttribution();
        if (contentAttribution != null) {
            contentAttribution.setLinkHighlightColor(i3);
        }
        this.buttonsTextColor = i3;
    }

    public final void setButtonsVisibility(boolean z2) {
        View buttonContainer = getButtonContainer();
        if (buttonContainer != null) {
            ViewKt.visibleIf(buttonContainer, z2);
        }
        View divider2 = getDivider2();
        if (divider2 != null) {
            ViewKt.visibleIf(divider2, z2);
        }
    }

    public final void setDevice(Device device) {
        this.device = device;
        if (device != null) {
            TextView deviceManufacturer = getDeviceManufacturer();
            if (deviceManufacturer != null) {
                deviceManufacturer.setText(device.getManufacturer());
            }
            TextView deviceModel = getDeviceModel();
            if (deviceModel != null) {
                deviceModel.setText(device.getModel());
            }
            TextView deviceAndroidVersion = getDeviceAndroidVersion();
            if (deviceAndroidVersion != null) {
                deviceAndroidVersion.setText(device.getAndroidVersion());
            }
        }
    }

    public final void setDividerColor(int i3) {
        View divider1 = getDivider1();
        if (divider1 != null) {
            divider1.setBackgroundColor(i3);
        }
        View divider2 = getDivider2();
        if (divider2 != null) {
            divider2.setBackgroundColor(i3);
        }
        View divider3 = getDivider3();
        if (divider3 != null) {
            divider3.setBackgroundColor(i3);
        }
        this.dividerColor = i3;
    }

    public final void setExplanationTitleText(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.explanationTitleText = str;
    }

    public final void setHeaderBackgroundColor(int i3) {
        View headerBackground = getHeaderBackground();
        if (headerBackground != null) {
            headerBackground.setBackgroundColor(i3);
        }
        this.headerBackgroundColor = i3;
    }

    public final void setIconsStyle(DokiRatingView.Style style) {
        Drawable drawable;
        if (style != null) {
            Drawable drawable2 = null;
            try {
                drawable = ContextCompat.getDrawable(getContext(), style.getActiveResId());
            } catch (Exception unused) {
                drawable = null;
            }
            setActiveIconsDrawable(drawable);
            try {
                drawable2 = ContextCompat.getDrawable(getContext(), style.getInactiveResId());
            } catch (Exception unused2) {
            }
            setInactiveIconsDrawable(drawable2);
        }
        this.iconsStyle = style;
    }

    public final void setInactiveIconsColor(int i3) {
        DokiRatingView manufacturerRating = getManufacturerRating();
        if (manufacturerRating != null) {
            manufacturerRating.setInactiveIconsColor(i3);
        }
        this.inactiveIconsColor = i3;
    }

    public final void setInactiveIconsDrawable(Drawable drawable) {
        DokiRatingView manufacturerRating = getManufacturerRating();
        if (manufacturerRating != null) {
            manufacturerRating.setInactiveIconsDrawable(drawable);
        }
        this.inactiveIconsDrawable = drawable;
    }

    public final void setLineHeight(float f3) {
        DokiHtmlTextView contentExplanation = getContentExplanation();
        if (contentExplanation != null) {
            contentExplanation.setLineSpacing(this.lineSeparation, f3);
        }
        DokiHtmlTextView contentSolution = getContentSolution();
        if (contentSolution != null) {
            contentSolution.setLineSpacing(this.lineSeparation, f3);
        }
        DokiHtmlTextView contentDeveloperSolution = getContentDeveloperSolution();
        if (contentDeveloperSolution != null) {
            contentDeveloperSolution.setLineSpacing(this.lineSeparation, f3);
        }
        this.lineHeight = f3;
    }

    public final void setLineSeparation(float f3) {
        this.lineSeparation = f3;
        setLineHeight(this.lineHeight);
    }

    public final void setManufacturer(DokiManufacturer dokiManufacturer) {
        this.manufacturer = dokiManufacturer;
        if (dokiManufacturer != null) {
            DokiRatingView manufacturerRating = getManufacturerRating();
            if (manufacturerRating != null) {
                manufacturerRating.setRating(dokiManufacturer.getAward());
            }
            DokiRatingView manufacturerRating2 = getManufacturerRating();
            if (manufacturerRating2 != null) {
            }
            TextView manufacturerRatingHeader = getManufacturerRatingHeader();
            if (manufacturerRatingHeader != null) {
            }
            DokiHtmlTextView contentExplanation = getContentExplanation();
            if (contentExplanation != null) {
                contentExplanation.setHtmlText(dokiManufacturer.getExplanation());
            }
            DokiHtmlTextView contentSolution = getContentSolution();
            if (contentSolution != null) {
                contentSolution.setHtmlText(dokiManufacturer.getUser_solution());
            }
            String dev_solution = dokiManufacturer.getDev_solution();
            if (dev_solution == null || dev_solution.length() == 0) {
                TextView contentDeveloperSolutionHeader = getContentDeveloperSolutionHeader();
                if (contentDeveloperSolutionHeader != null) {
                    contentDeveloperSolutionHeader.setVisibility(8);
                }
                DokiHtmlTextView contentDeveloperSolution = getContentDeveloperSolution();
                if (contentDeveloperSolution != null) {
                    contentDeveloperSolution.setVisibility(8);
                }
            } else {
                TextView contentDeveloperSolutionHeader2 = getContentDeveloperSolutionHeader();
                if (contentDeveloperSolutionHeader2 != null) {
                    contentDeveloperSolutionHeader2.setVisibility(0);
                }
                DokiHtmlTextView contentDeveloperSolution2 = getContentDeveloperSolution();
                if (contentDeveloperSolution2 != null) {
                    contentDeveloperSolution2.setVisibility(0);
                }
                DokiHtmlTextView contentDeveloperSolution3 = getContentDeveloperSolution();
                if (contentDeveloperSolution3 != null) {
                    contentDeveloperSolution3.setHtmlText(dokiManufacturer.getDev_solution());
                }
            }
            ProgressBar contentLoadingView = getContentLoadingView();
            if (contentLoadingView != null) {
            }
            View contentScrollView = getContentScrollView();
            if (contentScrollView != null) {
                ViewKt.visible(contentScrollView);
            }
        }
    }

    public final void setOnCloseListener(final Function1<? super View, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        TextView closeBtn = getCloseBtn();
        if (closeBtn != null) {
            closeBtn.setOnClickListener(new View.OnClickListener() { // from class: dev.doubledot.doki.views.DokiContentView.setOnCloseListener.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    listener.invoke(view);
                }
            });
        }
    }

    public final void setPrimaryTextColor(int i3) {
        TextView deviceManufacturer = getDeviceManufacturer();
        if (deviceManufacturer != null) {
            deviceManufacturer.setTextColor(i3);
        }
        TextView deviceModel = getDeviceModel();
        if (deviceModel != null) {
            deviceModel.setTextColor(i3);
        }
        TextView deviceAndroidVersion = getDeviceAndroidVersion();
        if (deviceAndroidVersion != null) {
            deviceAndroidVersion.setTextColor(i3);
        }
        TextView contentExplanationHeader = getContentExplanationHeader();
        if (contentExplanationHeader != null) {
            contentExplanationHeader.setTextColor(i3);
        }
        TextView contentSolutionHeader = getContentSolutionHeader();
        if (contentSolutionHeader != null) {
            contentSolutionHeader.setTextColor(i3);
        }
        TextView contentDeveloperSolutionHeader = getContentDeveloperSolutionHeader();
        if (contentDeveloperSolutionHeader != null) {
            contentDeveloperSolutionHeader.setTextColor(i3);
        }
        this.primaryTextColor = i3;
    }

    public final void setSecondaryTextColor(int i3) {
        TextView deviceManufacturerHeader = getDeviceManufacturerHeader();
        if (deviceManufacturerHeader != null) {
            deviceManufacturerHeader.setTextColor(i3);
        }
        TextView deviceModelHeader = getDeviceModelHeader();
        if (deviceModelHeader != null) {
            deviceModelHeader.setTextColor(i3);
        }
        TextView deviceAndroidVersionHeader = getDeviceAndroidVersionHeader();
        if (deviceAndroidVersionHeader != null) {
            deviceAndroidVersionHeader.setTextColor(i3);
        }
        TextView manufacturerRatingHeader = getManufacturerRatingHeader();
        if (manufacturerRatingHeader != null) {
            manufacturerRatingHeader.setTextColor(i3);
        }
        DokiHtmlTextView contentExplanation = getContentExplanation();
        if (contentExplanation != null) {
            contentExplanation.setTextColor(i3);
        }
        DokiHtmlTextView contentSolution = getContentSolution();
        if (contentSolution != null) {
            contentSolution.setTextColor(i3);
        }
        DokiHtmlTextView contentDeveloperSolution = getContentDeveloperSolution();
        if (contentDeveloperSolution != null) {
            contentDeveloperSolution.setTextColor(i3);
        }
        DokiHtmlTextView contentAttribution = getContentAttribution();
        if (contentAttribution != null) {
            contentAttribution.setTextColor(i3);
        }
        this.secondaryTextColor = i3;
    }

    public final void setSolutionTitleText(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.solutionTitleText = str;
    }

    public DokiContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DokiContentView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DokiContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.api$delegate = LazyKt.b(new Function0<DokiApi>() { // from class: dev.doubledot.doki.views.DokiContentView$api$2
            @Override // kotlin.jvm.functions.Function0
            public final DokiApi invoke() {
                return new DokiApi();
            }
        });
        this.appBarLayout$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.appbar));
        this.footerLayout$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.footer));
        this.headerBackground$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.headerBackground));
        this.deviceManufacturerHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.deviceManufacturerHeader));
        this.deviceManufacturer$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.deviceManufacturer));
        this.deviceModelHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.deviceModelHeader));
        this.deviceModel$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.deviceModel));
        this.deviceAndroidVersionHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.deviceAndroidVersionHeader));
        this.deviceAndroidVersion$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.deviceAndroidVersion));
        this.manufacturerRatingHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.manufacturerRatingHeader));
        this.manufacturerRating$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.manufacturerRating));
        this.contentLoadingView$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentLoadingView));
        this.contentScrollView$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentScrollView));
        this.contentExplanationHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentExplanationHeader));
        this.contentExplanation$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentExplanation));
        this.contentSolutionHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentSolutionHeader));
        this.contentSolution$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentSolution));
        this.contentDeveloperSolutionHeader$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentDeveloperSolutionHeader));
        this.contentDeveloperSolution$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentDeveloperSolution));
        this.contentAttribution$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.contentAttribution));
        this.buttonContainer$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.buttonContainer));
        this.closeBtn$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.buttonClose));
        this.divider1$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.divider1));
        this.divider2$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.divider2));
        this.divider3$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.divider3));
        this.primaryTextColor = -16777216;
        this.secondaryTextColor = -16777216;
        this.buttonsTextColor = ContextKt.extractColor(context, new int[]{R.attr.colorAccent});
        this.dividerColor = Color.parseColor("#1F000000");
        this.iconsStyle = DokiRatingView.Style.THUMB;
        this.activeIconsColor = -16777216;
        this.inactiveIconsColor = -16777216;
        this.lineHeight = 1.0f;
        this.devSolutionMessage = "";
        this.explanationTitleText = "";
        this.solutionTitleText = "";
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            ((LayoutInflater) systemService).inflate(R.layout.doki_view_content, (ViewGroup) this, true);
            setRootBackgroundColor(-1);
            DokiHtmlTextView contentAttribution = getContentAttribution();
            if (contentAttribution != null) {
                contentAttribution.setHtmlText(context.getString(R.string.doki_content_attribution));
            }
            initFromAttrs(attributeSet);
            setDevice(new Device(null, null, null, 7, null));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
