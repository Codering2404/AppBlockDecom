package dev.doubledot.doki.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import dev.doubledot.doki.R;
import dev.doubledot.doki.extensions.ActivityKt;
import dev.doubledot.doki.extensions.DrawableKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
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
public class DokiRatingView extends LinearLayout {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.i(new PropertyReference1Impl(Reflection.b(DokiRatingView.class), "iconA", "getIconA()Landroidx/appcompat/widget/AppCompatImageView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiRatingView.class), bfIdKSjLOVjG.UVctDrvK, "getIconB()Landroidx/appcompat/widget/AppCompatImageView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiRatingView.class), "iconC", "getIconC()Landroidx/appcompat/widget/AppCompatImageView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiRatingView.class), "iconD", "getIconD()Landroidx/appcompat/widget/AppCompatImageView;")), Reflection.i(new PropertyReference1Impl(Reflection.b(DokiRatingView.class), "iconE", "getIconE()Landroidx/appcompat/widget/AppCompatImageView;"))};
    private int activeIconsColor;
    private Drawable activeIconsDrawable;
    private final Lazy iconA$delegate;
    private final Lazy iconB$delegate;
    private final Lazy iconC$delegate;
    private final Lazy iconD$delegate;
    private final Lazy iconE$delegate;
    private int inactiveIconsColor;
    private Drawable inactiveIconsDrawable;
    private int rating;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Style {
        THUMB(R.drawable.ic_thumb, R.drawable.ic_thumb_outline),
        FACE(R.drawable.ic_angry, R.drawable.ic_angry_outline),
        POOP(R.drawable.ic_poop, R.drawable.ic_poop_outline),
        TRASH(R.drawable.ic_trash, R.drawable.ic_trash_outline);

        public static final Companion Companion = new Companion(null);
        private final int activeResId;
        private final int inactiveResId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final Style getFromId(int i3) {
                return i3 != 1 ? i3 != 2 ? i3 != 3 ? Style.THUMB : Style.TRASH : Style.POOP : Style.FACE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        Style(int i3, int i4) {
            this.activeResId = i3;
            this.inactiveResId = i4;
        }

        public final int getActiveResId() {
            return this.activeResId;
        }

        public final int getInactiveResId() {
            return this.inactiveResId;
        }
    }

    public DokiRatingView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final AppCompatImageView getIconA() {
        Lazy lazy = this.iconA$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AppCompatImageView) lazy.getValue();
    }

    private final AppCompatImageView getIconB() {
        Lazy lazy = this.iconB$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (AppCompatImageView) lazy.getValue();
    }

    private final AppCompatImageView getIconC() {
        Lazy lazy = this.iconC$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (AppCompatImageView) lazy.getValue();
    }

    private final AppCompatImageView getIconD() {
        Lazy lazy = this.iconD$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (AppCompatImageView) lazy.getValue();
    }

    private final AppCompatImageView getIconE() {
        Lazy lazy = this.iconE$delegate;
        KProperty kProperty = $$delegatedProperties[4];
        return (AppCompatImageView) lazy.getValue();
    }

    private final void updateIcons() {
        Drawable drawableTint;
        Drawable drawableTint2;
        Drawable drawableTint3;
        Drawable drawableTint4;
        AppCompatImageView iconA = getIconA();
        Drawable drawableTint5 = null;
        if (iconA != null) {
            int i3 = this.rating;
            Drawable drawable = i3 > 0 ? this.activeIconsDrawable : this.inactiveIconsDrawable;
            if (drawable != null) {
                drawableTint4 = DrawableKt.tint(drawable, i3 > 0 ? this.activeIconsColor : this.inactiveIconsColor);
            } else {
                drawableTint4 = null;
            }
            iconA.setImageDrawable(drawableTint4);
        }
        AppCompatImageView iconB = getIconB();
        if (iconB != null) {
            int i4 = this.rating;
            Drawable drawable2 = i4 > 1 ? this.activeIconsDrawable : this.inactiveIconsDrawable;
            if (drawable2 != null) {
                drawableTint3 = DrawableKt.tint(drawable2, i4 > 1 ? this.activeIconsColor : this.inactiveIconsColor);
            } else {
                drawableTint3 = null;
            }
            iconB.setImageDrawable(drawableTint3);
        }
        AppCompatImageView iconC = getIconC();
        if (iconC != null) {
            int i5 = this.rating;
            Drawable drawable3 = i5 > 2 ? this.activeIconsDrawable : this.inactiveIconsDrawable;
            if (drawable3 != null) {
                drawableTint2 = DrawableKt.tint(drawable3, i5 > 2 ? this.activeIconsColor : this.inactiveIconsColor);
            } else {
                drawableTint2 = null;
            }
            iconC.setImageDrawable(drawableTint2);
        }
        AppCompatImageView iconD = getIconD();
        if (iconD != null) {
            int i6 = this.rating;
            Drawable drawable4 = i6 > 3 ? this.activeIconsDrawable : this.inactiveIconsDrawable;
            if (drawable4 != null) {
                drawableTint = DrawableKt.tint(drawable4, i6 > 3 ? this.activeIconsColor : this.inactiveIconsColor);
            } else {
                drawableTint = null;
            }
            iconD.setImageDrawable(drawableTint);
        }
        AppCompatImageView iconE = getIconE();
        if (iconE != null) {
            int i7 = this.rating;
            Drawable drawable5 = i7 > 4 ? this.activeIconsDrawable : this.inactiveIconsDrawable;
            if (drawable5 != null) {
                drawableTint5 = DrawableKt.tint(drawable5, i7 > 4 ? this.activeIconsColor : this.inactiveIconsColor);
            }
            iconE.setImageDrawable(drawableTint5);
        }
    }

    public final int getActiveIconsColor() {
        return this.activeIconsColor;
    }

    public final Drawable getActiveIconsDrawable() {
        return this.activeIconsDrawable;
    }

    public final int getInactiveIconsColor() {
        return this.inactiveIconsColor;
    }

    public final Drawable getInactiveIconsDrawable() {
        return this.inactiveIconsDrawable;
    }

    public final int getRating() {
        return this.rating;
    }

    public final void setActiveIconRes(int i3) {
        Drawable drawable;
        try {
            drawable = ContextCompat.getDrawable(getContext(), i3);
        } catch (Exception unused) {
            drawable = null;
        }
        setActiveIconsDrawable(drawable);
    }

    public final void setActiveIconsColor(int i3) {
        this.activeIconsColor = i3;
        updateIcons();
    }

    public final void setActiveIconsColorRes(int i3) {
        int color;
        try {
            color = ContextCompat.getColor(getContext(), i3);
        } catch (Exception unused) {
            color = -16777216;
        }
        setActiveIconsColor(color);
    }

    public final void setActiveIconsDrawable(Drawable drawable) {
        this.activeIconsDrawable = drawable;
        updateIcons();
    }

    public final void setIconsStyle(Style style) {
        Intrinsics.checkParameterIsNotNull(style, "style");
        setActiveIconRes(style.getActiveResId());
        setInactiveIconRes(style.getInactiveResId());
    }

    public final void setInactiveIconRes(int i3) {
        Drawable drawable;
        try {
            drawable = ContextCompat.getDrawable(getContext(), i3);
        } catch (Exception unused) {
            drawable = null;
        }
        setInactiveIconsDrawable(drawable);
    }

    public final void setInactiveIconsColor(int i3) {
        this.inactiveIconsColor = i3;
        updateIcons();
    }

    public final void setInactiveIconsColorRes(int i3) {
        int color;
        try {
            color = ContextCompat.getColor(getContext(), i3);
        } catch (Exception unused) {
            color = -16777216;
        }
        setInactiveIconsColor(color);
    }

    public final void setInactiveIconsDrawable(Drawable drawable) {
        this.inactiveIconsDrawable = drawable;
        updateIcons();
    }

    public final void setRating(int i3) {
        this.rating = i3;
        updateIcons();
    }

    public DokiRatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DokiRatingView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DokiRatingView(Context context, AttributeSet attributeSet, int i3) {
        Drawable drawable;
        super(context, attributeSet, i3);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.iconA$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.rating_icon_a));
        this.iconB$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.rating_icon_b));
        this.iconC$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.rating_icon_c));
        this.iconD$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.rating_icon_d));
        this.iconE$delegate = LazyKt.b(new ActivityKt.AnonymousClass3(this, R.id.rating_icon_e));
        this.activeIconsColor = -16777216;
        this.inactiveIconsColor = -16777216;
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            ((LayoutInflater) systemService).inflate(R.layout.doki_view_rating, (ViewGroup) this, true);
            Drawable drawable2 = null;
            try {
                drawable = ContextCompat.getDrawable(context, R.drawable.ic_thumb);
            } catch (Exception unused) {
                drawable = null;
            }
            setActiveIconsDrawable(drawable);
            try {
                drawable2 = ContextCompat.getDrawable(context, R.drawable.ic_thumb_outline);
            } catch (Exception unused2) {
            }
            setInactiveIconsDrawable(drawable2);
            updateIcons();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
