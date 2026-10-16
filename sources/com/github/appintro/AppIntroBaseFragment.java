package com.github.appintro;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.TypefaceContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class AppIntroBaseFragment extends Fragment implements SlideSelectionListener, SlideBackgroundColorHolder {
    private int bgDrawable;
    private int defaultBackgroundColor;
    private int descColor;
    private TypefaceContainer descTypeface;
    private String description;
    private int drawable;
    private final String logTAG = LogHelper.makeLogTag((Class<?>) AppIntroBaseFragment.class);
    private String title;
    private int titleColor;
    private TypefaceContainer titleTypeface;

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public final int getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }

    protected abstract int getLayoutId();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.drawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
            this.title = bundle.getString("title");
            this.description = bundle.getString(AppIntroBaseFragmentKt.ARG_DESC);
            this.titleTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, 0));
            this.descTypeface = new TypefaceContainer(bundle.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE), bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, 0));
            this.defaultBackgroundColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            this.bgDrawable = bundle.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
            this.titleColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR);
            this.descColor = bundle.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments == null || arguments.size() == 0) {
            return;
        }
        this.drawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_DRAWABLE);
        this.title = arguments.getString("title");
        this.description = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC);
        this.bgDrawable = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE);
        String string = arguments.getString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE);
        String string2 = arguments.getString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE);
        int i3 = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES);
        int i4 = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES);
        this.titleTypeface = new TypefaceContainer(string, i3);
        this.descTypeface = new TypefaceContainer(string2, i4);
        this.defaultBackgroundColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_BG_COLOR);
        this.titleColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, 0);
        this.descColor = arguments.getInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(getLayoutId(), viewGroup, false);
        TextView titleText = (TextView) viewInflate.findViewById(R.id.title);
        TextView descriptionText = (TextView) viewInflate.findViewById(R.id.description);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.main);
        Intrinsics.checkNotNullExpressionValue(titleText, "titleText");
        titleText.setText(this.title);
        Intrinsics.checkNotNullExpressionValue(descriptionText, "descriptionText");
        descriptionText.setText(this.description);
        int i3 = this.titleColor;
        if (i3 != 0) {
            titleText.setTextColor(i3);
        }
        int i4 = this.descColor;
        if (i4 != 0) {
            descriptionText.setTextColor(i4);
        }
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            typefaceContainer.applyTo(titleText);
        }
        TypefaceContainer typefaceContainer2 = this.descTypeface;
        if (typefaceContainer2 != null) {
            typefaceContainer2.applyTo(descriptionText);
        }
        imageView.setImageResource(this.drawable);
        int i5 = this.bgDrawable;
        if (i5 != 0) {
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(i5);
                return viewInflate;
            }
        } else if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(this.defaultBackgroundColor);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = getView();
        KeyEvent.Callback callback = view != null ? (ImageView) view.findViewById(R.id.image) : null;
        if (callback instanceof Animatable) {
            ((Animatable) callback).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = getView();
        KeyEvent.Callback callback = view != null ? (ImageView) view.findViewById(R.id.image) : null;
        if (callback instanceof Animatable) {
            ((Animatable) callback).start();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(AppIntroBaseFragmentKt.ARG_DRAWABLE, this.drawable);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.bgDrawable);
        outState.putString("title", this.title);
        outState.putString(AppIntroBaseFragmentKt.ARG_DESC, this.description);
        outState.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.defaultBackgroundColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descColor);
        TypefaceContainer typefaceContainer = this.titleTypeface;
        if (typefaceContainer != null) {
            outState.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, typefaceContainer != null ? typefaceContainer.getTypeFaceUrl() : null);
            TypefaceContainer typefaceContainer2 = this.titleTypeface;
            outState.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, typefaceContainer2 != null ? typefaceContainer2.getTypeFaceResource() : 0);
        }
        TypefaceContainer typefaceContainer3 = this.descTypeface;
        if (typefaceContainer3 != null) {
            outState.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, typefaceContainer3 != null ? typefaceContainer3.getTypeFaceUrl() : null);
            TypefaceContainer typefaceContainer4 = this.descTypeface;
            outState.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, typefaceContainer4 != null ? typefaceContainer4.getTypeFaceResource() : 0);
        }
        super.onSaveInstanceState(outState);
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
        LogHelper.d(this.logTAG, "Slide " + this.title + " has been deselected.");
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        LogHelper.d(this.logTAG, "Slide " + this.title + " has been selected.");
    }

    @Override // com.github.appintro.SlideBackgroundColorHolder
    public void setBackgroundColor(int i3) {
        ConstraintLayout constraintLayout;
        View view = getView();
        if (view == null || (constraintLayout = (ConstraintLayout) view.findViewById(R.id.main)) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(i3);
    }
}
